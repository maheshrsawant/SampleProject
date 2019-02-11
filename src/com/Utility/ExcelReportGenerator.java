package com.Utility;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class ExcelReportGenerator extends TestNGCreation{

public void generateExcelReport(String destFileName) throws SAXException, IOException, ParserConfigurationException
	{
	
        String path = System.getProperty("user.dir");
		File xmlFile = new File("./test-output/testng-results.xml");
		
		DocumentBuilderFactory fact = DocumentBuilderFactory.newInstance();
		DocumentBuilder build = fact.newDocumentBuilder();
		Document doc = build.parse(xmlFile);
		doc.getDocumentElement().normalize();
		
		
		XSSFWorkbook book = new XSSFWorkbook();
		XSSFCellStyle fail = book.createCellStyle();
		XSSFCellStyle pass = book.createCellStyle();
		XSSFCellStyle skip = book.createCellStyle();
		
		
		NodeList test_list = doc.getElementsByTagName("suite");
		NodeList test_Results = doc.getElementsByTagName("testng-results");
		Node test_result_node = test_Results.item(0);
		String test_result_total = ((Element)test_result_node).getAttribute("total");
		String test_result_pass = ((Element)test_result_node).getAttribute("passed");
		String test_result_fail = ((Element)test_result_node).getAttribute("failed");
		String test_result_skip = ((Element)test_result_node).getAttribute("skipped");

		System.out.println("Total:"+test_result_total);
		System.out.println("Pass:"+test_result_pass);
		System.out.println("Fail:"+test_result_fail);
		System.out.println("Skip:"+test_result_skip);
	
		XSSFSheet sheet1 = book.createSheet("Test Results");
		XSSFRow row1 = sheet1.createRow(0);
		XSSFCell cel_total1 = row1.createCell(0);
		cel_total1.setCellValue("Total");
		XSSFCell cel_pass1 = row1.createCell(1);
		cel_pass1.setCellValue("Pass");
		XSSFCell cel_fail1 = row1.createCell(2);
		cel_fail1.setCellValue("Fail");
		XSSFCell cel_skip1 = row1.createCell(3);
		cel_skip1.setCellValue("Skip");
		
		
		XSSFRow row2 = sheet1.createRow(1);
		XSSFCell cel_total2 = row2.createCell(0);
		cel_total2.setCellValue(test_result_total);
		XSSFCell cel_pass2 = row2.createCell(1);
		cel_pass2.setCellValue(test_result_pass);
		XSSFCell cel_fail2 = row2.createCell(2);
		cel_fail2.setCellValue(test_result_fail);
		XSSFCell cel_skip2 = row2.createCell(3);
		cel_skip2.setCellValue(test_result_skip);
		
		
		for(int i=0;i< test_list.getLength(); i++)
		{
			int r=0;
			Node test_node = test_list.item(i);
			String test_name = ((Element)test_node).getAttribute("name");
			XSSFSheet sheet = book.createSheet(test_name);
			NodeList class_list = ((Element)test_node).getElementsByTagName("class");
			
			for(int j=0;j< class_list.getLength(); j++ )
			{
				Node class_node = class_list.item(j);
				String class_name = ((Element)class_node).getAttribute("name");
				NodeList test_method_list = ((Element)class_node).getElementsByTagName("test-method");
				
				for(int k=0;k< test_method_list.getLength(); k++ )
				{
					Node test_method_node = test_method_list.item(k);
					if(!((Element)test_method_node).getAttribute("is-config").equals("true"))
					{
						String test_method_name = ((Element)test_method_node).getAttribute("name");
						String test_method_status = ((Element)test_method_node).getAttribute("status");
	
						fail.setFillForegroundColor(HSSFColor.RED.index);
						pass.setFillForegroundColor(HSSFColor.BRIGHT_GREEN.index);
						skip.setFillForegroundColor(HSSFColor.YELLOW.index);
						
						fail.setFillPattern(FillPatternType.SOLID_FOREGROUND);
						pass.setFillPattern(FillPatternType.SOLID_FOREGROUND);
						skip.setFillPattern(FillPatternType.SOLID_FOREGROUND);

						XSSFRow row = sheet.createRow(r++);
						XSSFCell cel_name1 = row.createCell(0);
						cel_name1.setCellValue(class_name);
						XSSFCell cel_name2 = row.createCell(1);
						cel_name2.setCellValue(test_method_name);
						XSSFCell cel_status = row.createCell(2);
						cel_status.setCellValue(test_method_status);
						
						if("pass".equalsIgnoreCase(test_method_status))
						{
							cel_status.setCellStyle(pass);
						}
						if("fail".equalsIgnoreCase(test_method_status))
						{
							cel_status.setCellStyle(fail);
						}
						if("skip".equalsIgnoreCase(test_method_status))
						{
							cel_status.setCellStyle(skip);
						}
						
						XSSFCell cel_exp;
						String exp_msg;

						if("fail".equalsIgnoreCase(test_method_status))
						{
							NodeList exp_list =((Element)test_method_node).getElementsByTagName("exception");
							Node exp_node = exp_list.item(0);
							exp_msg = ((Element)exp_node).getAttribute("class");
							
							cel_exp = row.createCell(3);
							cel_exp.setCellValue(exp_msg);
							
							
							
						}
						
					}
					
				}
				
				
			}
			
			
		}
		
		FileOutputStream fout = new FileOutputStream(path +"/test-output/ExtendReports/"+destFileName);
		book.write(fout);
		fout.close();
		System.out.println("Excel Report Generated Successfully");
	
	}

}