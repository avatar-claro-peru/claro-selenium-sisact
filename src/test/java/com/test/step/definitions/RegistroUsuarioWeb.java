package com.test.step.definitions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.test.step.logic.Registration;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;


public class RegistroUsuarioWeb {

	public WebDriver driver;
	public RegistroUsuarioWeb() {
		this.driver = Hook.getDriver();
	}	
	
	
	@And("^ingresa a la seccion registro$")
	public void ingresa_a_la_seccion_registro() throws Throwable {
		
		Registration.seccionLogin();
	    Registration.takeScreenshot("SeccionLogin");
	    
	    WebElement redirectRegistro = driver.findElement(By.id("Header_GlobalLogin_WC_AccountDisplay_links_3"));
	    
	    redirectRegistro.click();
	    
	    Thread.sleep(2000);
	    
	}
	
	
	@Then("^rellenar los datos para el registro datos personales$")
	public void rellenar_los_datos_para_el_registro_datos_personales(DataTable arg1) throws Throwable {

		List<WebElement>  li = (List<WebElement>) driver.findElements(By.xpath("//*[@class='content-infoCompra separa-small']//*[@class='row relative']//*[@class='medium-7 small-12 columns form-styles']//*[@class='row']//ul//li"));
		
	    Registration.rellenarDP(arg1,li);
	    
	}
	
	@Then("^rellenar los datos de la cuenta$")
	public void rellenar_los_datos_de_la_cuenta(DataTable arg1) throws Throwable {
	    
		List<WebElement>  li = (List<WebElement>) driver.findElements(By.xpath("//*[@class='content-infoCompra separa-small no-pt']//*[@class='row']//*[@class='medium-7 small-12 columns form-styles']//*[@class='row']//ul//li"));
		
		Registration.rellenarDP(arg1,li);
		
	}
	
	@Then("^terminar el registro del usuario$")
	public void terminar_el_registro_del_usuario() throws Throwable {
	    
		
		Registration.terminosCondiciones();	  
		
		Registration.informacionPromaciones();
		
		Registration.buttonCrearCuenta();
		
		Thread.sleep(2000);
		
		WebDriverWait wait = new WebDriverWait(Registration.driver,120);
	    
	 	if (wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("UserRegistrationErrorMessage"))) != null) {
			WebElement mensaje = driver.findElement(By.id("UserRegistrationErrorMessage"));
	 		
	 		System.out.print(mensaje.getText().toString());
	 		
	 		driver.close();
		}
	}
	
	@Then("^validar el nombre de usuario \"([^\"]*)\"$")
	public void validar_el_nombre_de_usuario(String arg1) throws Throwable {
		
		WebElement user = driver.findElement(By.id("Header_GlobalLogin_signOutQuickLinkUser"));
		
		if (!user.equals(arg1)) {
			System.out.print("No contiene el nombre de usuario");
		}
		
		Registration.seccionLogin();
		
		WebElement mycount = driver.findElement(By.id("myAccountQuickLink"));
		
		mycount.click();
		
	}
	
	@Then("^visualizar detalle de la cuenta$")
	public void visualizar_detalle_de_la_cuenta(DataTable arg1) throws Throwable {
		
		List<List<String>> data = arg1.raw();
		
		WebElement user = driver.findElement(By.xpath("//*[@class='txt-bold padiro']"));
		
		if (!user.equals("Hola, "+data.get(0).get(0))) {
			System.out.print("No contiene el nombre de usuario");
		}
		
		List<WebElement> datos = driver.findElements(By.xpath("//*[@class='fondo-datos-cliente']//*[@class='row']//*[@class='mediun-12 columns text-left lines-h no-p-no']//span"));
			
		if (!datos.get(0).findElement(By.tagName("span")).equals(data.get(0).get(0) + " " + data.get(0).get(1) + " " + data.get(0).get(2))) {
			System.out.print("No contiene los datos del usuario");
		}
		
		if (!datos.get(1).findElement(By.tagName("span")).equals(data.get(0).get(7))) {
			System.out.print("No contiene el correo");
		}
		
	}

	
}
