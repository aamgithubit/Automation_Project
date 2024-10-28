package handling_frameswithoutusing_switchto;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class countwebelementofscrollingpage {
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
	public void firstway() {
		driver.get("http://booksbykilo.in/new-books");

		List<WebElement> allbook;
		JavascriptExecutor js= (JavascriptExecutor)driver;

		//capture all weblement in a list
		allbook= driver.findElements(By.xpath(""));
		js.executeScript("window.scrollBy(0, document.body.scrollHeight)");
		System.out.println(allbook.size());
		// by using above method we can get only first list of books which will show 
		//it doesnt show the scrolling books count


	}
	@Test
	public void secondway() {
		//create common xpath representing all the webelement

		driver.get("http://booksbykilo.in/new-books");

		//we can use javascriptexecutor for it
		JavascriptExecutor js= (JavascriptExecutor)driver;
		int previouscount=0;
		int currentcount=0;
		while(true) {
			List<WebElement> allbook= driver.findElements(By.xpath(""));
			currentcount=allbook.size();
			if(currentcount==previouscount) {
				break;
			}
			previouscount=currentcount;
			//scroll page till the end
			js.executeScript("window.scrollBy(0, document.body.scrollHeight)");
			/*
			  // second way to scroll page

			Actions act= new Actions(driver);
			act.sendKeys(Keys.END).perform();
			 */
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		}
		System.out.println("total no. of books: "+ currentcount);
		driver.quit();
	}
}
