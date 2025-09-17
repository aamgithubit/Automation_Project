package dynamicwebtablewithpagenavigation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class dynamicwebtablewithpagenavigation {
WebDriver driver;
	@BeforeTest
	public void staticwebtable() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver",

				"C:\\Users\\msilocal\\Downloads\\Drivers&jars\\chromedriver\\chromedriver.exe");

			

		Thread.sleep(2000);
		driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	}

	@Test
	public void table1()
	{
		driver.get("https://demo.opencart.com/admin/index.php?route=sale&user_token=8eeeb73ab3db9705220e3cb3366c2549");
		driver.findElement(By.xpath("//li[@id='menu-sale']/a[@href='#collapse-4']")).click();
		driver.findElement(By.xpath("//*[@id='collapse-4']/li[1]/a")).click();
		String header=driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']/thead")).getText();
		System.out.println(header);

		//find total no. of pages presents for that check the text present bottom right showing 21 to 10 of 778(78 pages)
		String totalpages=driver.findElement(By.xpath("//div[@class='col-sm-6 text-end']")).getText();
		System.out.println(totalpages);//result::::Showing 1 to 10 of 778 (78 Pages)

		//now we want to retrieve only total page number count from this text i.e.78  "Showing 1 to 10 of 778 (78 Pages)"
		int noofpages=Integer.valueOf(totalpages.substring(totalpages.indexOf("(")+1, totalpages.indexOf("Pages")-1));
		System.out.println(noofpages);

		driver.findElement(By.xpath("//a[text()='7']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 //verifying customer
		 String customer= "Le Duy Quan";
	
		//String movetopage=driver.findElement(By.xpath("//td[text()='Le Duy Quan']")).getText();
		WebElement movetopage=driver.findElement(By.xpath("//td[text()='Le Duy Quan']"));
		System.out.println(movetopage.getText());
		Assert.assertEquals(movetopage.getText(), customer);
		
	}

	@AfterTest
	public void teardown()
	{
		driver.quit();
	}

/*	@AfterTest
	public void teardown()
	{
		driver.quit();
	}*/

}
