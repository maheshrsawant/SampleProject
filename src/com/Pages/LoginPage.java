package com.Pages;

import org.apache.commons.codec.binary.Base64;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.PageFactory.ElementFactory;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.Utility.BrowserFactory;
import com.Utility.ConfigReader;

public class LoginPage{
	
	public WebDriver driver;
	BrowserFactory br = new BrowserFactory();
	ConfigReader config = new ConfigReader();
	ElementFactory ef = new ElementFactory();
	public String TS;
	

	//Login to SSA Application
	public WebDriver loginSSA(WebDriver driver, String path, ExtentTest logger)
	{
		ElementFactory ef = PageFactory.initElements(driver, ElementFactory.class); 
		ef.loginUsername.sendKeys(config.getUserName());
		ef.loginPassword.sendKeys(config.getpassword());
	 	logger.log(LogStatus.INFO, " Username and Password Entered successfully");
	 	ef.loginSubmit.click();
	 	
		return driver;
	} 
	
	
	
	// Mahesh Methods

	//Login to SSA Application
	
	
	
	public WebDriver loginSSAUser(WebDriver driver, String path, String user, String pass, ExtentTest logger)
	{
		ElementFactory ef = PageFactory.initElements(driver, ElementFactory.class); 
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(ef.loginUsername));
		ef.loginUsername.sendKeys(user);
		ef.loginPassword.sendKeys(pass);
		//logger.log(LogStatus.INFO, " Login TO SSA successfully"+logger.addScreenCapture(TS));
		ef.loginSubmit.click();
		System.out.println("Username and Password Entered Successfully");
		logger.log(LogStatus.INFO,"Username and Password Entered Successfully");
		return driver;
	}
	
	public static String encryptedPassword(String pass)
	{
		byte[] encodedBytes = Base64.encodeBase64(pass.getBytes());
		String encodedPassword = new String(encodedBytes);
		System.out.println("encodedBytes: "+ encodedPassword);
		return encodedPassword;
	}
	
	public static String decryptedPassword(String encodedBytes)
	{
		byte[] decodedBytes = Base64.decodeBase64(encodedBytes);
		String decodedpassword = new String(decodedBytes);
		return decodedpassword;
	}
	
	
	public WebDriver loginDevSSAUser(WebDriver driver, String path, ExtentTest logger, String user)
    {
		ElementFactory ef = PageFactory.initElements(driver, ElementFactory.class); 
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(ef.usesrname));
		ef.usesrname.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		for(int i=0; i<ef.usernameList.size();i++)
		{
			
			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(ef.usernameList.get(i)));
			//userOption.click();
			//System.out.println(ef.usernameList.get(i).getText());
			
		if(ef.usernameList.get(i).getText().contains(user))		
		{
			ef.usernameList.get(i).click();
			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(ef.devSubmit));
	        ef.devSubmit.click();
	        System.out.println(user+" selected successfully");
	        logger.log(LogStatus.INFO,user+" selected successfully");
			break;
		}
		}
		testLogin(driver, path); 
		                       
           return driver;
           
    }

	 
	public WebDriver testLogin(WebDriver driver, String path) 
	  {
		  // OTP Wait Timer
		   for (int a = 110; a >= 0; a--)
		    {
		    	System.out.println(a);
		        try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
		      
		        if(driver.findElements(By.xpath(".//*[@id='step1']//*[@id='btnClose']") ).size() != 0)
		        	{
		        	try {
						Thread.sleep(3000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		        	break;
		        	}
		    }
		  
		  String title = driver.getTitle();
		  System.out.println(title);
		  if(title.contains("S.M.A.R.T. - Staffing Management and Resource Tracking"))
		  {
			  for (int a = 15; a >= 0; a--)
			    {
			    	System.out.println(a);
			        try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			    }
			  
		  	System.out.println("Login successfull");
		  	try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  	
		  }
		return driver;
	  }



	public String decryptedPassword(Object encodedBytes) {
		// TODO Auto-generated method stub
		return null;
	}
	 

}
