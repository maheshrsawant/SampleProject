package com.Utility;

import java.awt.Toolkit;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BrowserFactory {
	
	public WebDriver driver;
	ConfigReader config = new ConfigReader();

	public WebDriver startBrowser(String broswerName)
	{
		String os = System.getProperty("os.name").toLowerCase();
		System.out.println(os);
		
		if(broswerName.equalsIgnoreCase("chrome"))
		{	
			System.setProperty("webdriver.chrome.driver",config.getChromePath());
			driver = new ChromeDriver();
			System.out.println("Chrome Browser Opened Successfully");

			Toolkit toolkit = Toolkit.getDefaultToolkit();
			int Width = (int) toolkit.getScreenSize().getWidth();
			int Height = (int)toolkit.getScreenSize().getHeight();
			System.out.println(Width+"X"+Height);
			
			if(!os.equalsIgnoreCase("windows 10"))
			{
					try {
						driver.manage().window().maximize();
					} catch (Exception e) {
						System.out.println(e.getMessage());
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					try {
						driver.manage().window().fullscreen();
					} catch (Exception e) {
						System.out.println(e.getMessage());
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
			else
			{
				try {
					driver.manage().window().maximize();
				} catch (Exception e) {
					System.out.println(e.getMessage());
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		else if(broswerName.equalsIgnoreCase("firefox"))
		{

			FirefoxOptions options = new FirefoxOptions();
			options.setCapability("marionette", false);
			driver = new FirefoxDriver(options);
			System.out.println("Firefox Browser Opened Successfully");
			driver.manage().window().maximize();
		}
		else if(broswerName.equalsIgnoreCase("ie"))
		{
			System.setProperty("webdriver.ie.driver", config.getIEPath());
			DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
			capabilities.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
			driver = new InternetExplorerDriver(capabilities);
			System.out.println("IE Browser Opened Successfully");
			driver.manage().window().maximize();
		}
		
		driver.get(config.getAppUrl());
	
	
		
		return driver;
	}
	

}
