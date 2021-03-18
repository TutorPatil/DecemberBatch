package com.actitime.tests;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.actitime.base.BaseClass;
import com.actitime.utils.CommonLibrary;

public class Login extends BaseClass{
	
	
	//@Test(groups = { "smoke", "regression","login_001" })	
	
	//@Test
	public static void login_001() throws IOException
	{		
		writeLogs("*********starting the test case**********");
		CommonLibrary.launchAndLoginToActitime();	
		boolean result = getWebElementFromPageAndElementNames("Home","Logout_Link").isDisplayed();
	
		SoftAssert sAssert = new SoftAssert();
		sAssert.assertFalse(result, "Login_001 Failed");
		sAssert.assertTrue(false," The condition is false");
		sAssert.assertTrue(result, "Login_001 Failed");
		System.out.println(" All the assertions will be printed");
		sAssert.assertAll();
		
	}
	
	
	@Test
	public static void fileUpload1() throws IOException, AWTException, InterruptedException
	{		
		driver.get("https://codepen.io/rcass/pen/MmYwEp");
		driver.switchTo().frame("result");
		Thread.sleep(3000);
		//driver.findElement(By.id("fileToUpload")).click();
		
		
		// using Jawa AWT copy the file name to clipborad
		StringSelection ss= new StringSelection("D:\\test1.txt");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss,null);
		
		
		// Creating the object of the RObot class and using the Keypress and key release methods
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V); 
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		
		
		//driver.findElement(By.id("fileToUpload")).sendKeys("D:\\log1.txt");
		
		
	}
	
	//@Test
	public static void login_003() throws IOException
	{		
		
		CommonLibrary.launchAndLoginToActitime();	
		boolean result = getWebElementFromPageAndElementNames("Home","Logout_Link").isDisplayed();
	
		//Assert.assertFalse(result, "Login_001 Failed");
		Assert.assertTrue(result, "Login_001 Failed");	
		
		
	}
	
	
	
	//@Test
	public static void login_004() throws IOException
	{		
		
		CommonLibrary.launchAndLoginToActitime();	
		boolean result = getWebElementFromPageAndElementNames("Home","Logout_Link").isDisplayed();
	
		//Assert.assertFalse(result, "Login_001 Failed");
		Assert.assertTrue(result, "Login_001 Failed");	
		
		
	}
	
	
	
	
	
	
	
	
	
	
		
	//@Test(dependsOnMethods = { "login_001" })
	//@Test(groups = { "smoke","login_002" })
	
	//@Test(dataProvider = "logindata")
	
	//@Test(dataProvider = "logindata", dataProviderClass = com.actitime.dataproviders.DataProviders.class)
	public static void login_002(String user, String password) throws IOException
	{		
			
		CommonLibrary.launchAndLoginToActitime(user,password);		
		boolean result = getWebElementFromPageAndElementNames("Login","Error_Message").isDisplayed();
		
		if(result)
			writeResultsToFile("Login_002", "Pass");		
		else
		{
			writeResultsToFile("Login_002", "Fail");
			capturescreenShot("Login_002");
		}			
		closeBrowser();
		
	}	
	
	
	

}
