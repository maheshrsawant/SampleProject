package com.Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import com.PageFactory.ElementFactory;
import com.Utility.TakeScreenshot;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.Utility.ConfigReader;

public class ReadExcel {
	public static ConfigReader config = new ConfigReader();
	public TakeScreenshot takescreenshot;
	public static XSSFSheet ExcelWSheet;
	public static XSSFWorkbook ExcelWBook;
	public static XSSFCell Cell;
	public static XSSFRow Row;
	public static String  reportStatus="Fail";
	public static FileInputStream fis;

	public static String getData(String Sheet1, int row, int column)
	{
		
		try {
			fis = new FileInputStream(ElementFactory.dataPath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			ExcelWBook = new XSSFWorkbook(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ExcelWSheet = ExcelWBook.getSheet(Sheet1);
		String data =ExcelWSheet.getRow(row).getCell(column).getStringCellValue();
		return data;
	}
	
	public static int getIntegerData(String Sheet1, int row, int column)
	{

		try {
			fis = new FileInputStream(ElementFactory.dataPath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			ExcelWBook = new XSSFWorkbook(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ExcelWSheet = ExcelWBook.getSheet(Sheet1);
		int data =(int)ExcelWSheet.getRow(row).getCell(column).getNumericCellValue();
		return data;
	}

	//This method is to set the File path and to open the Excel file, Pass Excel Path and Sheetname as Arguments to this method
	 
		public void setExcelFile(String Path,String SheetName) throws Exception {

				try {

	   			// Open the Excel file

				FileInputStream ExcelFile = new FileInputStream(Path);

				// Access the required test data sheet

				ExcelWBook = new XSSFWorkbook(ExcelFile);

				ExcelWSheet = ExcelWBook.getSheet(SheetName);

				} catch (Exception e){

					throw (e);

				}

		}
		
		public void setCellData(String Result,  int RowNum, int ColNum) throws Exception	{
			 
				try{

	  			Row  = ExcelWSheet.getRow(RowNum);

				//Cell = Row.getCell(ColNum, Row.RETURN_BLANK_AS_NULL);

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
		
		
	 public static double passCount=0, failCount=0, skipCount=0;
	 public static int pathCount=0;
	 public static void writeResultExcel(String tcName, String status, String moduleName, String path) throws Exception 
		
		{
			if(status.equalsIgnoreCase("pass"))
				passCount=passCount+1;
				if(status.equalsIgnoreCase("Fail"))
				{
					failCount=failCount+1;
					TestNGCreation.failureScreenshotpath[pathCount]=path;
					TestNGCreation.stringInDocument[pathCount]=moduleName+" : "+tcName;
					//System.out.println(TestNGCreation.failureScreenshotpath[pathCount]);
					//System.out.println(pathCount);
					//System.out.println(TestNGCreation.stringInDocument[pathCount]);
					pathCount=pathCount+1;
				}
					if(status.equalsIgnoreCase("Skip"))
						skipCount=skipCount+1;
					
/*		  setExcelFile(ElementFactory.dataPath, "MasterResult");
			int j=0;
			for(int i=1; i>=0; i++)
			{
					String expectedTcName = getData("MasterResult",i,j); 
					if(tcName.equals(expectedTcName))
							{
								int b=j+1;
								WriteExcelSheet.writeExcel("MasterResult",TakeScreenshot.timestamp(),i,b);
								int c=j+2;
								WriteExcelSheet.writeExcel("MasterResult",status,i,c);
								int m=j+3;
								WriteExcelSheet.writeExcel("MasterResult",moduleName,i,m);
								

								break;
							}
					else
					{
						continue;
					}
					
			}*/
			
		}

	 public void clearContents() throws Exception
		{
		 ExcelWSheet = ExcelWBook.getSheet("MasterResult");
		 	setExcelFile(ElementFactory.dataPath, "MasterResult");
		 	//int rowCount = sheet.getLastRowNum()-sheet.getFirstRowNum();
		 	System.out.println("Erasing Previous Results, Please wait...");
		 	 //Clear all contents on Date and Time column
			 for(int i=1; i<=200; i++)
			 {
				 String currentValue = getData("MasterResult",i,1); 
					if(currentValue!=null)
							{
								WriteExcelSheet.writeExcel("MasterResult","",i,1);
							}
			 }
			 
		 	 //Clear all contents on "Result" column
			 for(int i=1; i<=200; i++)
			 {
				 String currentValue = getData("MasterResult",i,2); 
					if(currentValue!=null)
							{
								WriteExcelSheet.writeExcel("MasterResult","",i,2);
							}
			 }
			 
			System.out.println("Previous Results Erased successfully...");
		}

	 public static double totalCount=0;
	 public static double totalCountpassfail=0;
	 public static float testResultsCalculation() throws Exception
		{
		 totalCount=passCount+failCount+skipCount;
		 totalCountpassfail=passCount+failCount;
		 System.out.println("::::::::::::::::::::::[Test Summary]::::::::::::::::::::::");	
		 float passPercentage;
		 passPercentage = (float) (passCount * 100/ totalCountpassfail);
		 System.out.println("PassPercentage:"+passPercentage);

		 return passPercentage;
		 
		}
	 public static void eraseValues() throws Exception
		{
		 totalCount=0; totalCountpassfail=0;passCount=0;failCount=0; skipCount=0; totalCount=0;
		 
		}
	 
	 public static boolean  createTXT(float passPercentage,ExtentTest logger ) throws IOException {
		  
		  String fullyPassed = config.getLimit();
		  float fullPass = Float.parseFloat(fullyPassed);
		  

			CheckExistingFile("success.txt", logger);

		
			CheckExistingFile("fail.txt", logger);

		  try {
			if (passPercentage >= fullPass) 
			{
				CreateAFile("success.txt", logger);
				reportStatus = "Pass";
			} else {
				CreateAFile("fail.txt", logger);
				reportStatus = "Fail";
			} 
		} catch (Exception e) {
			// TODO: handle exception
		     logger.log(LogStatus.INFO, e.getMessage());
		     e.printStackTrace();
		}
		   
		if (passPercentage < 100.00) 
				return true;
		else 
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

	      } catch (IOException e) {
	    	  System.out.println(e.getMessage());
	          e.printStackTrace();
	      }
	  }
	 
	 
	 
}
