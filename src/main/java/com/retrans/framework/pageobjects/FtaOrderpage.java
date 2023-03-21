package com.retrans.framework.pageobjects;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.retrans.test.RetransTest;
import com.retrans.test.TestBase;

public class FtaOrderpage extends BasePage {
	private static Logger logger = LogManager.getLogger(FtaOrderpage.class);
	

	public FtaOrderpage(WebDriver driver) {
		super(driver);
	}

	public void ftacycle(String fullTextTabXpath, String OrderClick) {

		driver.findElement(By.xpath("//a[normalize-space()='Full Text']")).click(); 
		threadwait(2000);
		driver.findElement(By.xpath("//span[@class='ui-button-text ui-c'][normalize-space()='Order']")).click();
		threadwait(2000);

	}
	  
}
 