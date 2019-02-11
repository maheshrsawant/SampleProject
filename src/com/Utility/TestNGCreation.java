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
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.Test.LoginTest;
import com.Utility.TakeScreenshot;
import com.Pages.RejectionPage;
import com.Pages.ReportDashboardPage;
import com.Pages.RequestPage;
import com.Pages.ResourceProfilePage;
import com.Pages.SIQAPage;
import com.Pages.SRDetailsPage;
import com.Pages.SRPage;
import com.Pages.SourcingStrategyPage;
import com.Pages.SplashScreenPage;
import com.Pages.SwapLockPage;
import com.Pages.TaggingPage;
import com.Pages.TeamPage;
import com.Pages.TopSearchPage;
import com.Pages.TransferPage;
import com.Pages.UserManualPage;
import com.Pages.VersionHistoryPage;
import com.Pages.AccessRequestPage;
import com.Pages.AddSupplyPage;
import com.Pages.ChangeRollOffPage;
import com.Pages.ContactUsPage;
import com.Pages.DemandCancellationPage;
import com.Pages.DemandClonePage;
import com.Pages.DemandCreationPage;
import com.Pages.DemandDashbaordPage;
import com.Pages.DemandDetailsPage;
import com.Pages.DemandMaintenanceRRMatrixPage;
import com.Pages.DemandSkillOntologyPage;
import com.Pages.EmailVerification;
import com.Pages.GeneralEditPage;
import com.Pages.LockingIOMPage;
import com.Pages.LockingPage;
import com.Pages.LoginPage;
import com.Pages.MatchingRolesPage;
import com.Pages.MatchingScoreCalculationPage;
import com.Pages.MatchingSupplyPage;
import com.Pages.MyLearningPage;
import com.Pages.PendingApprovalPage;
import com.Pages.QuickEditPage;
import com.Pages.RFFDashboardPage;
import com.Pages.RefusalPage;
import com.Pages.FeedbackPage;
import com.Pages.LibraryPage;
import com.Pages.ExportPage;
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

	public RejectionPage rejection;
	public RFFDashboardPage rffDashboardPage;
	public SRDetailsPage srdetailspage;
	public DemandCreationPage demandCreationPage;
	public DemandDetailsPage demandDetailsPage;
	public DemandClonePage demandclonepage;
	public TeamPage teamPage;
	public GeneralEditPage generalEditPage;
	public TransferPage transferPage;
	public TaggingPage taggingPage;
	public AddSupplyPage addSupplyPage;
	public DemandCancellationPage demandCancellationPage;
	public DemandDashbaordPage demandDashbaordPage;
	public QuickEditPage quickEditPage;
	public SwapLockPage swapLockPage;
	public PendingApprovalPage pendingApprovalPage;
	public LockingPage lockingpage;
	public MatchingSupplyPage matchingSupply;
	public MatchingRolesPage matchingRolesPage;
	public ChangeRollOffPage changeRollOffPage;
	public DemandMaintenanceRRMatrixPage demandMaintenanceRRMatrix;
	public SRPage srPage;
	public TopSearchPage topSearchPage;
	public LockingIOMPage lockingIOMPage;
	public ReportDashboardPage reportDashboardPage;
	public ResourceProfilePage resProfile;
	public RefusalPage refusal;
	public AccessRequestPage accessRequestPage;
	public UserManualPage userManualPage;
	public VersionHistoryPage versionHistoryPage;
	public RequestPage requestPage;
	public SIQAPage siqaPage;
	public ContactUsPage contactusPage;
	public SplashScreenPage splashScreen; 
	public FeedbackPage feedbackPage;
	public LibraryPage libraryPage;
	public SourcingStrategyPage sourcingStrategyPage;
    public DemandSkillOntologyPage demandSkillOntologyPage;
    public ExportPage exportPage;
	public EmailVerification emailVerification;
	public MyLearningPage myLearningPage;
	public MatchingScoreCalculationPage matchingScoreCalculationPage;
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
			rejection = PageFactory.initElements(driver, RejectionPage.class);
			rffDashboardPage = PageFactory.initElements(driver, RFFDashboardPage.class);
			srdetailspage = PageFactory.initElements(driver, SRDetailsPage.class);
			demandCreationPage = PageFactory.initElements(driver, DemandCreationPage.class);
			demandDetailsPage = PageFactory.initElements(driver, DemandDetailsPage.class);
			demandclonepage=PageFactory.initElements(driver, DemandClonePage.class);
			teamPage = PageFactory.initElements(driver, TeamPage.class); 
			generalEditPage = PageFactory.initElements(driver, GeneralEditPage.class); 
			transferPage = PageFactory.initElements(driver, TransferPage.class); 
			taggingPage = PageFactory.initElements(driver, TaggingPage.class); 
			addSupplyPage = PageFactory.initElements(driver, AddSupplyPage.class); 
			demandCancellationPage = PageFactory.initElements(driver, DemandCancellationPage.class); 
			demandDashbaordPage = PageFactory.initElements(driver, DemandDashbaordPage.class);
			quickEditPage = PageFactory.initElements(driver, QuickEditPage.class);
			swapLockPage = PageFactory.initElements(driver, SwapLockPage.class);
			pendingApprovalPage = PageFactory.initElements(driver, PendingApprovalPage.class);
			lockingpage = PageFactory.initElements(driver, LockingPage.class);
			matchingSupply = PageFactory.initElements(driver, MatchingSupplyPage.class);
			matchingRolesPage = PageFactory.initElements(driver, MatchingRolesPage.class);
			changeRollOffPage = PageFactory.initElements(driver, ChangeRollOffPage.class);
			demandMaintenanceRRMatrix = PageFactory.initElements(driver, DemandMaintenanceRRMatrixPage.class);
			srPage = PageFactory.initElements(driver, SRPage.class);
			topSearchPage = PageFactory.initElements(driver, TopSearchPage.class);
			lockingIOMPage = PageFactory.initElements(driver, LockingIOMPage.class);
			connection = PageFactory.initElements(driver, DBConnectionNew.class);
			reportDashboardPage = PageFactory.initElements(driver, ReportDashboardPage.class);
			resProfile = PageFactory.initElements(driver, ResourceProfilePage.class);
			refusal = PageFactory.initElements(driver, RefusalPage.class);
			userManualPage =  PageFactory.initElements(driver, UserManualPage.class);
			accessRequestPage =  PageFactory.initElements(driver, AccessRequestPage.class);
			versionHistoryPage =  PageFactory.initElements(driver, VersionHistoryPage.class);
			requestPage = PageFactory.initElements(driver, RequestPage.class);
			siqaPage = PageFactory.initElements(driver, SIQAPage.class);
			contactusPage = PageFactory.initElements(driver, ContactUsPage.class);
			splashScreen = PageFactory.initElements(driver, SplashScreenPage.class);
			feedbackPage =  PageFactory.initElements(driver, FeedbackPage.class);
			sourcingStrategyPage = PageFactory.initElements(driver, SourcingStrategyPage.class);
			libraryPage =  PageFactory.initElements(driver, LibraryPage.class);
			demandSkillOntologyPage = PageFactory.initElements(driver, DemandSkillOntologyPage.class);
			exportPage = PageFactory.initElements(driver, ExportPage.class);
			emailVerification = PageFactory.initElements(driver, EmailVerification.class);
			myLearningPage = PageFactory.initElements(driver, MyLearningPage.class);
			matchingScoreCalculationPage = PageFactory.initElements(driver, MatchingScoreCalculationPage.class);
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
