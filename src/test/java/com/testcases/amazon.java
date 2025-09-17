package com.testcases;

import java.util.HashSet;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class amazon extends BaseClass1 {

	@Test
	public void amazon() throws InterruptedException {

		//driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.amazon.in/");
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 300)");

		// XPath for right arrow and current visible banner
		By rightArrow = By.xpath("//span[contains(text(),'Next slide')]");
		By currentBanner = By.xpath("//li[contains(@class,'a-carousel-card') and @aria-hidden='false']//img");

		Set<String> capturedBanners = new HashSet<>(); // Avoid duplicates

		for (int i = 0; i < 10; i++) {  // Adjust max clicks as needed
			try {
				WebElement img = driver.findElement(currentBanner);
				String src = img.getAttribute("src");
				String alt = img.getAttribute("alt");

				if (!capturedBanners.contains(src)) {
					System.out.println("Ad " + (capturedBanners.size() + 1));
					System.out.println("Alt Text: " + alt);
					System.out.println("Image URL: " + src);
					System.out.println("------------------------------------------------");
					capturedBanners.add(src);
				}

				// Click right arrow to move to next ad
				WebElement rightBtn = driver.findElement(rightArrow);
				js.executeScript("arguments[0].click();", rightBtn);
				Thread.sleep(2000);  // Allow ad to load
			} catch (Exception e) {
				System.out.println("No more ads or arrow not found.");
				break;
			}
		}

		System.out.println("Total unique ads captured: " + capturedBanners.size());
		driver.quit();
	}
	/*
		List<WebElement>allAds= driver.findElements(By.xpath("//div[@id='gw-ftGr-desktop-hero-1']//img"));
		System.out.println("Total ads found: " + allAds.size());

		for (WebElement ad : allAds) {
		    System.out.println(ad.getAttribute("href"));  // print ad link
		}
	 */
}



