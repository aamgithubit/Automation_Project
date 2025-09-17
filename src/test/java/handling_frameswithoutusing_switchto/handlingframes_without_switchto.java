package handling_frameswithoutusing_switchto;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class handlingframes_without_switchto {
	WebDriver driver;
	@BeforeTest
	public void setbrowser() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\msilocal\\Downloads\\Drivers&jars\\chromedriver\\chromedriver.exe");
		driver= new ChromeDriver();
	}
	@AfterTest
	public void quitbrowser() {
		driver.quit();
		
	}

	
	@Test
	public void testframes() {
		 WebDriver driver= new ChromeDriver();
		 driver.get("https://the-internet.herokuapp.com/upload");
		 
		 //old approach
		 WebElement framele= driver.findElement(By.xpath("input[id='file-upload']"));
		 driver.switchTo().frame(framele);
		 driver.navigate().back();
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 
		 // without using switch to method instead of it we can use explicit wait and its conditions or method.
		 
		 WebDriverWait explicitwait= new WebDriverWait(driver, 10);
		 explicitwait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(framele));
		 
		 // now perform actions
		 WebElement ele= driver.findElement(By.xpath(null));
		 ele.click();

		 
	}
}
