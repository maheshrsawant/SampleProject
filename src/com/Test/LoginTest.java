package com.Test;

import com.PageFactory.ElementFactory;
import com.Pages.LoginPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.Utility.BrowserFactory;
import com.Utility.ConfigReader;
import com.Utility.TestNGCreation;
import org.openqa.selenium.WebDriver;


public class LoginTest extends TestNGCreation{
	
	BrowserFactory br = new BrowserFactory();
	ConfigReader config = new ConfigReader();
	LoginPage loginPage= new LoginPage();
	public  WebDriver driver; 
	public static ExtentReports report; 
	public static ExtentTest logger;

    public static String pass;
    public static String user;
    

	
  public WebDriver testLogin(WebDriver driver,String path, String user, String pass, ExtentTest logger) throws InterruptedException 
	  {
	  	
	  			driver = br.startBrowser(config.getBrowserName());
	  			loginPage.loginSSAUser(driver, ElementFactory.loginPath, user, pass, logger);
	  			loginPage.testLogin(driver, ElementFactory.loginPath);
				//mf.closeFC(driver, ElementFactory.loginPath, logger);
				//loginPage.ServiceCheck(driver, ElementFactory.loginPath,logger);
				return driver;
	  }
  
}
