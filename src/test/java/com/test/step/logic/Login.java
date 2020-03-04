package com.test.step.logic;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.test.step.definitions.Hook;

import cucumber.api.DataTable;

public class Login {

	public static WebDriver driver = Hook.getDriver();
	public static WebDriverWait wait = new WebDriverWait(Login.driver, 120);
	public static JavascriptExecutor js = (JavascriptExecutor) driver;	
	
	public static void gotoLoginSection() throws InterruptedException {
		WebElement iconoLogin = driver.findElement(By.id("Header_GlobalLogin_signInQuickLink"));
		iconoLogin.click();
	}

	public static void completeLoginForm(DataTable data) throws InterruptedException {
		List<List<String>> dat = data.raw();
		WebElement correo = driver.findElement(By.id("Header_GlobalLogin_WC_AccountDisplay_FormInput_logonId_In_Logon_1"));
		WebElement pass = driver.findElement(By.id("Header_GlobalLogin_WC_AccountDisplay_FormInput_logonPassword_In_Logon_1"));

		correo.sendKeys(dat.get(0).get(0));
		pass.sendKeys(dat.get(0).get(1));
	}
	
	public static void clickOnLoginButton() throws InterruptedException {
		WebElement button = driver.findElement(By.xpath("//*[contains(text(),'Inicia sesión')]"));
		button.click();
		Thread.sleep(4000);
	}
	
	public static void successfulLogin() throws InterruptedException {
		Set<Cookie> cookies = driver.manage().getCookies();
		boolean isLogged = false;

		for (Cookie ck : cookies) {
			System.out.println("Name cookie: " + ck.getName() + " Value cookie: " + ck.getValue());
			if (ck.getName().indexOf("WC_LogonUserId_") != -1) {
				isLogged = true;
			}
		}
		
		if (isLogged) {
			System.out.println("Login correcto");
		} else {
			System.out.println("Login incorrecto");
		}
		
		assertEquals("Error controlado", true, isLogged);
		
	}

	public static void errorLogin() throws InterruptedException {

		WebElement tooltipLogin = driver.findElement(By.id("Header_GlobalLogin_logonErrorMessage_GL"));

		if (tooltipLogin.getText().equals("El correo electrónico o la contraseña son incorrectos. Intenta nuevamente")) {
			System.out.print("El error es controlado");
		} else {
			System.out.print("Error no controlado");
		}

	}

	

}
