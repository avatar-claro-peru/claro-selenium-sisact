package com.test.step.definitions;

import org.openqa.selenium.WebDriver;

import com.test.step.logic.Login;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginClaro {

	public WebDriver driver;
	
	public LoginClaro() {
		this.driver = Hook.getDriver();
	}	
	
	@And("^ingresa a la seccion login$")
	public void ingresa_a_la_seccion_login() throws Throwable {
	    Login.gotoLoginSection();
	}
	
	@When("^rellena el formulario de login$")
	public void rellena_el_formulario_de_login(DataTable dt)throws Throwable {
		Login.completeLoginForm(dt);
	}
	
	@And("^hace clic en boton inicia sesion$")
	public void hace_clic_en_boton_inicia_sesion()throws Throwable {
	    Login.clickOnLoginButton();
	}
	
	@Then("^el usuario se loguea correctamente$")
	public void el_usuario_se_loguea_correctamente() throws Throwable {
		Thread.sleep(5000);
		Login.successfulLogin();
	}	
	
	@Then("^sistema muestra mensaje de error$")
	public void sistema_muestra_mensaje_de_error() throws Throwable {		
		Login.errorLogin();
		Thread.sleep(5000);		
	}
	
}
