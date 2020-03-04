package com.test.step.definitions;

import java.time.Duration;
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
import io.appium.java_client.MobileDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class RegistroUsuarioMob {
	
	public WebDriver driver;
	public RegistroUsuarioMob() {
		this.driver = Hook.getDriver();
	}	
	
	public static WebDriverWait wait = new WebDriverWait(Registration.driver,120);
	
	@And("^ingresa a la seccion registro mobile$")
	public void ingresa_a_la_seccion_registro_mobile() throws Throwable {
		
	    Registration.seccionLoginMobile();
	    Registration.takeScreenshot("SeccionLogin");
	    
	   
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.Button[@resource-id='Header_GlobalLogin_WC_AccountDisplay_links_3']")));
	    WebElement redirectRegistro = driver.findElement(By.xpath("//android.widget.Button[@resource-id='Header_GlobalLogin_WC_AccountDisplay_links_3']"));
	    
	    redirectRegistro.click();
	    
	    Thread.sleep(2000);
	    
	}
	
	
	@Then("^rellenar los datos para el registro datos personales mobile$")
	public void rellenar_los_datos_para_el_registro_datos_personales_mobile(DataTable arg1) throws Throwable {

	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.ListView//android.view.View//android.widget.EditText")));
			
		List<WebElement>  li = (List<WebElement>) driver.findElements(By.xpath("//android.widget.ListView//android.view.View//android.widget.EditText"));
		
	    //Registration.rellenarDPMobile(arg1,li);
	    TouchAction action = new TouchAction((MobileDriver)driver);
	    action.press(PointOption.point(450, 1000)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2))).moveTo(PointOption.point(0, 250)).release().perform();
	    
	    Thread.sleep(2000);
	}
	
	

}
