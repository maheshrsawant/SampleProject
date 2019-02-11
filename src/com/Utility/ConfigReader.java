package com.Utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.testng.annotations.Test;

import com.Pages.LoginPage;

public class ConfigReader {

	Properties pro;
	FileInputStream fisE;
	Sheet datasheet;
	Workbook wb;
	public ConfigReader() {
		try {

			File src = new File("./configuration/config.property");
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		

		} catch (Exception e) {
			System.out.println("Exception is==="+e.getMessage());
		}

	}
	
	public String getChromePath()
	{
		return System.getProperty("user.dir")+pro.getProperty("chromeDriver");
	}
	
		
	public String getIEPath()
	{
		return System.getProperty("user.dir")+pro.getProperty("IEdriver");
	}
	
	public String getFirefoxPath()
	{
		return System.getProperty("user.dir")+pro.getProperty("firefoxDriver");
	}
	
	
	public String getAppUrl()
	{
		return pro.getProperty("ssaUrl");
	}
	public String getDevUrl()
	{
		return pro.getProperty("ssadevURL");
	}
	
	public String getMyUserName()
	{
		return pro.getProperty("MyuserName");
	}
	
	public String getMyPassword()
	{
		return pro.getProperty("Mypass");
	}
	
	public String getUserName()
	{
		return pro.getProperty("uName");
	}
	
	public String getpassword()
	{
		 String encodedPW = pro.getProperty("password");
		 String password = LoginPage.decryptedPassword(encodedPW);
		 System.out.println("Decrypted passwod is:" +password);
		 return password;
		//return pro.getProperty("pass");
	}
	public String getBrowserName()
	{
		return pro.getProperty("browserName");
	
	}
	
	
	//Mahesh Scripts
	public String getUrlDownInfo()
	{
		return pro.getProperty("urldown");
	}
	public String getUrlOkInfo()
	{
		return pro.getProperty("urlup");
	}
	
	
	public String getRejSSPath()
	{
		return pro.getProperty("RejectionPath");
	}
	public String getRefSSPath()
	{
		return pro.getProperty("RefusalPath");
	}
		
	//Test User ID configuration
	
	public String getUserAG()
	{
		return pro.getProperty("username_AG");
	}
	public String getUserDU()
	{
		return pro.getProperty("username_DU");
	}
	public String getUserCentral()
	{
		return pro.getProperty("username_Central");
	}
	public String getUserPSU()
	{
		return pro.getProperty("username_PSU");
	}
	
	public String getUserDMT()
	{
		return pro.getProperty("username_DMT");
	}
	
	
	public String transferQuery()
	{
		return pro.getProperty("TransferQuery");
	}
	
	public String getLimit()
	{
		return pro.getProperty("MinCutoffToCreateSuccessTxtFile");
	}
	//DB Connection

	public String getDBUrl()
	{
		if(pro.getProperty("ssaUrl").contains("ciodev"))
			{
				String dbURLPart1 = pro.getProperty("dbURL");
				//String dbEncPass = LoginPage.encryptedPassword("2dPPHPVT");
				String dbEncPass = getDBPassword();
				String dbDecpass = LoginPage.decryptedPassword(dbEncPass);
				String dburl = dbURLPart1+dbDecpass;
				System.out.println(dburl);
				return dburl;
			}
		else
			{
				return pro.getProperty("dbURL");
			}
		
	}
	
	public String getDBUserName()
	{
		return pro.getProperty("dbusername");
	}
	
	public String getDBPassword()
	{
		return pro.getProperty("dbEncodedPass");
	}
	
	// Test Type
	public String getTestingType()
	{
	
		return pro.getProperty("testingType");
	}
	
	public String getNoAccessUser()
	{
		return pro.getProperty("username_NoAccess");
	} 
	
	public String getUserTFS()
	{
		return pro.getProperty("username_TFS");
	}
}