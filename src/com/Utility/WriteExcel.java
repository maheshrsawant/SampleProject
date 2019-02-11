package com.Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteExcel {
	
	XSSFWorkbook wb;
	XSSFSheet sheet;
	File src;
	FileOutputStream fout;
	 
	public WriteExcel(String excePath)
	{
		
		try {
			File src = new File(excePath);
			FileInputStream fis = new FileInputStream(src);
			wb = new XSSFWorkbook(fis);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
	}
	
	public void setStringData(String Sheet1, int row, int column, String data)
	{
		sheet = wb.getSheet(Sheet1);
		sheet.getRow(row).createCell(column).setCellValue(data);
		try {
			fout = new FileOutputStream(src);
			wb.write(fout);
			wb.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void setIntegerData(String Sheet1, int row, int column, int data)
	{
		sheet = wb.getSheet(Sheet1);
		sheet.getRow(row).createCell(column).setCellValue(data);
		try {
			fout = new FileOutputStream(src);
			wb.write(fout);
			wb.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

 
	

}
