package com.Utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import com.PageFactory.ElementFactory;
import com.Pages.LoginPage;
import com.Pages.MatchingSupplyPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.Test.LoginTest;
import com.Utility.TakeScreenshot;
//import com.Pages.RejectionPage;

import com.Utility.MethodFactory;


public class TestNGCreation {


	
	
	BrowserFactory br = new BrowserFactory();
	protected ConfigReader config = new ConfigReader();
	public UtilMethods util = new UtilMethods();
	public WebDriver driver; 
	
	public static String DocPATH = System.getProperty("user.dir")+"/FailureScreenShotsDocument.doc";
	List<String> failureScreenshotpath1= new ArrayList<String>();
	public static String failureScreenshotpath[]= new String[500];
	public static String stringInDocument[]= new String[500];
	public static int pathCount;
	
	public static ExtentReports report; 
	public static ExtentTest logger;
	public String TS;
	public static DBConnectionNew connection; 
    public String Before_FE;
    public String Work_Loc_Actual;
    public String selected_FE;
    public static int count;

    public MethodFactory mf;
	public ElementFactory ef;
	public LoginPage loginPage;
	public TakeScreenshot takescreenshot;
	public LoginTest loginTest;
	public MatchingSupplyPage matchingSupply;
	
	//public RejectionPage rejection;

	//This function can handle dev URL as well
	
    public WebDriver login(String user, String pass) 
    {
		System.out.println("URL Under Testing : "+config.getAppUrl());
		logger.log(LogStatus.INFO, "URL Under Testing : "+config.getAppUrl());
		System.out.println("Test Case Started Module: "+this.getClass().getSimpleName());
		logger.log(LogStatus.INFO, "Test Case Started Module: "+this.getClass().getSimpleName());
		System.out.println("Test Case Start Time: "+TakeScreenshot.timestamp());
		logger.log(LogStatus.INFO, "Test Case Start Time: "+TakeScreenshot.timestamp());
		System.out.println("Browser Name: "+config.getBrowserName());
		logger.log(LogStatus.INFO, "Browser Name: "+config.getBrowserName());
		
		
    	 if(config.getAppUrl().contains("ciostage") || config.getAppUrl().contains("ciotest"))
         {
    		 loginPage.loginSSAUser(driver, ElementFactory.loginPath, user, pass, logger);
             loginPage.testLogin(driver, ElementFactory.loginPath);
             mf.closeFC(driver, ElementFactory.loginPath, logger);
         }   
    	else
    	 {    
    		loginPage.loginDevSSAUser(driver, ElementFactory.loginPath, logger,user);
            mf.closeFC(driver, ElementFactory.loginPath, logger);
    	 } 
    	 
    	 	try {
				mf.getToolTip(driver, ElementFactory.loginPath, logger);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("Tool Tip information is not available for the User");
			}
               return driver;
    }


			@BeforeMethod
  			public void beforeMethod() 
	  		{
			
			driver = br.startBrowser(config.getBrowserName());
			

			 
			loginPage = PageFactory.initElements(driver, LoginPage.class);
			loginTest  = PageFactory.initElements(driver, LoginTest.class);
			ef = PageFactory.initElements(driver, ElementFactory.class); 
			mf = PageFactory.initElements(driver, MethodFactory.class); 
			takescreenshot = PageFactory.initElements(driver, TakeScreenshot.class); 
			//rejection = PageFactory.initElements(driver, RejectionPage.class);
			connection = PageFactory.initElements(driver, DBConnectionNew.class);
			matchingSupply = PageFactory.initElements(driver, MatchingSupplyPage.class);
	  		}
	

	  @AfterMethod
	  	public void getResult(ITestResult result) throws Exception {
		  
		    if(result.getStatus() == ITestResult.FAILURE){
		    	
		      	TS = TakeScreenshot.captureScreenshots(driver, result.getName(),ElementFactory.Failure);
		    	logger.log(LogStatus.FAIL,"Test Case Failed: "+result.getName()+logger.addScreenCapture(TS));
		    	logger.log(LogStatus.FAIL, result.getThrowable()+" :Failed");
		    	System.out.println("Test Case Failed: "+result.getName());
		    	ReadExcel.writeResultExcel(result.getName(), "Fail",this.getClass().getSimpleName(), TS );

	        }
	        if(result.getStatus() == ITestResult.SUCCESS ){ 
		    	logger.log(LogStatus.PASS,"Test Case Passed: "+result.getName());
		    	System.out.println("Test Case Passed: "+result.getName());
		    	ReadExcel.writeResultExcel(result.getName(), "pass",this.getClass().getSimpleName(), TS);
	        }
	        if(result.getStatus() == ITestResult.SKIP){
	
	            TS = TakeScreenshot.captureScreenshots(driver, result.getName(),ElementFactory.Skipped);
		    	logger.log(LogStatus.SKIP,"Test Case Skipped: "+result.getName()+logger.addScreenCapture(TS));//Expecting logger
	            logger.log(LogStatus.SKIP, "Test Case Skipped: " + result.getThrowable());
	            System.out.println("Test Case Skipped: "+result.getName());
	            ReadExcel.writeResultExcel(result.getName(), "Skip", this.getClass().getSimpleName(), TS);
	        }
	        	
		        // ending test
		        //endTest(logger) : It ends the current test and prepares to create HTML report
		    	report.endTest(logger); 	  
		    	report.flush();
		    	
		    	System.out.println("Browser Closed successfully");
		    	System.out.println("Test Case Execution Completed: "+result.getName());
				logger.log(LogStatus.INFO, "Test Case Execution Completed: "+result.getName());
				System.out.println("Test Case End Time: "+TakeScreenshot.timestamp());
				logger.log(LogStatus.INFO, "Test Case End Time: "+TakeScreenshot.timestamp());
				
		    	driver.close();
		    	driver.quit(); 
		    	
		    	TakeScreenShotToDocFile.getMemory();
		    	
	  }
	  
	  
	  
	  @AfterClass
	  public void AfterClass()
	  {
		  System.gc();
		  TakeScreenShotToDocFile.getMemory();
	  }

	  
	  
	  @BeforeSuite
	  	public void beforeSuite() throws InterruptedException, FileNotFoundException {

	        //ExtentReports(String filePath,Boolean replaceExisting) 
	        //filepath - path of the file, in .htm or .html format - path where your report needs to generate. 
	        //replaceExisting - Setting to overwrite (TRUE) the existing file or append to it
	        //True (default): the file will be replaced with brand new markup, and all existing data will be lost. Use this option to create a brand new report
	        //False: existing data will remain, new tests will be appended to the existing report. If the the supplied path does not exist, a new file will be created.

		  	report = new ExtentReports (System.getProperty("user.dir") +"/test-output/ExtendReports/ExtendReport.html", true);

		  	report
	                .addSystemInfo("Host Name", "New Infra stage Environment")
	                .addSystemInfo("Environment", "CIO Stage")
	                .addSystemInfo("User Name", "Mahesh Sawant");
	                //loading the external xml file (i.e., extent-config.xml) which was placed under the base directory
		  	//You could find the xml file below. Create xml file in your project and copy past the code mentioned below
		  	report.loadConfig(new File(System.getProperty("user.dir")+"\\extent-config.xml"));
			
		  	System.out.println("before suite run done");
		  			  	 
		  	UtilMethods.deleteAllScreenshots();// TO delete all the screenshots from the directory
	  }

	  @AfterSuite
	  	public void afterSuite() throws Exception {
		  	report.close();
	  		float percentage = ReadExcel.testResultsCalculation(); // Calculation Of test summary i.e Pass, Fail and Skip percentage
	  		boolean statusDoc = ReadExcel.createTXT(percentage, logger); // Create .txt file as per pass percentage.
	  		if(statusDoc)
	  		{
	  			TakeScreenShotToDocFile.captureScreenShotInDoc();
				System.out.println("Fail Scenarios ScreenShots are saved in word document");
	  		}
	  		System.out.println("Automation Test Run Completed");
	  }

      
		
	
	
}
