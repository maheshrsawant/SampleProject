package com.PageFactory;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ElementFactory {
	public static String dataPath = System.getProperty("user.dir")+"/Testdata.xlsx";
	public static String Failure = System.getProperty("user.dir")+"/Screenshots/Failure/";
	public static String Skipped = System.getProperty("user.dir")+"/Screenshots/Skipped/";
	public static String Passed = System.getProperty("user.dir")+"/Screenshots/Passed/";
	//Screenshots path
	public static String demandDetailsPath1 = System.getProperty("user.dir")+"/Screenshots/DemandDetails/TC01/DemandDetails_";
	// Home Page Webelements
	@FindBy(xpath=".//*[@id='NavigatetoDemand']/a") public static WebElement demandTab;

	
	}
