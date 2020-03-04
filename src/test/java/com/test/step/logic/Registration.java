package com.test.step.logic;

import java.io.File;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.test.step.definitions.Hook;

import cucumber.api.DataTable;





public class Registration{
	public static WebDriver driver = Hook.getDriver();
	public static WebDriverWait wait = new WebDriverWait(Registration.driver,120);
	public static JavascriptExecutor js = (JavascriptExecutor) driver;
	
	public static void takeScreenshot(String filepath) {
	
		try {
        
        TakesScreenshot ts = (TakesScreenshot)driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        
        String dest="C:\\Users\\desarrollo\\eclipse-workspace\\Cucum\\take\\"+ filepath +".jpg";
        File snapshotDest =new File(dest);
        FileUtils.copyFile(source, snapshotDest);
        
		} catch (Exception e) {
	        throw new RuntimeException("Failed to take screenshot !", e);
	    }
		
	}
	
	public static void seccionLogin() throws InterruptedException{
		
		WebElement iconoLogin = driver.findElement(By.xpath("//*[@id='Header_GlobalLogin_signInQuickLink']"));
		
		iconoLogin.click();
		
	}
	
	public static void seccionLoginMobile() throws InterruptedException{
		
		
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.view.View[contains(@resource-id,'Header_GlobalLogin_')]")));
	 	
		WebElement iconoLogin = driver.findElement(By.xpath("//android.view.View[contains(@resource-id,'Header_GlobalLogin_')]"));
		 
		iconoLogin.click();
		
	}
	
	public static void rellenarDP(DataTable data,List<WebElement> li) throws InterruptedException {
		
		List<List<String>> dat = data.raw();
		
		
		
		for (int i = 0; i < li.size(); i++) {
			
			
			if (li.get(i).findElements(By.tagName("input")).size()>0) {
				li.get(i).findElement(By.tagName("input")).sendKeys(dat.get(0).get(i));
				
			}else {
				
				WebElement div = li.get(i).findElement(By.tagName("div"));
				Select select = new Select (div.findElement(By.tagName("select")));
				select.selectByVisibleText(dat.get(0).get(i));
				
			}
			
			Thread.sleep(2000);
			
		}
		
	}
	
	public static void rellenarDPMobile(DataTable data,List<WebElement> li) throws InterruptedException {
		
		List<List<String>> dat = data.raw();
		
		WebElement spinner = driver.findElement(By.xpath("//android.widget.Spinner[@resource-id='demographicField6']"));
		spinner.click();
		
		List<WebElement> seleccion = (List<WebElement>) driver.findElements(By.xpath("//android.widget.FrameLayout//android.widget.LinearLayout//android.widget.FrameLayout//android.widget.FrameLayout//android.widget.FrameLayout//android.widget.ListView//android.widget.CheckedTextView"));
		
		System.out.print(dat.get(0).get(3).toString());
		
		for (int i = 0; i < seleccion.size(); i++) {
			
			if (seleccion.get(i).getText().equals(dat.get(0).get(3).toString())) {
				seleccion.get(i).click();
				break;
			}
			
		}
		
		for (int i = 0; i < li.size(); i++) {
			
				
			if (i < 3) {
				li.get(i).sendKeys(dat.get(0).get(i).toString());
				Thread.sleep(2000);
			}else {
				li.get(i).sendKeys(dat.get(0).get(i+1).toString());
				Thread.sleep(2000);
			}
			
		}
		
		
	}
	
	public static void informacionPromaciones() {
		
		WebElement iyp = driver.findElement(By.xpath("//*[contains(text(), 'Deseo recibir información y promociones por correo electrónico.')]"));
		
		iyp.click();
		
	}
	
	public static void buttonCrearCuenta() {
		
		WebElement cuenta = driver.findElement(By.xpath("//div[contains(text(), 'Crear cuenta')]"));
		
		cuenta.click();
		
	}
	
	public static void terminosCondiciones() throws InterruptedException {

        WebElement tyc = driver.findElement(By.xpath("//a[contains(text(), 'Términos y condiciones')]"));
        
        tyc.click();
        
        String parentWindow = driver.getWindowHandle();
        Set<String> handles =  driver.getWindowHandles();
           for(String windowHandle  : handles)
               {
               if(!windowHandle.equals(parentWindow))
                  {
                  driver.switchTo().window(windowHandle);
                 Thread.sleep(2000);
                 WebElement contenido = driver.findElement(By.id("terms_condition_content"));
                 driver.close(); 
                 driver.switchTo().window(parentWindow); 
                  }
               }
        
        
	}
	
	public static void loginUsuario (DataTable data) throws InterruptedException {
		
		List<List<String>> dat = data.raw();
		
		WebElement correo = driver.findElement(By.id("Header_GlobalLogin_WC_AccountDisplay_FormInput_logonId_In_Logon_1"));
		
		WebElement pass = driver.findElement(By.id("Header_GlobalLogin_WC_AccountDisplay_FormInput_logonPassword_In_Logon_1"));
		
		WebElement button = driver.findElement(By.xpath("//*[contains(text(),'Inicia sesión')]"));
			
		correo.sendKeys(dat.get(0).get(0));
		
		pass.sendKeys(dat.get(0).get(1));
		button.click();
		
		
		Thread.sleep(2000);
		
	}
	
	
	public static void errorLogin() {		
		
		WebElement tooltipLogin =  driver.findElement(By.id("Header_GlobalLogin_logonErrorMessage_GL"));
		
		if (tooltipLogin.getText().equals("El correo electrónico o la contraseña son incorrectos. Intenta nuevamente")) {
			System.out.print("El error es controlado");
		}else {
			System.out.print("Error no controlado");
		}
		
	}
	
	public static void successfulLogin() {
		
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
		
	}
	
}
