package org.test.sample;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Google {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Dell\\eclipse-workspace\\MavenSample\\Driver\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com");

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		WebElement close = driver.findElement(By.xpath("//button[@class = '_2KpZ6l _2doB4z']"));

		close.click();

		WebElement search = driver.findElement(By.xpath("//input[@class = '_3704LK']"));

		search.sendKeys("Mobile");

		driver.findElement(By.xpath("//button[@class = 'L0Z3Pu']")).click();

		Thread.sleep(3000);

		List<WebElement> productName = driver.findElements(By.xpath("//div[@class = '_4rR01T']"));

		List<WebElement> productPrice = driver.findElements(By.xpath("//div[@class = '_30jeq3 _1_WHN1']"));

		HashMap<Integer, String> finalProduct = new LinkedHashMap<Integer, String>();

		for (int i = 0; i < productName.size(); i++) {

			WebElement prodName = productName.get(i);

			String mobileNames = prodName.getText().toString();

			WebElement prodPrice = productPrice.get(i);

			String mobilePrice = prodPrice.getText().toString();

			String mobile_Price_Replace = mobilePrice.replaceAll("[^0-9]", "");

			int mobilePriceInt = Integer.parseInt(mobile_Price_Replace);

			finalProduct.put(mobilePriceInt, mobileNames);

		}
		
		Set<Integer> key = finalProduct.keySet();
		
		ArrayList<Integer> lst = new ArrayList<Integer>();
		
		lst.addAll(key);
		
		Collections.sort(lst);
		//1,2,3,4,5,6,7
		
		
		//Lowest price
		System.out.println(finalProduct.get(lst.get(0))+" : Rs "+lst.get(0));
		
		//Highest price
		System.out.println(finalProduct.get(lst.get(lst.size()-1))+" : Rs "+lst.get(lst.size()-1));
		
		//Second Lowest price
		System.out.println(finalProduct.get(lst.get(1))+" : Rs "+lst.get(1));
		
		//Second Highest price
		System.out.println(finalProduct.get(lst.get(lst.size()-2))+" : Rs "+lst.get(lst.size()-2));
		
	}
}
