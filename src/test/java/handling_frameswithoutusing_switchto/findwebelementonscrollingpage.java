package handling_frameswithoutusing_switchto;

import java.util.List;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class findwebelementonscrollingpage {

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
	@Test()
	public void webelementonscrollingpage() {
		driver.get("http://booksbykilo.in/new-books");


		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		Actions act =new Actions(driver);
		WebElement book= driver.findElement(By.xpath(null));
		act.moveToElement(book).perform();
		// from above code it will get fails bcoz 
		//our element present at the last or in the middle so it will not check upto it
		// for that we use javascript executor
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		boolean bookfound=false;
		//here, !bookfound means true so while loop iterate
		//infintie time until the condition is true

		while(!bookfound)
		{
			List<WebElement> bookslist= driver.findElements(By.xpath(null));
			String actualbook= "title of book";
			for(WebElement eachbook: bookslist) 
			{
				if(eachbook.getText().equals(actualbook)) 
				{
					System.out.println("book found");
					bookfound=true;
					break;
				}
				//if actual book not founds on this page it will get scroll down and check for the book
				js.executeScript("window.scrollBy(0, document.body.scrollHeight)");
			}
		}
	}
}
