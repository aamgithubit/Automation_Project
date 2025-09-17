package com.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;

public class Testng {

	WebDriver driver;
	
	@Parameters("browsername")
	@BeforeTest	
	public void setup(String browsername) {


		if(browsername.equals("chrome")) {

			System.setProperty("webdriver.chrome.driver",
					"C:\\chromeDriver\\chromedriver.exe");
			driver= new ChromeDriver();
		}

		if(browsername.equals("firefox")) {

			System.setProperty("webdriver.gecko.driver", 
					"C:\\Users\\msilocal\\Downloads\\Drivers&jars\\geckodriver-v0.33.0-win64\\geckodriver.exe");
			DesiredCapabilities capabilities = DesiredCapabilities.firefox();
			capabilities.setCapability("marionette",true);
			driver= new FirefoxDriver(capabilities);
		}
		if(browsername.equals("edge")) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\chromeDriver\\chromedriver.exe");
			driver= new ChromeDriver();

		}

		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}	

	@Test(priority=-1)
	public void youtube() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://www.orangehrm.com/en/contact-sales/");
	}
	@Parameters({"username" , "pwd"} )
	@Test
	public void login(String username , String pwd) {
		
		driver.findElement(By.xpath("(//*[contains(@id, \"Form_getForm_FullName\")])[2]")).sendKeys("username");
		driver.findElement(By.xpath("(//*[contains(@id, \"Form_getForm_Contact\")])[2]")).sendKeys("pwd");
		driver.findElement(By.xpath("//*[contains(@id, \"Form_getForm_action_submitForm\")]")).click();	
	}
	@Test(enabled=false)
	public void qatest() {
		driver.get("https://www.flipkart.com/");
	}
	@AfterTest
	public void teardown() {
		driver.close();
	}
}