package com.Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class WriteExcelSheet {
	
@Test
	public static  void writeExcel(String sheet,String val,int row,int column) throws IOException
	{
	FileInputStream fsIP= new FileInputStream(new File(System.getProperty("user.dir")+"/Testdata.xlsx")); //Read the spreadsheet that needs to be updated
    
    XSSFWorkbook wb = new XSSFWorkbook(fsIP); //Access the workbook
      
    XSSFSheet newsheet = wb.getSheet(sheet);//Access the worksheet, so that we can update / modify it.
      
    // String val="Test";
   XSSFRow rownew = newsheet.getRow(row);
          if (rownew == null)
          {
          rownew = newsheet.createRow(row);
          }
          XSSFCell cell1 = rownew.getCell(column);
          if (cell1 == null)
          {
                  cell1 = rownew.createCell(column);
          }
          
          cell1.setCellValue(val);
         
    fsIP.close(); //Close the InputStream
     
    FileOutputStream output_file =new FileOutputStream(new File(System.getProperty("user.dir")+"/Testdata.xlsx"));  //Open FileOutputStream to write updates
      
    wb.write(output_file); //write change
      
    output_file.close();  //close the stream
	}
}
    