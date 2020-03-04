package com.test.step.definitions;

import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.Given;

public class DefinicionHelp {

	public WebDriver driver;

	public DefinicionHelp() {
		this.driver = Hook.getDriver();
	}

	@Given("^el usuario ingreso a la pagina \"([^\"]*)\"$")
	public void el_usuario_ingreso_a_la_pagina(String url) throws Throwable {		
		driver.get(url);
	}

}
