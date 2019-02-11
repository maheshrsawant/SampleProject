package com.Utility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.PageFactory.ElementFactory;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.Utility.ReadExcel;
import com.Utility.TakeScreenshot;
import com.Utility.TestNGCreation;

public class MethodFactory extends TestNGCreation{
	
WebDriver driver1;
public static String TS;
public static String data;
public static int personnelNo;
public static String RRDFromExcel;
public static String rrd_Number;
public static String Project_Name;
public static String Primary_Skill;
public static String Level;
public static String Location;
public static String Res_Name;
public static String Res_Status;
public static String Res_IG;
public static String Res_Primary_Skill;
public static String Res_Level;
public static String Res_Location;
private static XSSFSheet ExcelWSheet;
private static XSSFWorkbook ExcelWBook;
private static XSSFCell Cell;
private static XSSFRow Row;



	public MethodFactory()
	{
		this.driver1=driver;
	}

	public WebDriver closeFC(WebDriver driver, String path, ExtentTest logger)
	{
		//this.driver = driver;
//		new WebDriverWait(driver, 200).until(ExpectedConditions.visibilityOf(ElementFactory.fcClose)); 
//		
//		try {
//			Thread.sleep(7000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		UtilMethods.clickOn(logger,ElementFactory.fcClose,"FC Close Button");
//		TS = TakeScreenshot.captureScreenshots(driver, "Home page Shown", path);
//	 	logger.log(LogStatus.INFO, "Home page Shown"+logger.addScreenCapture(TS));
		return driver;
	}

	public WebDriver getToolTip(WebDriver driver, String loginPath, ExtentTest logger) {
		
		
	 	Actions ToolTip1 = new Actions(driver);
	    WebElement googleLogo = driver.findElement(By.xpath("//*[@id=\"demand\"]/header-layout/header/div[1]/div[3]/ul/li[5]/a/img"));

	    try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	    ToolTip1.clickAndHold(googleLogo).perform();
	    
	    //Perform mouse hover action using 'clickAndHold' method.

	    //Get the value of Tool tip by using 'getAttribute' command

	     String ToolTipText = googleLogo.getAttribute("title");
	     //Assert.assertEquals(ToolTipText, "T02109AbacusDSM.TU02 logged in as DU");
	        try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        System.out.println("Login Information : " + ToolTipText);
	        logger.log(LogStatus.INFO,"Login Information : " + ToolTipText);
	
	
	
	return driver;
	
	
	
}     

	public static void selectDropdownValue(WebDriver driver) 
	{
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		 UtilMethods.waitTillElementIsVisible(logger, driver, ElementFactory.selectDropdownValue,"Drop Down Value");
		//WebDriverWait wait=new WebDriverWait(driver,60);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@class='ui-select-choices-row ng-scope active']/span/span"))); 
		UtilMethods.clickOn(logger,ElementFactory.selectDropdownValue,"Select Dropdown");
	
	}


	public static WebDriver selectDate(WebDriver driver, WebElement datefield,List <WebElement> dates, int a, ExtentTest logger) {
		  
		  //	this.driver = driver;
		  	UtilMethods.clickOn(logger,datefield,"Date Field");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			for(WebElement ele:dates)
			{
				String date=ele.getText();
				String date1 = getDate(a);
				
				if(date1.matches("01|02|03|04|05|06|07|08|09")) {
					date1=trimint(date1);
				}
				if(date.equalsIgnoreCase(date1))
				{
					try {
						
						UtilMethods.clickOn(logger,ele,"Date");
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						logger.log(LogStatus.INFO, e.getMessage());
					}
					break;	
				}
			}
			return driver;
	  }  
	
	public static String trimint(String date1)
	{

		String new_date1 = date1.substring(1);

		return new_date1;
	}
	public static String getDate(int a)
	
	{

		Date mydate =new Date();
	    Calendar Cal= Calendar.getInstance();
	    Cal.setTime(mydate);
	    Cal.add(Calendar.DATE, a);
	    Date expected = Cal.getTime();
	    DateFormat dateformat = new SimpleDateFormat("dd");
	    String date1 = dateformat.format(expected);
	    return date1;
	
	}
	
public static String getMonth(int a)
	
	{

		Date mydate =new Date();
	    Calendar cal= Calendar.getInstance();
	    cal.setTime(mydate);
	    cal.add(Calendar.MONTH, a);
	    Date expected = cal.getTime();
	    DateFormat dateformat = new SimpleDateFormat("MMM");
	    String month1 = dateformat.format(expected);
	    return month1;
	
	}

	public WebDriver clickDemandTab(WebDriver driver,String path,ExtentTest logger) {
		try {
			Thread.sleep(7000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		UtilMethods.waitTillElementIsVisible(logger, driver, ElementFactory.demandTab, "Demand Tab");
		//new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(ElementFactory.demandTab));
		UtilMethods.clickOn(logger,ElementFactory.demandTab,"Demand Tab");
		UtilMethods.clickOn(logger,ElementFactory.demandTab,"Demand Tab");
		UtilMethods.waitTillElementIsVisible(logger, driver, ElementFactory.firstRRDonDemandPage, "RRD on Demand Page");
		//new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(ElementFactory.firstRRDonDemandPage));
		TakeScreenshot.captureScreenshots(driver, "clickDemandTab", path);
		try {
			Thread.sleep(7000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return driver;
	}
	
	public WebDriver clickTeamTab(WebDriver driver,String path,ExtentTest logger)
    {
		UtilMethods.waitTillElementIsVisible(logger, driver, ElementFactory.teamTab, "Team Tab");  
		//new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(ElementFactory.teamTab));
		UtilMethods.clickOn(logger,ElementFactory.teamTab,"Team Tab");
		UtilMethods.waitTillElementIsVisible(logger, driver, ElementFactory.firstResOnTeamPage, "Resource on Team Page");
		//new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(ElementFactory.firstResOnTeamPage));
		TakeScreenshot.captureScreenshots(driver, "clickTeamTab", path);
		return driver;
	}
	
	public WebDriver clickRequestTab(WebDriver driver,String path,ExtentTest logger) throws InterruptedException {
		  
		UtilMethods.waitTillElementIsVisible(logger, driver, ElementFactory.requestTab, "Request Tab");  
		//new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(ElementFactory.requestTab));
		UtilMethods.clickOn(logger,ElementFactory.requestTab,"Request Tab");
		//new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(ElementFactory.firstCheckBoxButtonOnLockPage));// Wait for First checkBox to get visible
		Thread.sleep(5000);
		UtilMethods.clickOn(logger,ElementFactory.requestTab,"Request Tab");
		TakeScreenshot.captureScreenshots(driver, "clickrequestTab", path);
		return driver;
	}
	
  public WebDriver clickSourcingStrategyTab(WebDriver driver,String path,ExtentTest logger) throws InterruptedException {
		  
		UtilMethods.waitTillElementIsVisible(logger, driver, ElementFactory.sourcingStrategyTab, "Sourcing Strategy Tab");
		UtilMethods.clickOn(logger,ElementFactory.sourcingStrategyTab,"Sourcing Strategy Tab");
		Thread.sleep(3000);
		TakeScreenshot.captureScreenshots(driver, "clicksourcingStrategyTab", path);
		return driver;
	}
	
	public static WebDriver clickReportsTab(WebDriver driver,String path,ExtentTest logger) throws InterruptedException {
		  
		UtilMethods.waitTillElementIsVisible(logger, driver, ElementFactory.reportsTab, "Reports Tab");
		//new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(ElementFactory.reportsTab));
		UtilMethods.clickOn(logger,ElementFactory.reportsTab,"Reports Tab");
		UtilMethods.waitTillElementIsVisible(logger, driver, ElementFactory.reportContentPage, "reportContentPage");
		//new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(ElementFactory.reportContentPage));
		Thread.sleep(3000);
		TakeScreenshot.captureScreenshots(driver, "clickreportsTab", path);

		return driver;
	}
	
	public WebDriver clickReviewTab(WebDriver driver,String path,ExtentTest logger) throws InterruptedException {
		
		UtilMethods.waitTillElementIsVisible(logger, driver, ElementFactory.reveiwTab, "Review Tab");  
		//new WebDriverWait(driver, 90).until(ExpectedConditions.visibilityOf(ElementFactory.reveiwTab));
		UtilMethods.clickOn(logger,ElementFactory.reveiwTab,"Reveiw Tab");
		UtilMethods.waitTillElementIsVisible(logger, driver, ElementFactory.RejDashexpandButton, "review page load");  
		//new WebDriverWait(driver, 90).until(ExpectedConditions.visibilityOf(ElementFactory.RejDashexpandButton));
		TakeScreenshot.captureScreenshots(driver, "clickreviewTab", path);

		return driver;
	}
	public WebDriver scrollPage(WebDriver driver) throws IOException, InterruptedException
  	{
	    JavascriptExecutor jse = (JavascriptExecutor)driver;
	    jse.executeScript("scroll(0, 450);");
		return driver;
  	} 
	
	public static WebDriver enterRRDNumber(WebDriver driver, String path, int a, int b, String sheetName, ExtentTest logger, String queryName)
	{
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(ElementFactory.mainSearchIconClick));
		UtilMethods.clickOn(logger,ElementFactory.mainSearchIconClick,"MainSearchClick");
		
		try {
			connection.retrieveQuery(queryName,logger);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}	
		String data=connection.dbResult;
		data = "R"+data;
		
		//data = ReadExcel.getData(sheetName, a, b);
		System.out.println(data);
		//RRDFromExcel = data;
		UtilMethods.setText(logger ,ElementFactory.mainSearch, data);
		TakeScreenshot.captureScreenshots(driver, "enterRRDNumber",path);
		UtilMethods.clickOn(logger,ElementFactory.rrdMainSearch,"Select RRD Main Search");
		
		return driver;
	}
	public WebDriver enterEnterpriseIDNumber(WebDriver driver, String path, int a, int b, String sheetName, ExtentTest logger)
	{
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(ElementFactory.mainSearchIconClick));
		UtilMethods.clickOn(logger,ElementFactory.mainSearchIconClick,"MainSearchClick");
		data = ReadExcel.getData(sheetName, a, b);
		System.out.println(data);
		UtilMethods.setText(logger ,ElementFactory.mainSearch, data);
		TakeScreenshot.captureScreenshots(driver, "enterEnterpriseIDNumber",path);
		UtilMethods.clickOn(logger,ElementFactory.enterpriseIDMainSearch,"Select EnterpriseID/Personnal No/Candidate ID Main Search");
		return driver;
		
	}
	public WebDriver enterUsedEnterpriseId(WebDriver driver, String path, String entID, ExtentTest logger)
	{
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(ElementFactory.mainSearchIconClick));
		UtilMethods.clickOn(logger,ElementFactory.mainSearchIconClick,"MainSearchClick");
		UtilMethods.setText(logger ,ElementFactory.mainSearch, entID);
		TakeScreenshot.captureScreenshots(driver, "enterEnterpriseIDNumber",path);
		UtilMethods.clickOn(logger,ElementFactory.enterpriseIDMainSearch,"Select EnterpriseID/Personnal No/Candidate ID Main Search");
		return driver;
		
	}
	public WebDriver enterSkillLevelLocation(WebDriver driver, String path, int a, int b, String sheetName, ExtentTest logger)
	{
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(ElementFactory.mainSearchIconClick));
		UtilMethods.clickOn(logger,ElementFactory.mainSearchIconClick,"MainSearchClick");
		data = ReadExcel.getData(sheetName, a, b);
		System.out.println(data);
		UtilMethods.setText(logger ,ElementFactory.mainSearch, data);
		TakeScreenshot.captureScreenshots(driver, "enterSkillLevelLocation",path);
		UtilMethods.clickOn(logger,ElementFactory.skillLevelLocationMainSearch,"Select Skill/Level/Location Main Search");
		return driver;
		
	}
	
	public WebDriver taggedTab(WebDriver driver, String path, ExtentTest logger) throws InterruptedException
	{
		 
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(ElementFactory.taggedTab));
		UtilMethods.clickOn(logger,ElementFactory.taggedTab, "Tagged Tab Successfully on RRD page");
		TakeScreenshot.captureScreenshots(driver, "taggedTab", path);
		return driver;

	}
	
	
	public WebDriver detailsTab(WebDriver driver, String path, ExtentTest logger) throws InterruptedException
	{
		 
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(ElementFactory.detailsTab));
		UtilMethods.clickOn(logger,ElementFactory.detailsTab, "Details Tab Successfully on RRD page");
		TakeScreenshot.captureScreenshots(driver, "detailsTab", path);
		return driver;

	}
	
	public WebDriver jobDescriptionTab(WebDriver driver, String path, ExtentTest logger) throws InterruptedException
	{
		 
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(ElementFactory.jobDescriptionTab));
		UtilMethods.clickOn(logger,ElementFactory.jobDescriptionTab, "Job Description Tab Successfully on RRD page");
		TakeScreenshot.captureScreenshots(driver, "jobDescriptionTab", path);
		return driver;

	}
	

    public WebDriver Get_RRD_Details_Damand_Page(WebDriver driver,int n) {
    	rrd_Number = driver.findElement(By.cssSelector("div.ui-grid-row:nth-child("+n+") > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > a:nth-child(1)")).getText();
    	System.out.println("RRD Number: "+rrd_Number);
    	Project_Name = driver.findElement(By.cssSelector("div.ui-grid-row:nth-child("+n+") > div:nth-child(1) > div:nth-child(1) > div:nth-child(4) > div:nth-child(1)")).getText();
    	System.out.println("Project Name: "+Project_Name);
    	Primary_Skill = driver.findElement(By.cssSelector("div.ui-grid-row:nth-child("+n+") > div:nth-child(1) > div:nth-child(1) > div:nth-child(5) > div:nth-child(1)")).getText();
    	System.out.println("Primary Skill: "+Primary_Skill);
    	Level = driver.findElement(By.cssSelector("div.ui-grid-row:nth-child("+n+") > div:nth-child(1) > div:nth-child(1) > div:nth-child(6) > div:nth-child(1)")).getText();
    	System.out.println("Level: "+Level);
    	Location = driver.findElement(By.cssSelector("div.ui-grid-row:nth-child("+n+") > div:nth-child(1) > div:nth-child(1) > div:nth-child(7) > div:nth-child(1)")).getText();
    	System.out.println("Location: "+Location);
        return driver;
    }
    

    
    public WebDriver Get_Resource_Details_Tagged_Page(WebDriver driver,int n) {
        // n should come from List elements for loop
    	
    	int m=n+1;

    	Res_Name = driver.findElement(By.xpath(".//*[@class='ui-grid-canvas']/div["+m+"]//*[@class='ng-scope']//*[@id='ms_tagged_cell']")).getText();
    	Res_Status = driver.findElement(By.xpath(".//*[@class='ui-grid-canvas']/div["+m+"]//*[@class='ng-scope']/div[3]//*[@id='ms_tagged_cell']//*[@class='ui-grid-cell-contents']//*[@class='identifier-icons']//*[@class='ng-binding']")).getText();
    	Res_IG = driver.findElement(By.xpath(".//*[@class='ui-grid-canvas']/div["+m+"]//*[@class='ng-scope']/div[5]//*[@class='ui-grid-cell-contents ng-binding ng-scope']")).getText();
    	Res_Primary_Skill = driver.findElement(By.xpath(".//*[@class='ui-grid-canvas']/div["+m+"]//*[@class='ng-scope']/div[6]//*[@class='ui-grid-cell-contents ng-binding ng-scope']")).getText();
    	Res_Level = driver.findElement(By.xpath(".//*[@class='ui-grid-canvas']/div["+m+"]//*[@class='ng-scope']/div[7]//*[@class='ui-grid-cell-contents ng-binding ng-scope']")).getText();
    	Res_Location = driver.findElement(By.xpath(".//*[@class='ui-grid-canvas']/div["+m+"]//*[@class='ng-scope']/div[8]//*[@class='ui-grid-cell-contents ng-binding ng-scope']")).getText();

    	return driver;
    }
    
  public void Print_Resource_Details_Tagged_Page() {
    	
    	System.out.println("Resource_Name: "+Res_Name);
    	System.out.println("Resource Status: "+Res_Status);
    	System.out.println("IG: "+Res_IG);
    	System.out.println("Primary Skill: "+Res_Primary_Skill);
    	System.out.println("Level: "+Res_Level);
    	System.out.println("Level: "+Res_Location);
    }
    
  public WebDriver searchRRDOnDemandPage(WebDriver driver, String path, String exceltab, int a, int b,  ExtentTest logger) throws InterruptedException, IOException
	{
	     	
			for(int i=0; i>=0;i++)
			{
				data = ReadExcel.getData(exceltab, a, b);
				System.out.println(data);
				RRDFromExcel = data;
				refreshPg(driver);
				clickDemandTab(driver, ElementFactory.loginPath, logger);
		        //Check if RRD search box is visible or not
		        if(driver.findElements( By.cssSelector(".ui-grid-filter-input") ).size() != 0 )
		        	{
			        	 	// Put RRD noumber in box and search RRD
			        	 	ElementFactory.rrdSearchBox.sendKeys(RRDFromExcel);
			        	 	TS = TakeScreenshot.captureScreenshots(driver, "EnterRRD",path);
			        	 	logger.log(LogStatus.INFO, RRDFromExcel+" Entered successfully"+logger.addScreenCapture(TS));
			        	 	UtilMethods.clickOn(logger,ElementFactory.rrdSearchIcon, "RRD Search Icon");
			        	 	
			        	 	Thread.sleep(3000);
			        	 	TS = TakeScreenshot.captureScreenshots(driver, "enterRRD", path);
			        	 	logger.log(LogStatus.INFO,"Serching RRD on demand page successfull"+logger.addScreenCapture(TS));
			        	 	break;
			        	 	
		        	}
		        else
			        {
		        			System.out.println("Search Box not shown on Demand Page");
		        			TakeScreenshot.captureScreenshots(driver, "rrdNotShown", path);
			        	 	logger.log(LogStatus.INFO,"Search Box not shown on Demand Page");
			        	 	
			        }
			}
		return driver;
	}
  
	public WebDriver refreshPg(WebDriver driver) throws InterruptedException {
		
		driver.navigate().refresh();
		System.out.println("Page Refreshed...");
		Thread.sleep(40000);
		closeFC(driver, ElementFactory.loginPath, logger);
		return driver;
	}
  
  

	public static WebDriver addSupply(WebDriver driver, String path, int a, int b, String sheetName, ExtentTest logger, String queryName)
	{
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(ElementFactory.addSupplyButton));
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 	UtilMethods.clickOn(logger,ElementFactory.addSupplyButton, "Add Supply Button");

	 	
		//personnelNo = ReadExcel.getIntegerData(sheetName, a, b);
	//	System.out.println(Integer.toString(personnelNo));
	//	String Personnel_No = Integer.toString(personnelNo);
		
		try {
			connection.retrieveQuery(queryName,logger);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}	
		String Personnel_No=connection.dbResult;
		
		
		UtilMethods.waitTillElementIsVisible(logger, driver, ElementFactory.addSupplyInput, "addSupplyInput");
	 	UtilMethods.clickOn(logger,ElementFactory.addSupplyInput, "Add Supply Input");

        ElementFactory.addSupplyInput.sendKeys(Personnel_No);
    	UtilMethods.waitTillElementIsVisible(logger, driver, ElementFactory.addSupplySelectDropdownValue, "addSupplySelectDropdownValue");
	 	UtilMethods.clickOn(logger,ElementFactory.addSupplySelectDropdownValue, "Add Supply Select Dropdown Value");

		TakeScreenshot.captureScreenshots(driver, "enterSupply",path);
		return driver;
		
	}

	public WebDriver clickRFFTab(WebDriver driver , String path) throws InterruptedException 
	{
			  
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(ElementFactory.rffTab));
		UtilMethods.clickOn(logger,ElementFactory.rffTab, "RFF Tab");
		Thread.sleep(4000);
		TakeScreenshot.captureScreenshots(driver, "clickRFFTab", path);
		return driver;  
		
	}

	//This method is to set the File path and to open the ReadExcel file, Pass ReadExcel Path and Sheetname as Arguments to this method
	 
	public void setExcelFile(String Path,String SheetName) throws Exception {

			try {

   			// Open the ReadExcel file

			FileInputStream ExcelFile = new FileInputStream(Path);

			// Access the required test data sheet

			ExcelWBook = new XSSFWorkbook(ExcelFile);

			ExcelWSheet = ExcelWBook.getSheet(SheetName);

			} catch (Exception e){

				throw (e);

			}

	}

	@SuppressWarnings({ "static-access", "deprecation" })
	public void setCellData(String Result,  int RowNum, int ColNum) throws Exception	{
		 
			try{

  			Row  = ExcelWSheet.getRow(RowNum);

			Cell = Row.getCell(ColNum, Row.RETURN_BLANK_AS_NULL);

			if (Cell == null) {

				Cell = Row.createCell(ColNum);

				Cell.setCellValue(Result);

				} else {

					Cell.setCellValue(Result);

				}

  // Constant variables Test Data path and Test Data file name

  				FileOutputStream fileOut = new FileOutputStream(ElementFactory.dataPath);

  				ExcelWBook.write(fileOut);

  				fileOut.flush();

					fileOut.close();

				}catch(Exception e){

					throw (e);

			}

		}
	 public static WebDriver selectDate2(WebDriver driver, ExtentTest logger, WebElement datefield, List <WebElement> dates, int monthsToIncrement) {
		 
			 
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			UtilMethods.waitTillElementIsVisible(logger, driver, datefield, "waiting for date field");
		UtilMethods.clickOn(logger,datefield,"Date Field");
		 UtilMethods.waitTillElementIsVisible(logger, driver, ElementFactory.nextMonth, "NextMonth");
		 
		  for(int i= 0; i<monthsToIncrement; i++)
			  ElementFactory.nextMonth.click();
		  
		  
			for(WebElement ele:dates)
			{
				String date=ele.getText();
				String date1 = getDate(1);
				
				if(date1.matches("01|02|03|04|05|06|07|08|09")) {
					date1=trimint(date1);
				}
				if(date.equalsIgnoreCase(date1))
				{
					try {
						
						UtilMethods.clickOn(logger,ele,"Date- "+date1);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						logger.log(LogStatus.INFO, e.getMessage());
					}
					break;	
				}
			}
			return driver;	
	  }
	 
	public static String trimString(String data,  int a, int b)
	{
		data = data.substring(a, b);
	    System.out.println(data);
	    return data;
	}
	
	public String getResPersNumberFromResPage(String data)
	{
		String persNo = null;
		String s = data;
		char c ='|'; //character c is static...can be modified to accept user input
		int count=0;
		for(int i=0;i<s.length();i++)
	       {
	    	   if(s.charAt(i)==c)
	    	   {
	    		   count=count+1;
	    		   if(count==4)
	    		   {
		    		   String secondpart =  s.substring(i, s.length());
		    		   persNo =  secondpart.substring(2,10);
		    		   break;
	    		   }
	    	   }
	       }
		
	    return persNo;
	}
	
	
	public String getRRDDUDetails(String data)
	{
		String rrdDU = null;
		String s = data;
		char c ='|'; //character c is static...can be modified to accept user input
		int count=0;
		for(int i=0;i<s.length();i++)
	       {
	    	   if(s.charAt(i)==c)
	    	   {
	    		   count=count+1;
	    		   if(count==5)
	    		   {
		    		   String secondpart =  s.substring(i, s.length());
		    		   rrdDU =  secondpart.substring(5,10);
		    		   break;
	    		   }
	    	   }
	       }
		
	    return rrdDU;
	}
	
	public String getResLocationFromResPage(String data)
	{
		String resLocation = null;
		String s = data;
		char c ='|'; //character c is static...can be modified to accept user input
		int count=0;
		for(int i=0;i<s.length();i++)
	       {
	    	   if(s.charAt(i)==c)
	    	   {
	    		   count=count+1;
	    		   if(count==2)
	    		   {
		    		   String secondpart =  s.substring(i, s.length());
		    		   resLocation =  secondpart.substring(2,6);
		    		   break;
	    		   }
	    	   }
	       }
		
	    return resLocation;
	}
	
	public String getResEmpIDFromResPage(String data)
	{
		String empid = null;
		String s = data;
		char email ='|';
		char at ='@'; //character at is static...can be modified to accept user input
		int count1=0;
		for(int i=0;i<s.length();i++)
	       {
	    	   if(s.charAt(i)==email)
	    	   {
	    		   count1=count1+1;
	    		   if(count1==9)
	    		   {
		    		   String part2 =  s.substring(i, s.length());
		    		   String part3=part2.substring(13, part2.length());
		    		   for(int j=0;j<part3.length();j++)
		    	       {
		    	    	   if(part3.charAt(j)==at)
		    	    	   {
		    	    		   empid = part3.substring(0, j);
		    	    		   break;
		    	    	   }
		    	       }
		    		   break;
	    		   }
	    	   }
	       }
	    return empid;
	}
	@FindBy(xpath=".//*[@id='overdueTab']/div[1]") public WebElement overdueTab;

	public WebDriver overdueTab(WebDriver driver, String path, ExtentTest logger, ElementFactory ef) throws InterruptedException
	{
		 
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(overdueTab));
		TakeScreenshot.captureScreenshots(driver, "overdueTab", path);
		overdueTab.click();
		return driver;

	}
}
