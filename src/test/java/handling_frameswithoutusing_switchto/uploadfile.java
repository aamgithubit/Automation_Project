package handling_frameswithoutusing_switchto;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class uploadfile {
	WebDriver driver;
	@BeforeTest
	public void setbrowser() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\msilocal\\Downloads\\Drivers&jars\\chromedriver\\chromedriver.exe");
		driver= new ChromeDriver();
	}
		
	@Test(enabled=false)
	public void testuploadfiles() {
		
		driver.get("https://the-internet.herokuapp.com/upload");

		WebElement upload= driver.findElement(By.cssSelector("input[id='file-upload']"));
	
		
		// Use JavaScriptExecutor to click the file input element
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", upload);

		// Specify the file path you want to upload
		String filePath = "C:\\Users\\msilocal\\Desktop\\Automation testing\\Advanced selenium Q & A"; 
		// Update this to the file you want to upload

		// Use sendKeys to set the file path (required for file uploads)
		upload.sendKeys(filePath);
		upload.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.cssSelector("input[class='button']")).submit();  

		// Optionally, check for the success message
		String successMessage = driver.findElement(By.xpath("//h3[contains(text(),'File Uploaded!')]")).getText();
		System.out.println("Success Message: " + successMessage);

	}
	@Test
	public void duplicatesitem() {
		
		driver.get("https://testautomationpractice.blogspot.com/");
		WebElement listboxele=driver.findElement(By.xpath("//select[@id='animals']"));
		Select listbox= new Select(listboxele);
		
		Set<String>uniqueitem= new HashSet<String>();
		
		for(WebElement options:listbox.getOptions()) {
			String option= options.getText();
			System.out.println(option);
			if(uniqueitem.add(option)) {
				System.out.println("duplicate not found" + option);
			}
			else {
				System.out.println("duplicate  found" + option);

			}
		}
		
	}
	@AfterTest
	public void quitbrowser() {
		driver.quit();
		
	}

}

