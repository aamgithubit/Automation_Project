package handling_frameswithoutusing_switchto;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class checklistbox_sortedornot {
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
	public static boolean withoutsortmethod(String[] array1) {
		String[] array= {"abhi","kale","ram","abhis","kale"};
		for(int i=0;i<array.length;i++) 
		{
			if(array[i-1].compareTo(array[i])>0)
			{
				return false;
				
			}
		}
		return true;
		
	}
}
