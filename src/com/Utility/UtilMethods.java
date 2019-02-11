package com.Utility;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class UtilMethods {
	static SoftAssert softly = new SoftAssert();
	public static String rootDirPath = System.getProperty("user.dir");
	public static ConfigReader config = new ConfigReader();
	
	
	public static void clickOn(ExtentTest logger,WebElement we,String elementName) {
		
		      
		
        try {
        		we.click();
        		logger.log(LogStatus.INFO, "Clicked on "+elementName);
        		
        		System.out.println("Clicked on "+elementName);
        	} catch (Exception e) {
        		e.printStackTrace();
        		System.out.println(e.getMessage());
        		System.out.println(e.getCause());
        		logger.log(LogStatus.INFO,  "Failed to click on <b style='color:red'> "+elementName+"<br>");
        	}
}
	

	public static void setText(ExtentTest logger,WebElement we, String data){
        try {
    		we.sendKeys(data);      
    		logger.log(LogStatus.INFO, "Keys sent as: "+data);
      } catch (Exception e) {
     	 	e.printStackTrace();
     	 	System.out.println(e.getMessage());
     	 	System.out.println(e.getCause());
     	 	logger.log(LogStatus.FAIL,  "Failed to send keys <b style='color:red'> " + data+"<br>");
      }
	} 

//keep it in Util
	
public static boolean verifyElementByXpath(ExtentTest logger,WebElement object)
	{ 
	    try{
	    	if(object.isDisplayed())
	    	{
	    		//System.out.println("The Object is present ");
	    		logger.log(LogStatus.INFO,  "WebElement is displayed");
	    		return true;
	    	}		
	      }catch(Exception e)
	    	{
				logger.log(LogStatus.INFO,  "Failed: Element  <b>"+object+"</b> not displayed due to <b style='color:red'>"+e.getClass()+"<br>"+e.getMessage()+"</b>");
				e.printStackTrace();
				System.out.println(e.getMessage());
				System.out.println(e.getCause());
	        }
		return false;
	} 

public static WebDriver driverWait( WebDriver driver, WebElement element) {
	
		new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(element));
	  new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(element));
	    return driver;
}


public static boolean checkDropdownValues( WebDriver driver,  List <WebElement> dropdown, String exp[], ExtentTest logger, String method) {

	new WebDriverWait(driver, 120).until(ExpectedConditions.visibilityOfAllElements(dropdown));
	int i;
	int j=0;
	int b=0;
	String Expected = null;
	if(exp.length==dropdown.size())
	{
		  for (i=0; i<exp.length; i++)
		  {
			  for (int k=0; k<dropdown.size(); k++)
			  {
			 	 Expected = exp[i];
			 	 String Actual = dropdown.get(k).getText();
			 	   if (Actual.equalsIgnoreCase((Expected)))
			      {	
					  break;
			      }
			      else
			      {
			    	  j=j+1;// Matched
			    	  continue;
			      }

			 	   
			  }
		 	  if (j==dropdown.size())
			  {
					System.out.println("Dropdown value Not matched for: "+Expected);
					logger.log(LogStatus.FAIL, "Dropdown value Not matched for: "+Expected);
					b=b+1;
			  }
			  else
			  {
					System.out.println("Dropdown value matched for: "+Expected);
					logger.log(LogStatus.PASS, "Dropdown value matched for: "+Expected);
					
			  }
		 	  j=0;
		  }
		  
	}
		  
	  if (b!=0)
	  {
			System.out.println("Dropdown value not Mached for "+b+" Dropdown Values");
			logger.log(LogStatus.FAIL, "Dropdown value not Mached for "+b+" Dropdown Values");
			return false;
	  }
	  else
	  {
			System.out.println("Dropdown value Mached for "+dropdown.size()+" Dropdown Values");
			logger.log(LogStatus.PASS, "Dropdown value Mached for "+dropdown.size()+" Dropdown Values");
			return true;
	  }

}

public static void waitTillElementIsVisible(ExtentTest logger,WebDriver driver, WebElement object )
{                   
        try {
              WebDriverWait wait=new WebDriverWait(driver,100);
              //logger.log(LogStatus.INFO,  "Wait upto <b>60 Seconds </b>");
              wait.until(ExpectedConditions.visibilityOf(object));      
              //logger.log(LogStatus.INFO,  "Wait till <b>"+object+" </b>[Object] clikable is Success");
            
      } catch (Exception e) {
    	  		System.out.println(e.getMessage());
            	e.printStackTrace();
            	logger.log(LogStatus.INFO,  "Failed: Wait till element is visible <b>"+object+"</b>");
      } 
              
  } 

public static void waitTillElementIsVisible(ExtentTest logger,WebDriver driver, WebElement object,String elementName)
{                   
        try {
              WebDriverWait wait=new WebDriverWait(driver,100);
       //       logger.log(LogStatus.INFO,  "Wait upto <b>30 Seconds </b>");
              wait.until(ExpectedConditions.visibilityOf(object));      
              //logger.log(LogStatus.PASS,  "Wait till <b>"+elementName+" </b> clickable is Success");
              System.out.println("Wait till "  +elementName+ " clickable is Success");
      } catch (Exception e) {
            e.printStackTrace();
            logger.log(LogStatus.INFO,  "Failed: Wait till element is visible : <b style='color:red'> "+elementName+"<br>");
      } 
              
       } 


public static void  Sorting(ExtentTest logger,WebDriver driver, List<WebElement> sortingElement,WebElement filterIcon, WebElement filterIcon1 ) throws InterruptedException {
    List<String> randomElement = new ArrayList<String>();
    List<String> randomElementAfterOneClick = new ArrayList<String>();
    List<String> randomElementAfterTwoClick = new ArrayList<String>();
      
      
      
      System.out.println("size:::::::::::::::::;;"+sortingElement.size());
      
      for (WebElement element : sortingElement){
            randomElement.add(element.getText());
            //System.out.println(element.getText());
      }
      
      Collections.sort(randomElement);
      
      for (String element : randomElement){
            
            //System.out.println(element);
      }
      
     filterIcon.click();
     Thread.sleep(5000);
      System.out.println("size:::::::::::::::::;;"+sortingElement.size());
      for (WebElement element : sortingElement){
            randomElementAfterOneClick.add(element.getText());
            //System.out.println(element.getText());
      }
      
      if(randomElement.equals(randomElementAfterOneClick)){
            //System.out.println("elements are in ascending order");
            softly.assertTrue(true);
      }
//System.out.println("size:::::::::::::::::;;"+sortingElement.size());
      
      
      Collections.sort(randomElementAfterOneClick, Collections.reverseOrder());
      
      
/*      for (String element : randomElementAfterOneClick){
            
            System.out.println(element);
      }
      */
      
      filterIcon1.click();
      Thread.sleep(5000);
      System.out.println("size:::::::::::::::::;;"+sortingElement.size());
      
      for (WebElement element : sortingElement){
            randomElementAfterTwoClick.add(element.getText());
            System.out.println(element.getText());
      }
      
      if(randomElementAfterOneClick.equals(randomElementAfterTwoClick)){
            System.out.println("elements are in desecnding order");
      }
      
      
}     



public static WebDriver validationOfExcelFirstRowColumns(WebDriver driver, String path,ExtentTest logger ,String [] expectedData ,String [] actualData) {
    
    driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
    File file = new File(
                "path");
    if (file.exists()) {
          System.out.println("File Exists");
    }
    BufferedReader bufRdr = null;
    String line = null;
    try {
          if (bufRdr == null && file !=null) {
                bufRdr = new BufferedReader(new FileReader(file));
                
          //bufRdr = new BufferedReader(new FileReader(file));
          if((line = bufRdr.readLine()) != null) {
                line.trim();
                String [] st = line.split(",");
                actualData = Arrays.copyOf(actualData, st.length);
                actualData = st;
          }
          boolean flag = true;
          for(int i = 0 ; i<actualData.length; i++) {
                if (!expectedData[i].trim().equalsIgnoreCase(actualData[i].trim().replace("\"", ""))) {
                      System.out.println("File column header is diferent than expected..");
                      System.out.println("expected data:"+expectedData[i]+" Actual file data:"+actualData[i]);
                      flag = false;
                      break;
                } 
          }
          if(flag){
                System.out.println("Data comparison for column header is sucessful.");
          }
          
          }
    }
          catch (IOException e) {
          e.printStackTrace();
    } finally {
          if(bufRdr !=null){
                try {
                      bufRdr.close();
                } catch (IOException e) {
                      e.printStackTrace();
                }
          }
    }
    return driver;
    
    
}

public static String parentHandle; 
public static  String getParentWindowHandle(ExtentTest logger,WebDriver driver)
{
     try
     {
           String parentHandle = driver.getWindowHandle();
           //System.out.println(parentHandleer);
           logger.log(LogStatus.PASS,  "The parent window handler is <b>"+parentHandle+"</b> Success");
           return parentHandle;
     }catch(Exception e)
     {
          // util.screenShotAndErrorMsg(logger, e, driver, "getParentWindowHandle");  
    	 
    	 logger.log(LogStatus.INFO,  "parent");
     }
     return "";
}


public static  void switchToChildWindow(ExtentTest logger,WebDriver driver,String parentHandle)
{
     try {            
           Thread.sleep(5000);
           for (String winHandle : driver.getWindowHandles())
           {     
                if (!winHandle.equals(parentHandle)) { 
                      driver.switchTo().window(winHandle);
                      logger.log(LogStatus.PASS,  "Swiching to child window is  Success");
                }
           }
     }                
     catch (Exception e) 
     {                     
    	 
    	 logger.log(LogStatus.INFO,  "parent"); 
     }
}


public static void switchToParentWindowHandle(ExtentTest logger,WebDriver driver,String parentHandle)
{
     try{ 
           //System.out.println("Switching back to parent Window-----------");
           driver.switchTo().window(parentHandle);     
           logger.log(LogStatus.PASS,  "Swiching to parent window <b>"+parentHandle+"</b>is  Success");
           //System.out.println("Switching back to parent Window");
     }catch(Exception e)
     {
    	 
    	 logger.log(LogStatus.INFO,  "parent");
     }          
}

public static boolean isClickable(ExtentTest logger,WebDriver driver,WebElement element) {
    try {
           new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(element));
           logger.log(LogStatus.PASS, "The element is clickable");
           return true;
    } catch (Exception e) {
           logger.log(LogStatus.FAIL, "The element is not clickable");
           return false;
    }
}

public static boolean isAttributePresent(ExtentTest logger,WebDriver driver, WebElement element, String attribute) {
    Boolean result = false;
    String value = element.getAttribute(attribute);

    if (value != null) {
           result = true;
           logger.log(LogStatus.PASS, "The attribute is present");
    } else {
           logger.log(LogStatus.FAIL, "The attribute is not present");
    }

    return result;
}

public static boolean checkFiltersORFields(WebDriver driver,  List <WebElement> dropdown, String exp[], ExtentTest logger, String method,int size) {

	new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOfAllElements(dropdown));
	int i;
	int j=0;
		  for (i=0; i<size; i++)
		  {
		 	 String Expected = exp[i];
		 	 String Actual = dropdown.get(i).getText();
		 	 System.out.println(Expected);
		 	 System.out.println(Actual);
		 	   if (Actual.equals(Expected))
		      {	
		 		   System.out.println("Matched");
		    	  j=j+1;
		      }
		      else
		      {
		    	  int b=i+1;
		    	  logger.log(LogStatus.FAIL,  "Not Matched on "+b+" Expected-"+exp[i]+" and Actual- "+dropdown.get(i).getText());
		    	  continue;
		      }
		    }
		  if (j==size)
		  {
				System.out.println("Matched "+j+"/"+size+" Filters"+" For "+method);
				logger.log(LogStatus.PASS, "Matched "+j+"/"+size+" Filters"+" For "+method);
				return true;
		
		  }
		  else
		  {
				System.out.println("Matched "+j+"/"+size+" Filters"+" For "+method);
				logger.log(LogStatus.FAIL, "Matched "+j+"/"+size+" Filters"+" For "+method);
				return false;
		  }
}

public static boolean waitTillPopUpIsVisible(ExtentTest logger,WebDriver driver, WebElement object )
{                   
        try {
              
              object.isDisplayed();     
              logger.log(LogStatus.PASS,  "Wait till <b>"+object+" </b>[Object] clikable is Success");
              return true;
        	} 
        catch (Exception e)
        	{
               	return false;
        	} 
} 
  
  public static boolean isAlertPresents(ExtentTest logger,WebDriver driver) throws InterruptedException 
  {	
		int sec=0;
		   while(+sec++<60)
		   {
		        try
		        {
		            driver.switchTo().alert();
		            logger.log(LogStatus.INFO, "Alert present : "+driver.switchTo().alert().getText());
			  		return true;
		        }catch(NoAlertPresentException e)
		        {
		        	Thread.sleep(1000);
		        	System.out.println("Waiting for pop : "+sec);
		        	
		        }
		   }
		   logger.log(LogStatus.INFO, "Alert not present");
   		   return false;
	  	
	}
  public static void CheckExistingFile(String filename, ExtentTest logger ) throws IOException {
      //get current project path
      String filePath = System.getProperty("user.dir");
      //create a new file
      File file = new File(filePath + "\\" + filename);
      if (file.exists()) 
	  {
	      //delete a file
		  file.delete();
	      System.out.println(filename+" File was already exist, File Deleted");
	      logger.log(LogStatus.INFO, filename+" File was already exist, File Deleted");
	  }
  }
//Delete a file
  public static void CreateAFile(String filename,ExtentTest logger ) {
      //get current project path
      String filePath = System.getProperty("user.dir");
      //create a new file
      File file = new File(filePath + "\\" + filename);
      try {
              file.createNewFile();
              System.out.println(filename+" File is created");
              logger.log(LogStatus.INFO, "File is created");

      } catch (IOException e) {
          logger.log(LogStatus.INFO, e.getMessage());
          e.printStackTrace();
      }
  }
  

  public static void createTXT(String passPercentage,ExtentTest logger ) {
	  
	  String fullyPassed = config.getLimit();
	  float fullPass = Float.parseFloat(fullyPassed);
	  float actualPass = Float.parseFloat(passPercentage);
	  
	  try {
		CheckExistingFile("success.txt", logger);
	} catch (IOException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	  try {
		CheckExistingFile("fail.txt", logger);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  
	  
	  try {
		if (actualPass > fullPass) 
		{
			CreateAFile("success.txt", logger);
		} else {
			CreateAFile("fail.txt", logger);
		} 
	} catch (Exception e) {
		// TODO: handle exception
	     logger.log(LogStatus.INFO, e.getMessage());
	     e.printStackTrace();
	}
	  
	  
  }
  
  
  
  public static void waitForListLoading(WebDriver driver, ExtentTest logger, List<WebElement> object, String elementName) 
	{
		try {
          WebDriverWait wait=new WebDriverWait(driver,100);
          wait.until(ExpectedConditions.visibilityOfAllElements(object));      
          System.out.println("Wait till "  +elementName+ " list loading is Success");
	    } catch (Exception e) {
	          e.printStackTrace();
	          logger.log(LogStatus.FAIL,  "Failed: Wait for list loading : <b style='color:red'> "+elementName+"<br>");
	    }        
   } 

  
  
  public static void deleteAllScreenshots() 
	{

	  	try {
			ReadExcel.eraseValues();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			System.out.println("Error erasing prev. results values.");
		}
        //String path= System.getProperty("user.dir")+"/Screenshots/";
        
        Path dir = Paths.get(System.getProperty("user.dir")+"/Screenshots/");
        try
        {
        	System.out.println("Deleting Old Screenshots, Please wait....");
            Files.walkFileTree(dir, new SimpleFileVisitor<Path>()
            {
            	
                  @Override
                  public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)
                          throws IOException
                  {
                      //System.out.println("Deleting file: " + file);
                      Files.delete(file);
                      return FileVisitResult.CONTINUE;
                  }
              
                  @Override
                  public FileVisitResult postVisitDirectory(Path dir,
                          IOException exc) throws IOException
                  {
                      //System.out.println("Deleting dir: " + dir);
                      if (exc == null) {
                          Files.delete(dir);
                          return FileVisitResult.CONTINUE;
                      } else {
                          throw exc;
                      }
                   }
  
                });
            System.out.println("Old Screenshots deleted!");
        }
        catch (IOException e)
        {
          System.out.println("Screenshots already deleted....");
        }
    
	}
}
