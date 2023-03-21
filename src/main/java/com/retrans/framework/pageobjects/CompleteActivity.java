package com.retrans.framework.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CompleteActivity extends BasePage {

	public CompleteActivity(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void QueryCre() {
		threadwait(3000);
		String xpathClickLiteratureMenu = "//span[normalize-space()='Literature']";
		String xpathClickQueryMenu = "//span[normalize-space()='Queries..']";
		String xpathClickQueryList = "//span[normalize-space()='Query List']";

		driver.findElement(By.xpath(xpathClickLiteratureMenu)).click();
		threadwait(5000);
		driver.findElement(By.xpath(xpathClickQueryMenu)).click();
		threadwait(5000);
		driver.findElement(By.xpath(xpathClickQueryList)).click();  
		threadwait(5000);

	}

}
