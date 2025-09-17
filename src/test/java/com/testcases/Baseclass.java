package com.testcases;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;


public class Baseclass {

	static Properties pro;

	WebDriver driver;

/*

	public void reportconfig() throws IOException {
		pro = new Properties();

		File ippath= new File("C:\\SeleniumEclipse\\Automation_Project\\configuration\\config.properties");
		FileInputStream fis= new FileInputStream(ippath);
		pro.load(fis);
		//System.out.println(ippath.getPath());
		//pro.getProperty(geturl());
	}
Reportconfig reportconfig= new Reportconfig();
	*/
	

	@BeforeTest
	public void setup() {

		System.setProperty("webdriver.chrome.driver","C:\\Users\\msilocal\\Downloads\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	
	@AfterTest
	public void teardown() {

		driver.close();
	}
}

