package com.test.step.definitions;

import org.openqa.selenium.WebDriver;

import com.test.step.logic.SisacAvatarLogic;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SisactAvatarSteps {

	public WebDriver driver;

	public SisactAvatarSteps() {
		this.driver = Hook.getDriver();
	}

	@When("^ingresa credenciales en login$")
	public void ingresa_credenciales_en_login(DataTable dt) throws Throwable {
		SisacAvatarLogic.completeLoginForm(dt);
	}

	@And("^hace clic en boton ingresar$")
	public void hace_clic_en_boton_ingresar() throws Throwable {
		SisacAvatarLogic.clickOnLoginButton();
	}
	
	@And("^selecciona la opcion Clientes$")
	public void selecciona_la_option_Clientes() throws Throwable {
		SisacAvatarLogic.clickOptionClient();
	}
	
	@And("^ingresa dni del cliente$")
	public void ingresa_dni_de_cliente(DataTable dt) throws Throwable {
		SisacAvatarLogic.setDni(dt);
	}
	
	@And("^hace clic en boton buscar$")
	public void hace_clic_en_boton_buscar() throws Throwable {
		SisacAvatarLogic.clickSearchButton();
	}
	
	// REGISTRAR CLIENTE
	@And("^hace clic en boton Agregar Cliente$")
	public void hace_clic_en_boton_Agregar_Cliente() throws Throwable {
		Thread.sleep(4000);
		SisacAvatarLogic.clickAddClientButton();
	}

	@And("^rellena el formulario de cliente$")
	public void rellena_el_formulario_de_cliente(DataTable dt) throws Throwable {
		SisacAvatarLogic.completeClientForm(dt);
	}

	@And("^hace clic en boton Guardar$")
	public void hace_clic_en_boton_Guardar() throws Throwable {
		SisacAvatarLogic.clickSaveButton();
	}
	
	@And("^confirmar registro$")
	public void confirmar_registro() throws Throwable {
		SisacAvatarLogic.clickYesButton();
	}
	//

	@Then("^se realiza la operacion correctamente$")
	public void se_realiza_la_operacion_correctamente() throws Throwable {
		Thread.sleep(4000);
		SisacAvatarLogic.successfulLogin();
	}
	
	@Then("^Se guardo$")
	public void Se_guardo() throws Throwable {
		Thread.sleep(4000);
		SisacAvatarLogic.successfulLogin();
	}

}