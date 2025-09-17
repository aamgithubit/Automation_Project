package com.testcases;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.*;

public class BaseClass1 {
	

	static WebDriver driver;    
	static String screenshotName;

	@BeforeTest
	public void setup() {
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\msilocal\\Downloads\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		//rconfig.geturl("");
		
	}
	@AfterTest
	public void teardown() {
		driver.close();
}


	//	public void capturescreenshot() throws Exception {
	//
	//	//	TakesScreenshot ts= (TakesScreenshot)driver;
	//		File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	//		File dest= new File("C:\\SeleniumEclipse\\Automation_Project\\src\\main\\resources\\failedscreenshot" );
	//		
	//		try {
	//			Date d = new Date();
	//    		screenshotName = d.toString().replace(":", "_").replace(" ", "_") + ".jpg"; 
	//			FileUtils.copyFile(src, dest);
	//		} catch (Exception e) {
	//			
	//			e.printStackTrace();
	//					}
	//		System.out.println("screenshot saved successfully");
	//		}

	public static void captureScreenshot() {

		TakesScreenshot screenshot = (TakesScreenshot)driver;

		// Call method to capture screenshot
		File src = screenshot.getScreenshotAs(OutputType.FILE);

		try
		{
			Date d = new Date();
			screenshotName = d.toString().replace(":", "_").replace(" ", "_") + ".jpg";  
			FileUtils.copyFile(src,new File(System.getProperty("user.dir") + "\\reports\\" + screenshotName));
			System.out.println("Successfully captured a screenshot");
		} catch (IOException e) {
			System.out.println("Exception while taking screenshot " + e.getMessage());
		}

			
		//	if(formattedDate==null) {
		//		LocalDateTime myDateObj = LocalDateTime.now();
		//	    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		//	   formattedDate = myDateObj.format(myFormatObj);
		//
		//		}
	}}

