package com.Utility;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.testng.TestNG;
import org.xml.sax.SAXException;

public class Listener {
	protected static ConfigReader config = new ConfigReader();
	public static String excelReportName = "ExcelReport.xlsx";
	static int flag=0;
	public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException {
		
		if((config.getAppUrl().contains("ciostage"))||(config.getAppUrl().contains("ciotest")))
		{
			boolean sanityStatus = sanity(".\\testng-Dev.xml"); // Run Stage / Test Automation Sanity Suite
			if(sanityStatus)
			{
				SendMailWithAttachment.email();// Email sent with Sanity Pass Report as attachment
				flag=0;
				runXML(".\\testng.xml"); // Run Stage / Test Automation Regression Suite
			}
			else
				SendMailWithAttachment.email();// Email sent with Sanity Fail Report as attachment
		}
		else
				runXML(".\\testng.xml"); // Run Dev Sanity Automation Suite
	}		
	
	public static boolean sanity(String xmlName) throws SAXException, IOException, ParserConfigurationException {

		flag=1;
		TestNG testng = new TestNG();
		List<String> suites = new ArrayList<String>();
		suites.add(xmlName);//path to xml..
		testng.setTestSuites(suites);
		testng.run();
		new ExcelReportGenerator().generateExcelReport(excelReportName); // Generate Excel Report
		
		if((ReadExcel.reportStatus=="Pass")||(ReadExcel.reportStatus=="Fail"))
		{
			suites.clear();
			return true;
		}
		else
			
			return false;
	}	
	
	public static void runXML(String xmlName) throws SAXException, IOException, ParserConfigurationException {

		TestNG testng = new TestNG();
		List<String> suites = new ArrayList<String>();
		suites.add(xmlName);//path to xml..
		testng.setTestSuites(suites);
		testng.run();
		new ExcelReportGenerator().generateExcelReport(excelReportName); // Generate Excel Report

		SendMailWithAttachment.email();// Email sent with xml Report as attachment
		suites.clear();

	}
	
}
