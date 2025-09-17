package com.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class static_webtable {
	WebDriver driver;
	@BeforeTest
	public void staticwebtable() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\msilocal\\Downloads\\Drivers&jars\\chromedriver\\chromedriver.exe");
		Thread.sleep(2000);
		driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	@Test(enabled= false)
	public void table1() {
		driver.get("https://www.nyse.com/ipo-center/filings");
		//WebElement ele= driver.findElement(By.xpath("//div[@class='overflow-x-auto'][3]/table[1]"));
		WebElement row= driver.findElement(By.xpath("//div[@class='overflow-x-auto'][3]/table[1]/thead/tr"));
		System.out.print(row.getText());
	}
	@Test
	public void table2() {
		driver.get("https://money.rediff.com/gainers/bse/daily/groupa?src=gain_lose");
		
		//want to retrive specific cell value from the row i.e from 10th row want to retrive 3rd and 4th cell value.
		String rowspecvalue=driver.findElement(By.xpath("//table[@class='dataTable']/tbody/tr")).getText();
		
		int row= driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr")).size();
		System.out.println("no of rows in a table : " +row);
		
		for(int i=1;i<row;i++) {
			String value= driver.findElement(By.xpath("//table[@class='dataTable']/tbody/tr["+i+"]/td[2]"))
					.getText();
			if(value.equals("Tejas Networks")) {
				//String groupname= driver.findElement(By.xpath("//table[@class='dataTable']/tbody/tr/td/a[contains(text(),'Tejas Networks')]")).getText();
				String groupname= driver.findElement(By.xpath("//table[@class='dataTable']/tbody/tr["+i+"]/td[3]")).getText();
				String prevclose= driver.findElement(By.xpath("//table[@class='dataTable']/tbody/tr["+i+"]/td[4]")).getText();

System.out.println(value + ": "+groupname +"    "+ prevclose);
				

			}
		
	/*
		 WebElement header= driver.findElement(By.xpath("//table[@class='dataTable']/thead"));
		System.out.print("headers retriving : "+ header.getText());
		
		
		
		int cell= driver.findElements(By.xpath("//table[@class='dataTable']/thead/tr/th")).size();
		System.out.println("no of cells in a table : " +cell);
			
		WebElement rowretriving= driver.findElement(By.xpath("//table[@class='dataTable']/tbody/tr[90]"));
		System.out.println("specific row retriving : " +rowretriving.getText());
		
		System.out.println("all data retriving : :::::::" );
		for(int i=1;i<row;i++) {
			for(int j=1;j<cell;j++) {
				//we have parameterised i and j values as we cant directly write variables in xpath
				String data= driver.findElement(By.xpath("//table[@class='dataTable']/tbody/tr["+i+"]/td["+j+"]")).getText();
				System.out.print(data+ "   ");
			}
			System.out.println();
		}
		*/
		
		
	}
}
}
