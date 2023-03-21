package com.retrans.framework.pageobjects;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateActionsPage extends BasePage {
	private static Logger logger = LogManager.getLogger(CreateActionsPage.class);

	public CreateActionsPage(WebDriver driver) {
		super(driver); 
	}

	public void createAction(String title, String status, String fromDate, String fromMonth, String fromYear,
			String toDate, String toMonth, String toYear, String actionsRemarks, String suppDoc, String uploadBut,
			String saveBut, String caseTab, String caseAdd, String caseaply, String caseSub, String casecret,
			String toEmail, String toSubj, String toBody, String toRemark, String savebt, String addAt, String aatitle,
			String ccdesp, String upDoc, String uplbt, String Savbt, String sendky) {
		driver.findElement(By.xpath("//label[@id='litPanel:createActionForm:title_label']")).click();
		threadwait(2000);
		driver.findElement(By.xpath("//td[normalize-space()='" + title + "']")).click();
		threadwait(2000);
 
		driver.findElement(By.xpath("//label[@id='litPanel:createActionForm:status_label']")).click();
		threadwait(2000);
		driver.findElement(By.xpath("//tr[contains(@id,'createActionForm:status')]/td[text()='" + status + "']"))
				.click(); 
		threadwait(3000); 

		driver.findElement(By.xpath("//input[@id='litPanel:createActionForm:plannedStartDate_input']")).sendKeys("");
		threadwait(3000);

		Select drpMonth = new Select(driver.findElement(By.className("ui-datepicker-month"))); 
		drpMonth.selectByVisibleText(fromMonth);

		Select drpYear = new Select(driver.findElement(By.className("ui-datepicker-year")));
		drpYear.selectByVisibleText(fromYear);
		threadwait(3000);
		driver.findElement(By.xpath("//td[@data-handler='selectDay']/a[text()='" + fromDate + "']")).click();  
		threadwait(3000);

		driver.findElement(By.xpath("//input[@id='litPanel:createActionForm:plannedEndDate_input']")).sendKeys("");
		threadwait(3000);

		drpMonth = new Select(driver.findElement(By.className("ui-datepicker-month")));
		drpMonth.selectByVisibleText(toMonth);

		drpYear = new Select(driver.findElement(By.className("ui-datepicker-year")));
		drpYear.selectByVisibleText(toYear);
		threadwait(3000);

		driver.findElement(By.xpath("//td[@data-handler='selectDay']/a[text()='" + toDate + "']")).click();
		threadwait(3000);

		driver.findElement(By.xpath("//textarea[@id='litPanel:createActionForm:action']")).sendKeys("tesing By zaid");
		threadwait(3000);

		driver.findElement(By.xpath("//input[@id='litPanel:createActionForm:supDocAction_input']"))
				.sendKeys("C:\\Users\\ADMIN\\Desktop\\Automated Testing/Auto_Test.pdf");
		threadwait(5000);

		driver.findElement(By.xpath("//*[@id=\"litPanel:createActionForm:supDocAction\"]/div[1]/button[1]/span[1]"))
				.click();
		threadwait(5000);

		driver.findElement(By.xpath(
				"//button[@id='litPanel:createActionForm:saveAction']//span[@class='ui-button-text ui-c'][normalize-space()='Save']"))
				.click();
		threadwait(3000);

		driver.findElement(By.xpath("//a[normalize-space()='Case Creation']")).click();
		threadwait(3000);

		driver.findElement(By.xpath("//span[normalize-space()='Add']")).click();
		threadwait(3000); 

		driver.findElement(By.xpath("//span[normalize-space()='Apply']")).click();
		threadwait(3000);

		driver.findElement(By.xpath("//a[normalize-space()='Case Submission']")).click();
		threadwait(3000);

		driver.findElement(By.xpath( 
				"//button[@id='litPanel:litEmailSubmissionListForm:createNote']//span[@class='ui-button-text ui-c'][normalize-space()='Create']"))
				.click();
		threadwait(3000);

		driver.findElement(By.xpath("//input[@id='litPanel:createLitEmailSubmissionForm:toAddressId']"))
				.sendKeys("mzaid@aliteware.com");
		threadwait(3000);

		driver.findElement(By.xpath("//input[@id='litPanel:createLitEmailSubmissionForm:subjId']"))
				.sendKeys("Auto Testing By zaid");
		threadwait(3000);

		driver.findElement(By.xpath("//textarea[@id='litPanel:createLitEmailSubmissionForm:body']"))
				.sendKeys("Auto Testing By zaid");
		threadwait(3000);

		driver.findElement(By.xpath("//textarea[@id='litPanel:createLitEmailSubmissionForm:remarksId']"))
				.sendKeys("Auto Testing By zaid");
		threadwait(3000);

		driver.findElement(By.xpath("//*[@id=\"litPanel:createLitEmailSubmissionForm:saveES\"]")).click();
		threadwait(3000);

		driver.findElement(By.xpath("//span[normalize-space()='Add Attachment']")).click();
		threadwait(3000);

		driver.findElement(By.xpath("//input[@id='litPanel:uploadLESAttachmentForm:docTitle']"))
				.sendKeys("Auto Testing By zaid");
		threadwait(3000);

		driver.findElement(By.xpath("//textarea[@id='litPanel:uploadLESAttachmentForm:description']"))
				.sendKeys("Auto Testing By zaid");
		threadwait(3000);

		driver.findElement(By.xpath("//input[@id='litPanel:uploadLESAttachmentForm:attachDoc_input']"))
				.sendKeys("C:\\Users\\ADMIN\\Desktop\\Automated Testing/Auto_Test.pdf");
		threadwait(3000);

		driver.findElement(By.xpath("//*[@id=\"litPanel:uploadLESAttachmentForm:attachDoc\"]/div[1]/button[1]/span[2]")) 
				.click();
		threadwait(3000);

		driver.findElement(By.xpath("//*[@id=\"litPanel:uploadLESAttachmentForm:saveAttachmentDoc\"]/span[2]")).click();
		threadwait(3000);

		driver.findElement(By.xpath("//*[@id=\"litPanel:createLitEmailSubmissionForm:sendES\"]/span[2]")).click();
		threadwait(3000);

	}
}
