package com.retrans.framework.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateSingleCitation extends BasePage {

	public CreateSingleCitation(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//ul[@class='ui-selectcheckboxmenu-multiple-container ui-widget ui-inputfield ui-state-default ui-corner-all']")
	private WebElement filterByBusinessUnit;

	@FindBy(xpath = "//input[@id='litPanel:createUserNotesForm:notes']")
	private WebElement inputTitle;

	@FindBy(xpath = "//button[@id='litPanel:createUserNotesForm:saveNote']//span[@class='ui-button-text ui-c'][normalize-space()='Save']")
	private WebElement inputAuthors;

	@FindBy(xpath = "//input[@id='litPanel:createUserNotesForm:notes']")
	private WebElement inputUID;

	@FindBy(xpath = "//input[@id='litPanel:createUserNotesForm:notes']")
	private WebElement inputDOI;

	@FindBy(xpath = "//input[@id='litPanel:createUserNotesForm:notes']")
	private WebElement inputISSN;

	@FindBy(xpath = "//input[@id='litPanel:createUserNotesForm:notes']")
	private WebElement inputAcessionId;

	@FindBy(xpath = "//input[@id='litPanel:createUserNotesForm:notes']")
	private WebElement inputAbstract;

	@FindBy(xpath = "//input[@id='litPanel:createUserNotesForm:notes']")
	private WebElement inputDrugTerms;

	public void addCitationDetails(String businessUnit, String title, String authors, String uid, String doi,
			String issn, String accession_id, String abstractContents, String drugTerms) {

		driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-triangle-1-s']")).click();

		driver.findElement(By.xpath("//li[@data-item-value='" + businessUnit + "']")).click();

		driver.findElement(By.xpath("//textarea[@id='createLiteItemMultiUnitsForm:authorNames']")).click();

		driver.findElement(By.xpath("//textarea[@id='createLiteItemMultiUnitsForm:title']")).sendKeys(title);

		driver.findElement(By.xpath("//textarea[@id='createLiteItemMultiUnitsForm:authorNames']")).sendKeys(authors);

		driver.findElement(By.xpath("//input[@id='createLiteItemMultiUnitsForm:pui']")).sendKeys(uid);

		driver.findElement(By.xpath("//input[@id='createLiteItemMultiUnitsForm:doi']")).sendKeys(doi);

		driver.findElement(By.xpath("//input[@id='createLiteItemMultiUnitsForm:issn']")).sendKeys(issn);

		driver.findElement(By.xpath("//input[@id='createLiteItemMultiUnitsForm:accessionId']")).sendKeys(accession_id);

		driver.findElement(By.xpath("//textarea[@id='createLiteItemMultiUnitsForm:absCitationContent']"))
				.sendKeys(abstractContents);

		driver.findElement(By.xpath("//textarea[@id='createLiteItemMultiUnitsForm:drugTerms']")).sendKeys(drugTerms);

		driver.findElement(By.xpath("//span[normalize-space()='Save & Publish']")).click();

		threadwait(3000);

		driver.findElement(By.xpath("(//span[@class='ui-button-text ui-c'][text()='Yes'])[2]")).click();

	}
	
	

}



