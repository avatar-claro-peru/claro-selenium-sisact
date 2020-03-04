package com.test.step.logic;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.test.step.definitions.Hook;

import cucumber.api.DataTable;

public class SisacAvatarLogic {

	public static WebDriver driver = Hook.getDriver();
	public static WebDriverWait wait = new WebDriverWait(SisacAvatarLogic.driver, 120);
	public static JavascriptExecutor js = (JavascriptExecutor) driver;	
	
	public static void completeLoginForm(DataTable data) throws InterruptedException {
		List<List<String>> dat = data.raw();
		WebElement correo = driver.findElement(By.name("j_username"));
		WebElement pass = driver.findElement(By.name("j_password"));

		correo.sendKeys(dat.get(0).get(0));
		pass.sendKeys(dat.get(0).get(1));
	}
	
	public static void clickOnLoginButton() throws InterruptedException {
		WebElement button = driver.findElement(By.name("login"));
		button.click();
		Thread.sleep(4000);
	}
	
	public static void clickOptionClient() throws InterruptedException {
		WebElement button = driver.findElement(By.id("cliente")).findElement(By.linkText("Clientes"));
		button.click();
		Thread.sleep(4000);
	}
	
	public static void setDni(DataTable data) throws InterruptedException {
		List<List<String>> dat = data.raw();
		WebElement numDoc = driver.findElement(By.name("num_doc"));
		
		numDoc.sendKeys(dat.get(0).get(0));
		Thread.sleep(4000);
	}
	
	public static void clickSearchButton() throws InterruptedException {
		WebElement button = driver.findElement(By.id("btn_buscar"));
		button.click();
	}
	
	public static void clickAddClientButton() throws InterruptedException {
		WebElement button = driver.findElement(By.id("btn_nuevo"));
		button.click();
	}
	
	public static void completeClientForm(DataTable data) throws InterruptedException {
		List<List<String>> dat = data.raw();
		WebElement nombre = driver.findElement(By.name("formClienteEdit")).findElement(By.name("nombre"));
		WebElement numDoc = driver.findElement(By.name("formClienteEdit")).findElement(By.id("textbox_num_doc"));
		WebElement email = driver.findElement(By.name("formClienteEdit")).findElement(By.name("correo"));
		
		nombre.sendKeys(dat.get(0).get(0));
		Thread.sleep(4000);
		WebElement button = driver.findElement(By.name("formClienteEdit")).findElement(By.id("rbn_dni"));
		button.click();
		
		numDoc.sendKeys(dat.get(0).get(1));
		email.sendKeys(dat.get(0).get(2));
	}
	
	public static void clickSaveButton() throws InterruptedException {
		WebElement button = driver.findElement(By.id("btn_guardar"));
		button.click();
		Thread.sleep(4000);
//		WebElement button2 = driver.findElement(By.xpath("//*[@class = 'sa-confirm-button-container']"));
//		button2.findElement(By.xpath("//button[@class ='confirm']")).click();
	}
	
	public static void clickYesButton() throws InterruptedException {
		WebElement button = driver.findElement(By.xpath("//*[@class = 'sa-confirm-button-container']"));
		button.findElement(By.xpath("//button[@class ='confirm']")).click();
	}

	//
	public static void successfulLogin() throws InterruptedException {
		
	}

}