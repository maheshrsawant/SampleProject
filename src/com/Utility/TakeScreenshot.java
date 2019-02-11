package com.Utility;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import com.PageFactory.ElementFactory;

public class TakeScreenshot {
	
	WebDriver driver;
	static ConfigReader config;
	ElementFactory ef;
	BrowserFactory br = new BrowserFactory();
	public static String destinationPath;
	
	 public static String timestamp() 
		{
		 return new SimpleDateFormat("dd-MM-yyyy HH-mm-ss").format(new Date());
		}
	public static String captureScreenshots(WebDriver driver, String ScreenshotName, String PATH) 
	{
		 destinationPath = PATH+ScreenshotName+"_"+timestamp()+".png";
		try {
			  File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	          File dest= new File(destinationPath);
	          FileUtils.copyFile(scrFile, dest);  
	         // System.out.println(ScreenshotName+" Screenshot Taken");
		} catch (Exception e) {
			System.out.println("Exception while taking screen shot is: "+e.getMessage());
			if(e.getMessage().contains(("unexpected alert open"))) {
				
				try {
					takeALertScreenShot(driver, ScreenshotName, destinationPath);
				} catch (AWTException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
		return destinationPath;	
	
	}
	
	public static String takeALertScreenShot(WebDriver driver, String ScreenshotName, String PATH) throws AWTException, IOException 
	{
		// destinationPath = PATH+ScreenshotName+"_"+timestamp()+".png";
		
		Robot robot = new Robot();
		// create rectangle for full screenshot 
		Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
		// capture screen of the desktop 
		BufferedImage screenFullImage = robot.createScreenCapture(screenRect);
		// save the screenshot to local system 
		
		try {
			ImageIO.write(screenFullImage, "png", new File(destinationPath));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return destinationPath;	
	}
}
