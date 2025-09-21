package com.testcases;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


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
	public static ExtentReports extent;
    public static ExtentTest test;

	

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
	
    @BeforeSuite
    public void startReport() {
        ExtentSparkReporter reporter = new ExtentSparkReporter("test-output/ExtentReport.html");
        reporter.config().setReportName("Automation Test Report");
        reporter.config().setDocumentTitle("Extent Report");

        extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("OS", System.getProperty("os.name"));
        extent.setSystemInfo("Tester", "Abhishek");
    }

    @AfterSuite
    public void endReport() {
        extent.flush();
    }
}

