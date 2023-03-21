package com.retrans.framework.pageobjects;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.retrans.test.TestBase;

public class ListLiteraturesPage<XSSWorkbook> extends BasePage {
	private static Logger logger = LogManager.getLogger(ListLiteraturesPage.class);

	@FindBy(xpath = "//span[contains(text(),'Zaid_QC')]")
	private WebElement testUserLink;

	@FindBy(xpath = "//span[normalize-space()='Logout']")
	private WebElement logoutElement;

	// @FindBy(xpath =
	// "//label[@id='literaturListForm:literatureItemsGrid:classificationid_label']/following::span[1]")

	// label[@id='literaturListForm:literatureItemsGrid:classificationid_label']/preceding::div[1]/following::div[1]/span
	@FindBy(xpath = "//label[@id='literaturListForm:literatureItemsGrid:classificationid_label']/following::span[1]")
	private WebElement filterByClassification;

	@FindBy(xpath = "//button[@id='literaturListForm:literatureItemsGrid:claimAllBtn']//span[@class='ui-button-icon-left ui-icon ui-c fa fa-tasks']")
	private WebElement claimButton;

	@FindBy(xpath = "//button[@id='literaturListForm:literatureItemsGrid:0:claimNowLitItem']//span[@class='ui-button-icon-left ui-icon ui-c fa fa-tasks']")
	private WebElement claimIconButton;

	@FindBy(xpath = "//button[@id='litPanel:userNotesListForm:createNote']//span[@class='ui-button-text ui-c'][normalize-space()='Create']")
	private WebElement createNoteButton;

	@FindBy(xpath = "//a[normalize-space()='Case Creation']")
	private WebElement caseCreationTab;

	@FindBy(xpath = "//span[normalize-space()='Add']")
	private WebElement caseAdd;

	@FindBy(xpath = "//span[normalize-space()='Apply']")
	private WebElement caseApply;

	@FindBy(xpath = "//*[@id=\"completeActivityForm:isDisagreeId\"]/div[2]")
	private WebElement checkbox;

	@FindBy(xpath = "//input[@id='litPanel:createUserNotesForm:title']")
	private WebElement textTitleField;

	@FindBy(xpath = "//input[@id='litPanel:createLitEmailSubmissionForm:toAddressId']")
	private WebElement textToEmail;

	@FindBy(xpath = "//textarea[@id='completeActivityForm:remarks']")
	private WebElement CompleteAcRemarks;

	@FindBy(xpath = "//input[@id='litPanel:createLitEmailSubmissionForm:subjId']")
	private WebElement textToSubject;

	@FindBy(xpath = "//textarea[@id='litPanel:createLitEmailSubmissionForm:remarksId']")
	private WebElement textToRemarks;

	@FindBy(xpath = "//textarea[@id='litPanel:createLitEmailSubmissionForm:body']")
	private WebElement textToBody;

	@FindBy(xpath = "//button[@id='litPanel:createLitEmailSubmissionForm:saveES']//span[@class='ui-button-text ui-c'][normalize-space()='Save']")
	private WebElement EmailSaveButton;

	@FindBy(xpath = "//span[normalize-space()='Add Attachment']")
	private WebElement AddAttachment;

	@FindBy(xpath = "//span[normalize-space()='Send']")
	private WebElement EmailSentButton;

	@FindBy(xpath = "//button[@id='litMetaDataFormTmp:CompleteActivityBtn']//span[@class='ui-button-icon-left ui-icon ui-c fa fa-check']")
	private WebElement CompleteButton;

	@FindBy(xpath = "//div[@class='ui-selectonemenu-trigger ui-state-default ui-corner-right ui-state-hover']")
	private WebElement ClassificationIcon;

	@FindBy(xpath = "//div[@id='completeActivityForm:itemActStatus']//span[@class='ui-icon ui-icon-triangle-1-s ui-c']")
	private WebElement filterByNextActivity;

	@FindBy(xpath = "//textarea[@id='litPanel:createUserNotesForm:notes']")
	private WebElement NotesField;

	@FindBy(xpath = "//input[@id='litPanel:createUserNotesForm:supDocUserNotes_input']")
	private WebElement SupportDoc;

	@FindBy(xpath = "//*[@id=\"litPanel:createUserNotesForm:supDocUserNotes\"]/div[1]/button[1]/span[2]")
	private WebElement uploadButton;

	@FindBy(xpath = "//button[@id='completeActivityForm:completeCurrActvity']//span[@class='ui-button-text ui-c'][normalize-space()='Complete Activity']")
	private WebElement CompleteActivityButton;

	@FindBy(xpath = "//button[@id='litPanel:createUserNotesForm:saveNote']//span[@class='ui-button-text ui-c'][normalize-space()='Save']")
	private WebElement SaveButtonNotes;

	@FindBy(xpath = "//a[normalize-space()='Actions']")
	private WebElement ActionTab;

	@FindBy(xpath = "//input[@id='litPanel:createActionForm:plannedStartDate_input']")
	private WebElement PlannedStartDate;

	@FindBy(xpath = "//a[@class='ui-state-default ui-state-hover']")
	private WebElement PlannedStartDatePick;

	@FindBy(xpath = "//button[@id='litPanel:actionListForm:createAction']//span[@class='ui-button-text ui-c'][normalize-space()='Create']")
	private WebElement CreateActionButton;

	@FindBy(xpath = "//a[normalize-space()='Case Submission']")
	private WebElement CaseSubmissonTab;

	@FindBy(xpath = "//button[@id='litPanel:litEmailSubmissionListForm:createNote']//span[@class='ui-button-text ui-c'][normalize-space()='Create']")
	private WebElement CaseCreateButton;

	@FindBy(xpath = "//input[@id='litPanel:createUserNotesForm:title']")
	private WebElement titleField;

	@FindBy(xpath = "//input[@id='litPanel:createUserNotesForm:title']]")
	private WebElement createTitle;

	@FindBy(xpath = "//span[normalize-space()='Release my claim']")
	private WebElement unClaimButton;

	@FindBy(xpath = "//span[@class='ui-button-icon-left ui-icon ui-c fa fa-check Fs16 white']")
	private WebElement dialogYesButton;

	@FindBy(xpath = "//label[@id='literaturListForm:literatureItemsGrid:queryTypeid_label']/following::span[1]")
	private WebElement filterBySearchType;

	@FindBy(xpath = "//div[@id='litPanel:createActionForm:title']//span[@class='ui-icon ui-icon-triangle-1-s ui-c']")
	private WebElement filterByTitleActions;

	@FindBy(xpath = "//label[@id='litPanel:createLitEmailSubmissionForm:status_label']")
	private WebElement filterByEmailStatus;

	@FindBy(xpath = "//div[@id='litMetaDataFormTmp:classificationTypeid']//div//span")
	private WebElement filterByClassificationIcon;

	@FindBy(xpath = "//div[@id='litPanel:createActionForm:status']//span[@class='ui-icon ui-icon-triangle-1-s ui-c']")
	private WebElement filterByStatusActions;

	@FindBy(xpath = "//label[@id='literaturListForm:literatureItemsGrid:comUnitfilid_label']/following::span[1]")
	private WebElement filterByBusinessUnit;

	@FindBy(xpath = "//label[@id='literaturListForm:literatureItemsGrid:claimid_label']/following::span[1]")
	private WebElement filterByClaims;

	@FindBy(xpath = "//label[@id='literaturListForm:literatureItemsGrid:statusid_label']/following::span[1]")
	private WebElement filterByActivity;

	private String clearFilterElementXPATH = "//span[@class='ui-button-icon-left ui-icon ui-c fa fa-eraser']";

	public ListLiteraturesPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		System.out.println("logoutElement::::::" + logoutElement);
	}

	public void clearFilter() {
		logger.info("Clearing filters on inbox");
		threadwait(3000);
		driver.findElement(By.xpath(clearFilterElementXPATH)).click();
	}

	public void closeLiteratureDialog() {
		threadwait(3000);
		String xpath = "//span[contains(text(),'Close')]/preceding::button[@title='Close' and @role='button' and contains(@id,'readOnlyLitItemNotDupForm:j')]";
		// waituntilElementLocated(By.xpath(xpath));
		try {
			driver.findElement(By.xpath(xpath)).click();
		} catch (Throwable th) {
			System.out.println("-------##############____________________");
			th.printStackTrace();
			driver.findElement(By.xpath(xpath)).click();

		}
	}

	public void claimSelectedLiteratureItems() {
		claimButton.click();
		threadwait(5000);
		dialogYesButton.click();
	}

	public void claimIconButton() {
		claimIconButton.click();

	}

	public void createNoteButton() {
		createNoteButton.click();

	}

	public void caseCreationTab() {
		caseCreationTab.click();

	}

	public void caseAdd() {
		caseAdd.click();
	}

	public void caseApply() {
		caseApply.click();

	}

	public void checkbox() {
		checkbox.click();

	}

	public void textTitleField() {
		textTitleField.sendKeys("ByZaid");

	}

	public void textToEmail() {
		textToEmail.sendKeys("Rawzaid@gmai.com");

	}

	public void CompleteAcRemarks() {
		CompleteAcRemarks.sendKeys("DemoToABR");

	}

	public void textToSubject() {
		textToSubject.sendKeys("Rawzaid@gmai.com");

	}

	public void textToRemarks() {
		textToRemarks.sendKeys("Rawzaid@gmai.com");
	}

	public void textToBody() {
		textToBody.sendKeys("Rawzaid@gmai.com");

	}

	public void NotesField() {
		NotesField.sendKeys("ByZaid");

	}

	public void SupportDoc() {
		SupportDoc.sendKeys("C:\\Users\\ADMIN\\Desktop\\Automated Testing/Auto_Test.pdf");

	}

	public void uploadButton() {
		uploadButton.click();

	}

	public void CompleteActivityButton() {
		CompleteActivityButton.click();

	}

	public void EmailSaveButton() {
		EmailSaveButton.click();

	}

	public void AddAttachment() {
		AddAttachment.sendKeys("C:\\Users\\ADMIN\\Desktop\\Automated Testing/Auto_Test.pdf")

		;

	}

	public void SaveButtonNotes() {
		SaveButtonNotes.click();

	}

	public void EmailSentButton() {
		EmailSentButton.click();

	}

	public void CompleteButton() {
		CompleteButton.click();

	}

	public void PlannedStartDate() {
		PlannedStartDate.click();
	}

	public void PlannedStartDatePick() {
		PlannedStartDatePick.click();
	}

	public void ActionTab() {
		ActionTab.click();

	}

	public void CreateActionButton() {
		CreateActionButton.click();

	}

	public void CaseSubmissonTab() {
		CaseSubmissonTab.click();

	}

	public void CaseCreateButton() {
		CaseCreateButton.click();

	}

	public void unClaimSelectedLiteratureItems() {
		unClaimButton.click();
		threadwait(5000);
		dialogYesButton.click();
	}

	public void selectLiteratureByCheckBox(String litName) {
		String xpath = "//span[text()='" + litName + "']/preceding::td[@class='ui-selection-column'][1]";
		waituntilElementLocated(By.xpath(xpath));
		driver.findElement(By.xpath(xpath)).click();
	}

	public EditLiteraturesPage editLiterature(String litName) {
		String xpath = "//span[text()='" + litName + "']/preceding::td[1]/button/span[1]";
		waituntilElementLocated(By.xpath(xpath));
		driver.findElement(By.xpath(xpath)).click();
		return new EditLiteraturesPage(driver);
	}

	public EditLiteraturesPage editLiteratureByTitle(String litTitle) {
		/*
		 * //button[@id='literaturListForm:literatureItemsGrid:searchCit']
		 * 
		 * //textarea[@placeholder='Title ']
		 * 
		 * //button[@id='filterPanelForm:applyFilter']
		 * 
		 * //span[@class='ui-button-icon-left ui-icon ui-c fa fa-pencil-alt jm3']
		 */

		String xpath = "//button[@id='literaturListForm:literatureItemsGrid:searchCit']";
		driver.findElement(By.xpath(xpath)).click();
		threadwait(3000);

		xpath = "//textarea[@placeholder='Title ']";
		driver.findElement(By.xpath(xpath)).clear();
		driver.findElement(By.xpath(xpath)).sendKeys("%" + litTitle + "%");

		xpath = "//button[@id='filterPanelForm:applyFilter']";
		driver.findElement(By.xpath(xpath)).click();
		threadwait(4000);

		xpath = "//span[@class='ui-button-icon-left ui-icon ui-c fa fa-pencil-alt jm3']";
		driver.findElement(By.xpath(xpath)).click();
		threadwait(3000);

		return new EditLiteraturesPage(driver);
	}

	public void clickLiteratureByName(String litName) {
		String xpath = "//span[contains(text(),'" + litName + "')]";
		waituntilElementLocated(By.xpath(xpath));
		driver.findElement(By.xpath(xpath)).click();
	}

	public void filterBySearchType(String searchType) {
		String xpath = "//td[normalize-space()='" + searchType + "']";
		filterBySearchType.click();
		waituntilElementLocated(By.xpath(xpath));
		driver.findElement(By.xpath(xpath)).click();

	}

	public void filterByTitleActions(String searchType) {
		String xpath = "//td[normalize-space()='" + searchType + "']";
		filterByTitleActions.click();
		waituntilElementLocated(By.xpath(xpath));
		driver.findElement(By.xpath(xpath)).click();

	}

	public void filterByEmailStatus(String emailStatus) {
		String xpath = "//tr[@data-label='" + emailStatus + "']/td";
		filterByEmailStatus.click();
		waituntilElementLocated(By.xpath(xpath));
		driver.findElement(By.xpath(xpath)).click();
	}

	public void filterByClassificationIcon(String classificationType) {
		String xpath = "//td[normalize-space()='" + classificationType + "']";
		filterByClassificationIcon.click();
		waituntilElementLocated(By.xpath(xpath));
		driver.findElement(By.xpath(xpath)).click();

	}

	public void filterByNextActivity(String searchActivity) {
		String xpath = "//td[normalize-space()='" + searchActivity + "']";
		filterByNextActivity.click();
		waituntilElementLocated(By.xpath(xpath));
		driver.findElement(By.xpath(xpath)).click();

	}

	public void filterByStatusActions(String searchType) {
		String xpath = "//td[normalize-space()='" + searchType + "']";
		filterByStatusActions.click();
		waituntilElementLocated(By.xpath(xpath));
		driver.findElement(By.xpath(xpath)).click();

	}

	public void filterByActivity(String activityValue) {
		String xpath = "//td[normalize-space()='" + activityValue + "']";
		filterByActivity.click();
		waituntilElementLocated(By.xpath(xpath));
		driver.findElement(By.xpath(xpath)).click();
	}

	public void filterByClassification(String classificationValue) {
		String xpath = "//tr[@data-label='" + classificationValue + "']/td";
		filterByClassification.click();
		waituntilElementLocated(By.xpath(xpath));
		driver.findElement(By.xpath(xpath)).click();
	}

	public void filterByClaims(String claimStatus) {
		String xpath = "//td[normalize-space()='" + claimStatus + "']";
		filterByClaims.click();
		waituntilElementLocated(By.xpath(xpath));
		driver.findElement(By.xpath(xpath)).click();
	}

	public void filterByBusinessUnit(String businessUnit) {
		filterByBusinessUnit.click();
		String xpath = "//tr[@data-label='" + businessUnit + "']/td";
		waituntilElementLocated(By.xpath(xpath));
		driver.findElement(By.xpath(xpath)).click();
		System.out.println("logoutElement::::::" + logoutElement);
	}

	public void logout() {

		testUserLink.click();
		logoutElement.click();

	}

	public void navigateToListLitItemsPage() {
		logger.info("Navigating to inbox");
		driver.get("http://" + TestBase.hostIP + "/" + TestBase.context + "/views/literatureItems/list.xhtml");
		threadwait(4000);

	}

	public void addCitationDetails(String businessUnit, String title, String authors, String uid, String doi,
			String issn, String accession_id, String abstractContents, String drugTerms) {

		driver.findElement(By.xpath("//span[normalize-space()='Literature']")).click();
		threadwait(3000);

		driver.findElement(By.xpath("//span[normalize-space()='Queries..']")).click();
		threadwait(3000);

		driver.findElement(By.xpath("//span[normalize-space()='Create Citation']")).click();

		CreateSingleCitation singleCitationPage = new CreateSingleCitation(driver);
		singleCitationPage.addCitationDetails(businessUnit, title, authors, uid, doi, issn, accession_id,
				abstractContents, drugTerms);

	}

	public void addNotes(String title, String notes, String supporting, String upload, String save) {
		driver.findElement(By.xpath("//input[@id='litPanel:createUserNotesForm:title']")).sendKeys("By Zaid Title");
		threadwait(3000);
		driver.findElement(By.xpath("//textarea[@id='litPanel:createUserNotesForm:notes']")).sendKeys("By Zaid Notes");
		threadwait(3000);
		driver.findElement(By.xpath("//input[@id='litPanel:createUserNotesForm:supDocUserNotes_input']"))
				.sendKeys("C:\\Users\\ADMIN\\Desktop\\Automated Testing/Auto_Test.pdf");
		threadwait(3000);
		driver.findElement(By.xpath(
				"//button[@class='ui-button ui-widget ui-state-default ui-corner-all ui-button-text-icon-left ui-fileupload-upload ui-state-focus ui-state-hover']//span[@class='ui-button-icon-left ui-icon ui-c ui-icon-arrowreturnthick-1-n']"))
				.click();
		threadwait(3000);
		driver.findElement(By.xpath(
				"//button[@id='litPanel:createUserNotesForm:saveNote']//span[@class='ui-button-text ui-c'][normalize-space()='Save']"))
				.click();

	}

	public void createQuery() {
		threadwait(3000);

		String xpathClickLiteratureMenu = "//span[normalize-space()='Literature']";
		String xpathClickQueryMenu = "//span[normalize-space()='Queries..']";
		String xpathClickCreateQuery = "(//span[contains(text(),'Create Query(Blank)')])[1]";
		String xpathSelectSlider = "//div[@class='ui_tpicker_hour_slider ui-slider ui-slider-horizontal ui-widget ui-widget-content ui-corner-all']";
		String xpathDateTimeField = "(//input[@id='createNewQueryDialogForm:searchDate_input'])[1]";

		String selectDate = "15";

		driver.findElement(By.xpath(xpathClickLiteratureMenu)).click();

		driver.findElement(By.xpath(xpathClickQueryMenu)).click();

		driver.findElement(By.xpath(xpathClickCreateQuery)).click();
		threadwait(3000);
		driver.findElement(By.xpath(xpathDateTimeField)).click();
		threadwait(3000);

		driver.findElement(By.xpath("//a[normalize-space()='" + selectDate + "']")).click();
		threadwait(3000);

		WebElement slider = driver.findElement(By.xpath(xpathSelectSlider));

		Actions move = new Actions(driver);
		Action action = (Action) move.dragAndDropBy(slider, 30, 0).build();
		action.perform();
		threadwait(3000);

	}

	public void createEmbaseQuery() {
		logger.info("cteating Embase Query ");
		threadwait(5000);

		String xpathLiLiterature = "//span[normalize-space()='Literature']";
		logger.info("Clicking on Literature Menu");
		String xpathQueries = "//span[normalize-space()='Queries..']";
		logger.info("Clicking on Query List From Literature Menu");
		String xpathQueryList = "//span[normalize-space()='Query List']"; 
		logger.info("Clicking on Literature Menu");
		String xpathCreate = "//button[@id='literatureQueryListForm:literatureQueryGrid:createButton']//span[2]";
		logger.info("Clicking on Create Button");
		String xpathBusinessUnitIcon = "//button[@id='literatureQueryForm:queryTab:selectCompLookup']//span[1]";
		logger.info("Clicking on Business Unit Search Icon");
		String xpathRadioButton = "//*[@id=\"litCompanyUnitLookForm:companyUnitGrid_data\"]/tr[2]/td[1]/div/div[2]/span";
		logger.info("Selecting Business Unit From the List");
		String xpathSelectButton = "//button[@id='litCompanyUnitLookForm:selectComp']//span[@class='ui-button-text ui-c'][normalize-space()='Select']";
		logger.info("Clicking on Business Unit Select Button");
		String xpathProductIcon = "//button[@id='literatureQueryForm:queryTab:selectProdLookup']//span[contains(@class,'ui-button-icon-left ui-icon ui-c fa fa-search Fs16')]";
		logger.info("Clicking on Product Search Icon");
		String xpathProRadioButton = "//*[@id=\"litProductLookForm:productGrid_data\"]/tr[2]/td[1]/div/div[2]/span";
		logger.info("Selecting Product From the List");
		String xpathpProSelectButton = "//button[@id='litProductLookForm:j_idt186']//span[@class='ui-button-icon-left ui-icon ui-c fa fa-check']";
		logger.info("Clicking on Product Select Button");
		String SearchStartDateFromMonth = "Jan";
		logger.info("Selecting a Month From month list");
		String SearchStartDatefromYear = "2023";
		logger.info("Selecting a Year From year list");
		String SearchStart = "11";
		logger.info("Selecting Date");
		String SearchStartDateToMonth = "Jan";
		logger.info("Selecting a Month From month list");
		String SearchStartDateToYear = "2023";
		logger.info("Selecting a Year From year list");
		String SearchStartTo = "18";
		logger.info("Selecting Date");
		String SearchDate = "//span[@id='literatureQueryForm:queryTab:searchDate']//span[1]";
		logger.info("Clicking on Search Date");
		String SearchDateMonth = "Jan";
		logger.info("Selecting a Month From month list ");
		String SearchDateYear = "2023";
		logger.info("Selecting a Year From year list");
		String SearchDateStart = "12";
		logger.info("Selecting Date");
		String xpathSelectSliderTime = "//div[@class='ui_tpicker_hour_slider ui-slider ui-slider-horizontal ui-widget ui-widget-content ui-corner-all']//span[@class='ui-slider-handle ui-state-default ui-corner-all']";
		logger.info("Selecting Time");
		String xpathUploadQueryFile = "//button[@class='ui-button ui-widget ui-state-default ui-corner-all ui-button-text-icon-left ui-fileupload-upload']//span[@class='ui-button-text ui-c']";
		logger.info("Selecting Date");
		String xpathBeforeSave = "//textarea[@id='literatureQueryForm:queryTab:description']";
		String xpathCloseButt = "//button[@id='literatureQueryForm:querySaveCancelButton']//span[@class='ui-button-text ui-c'][normalize-space()='Close']";
		String xpathInbox = "//li[@id='menuform1:literature']//a[@class='menulink']";
		String xpathAdanceFilterIcon = "//span[@class='ui-button-icon-left ui-icon ui-c fa fa-search']";
		String xpathCloseLitReview = "//a[@id='filterPanelForm:litItemFilters_toggler']";
		String xpathMoreFilter = "//a[@id='filterPanelForm:toggleable_toggler']";
		String xpathSearchButt = "//*[@id=\"filterPanelForm:applyFilter\"]/span[2]";

		driver.findElement(By.xpath(xpathLiLiterature)).click();
		driver.findElement(By.xpath(xpathQueries)).click();
		driver.findElement(By.xpath(xpathQueryList)).click();
		driver.findElement(By.xpath(xpathCreate)).click();
		threadwait(3000);
		driver.findElement(By.xpath(xpathBusinessUnitIcon)).click();
		threadwait(3000);
		driver.findElement(By.xpath(xpathRadioButton)).click();
		threadwait(3000);
		driver.findElement(By.xpath(xpathSelectButton)).click();
		threadwait(3000);
		driver.findElement(By.xpath(xpathProductIcon)).click();
		threadwait(3000);
		driver.findElement(By.xpath(xpathProRadioButton)).click();
		threadwait(3000);
		driver.findElement(By.xpath(xpathpProSelectButton)).click();
		threadwait(3000);
		driver.findElement(By.xpath("//input[@id='literatureQueryForm:queryTab:name']"))
				.sendKeys("Creating EMBASE Query");
		logger.info("Entering the Search Title");
		threadwait(3000);
		driver.findElement(By.xpath("//span[@id='literatureQueryForm:queryTab:searchStartDate']//span[1]")).click();
		threadwait(3000);

		Select drpMonth = new Select(driver.findElement(By.className("ui-datepicker-month")));
		drpMonth.selectByVisibleText(SearchStartDateFromMonth);

		Select drpYear = new Select(driver.findElement(By.className("ui-datepicker-year")));
		drpYear.selectByVisibleText(SearchStartDatefromYear);
		threadwait(3000);
		driver.findElement(By.xpath("//td[@data-handler='selectDay']/a[text()='" + SearchStart + "']")).click();
		threadwait(3000);

		threadwait(3000);
		driver.findElement(By.xpath("//span[@id='literatureQueryForm:queryTab:searchEndDate']//span[1]")).click();
		threadwait(3000);

		Select drpMonthTo = new Select(driver.findElement(By.className("ui-datepicker-month")));
		drpMonthTo.selectByVisibleText(SearchStartDateToMonth);
		threadwait(3000);

		Select drpYearTo = new Select(driver.findElement(By.className("ui-datepicker-year")));
		drpYearTo.selectByVisibleText(SearchStartDateToYear);
		threadwait(3000);
		driver.findElement(By.xpath("//td[@data-handler='selectDay']/a[text()='" + SearchStartTo + "']")).click();
		threadwait(3000);

		driver.findElement(By.xpath(SearchDate)).click();
		threadwait(3000);

		Select drpMonthSearch = new Select(driver.findElement(By.className("ui-datepicker-month")));
		drpMonthSearch.selectByVisibleText(SearchDateMonth);
		threadwait(3000);

		Select drpYearSearch = new Select(driver.findElement(By.className("ui-datepicker-year")));
		drpYearSearch.selectByVisibleText(SearchDateYear);
		threadwait(3000);
		driver.findElement(By.xpath("//td[@data-handler='selectDay']/a[text()='" + SearchDateStart + "']")).click();
		threadwait(3000);

		WebElement Timeslider = driver.findElement(By.xpath(xpathSelectSliderTime));

		Actions move = new Actions(driver);
		Action action = (Action) move.dragAndDropBy(Timeslider, 30, 0).build();
		action.perform();
		threadwait(3000);

		driver.findElement(By.xpath("//input[@id='literatureQueryForm:queryTab:projCode']"))
				.sendKeys("Creating EMBASE Query");

		driver.findElement(By.xpath("//textarea[@id='literatureQueryForm:queryTab:description']"))
				.sendKeys("Creating EMBASE Query By Automation for Smoke Testing");
		logger.info("Entering the Description");

		driver.findElement(By.xpath("//input[@id='literatureQueryForm:queryTab:selectFileBtnCsv_input']"))
				.sendKeys("C:\\Users\\ADMIN\\Desktop\\Automated Testing/DuplicateCheckFile_081221 (1).csv");
		logger.info("Uplaoding the File ");
		threadwait(3000);
		driver.findElement(By.xpath(xpathUploadQueryFile)).click();
		logger.info("Clickling on Upload Button");

//		driver.findElement(By.xpath(xpathBeforeSave)).click();
//		threadwait(10000);

		driver.findElement(By.xpath("//*[@id=\"literatureQueryForm:queryTab:litType\"]/div[3]/span")).click();
		logger.info("Click on Search Source Dropdown List");
		threadwait(3000);

		driver.findElement(By.xpath("//*[@id=\"literatureQueryForm:queryTab:litType_0\"]/td")).click();
		logger.info("Selecting as Embase from the Dropdown List");
		threadwait(10000);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,400);");
		threadwait(3000);

		driver.findElement(By.xpath(
				"//button[@id='literatureQueryForm:querySaveButton']//span[@class='ui-button-text ui-c'][normalize-space()='Save']"))
				.click();
		logger.info("Clicking on save Button");

		// button[id='literatureQueryForm:querySaveButton'] span[class='ui-button-text
		// ui-c']
		// /html[1]/body[1]/div[2]/div[2]/div[1]/form[1]/div[2]/button[1]/span[1]

		// button[id='literatureQueryForm:querySaveButton'] span[class='ui-button-text
		// ui-c']

		threadwait(7000);
		driver.findElement(By.xpath(xpathCloseButt)).click();
		driver.findElement(By.xpath(xpathLiLiterature)).click();
		driver.findElement(By.xpath(xpathInbox)).click();
		threadwait(5000);
//		driver.findElement(By.xpath(xpathAdanceFilterIcon)).click();
//		threadwait(5000);
//		driver.findElement(By.xpath(xpathCloseLitReview)).click();
//		threadwait(5000);
//		driver.findElement(By.xpath(xpathMoreFilter)).click();
//		threadwait(5000);
//		driver.findElement(By.xpath("//input[@id='filterPanelForm:j_idt471']")).sendKeys("Creating EMBASE Query");
//		threadwait(2000);
//		driver.findElement(By.xpath(xpathSearchButt)).click();
//		threadwait(7000);

	}

	public void closeInactiveQuery() {
		threadwait(5000);

		String xpathLiLiterature = "//span[normalize-space()='Literature']";
		String xpathQueries = "//span[normalize-space()='Queries..']";
		String xpathQueryList = "//span[normalize-space()='Query List']";
		String xpathFilterbystatus = "//*[@id=\"literatureQueryListForm:literatureQueryGrid:statusType\"]";
		String xpathselectfilterstatus = "//*[@id=\"literatureQueryListForm:literatureQueryGrid:statusType_1\"]";
		String xpatharrow = "//span[@class='ui-icon ui-icon-seek-end']";
		String xpatheditquerybut = "//span[@class='ui-button-icon-left ui-icon ui-c fa fa-pencil-alt jm3']";

		// html/body/div[2]/form[1]/div/div[4]/table/tbody/tr[2]/td[2]/button

		// *[@id="literatureQueryListForm:literatureQueryGrid_data"]/tr/td[2]

		String xpathstatus = "//div[@id='literatureQueryForm:queryTab:status']";
		String xpathselectstatus = "/html/body/div[14]/div[2]/table/tbody/tr[3]";
		String xpathupdate = "//button[@id='literatureQueryForm:j_idt127']//span[@class='ui-button-text ui-c'][normalize-space()='Update']";
		String xpathclose = "//button[@id='literatureQueryForm:j_idt128']//span[@class='ui-button-text ui-c'][normalize-space()='Close']";

		driver.findElement(By.xpath(xpathLiLiterature)).click();
		driver.findElement(By.xpath(xpathQueries)).click();
		driver.findElement(By.xpath(xpathQueryList)).click();
		threadwait(2000);
		driver.findElement(By.xpath(xpathFilterbystatus)).click();
		threadwait(2000);
		driver.findElement(By.xpath(xpathselectfilterstatus)).click();
		threadwait(10000);
		driver.findElement(By.xpath(xpatharrow)).click();
		threadwait(5000);

		driver.findElement(By.xpath(xpatheditquerybut)).click();
		threadwait(2000);
		driver.findElement(By.xpath(xpathstatus)).click();
		driver.findElement(By.xpath(xpathselectstatus)).click();
		threadwait(2000);
		driver.findElement(By.xpath(xpathupdate)).click();
		threadwait(2000);
		driver.findElement(By.xpath(xpathclose)).click();
		threadwait(5000);

	}

	public void createCitationSingle() {
		threadwait(5000);

		String xpathLiLiterature = "//span[normalize-space()='Literature']";
		String xpathQueries = "//span[normalize-space()='Queries..']";
		String xpathCitation = "//span[normalize-space()='Create Citation']";
		String xpathDropBuDown = "//span[@class='ui-icon ui-icon-triangle-1-s']";

		String xpathSelectBuBox = "//*[@id=\"createLiteItemMultiUnitsForm:selectedUnits_panel\"]/div[2]/ul/li[1]/div/div[2]";
		String xpathSavePublish = "//span[normalize-space()='Save & Publish']";
		String xpathYesButton = "//button[@name='createLiteItemMultiUnitsForm:j_idt3432']//span[contains(text(),'Yes')]";

		driver.findElement(By.xpath(xpathLiLiterature)).click();
		driver.findElement(By.xpath(xpathQueries)).click();
		driver.findElement(By.xpath(xpathCitation)).click();
		driver.findElement(By.xpath(xpathDropBuDown)).click();
		threadwait(5000);
		driver.findElement(By.xpath(xpathSelectBuBox)).click();
		driver.findElement(By.xpath("//textarea[@id='createLiteItemMultiUnitsForm:title']")).sendKeys("AutoTesting");
		driver.findElement(By.xpath("//input[@id='createLiteItemMultiUnitsForm:pui']")).sendKeys("UID123");
		driver.findElement(By.xpath("//input[@id='createLiteItemMultiUnitsForm:doi']")).sendKeys("DOI1317");
		driver.findElement(By.xpath(xpathSavePublish)).click();
		driver.findElement(By.xpath(xpathYesButton)).click();
		threadwait(5000);

		driver.findElement(By.xpath("//span[@class='ui-button-icon-left ui-icon ui-c fa fa-eraser']")).click();

		threadwait(2000);
		driver.findElement(By.xpath(xpathLiLiterature)).click();

		driver.findElement(By.xpath(xpathCitation)).click();
		driver.findElement(By.xpath(xpathDropBuDown)).click();
		threadwait(5000);
		driver.findElement(By.xpath(xpathSelectBuBox)).click();
		driver.findElement(By.xpath("//textarea[@id='createLiteItemMultiUnitsForm:title']")).sendKeys("AutoTesting");
		driver.findElement(By.xpath("//input[@id='createLiteItemMultiUnitsForm:pui']")).sendKeys("UID123");
		driver.findElement(By.xpath("//input[@id='createLiteItemMultiUnitsForm:doi']")).sendKeys(doiValue);
		driver.findElement(By.xpath(xpathSavePublish)).click();
		threadwait(2000);
		driver.findElement(
				By.xpath("//button[@name='createLiteItemMultiUnitsForm:j_idt3432']//span[contains(text(),'Yes')]"))
				.click();

	}

	public void ReadExcel() throws IOException {

		FileInputStream fis = new FileInputStream("C:\\Users\\ADMIN\\Desktop\\Automated Testing\\Testing_Date.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.getsheet("sheet1");
		int rowcount = sheet.getLastRowNum();//10
		int colcount = sheet.getRow(1);
		for (int i = 1; i <= rowcount; i++)
		{
			int celldata = sheet.getRow(i);

			
		}
	}
}
