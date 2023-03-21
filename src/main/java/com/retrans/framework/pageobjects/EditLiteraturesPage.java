package com.retrans.framework.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditLiteraturesPage extends BasePage {

	// @FindBy(xpath = "//button[@id='litPanel:userNotesListForm:createNote']")
	// private WebElement createNotesButton;

	// @FindBy(xpath = "//button[@id='litPanel:actionListForm:createAction']")
	// private WebElement createActionButton;

	//

	@FindBy(xpath = "//a[normalize-space()='Actions']")
	private WebElement actionTab;

	public EditLiteraturesPage(WebDriver driver) {
		super(driver);
	}

	public void createNotes(String title, String description, String attachmentFilePath) { 
		driver.findElement(By.xpath("//button[@id='litPanel:userNotesListForm:createNote']")).click();
		CreateNotesPage notesPage = new CreateNotesPage(driver);
		notesPage.addNotes(title, description, attachmentFilePath); 
		threadwait(3000);
	}

	public void createAction(String title, String status, String fromDate, String fromMonth, String fromYear,
			String toDate, String toMonth, String toYear, String actionsRemarks, String suppDoc, String uploadBut,
			String saveBut, String caseTab, String caseAdd, String caseaply, String caseSub, String casecret,
			String toEmail, String toSubj, String toBody, String toRemark, String savebt, String addAt, String aatitle,
			String ccdesp, String upDoc, String uplbt, String Savbt, String sendky) {
		driver.findElement(By.xpath("//a[normalize-space()='Actions']")).click();
		threadwait(5000);
		driver.findElement(By.xpath("//button[@id='litPanel:actionListForm:createAction']")).click();
		CreateActionsPage actionsPage = new CreateActionsPage(driver);
		actionsPage.createAction(title, status, fromDate, fromMonth, fromYear, toDate, toMonth, toYear, actionsRemarks,
				suppDoc, uploadBut, saveBut, caseTab, caseAdd, caseaply, caseSub, casecret, toEmail, toSubj, toBody,
				toRemark, savebt, addAt, aatitle, ccdesp, upDoc, uplbt, Savbt, sendky);

	}
 
}
