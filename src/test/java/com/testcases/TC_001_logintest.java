package com.testcases;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_001_logintest extends BaseClass1 {

	@Test(testName="1", priority=0)
	public void login() {
		String user = System.getProperty("username", "defaultUser");
	    String pass = System.getProperty("password", "defaultPass");
		
		driver.get("https://www.amazon.in");
		System.out.println("listing title is:-" + "  " + driver.getTitle());
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}
	@Test(testName="2",priority=1)
	public void differnece() {
		String actutitle="Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";

		//String actutitle="Amazon.in";
		
		String expecttitle= driver.getTitle();;
		Assert.assertEquals(actutitle, expecttitle);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	@Test(testName="3",priority=2)
	public void url() {
		String actualurl= "https://www.amazon.in/";

		//String actualurl= "https://www.amazon.in/";
		String expturl= driver.getCurrentUrl();
		Assert.assertEquals(actualurl, expturl);


	}


}
