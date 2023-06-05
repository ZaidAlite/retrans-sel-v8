package com.retrans.framework.pageobjects;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.retrans.framework.utils.TestDataFromJsonUtils;
import com.retrans.test.TestBase;

public class ListLiteraturesPage<XSSWorkbook> extends BasePage {
	private static Logger logger = LogManager.getLogger(ListLiteraturesPage.class);

	static SimpleDateFormat timeStampFormat = new SimpleDateFormat("yyyyMMddHHmmssSSS");

	private String testDataFile = "selectMultipleLiteratures.json";
	private List<Map<String, String>> testData = TestDataFromJsonUtils.readJsonTestDataFromFile(testDataFile);

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

	@FindBy(xpath = "//label[@id='literatureQueryForm:queryTab:companyId_label']")
	private WebElement dropdownFiledInCreateQuery;

	@FindBy(xpath = "//div[@id='litPanel:createActionForm:title']//span[@class='ui-icon ui-icon-triangle-1-s ui-c']")
	private WebElement filterByTitleActions;

	@FindBy(xpath = "//label[@id='litPanel:createLitEmailSubmissionForm:status_label']")
	private WebElement filterByEmailStatus;

	@FindBy(xpath = "//div[@id='litMetaDataFormTmp:classificationTypeid']//div//span")
	private WebElement filterByClassificationIcon;

	@FindBy(xpath = "//div[@id='litPanel:createActionForm:status']//span[@class='ui-icon ui-icon-triangle-1-s ui-c']")
	private WebElement filterByStatusActions;

	@FindBy(xpath = "//label[@id='literaturListForm:literatureItemsGrid:comUnitfilid_label']/following::span[1]")
	private WebElement filterByBusinessUnit1;

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

	public void dropdownFiledInCreateQuery(String filterType) {
		String xpath = "//td[normalize-space()='" + filterType + "']";
		dropdownFiledInCreateQuery.click();
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

	public void filterByBusinessUnit1(String businessUnit1) {
		filterByBusinessUnit1.click();
		String xpath = "//tr[@data-label='" + businessUnit1 + "']/td";
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
		driver.get("http://" + TestBase.hostNAME + "/" + TestBase.context + "/views/literatureItems/list.xhtml");
		threadwait(4000);

	}

	public void addCitationDetails(String businessUnit1, String title, String authors, String uid, String doi,
			String issn, String accession_id, String abstractContents, String drugTerms) {

		driver.findElement(By.xpath("//span[normalize-space()='Literature']")).click();
		threadwait(3000);

		driver.findElement(By.xpath("//span[normalize-space()='Queries..']")).click();
		threadwait(3000);

		driver.findElement(By.xpath("//span[normalize-space()='Create Citation']")).click();

		CreateSingleCitation singleCitationPage = new CreateSingleCitation(driver);
		singleCitationPage.addCitationDetails(businessUnit1, title, authors, uid, doi, issn, accession_id,
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

	public void createPubMedQuery() throws IOException {
		logger.info("Creating PubMed Query ");

		Date currentdate = new Date();
		String screenShotFileName = timeStampFormat.format(currentdate);

		threadwait(5000);
		String testDataFile = "selectMultipleLiteratures.json";
		List<Map<String, String>> testData = TestDataFromJsonUtils.readJsonTestDataFromFile(testDataFile);
		String xpathLiLiterature = "//span[normalize-space()='Literature']";
		String xpathQueries = "//span[normalize-space()='Queries..']";
		String xpathQueryList = "//span[normalize-space()='Query List']";
		String xpathCreate = "//button[@id='literatureQueryListForm:literatureQueryGrid:createButton']//span[2]";
		String xpathBusinessUnitDropdown = "//label[@id='literatureQueryForm:queryTab:companyId_label']";
		String xpathBusinessSearhIcon = "//*[@id=\"literatureQueryForm:queryTab:companyId_filter\"]";
		String xpathBuselect = "//*[@id=\"literatureQueryForm:queryTab:companyId_1\"]";
		String xpathSearchSourceDropdown = "//*[@id=\"literatureQueryForm:queryTab:litType_label\"]";
		String xpathSearchSourceIcon = "//*[@id=\"literatureQueryForm:queryTab:litType_filter\"]";
		String xapthSearchSelect = "//*[@id=\"literatureQueryForm:queryTab:litType_1\"]";
		String xpathProductIcon = "//input[@id='literatureQueryForm:queryTab:product']";
		String SearchDate = "//span[@id='literatureQueryForm:queryTab:searchDate']//span[1]";
		String xpathSelectSliderTime = "//div[@class='ui_tpicker_hour_slider ui-slider ui-slider-horizontal ui-widget ui-widget-content ui-corner-all']//span[@class='ui-slider-handle ui-state-default ui-corner-all']";
		String xpathSearchTitle = "//input[@id='literatureQueryForm:queryTab:name']";
		String xpathProjectCode = "//input[@id='literatureQueryForm:queryTab:projCode']";
		String xpathChooseCSV = "//input[@id='literatureQueryForm:queryTab:selectFileBtnCsv_input']";
		String xpathUploadQueryFile = "//button[@class='ui-button ui-widget ui-state-default ui-corner-all ui-button-text-icon-left ui-fileupload-upload']//span[@class='ui-button-text ui-c']";
		String xpathSaveButton = "//button[@id='literatureQueryForm:querySaveButton']//span[@class='ui-button-text ui-c'][normalize-space()='Save']";
		String xpathCloseButt = "//button[@id='literatureQueryForm:querySaveCancelButton']//span[@class='ui-button-text ui-c'][normalize-space()='Close']";
		String xpathInbox = "//li[@id='menuform1:literature']//a[@class='menulink']";
		String xpathAdanceFilterIcon = "//*[@id=\"literaturListForm:literatureItemsGrid:searchCit\"]";
		String xpathCloseLitReview = "//a[@id='filterPanelForm:litItemFilters_toggler']";
		String xpathMoreFilter = "//a[@id='filterPanelForm:toggleable_toggler']";
		String xpathSearchTitleInput = "//input[@id='filterPanelForm:j_idt520']";
		String xpathSearchButt = "//*[@id=\"filterPanelForm:applyFilter\"]";

		String xpathReports = "//span[normalize-space()='Reports']";
		String xpathAdminAudit = "//a[@href='/ReTrans/views/audit/filterPanel.xhtml']//span[contains(text(),'Admin')]";
		String xpathClearButton = "//span[@class='ui-button-icon-left ui-icon ui-c fa fa-eraser F20 gray']";
		String xpathBusinessTransactionId = "//*[@id=\"filterPanelForm:j_idt34\"]";
		String xpathSearchauditButton = "//span[normalize-space()='Search']";
		String xpathSessionId = "//a[@id='auditlistListForm:auditlistGrid:2:j_idt38']";
		String xpathBackButton = "//*[@id=\"auditFieldLogForm:j_idt34\"]";
		String xpathGenerateAll = "//span[normalize-space()='Generate Report(All)']";

		String bUint = testData.get(0).get("CompanyUnit");
		String SearchSource = testData.get(0).get("SearchSource");
		String Description = testData.get(0).get("Description");
		String product = testData.get(0).get("Product");
		String SearchStartDateFromMonth = testData.get(0).get("SearchStartDateFromMonth");
		String SearchStartDatefromYear = testData.get(0).get("SearchStartDatefromYear");
		String SearchStart = testData.get(0).get("SearchStart");
		String SearchStartDateToMonth = testData.get(0).get("SearchStartDateToMonth");
		String SearchStartDateToYear = testData.get(0).get("SearchStartDateToYear");
		String SearchStartTo = testData.get(0).get("SearchStartTo");
		String SearchDateMonth = testData.get(0).get("SearchDateMonth");
		String SearchDateYear = testData.get(0).get("SearchDateYear");
		String SearchDateStart = testData.get(0).get("SearchDateStart");
		String SearchTitle = testData.get(0).get("SearchTitle");
		String CSVfilePath = testData.get(0).get("CSVfilePath");
		String ProjectCode = testData.get(0).get("ProjectCode");

		driver.findElement(By.xpath(xpathLiLiterature)).click();
		logger.info("Clicking on Literature Menu");

		driver.findElement(By.xpath(xpathQueries)).click();
		logger.info("Clicking on Queries List From Literature Menu");

		driver.findElement(By.xpath(xpathQueryList)).click();
		logger.info("Clicking on Query ");

		driver.findElement(By.xpath(xpathCreate)).click();
		logger.info("Clicking on Create Button ");
		threadwait(3000);

		driver.findElement(By.xpath(xpathBusinessUnitDropdown)).click();
		logger.info("Clicking on BusinessUnitDropdown");
		threadwait(3000);

		driver.findElement(By.xpath(xpathBusinessSearhIcon)).sendKeys(bUint);
		logger.info("Clicking on BusinessUnitSearchIcon");

		driver.findElement(By.xpath(xpathBuselect)).click();
		threadwait(3000);
		logger.info("Selecting the BusinessUnit");
		threadwait(3000);

		driver.findElement(By.xpath(xpathSearchSourceDropdown)).click();
		logger.info("Clicking on Search Source Dropdown");

		driver.findElement(By.xpath(xpathSearchSourceIcon)).sendKeys(SearchSource);
		logger.info("Selecting the Search Source");

		driver.findElement(By.xpath(xapthSearchSelect)).click();
		threadwait(3000);
		driver.findElement(By.xpath("//textarea[@id='literatureQueryForm:queryTab:description']"))
				.sendKeys(Description);
		logger.info("Entering the Description");

		driver.findElement(By.xpath(xpathProductIcon)).sendKeys(product);
		logger.info("Entering the Product");

		driver.findElement(By.xpath("//span[@id='literatureQueryForm:queryTab:searchStartDate']//span[1]")).click();
		threadwait(1000);

		Select drpMonth = new Select(driver.findElement(By.className("ui-datepicker-month")));
		drpMonth.selectByVisibleText(SearchStartDateFromMonth);
		threadwait(1000);

		Select drpYear = new Select(driver.findElement(By.className("ui-datepicker-year")));
		drpYear.selectByVisibleText(SearchStartDatefromYear);
		threadwait(1000);

		driver.findElement(By.xpath("//td[@data-handler='selectDay']/a[text()='" + SearchStart + "']")).click();
		threadwait(3000);
		logger.info("Entering the Search Date");

		driver.findElement(By.xpath("//span[@id='literatureQueryForm:queryTab:searchEndDate']//span[1]")).click();

		Select drpMonthTo = new Select(driver.findElement(By.className("ui-datepicker-month")));
		drpMonthTo.selectByVisibleText(SearchStartDateToMonth);
		;

		Select drpYearTo = new Select(driver.findElement(By.className("ui-datepicker-year")));
		drpYearTo.selectByVisibleText(SearchStartDateToYear);

		driver.findElement(By.xpath("//td[@data-handler='selectDay']/a[text()='" + SearchStartTo + "']")).click();
		threadwait(3000);

		driver.findElement(By.xpath(SearchDate)).click();
		;
		logger.info("Entering the Search Dates");

		Select drpMonthSearch = new Select(driver.findElement(By.className("ui-datepicker-month")));
		drpMonthSearch.selectByVisibleText(SearchDateMonth);
		threadwait(3000);

		Select drpYearSearch = new Select(driver.findElement(By.className("ui-datepicker-year")));
		drpYearSearch.selectByVisibleText(SearchDateYear);
		threadwait(3000);
		driver.findElement(By.xpath("//td[@data-handler='selectDay']/a[text()='" + SearchDateStart + "']")).click();
		threadwait(3000);
		logger.info("Entering the Search Dates");
		WebElement Timeslider = driver.findElement(By.xpath(xpathSelectSliderTime));

		Actions move = new Actions(driver);
		Action action = (Action) move.dragAndDropBy(Timeslider, 30, 0).build();
		action.perform();

		logger.info("Selecting Time");

		driver.findElement(By.xpath(xpathSearchTitle)).sendKeys(SearchTitle);
		logger.info("Entering the Search Title");

		driver.findElement(By.xpath(xpathProjectCode)).sendKeys(ProjectCode);
		logger.info("Entering the Project Code");
		threadwait(3000);

		driver.findElement(By.xpath(xpathChooseCSV)).sendKeys(CSVfilePath);
		logger.info("Selecting the Csv File to Upload");
		threadwait(1000);

		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile,
				new File("D://All_Software//ScreenShots//Create_PubMed_Query//createQueryPubMedSceenShot01_"
						+ screenShotFileName + ".png"));

		driver.findElement(By.xpath(xpathUploadQueryFile)).click();
		logger.info("Clickling on Upload Button");

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,400);");
		threadwait(3000);

		driver.findElement(By.xpath(xpathSaveButton)).click();
		logger.info("Clicking on save Button");
		threadwait(15000);

		File screenshotFile1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile1,
				new File("D://All_Software//ScreenShots//Create_PubMed_Query//createQueryPubMedSceenShot02_"
						+ screenShotFileName + ".png"));

		threadwait(20000);
		driver.findElement(By.xpath(xpathCloseButt)).click();
		threadwait(3000);

		driver.findElement(By.xpath(xpathLiLiterature)).click();
		threadwait(3000);

		driver.findElement(By.xpath(xpathInbox)).click();
		threadwait(3000);
		logger.info("Navigating Back to Inbox page");
		threadwait(15000);

		driver.findElement(By.xpath(xpathAdanceFilterIcon)).click();
		logger.info("Navigating to Adance Filter window");
		threadwait(5000);

		driver.findElement(By.xpath(xpathCloseLitReview)).click();
		threadwait(3000);
		driver.findElement(By.xpath(xpathMoreFilter)).click();
		threadwait(3000);

		driver.findElement(By.xpath(xpathSearchTitleInput)).sendKeys(SearchTitle);
		threadwait(3000);
		logger.info("Entering the Title for Search");

		driver.findElement(By.xpath(xpathSearchButt)).click();
		logger.info("Clicking on search Button to Filter the Results");

		File screenshotFile11 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile11,
				new File("D://All_Software//ScreenShots//Create_PubMed_Query//createQueryPubMedSceenShot03_"
						+ screenShotFileName + ".png"));

		threadwait(10000);

		driver.findElement(By.xpath(xpathReports)).click();
		driver.findElement(By.xpath(xpathAdminAudit)).click();
		logger.info("Navigating to Audit Report Filter");

		threadwait(2000);

		driver.findElement(By.xpath(xpathClearButton)).click();
		logger.info("Clearing Audit Report Filter");
		threadwait(10000);

		driver.findElement(By.xpath(xpathBusinessTransactionId)).sendKeys(SearchTitle);
		logger.info("Entering the Created Create PubMed Query SearchTitle For Audit Report");
		threadwait(2000);

		File screenshotFile2 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile2,
				new File("D://All_Software//ScreenShots//Create_PubMed_Query//createQueryPubMedSceenShot04_"
						+ screenShotFileName + ".png"));

		logger.info("ScreenShot taken once Before Applying the Filter ");

		driver.findElement(By.xpath(xpathSearchauditButton)).click();
		logger.info("Clickling Search button For Audit Report");
		threadwait(5000);

		File screenshotFile3 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile3,
				new File("D://All_Software//ScreenShots//Create_PubMed_Query//createQueryPubMedSceenShot05_"
						+ screenShotFileName + ".png"));

		logger.info("ScreenShot after Applying the Filter ");

		driver.findElement(By.xpath(xpathSessionId)).click();
		logger.info("Navigating to Detailed Audit Report Filter");
		threadwait(2000);

		File screenshotFile4 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile4,
				new File("D://All_Software//ScreenShots//Create_PubMed_Query//createQueryPubMedSceenShot06_"
						+ screenShotFileName + ".png"));

		logger.info("ScreenShot of Detailed Audit Report Filter ");

		driver.findElement(By.xpath(xpathBackButton)).click();
		logger.info("Navigating to Audit Report Listing Page");

		driver.findElement(By.xpath(xpathGenerateAll)).click();
		threadwait(5000);
		logger.info("Generating The Audit Report of Create PubMed Query");

	}

	public void createQueryBlank() throws IOException {
		logger.info("Creating Blank Query ");

		Date currentdate = new Date();
		String screenShotFileName = timeStampFormat.format(currentdate);

		threadwait(5000);
		String testDataFile = "selectMultipleLiteratures.json";
		List<Map<String, String>> testData = TestDataFromJsonUtils.readJsonTestDataFromFile(testDataFile);

		String Literature = "//span[normalize-space()='Literature']";
//		String Queries = "//span[normalize-space()='Queries..']";
		String CreateQueryBlank = "/html/body/div[1]/div/form[1]/div/ul/li[1]/ul/li[3]/ul/li[2]/a";
		String BusinessUnit = "//*[@id=\"createNewQueryDialogForm:selectedUnits\"]/ul";
		String BusinessUnitSearchBar = "//input[@aria-label='Filter Input']";
		String BusinessUnitSelect = "//*[@id=\"createNewQueryDialogForm:selectedUnits_panel\"]/div[2]/ul/li[1]/div/div[2]/span";
		String ProductTextField = "//input[@id='createNewQueryDialogForm:product']";
		String SearchTitleTextField = "//input[@id='createNewQueryDialogForm:name']";
		String SearchSource = "//label[@id='createNewQueryDialogForm:litType_label']";
		String SearchSourceInput = "//input[@id='createNewQueryDialogForm:litType_filter']";
		String SelectSearchSource = "/html/body/div[23]/div[2]/table/tbody/tr[1]/td";
		String ProjectCodeTextField = "//input[@id='createNewQueryDialogForm:projCode']";
		String DescriptionTextField = "//textarea[@id='createNewQueryDialogForm:description']";
		String StarCalendar = "//span[@id='createNewQueryDialogForm:searchStartDate']//span[1]";
		String EndCalendar = "//span[@id='createNewQueryDialogForm:searchEndDate']//span[1]";
		String SearchCalendar = "//span[@id='createNewQueryDialogForm:searchDate']//span[1]";
		String HourTime = "//div[@class='ui_tpicker_hour_slider ui-slider ui-slider-horizontal ui-widget ui-widget-content ui-corner-all']//span[@class='ui-slider-handle ui-state-default ui-corner-all']";
		String MinTime = "//div[@class='ui_tpicker_minute_slider ui-slider ui-slider-horizontal ui-widget ui-widget-content ui-corner-all']//span[@class='ui-slider-handle ui-state-default ui-corner-all']";
		String SecTime = "//div[@class='ui_tpicker_second_slider ui-slider ui-slider-horizontal ui-widget ui-widget-content ui-corner-all']//span[@class='ui-slider-handle ui-state-default ui-corner-all']";
		String ProceedButton = "//span[normalize-space()='Proceed']";

		String CompanyUnit = testData.get(11).get("CompanyUnit");
		String Product = testData.get(11).get("Product");
		String SearchTitle = testData.get(11).get("SearchTitle");
		String SearchSou = testData.get(11).get("SearchSource");
		String ProjectCode = testData.get(11).get("ProjectCode");
		String Description = testData.get(11).get("Description");
		String SearchStartDateFromMonth = testData.get(11).get("SearchStartDateFromMonth");
		String SearchStartDatefromYear = testData.get(11).get("SearchStartDatefromYear");
		String SearchStart = testData.get(11).get("SearchStart");
		String SearchStartDateToMonth = testData.get(11).get("SearchStartDateToMonth");
		String SearchStartDateToYear = testData.get(11).get("SearchStartDateToYear");
		String SearchStartTo = testData.get(11).get("SearchStartTo");
		String SearchDateMonth = testData.get(11).get("SearchDateMonth");
		String SearchDateYear = testData.get(11).get("SearchStartDateToYear");
		String SearchDateStart = testData.get(11).get("SearchDateStart");

		String Inbox = "//li[@id='menuform1:literature']//a[@class='menulink']";
		String AdanceFilterIcon = "//*[@id=\"literaturListForm:literatureItemsGrid:searchCit\"]";
		String CloseLitReview = "//a[@id='filterPanelForm:litItemFilters_toggler']";
		String MoreFilter = "//a[@id='filterPanelForm:toggleable_toggler']";
		String SearchTitleInput = "//input[@id='filterPanelForm:j_idt520']";
		String SearchButt = "//*[@id=\"filterPanelForm:applyFilter\"]";

		String Reports = "//span[normalize-space()='Reports']";
		String AdminAudit = "//a[@href='/ReTrans/views/audit/filterPanel.xhtml']//span[contains(text(),'Admin')]";
		String ClearButton = "//span[@class='ui-button-icon-left ui-icon ui-c fa fa-eraser F20 gray']";
		String BusinessTransactionId = "//*[@id=\"filterPanelForm:j_idt34\"]";
		String SearchauditButton = "//span[normalize-space()='Search']";
		String SessionId = "//a[@id='auditlistListForm:auditlistGrid:0:j_idt38']";
		String BackButton = "//*[@id=\"auditFieldLogForm:j_idt34\"]";
		String GenerateAll = "//span[normalize-space()='Generate Report(All)']";

		driver.findElement(By.xpath(Literature)).click();
		logger.info("Navigating To Literature Menu");

		// driver.findElement(By.xpath(Queries)).click();
		logger.info("Navigating To Literature Queries List");
		threadwait(8000);

		driver.findElement(By.xpath(CreateQueryBlank)).click();
		logger.info("Navigating To Create Query Blank Window");

		driver.findElement(By.xpath(BusinessUnit)).click();
		driver.findElement(By.xpath(BusinessUnitSearchBar)).sendKeys(CompanyUnit);
		threadwait(5000);

		driver.findElement(By.xpath(BusinessUnitSelect)).click();
		logger.info("Selecting the Business Unit To Create Query Blank");

		driver.findElement(By.xpath(ProductTextField)).click();
		threadwait(1000);

		driver.findElement(By.xpath(ProductTextField)).sendKeys(Product);
		logger.info("Entering the Product To Create Query Blank");
		threadwait(1000);

		driver.findElement(By.xpath(SearchTitleTextField)).sendKeys(SearchTitle);
		logger.info("Entering the Search Title To Create Query Blank");
		threadwait(1000);

		driver.findElement(By.xpath(SearchSource)).click();
		driver.findElement(By.xpath(SearchSourceInput)).sendKeys(SearchSou);
		threadwait(2000);
		driver.findElement(By.xpath(SelectSearchSource)).click();
		logger.info("Selecting the Search Source To Create Query Blank");

		driver.findElement(By.xpath(ProjectCodeTextField)).sendKeys(ProjectCode);
		logger.info("Entering the Project Code To Create Query Blank");
		threadwait(1000);

		driver.findElement(By.xpath(DescriptionTextField)).sendKeys(Description);
		logger.info("Entering the Description To Create Query Blank");
		threadwait(1000);

		driver.findElement(By.xpath(StarCalendar)).click();
		threadwait(1000);

		Select drpMonth = new Select(driver.findElement(By.className("ui-datepicker-month")));
		drpMonth.selectByVisibleText(SearchStartDateFromMonth);
		threadwait(1000);

		Select drpYear = new Select(driver.findElement(By.className("ui-datepicker-year")));
		drpYear.selectByVisibleText(SearchStartDatefromYear);
		threadwait(1000);

		driver.findElement(By.xpath("//td[@data-handler='selectDay']/a[text()='" + SearchStart + "']")).click();
		threadwait(3000);
		logger.info("Entering the Search Date");

		driver.findElement(By.xpath(EndCalendar)).click();

		Select drpMonthTo = new Select(driver.findElement(By.className("ui-datepicker-month")));
		drpMonthTo.selectByVisibleText(SearchStartDateToMonth);
		;

		Select drpYearTo = new Select(driver.findElement(By.className("ui-datepicker-year")));
		drpYearTo.selectByVisibleText(SearchStartDateToYear);

		driver.findElement(By.xpath("//td[@data-handler='selectDay']/a[text()='" + SearchStartTo + "']")).click();

		driver.findElement(By.xpath(SearchCalendar)).click();
		;
		logger.info("Entering the Search Dates");

		Select drpMonthSearch = new Select(driver.findElement(By.className("ui-datepicker-month")));
		drpMonthSearch.selectByVisibleText(SearchDateMonth);
		threadwait(3000);

		Select drpYearSearch = new Select(driver.findElement(By.className("ui-datepicker-year")));
		drpYearSearch.selectByVisibleText(SearchDateYear);
		threadwait(1500);

		driver.findElement(By.xpath("//td[@data-handler='selectDay']/a[text()='" + SearchDateStart + "']")).click();
		threadwait(3000);
		logger.info("Entering the Search Dates");

		WebElement Timeslider = driver.findElement(By.xpath(HourTime));

		Actions move = new Actions(driver);
		Action action = (Action) move.dragAndDropBy(Timeslider, 30, 0).build();
		action.perform();

		logger.info("Selecting  Hour Time");
		threadwait(3000);

		WebElement TimesliderMin = driver.findElement(By.xpath(MinTime));

		Actions move1 = new Actions(driver);
		Action action1 = (Action) move1.dragAndDropBy(TimesliderMin, 40, 0).build();
		action1.perform();

		logger.info("Selecting  Min Time");
		threadwait(3000);

		WebElement TimesliderSec = driver.findElement(By.xpath(SecTime));

		Actions move11 = new Actions(driver);
		Action action11 = (Action) move11.dragAndDropBy(TimesliderSec, 50, 0).build();
		action11.perform();

		logger.info("Selecting  Sec time ");
		threadwait(3000);

		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile,
				new File("D://All_Software//ScreenShots//Create_Query_Blank//createQueryBlankSceenShot01_"
						+ screenShotFileName + ".png"));

		threadwait(1000);

		driver.findElement(By.xpath(ProceedButton)).click();
		logger.info("Clicking on Proceed button to Create Black Query");
		threadwait(3000);

		driver.findElement(By.xpath(Literature)).click();
		driver.findElement(By.xpath(Inbox)).click();
		threadwait(3000);

		driver.findElement(By.xpath(AdanceFilterIcon)).click();
		logger.info("Navigating To Adance Filter Window");
		threadwait(3000);

		driver.findElement(By.xpath(CloseLitReview)).click();
		threadwait(3000);

		driver.findElement(By.xpath(MoreFilter)).click();
		driver.findElement(By.xpath(SearchTitleInput)).sendKeys(SearchTitle);
		logger.info("Entering the Search Ttile to Filter the Query");
		threadwait(3000);

		driver.findElement(By.xpath(SearchButt)).click();
		logger.info("CLicking Search Button");
		threadwait(6000);

		File screenshotFile1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile1,
				new File("D://All_Software//ScreenShots//Create_Query_Blank//createQueryBlankSceenShot02_"
						+ screenShotFileName + ".png"));

		driver.findElement(By.xpath(Reports)).click();
		driver.findElement(By.xpath(AdminAudit)).click();
		logger.info("Navigating To Audit Report Page");
		threadwait(3000);

		driver.findElement(By.xpath(ClearButton)).click();
		logger.info("Clearing the Audit Report Filter");
		threadwait(3000);

		driver.findElement(By.xpath(BusinessTransactionId)).sendKeys(SearchTitle);
		logger.info("Entering the Search Title For Audit Report ");
		threadwait(3000);

		File screenshotFile2 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile2,
				new File("D://All_Software//ScreenShots//Create_Query_Blank//createQueryBlankSceenShot03_"
						+ screenShotFileName + ".png"));

		logger.info("ScreenShot taken once Before Applying the Filter ");

		driver.findElement(By.xpath(SearchauditButton)).click();
		logger.info("Clickin on Search Button For Audit Report");
		threadwait(5000);

		driver.findElement(By.xpath(SessionId)).click();
		logger.info("Navigating To Deatiled Audit Report");
		threadwait(5000);

		File screenshotFile3 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile3,
				new File("D://All_Software//ScreenShots//Create_Query_Blank//createQueryBlankSceenShot04_"
						+ screenShotFileName + ".png"));

		logger.info("ScreenShot taken once After Applying the Filter ");

		driver.findElement(By.xpath(BackButton)).click();
		threadwait(3000);

		driver.findElement(By.xpath(GenerateAll)).click();
		logger.info("Generating The Audit Report of Create Blank Query");

	}

	public void createEmbaseQuery() throws IOException {
		logger.info("Creating Embase Query ");

		Date currentdate = new Date();
		String screenShotFileName = timeStampFormat.format(currentdate);

		threadwait(5000);
		String testDataFile = "selectMultipleLiteratures.json";
		List<Map<String, String>> testData = TestDataFromJsonUtils.readJsonTestDataFromFile(testDataFile);
		String xpathLiLiterature = "//span[normalize-space()='Literature']";
		String xpathQueries = "//span[normalize-space()='Queries..']";
		String xpathQueryList = "//span[normalize-space()='Query List']";
		String xpathCreate = "//button[@id='literatureQueryListForm:literatureQueryGrid:createButton']//span[2]";
		String xpathBusinessUnitDropdown = "//label[@id='literatureQueryForm:queryTab:companyId_label']";
		String xpathBusinessSearhIcon = "//*[@id=\"literatureQueryForm:queryTab:companyId_filter\"]";
		String xpathBuselect = "//*[@id=\"literatureQueryForm:queryTab:companyId_1\"]";
		String xpathSearchSourceDropdown = "//*[@id=\"literatureQueryForm:queryTab:litType_label\"]";
		String xpathSearchSourceIcon = "//*[@id=\"literatureQueryForm:queryTab:litType_filter\"]";
		String xapthSearchSelect = "//*[@id=\"literatureQueryForm:queryTab:litType_0\"]";
		String xpathProductIcon = "//input[@id='literatureQueryForm:queryTab:product']";
		String SearchDate = "//span[@id='literatureQueryForm:queryTab:searchDate']//span[1]";
		String xpathSelectSliderTime = "//div[@class='ui_tpicker_hour_slider ui-slider ui-slider-horizontal ui-widget ui-widget-content ui-corner-all']//span[@class='ui-slider-handle ui-state-default ui-corner-all']";
		String xpathSearchTitle = "//input[@id='literatureQueryForm:queryTab:name']";
		String xpathProjectCode = "//input[@id='literatureQueryForm:queryTab:projCode']";
		String xpathChooseCSV = "//input[@id='literatureQueryForm:queryTab:selectFileBtnCsv_input']";
		String xpathUploadQueryFile = "//button[@class='ui-button ui-widget ui-state-default ui-corner-all ui-button-text-icon-left ui-fileupload-upload']//span[@class='ui-button-text ui-c']";
		String xpathSaveButton = "//button[@id='literatureQueryForm:querySaveButton']//span[@class='ui-button-text ui-c'][normalize-space()='Save']";
		String xpathCloseButt = "//button[@id='literatureQueryForm:querySaveCancelButton']//span[@class='ui-button-text ui-c'][normalize-space()='Close']";
		String xpathInbox = "//li[@id='menuform1:literature']//a[@class='menulink']";
		String xpathAdanceFilterIcon = "//*[@id=\"literaturListForm:literatureItemsGrid:searchCit\"]";
		String xpathCloseLitReview = "//a[@id='filterPanelForm:litItemFilters_toggler']";
		String xpathMoreFilter = "//a[@id='filterPanelForm:toggleable_toggler']";
		String xpathSearchTitleInput = "//input[@id='filterPanelForm:j_idt520']";
		String xpathSearchButt = "//*[@id=\"filterPanelForm:applyFilter\"]";

		String xpathReports = "//span[normalize-space()='Reports']";
		String xpathAdminAudit = "//a[@href='/ReTrans/views/audit/filterPanel.xhtml']//span[contains(text(),'Admin')]";
		String xpathClearButton = "//span[@class='ui-button-icon-left ui-icon ui-c fa fa-eraser F20 gray']";
		String xpathBusinessTransactionId = "//*[@id=\"filterPanelForm:j_idt34\"]";
		String xpathSearchauditButton = "//span[normalize-space()='Search']";
		String xpathSessionId = "//a[@id='auditlistListForm:auditlistGrid:2:j_idt38']";
		String xpathBackButton = "//*[@id=\"auditFieldLogForm:j_idt34\"]";
		String xpathGenerateAll = "//span[normalize-space()='Generate Report(All)']";

		String bUint = testData.get(1).get("CompanyUnitForEmbase");
		String SearchSource = testData.get(1).get("SearchSourceForEmbase");
		String Description = testData.get(1).get("DescriptionForEmbase");
		String product = testData.get(1).get("ProductForEmbase");
		String SearchStartDateFromMonth = testData.get(1).get("SearchStartDateFromMonthForEmbase");
		String SearchStartDatefromYear = testData.get(1).get("SearchStartDatefromYearForEmbase");
		String SearchStart = testData.get(1).get("SearchStartForEmbase");
		String SearchStartDateToMonth = testData.get(1).get("SearchStartDateToMonthForEmbase");
		String SearchStartDateToYear = testData.get(1).get("SearchStartDateToYearForEmbase");
		String SearchStartTo = testData.get(1).get("SearchStartToForEmbase");
		String SearchDateMonth = testData.get(1).get("SearchDateMonthForEmbase");
		String SearchDateYear = testData.get(1).get("SearchDateYearForEmbase");
		String SearchDateStart = testData.get(1).get("SearchDateStartForEmbase");
		String SearchTitle = testData.get(1).get("SearchTitleForEmbase");
		String ProjectCode = testData.get(1).get("ProjectCodeForEmbase");
		String CSVfilePathEmbase = testData.get(1).get("CSVfilePathEmbaseForEmbase");

		driver.findElement(By.xpath(xpathLiLiterature)).click();
		logger.info("Clicking on Literature Menu");

		driver.findElement(By.xpath(xpathQueries)).click();
		logger.info("Clicking on Queries List From Literature Menu");

		driver.findElement(By.xpath(xpathQueryList)).click();
		logger.info("Clicking on Query ");

		driver.findElement(By.xpath(xpathCreate)).click();
		logger.info("Clicking on Create Button ");
		threadwait(3000);

		driver.findElement(By.xpath(xpathBusinessUnitDropdown)).click();
		logger.info("Clicking on BusinessUnitDropdown");
		threadwait(3000);

		driver.findElement(By.xpath(xpathBusinessSearhIcon)).sendKeys(bUint);
		logger.info("Clicking on BusinessUnitSearchIcon");

		driver.findElement(By.xpath(xpathBuselect)).click();
		threadwait(3000);
		logger.info("Selecting the BusinessUnit");
		threadwait(3000);

		driver.findElement(By.xpath(xpathSearchSourceDropdown)).click();
		logger.info("Clicking on Search Source Dropdown");

		driver.findElement(By.xpath(xpathSearchSourceIcon)).sendKeys(SearchSource);
		logger.info("Selecting the Search Source");

		driver.findElement(By.xpath(xapthSearchSelect)).click();
		threadwait(3000);
		driver.findElement(By.xpath("//textarea[@id='literatureQueryForm:queryTab:description']"))
				.sendKeys(Description);
		logger.info("Entering the Description");

		driver.findElement(By.xpath(xpathProductIcon)).sendKeys(product);
		logger.info("Entering the Product");

		driver.findElement(By.xpath("//span[@id='literatureQueryForm:queryTab:searchStartDate']//span[1]")).click();
		threadwait(1000);

		Select drpMonth = new Select(driver.findElement(By.className("ui-datepicker-month")));
		drpMonth.selectByVisibleText(SearchStartDateFromMonth);
		threadwait(1000);
		Select drpYear = new Select(driver.findElement(By.className("ui-datepicker-year")));
		drpYear.selectByVisibleText(SearchStartDatefromYear);
		threadwait(1000);
		driver.findElement(By.xpath("//td[@data-handler='selectDay']/a[text()='" + SearchStart + "']")).click();
		threadwait(3000);
		logger.info("Entering the Search Date");

		driver.findElement(By.xpath("//span[@id='literatureQueryForm:queryTab:searchEndDate']//span[1]")).click();

		Select drpMonthTo = new Select(driver.findElement(By.className("ui-datepicker-month")));
		drpMonthTo.selectByVisibleText(SearchStartDateToMonth);
		;

		Select drpYearTo = new Select(driver.findElement(By.className("ui-datepicker-year")));
		drpYearTo.selectByVisibleText(SearchStartDateToYear);

		driver.findElement(By.xpath("//td[@data-handler='selectDay']/a[text()='" + SearchStartTo + "']")).click();

		driver.findElement(By.xpath(SearchDate)).click();
		;
		logger.info("Entering the Search Dates");

		Select drpMonthSearch = new Select(driver.findElement(By.className("ui-datepicker-month")));
		drpMonthSearch.selectByVisibleText(SearchDateMonth);
		threadwait(3000);

		Select drpYearSearch = new Select(driver.findElement(By.className("ui-datepicker-year")));
		drpYearSearch.selectByVisibleText(SearchDateYear);
		threadwait(3000);
		driver.findElement(By.xpath("//td[@data-handler='selectDay']/a[text()='" + SearchDateStart + "']")).click();
		threadwait(3000);
		logger.info("Entering the Search Dates");
		WebElement Timeslider = driver.findElement(By.xpath(xpathSelectSliderTime));

		Actions move = new Actions(driver);
		Action action = (Action) move.dragAndDropBy(Timeslider, 30, 0).build();
		action.perform();

		logger.info("Selecting Time");

		driver.findElement(By.xpath(xpathSearchTitle)).sendKeys(SearchTitle);
		logger.info("Entering the Search Title");

		driver.findElement(By.xpath(xpathProjectCode)).sendKeys(ProjectCode);
		logger.info("Entering the Project Code");
		threadwait(3000);

		driver.findElement(By.xpath(xpathChooseCSV)).sendKeys(CSVfilePathEmbase);
		logger.info("Selecting the Csv File to Upload");
		threadwait(1000);

		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile,
				new File("D://All_Software//ScreenShots//Create_Embase_Query//createQueryEmbaseSceenShot01_"
						+ screenShotFileName + ".png"));

		driver.findElement(By.xpath(xpathUploadQueryFile)).click();
		logger.info("Clickling on Upload Button");

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,400);");
		threadwait(3000);

		driver.findElement(By.xpath(xpathSaveButton)).click();
		logger.info("Clicking on save Button");
		threadwait(15000);

		File screenshotFile1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile1,
				new File("D://All_Software//ScreenShots//Create_Embase_Query//createQueryEmbaseSceenShot02_"
						+ screenShotFileName + ".png"));

		threadwait(3000);

		driver.findElement(By.xpath(xpathCloseButt)).click();
		threadwait(3000);

		driver.findElement(By.xpath(xpathLiLiterature)).click();
		threadwait(3000);
		driver.findElement(By.xpath(xpathInbox)).click();
		threadwait(3000);
		logger.info("Navigating Back to Inbox page");
		threadwait(15000);

		driver.findElement(By.xpath(xpathAdanceFilterIcon)).click();
		logger.info("Navigating to Adance Filter window");
		threadwait(5000);

		driver.findElement(By.xpath(xpathCloseLitReview)).click();
		threadwait(3000);

		driver.findElement(By.xpath(xpathMoreFilter)).click();
		threadwait(3000);

		driver.findElement(By.xpath(xpathSearchTitleInput)).sendKeys(SearchTitle);
		threadwait(3000);
		logger.info("Entering the Title for Search");

		driver.findElement(By.xpath(xpathSearchButt)).click();
		logger.info("Clicking on search Button to Filter the Results");
		threadwait(5000);

		File screenshotFile11 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile11,
				new File("D://All_Software//ScreenShots//Create_Embase_Query//createQueryEmbaseSceenShot03_"
						+ screenShotFileName + ".png"));

		threadwait(10000);

		driver.findElement(By.xpath(xpathReports)).click();
		driver.findElement(By.xpath(xpathAdminAudit)).click();
		logger.info("Navigating to Audit Report Filter");

		threadwait(2000);

		driver.findElement(By.xpath(xpathClearButton)).click();
		logger.info("Clearing Audit Report Filter");
		threadwait(10000);

		driver.findElement(By.xpath(xpathBusinessTransactionId)).sendKeys(SearchTitle);
		logger.info("Entering the Created Create PubMed Query SearchTitle For Audit Report");
		threadwait(2000);

		File screenshotFile2 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile2,
				new File("D://All_Software//ScreenShots//Create_Embase_Query//createQueryEmbaseSceenShot04_"
						+ screenShotFileName + ".png"));

		logger.info("ScreenShot taken once Before Applying the Filter ");

		driver.findElement(By.xpath(xpathSearchauditButton)).click();
		logger.info("Clickling Search button For Audit Report");
		threadwait(5000);

		File screenshotFile3 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile3,
				new File("D://All_Software//ScreenShots//Create_Embase_Query//createQueryEmbaseSceenShot05_"
						+ screenShotFileName + ".png"));

		logger.info("ScreenShot after Applying the Filter ");

		driver.findElement(By.xpath(xpathSessionId)).click();
		logger.info("Navigating to Detailed Audit Report Filter");
		threadwait(2000);

		File screenshotFile4 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile4,
				new File("D://All_Software//ScreenShots//Create_Embase_Query//createQueryEmbaseSceenShot06_"
						+ screenShotFileName + ".png"));

		logger.info("ScreenShot of Detailed Audit Report Filter ");

		driver.findElement(By.xpath(xpathBackButton)).click();
		logger.info("Navigating to Audit Report Listing Page");

		driver.findElement(By.xpath(xpathGenerateAll)).click();
		threadwait(5000);
		logger.info("Generating The Audit Report of Create PubMed Query");

	}

	public void bulkClaimReset() throws IOException {
		threadwait(5000);

		logger.info("Claiming Bulk & Reset ");

		Date currentdate = new Date();
		String screenShotFileName = timeStampFormat.format(currentdate);

		threadwait(5000);
		String testDataFile = "selectMultipleLiteratures.json";
		List<Map<String, String>> testData = TestDataFromJsonUtils.readJsonTestDataFromFile(testDataFile);
		String xpathLiLiterature = "//span[normalize-space()='Literature']";

		String xpathInboxBack = "/html/body/div[1]/div/form[1]/div/ul/li[1]/ul/li[5]/a";
		String xpathFilter = "//*[@id=\"literaturListForm:literatureItemsGrid:claimid\"]";
		String xpathFilterBy = "//input[@id='literaturListForm:literatureItemsGrid:claimid_filter']";
		String xpathSelectFilter = "//*[@id=\"literaturListForm:literatureItemsGrid:claimid_1\"]";
		String xpathSelectClamied = "//tr[@id='literaturListForm:literatureItemsGrid:claimid_3']";
		String xpathPageArrown = "//span[@class='ui-icon ui-icon-seek-end']";
		String xapthCheckBox = "//*[@id=\"literaturListForm:literatureItemsGrid:cbSelection\"]/div/div[2]/span";
		String xpathClaimButton = "//button[@id='literaturListForm:literatureItemsGrid:claimAllBtn']//span[@class='ui-button-icon-left ui-icon ui-c fa fa-tasks']";
		String xpathconfirmation = "//span[normalize-space()='Yes']";
		String xpathClearButton = "//span[@class='ui-button-icon-left ui-icon ui-c fa fa-eraser']";
		String xpathResetButton = "//span[@class='ui-button-icon-left ui-icon ui-c fa fa-list-ul']";
		String xpathResetconfirmation = "//span[normalize-space()='Yes']";
		String xpathfirstArrow = "//span[@class='ui-icon ui-icon-seek-first']";

		String xpathReports = "//span[normalize-space()='Reports']";
		String xpathAdminAudit = "//a[@href='/ReTrans/views/audit/filterPanel.xhtml']//span[contains(text(),'Admin')]";
		String xpathClearButtonAudit = "//span[@class='ui-button-icon-left ui-icon ui-c fa fa-eraser F20 gray']";
		String xpathBusinessTransactionId = "//*[@id=\"filterPanelForm:j_idt34\"]";
		String xpathSearchauditButton = "//span[normalize-space()='Search']";
		String xpathSessionId = "//a[@id='auditlistListForm:auditlistGrid:0:j_idt38']";
		String xpathBackButton = "//*[@id=\"auditFieldLogForm:j_idt34\"]";
		String xpathGenerateAll = "//span[normalize-space()='Generate Report(All)']";
		String xpathBackAudit = "//span[normalize-space()='Back']";

		String FilterByClaim = testData.get(2).get("FilterByClaim");
		String FilterByClaimed = testData.get(2).get("FilterByClaimed");
		String UserID = testData.get(2).get("UserID");

		driver.findElement(By.xpath(xpathLiLiterature)).click();
		driver.findElement(By.xpath(xpathInboxBack)).click();
		logger.info("Navigating to Inbox page");

		driver.findElement(By.xpath(xpathFilter)).click();
		driver.findElement(By.xpath(xpathFilterBy)).sendKeys(FilterByClaim);
		driver.findElement(By.xpath(xpathSelectFilter)).click();
		logger.info("Filter by Unclaimed");
		threadwait(15000);

		driver.findElement(By.xpath(xpathPageArrown)).click();
		logger.info("Navigating to last page of Unclaimed");
		threadwait(10000);

		driver.findElement(By.xpath(xapthCheckBox)).click();
		logger.info("Selecting bulk cication");

		driver.findElement(By.xpath(xpathClaimButton)).click();
		logger.info("Clicking on Claim button");
		threadwait(1000);

		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile,
				new File("D://All_Software//ScreenShots//Bulk_Claim_Reset//BulkClaimResetScreenShot01_"
						+ screenShotFileName + ".png"));

		driver.findElement(By.xpath(xpathconfirmation)).click();
		logger.info("Clicking on Claim button");
		threadwait(10000);

		driver.findElement(By.xpath(xpathClearButton)).click();
		logger.info("Clicking on Clear button");
		threadwait(10000);
		driver.findElement(By.xpath(xpathReports)).click();
		driver.findElement(By.xpath(xpathAdminAudit)).click();
		logger.info("Navigating to Audit Report Filter");

		threadwait(2000);

		driver.findElement(By.xpath(xpathClearButtonAudit)).click();
		logger.info("Clearing Audit Report Filter");
		threadwait(10000);

		driver.findElement(By.xpath(xpathBusinessTransactionId)).sendKeys(UserID);
		logger.info("Entering the UserID For Audit Report");
		threadwait(2000);

		File screenshotFile1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile1,
				new File("D://All_Software//ScreenShots//Bulk_Claim_Reset//BulkClaimResetScreenShot02_"
						+ screenShotFileName + ".png"));

		logger.info("ScreenShot taken once Before Applying the Filter ");

		driver.findElement(By.xpath(xpathSearchauditButton)).click();
		logger.info("Clickling Search button For Audit Report");
		threadwait(5000);

		File screenshotFile2 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile2,
				new File("D://All_Software//ScreenShots//Bulk_Claim_Reset//BulkClaimResetScreenShot03_"
						+ screenShotFileName + ".png"));

		logger.info("ScreenShot after Applying the Filter ");

		driver.findElement(By.xpath(xpathSessionId)).click();
		logger.info("Navigating to Detailed Audit Report Filter");
		threadwait(2000);

		File screenshotFile3 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile3,
				new File("D://All_Software//ScreenShots//Bulk_Claim_Reset//BulkClaimResetScreenShot04_"
						+ screenShotFileName + ".png"));

		logger.info("ScreenShot of Detailed Audit Report Filter ");

		driver.findElement(By.xpath(xpathBackButton)).click();
		logger.info("Navigating to Audit Report Listing Page");

		driver.findElement(By.xpath(xpathGenerateAll)).click();
		threadwait(5000);
		logger.info("Generating The Audit Report For Bulk Claim ");
		threadwait(5000);

		driver.findElement(By.xpath(xpathBackAudit)).click();

		driver.findElement(By.xpath(xpathLiLiterature)).click();
		threadwait(3000);
		driver.findElement(By.xpath(xpathInboxBack)).click();
		logger.info("Navigating to Inbox page");
		threadwait(2000);

		driver.findElement(By.xpath(xpathFilter)).click();
		threadwait(2000);
		driver.findElement(By.xpath(xpathFilterBy)).sendKeys(FilterByClaimed);
		threadwait(2000);
		driver.findElement(By.xpath(xpathSelectClamied)).click();
		logger.info("Filter by Clamied by me");
		threadwait(10000);

		driver.findElement(By.xpath(xpathfirstArrow)).click();
		logger.info("Navigating to First page of claimed by me");
		threadwait(15000);

		driver.findElement(By.xpath(xapthCheckBox)).click();
		logger.info("Selecting bulk cication");
		threadwait(15000);

		driver.findElement(By.xpath(xpathResetButton)).click();
		logger.info("Clicking on Reset button");

		File screenshotFile4 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile4,
				new File("D://All_Software//ScreenShots//Bulk_Claim_Reset//BulkClaimResetScreenShot05_"
						+ screenShotFileName + ".png"));

		driver.findElement(By.xpath(xpathResetconfirmation)).click();

		threadwait(10000);
		driver.findElement(By.xpath(xpathReports)).click();
		driver.findElement(By.xpath(xpathAdminAudit)).click();
		logger.info("Navigating to Audit Report Filter");

		threadwait(2000);

		driver.findElement(By.xpath(xpathClearButtonAudit)).click();
		logger.info("Clearing Audit Report Filter");
		threadwait(10000);

		driver.findElement(By.xpath(xpathBusinessTransactionId)).sendKeys(UserID);
		logger.info("Entering the UserID For Audit Report");
		threadwait(2000);

		File screenshotFile5 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile5,
				new File("D://All_Software//ScreenShots//Bulk_Claim_Reset//BulkClaimResetScreenShot06_"
						+ screenShotFileName + ".png"));

		logger.info("ScreenShot taken once Before Applying the Filter ");

		driver.findElement(By.xpath(xpathSearchauditButton)).click();
		logger.info("Clickling Search button For Audit Report");
		threadwait(5000);

		File screenshotFile6 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile6,
				new File("D://All_Software//ScreenShots//Bulk_Claim_Reset//BulkClaimResetScreenShot07_"
						+ screenShotFileName + ".png"));

		logger.info("ScreenShot after Applying the Filter ");

		driver.findElement(By.xpath(xpathSessionId)).click();
		logger.info("Navigating to Detailed Audit Report Filter");
		threadwait(2000);

		File screenshotFile7 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile7,
				new File("D://All_Software//ScreenShots//Bulk_Claim_Reset//BulkClaimResetScreenShot08_"
						+ screenShotFileName + ".png"));

		logger.info("ScreenShot of Detailed Audit Report Filter ");

		driver.findElement(By.xpath(xpathBackButton)).click();
		logger.info("Navigating to Audit Report Listing Page");

		driver.findElement(By.xpath(xpathGenerateAll)).click();
		threadwait(5000);
		logger.info("Generating The Audit Report For Bulk Reset Claim ");

	}

	public void createUser() throws IOException {
		threadwait(5000);

		logger.info("Creating a user and verifying created user Audit`");

		Date currentdate = new Date();
		String screenShotFileName = timeStampFormat.format(currentdate);

		threadwait(5000);
		String testDataFile = "selectMultipleLiteratures.json";
		List<Map<String, String>> testData = TestDataFromJsonUtils.readJsonTestDataFromFile(testDataFile);

		String xpathSecurity = "//*[@id=\"menuform1:security\"]/a/span";
		String xpathUser = "//*[@id=\"menuform1:user\"]/a";
		String xpathCreate = "//span[normalize-space()='Create']";
		String xpathAppUserIdTextField = "//input[@id='appUserForm:userId']";
		String xpathUserFirstNameTextField = "//input[@id='appUserForm:firstname']";
		String xpathUserLastNameTextField = "//input[@id='appUserForm:lastname']";
		String xpathAppEmailIdTextField = "//input[@id='appUserForm:emailId']";
		String xpathPasswordTextField = "//input[@id='appUserForm:password']";
		String xpathConfirmPasswordTextField = "//input[@id='appUserForm:confPassword1']";
		String xpathTelephoneTextField = "//input[@id='appUserForm:phone']";
		String xpathAddressTextField = "//textarea[@id='appUserForm:address']";
		String xpathAssign = "//span[@class='ui-button-icon-left ui-icon ui-c ui-icon ui-icon-arrowstop-1-e']";
		String xpathChangePassword = "//div[@id='appUserForm:passChngOnLogOn']//span[@class='ui-button-text ui-c'][normalize-space()='NO']";
		String xpathSaveandClose = "//span[normalize-space()='Save and Close']";
		String xpathAdanceFilter = "//span[@class='ui-button-text ui-c'][normalize-space()='Advance Filter']";
		String xpathUserIdTextField = "//input[@id='filterPanelForm:j_idt77']";
		String xpathSearchButton = "//span[@class='ui-button-icon-left ui-icon ui-c fa fa-search F16 white']";
		String xpathUserName = "//a[@id='appUserListForm:appUserGrid:0:j_idt44']";
		String xpathBULookUp = "//span[@class='ui-button-icon-left ui-icon ui-c fa fa-search F20 white']";
		String xpathSelectUnit = "//*[@id=\"userCompanyUnitLookForm:companyUnitGrid_data\"]/tr[1]/td[1]/div/div[2]/span";
		String xpathSelectButton = "//span[normalize-space()='Select']";
		String xpathReports = "//span[normalize-space()='Reports']";
		String xpathAdminAudit = "//a[@href='/ReTrans/views/audit/filterPanel.xhtml']//span[contains(text(),'Admin')]";
		String xpathClearButton = "//span[@class='ui-button-icon-left ui-icon ui-c fa fa-eraser F20 gray']";
		String xpathBusinessTransactionId = "//*[@id=\"filterPanelForm:j_idt34\"]";
		String xpathSearchauditButton = "//span[normalize-space()='Search']";
		String xpathGenerateAll = "//span[normalize-space()='Generate Report(All)']";

		String xpathSessionId = "//a[@id='auditlistListForm:auditlistGrid:1:j_idt38']";
		String xpathBackButton = "//*[@id=\"auditFieldLogForm:j_idt34\"]";
		String xpathBackAudit = "//span[normalize-space()='Back']";

		String AppUserId = testData.get(3).get("AppUserId");
		String UserFirstName = testData.get(3).get("UserFirstName");
		String UserLastName = testData.get(3).get("UserLastName");
		String AppEmailId = testData.get(3).get("AppEmailId");
		String Password = testData.get(3).get("Password");
		String ConfirmPassword = testData.get(3).get("ConfirmPassword");
		String Telephone = testData.get(3).get("Telephone");
		String Address = testData.get(3).get("Address");

		driver.findElement(By.xpath(xpathSecurity)).click();
		driver.findElement(By.xpath(xpathUser)).click();
		logger.info("Navigating to User listing page");
		threadwait(2000);

		driver.findElement(By.xpath(xpathCreate)).click();
		threadwait(2000);
		logger.info("Navigating to Create user page");

		driver.findElement(By.xpath(xpathAppUserIdTextField)).sendKeys(AppUserId);

		logger.info("Entering the App User id");
		driver.findElement(By.xpath(xpathUserFirstNameTextField)).sendKeys(UserFirstName);

		logger.info("Entering the First Name");
		driver.findElement(By.xpath(xpathUserLastNameTextField)).sendKeys(UserLastName);

		logger.info("Entering the Last Name");
		driver.findElement(By.xpath(xpathAppEmailIdTextField)).sendKeys(AppEmailId);

		logger.info("Entering the Email id");
		driver.findElement(By.xpath(xpathPasswordTextField)).sendKeys(Password);

		logger.info("Entering the password");
		driver.findElement(By.xpath(xpathConfirmPasswordTextField)).sendKeys(ConfirmPassword);

		logger.info("Entering the Confrim password");
		driver.findElement(By.xpath(xpathTelephoneTextField)).sendKeys(Telephone);

		logger.info("Entering the TelePhone");
		driver.findElement(By.xpath(xpathAddressTextField)).sendKeys(Address);

		logger.info("Entering the Address");
		driver.findElement(By.xpath(xpathAssign)).click();
		logger.info("Assigning the roles");
		driver.findElement(By.xpath(xpathChangePassword)).click();
		logger.info("Enabling the password change on first login");

		threadwait(2000);

		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile, new File(
				"D://All_Software//ScreenShots//Create_User//createUserScreenShot01_" + screenShotFileName + ".png"));

		logger.info("ScreenShot taken once all the Deatils enterd");

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,400);");
		threadwait(3000);

		driver.findElement(By.xpath(xpathSaveandClose)).click();
		logger.info("Clicking on Save & Close button");

		driver.findElement(By.xpath(xpathAdanceFilter)).click();
		logger.info("Clicking on Adance Filter button");

//		driver.findElement(By.xpath(xpathUserIdTextField)).sendKeys(AppUserId);
		logger.info("Entering the Created User id");

		driver.findElement(By.xpath(xpathSearchButton)).click();
		logger.info("Clicking on Search button");
		threadwait(3000);

		driver.findElement(By.xpath(xpathUserName)).click();
		logger.info("Clicking on User Name of the Created User");

		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("window.scrollBy(0,400);");
		threadwait(3000);

		driver.findElement(By.xpath(xpathBULookUp)).click();
		logger.info("Navigating to Company unit look up window");

		driver.findElement(By.xpath(xpathSelectUnit)).click();
		logger.info("Selecting Company unit From the listing");

		driver.findElement(By.xpath(xpathSelectButton)).click();
		threadwait(2000);

		File screenshotFile1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile1, new File(
				"D://All_Software//ScreenShots//Create_User//createUserScreenShot02_" + screenShotFileName + ".png"));

		logger.info("ScreenShot taken once Business Unit Assigned ");

		driver.findElement(By.xpath(xpathSaveandClose)).click();
		logger.info("Clicking on Save & Close button");

		driver.findElement(By.xpath(xpathReports)).click();
		driver.findElement(By.xpath(xpathAdminAudit)).click();
		logger.info("Navigating to Audit Report Filter");

		threadwait(2000);

		driver.findElement(By.xpath(xpathClearButton)).click();
		logger.info("Clearing Audit Report Filter");
		threadwait(10000);

		driver.findElement(By.xpath(xpathBusinessTransactionId)).sendKeys(AppUserId);
		logger.info("Entering the Created User id For Audit Report");
		threadwait(2000);

		File screenshotFile2 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile2, new File(
				"D://All_Software//ScreenShots//Create_User//createUserScreenShot03_" + screenShotFileName + ".png"));

		logger.info("ScreenShot taken once Before Applying the Filter ");

		driver.findElement(By.xpath(xpathSearchauditButton)).click();
		logger.info("Clickling Search button For Audit Report");
		threadwait(5000);

		File screenshotFile3 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile3, new File(
				"D://All_Software//ScreenShots//Create_User//createUserScreenShot04_" + screenShotFileName + ".png"));

		logger.info("ScreenShot after Applying the Filter ");

		driver.findElement(By.xpath(xpathSessionId)).click();
		logger.info("Navigating to Detailed Audit Report Filter");
		threadwait(2000);

		File screenshotFile4 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile4, new File(
				"D://All_Software//ScreenShots//Create_User//createUserScreenShot05_" + screenShotFileName + ".png"));

		logger.info("ScreenShot in Detailed Audit Report First Half ");
		threadwait(4000);

		JavascriptExecutor js2 = (JavascriptExecutor) driver;
		js2.executeScript("document.querySelector(\".ui-datatable-scrollable-body\").scrollTop=400");
		threadwait(3000);

		File screenshotFile5 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile5, new File(
				"D://All_Software//ScreenShots//Create_User//createUserScreenShot06_" + screenShotFileName + ".png"));

		logger.info("ScreenShot in Detailed Audit Report Second Half ");
		threadwait(4000);

		driver.findElement(By.xpath(xpathBackButton)).click();
		threadwait(2000);

		driver.findElement(By.xpath(xpathGenerateAll)).click();
		threadwait(5000);
		logger.info("Generating The Audit Report of User");

		driver.findElement(By.xpath(xpathBackAudit));

	}

	public void inactiveUser() throws IOException {
		threadwait(5000);

		logger.info("Inactiving a user verifying Inactive user Audit");

		Date currentdate = new Date();
		String screenShotFileName = timeStampFormat.format(currentdate);

		threadwait(5000);
		String testDataFile = "selectMultipleLiteratures.json";
		List<Map<String, String>> testData = TestDataFromJsonUtils.readJsonTestDataFromFile(testDataFile);

		String xpathSecurity = "//*[@id=\"menuform1:security\"]/a/span";
		String xpathUser = "//*[@id=\"menuform1:user\"]/a";
		String xpathAdanceFilter = "//span[@class='ui-button-text ui-c'][normalize-space()='Advance Filter']";
		String xpathUserIdTextField = "//input[@id='filterPanelForm:j_idt77']";
		String xpathSearchButton = "//span[normalize-space()='Search']";
		String xpathSelectCheckBox = "//*[@id=\"appUserListForm:appUserGrid:j_idt42\"]/div/div[2]/span";
		String xpathInactiveButton = "//span[normalize-space()='Inactivate']";
		String xpathYesButton = "//body/div[@id='appUserListForm:appUserGrid:j_idt35']/div[@class='ui-dialog-buttonpane ui-dialog-footer ui-widget-content ui-helper-clearfix']/button[@id='appUserListForm:appUserGrid:j_idt36']/span[2]";
		String xpathClearButton = "//span[normalize-space()='Clear']";

		String xpathReports = "//span[normalize-space()='Reports']";
		String xpathAdminAudit = "//a[@href='/ReTrans/views/audit/filterPanel.xhtml']//span[contains(text(),'Admin')]";
		String xpathClearButtonAudit = "//span[@class='ui-button-icon-left ui-icon ui-c fa fa-eraser F20 gray']";
		String xpathBusinessTransactionId = "//*[@id=\"filterPanelForm:j_idt34\"]";
		String xpathSearchauditButton = "//span[normalize-space()='Search']";
		String xpathGenerateAll = "//span[normalize-space()='Generate Report(All)']";
		String xpathSessionId = "//a[@id='auditlistListForm:auditlistGrid:0:j_idt38']";
		String xpathBackButton = "//*[@id=\"auditFieldLogForm:j_idt34\"]";
		String xpathBackAudit = "//span[normalize-space()='Back']";

		String UserID = testData.get(6).get("UserID");

		driver.findElement(By.xpath(xpathSecurity)).click();
		driver.findElement(By.xpath(xpathUser)).click();
		logger.info("Navigating to User listing page");
		threadwait(2000);

		driver.findElement(By.xpath(xpathClearButton)).click();
		threadwait(2000);

		driver.findElement(By.xpath(xpathAdanceFilter)).click();
		logger.info("Navigating to Adance Filter to Window");

		driver.findElement(By.xpath(xpathUserIdTextField)).sendKeys(UserID);
		logger.info("Entering the User id to Inactive");

		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile,
				new File("D://All_Software//ScreenShots//InactiveUser//inactiveUserScreenShot01_" + screenShotFileName
						+ ".png"));
		threadwait(2000);

		driver.findElement(By.xpath(xpathSearchButton)).click();
		logger.info("Clicking on Search button to Inactive a user");

		File screenshotFile1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile1,
				new File("D://All_Software//ScreenShots//InactiveUser//inactiveUserScreenShot02_" + screenShotFileName
						+ ".png"));
		threadwait(2000);

		driver.findElement(By.xpath(xpathSelectCheckBox)).click();
		logger.info("Selecting the searched user to Inactive");

		File screenshotFile2 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile2,
				new File("D://All_Software//ScreenShots//InactiveUser//inactiveUserScreenShot03_" + screenShotFileName
						+ ".png"));
		threadwait(2000);

		driver.findElement(By.xpath(xpathInactiveButton)).click();
		logger.info("Clicking on Inactive button to Inactive a user");

		File screenshotFile3 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile3,
				new File("D://All_Software//ScreenShots//InactiveUser//inactiveUserScreenShot04_" + screenShotFileName
						+ ".png"));
		threadwait(2000);

		driver.findElement(By.xpath(xpathYesButton)).click();
		logger.info("confirmation to Inactive a user");
		threadwait(5000);

		driver.findElement(By.xpath(xpathClearButton)).click();
		threadwait(2000);
		driver.findElement(By.xpath(xpathAdanceFilter)).click();
		threadwait(2000);
		driver.findElement(By.xpath(xpathUserIdTextField)).sendKeys(UserID);
		threadwait(2000);
		driver.findElement(By.xpath(xpathSearchButton)).click();
		logger.info("Clicking on Search button to Inactived a user");

		File screenshotFile4 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile4,
				new File("D://All_Software//ScreenShots//InactiveUser//inactiveUserScreenShot05_" + screenShotFileName
						+ ".png"));
		threadwait(2000);

		driver.findElement(By.xpath(xpathReports)).click();
		driver.findElement(By.xpath(xpathAdminAudit)).click();
		logger.info("Navigating to Audit Report Filter");

		threadwait(2000);

		driver.findElement(By.xpath(xpathClearButtonAudit)).click();
		logger.info("Clearing Audit Report Filter");
		threadwait(10000);

		driver.findElement(By.xpath(xpathBusinessTransactionId)).sendKeys(UserID);
		logger.info("Entering the Inactived User id For Audit Report");
		threadwait(2000);

		File screenshotFile5 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile5,
				new File("D://All_Software//ScreenShots//InactiveUser//inactiveUserScreenShot06_" + screenShotFileName
						+ ".png"));

		logger.info("ScreenShot taken once Before Applying the Filter ");

		driver.findElement(By.xpath(xpathSearchauditButton)).click();
		logger.info("Clickling Search button For Audit Report");
		threadwait(5000);

		File screenshotFile6 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile6,
				new File("D://All_Software//ScreenShots//InactiveUser//inactiveUserScreenShot07_" + screenShotFileName
						+ ".png"));

		logger.info("ScreenShot after Applying the Filter ");

		driver.findElement(By.xpath(xpathSessionId)).click();
		logger.info("Navigating to Detailed Audit Report Filter");
		threadwait(2000);

		File screenshotFile7 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile7,
				new File("D://All_Software//ScreenShots//InactiveUser//inactiveUserScreenShot08_" + screenShotFileName
						+ ".png"));

		logger.info("ScreenShot in Detailed Audit Report First Half ");
		threadwait(4000);

		driver.findElement(By.xpath(xpathBackButton)).click();
		threadwait(2000);

		driver.findElement(By.xpath(xpathGenerateAll)).click();
		threadwait(5000);
		logger.info("Generating The Audit Report of Inactived a user");

		driver.findElement(By.xpath(xpathBackAudit));

	}

	public void unlockActiveUser() throws IOException {
		threadwait(5000);

		logger.info("Unlock/Active a user verifying Unlock/Active user Audit");

		Date currentdate = new Date();
		String screenShotFileName = timeStampFormat.format(currentdate);

		threadwait(5000);
		String testDataFile = "selectMultipleLiteratures.json";
		List<Map<String, String>> testData = TestDataFromJsonUtils.readJsonTestDataFromFile(testDataFile);

		String xpathSecurity = "//*[@id=\"menuform1:security\"]/a/span";
		String xpathUser = "//*[@id=\"menuform1:user\"]/a";
		String xpathAdanceFilter = "//span[@class='ui-button-text ui-c'][normalize-space()='Advance Filter']";
		String xpathUserIdTextField = "//input[@id='filterPanelForm:j_idt77']";
		String xpathSearchButton = "//span[normalize-space()='Search']";
		String xpathSelectCheckBox = "//*[@id=\"appUserListForm:appUserGrid:j_idt42\"]/div/div[2]/span";
		String xpathUnlockActiveButton = "//span[contains(text(),'Unlock')]";
		String xpathYesButton = "//body/div[@id='appUserListForm:appUserGrid:j_idt35']/div[@class='ui-dialog-buttonpane ui-dialog-footer ui-widget-content ui-helper-clearfix']/button[@id='appUserListForm:appUserGrid:j_idt36']/span[2]";
		String xpathClearButton = "//span[normalize-space()='Clear']";

		String xpathReports = "//span[normalize-space()='Reports']";
		String xpathAdminAudit = "//a[@href='/ReTrans/views/audit/filterPanel.xhtml']//span[contains(text(),'Admin')]";
		String xpathClearButtonAudit = "//span[@class='ui-button-icon-left ui-icon ui-c fa fa-eraser F20 gray']";
		String xpathBusinessTransactionId = "//*[@id=\"filterPanelForm:j_idt34\"]";
		String xpathSearchauditButton = "//span[normalize-space()='Search']";
		String xpathGenerateAll = "//span[normalize-space()='Generate Report(All)']";
		String xpathSessionId = "//a[@id='auditlistListForm:auditlistGrid:0:j_idt38']";
		String xpathBackButton = "//*[@id=\"auditFieldLogForm:j_idt34\"]";
		String xpathBackAudit = "//span[normalize-space()='Back']";

		String UserID = testData.get(6).get("UserID");

		driver.findElement(By.xpath(xpathSecurity)).click();
		driver.findElement(By.xpath(xpathUser)).click();
		logger.info("Navigating to User listing page");
		threadwait(2000);

		driver.findElement(By.xpath(xpathClearButton)).click();
		threadwait(2000);

		driver.findElement(By.xpath(xpathAdanceFilter)).click();
		logger.info("Navigating to Adance Filter to Window");

		driver.findElement(By.xpath(xpathUserIdTextField)).sendKeys(UserID);
		logger.info("Entering the User id to Unlock/Active");

		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile,
				new File("D://All_Software//ScreenShots//Unlock_Active_User//unlockActiveUserScreenShot01_"
						+ screenShotFileName + ".png"));
		threadwait(2000);

		driver.findElement(By.xpath(xpathSearchButton)).click();
		logger.info("Clicking on Search button to Unlock/Active a user");

		File screenshotFile1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile1,
				new File("D://All_Software//ScreenShots//Unlock_Active_User//inactiveUserScreenShot02_"
						+ screenShotFileName + ".png"));
		threadwait(2000);

		driver.findElement(By.xpath(xpathSelectCheckBox)).click();
		logger.info("Selecting the searched user to Unlock/Active");

		File screenshotFile2 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile2,
				new File("D://All_Software//ScreenShots//Unlock_Active_User//unlockActiveUserScreenShot03_"
						+ screenShotFileName + ".png"));
		threadwait(2000);

		driver.findElement(By.xpath(xpathUnlockActiveButton)).click();
		logger.info("Clicking on Inactive button to Unlock/Active a user");

		File screenshotFile3 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile3,
				new File("D://All_Software//ScreenShots//Unlock_Active_User//unlockActiveUserScreenShot04_"
						+ screenShotFileName + ".png"));
		threadwait(2000);

		driver.findElement(By.xpath(xpathYesButton)).click();
		logger.info("confirmation to Unlock/Active a user");
		threadwait(5000);

		driver.findElement(By.xpath(xpathClearButton)).click();
		threadwait(2000);
		driver.findElement(By.xpath(xpathAdanceFilter)).click();
		threadwait(2000);
		driver.findElement(By.xpath(xpathUserIdTextField)).sendKeys(UserID);
		threadwait(2000);
		driver.findElement(By.xpath(xpathSearchButton)).click();
		logger.info("Clicking on Search button to Unlock/Active a user");

		File screenshotFile4 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile4,
				new File("D://All_Software//ScreenShots//Unlock_Active_User//unlockActiveUserScreenShot05_"
						+ screenShotFileName + ".png"));
		threadwait(2000);

		driver.findElement(By.xpath(xpathReports)).click();
		driver.findElement(By.xpath(xpathAdminAudit)).click();
		logger.info("Navigating to Audit Report Filter");

		threadwait(2000);

		driver.findElement(By.xpath(xpathClearButtonAudit)).click();
		logger.info("Clearing Audit Report Filter");
		threadwait(10000);

		driver.findElement(By.xpath(xpathBusinessTransactionId)).sendKeys(UserID);
		logger.info("Entering the Unlock/Active User id For Audit Report");
		threadwait(2000);

		File screenshotFile5 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile5,
				new File("D://All_Software//ScreenShots//Unlock_Active_User//unlockActiveUserScreenShot06_"
						+ screenShotFileName + ".png"));

		logger.info("ScreenShot taken once Before Applying the Filter ");

		driver.findElement(By.xpath(xpathSearchauditButton)).click();
		logger.info("Clickling Search button For Audit Report");
		threadwait(5000);

		File screenshotFile6 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile6,
				new File("D://All_Software//ScreenShots//Unlock_Active_User//unlockActiveUserScreenShot07_"
						+ screenShotFileName + ".png"));

		logger.info("ScreenShot after Applying the Filter ");

		driver.findElement(By.xpath(xpathSessionId)).click();
		logger.info("Navigating to Detailed Audit Report Filter");
		threadwait(2000);

		File screenshotFile7 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile7,
				new File("D://All_Software//ScreenShots//Unlock_Active_User//unlockActiveUserScreenShot08_"
						+ screenShotFileName + ".png"));

		logger.info("ScreenShot in Detailed Audit Report First Half ");
		threadwait(4000);

		driver.findElement(By.xpath(xpathBackButton)).click();
		threadwait(2000);

		driver.findElement(By.xpath(xpathGenerateAll)).click();
		threadwait(5000);
		logger.info("Generating The Audit Report of Unlock/Active a user");

		driver.findElement(By.xpath(xpathBackAudit));

	}

	public void createRole() throws IOException {
		threadwait(5000);

		logger.info("Creating a user verifying created user Audit  ");

		Date currentdate = new Date();
		String screenShotFileName = timeStampFormat.format(currentdate);

		threadwait(5000);
		String testDataFile = "selectMultipleLiteratures.json";
		List<Map<String, String>> testData = TestDataFromJsonUtils.readJsonTestDataFromFile(testDataFile);

		String xpathSecurity = "//*[@id=\"menuform1:security\"]/a/span";
		String xpathRoles = "//a[@href='/ReTrans/views/appRole/list.xhtml']";
		String xpathCreatebutton = "//span[normalize-space()='Create']";
		String xpathRoleNameTextField = "//input[@id='appRoleForm:roleName']";
		String xpathDescriptionTextField = "//textarea[@id='appRoleForm:description']";
		String xpathCheckBoxRoles = "//*[@id=\"appRoleForm:j_idt37:1:j_idt45\"]";
		String xpathCheckBoxUser = "//*[@id=\"appRoleForm:j_idt37:3:j_idt45\"]/div[2]/span";
		String xpathCheckBoxWfactivityrule = "//*[@id=\"appRoleForm:j_idt48:2:j_idt56\"]/div[2]";
		String xpathCheckBoxWorkFlow = "//*[@id=\"appRoleForm:j_idt48:5:j_idt56\"]/div[2]";
		String xpathCheckBoxDashboard = "//*[@id=\"appRoleForm:j_idt59:1:j_idt67\"]/div[2]";
		String xpathCheckBoxDistribute = "//*[@id=\"appRoleForm:j_idt59:4:j_idt67\"]/div[2]";
		String xpathCheckBoxDuplicateReview = "//*[@id=\"appRoleForm:j_idt69:0:j_idt72:0:j_idt80\"]/div[2]";
		String xpathCheckBoxAwaitingFTA = "//*[@id=\"appRoleForm:j_idt69:0:j_idt72:2:j_idt80\"]/div[2]";
		String xpathCheckBoxInitialReview = "//*[@id=\"appRoleForm:j_idt69:0:j_idt72:4:j_idt80\"]/div[2]";
		String xpathCheckBoxArchive = "//*[@id=\"appRoleForm:j_idt69:1:j_idt72:2:j_idt80\"]/div[2]";
		String xpathSaveandClose = "//span[normalize-space()='Save and Close']";

		String xpathReports = "//span[normalize-space()='Reports']";
		String xpathAdminAudit = "//a[@href='/ReTrans/views/audit/filterPanel.xhtml']//span[contains(text(),'Admin')]";
		String xpathClearButton = "//span[@class='ui-button-icon-left ui-icon ui-c fa fa-eraser F20 gray']";
		String xpathBusinessTransactionId = "//*[@id=\"filterPanelForm:j_idt34\"]";
		String xpathSearchauditButton = "//span[normalize-space()='Search']";
		String xpathGenerateAll = "//span[normalize-space()='Generate Report(All)']";
		String xpathSessionId = "//a[@id='auditlistListForm:auditlistGrid:0:j_idt38']";
		String xpathBackButton = "//*[@id=\"auditFieldLogForm:j_idt34\"]";
		String xpathBackAudit = "//span[normalize-space()='Back']";

		String RoleName = testData.get(4).get("RoleName");
		String Description = testData.get(4).get("Description");

		driver.findElement(By.xpath(xpathSecurity)).click();
		driver.findElement(By.xpath(xpathRoles)).click();
		logger.info("Navigating to Role listing page");

		driver.findElement(By.xpath(xpathCreatebutton)).click();
		logger.info("Navigating to Role Create page");

		driver.findElement(By.xpath(xpathRoleNameTextField)).sendKeys(RoleName);
		logger.info("Entering the Role Name");

		driver.findElement(By.xpath(xpathDescriptionTextField)).sendKeys(Description);
		logger.info("Entering the Description");

		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile, new File(
				"D://All_Software//ScreenShots//Create_Role//createRoleScreenShot01_" + screenShotFileName + ".png"));

		driver.findElement(By.xpath(xpathCheckBoxRoles)).click();
		logger.info("selecting the Roles");

		driver.findElement(By.xpath(xpathCheckBoxUser)).click();
		logger.info("selecting the Users");

		driver.findElement(By.xpath(xpathCheckBoxWfactivityrule)).click();
		logger.info("selecting the Wfactivityrule");

		driver.findElement(By.xpath(xpathCheckBoxWorkFlow)).click();
		logger.info("selecting the WorkFlow");

		driver.findElement(By.xpath(xpathCheckBoxDashboard)).click();
		logger.info("selecting the Dashboard");

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,400);");
		threadwait(3000);

		driver.findElement(By.xpath(xpathCheckBoxDistribute)).click();
		logger.info("selecting the Distribute");

		driver.findElement(By.xpath(xpathCheckBoxAwaitingFTA)).click();
		logger.info("selecting the Awaiting FTA");

		driver.findElement(By.xpath(xpathCheckBoxDuplicateReview)).click();
		logger.info("selecting the Duplicate Review");

		driver.findElement(By.xpath(xpathCheckBoxInitialReview)).click();
		logger.info("selecting the Initial Review");

		driver.findElement(By.xpath(xpathCheckBoxArchive)).click();
		logger.info("selecting the Archive");

		threadwait(3000);

		File screenshotFile1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile1, new File(
				"D://All_Software//ScreenShots//Create_Role//createRoleScreenShot02_" + screenShotFileName + ".png"));

		driver.findElement(By.xpath(xpathSaveandClose)).click();
		logger.info("Clicking on save button");

		driver.findElement(By.xpath(xpathReports)).click();
		driver.findElement(By.xpath(xpathAdminAudit)).click();
		logger.info("Navigating to Audit Report Filter");

		threadwait(2000);

		driver.findElement(By.xpath(xpathClearButton)).click();
		logger.info("Clearing Audit Report Filter");
		threadwait(10000);

		driver.findElement(By.xpath(xpathBusinessTransactionId)).sendKeys(RoleName);
		logger.info("Entering the Created User id For Audit Report");
		threadwait(2000);

		File screenshotFile2 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile2, new File(
				"D://All_Software//ScreenShots//Create_Role//createRoleScreenShot03_" + screenShotFileName + ".png"));

		logger.info("ScreenShot taken once Before Applying the Filter ");

		driver.findElement(By.xpath(xpathSearchauditButton)).click();
		logger.info("Clickling Search button For Audit Report");
		threadwait(5000);

		File screenshotFile3 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile3, new File(
				"D://All_Software//ScreenShots//Create_Role//createRoleScreenShot04_" + screenShotFileName + ".png"));

		logger.info("ScreenShot after Applying the Filter ");

		threadwait(5000);

		driver.findElement(By.xpath(xpathSessionId)).click();
		logger.info("Navigating to Detailed Audit Report Filter");
		threadwait(2000);

		File screenshotFile4 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile4, new File(
				"D://All_Software//ScreenShots//Create_Role//createRoleScreenShot05_" + screenShotFileName + ".png"));

		logger.info("ScreenShot in Detailed Audit Report First Half ");
		threadwait(4000);

		JavascriptExecutor js2 = (JavascriptExecutor) driver;
		js2.executeScript("document.querySelector(\".ui-datatable-scrollable-body\").scrollTop=400");
		threadwait(3000);

		File screenshotFile5 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile5, new File(
				"D://All_Software//ScreenShots//Create_Role//createRoleScreenShot06_" + screenShotFileName + ".png"));

		logger.info("ScreenShot in Detailed Audit Report Second Half ");
		threadwait(4000);

		driver.findElement(By.xpath(xpathBackButton)).click();
		threadwait(2000);

		driver.findElement(By.xpath(xpathGenerateAll)).click();
		threadwait(5000);
		logger.info("Generating The Audit Report of Role");

		driver.findElement(By.xpath(xpathBackAudit));

	}

	public void createMedicalTerms() throws IOException {
		threadwait(5000);

		logger.info("Creating a  Medical Terms & Vefiying created  Medical Terms Audit  ");

		Date currentdate = new Date();
		String screenShotFileName = timeStampFormat.format(currentdate);

		threadwait(5000);
		String testDataFile = "selectMultipleLiteratures.json";
		List<Map<String, String>> testData = TestDataFromJsonUtils.readJsonTestDataFromFile(testDataFile);

		String xpathNLPAdmin = "//span[normalize-space()='NLP Admin']";
		String xpathMedicalTerms = "//span[normalize-space()='Medical Terms']";
		String xpathCreateButton = "//span[normalize-space()='Create']";
		String xpathNameTextField = "//input[@id='medTermListForm:name']";
		String xpathType = "//label[@id='medTermListForm:type_label']";
		String xpathTypeSearchBar = "//input[@id='medTermListForm:type_filter']";
		String xpathTypeSelect = "//*[@id=\"medTermListForm:type_1\"]";
		String xpathPatternTextField = "//input[@id='medTermListForm:patternFormula']";
		String xpathDescriptionTextField = "//textarea[@id='medTermListForm:description']";
		String xpathCloseandSave = "//span[normalize-space()='Save and Close']";

		String xpathReports = "//span[normalize-space()='Reports']";
		String xpathAdminAudit = "//a[@href='/ReTrans/views/audit/filterPanel.xhtml']//span[contains(text(),'Admin')]";
		String xpathClearButton = "//span[@class='ui-button-icon-left ui-icon ui-c fa fa-eraser F20 gray']";
		String xpathBusinessTransactionId = "//*[@id=\"filterPanelForm:j_idt34\"]";
		String xpathSearchauditButton = "//span[normalize-space()='Search']";
		String xpathSessionId = "//a[@id='auditlistListForm:auditlistGrid:0:j_idt38']";
		String xpathBackButton = "//*[@id=\"auditFieldLogForm:j_idt34\"]";
		String xpathGenerateAll = "//span[normalize-space()='Generate Report(All)']";

		String Name = testData.get(5).get("Name");
		String Type = testData.get(5).get("Type");
		String Pattern = testData.get(5).get("Pattern");
		String Description = testData.get(5).get("Description");

		driver.findElement(By.xpath(xpathNLPAdmin)).click();
		driver.findElement(By.xpath(xpathMedicalTerms)).click();
		logger.info("Navigating to Medical Terms listing page");
		threadwait(2000);

		driver.findElement(By.xpath(xpathCreateButton)).click();
		logger.info("Navigating to Create Medical Terms page");
		threadwait(2000);

		driver.findElement(By.xpath(xpathNameTextField)).sendKeys(Name);
		logger.info("Entering the Medical Terms Name");
		threadwait(2000);

		driver.findElement(By.xpath(xpathType)).click();
		driver.findElement(By.xpath(xpathTypeSearchBar)).sendKeys(Type);
		threadwait(2000);
		driver.findElement(By.xpath(xpathTypeSelect)).click();
		logger.info("Selecting the Medical Terms Type");

		driver.findElement(By.xpath(xpathPatternTextField)).sendKeys(Pattern);
		logger.info("Entering the Medical Terms Pattern");

		driver.findElement(By.xpath(xpathDescriptionTextField)).sendKeys(Description);
		logger.info("Entering the Medical Terms Description");

		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile,
				new File("D://All_Software//ScreenShots//Create_Medical_Terms//createMedicalTerms01_"
						+ screenShotFileName + ".png"));

		logger.info("ScreenShot after Entering the Medical Terms Deatils  ");

		driver.findElement(By.xpath(xpathCloseandSave)).click();
		logger.info("Clicking on Save button to create the Medical Terms");
		threadwait(2000);

		driver.findElement(By.xpath(xpathReports)).click();
		driver.findElement(By.xpath(xpathAdminAudit)).click();
		logger.info("Navigating to Audit Report Filter");

		threadwait(2000);

		driver.findElement(By.xpath(xpathClearButton)).click();
		logger.info("Clearing Audit Report Filter");
		threadwait(10000);

		driver.findElement(By.xpath(xpathBusinessTransactionId)).sendKeys(Name);
		logger.info("Entering the Created Medical Terms Name For Audit Report");
		threadwait(2000);

		File screenshotFile1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile1,
				new File("D://All_Software//ScreenShots//Create_Medical_Terms//createMedicalTerms02_"
						+ screenShotFileName + ".png"));

		logger.info("ScreenShot taken once Before Applying the Filter ");

		driver.findElement(By.xpath(xpathSearchauditButton)).click();
		logger.info("Clickling Search button For Audit Report");
		threadwait(5000);

		File screenshotFile2 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile2,
				new File("D://All_Software//ScreenShots//Create_Medical_Terms//createMedicalTerms03_"
						+ screenShotFileName + ".png"));

		logger.info("ScreenShot after Applying the Filter ");

		driver.findElement(By.xpath(xpathSessionId)).click();
		logger.info("Navigating to Detailed Audit Report Filter");
		threadwait(2000);

		File screenshotFile3 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile3,
				new File("D://All_Software//ScreenShots//Create_Medical_Terms//createMedicalTerms04_"
						+ screenShotFileName + ".png"));

		logger.info("ScreenShot of Detailed Audit Report Filter ");

		driver.findElement(By.xpath(xpathBackButton)).click();
		logger.info("Navigating to Audit Report Listing Page");

		driver.findElement(By.xpath(xpathGenerateAll)).click();
		threadwait(5000);
		logger.info("Generating The Audit Report of Create Medical Terms");

	}

	public void createAppBucketTerms() throws IOException {
		threadwait(5000);

		logger.info("Creating a  App Bucket Terms & Vefiying created App Terms Bucket Audit  ");

		Date currentdate = new Date();
		String screenShotFileName = timeStampFormat.format(currentdate);

		String xpathNLPAdmin = "//span[normalize-space()='NLP Admin']";
		String xpathAppBucketTerms = "//span[normalize-space()='App Bucket Terms']";
		String xpathCreateButton = "//span[normalize-space()='Create']";
		String xpathNameTextField = "//input[@id='nlBucketTermForm:name']";
		String xpathType = "//label[@id='nlBucketTermForm:termType_label']";
		String xpathTypeSearchBar = "//input[@id='nlBucketTermForm:termType_filter']";
		String xpathTypeSelect = "//td[normalize-space()='Accepted']";
		String xpathPatternTextField = "//input[@id='nlBucketTermForm:patternFormula']";
		String xpathDescriptionTextField = "//textarea[@id='nlBucketTermForm:description']";
		String xpathCloseandSave = "//span[normalize-space()='Save and Close']";

		String xpathReports = "//span[normalize-space()='Reports']";
		String xpathAdminAudit = "//a[@href='/ReTrans/views/audit/filterPanel.xhtml']//span[contains(text(),'Admin')]";
		String xpathClearButton = "//span[@class='ui-button-icon-left ui-icon ui-c fa fa-eraser F20 gray']";
		String xpathBusinessTransactionId = "//*[@id=\"filterPanelForm:j_idt34\"]";
		String xpathSearchauditButton = "//span[normalize-space()='Search']";
		String xpathSessionId = "//a[@id='auditlistListForm:auditlistGrid:0:j_idt38']";
		String xpathBackButton = "//*[@id=\"auditFieldLogForm:j_idt34\"]";
		String xpathGenerateAll = "//span[normalize-space()='Generate Report(All)']";

		String Name = testData.get(8).get("Name");
		String Type = testData.get(8).get("Type");
		String Pattern = testData.get(8).get("Pattern");
		String Description = testData.get(8).get("Description");

		driver.findElement(By.xpath(xpathNLPAdmin)).click();
		driver.findElement(By.xpath(xpathAppBucketTerms)).click();

		logger.info("Navigating to App Bucket Terms  listing page");
		threadwait(2000);

		driver.findElement(By.xpath(xpathCreateButton)).click();
		logger.info("Navigating to Create App Bucket Terms page");
		threadwait(2000);

		driver.findElement(By.xpath(xpathNameTextField)).sendKeys(Name);
		logger.info("Entering the App Bucket Terms Name");
		threadwait(2000);

		driver.findElement(By.xpath(xpathType)).click();
		driver.findElement(By.xpath(xpathTypeSearchBar)).sendKeys(Type);
		threadwait(2000);
		driver.findElement(By.xpath(xpathTypeSelect)).click();
		logger.info("Selecting the Medical Terms Type");

		driver.findElement(By.xpath(xpathPatternTextField)).sendKeys(Pattern);
		logger.info("Entering the App Bucket Terms Pattern");

		driver.findElement(By.xpath(xpathDescriptionTextField)).sendKeys(Description);
		logger.info("Entering the App Bucket Terms Description");

		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile,
				new File("D://All_Software//ScreenShots//Create_App_Bucket_Terms//AppBucketTerms01_"
						+ screenShotFileName + ".png"));

		logger.info("ScreenShot after Entering the App Bucket Terms Deatils  ");

		driver.findElement(By.xpath(xpathCloseandSave)).click();
		logger.info("Clicking on Save button to create the  App Bucket Terms");
		threadwait(2000);

		driver.findElement(By.xpath(xpathReports)).click();
		driver.findElement(By.xpath(xpathAdminAudit)).click();
		logger.info("Navigating to Audit Report Filter");

		threadwait(2000);

		driver.findElement(By.xpath(xpathClearButton)).click();
		logger.info("Clearing Audit Report Filter");
		threadwait(10000);

		driver.findElement(By.xpath(xpathBusinessTransactionId)).sendKeys(Name);
		logger.info("Entering the Created App Bucket Terms Name For Audit Report");
		threadwait(2000);

		File screenshotFile1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile1,
				new File("D://All_Software//ScreenShots//Create_App_Bucket_Terms//AppBucketTerms02_"
						+ screenShotFileName + ".png"));

		logger.info("ScreenShot taken once Before Applying the Filter ");

		driver.findElement(By.xpath(xpathSearchauditButton)).click();
		logger.info("Clickling Search button For Audit Report");
		threadwait(5000);

		File screenshotFile2 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile2,
				new File("D://All_Software//ScreenShots//Create_App_Bucket_Terms//AppBucketTerms03_"
						+ screenShotFileName + ".png"));

		logger.info("ScreenShot after Applying the Filter ");

		driver.findElement(By.xpath(xpathSessionId)).click();
		logger.info("Navigating to Detailed Audit Report Filter");
		threadwait(2000);

		File screenshotFile3 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile3,
				new File("D://All_Software//ScreenShots//Create_App_Bucket_Terms//AppBucketTerms04_"
						+ screenShotFileName + ".png"));

		logger.info("ScreenShot of Detailed Audit Report Filter ");

		driver.findElement(By.xpath(xpathBackButton)).click();
		logger.info("Navigating to Audit Report Listing Page");

		driver.findElement(By.xpath(xpathGenerateAll)).click();
		threadwait(5000);
		logger.info("Generating The Audit Report of Create App Bucket Terms");

	}

	public void createBulkMedicalTerms() throws IOException {
		threadwait(5000);

		logger.info("Creating a Bulk Medical Terms & Vefiying created Bulk Medical Terms Audit  ");

		Date currentdate = new Date();
		String screenShotFileName = timeStampFormat.format(currentdate);

		threadwait(5000);
		String testDataFile = "selectMultipleLiteratures.json";
		List<Map<String, String>> testData = TestDataFromJsonUtils.readJsonTestDataFromFile(testDataFile);

		String xpathNLPAdmin = "//span[normalize-space()='NLP Admin']";
		String xpathMedicalTerms = "//span[normalize-space()='Medical Terms']";
		String xpathBulkCreateButton = "//span[@class='ui-button-text ui-c'][normalize-space()='Upload Med Terms']";
		String xapthCsvFile = "//input[@id='uploadMedTermsForm:supDocProducts_input']";
		String xpathUplaodButton = "//span[normalize-space()='Upload']";
		String xpathSaveButton = "//button[@id='uploadMedTermsForm:j_idt58']//span[@class='ui-button-text ui-c'][normalize-space()='Save']";

		String xpathReports = "//span[normalize-space()='Reports']";
		String xpathAdminAudit = "//a[@href='/ReTrans/views/audit/filterPanel.xhtml']//span[contains(text(),'Admin')]";
		String xpathClearButton = "//span[@class='ui-button-icon-left ui-icon ui-c fa fa-eraser F20 gray']";
		String xpathModuleName = "//*[@id=\"filterPanelForm:panelContextType_label\"]";
		String xpathSelectModule = "//td[normalize-space()='Medical Terms']";
		String xpathMoudleSearcgBar = "//input[@id='filterPanelForm:panelContextType_filter']";
		String xpathSearchauditButton = "//span[normalize-space()='Search']";
		String xpathSessionId = "//a[@id='auditlistListForm:auditlistGrid:0:j_idt38']";
		String xpathBackButton = "//*[@id=\"auditFieldLogForm:j_idt34\"]";
		String xpathGenerateAll = "//span[normalize-space()='Generate Report(All)']";

		String CSVForMedTerms = testData.get(7).get("CSVForMedTerms");
		String ModuleName = testData.get(7).get("ModuleName");

		driver.findElement(By.xpath(xpathNLPAdmin)).click();
		driver.findElement(By.xpath(xpathMedicalTerms)).click();
		logger.info("Navigating to Medical Terms listing page");
		threadwait(2000);

		driver.findElement(By.xpath(xpathBulkCreateButton)).click();
		logger.info("Navigating to Create Bulk Medical Terms Window");
		threadwait(5000);

		driver.findElement(By.xpath(xapthCsvFile)).sendKeys(CSVForMedTerms);
		logger.info("Selecting the Csv File to Upload");
		threadwait(3000);

		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile,
				new File("D://All_Software//ScreenShots//CreateB_Bulk_Medical_Terms//CreateBulkMedicalTerms01_"
						+ screenShotFileName + ".png"));

		driver.findElement(By.xpath(xpathUplaodButton)).click();
		logger.info("Clicking on Upload Button to Upload Csv File");

		File screenshotFile1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile1,
				new File("D://All_Software//ScreenShots//CreateB_Bulk_Medical_Terms//CreateBulkMedicalTerms02_"
						+ screenShotFileName + ".png"));

		driver.findElement(By.xpath(xpathSaveButton)).click();
		logger.info("Clicking on Save Button");

		driver.findElement(By.xpath(xpathReports)).click();
		driver.findElement(By.xpath(xpathAdminAudit)).click();
		logger.info("Navigating to Audit Report Filter");

		threadwait(2000);

		driver.findElement(By.xpath(xpathClearButton)).click();
		logger.info("Clearing Audit Report Filter");
		threadwait(10000);

		driver.findElement(By.xpath(xpathModuleName)).click();
		driver.findElement(By.xpath(xpathMoudleSearcgBar)).sendKeys(ModuleName);
		logger.info("Entering the Module Name For Audit Report");
		threadwait(2000);
		driver.findElement(By.xpath(xpathSelectModule)).click();

		File screenshotFile2 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile2,
				new File("D://All_Software//ScreenShots//CreateB_Bulk_Medical_Terms//CreateBulkMedicalTerms03_"
						+ screenShotFileName + ".png"));

		logger.info("ScreenShot taken once Before Applying the Filter ");

		driver.findElement(By.xpath(xpathSearchauditButton)).click();
		logger.info("Clickling Search button For Audit Report");
		threadwait(5000);

		File screenshotFile3 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile3,
				new File("D://All_Software//ScreenShots//CreateB_Bulk_Medical_Terms//CreateBulkMedicalTerms04_"
						+ screenShotFileName + ".png"));

		logger.info("ScreenShot after Applying the Filter ");

		driver.findElement(By.xpath(xpathSessionId)).click();
		logger.info("Navigating to Detailed Audit Report Filter");
		threadwait(2000);

		File screenshotFile4 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile4,
				new File("D://All_Software//ScreenShots//CreateB_Bulk_Medical_Terms//CreateBulkMedicalTerms05_"
						+ screenShotFileName + ".png"));

		logger.info("ScreenShot of Detailed Audit Report Filter ");

		driver.findElement(By.xpath(xpathBackButton)).click();
		logger.info("Navigating to Audit Report Listing Page");

		driver.findElement(By.xpath(xpathGenerateAll)).click();
		threadwait(5000);
		logger.info("Generating The Audit Report of Create Bulk Medical Terms");

	}

	public void createBulkAppBucketTerms() throws IOException {
		threadwait(5000);

		logger.info("Creating a Bulk App Bucket Terms & Vefiying created Bulk App Bucket Terms Audit  ");

		Date currentdate = new Date();
		String screenShotFileName = timeStampFormat.format(currentdate);

		threadwait(5000);
		String testDataFile = "selectMultipleLiteratures.json";
		List<Map<String, String>> testData = TestDataFromJsonUtils.readJsonTestDataFromFile(testDataFile);

		String xpathNLPAdmin = "//span[normalize-space()='NLP Admin']";
		String xpathAppBucketTerms = "//span[normalize-space()='App Bucket Terms']";
		String xpathBulkCreateButton = "//span[normalize-space()='Upload App Bucket Terms']";
		String xapthCsvFile = "//input[@id='uploadTermsForm:supDocProducts_input']";
		String xpathUplaodButton = "//span[normalize-space()='Upload']";
		String xpathSaveButton = "//button[@id='uploadTermsForm:j_idt60']//span[@class='ui-button-icon-left ui-icon ui-c fa fa-save Fs14']";

		String xpathReports = "//span[normalize-space()='Reports']";
		String xpathAdminAudit = "//a[@href='/ReTrans/views/audit/filterPanel.xhtml']//span[contains(text(),'Admin')]";
		String xpathClearButton = "//span[@class='ui-button-icon-left ui-icon ui-c fa fa-eraser F20 gray']";
		String xpathModuleName = "//*[@id=\"filterPanelForm:panelContextType_label\"]";
		String xpathSelectModule = "//td[normalize-space()='NLP']";
		String xpathMoudleSearcgBar = "//input[@id='filterPanelForm:panelContextType_filter']";
		String xpathSearchauditButton = "//span[normalize-space()='Search']";
		String xpathSessionId = "//a[@id='auditlistListForm:auditlistGrid:0:j_idt38']";
		String xpathBackButton = "//*[@id=\"auditFieldLogForm:j_idt34\"]";
		String xpathGenerateAll = "//span[normalize-space()='Generate Report(All)']";
		String useridsearch = "//input[@id='filterPanelForm:j_idt40']";

		String CSVForAppBucketTerms = testData.get(12).get("CSVForAppBucketTerms");
		String ModuleName = testData.get(12).get("ModuleName");
		String UserId = testData.get(12).get("UserId");

		driver.findElement(By.xpath(xpathNLPAdmin)).click();
		driver.findElement(By.xpath(xpathAppBucketTerms)).click();
		logger.info("Navigating to App Bucket Terms listing page");
		threadwait(2000);

		driver.findElement(By.xpath(xpathBulkCreateButton)).click();
		logger.info("Navigating to Create Bulk App Bucket Terms Window");
		threadwait(5000);

		driver.findElement(By.xpath(xapthCsvFile)).sendKeys(CSVForAppBucketTerms);
		logger.info("Selecting the Csv File to Upload");
		threadwait(3000);

		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile,
				new File("D://All_Software//ScreenShots//CreateB_Bulk_App_Bucket_Terms//CreateBulkMedicalTerms01_"
						+ screenShotFileName + ".png"));

		driver.findElement(By.xpath(xpathUplaodButton)).click();
		logger.info("Clicking on Upload Button to Upload Csv File");

		File screenshotFile1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile1,
				new File("D://All_Software//ScreenShots//CreateB_Bulk_App_Bucket_Terms//CreateBulkAppBucketTerms02_"
						+ screenShotFileName + ".png"));

		threadwait(3000);

		driver.findElement(By.xpath(xpathSaveButton)).click();
		logger.info("Clicking on Save Button");

		driver.findElement(By.xpath(xpathReports)).click();
		driver.findElement(By.xpath(xpathAdminAudit)).click();
		logger.info("Navigating to Audit Report Filter");

		threadwait(2000);

		driver.findElement(By.xpath(xpathClearButton)).click();
		logger.info("Clearing Audit Report Filter");
		threadwait(10000);

		driver.findElement(By.xpath(useridsearch)).sendKeys(UserId);
		threadwait(2000);

		driver.findElement(By.xpath(xpathModuleName)).click();
		threadwait(2000);

		driver.findElement(By.xpath(xpathMoudleSearcgBar)).sendKeys(ModuleName);

		logger.info("Entering the Module Name For Audit Report");
		threadwait(2000);
		driver.findElement(By.xpath(xpathSelectModule)).click();

		File screenshotFile2 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile2,
				new File("D://All_Software//ScreenShots//CreateB_Bulk_App_Bucket_Terms//CreateBulkAppBucketTerms03_"
						+ screenShotFileName + ".png"));

		logger.info("ScreenShot taken once Before Applying the Filter ");

		driver.findElement(By.xpath(xpathSearchauditButton)).click();
		logger.info("Clickling Search button For Audit Report");
		threadwait(5000);

		File screenshotFile3 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile3,
				new File("D://All_Software//ScreenShots//CreateB_Bulk_App_Bucket_Terms//CreateBulkAppBucketTerms04_"
						+ screenShotFileName + ".png"));

		logger.info("ScreenShot after Applying the Filter ");

		driver.findElement(By.xpath(xpathSessionId)).click();
		logger.info("Navigating to Detailed Audit Report Filter");
		threadwait(2000);

		File screenshotFile4 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile4,
				new File("D://All_Software//ScreenShots//CreateB_Bulk_App_Bucket_Terms//CreateBulkAppBucketTerms05_"
						+ screenShotFileName + ".png"));

		logger.info("ScreenShot of Detailed Audit Report Filter ");

		driver.findElement(By.xpath(xpathBackButton)).click();
		logger.info("Navigating to Audit Report Listing Page");
		threadwait(5000);

		driver.findElement(By.xpath(xpathGenerateAll)).click();
		threadwait(15000);
		logger.info("Generating The Audit Report of Create Bulk App Bucket Terms");

	}

	public void createBusinessUnit() throws IOException {
		threadwait(5000);
		logger.info("Creating a Business Unit & Vefiying created Business Unit Audit");

		Date currentdate = new Date();
		String screenShotFileName = timeStampFormat.format(currentdate);

		threadwait(5000);
		String testDataFile = "selectMultipleLiteratures.json";
		List<Map<String, String>> testData = TestDataFromJsonUtils.readJsonTestDataFromFile(testDataFile);

		String Libary = "//body/div[@id='layout-topbar-cover']/div[@id='layout-topbar']/form[@id='menuform1']/div[@id='layout-menu-cover']/ul[@id='layout-menu']/li[@id='menuform1:admin_xml']/a[1]";
		String BusinessUnit = "//a[@href='/ReTrans/views/companyUnit/list.xhtml']";
		String CreateButton = "//span[normalize-space()='Create']";
		String BUId = "//input[@id='companyUnitForm:companyCode']";
		String BUInterchangeId = "//input[@id='companyUnitForm:interchangeId']";
		String BUName = "//input[@id='companyUnitForm:named2']";
		String EncodingType = "//div[@id='companyUnitForm:encodingType']//span[@class='ui-icon ui-icon-triangle-1-s ui-c']";
		String EncodingTypeSearch = "//input[@id='companyUnitForm:encodingType_filter']";
		String EncodeSelect = "/html/body/div[15]/div[2]/table/tbody/tr[1]/td";
		String Department = "//input[@id='companyUnitForm:departmentId']";
		String EmailId = "//input[@id='companyUnitForm:emailId']";
		String Fax = "//input[@id='companyUnitForm:fax']";
		String Address = "//textarea[@id='companyUnitForm:address']";
		String SelectWorkflowLookUp = "/html/body/div[2]/div[2]/div/form[1]/div[1]/div[1]/div/div[5]/div[2]/button";
		String WorkflowName = "//input[@id='compWorkFlowLookupForm:wfname']";
		String SearchButton = "//span[normalize-space()='Search']";
		String Selectworkflow = "/html/body/div[2]/div[2]/div/form[3]/div/div[2]/div/div[3]/div[3]/table/tbody/tr/td[1]/div/div[2]/span";
		String SelectButton = "//button[@id='compWorkFlowLookupForm:j_idt186']//span[@class='ui-button-text ui-c'][normalize-space()='Select']";
		String OnDuplicate = "/html/body/div[2]/div[2]/div/form[1]/div[1]/div[1]/div/div[5]/div[4]/div/div[1]/div/div[3]/span";
		String OnDuplicateSearch = "/html/body/div[32]/div[1]/input";
		String OnDuplicateSelect = "/html/body/div[32]/div[2]/table/tbody/tr[1]/td";
		String OnReject = "/html/body/div[2]/div[2]/div/form[1]/div[1]/div[1]/div/div[5]/div[4]/div/div[2]/div/div[3]";
		String OnRejectSearch = "//input[@id='companyUnitForm:j_idt55:1:traigeTarget_filter']";
		String OnRejectSelect = "/html/body/div[33]/div[2]/table/tbody/tr[2]/td";
		String OnValidICSR = "/html/body/div[2]/div[2]/div/form[1]/div[1]/div[1]/div/div[5]/div[4]/div/div[3]/div";
		String OnValidICSRSearch = "//input[@id='companyUnitForm:j_idt55:2:traigeTarget_filter']";
		String OnValidICSRSelect = "/html/body/div[34]/div[2]/table/tbody/tr[2]/td";
		String OnSafetyinfo = "/html/body/div[2]/div[2]/div/form[1]/div[1]/div[1]/div/div[5]/div[4]/div/div[4]/div";
		String OnSafetyinfoSearch = "//input[@id='companyUnitForm:j_idt55:3:traigeTarget_filter']";
		String OnSafetyinfoSelect = "/html/body/div[35]/div[2]/table/tbody/tr[2]/td";
		String ExtraConfig = "//a[@id='companyUnitForm:j_idt60_toggler']//span";
		String AllowedClassifications = "//div[@id='companyUnitForm:compSafetyInfo']//span[@class='ui-icon ui-icon-triangle-1-s']";
		String AllowedClassificationsSelect = "//div[@id='companyUnitForm:compSafetyInfo_panel']//div[@class='ui-widget-header ui-corner-all ui-selectcheckboxmenu-header ui-helper-clearfix']//span[@class='ui-chkbox-icon ui-icon ui-icon-blank']";
		String DefaultClassifications = "//div[@id='companyUnitForm:compClassifications']//ul[@class='ui-selectcheckboxmenu-multiple-container ui-widget ui-inputfield ui-state-default ui-corner-all']";
		String DefaultClassificationsSelect = "//div[@id='companyUnitForm:compClassifications_panel']//div[@class='ui-widget-header ui-corner-all ui-selectcheckboxmenu-header ui-helper-clearfix']//div[@class='ui-chkbox-box ui-widget ui-corner-all ui-state-default']";
		String AllowedSafetyInfo = "//div[@id='companyUnitForm:compAssessent']//span[@class='ui-icon ui-icon-triangle-1-s']";
		String AllowedSafetyInfoSelect = "//div[@id='companyUnitForm:compAssessent_panel']//div[@class='ui-widget-header ui-corner-all ui-selectcheckboxmenu-header ui-helper-clearfix']//span[@class='ui-chkbox-icon ui-icon ui-icon-blank']";
		String NLPTyp = "//div[@id='companyUnitForm:litEditTabs']//span[@class='ui-icon ui-icon-triangle-1-s']";
		String NLPTypSelect = "//div[@class='ui-widget-header ui-corner-all ui-selectcheckboxmenu-header ui-helper-clearfix']//span[@class='ui-chkbox-icon ui-icon ui-icon-blank']";
		String LiteratureTriage = "/html/body/div[2]/div[2]/div/form[1]/div[1]/div[3]/div/div[1]/fieldset[2]/div/div[1]/div/div/div/div/div[2]";
		String AcceptedTerms = "/html/body/div[2]/div[2]/div/form[1]/div[1]/div[3]/div/div[1]/fieldset[2]/div/div[2]/div[2]/div/div/div/div[1]/fieldset/div/div/div/div[1]/div[1]/div/div[2]";
		String ProductNames = "/html/body/div[2]/div[2]/div/form[1]/div[1]/div[3]/div/div[1]/fieldset[2]/div/div[2]/div[2]/div/div/div/div[1]/fieldset/div/div/div/div[2]/div[1]/div/div[2]";
		String Events = "/html/body/div[2]/div[2]/div/form[1]/div[1]/div[3]/div/div[1]/fieldset[2]/div/div[2]/div[2]/div/div/div/div[1]/fieldset/div/div/div/div[3]/div[1]/div/div[2]/span";
		String RejectedTerms = "/html/body/div[2]/div[2]/div/form[1]/div[1]/div[3]/div/div[1]/fieldset[2]/div/div[2]/div[2]/div/div/div/div[2]/fieldset/div/div/div/div[1]/div[1]/div/div[2]/span";
		String Autoacceptancethreshold = "/html/body/div[2]/div[2]/div/form[1]/div[1]/div[3]/div/div[1]/fieldset[2]/div/div[2]/div[2]/div/div/div/div[2]/fieldset/div/div/div/div[2]/div[1]/div/div[2]/span";
		String AccepetedSlider = "//div[@id='companyUnitForm:compTabPanel:searchKeyweightageSlider']";
		String ProductsSlider = "//div[@id='companyUnitForm:compTabPanel:productNameweightageSlider']//span[@class='ui-slider-handle ui-state-default ui-corner-all']";
		String EventSlider = "//div[@id='companyUnitForm:compTabPanel:ingredientsweightageSlider']//span";
		String RejectTermSlider = "//div[@id='companyUnitForm:compTabPanel:rejTermsweightageSlider']//span";
		String AutoAcceptanceThresholdSlider = "//div[@id='companyUnitForm:compTabPanel:litAutoProcessMinValueSlider']//span";
		String AlertsOnActivityCompletion = "/html/body/div[2]/div[2]/div/form[1]/div[1]/div[3]/div/div[1]/fieldset[3]/div/div/div[1]/div[1]/div/div[2]/span";
		String AlertsOnCreatingQueriesCitations = "/html/body/div[2]/div[2]/div/form[1]/div[1]/div[3]/div/div[1]/fieldset[3]/div/div/div[3]/div[1]/div/div[2]";
		String AlertsOnRejectingCitationReview = "/html/body/div[2]/div[2]/div/form[1]/div[1]/div[3]/div/div[1]/fieldset[3]/div/div/div[5]/div[1]/div/div[2]/span";
		String AlertsOnWorkflowCompletion = "/html/body/div[2]/div[2]/div/form[1]/div[1]/div[3]/div/div[1]/fieldset[3]/div/div/div[2]/div[1]/div/div[2]/span";
		String AlertsOnFTArequests = "/html/body/div[2]/div[2]/div/form[1]/div[1]/div[3]/div/div[1]/fieldset[3]/div/div/div[4]/div[1]/div/div[2]/span";
		String AlertsOnQueryChangeArchivedCitation = "/html/body/div[2]/div[2]/div/form[1]/div[1]/div[3]/div/div[1]/fieldset[3]/div/div/div[6]/div[1]/div/div[2]/span";

		String AlertsOnActivityCompletionText = "//input[@id='companyUnitForm:compTabPanel:ALERT_ON_ACTIVITY_email']";
		String AlertsOnCreatingQueriesCitationsText = "//input[@id='companyUnitForm:compTabPanel:ALERT_ON_ARRIVAL_email']";
		String AlertsOnRejectingCitationReviewText = "//input[@id='companyUnitForm:compTabPanel:ALERT_ON_REJECT_email']";
		String AlertsOnWorkflowCompletionText = "//input[@id='companyUnitForm:compTabPanel:ALERT_ON_WORKFLOW_email']";
		String AlertsOnFTArequestsText = "//input[@id='companyUnitForm:compTabPanel:ALERT_ON_PO_email']";
		String AlertsOnQueryChangeArchivedCitationText = "//input[@id='companyUnitForm:compTabPanel:ALERT_ON_ADMIN_email']";

		String Parameters = "/html/body/div[2]/div[2]/div/form[1]/div[1]/div[3]/ul/li[2]/a";
		String EnbaleML = "/html/body/div[2]/div[2]/div/form[1]/div[1]/div[3]/div/div[2]/div[2]/div[1]/fieldset/div/div/div[2]/div/div/div[2]/span";
		String Enbale = "/html/body/div[2]/div[2]/div/form[1]/div[1]/div[3]/div/div[2]/div[2]/div[2]/fieldset/div/div/div[2]/div/div/div[2]/span";
		String Boby = "//input[@id='companyUnitForm:compTabPanel:j_idt123:2:j_idt127:0:j_idt134']";

		String CCAddress = "//input[@id='companyUnitForm:compTabPanel:j_idt123:2:j_idt127:5:j_idt134']";
		String Subject = "//input[@id='companyUnitForm:compTabPanel:j_idt123:2:j_idt127:12:j_idt134']";
		String ToAddress = "//input[@id='companyUnitForm:compTabPanel:j_idt123:2:j_idt127:16:j_idt134']";
		String CaseInfoLabel = "//input[@id='companyUnitForm:compTabPanel:j_idt123:3:j_idt127:2:j_idt134']";
		String TagsLabel = "//input[@id='companyUnitForm:compTabPanel:j_idt123:3:j_idt127:10:j_idt134']";
		String SafetyRelevantLabel = "//input[@id='companyUnitForm:compTabPanel:j_idt123:3:j_idt127:13:j_idt134']";
		String StudyCategoryLabel = "//input[@id='companyUnitForm:compTabPanel:j_idt123:3:j_idt127:14:j_idt134']";
		String ProductsLabel = "//input[@id='companyUnitForm:compTabPanel:j_idt123:3:j_idt127:17:j_idt134']";
		String EnableUseOnlyCPDLibrary = "//div[@id='companyUnitForm:compTabPanel:j_idt123:5:j_idt127:4:j_idt144']//span[@class='ui-chkbox-icon ui-icon ui-icon-blank ui-c']";

		String WFRejected = "//input[@id='companyUnitForm:compTabPanel:j_idt123:6:j_idt127:1:j_idt148']";
		String WFSafety = "//input[@id='companyUnitForm:compTabPanel:j_idt123:6:j_idt127:6:j_idt148']";
		String WFICSR = "//input[@id='companyUnitForm:compTabPanel:j_idt123:6:j_idt127:11:j_idt148']";
		String SavePara = "//button[@name='companyUnitForm:compTabPanel:saveUnitParams']//span";
		String LiteratureConfig = "/html/body/div[2]/div[2]/div/form[1]/div[1]/div[3]/ul/li[1]";
		String SaveandClose = "//span[normalize-space()='Save and Close']";

		String ClearButton = "//span[normalize-space()='Clear']";
		String AdvanceFilter = "//span[@class='ui-button-text ui-c'][normalize-space()='Advance Filter']";
		String NameText = "//input[@id='filterPanelForm:j_idt75']";
		String BUInterchangeIdText = "//input[@id='filterPanelForm:j_idt79']";
		String Search = "//span[normalize-space()='Search']";
		String ViewBu = "//a[@id='companyUnitListForm:companyUnitGrid:0:j_idt41']";

		String xpathReports = "//span[normalize-space()='Reports']";
		String xpathAdminAudit = "//a[@href='/ReTrans/views/audit/filterPanel.xhtml']//span[contains(text(),'Admin')]";
		String xpathClearButton = "//span[@class='ui-button-icon-left ui-icon ui-c fa fa-eraser F20 gray']";
		String xpathModuleName = "//*[@id=\"filterPanelForm:panelContextType_label\"]";
		String xpathSelectModule = "//td[normalize-space()='NLP']";
		String xpathMoudleSearcgBar = "//input[@id='filterPanelForm:panelContextType_filter']";
		String xpathSearchauditButton = "//span[normalize-space()='Search']";
		String xpathSessionId = "//a[@id='auditlistListForm:auditlistGrid:0:j_idt38']";
		String xpathBackButton = "//*[@id=\"auditFieldLogForm:j_idt34\"]";
		String xpathGenerateAll = "//span[normalize-space()='Generate Report(All)']";
		String useridsearch = "//input[@id='filterPanelForm:j_idt40']";

		String BUIdInput = testData.get(13).get("BUIdInput");
		String BUInterchangeIdInput = testData.get(13).get("BUInterchangeIdInput");
		String BUNameInput = testData.get(13).get("BUNameInput");
		String TypeSearchInput = testData.get(13).get("TypeSearchInput");
		String DepartmentInput = testData.get(13).get("DepartmentInput");
		String EmailIdInput = testData.get(13).get("EmailIdInput");
		String FaxInput = testData.get(13).get("FaxInput");
		String AddressInput = testData.get(13).get("AddressInput");
		String WorkflowNameInput = testData.get(13).get("WorkflowNameInput");
		String OnDuplicateInput = testData.get(13).get("OnDuplicateInput");
		String OnRejectInput = testData.get(13).get("OnRejectInput");
		String OnValidICSRInput = testData.get(13).get("OnValidICSRInput");
		String OnSafetyinfoInput = testData.get(13).get("OnSafetyinfoInput");

		String AlertsOnActivityCompletionInput = testData.get(13).get("AlertsOnActivityCompletionInput");
		String AlertsOnCreatingQueriesCitationsInput = testData.get(13).get("AlertsOnCreatingQueriesCitationsInput");
		String AlertsOnRejectingCitationReviewInput = testData.get(13).get("AlertsOnRejectingCitationReviewInput");
		String AlertsOnWorkflowCompletionInput = testData.get(13).get("AlertsOnWorkflowCompletionInput");
		String AlertsOnFTArequestsInput = testData.get(13).get("AlertsOnFTArequestsInput");
		String AlertsOnQueryChangeArchivedCitationInput = testData.get(13)
				.get("AlertsOnQueryChangeArchivedCitationInput");

		String BobyInput = testData.get(13).get("BobyInput");
		String CCAddressInput = testData.get(13).get("CCAddressInput");
		String SubjectInput = testData.get(13).get("SubjectInput");
		String ToAddressInput = testData.get(13).get("ToAddressInput");
		String CaseInfoLabelInput = testData.get(13).get("CaseInfoLabelInput");
		String TagsLabelInput = testData.get(13).get("TagsLabelInput");
		String SafetyRelevantLabelInput = testData.get(13).get("SafetyRelevantLabelInput");
		String StudyCategoryLabelInput = testData.get(13).get("BobyInput");
		String ProductsLabelInput = testData.get(13).get("StudyCategoryLabelInput");
		String WFRejectedInput = testData.get(13).get("WFRejectedInput");
		String WFSafetyInput = testData.get(13).get("WFSafetyInput");
		String WFICSRInput = testData.get(13).get("WFICSRInput");
		String UserIdInput = testData.get(13).get("UserIdInput");
		String ModuleNameInput = testData.get(13).get("ModuleNameInput");

		driver.findElement(By.xpath(Libary)).click();
		threadwait(1000);
		driver.findElement(By.xpath(BusinessUnit)).click();
		logger.info("Navigating to Business Unit listing page");
		threadwait(1000);

		driver.findElement(By.xpath(CreateButton)).click();
		logger.info("Click on create button to create a BusinessUnit ");
		threadwait(1000);

		driver.findElement(By.xpath(BUId)).sendKeys(BUIdInput);
		threadwait(1000);
		driver.findElement(By.xpath(BUInterchangeId)).sendKeys(BUInterchangeIdInput);
		threadwait(1000);
		driver.findElement(By.xpath(BUName)).sendKeys(BUNameInput);
		threadwait(1000);

		driver.findElement(By.xpath(EncodingType)).click();
		threadwait(1000);

		driver.findElement(By.xpath(EncodingTypeSearch)).sendKeys(TypeSearchInput);
		threadwait(1000);

		driver.findElement(By.xpath(EncodeSelect)).click();
		threadwait(1000);

		driver.findElement(By.xpath(Department)).sendKeys(DepartmentInput);
		threadwait(1000);

		driver.findElement(By.xpath(EmailId)).sendKeys(EmailIdInput);
		threadwait(1000);
		driver.findElement(By.xpath(Fax)).sendKeys(FaxInput);
		threadwait(1000);
		driver.findElement(By.xpath(Address)).sendKeys(AddressInput);
		threadwait(1000);

		driver.findElement(By.xpath(SelectWorkflowLookUp)).click();
		threadwait(1000);

		driver.findElement(By.xpath(WorkflowName)).sendKeys(WorkflowNameInput);
		threadwait(1000);

		driver.findElement(By.xpath(SearchButton)).click();
		threadwait(3000);

		driver.findElement(By.xpath(Selectworkflow)).click();
		threadwait(1000);

		driver.findElement(By.xpath(SelectButton)).click();
		threadwait(1000);

		driver.findElement(By.xpath(OnDuplicate)).click();
		threadwait(1000);

		driver.findElement(By.xpath(OnDuplicateSearch)).sendKeys(OnDuplicateInput);
		threadwait(1000);

		driver.findElement(By.xpath(OnDuplicateSelect)).click();
		threadwait(1000);

		driver.findElement(By.xpath(OnReject)).click();
		threadwait(1000);

		driver.findElement(By.xpath(OnRejectSearch)).sendKeys(OnRejectInput);
		threadwait(1000);

		driver.findElement(By.xpath(OnRejectSelect)).click();
		threadwait(1000);

		driver.findElement(By.xpath(OnValidICSR)).click();
		threadwait(1000);

		driver.findElement(By.xpath(OnValidICSRSearch)).sendKeys(OnValidICSRInput);
		threadwait(1000);

		driver.findElement(By.xpath(OnValidICSRSelect)).click();
		threadwait(1000);

		driver.findElement(By.xpath(OnSafetyinfo)).click();
		threadwait(1000);

		driver.findElement(By.xpath(OnSafetyinfoSearch)).sendKeys(OnSafetyinfoInput);
		threadwait(1000);

		driver.findElement(By.xpath(OnSafetyinfoSelect)).click();
		threadwait(2000);

		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile, new File(
				"D://All_Software//ScreenShots//Business_Unit//BusinessUnit_01_" + screenShotFileName + ".png"));

		driver.findElement(By.xpath(ExtraConfig)).click();
		threadwait(2000);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,450);");
		threadwait(3000);

		driver.findElement(By.xpath(AllowedClassifications)).click();
		threadwait(2000);

		driver.findElement(By.xpath(AllowedClassificationsSelect)).click();
		threadwait(2000);

		driver.findElement(By.xpath(DefaultClassifications)).click();
		threadwait(2000);

		driver.findElement(By.xpath(DefaultClassificationsSelect)).click();
		threadwait(2000);

		driver.findElement(By.xpath(AllowedSafetyInfo)).click();
		threadwait(2000);

		driver.findElement(By.xpath(AllowedSafetyInfoSelect)).click();
		threadwait(2000);

		driver.findElement(By.xpath(NLPTyp)).click();
		threadwait(2000);

		driver.findElement(By.xpath(NLPTypSelect)).click();
		threadwait(2000);

		File screenshotFile1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile1, new File(
				"D://All_Software//ScreenShots//Business_Unit//BusinessUnit_02_" + screenShotFileName + ".png"));

		driver.findElement(By.xpath(ExtraConfig)).click();
		threadwait(2000);

		driver.findElement(By.xpath(LiteratureTriage)).click();
		threadwait(1000);

		driver.findElement(By.xpath(AcceptedTerms)).click();
		threadwait(1000);

		driver.findElement(By.xpath(ProductNames)).click();
		threadwait(1000);

		driver.findElement(By.xpath(Events)).click();
		threadwait(1000);

		driver.findElement(By.xpath(RejectedTerms)).click();
		threadwait(1000);

		driver.findElement(By.xpath(Autoacceptancethreshold)).click();
		threadwait(1000);

		WebElement Timeslider = driver.findElement(By.xpath(AccepetedSlider));

		Actions move = new Actions(driver);
		Action action = (Action) move.dragAndDropBy(Timeslider, 5, 0).build();
		action.perform();

		WebElement Timeslider1 = driver.findElement(By.xpath(ProductsSlider));

		Actions move1 = new Actions(driver);
		Action action1 = (Action) move1.dragAndDropBy(Timeslider1, 62, 0).build();
		action1.perform();

		WebElement Timeslider2 = driver.findElement(By.xpath(EventSlider));

		Actions move2 = new Actions(driver);
		Action action2 = (Action) move2.dragAndDropBy(Timeslider2, 63, 0).build();
		action2.perform();

		WebElement Timeslider3 = driver.findElement(By.xpath(RejectTermSlider));

		Actions move3 = new Actions(driver);
		Action action3 = (Action) move3.dragAndDropBy(Timeslider3, 64, 0).build();
		action3.perform();

		WebElement Timeslider31 = driver.findElement(By.xpath(AutoAcceptanceThresholdSlider));

		Actions move31 = new Actions(driver);
		Action action31 = (Action) move31.dragAndDropBy(Timeslider31, 60, 0).build();
		action31.perform();

		JavascriptExecutor js2 = (JavascriptExecutor) driver;
		js2.executeScript("window.scrollBy(0,300);");
		threadwait(3000);

		driver.findElement(By.xpath(AlertsOnActivityCompletion)).click();
		threadwait(1000);

		driver.findElement(By.xpath(AlertsOnCreatingQueriesCitations)).click();
		threadwait(1000);

		driver.findElement(By.xpath(AlertsOnRejectingCitationReview)).click();
		threadwait(1000);

		driver.findElement(By.xpath(AlertsOnWorkflowCompletion)).click();
		threadwait(1000);

		driver.findElement(By.xpath(AlertsOnFTArequests)).click();
		threadwait(1000);

		driver.findElement(By.xpath(AlertsOnQueryChangeArchivedCitation)).click();
		threadwait(1000);

		driver.findElement(By.xpath(AlertsOnActivityCompletionText)).sendKeys(AlertsOnActivityCompletionInput);
		threadwait(1000);

		driver.findElement(By.xpath(AlertsOnCreatingQueriesCitationsText))
				.sendKeys(AlertsOnCreatingQueriesCitationsInput);
		threadwait(1000);

		driver.findElement(By.xpath(AlertsOnRejectingCitationReviewText))
				.sendKeys(AlertsOnRejectingCitationReviewInput);
		threadwait(1000);

		driver.findElement(By.xpath(AlertsOnWorkflowCompletionText)).sendKeys(AlertsOnWorkflowCompletionInput);
		threadwait(1000);

		driver.findElement(By.xpath(AlertsOnFTArequestsText)).sendKeys(AlertsOnFTArequestsInput);
		threadwait(1000);

		driver.findElement(By.xpath(AlertsOnQueryChangeArchivedCitationText))
				.sendKeys(AlertsOnQueryChangeArchivedCitationInput);
		threadwait(1000);

		File screenshotFile2 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile2, new File(
				"D://All_Software//ScreenShots//Business_Unit//BusinessUnit_03_" + screenShotFileName + ".png"));
		threadwait(2000);

		driver.findElement(By.xpath(SaveandClose)).click();
		threadwait(2000);

		driver.findElement(By.xpath(ClearButton)).click();
		threadwait(2000);

		driver.findElement(By.xpath(AdvanceFilter)).click();
		threadwait(2000);

		driver.findElement(By.xpath(NameText)).sendKeys(BUNameInput);
		threadwait(1000);

		driver.findElement(By.xpath(BUInterchangeIdText)).sendKeys(BUInterchangeIdInput);
		threadwait(1000);

		driver.findElement(By.xpath(Search)).click();
		threadwait(2000);

		driver.findElement(By.xpath(ViewBu)).click();
		threadwait(2000);

		driver.findElement(By.xpath(Parameters)).click();
		threadwait(2000);

		driver.findElement(By.xpath(EnbaleML)).click();
		threadwait(2000);

		driver.findElement(By.xpath(Enbale)).click();
		threadwait(2000);

		driver.findElement(By.xpath(Boby)).clear();
		threadwait(1000);

		driver.findElement(By.xpath(CCAddress)).clear();
		threadwait(1000);

		driver.findElement(By.xpath(Subject)).clear();
		threadwait(1000);

		driver.findElement(By.xpath(ToAddress)).clear();
		threadwait(1000);

		driver.findElement(By.xpath(CaseInfoLabel)).clear();
		threadwait(1000);

		driver.findElement(By.xpath(TagsLabel)).clear();
		threadwait(1000);

		driver.findElement(By.xpath(SafetyRelevantLabel)).clear();
		threadwait(1000);

		driver.findElement(By.xpath(StudyCategoryLabel)).clear();
		threadwait(1000);

		driver.findElement(By.xpath(ProductsLabel)).clear();

		driver.findElement(By.xpath(Boby)).sendKeys(BobyInput);
		threadwait(1000);

		driver.findElement(By.xpath(CCAddress)).sendKeys(CCAddressInput);
		threadwait(1000);

		driver.findElement(By.xpath(Subject)).sendKeys(SubjectInput);
		threadwait(1000);

		driver.findElement(By.xpath(ToAddress)).sendKeys(ToAddressInput);
		threadwait(1000);

		driver.findElement(By.xpath(CaseInfoLabel)).sendKeys(CaseInfoLabelInput);
		threadwait(1000);

		driver.findElement(By.xpath(TagsLabel)).sendKeys(TagsLabelInput);
		threadwait(1000);

		driver.findElement(By.xpath(SafetyRelevantLabel)).sendKeys(SafetyRelevantLabelInput);
		threadwait(1000);

		driver.findElement(By.xpath(StudyCategoryLabel)).sendKeys(StudyCategoryLabelInput);
		threadwait(1000);

		driver.findElement(By.xpath(ProductsLabel)).sendKeys(ProductsLabelInput);
		threadwait(1000);

		driver.findElement(By.xpath(EnableUseOnlyCPDLibrary)).click();
		threadwait(1000);

		File screenshotFile3 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile3, new File(
				"D://All_Software//ScreenShots//Business_Unit//BusinessUnit_04_" + screenShotFileName + ".png"));

		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("window.scrollBy(0,400);");
		threadwait(3000);

		driver.findElement(By.xpath(WFRejected)).clear();
		threadwait(1000);

		driver.findElement(By.xpath(WFSafety)).clear();
		threadwait(1000);

		driver.findElement(By.xpath(WFICSR)).clear();
		threadwait(1000);

		driver.findElement(By.xpath(WFRejected)).sendKeys(WFRejectedInput);
		threadwait(1000);

		driver.findElement(By.xpath(WFSafety)).sendKeys(WFSafetyInput);
		threadwait(1000);

		driver.findElement(By.xpath(WFICSR)).sendKeys(WFICSRInput);
		threadwait(1000);

		File screenshotFile4 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile4, new File(
				"D://All_Software//ScreenShots//Business_Unit//BusinessUnit_05_" + screenShotFileName + ".png"));

		JavascriptExecutor js11 = (JavascriptExecutor) driver;
		js11.executeScript("window.scrollBy(500,0);");
		threadwait(5000);

		driver.findElement(By.xpath(SavePara)).click();
		threadwait(3000);

		driver.findElement(By.xpath(LiteratureConfig)).click();
		threadwait(1000);

		JavascriptExecutor js12 = (JavascriptExecutor) driver;
		js12.executeScript("window.scrollBy(500,0);");
		threadwait(5000);

		driver.findElement(By.xpath(SaveandClose)).click();
		threadwait(2000);

		driver.findElement(By.xpath(xpathReports)).click();
		driver.findElement(By.xpath(xpathAdminAudit)).click();
		logger.info("Navigating to Audit Report Filter");

		threadwait(2000);

		driver.findElement(By.xpath(xpathClearButton)).click();
		logger.info("Clearing Audit Report Filter");
		threadwait(10000);

		driver.findElement(By.xpath(useridsearch)).sendKeys(UserIdInput);
		threadwait(2000);

		driver.findElement(By.xpath(xpathModuleName)).click();
		threadwait(2000);

		driver.findElement(By.xpath(xpathMoudleSearcgBar)).sendKeys(ModuleNameInput);

		logger.info("Entering the Module Name For Audit Report");
		threadwait(2000);
		driver.findElement(By.xpath(xpathSelectModule)).click();

		File screenshotFile5 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile5, new File(
				"D://All_Software//ScreenShots//Business_Unit//BusinessUnit_06_" + screenShotFileName + ".png"));

		logger.info("ScreenShot taken once Before Applying the Filter ");

		driver.findElement(By.xpath(xpathSearchauditButton)).click();
		logger.info("Clickling Search button For Audit Report");
		threadwait(5000);

		File screenshotFile6 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile6, new File(
				"D://All_Software//ScreenShots//Business_Unit//BusinessUnit_07_" + screenShotFileName + ".png"));

		logger.info("ScreenShot after Applying the Filter ");

		driver.findElement(By.xpath(xpathSessionId)).click();
		logger.info("Navigating to Detailed Audit Report Filter");
		threadwait(2000);

		File screenshotFile7 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile7, new File(
				"D://All_Software//ScreenShots//Business_Unit//BusinessUnit_08_" + screenShotFileName + ".png"));

		logger.info("ScreenShot of Detailed Audit Report Filter ");

		driver.findElement(By.xpath(xpathBackButton)).click();
		logger.info("Navigating to Audit Report Listing Page");
		threadwait(5000);

		driver.findElement(By.xpath(xpathGenerateAll)).click();
		threadwait(15000);
		logger.info("Generating The Audit Report of Create BU");

	}

	public void createingBulkUser() throws IOException {
		threadwait(5000);

		logger.info("Creating a Bulk user and verifying created user Audit`");

		Date currentdate = new Date();
		String screenShotFileName = timeStampFormat.format(currentdate);

		threadwait(5000);
		String testDataFile = "selectMultipleLiteratures.json";
		List<Map<String, String>> testData = TestDataFromJsonUtils.readJsonTestDataFromFile(testDataFile);

		String Security = "//*[@id=\"menuform1:security\"]/a/span";
		String User = "//*[@id=\"menuform1:user\"]/a";
		String UploadUser = "//span[@class='ui-button-text ui-c'][normalize-space()='Upload Users']";
		String Password = "/html/body/div[2]/form[3]/div/div[2]/div/div[2]/input";

		String SupportingDocument = "//input[@id='uploadUsersForm:supDocProducts_input']";
		String UplaodButton = "//span[normalize-space()='Upload']";
		String SaveButton = "//button[@id='uploadUsersForm:j_idt108']//span[@class='ui-button-text ui-c'][normalize-space()='Save']";

		String xpathReports = "//span[normalize-space()='Reports']";
		String xpathAdminAudit = "//a[@href='/ReTrans/views/audit/filterPanel.xhtml']//span[contains(text(),'Admin')]";
		String xpathClearButton = "//span[@class='ui-button-icon-left ui-icon ui-c fa fa-eraser F20 gray']";
		String xpathModuleName = "//*[@id=\"filterPanelForm:panelContextType_label\"]";
		String xpathSelectModule = "//td[normalize-space()='NLP']";
		String xpathMoudleSearcgBar = "//input[@id='filterPanelForm:panelContextType_filter']";
		String xpathSearchauditButton = "//span[normalize-space()='Search']";
		String xpathSessionId = "//a[@id='auditlistListForm:auditlistGrid:0:j_idt38']";
		String xpathBackButton = "//*[@id=\"auditFieldLogForm:j_idt34\"]";
		String xpathGenerateAll = "//span[normalize-space()='Generate Report(All)']";
		String useridsearch = "//input[@id='filterPanelForm:j_idt40']";

		String PasswordInput = testData.get(14).get("PasswordInput");
		String SupportingDocumentInput = testData.get(14).get("SupportingDocumentInput");
		String UserIdInput = testData.get(14).get("UserIdInput");
		String ModuleNameInput = testData.get(14).get("ModuleNameInput");

		driver.findElement(By.xpath(Security)).click();
		driver.findElement(By.xpath(User)).click();
		logger.info("Navigating to User listing page");
		threadwait(2000);

		driver.findElement(By.xpath(UploadUser)).click();
		threadwait(2000);

		driver.findElement(By.xpath(SupportingDocument)).sendKeys(SupportingDocumentInput);
		logger.info("Selecting the Csv File to Upload");
		threadwait(3000);

		driver.findElement(By.xpath(UplaodButton)).click();
		threadwait(1000);

		driver.findElement(By.xpath(Password)).sendKeys(PasswordInput);
		threadwait(1000);

		driver.findElement(By.xpath(SaveButton)).click();
		threadwait(1000);

		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile, new File(
				"D://All_Software//ScreenShots//Create_Bulk_Users//CreateBulkUsers01_" + screenShotFileName + ".png"));

		driver.findElement(By.xpath(xpathReports)).click();
		driver.findElement(By.xpath(xpathAdminAudit)).click();
		logger.info("Navigating to Audit Report Filter");

		threadwait(2000);

		driver.findElement(By.xpath(xpathClearButton)).click();
		logger.info("Clearing Audit Report Filter");
		threadwait(10000);

		driver.findElement(By.xpath(useridsearch)).sendKeys(UserIdInput);
		threadwait(2000);

		driver.findElement(By.xpath(xpathModuleName)).click();
		threadwait(2000);

		driver.findElement(By.xpath(xpathMoudleSearcgBar)).sendKeys(ModuleNameInput);

		logger.info("Entering the Module Name For Audit Report");
		threadwait(2000);
		driver.findElement(By.xpath(xpathSelectModule)).click();

		File screenshotFile1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile1, new File(
				"D://All_Software//ScreenShots//Create_Bulk_Users//CreateBulkUsers02_" + screenShotFileName + ".png"));

		logger.info("ScreenShot taken once Before Applying the Filter ");

		driver.findElement(By.xpath(xpathSearchauditButton)).click();
		logger.info("Clickling Search button For Audit Report");
		threadwait(5000);

		File screenshotFile2 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile2, new File(
				"D://All_Software//ScreenShots//Create_Bulk_Users//CreateBulkUsers03_" + screenShotFileName + ".png"));

		logger.info("ScreenShot after Applying the Filter ");

		driver.findElement(By.xpath(xpathSessionId)).click();
		logger.info("Navigating to Detailed Audit Report Filter");
		threadwait(2000);

		File screenshotFile3 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile3, new File(
				"D://All_Software//ScreenShots//Create_Bulk_Users//CreateBulkUsers04_" + screenShotFileName + ".png"));

		logger.info("ScreenShot of Detailed Audit Report Filter ");

		driver.findElement(By.xpath(xpathBackButton)).click();
		logger.info("Navigating to Audit Report Listing Page");
		threadwait(5000);

		driver.findElement(By.xpath(xpathGenerateAll)).click();
		threadwait(15000);
		logger.info("Generating The Audit Report of Create BU");

	}

	public void createProduct() throws IOException {
		threadwait(5000);

		logger.info("Creating a Product and verifying created Product Audit`");

		Date currentdate = new Date();
		String screenShotFileName = timeStampFormat.format(currentdate);

		threadwait(5000);
		String testDataFile = "selectMultipleLiteratures.json";
		List<Map<String, String>> testData = TestDataFromJsonUtils.readJsonTestDataFromFile(testDataFile);

		String Libary = "//body/div[@id='layout-topbar-cover']/div[@id='layout-topbar']/form[@id='menuform1']/div[@id='layout-menu-cover']/ul[@id='layout-menu']/li[@id='menuform1:admin_xml']/a[1]";
		String LPDLibary = "//a[@href='/ReTrans/views/lpd/list.xhtml']";
		String Create = "//button[@id='lpdListForm:lpdGrid:j_idt38']//span[@class='ui-button-text ui-c']";
		String BusinessUnitLookup = "/html/body/div[2]/div[2]/div/form[1]/div[1]/div[1]/div/div[1]/div[2]/button";
		String BUName = "//input[@id='lpdCompanyUnitLookForm:j_idt354']";
		String BUid = "//input[@id='lpdCompanyUnitLookForm:j_idt356']";
		String Search = "//span[normalize-space()='Search']";
		String SelectBU = "/html/body/div[2]/div[2]/div/form[2]/div/div[2]/div/div[3]/div[4]/table/tbody/tr/td[1]/div/div[2]/span";
		String SelectBusinessUnit = "//span[normalize-space()='Select']";
		String ProductRecordType = "/html/body/div[2]/div[2]/div/form[1]/div[1]/div[1]/div/div[1]/div[4]/div";
		String ProductRecordTypeSearch = "/html/body/div[14]/div[1]/input";
		String ProductRecordTypeSelect = "/html/body/div[14]/div[2]/table/tbody/tr[4]";
		String EnableActive = "/html/body/div[2]/div[2]/div/form[1]/div[1]/div[1]/div/div[1]/div[6]/div/div[2]";
		String AlertId = "//input[@id='createlpdForm:alertId']";

		String ProductType = "/html/body/div[2]/div[2]/div/form[1]/div[1]/div[1]/div/div[2]/div[4]/div/div[3]";
		String ProductTypeSearch = "/html/body/div[15]/div[1]/input";
		String ProductTypeSelect = "/html/body/div[15]/div[2]/table/tbody/tr[5]/td";

		String TherapeuticArea = "/html/body/div[2]/div[2]/div/form[1]/div[1]/div[1]/div/div[2]/div[6]/div/div[3]";
		String TherapeuticAreaSearch = "/html/body/div[16]/div[1]/input";
		String TherapeuticAreaSelect = "/html/body/div[16]/div[2]/table/tbody/tr[5]/td";

		String Product = "//input[@id='createlpdForm:localTradeName']";
		String ProductName = "//input[@id='createlpdForm:intTradeName']";
		String Concentration = "//input[@id='createlpdForm:concentration']";
		String Description = "//textarea[@id='createlpdForm:description']";
		String SaveandClose = "//span[normalize-space()='Save and Close']";

		String xpathReports = "//span[normalize-space()='Reports']";
		String xpathAdminAudit = "//a[@href='/ReTrans/views/audit/filterPanel.xhtml']//span[contains(text(),'Admin')]";
		String xpathClearButton = "//span[@class='ui-button-icon-left ui-icon ui-c fa fa-eraser F20 gray']";
		String xpathModuleName = "//*[@id=\"filterPanelForm:panelContextType_label\"]";
		String xpathSelectModule = "//td[normalize-space()='NLP']";
		String xpathMoudleSearcgBar = "//input[@id='filterPanelForm:panelContextType_filter']";
		String xpathSearchauditButton = "//span[normalize-space()='Search']";
		String xpathSessionId = "//a[@id='auditlistListForm:auditlistGrid:0:j_idt38']";
		String xpathBackButton = "//*[@id=\"auditFieldLogForm:j_idt34\"]";
		String xpathGenerateAll = "//span[normalize-space()='Generate Report(All)']";
		String useridsearch = "//input[@id='filterPanelForm:j_idt40']";

		String BUIdInput = testData.get(15).get("BUIdInput");
		String BUNameInput = testData.get(15).get("BUNameInput");
		String ProductRecordTypeInput = testData.get(15).get("ProductRecordTypeInput");
		String AlertIdInput = testData.get(15).get("AlertIdInput");
		String ProductTypeInput = testData.get(15).get("ProductTypeInput");
		String TherapeuticAreaInput = testData.get(15).get("TherapeuticAreaInput");
		String ProductInput = testData.get(15).get("ProductInput");
		String ProductNameInput = testData.get(15).get("ProductNameInput");
		String ConcentrationInput = testData.get(15).get("ConcentrationInput");
		String DescriptionInput = testData.get(15).get("DescriptionInput");
		String UserIdInput = testData.get(15).get("UserIdInput");
		String ModuleNameInput = testData.get(15).get("ModuleNameInput");

		driver.findElement(By.xpath(Libary)).click();
		threadwait(1000);

		driver.findElement(By.xpath(LPDLibary)).click();
		threadwait(1000);

		driver.findElement(By.xpath(Create)).click();
		threadwait(1000);

		driver.findElement(By.xpath(BusinessUnitLookup)).click();
		threadwait(1000);

		driver.findElement(By.xpath(BUName)).sendKeys(BUNameInput);
		threadwait(1000);

		driver.findElement(By.xpath(BUid)).sendKeys(BUIdInput);
		threadwait(1000);

		driver.findElement(By.xpath(Search)).click();
		threadwait(2000);

		driver.findElement(By.xpath(SelectBU)).click();
		threadwait(1000);

		driver.findElement(By.xpath(SelectBusinessUnit)).click();
		threadwait(2000);

		driver.findElement(By.xpath(ProductRecordType)).click();
		threadwait(1000);

		driver.findElement(By.xpath(ProductRecordTypeSearch)).sendKeys(ProductRecordTypeInput);
		threadwait(1000);

		driver.findElement(By.xpath(ProductRecordTypeSelect)).click();
		threadwait(1000);

		driver.findElement(By.xpath(EnableActive)).click();
		threadwait(1000);

		driver.findElement(By.xpath(AlertId)).sendKeys(AlertIdInput);
		threadwait(1000);

		driver.findElement(By.xpath(ProductType)).click();
		threadwait(1000);

		driver.findElement(By.xpath(ProductTypeSearch)).sendKeys(ProductTypeInput);
		threadwait(1000);

		driver.findElement(By.xpath(ProductTypeSelect)).click();
		threadwait(1000);

		driver.findElement(By.xpath(TherapeuticArea)).click();
		threadwait(1000);

		driver.findElement(By.xpath(TherapeuticAreaSearch)).sendKeys(TherapeuticAreaInput);
		threadwait(1000);

		driver.findElement(By.xpath(TherapeuticAreaSelect)).click();
		threadwait(1000);

		driver.findElement(By.xpath(Product)).sendKeys(ProductInput);
		threadwait(1000);

		driver.findElement(By.xpath(ProductName)).sendKeys(ProductNameInput);
		threadwait(1000);

		driver.findElement(By.xpath(Concentration)).sendKeys(ConcentrationInput);
		threadwait(1000);

		driver.findElement(By.xpath(Description)).sendKeys(DescriptionInput);
		threadwait(1000);

		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile, new File(
				"D://All_Software//ScreenShots//Create_Product//CreateProduct01_" + screenShotFileName + ".png"));

		driver.findElement(By.xpath(SaveandClose)).click();

		driver.findElement(By.xpath(xpathReports)).click();
		driver.findElement(By.xpath(xpathAdminAudit)).click();
		logger.info("Navigating to Audit Report Filter");

		threadwait(2000);

		driver.findElement(By.xpath(xpathClearButton)).click();
		logger.info("Clearing Audit Report Filter");
		threadwait(10000);

		driver.findElement(By.xpath(useridsearch)).sendKeys(UserIdInput);
		threadwait(2000);

		driver.findElement(By.xpath(xpathModuleName)).click();
		threadwait(2000);

		driver.findElement(By.xpath(xpathMoudleSearcgBar)).sendKeys(ModuleNameInput);

		logger.info("Entering the Module Name For Audit Report");
		threadwait(2000);
		driver.findElement(By.xpath(xpathSelectModule)).click();

		File screenshotFile1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile1, new File(
				"D://All_Software//ScreenShots//Create_Product//CreateProduct02_" + screenShotFileName + ".png"));

		logger.info("ScreenShot taken once Before Applying the Filter ");

		driver.findElement(By.xpath(xpathSearchauditButton)).click();
		logger.info("Clickling Search button For Audit Report");
		threadwait(5000);

		File screenshotFile2 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile2, new File(
				"D://All_Software//ScreenShots//Create_Product//CreateProduct03_" + screenShotFileName + ".png"));

		logger.info("ScreenShot after Applying the Filter ");

		driver.findElement(By.xpath(xpathSessionId)).click();
		logger.info("Navigating to Detailed Audit Report Filter");
		threadwait(2000);

		File screenshotFile3 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile3, new File(
				"D://All_Software//ScreenShots//Create_Product//CreateProduct04_" + screenShotFileName + ".png"));

		logger.info("ScreenShot of Detailed Audit Report Filter ");

		driver.findElement(By.xpath(xpathBackButton)).click();
		logger.info("Navigating to Audit Report Listing Page");
		threadwait(5000);

		driver.findElement(By.xpath(xpathGenerateAll)).click();
		threadwait(15000);
		logger.info("Generating The Audit Report of Create BU");
	}

	public void creatingBulkProductandExportProducts() throws IOException {
		threadwait(5000);

		logger.info("Creating a Product and verifying created Product Audit`");

		Date currentdate = new Date();
		String screenShotFileName = timeStampFormat.format(currentdate);

		threadwait(5000);
		String testDataFile = "selectMultipleLiteratures.json";
		List<Map<String, String>> testData = TestDataFromJsonUtils.readJsonTestDataFromFile(testDataFile);

		String Libary = "//body/div[@id='layout-topbar-cover']/div[@id='layout-topbar']/form[@id='menuform1']/div[@id='layout-menu-cover']/ul[@id='layout-menu']/li[@id='menuform1:admin_xml']/a[1]";
		String LPDLibary = "//a[@href='/ReTrans/views/lpd/list.xhtml']";
		String Clear = "//span[normalize-space()='Clear']";
		String ReloadCache = "//span[normalize-space()='Reload Cache']";
		String CheckBox = "/html/body/div[2]/form[1]/div[1]/div[3]/div/table/thead/tr/th[1]/div/div[2]/span";
		String ExportProduct = "//span[normalize-space()='Export Products']";
		String Title = "//input[@id='submitRecReportForm:title']";
		String Description = "//textarea[@id='submitRecReportForm:notes']";
		String Submit = "//span[normalize-space()='Submit']";
		String AdanceFilter = "//span[@class='ui-button-text ui-c'][normalize-space()='Advance Filter']";

		String ProductActive = "/html/body/div[2]/form[2]/div/div[2]/div/div/div/div/div[3]/div[4]/div/div[3]";
		String ProductActiveSearch = "/html/body/div[24]/div[1]/input";
		String ProductActiveSelect = "/html/body/div[24]/div[2]/table/tbody/tr[2]/td";
		String Search = "//span[normalize-space()='Search']";
		String UploadLPD = "//span[@class='ui-button-text ui-c'][normalize-space()='Upload LPD']";

		String SupportingDoc = "//input[@id='uploadProdsForm:supDocProducts_input']";
		String Close = "//button[@id='uploadProdsForm:j_idt94']//span[@class='ui-button-text ui-c'][normalize-space()='Close']";
		String UplaodButton = "//span[normalize-space()='Upload']";
		String SaveButton = "//button[@id='uploadProdsForm:j_idt93']//span[@class='ui-button-text ui-c'][normalize-space()='Save']";
		String Reports = "//span[normalize-space()='Reports']";
		String InboxReports = "//span[normalize-space()='Inbox Report..']";
		String GenReports = "//a[@href='/ReTrans/views/genReportQueue/list.xhtml']";
		String Refresh = "//span[normalize-space()='Refresh']";
		String Status = "/html/body/div[2]/form/div[1]/div[1]/div/div[2]/div/div[3]";
		String StatusSearch = "//input[@id='genReportQueueListForm:genReportQueueGrid:statusFilter_filter']";
		String StatusSearchSelect = "/html/body/div[21]/div[2]/table/tbody/tr[4]/td";
		String DownloadIcon = "/html/body/div[2]/form/div[1]/div[4]/table/tbody/tr[1]/td[7]/a";

		String xpathReports = "//span[normalize-space()='Reports']";
		String xpathAdminAudit = "//a[@href='/ReTrans/views/audit/filterPanel.xhtml']//span[contains(text(),'Admin')]";
		String xpathClearButton = "//span[@class='ui-button-icon-left ui-icon ui-c fa fa-eraser F20 gray']";
		String xpathModuleName = "//*[@id=\"filterPanelForm:panelContextType_label\"]";
		String xpathSelectModule = "//td[normalize-space()='NLP']";
		String xpathMoudleSearcgBar = "//input[@id='filterPanelForm:panelContextType_filter']";
		String xpathSearchauditButton = "//span[normalize-space()='Search']";
		String xpathSessionId = "//a[@id='auditlistListForm:auditlistGrid:0:j_idt38']";
		String xpathBackButton = "//*[@id=\"auditFieldLogForm:j_idt34\"]";
		String xpathGenerateAll = "//span[normalize-space()='Generate Report(All)']";
		String useridsearch = "//input[@id='filterPanelForm:j_idt40']";

		String TitleInput = testData.get(16).get("TitleInput");
		String DescriptionInput = testData.get(16).get("DescriptionInput");
		String ProductActiveInput = testData.get(16).get("ProductActiveInput");
		String SupportingProductInput = testData.get(16).get("SupportingProductInput");
		String StatusInput = testData.get(16).get("StatusInput");
		String UserIdInput = testData.get(16).get("UserIdInput");
		String ModuleNameInput = testData.get(16).get("ModuleNameInput");

		driver.findElement(By.xpath(Libary)).click();
		threadwait(1000);

		driver.findElement(By.xpath(LPDLibary)).click();
		threadwait(1000);

		driver.findElement(By.xpath(ReloadCache)).click();
		threadwait(1000);

		driver.findElement(By.xpath(Clear)).click();
		threadwait(1000);

		driver.findElement(By.xpath(AdanceFilter)).click();
		threadwait(1000);

		driver.findElement(By.xpath(ProductActive)).click();
		threadwait(1000);

		driver.findElement(By.xpath(ProductActiveSearch)).sendKeys(ProductActiveInput);
		threadwait(1000);

		driver.findElement(By.xpath(ProductActiveSelect)).click();
		threadwait(1000);

		driver.findElement(By.xpath(Search)).click();
		threadwait(2000);

		driver.findElement(By.xpath(CheckBox)).click();
		threadwait(1000);

		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile, new File(
				"D://All_Software//ScreenShots//Create_Bulk_Product_And_Export_Product//CreateBulkProductExportProduct01_"
						+ screenShotFileName + ".png"));

		driver.findElement(By.xpath(ExportProduct)).click();
		threadwait(1000);

		driver.findElement(By.xpath(Title)).sendKeys(TitleInput);
		threadwait(1000);

		driver.findElement(By.xpath(Description)).sendKeys(DescriptionInput);
		threadwait(1000);

		File screenshotFile1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile1, new File(
				"D://All_Software//ScreenShots//Create_Bulk_Product_And_Export_Product//CreateBulkProductExportProduct02_"
						+ screenShotFileName + ".png"));

		driver.findElement(By.xpath(Submit)).click();
		threadwait(2000);

		driver.findElement(By.xpath(Clear)).click();
		threadwait(2000);

		threadwait(2000);
		driver.findElement(By.xpath(Libary)).click();
		threadwait(2000);

		driver.findElement(By.xpath(LPDLibary)).click();
		threadwait(2000);

		driver.findElement(By.xpath(ReloadCache)).click();
		threadwait(2000);

		driver.findElement(By.xpath(Clear)).click();
		threadwait(2000);

		driver.findElement(By.xpath(UploadLPD)).click();
		threadwait(2000);

		driver.findElement(By.xpath(Close)).click();
		threadwait(2000);

		driver.findElement(By.xpath(UploadLPD)).click();
		threadwait(2000);

		driver.findElement(By.xpath(SupportingDoc)).sendKeys(SupportingProductInput);
		logger.info("Selecting the Csv File to Upload");
		threadwait(5000);

		File screenshotFile2 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile2, new File(
				"D://All_Software//ScreenShots//Create_Bulk_Product_And_Export_Product//CreateBulkProductExportProduct03_"
						+ screenShotFileName + ".png"));

		driver.findElement(By.xpath(UplaodButton)).click();
		threadwait(2000);

		File screenshotFile3 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile3, new File(
				"D://All_Software//ScreenShots//Create_Bulk_Product_And_Export_Product//CreateBulkProductExportProduct04_"
						+ screenShotFileName + ".png"));

		driver.findElement(By.xpath(SaveButton)).click();
		threadwait(2000);

		driver.findElement(By.xpath(Reports)).click();
		threadwait(2000);

		driver.findElement(By.xpath(InboxReports)).click();
		threadwait(2000);

		driver.findElement(By.xpath(GenReports)).click();
		threadwait(2000);

		driver.findElement(By.xpath(Refresh)).click();
		threadwait(2000);

		driver.findElement(By.xpath(Status)).click();
		threadwait(2000);

		driver.findElement(By.xpath(StatusSearch)).sendKeys(StatusInput);
		threadwait(2000);

		driver.findElement(By.xpath(StatusSearchSelect)).click();
		threadwait(5000);

		driver.findElement(By.xpath(DownloadIcon)).click();
		threadwait(3000);

		File screenshotFile4 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile4, new File(
				"D://All_Software//ScreenShots//Create_Bulk_Product_And_Export_Product//CreateBulkProductExportProduct05_"
						+ screenShotFileName + ".png"));

		driver.findElement(By.xpath(xpathReports)).click();
		driver.findElement(By.xpath(xpathAdminAudit)).click();
		logger.info("Navigating to Audit Report Filter");

		threadwait(2000);

		driver.findElement(By.xpath(xpathClearButton)).click();
		logger.info("Clearing Audit Report Filter");
		threadwait(10000);

		driver.findElement(By.xpath(useridsearch)).sendKeys(UserIdInput);
		threadwait(2000);

		driver.findElement(By.xpath(xpathModuleName)).click();
		threadwait(2000);

		driver.findElement(By.xpath(xpathMoudleSearcgBar)).sendKeys(ModuleNameInput);

		logger.info("Entering the Module Name For Audit Report");
		threadwait(2000);
		driver.findElement(By.xpath(xpathSelectModule)).click();

		File screenshotFile5 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile5, new File(
				"D://All_Software//ScreenShots//Create_Bulk_Product_And_Export_Product//CreateBulkProductExportProduct06_"
						+ screenShotFileName + ".png"));

		logger.info("ScreenShot taken once Before Applying the Filter ");

		driver.findElement(By.xpath(xpathSearchauditButton)).click();
		logger.info("Clickling Search button For Audit Report");
		threadwait(5000);

		File screenshotFile6 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile6, new File(
				"D://All_Software//ScreenShots//Create_Bulk_Product_And_Export_Product//CreateBulkProductExportProduct07_"
						+ screenShotFileName + ".png"));
		logger.info("ScreenShot after Applying the Filter ");

		driver.findElement(By.xpath(xpathSessionId)).click();
		logger.info("Navigating to Detailed Audit Report Filter");
		threadwait(2000);

		File screenshotFile7 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile7, new File(
				"D://All_Software//ScreenShots//Create_Bulk_Product_And_Export_Product//CreateBulkProductExportProduct08_"
						+ screenShotFileName + ".png"));

		logger.info("ScreenShot of Detailed Audit Report Filter ");

		driver.findElement(By.xpath(xpathBackButton)).click();
		logger.info("Navigating to Audit Report Listing Page");
		threadwait(5000);

		driver.findElement(By.xpath(xpathGenerateAll)).click();
		threadwait(15000);
		logger.info("Generating The Audit Report of Create BU");

	}

	public void creatingWorkFlowRules() throws IOException {
		threadwait(5000);

		logger.info("Creating a WorkFlowRules and verifying created WorkFlowRules and  Audit");

		Date currentdate = new Date();
		String screenShotFileName = timeStampFormat.format(currentdate);

		threadwait(5000);
		String testDataFile = "selectMultipleLiteratures.json";
		List<Map<String, String>> testData = TestDataFromJsonUtils.readJsonTestDataFromFile(testDataFile);

		String Libary = "//body/div[@id='layout-topbar-cover']/div[@id='layout-topbar']/form[@id='menuform1']/div[@id='layout-menu-cover']/ul[@id='layout-menu']/li[@id='menuform1:admin_xml']/a[1]";
		String WorkFlowRules = "/html/body/div[1]/div/form[1]/div/ul/li[3]/ul/li[8]/a/span";
		String Create = "//span[normalize-space()='Create']";
		String PencilIconOne = "//div[@id='wfActivityRuleForm:wfActivityRuleGrid:0:j_idt115']//span[@class='ui-icon ui-icon-pencil']";
		String PencilIconTwo = "//div[@id='wfActivityRuleForm:wfActivityRuleGrid:1:j_idt115']//span[@class='ui-icon ui-icon-pencil']";
		String PencilIconthree = "//div[@id='wfActivityRuleForm:wfActivityRuleGrid:2:j_idt115']//span[@class='ui-icon ui-icon-pencil']";
		String PencilIconfour = "//div[@id='wfActivityRuleForm:wfActivityRuleGrid:3:j_idt115']//span[@class='ui-icon ui-icon-pencil']";

		String BUunit = "//div[@id='wfActivityRuleForm:wfActivityRuleGrid:0:companyId']//div[@class='ui-selectonemenu-trigger ui-state-default ui-corner-right']";
		String BUunitSearch = "//input[@id='wfActivityRuleForm:wfActivityRuleGrid:0:companyId_filter']";
		String BUunitSelect = "//tr[@id='wfActivityRuleForm:wfActivityRuleGrid:0:companyId_2']//td[contains(text(),'BU_PV_Test')]";

		String BUunit1 = "//div[@id='wfActivityRuleForm:wfActivityRuleGrid:1:companyId']//div[@class='ui-selectonemenu-trigger ui-state-default ui-corner-right']";
		String BUunitSearch1 = "//input[@id='wfActivityRuleForm:wfActivityRuleGrid:1:companyId_filter']";
		String BUunitSelect1 = "//tr[@id='wfActivityRuleForm:wfActivityRuleGrid:1:companyId_2']//td[contains(text(),'BU_PV_Test')]";

		String BUunit2 = "//div[@id='wfActivityRuleForm:wfActivityRuleGrid:2:companyId']//div[@class='ui-selectonemenu-trigger ui-state-default ui-corner-right']";
		String BUunitSearch2 = "//input[@id='wfActivityRuleForm:wfActivityRuleGrid:2:companyId_filter']";
		String BUunitSelect2 = "//tr[@id='wfActivityRuleForm:wfActivityRuleGrid:2:companyId_2']//td[contains(text(),'BU_PV_Test')]";

		String BUunit3 = "//div[@id='wfActivityRuleForm:wfActivityRuleGrid:3:companyId']//div[@class='ui-selectonemenu-trigger ui-state-default ui-corner-right']";
		String BUunitSearch3 = "//input[@id='wfActivityRuleForm:wfActivityRuleGrid:3:companyId_filter']";
		String BUunitSelect3 = "//tr[@id='wfActivityRuleForm:wfActivityRuleGrid:3:companyId_2']//td[contains(text(),'BU_PV_Test')]";

		String RuleType = "//div[@id='wfActivityRuleForm:wfActivityRuleGrid:0:ruleType']//div[@class='ui-selectonemenu-trigger ui-state-default ui-corner-right']";
		String RuleTypeSearch = "//input[@id='wfActivityRuleForm:wfActivityRuleGrid:0:ruleType_filter']";
		String RuleTypeSelect = "//tr[@id='wfActivityRuleForm:wfActivityRuleGrid:0:ruleType_1']//td[contains(text(),'Activity Completion')]";

		String RuleType1 = "//div[@id='wfActivityRuleForm:wfActivityRuleGrid:1:ruleType']//div[@class='ui-selectonemenu-trigger ui-state-default ui-corner-right']";
		String RuleTypeSearch1 = "//input[@id='wfActivityRuleForm:wfActivityRuleGrid:1:ruleType_filter']";
		String RuleTypeSelect1 = "//tr[@id='wfActivityRuleForm:wfActivityRuleGrid:1:ruleType_1']//td[contains(text(),'Activity Completion')]";

		String RuleType2 = "//div[@id='wfActivityRuleForm:wfActivityRuleGrid:2:ruleType']//div[@class='ui-selectonemenu-trigger ui-state-default ui-corner-right']";
		String RuleTypeSearch2 = "//input[@id='wfActivityRuleForm:wfActivityRuleGrid:2:ruleType_filter']";
		String RuleTypeSelect2 = "//tr[@id='wfActivityRuleForm:wfActivityRuleGrid:2:ruleType_1']//td[contains(text(),'Activity Completion')]";

		String RuleType3 = "//div[@id='wfActivityRuleForm:wfActivityRuleGrid:3:ruleType']//div[@class='ui-selectonemenu-trigger ui-state-default ui-corner-right']";
		String RuleTypeSearch3 = "//input[@id='wfActivityRuleForm:wfActivityRuleGrid:3:ruleType_filter']";
		String RuleTypeSelect3 = "//tr[@id='wfActivityRuleForm:wfActivityRuleGrid:3:ruleType_3']//td[contains(text(),'Sending Email as Submission')]";

		String WFActivity = "//div[@id='wfActivityRuleForm:wfActivityRuleGrid:0:activityId']//div[@class='ui-selectonemenu-trigger ui-state-default ui-corner-right']";
		String WFActivitySearch = "//input[@id='wfActivityRuleForm:wfActivityRuleGrid:0:activityId_filter']";
		String WFActivitySelect = "//td[normalize-space()='Initial Review']";

		String WFActivity1 = "//div[@id='wfActivityRuleForm:wfActivityRuleGrid:1:activityId']//div[@class='ui-selectonemenu-trigger ui-state-default ui-corner-right']";
		String WFActivitySearch1 = "//input[@id='wfActivityRuleForm:wfActivityRuleGrid:1:activityId_filter']";
		String WFActivitySelect1 = "//tr[@id='wfActivityRuleForm:wfActivityRuleGrid:1:activityId_6']//td[contains(text(),'QC Review')]";

		String WFActivity2 = "//div[@id='wfActivityRuleForm:wfActivityRuleGrid:2:activityId']//div[@class='ui-selectonemenu-trigger ui-state-default ui-corner-right']";
		String WFActivitySearch2 = "//input[@id='wfActivityRuleForm:wfActivityRuleGrid:2:activityId_filter']";
		String WFActivitySelect2 = "//tr[@id='wfActivityRuleForm:wfActivityRuleGrid:2:activityId_6']//td[contains(text(),'QC Review')]";

		String WFActivity3 = "//div[@id='wfActivityRuleForm:wfActivityRuleGrid:3:activityId']//div[@class='ui-selectonemenu-trigger ui-state-default ui-corner-right']";
		String WFActivitySearch3 = "//input[@id='wfActivityRuleForm:wfActivityRuleGrid:3:activityId_filter']";
		String WFActivitySelect3 = "//tr[@id='wfActivityRuleForm:wfActivityRuleGrid:3:activityId_6']//td[contains(text(),'QC Review')]";

		String ExecutionTime = "//label[@id='wfActivityRuleForm:wfActivityRuleGrid:0:executionTime_label']";
		String ExecutionTimeSearch = "//input[@id='wfActivityRuleForm:wfActivityRuleGrid:0:executionTime_filter']";
		String ExecutionTimeSelect = "//tr[@id='wfActivityRuleForm:wfActivityRuleGrid:0:executionTime_1']//td[contains(text(),'NA')]";

		String ExecutionTime1 = "//label[@id='wfActivityRuleForm:wfActivityRuleGrid:1:executionTime_label']";
		String ExecutionTimeSearch1 = "//input[@id='wfActivityRuleForm:wfActivityRuleGrid:1:executionTime_filter']";
		String ExecutionTimeSelect1 = "//tr[@id='wfActivityRuleForm:wfActivityRuleGrid:1:executionTime_1']//td[contains(text(),'NA')]";

		String ExecutionTime3 = "//label[@id='wfActivityRuleForm:wfActivityRuleGrid:3:executionTime_label']";
		String ExecutionTimeSearch3 = "//input[@id='wfActivityRuleForm:wfActivityRuleGrid:3:executionTime_filter']";
		String ExecutionTimeSelect3 = "//tr[@id='wfActivityRuleForm:wfActivityRuleGrid:3:executionTime_2']//td[contains(text(),'On Entry')]";

		String ExecutionTime2 = "//label[@id='wfActivityRuleForm:wfActivityRuleGrid:2:executionTime_label']";
		String ExecutionTimeSearch2 = "//input[@id='wfActivityRuleForm:wfActivityRuleGrid:2:executionTime_filter']";
		String ExecutionTimeSelect2 = "//tr[@id='wfActivityRuleForm:wfActivityRuleGrid:2:executionTime_1']//td[contains(text(),'NA')]";

		String Classification = "//div[@id='wfActivityRuleForm:wfActivityRuleGrid:0:classification']//div[@class='ui-selectonemenu-trigger ui-state-default ui-corner-right']";
		String ClassificationSearch = "//input[@id='wfActivityRuleForm:wfActivityRuleGrid:0:classification_filter']";
		String ClassificationSelect = "//td[normalize-space()='ICSR']";

		String Classification1 = "//div[@id='wfActivityRuleForm:wfActivityRuleGrid:1:classification']//div[@class='ui-selectonemenu-trigger ui-state-default ui-corner-right']";
		String ClassificationSearch1 = "//input[@id='wfActivityRuleForm:wfActivityRuleGrid:1:classification_filter']";
		String ClassificationSelect1 = "//tr[@id='wfActivityRuleForm:wfActivityRuleGrid:1:classification_1']";

		String Classification2 = "//div[@id='wfActivityRuleForm:wfActivityRuleGrid:2:classification']//div[@class='ui-selectonemenu-trigger ui-state-default ui-corner-right']";
		String ClassificationSearch2 = "//input[@id='wfActivityRuleForm:wfActivityRuleGrid:2:classification_filter']";
		String ClassificationSelect2 = "//tr[@id='wfActivityRuleForm:wfActivityRuleGrid:2:classification_5']//td[contains(text(),'Re-Evaluate')]";

		String Classification3 = "//div[@id='wfActivityRuleForm:wfActivityRuleGrid:3:classification']//div[@class='ui-selectonemenu-trigger ui-state-default ui-corner-right']";
		String ClassificationSearch3 = "//input[@id='wfActivityRuleForm:wfActivityRuleGrid:3:classification_filter']";
		String ClassificationSelect3 = "//tr[@id='wfActivityRuleForm:wfActivityRuleGrid:3:classification_1']//td[contains(text(),'ICSR')]";

		String WFPathTarget = "//div[@id='wfActivityRuleForm:wfActivityRuleGrid:0:activityCompletionPathId']//div[@class='ui-selectonemenu-trigger ui-state-default ui-corner-right']";
		String WFPathTargetSearch = "//input[@id='wfActivityRuleForm:wfActivityRuleGrid:0:activityCompletionPathId_filter']";
		String WFPathTargetSelect = "//td[normalize-space()='To QC Review']";

		String WFPathTarget1 = "//div[@id='wfActivityRuleForm:wfActivityRuleGrid:1:activityCompletionPathId']//div[@class='ui-selectonemenu-trigger ui-state-default ui-corner-right']";
		String WFPathTargetSearch1 = "//input[@id='wfActivityRuleForm:wfActivityRuleGrid:1:activityCompletionPathId_filter']";
		String WFPathTargetSelect1 = "//tr[@id='wfActivityRuleForm:wfActivityRuleGrid:1:activityCompletionPathId_1']//td[contains(text(),'To End')]";

		String WFPathTarget2 = "//div[@id='wfActivityRuleForm:wfActivityRuleGrid:2:activityCompletionPathId']//div[@class='ui-selectonemenu-trigger ui-state-default ui-corner-right']";
		String WFPathTargetSearch2 = "//input[@id='wfActivityRuleForm:wfActivityRuleGrid:2:activityCompletionPathId_filter']";
		String WFPathTargetSelect2 = "//tr[@id='wfActivityRuleForm:wfActivityRuleGrid:2:activityCompletionPathId_2']//td[contains(text(),'Back To Initial Review')]";

		String ActionRemarks = "//textarea[@id='wfActivityRuleForm:wfActivityRuleGrid:0:defRemarks']";
		String ActionRemarks1 = "//textarea[@id='wfActivityRuleForm:wfActivityRuleGrid:1:defRemarks']";
		String ActionRemarks2 = "//textarea[@id='wfActivityRuleForm:wfActivityRuleGrid:2:defRemarks']";
		String ActionRemarks3 = "//textarea[@id='wfActivityRuleForm:wfActivityRuleGrid:3:defRemarks']";

		String AutoAction = "//div[@id='wfActivityRuleForm:wfActivityRuleGrid:0:isWFActAutoComplete']//div[@class='ui-selectonemenu-trigger ui-state-default ui-corner-right']";
		String AutoActionSearch = "//input[@id='wfActivityRuleForm:wfActivityRuleGrid:0:isWFActAutoComplete_filter']";
		String AutoActionSelect = "//tr[@id='wfActivityRuleForm:wfActivityRuleGrid:0:isWFActAutoComplete_1']//td[contains(text(),'Yes')]";

		String AutoAction1 = "//div[@id='wfActivityRuleForm:wfActivityRuleGrid:1:isWFActAutoComplete']//div[@class='ui-selectonemenu-trigger ui-state-default ui-corner-right']";
		String AutoActionSearch1 = "//input[@id='wfActivityRuleForm:wfActivityRuleGrid:1:isWFActAutoComplete_filter']";
		String AutoActionSelect1 = "//tr[@id='wfActivityRuleForm:wfActivityRuleGrid:1:isWFActAutoComplete_1']//td[contains(text(),'Yes')]";

		String AutoAction2 = "//div[@id='wfActivityRuleForm:wfActivityRuleGrid:2:isWFActAutoComplete']//div[@class='ui-selectonemenu-trigger ui-state-default ui-corner-right']";
		String AutoActionSearch2 = "//input[@id='wfActivityRuleForm:wfActivityRuleGrid:2:isWFActAutoComplete_filter']";
		String AutoActionSelect2 = "//tr[@id='wfActivityRuleForm:wfActivityRuleGrid:2:isWFActAutoComplete_1']//td[contains(text(),'Yes')]";

		String AutoAction3 = "//div[@id='wfActivityRuleForm:wfActivityRuleGrid:3:isWFActAutoComplete']//div[@class='ui-selectonemenu-trigger ui-state-default ui-corner-right']";
		String AutoActionSearch3 = "//input[@id='wfActivityRuleForm:wfActivityRuleGrid:3:isWFActAutoComplete_filter']";
		String AutoActionSelect3 = "//tr[@id='wfActivityRuleForm:wfActivityRuleGrid:3:isWFActAutoComplete_1']//td[contains(text(),'Yes')]";

		String Itemtype = "//div[@id='wfActivityRuleForm:wfActivityRuleGrid:0:itemType']//div[@class='ui-selectonemenu-trigger ui-state-default ui-corner-right']";
		String ItemtypeSearch = "//input[@id='wfActivityRuleForm:wfActivityRuleGrid:0:itemType_filter']";
		String ItemtypeSelect = "//tr[@id='wfActivityRuleForm:wfActivityRuleGrid:0:itemType_1']//td[contains(text(),'Literature')]";

		String Itemtype1 = "//div[@id='wfActivityRuleForm:wfActivityRuleGrid:1:itemType']//div[@class='ui-selectonemenu-trigger ui-state-default ui-corner-right']";
		String ItemtypeSearch1 = "//input[@id='wfActivityRuleForm:wfActivityRuleGrid:1:itemType_filter']";
		String ItemtypeSelect1 = "//tr[@id='wfActivityRuleForm:wfActivityRuleGrid:1:itemType_1']//td[contains(text(),'Literature')]";

		String Itemtype2 = "//div[@id='wfActivityRuleForm:wfActivityRuleGrid:2:itemType']//div[@class='ui-selectonemenu-trigger ui-state-default ui-corner-right']";
		String ItemtypeSearch2 = "//input[@id='wfActivityRuleForm:wfActivityRuleGrid:2:itemType_filter']";
		String ItemtypeSelect2 = "//tr[@id='wfActivityRuleForm:wfActivityRuleGrid:2:itemType_1']//td[contains(text(),'Literature')]";

		String Itemtype3 = "//div[@id='wfActivityRuleForm:wfActivityRuleGrid:3:itemType']//div[@class='ui-selectonemenu-trigger ui-state-default ui-corner-right']";
		String ItemtypeSearch3 = "//input[@id='wfActivityRuleForm:wfActivityRuleGrid:3:itemType_filter']";
		String ItemtypeSelect3 = "//tr[@id='wfActivityRuleForm:wfActivityRuleGrid:3:itemType_1']//td[contains(text(),'Literature')]";

		String Save = "//div[@id='wfActivityRuleForm:wfActivityRuleGrid:0:j_idt115']//span[@class='ui-icon ui-icon-check ui-c']";
		String Save1 = "//div[@id='wfActivityRuleForm:wfActivityRuleGrid:1:j_idt115']//span[@class='ui-icon ui-icon-check ui-c']";
		String Save2 = "//div[@id='wfActivityRuleForm:wfActivityRuleGrid:2:j_idt115']//span[@class='ui-icon ui-icon-check ui-c']";
		String Save3 = "//div[@id='wfActivityRuleForm:wfActivityRuleGrid:3:j_idt115']//span[@class='ui-icon ui-icon-check ui-c']";

		String BUunitInput = testData.get(17).get("BUunitInput");
		String RuleTypeInput = testData.get(17).get("RuleTypeInput");
		String RuleTypeInput1 = testData.get(17).get("RuleTypeInput1");
		String ExecutionTimeInput = testData.get(17).get("ExecutionTimeInput");
		String ExecutionTimeInput1 = testData.get(17).get("ExecutionTimeInput1");
		String WFActivityInput = testData.get(17).get("WFActivityInput");
		String ClassificationInput = testData.get(17).get("ClassificationInput");
		String WFPathTargetInput = testData.get(17).get("WFPathTargetInput");
		String ActionRemarksInput = testData.get(17).get("ActionRemarksInput");
		String AutoActionInput = testData.get(17).get("AutoActionInput");
		String ItemtypeInput = testData.get(17).get("ItemtypeInput");

		String WFActivityInput1 = testData.get(17).get("WFActivityInput1");
		String WFPathTargetInput1 = testData.get(17).get("WFPathTargetInput1");
		String ActionRemarksInput1 = testData.get(17).get("ActionRemarksInput1");

		String ClassificationInput1 = testData.get(17).get("ClassificationInput1");
		String WFPathTargetInput2 = testData.get(17).get("WFPathTargetInput2");

		String ActionRemarksInput2 = testData.get(17).get("ActionRemarksInput2");
		String ActionRemarksInput3 = testData.get(17).get("ActionRemarksInput3");

		driver.findElement(By.xpath(Libary)).click();
		threadwait(1000);

		driver.findElement(By.xpath(WorkFlowRules)).click();
		threadwait(1000);

		driver.findElement(By.xpath(Create)).click();
		threadwait(1000);

//		driver.findElement(By.xpath(PencilIconOne)).click();
//		threadwait(3000);
//
//		driver.findElement(By.xpath(BUunit)).click();
//		threadwait(1000);
//
//		driver.findElement(By.xpath(BUunitSearch)).sendKeys(BUunitInput);
//		threadwait(1000);
//
//		driver.findElement(By.xpath(BUunitSelect)).click();
//		threadwait(3000);
//
//		driver.findElement(By.xpath(RuleType)).click();
//		threadwait(1000);
//
//		driver.findElement(By.xpath(RuleTypeSearch)).sendKeys(RuleTypeInput);
//		threadwait(1000);
//
//		driver.findElement(By.xpath(RuleTypeSelect)).click();
//		threadwait(3000);
//
//		driver.findElement(By.xpath(ExecutionTime)).click();
//		threadwait(1000);
//
//		driver.findElement(By.xpath(ExecutionTimeSearch)).sendKeys(ExecutionTimeInput);
//		threadwait(1000);
//
//		driver.findElement(By.xpath(ExecutionTimeSelect)).click();
//		threadwait(3000);
//
//		driver.findElement(By.xpath(WFActivity)).click();
//		threadwait(1000);
//
//		driver.findElement(By.xpath(WFActivitySearch)).sendKeys(WFActivityInput);
//		threadwait(1000);
//
//		driver.findElement(By.xpath(WFActivitySelect)).click();
//		threadwait(3000);
//
//		driver.findElement(By.xpath(Classification)).click();
//		threadwait(1000);
//
//		driver.findElement(By.xpath(ClassificationSearch)).sendKeys(ClassificationInput);
//		threadwait(1000);
//
//		driver.findElement(By.xpath(ClassificationSelect)).click();
//		threadwait(3000);
//
//		driver.findElement(By.xpath(WFPathTarget)).click();
//		threadwait(1000);
//
//		driver.findElement(By.xpath(WFPathTargetSearch)).sendKeys(WFPathTargetInput);
//		threadwait(1000);
//
//		driver.findElement(By.xpath(WFPathTargetSelect)).click();
//		threadwait(3000);
//
//		driver.findElement(By.xpath(ActionRemarks)).sendKeys(ActionRemarksInput);
//		threadwait(3000);
//
//		driver.findElement(By.xpath(AutoAction)).click();
//		threadwait(1000);
//
//		driver.findElement(By.xpath(AutoActionSearch)).sendKeys(AutoActionInput);
//		threadwait(1000);
//
//		driver.findElement(By.xpath(AutoActionSelect)).click();
//		threadwait(3000);
//
//		driver.findElement(By.xpath(Itemtype)).click();
//		threadwait(1000);
//
//		driver.findElement(By.xpath(ItemtypeSearch)).sendKeys(ItemtypeInput);
//		threadwait(1000);
//
//		driver.findElement(By.xpath(ItemtypeSelect)).click();
//		threadwait(3000);
//
//		driver.findElement(By.xpath(Save)).click();
//		threadwait(3000);
//
//		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//		FileUtils.copyFile(screenshotFile,
//				new File("D://All_Software//ScreenShots//Create_WorkFlow_Rules//Create_WorkFlow_Rules01_"
//						+ screenShotFileName + ".png"));
//		threadwait(1000);
//
//		driver.findElement(By.xpath(Create)).click();
//		threadwait(1000);
//
//		driver.findElement(By.xpath(PencilIconTwo)).click();
//		threadwait(3000);
//
//		driver.findElement(By.xpath(BUunit1)).click();
//		threadwait(1000);
//
//		driver.findElement(By.xpath(BUunitSearch1)).sendKeys(BUunitInput);
//		threadwait(1000);
//
//		driver.findElement(By.xpath(BUunitSelect1)).click();
//		threadwait(3000);
//
//		driver.findElement(By.xpath(RuleType1)).click();
//		threadwait(1000);
//
//		driver.findElement(By.xpath(RuleTypeSearch1)).sendKeys(RuleTypeInput);
//		threadwait(1000);
//
//		driver.findElement(By.xpath(RuleTypeSelect1)).click();
//		threadwait(3000);
//
//		driver.findElement(By.xpath(ExecutionTime1)).click();
//		threadwait(1000);
//
//		driver.findElement(By.xpath(ExecutionTimeSearch1)).sendKeys(ExecutionTimeInput);
//		threadwait(1000);
//
//		driver.findElement(By.xpath(ExecutionTimeSelect1)).click();
//		threadwait(3000);
//
//		driver.findElement(By.xpath(WFActivity1)).click();
//		threadwait(1000);
//
//		driver.findElement(By.xpath(WFActivitySearch1)).sendKeys(WFActivityInput1);
//		threadwait(1000);
//
//		driver.findElement(By.xpath(WFActivitySelect1)).click();
//		threadwait(3000);
//
//		driver.findElement(By.xpath(Classification1)).click();
//		threadwait(1000);
//
//		driver.findElement(By.xpath(ClassificationSearch1)).sendKeys(ClassificationInput);
//		threadwait(1000);
//
//		driver.findElement(By.xpath(ClassificationSelect1)).click();
//		threadwait(3000);
//
//		driver.findElement(By.xpath(WFPathTarget1)).click();
//		threadwait(1000);
//
//		driver.findElement(By.xpath(WFPathTargetSearch1)).sendKeys(WFPathTargetInput1);
//		threadwait(1000);
//
//		driver.findElement(By.xpath(WFPathTargetSelect1)).click();
//		threadwait(3000);
//
//		driver.findElement(By.xpath(ActionRemarks1)).sendKeys(ActionRemarksInput1);
//		threadwait(3000);
//
//		driver.findElement(By.xpath(AutoAction1)).click();
//		threadwait(1000);
//
//		driver.findElement(By.xpath(AutoActionSearch1)).sendKeys(AutoActionInput);
//		threadwait(1000);
//
//		driver.findElement(By.xpath(AutoActionSelect1)).click();
//		threadwait(3000);
//
//		driver.findElement(By.xpath(Itemtype1)).click();
//		threadwait(1000);
//
//		driver.findElement(By.xpath(ItemtypeSearch1)).sendKeys(ItemtypeInput);
//		threadwait(1000);
//
//		driver.findElement(By.xpath(ItemtypeSelect1)).click();
//		threadwait(3000);
//
//		driver.findElement(By.xpath(Save1)).click();
//		threadwait(3000);
//
//		File screenshotFile1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//		FileUtils.copyFile(screenshotFile1,
//				new File("D://All_Software//ScreenShots//Create_WorkFlow_Rules//Create_WorkFlow_Rules02_"
//						+ screenShotFileName + ".png"));
//
//		threadwait(1000);
//
//		driver.findElement(By.xpath(Create)).click();
//		threadwait(1000);
//
//		driver.findElement(By.xpath(PencilIconthree)).click();
//		threadwait(3000);
//
//		driver.findElement(By.xpath(BUunit2)).click();
//		threadwait(1000);
//
//		driver.findElement(By.xpath(BUunitSearch2)).sendKeys(BUunitInput);
//		threadwait(1000);
//
//		driver.findElement(By.xpath(BUunitSelect2)).click();
//		threadwait(3000);
//
//		driver.findElement(By.xpath(RuleType2)).click();
//		threadwait(1000);
//
//		driver.findElement(By.xpath(RuleTypeSearch2)).sendKeys(RuleTypeInput);
//		threadwait(1000);
//
//		driver.findElement(By.xpath(RuleTypeSelect2)).click();
//		threadwait(3000);
//
//		driver.findElement(By.xpath(ExecutionTime2)).click();
//		threadwait(1000);
//
//		driver.findElement(By.xpath(ExecutionTimeSearch2)).sendKeys(ExecutionTimeInput);
//		threadwait(1000);
//
//		driver.findElement(By.xpath(ExecutionTimeSelect2)).click();
//		threadwait(3000);
//
//		driver.findElement(By.xpath(WFActivity2)).click();
//		threadwait(1000);
//
//		driver.findElement(By.xpath(WFActivitySearch2)).sendKeys(WFActivityInput1);
//		threadwait(1000);
//
//		driver.findElement(By.xpath(WFActivitySelect2)).click();
//		threadwait(3000);
//
//		driver.findElement(By.xpath(Classification2)).click();
//		threadwait(1000);
//
//		driver.findElement(By.xpath(ClassificationSearch2)).sendKeys(ClassificationInput1);
//		threadwait(1000);
//
//		driver.findElement(By.xpath(ClassificationSelect2)).click();
//		threadwait(3000);
//
//		driver.findElement(By.xpath(WFPathTarget2)).click();
//		threadwait(1000);
//
//		driver.findElement(By.xpath(WFPathTargetSearch2)).sendKeys(WFPathTargetInput2);
//		threadwait(1000);
//
//		driver.findElement(By.xpath(WFPathTargetSelect2)).click();
//		threadwait(3000);
//
//		driver.findElement(By.xpath(ActionRemarks2)).sendKeys(ActionRemarksInput2);
//		threadwait(3000);
//
//		driver.findElement(By.xpath(AutoAction2)).click();
//		threadwait(1000);
//
//		driver.findElement(By.xpath(AutoActionSearch2)).sendKeys(AutoActionInput);
//		threadwait(1000);
//
//		driver.findElement(By.xpath(AutoActionSelect2)).click();
//		threadwait(3000);
//
//		driver.findElement(By.xpath(Itemtype2)).click();
//		threadwait(1000);
//
//		driver.findElement(By.xpath(ItemtypeSearch2)).sendKeys(ItemtypeInput);
//		threadwait(1000);
//
//		driver.findElement(By.xpath(ItemtypeSelect2)).click();
//		threadwait(3000);
//
//		driver.findElement(By.xpath(Save2)).click();
//		threadwait(3000);
//
//		File screenshotFile2 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//		FileUtils.copyFile(screenshotFile2,
//				new File("D://All_Software//ScreenShots//Create_WorkFlow_Rules//Create_WorkFlow_Rules03_"
//						+ screenShotFileName + ".png"));
//
//		threadwait(1000);

//		driver.findElement(By.xpath(Create)).click();
//		threadwait(1000);

		driver.findElement(By.xpath(PencilIconfour)).click();
		threadwait(3000);

		driver.findElement(By.xpath(BUunit3)).click();
		threadwait(1000);

		driver.findElement(By.xpath(BUunitSearch3)).sendKeys(BUunitInput);
		threadwait(1000);

		driver.findElement(By.xpath(BUunitSelect3)).click();
		threadwait(3000);

		driver.findElement(By.xpath(RuleType3)).click();
		threadwait(1000);

		driver.findElement(By.xpath(RuleTypeSearch3)).sendKeys(RuleTypeInput1);
		threadwait(1000);

		driver.findElement(By.xpath(RuleTypeSelect3)).click();
		threadwait(3000);

		driver.findElement(By.xpath(ExecutionTime3)).click();
		threadwait(1000);

		driver.findElement(By.xpath(ExecutionTimeSearch3)).sendKeys(ExecutionTimeInput1);
		threadwait(1000);

		driver.findElement(By.xpath(ExecutionTimeSelect3)).click();
		threadwait(3000);

		driver.findElement(By.xpath(WFActivity3)).click();
		threadwait(1000);

		driver.findElement(By.xpath(WFActivitySearch3)).sendKeys(WFActivityInput1);
		threadwait(1000);

		driver.findElement(By.xpath(WFActivitySelect3)).click();
		threadwait(3000);

		driver.findElement(By.xpath(Classification3)).click();
		threadwait(1000);

		driver.findElement(By.xpath(ClassificationSearch3)).sendKeys(ClassificationInput);
		threadwait(1000);

		driver.findElement(By.xpath(ClassificationSelect3)).click();
		threadwait(3000);

		driver.findElement(By.xpath(ActionRemarks3)).sendKeys(ActionRemarksInput3);
		threadwait(3000);

		driver.findElement(By.xpath(AutoAction3)).click();
		threadwait(1000);

		driver.findElement(By.xpath(AutoActionSearch3)).sendKeys(AutoActionInput);
		threadwait(1000);

		driver.findElement(By.xpath(AutoActionSelect3)).click();
		threadwait(3000);

		driver.findElement(By.xpath(Itemtype3)).click();
		threadwait(1000);

		driver.findElement(By.xpath(ItemtypeSearch3)).sendKeys(ItemtypeInput);
		threadwait(1000);

		driver.findElement(By.xpath(ItemtypeSelect3)).click();
		threadwait(3000);

		driver.findElement(By.xpath(Save3)).click();
		threadwait(3000);

	}

	public void createCitationSingle() throws IOException {

		logger.info("Creating a Single Citation & Vefiying created Citation Audit  ");

		Date currentdate = new Date();
		String screenShotFileName = timeStampFormat.format(currentdate);

		threadwait(5000);
		String testDataFile = "selectMultipleLiteratures.json";
		List<Map<String, String>> testData = TestDataFromJsonUtils.readJsonTestDataFromFile(testDataFile);

		String xpathLiLiterature = "//span[normalize-space()='Literature']";
		String xpathQueries = "//span[normalize-space()='Queries..']";
		String xpathCitation = "//span[normalize-space()='Create Citation']";
		String xpathBusinessUnitDropDown = "//span[@class='ui-icon ui-icon-triangle-1-s']";
		String xpathBUSearchBar = "//input[@aria-label='Filter Input']";
		String xpathSelectBuBox = "/html/body/div[21]/div[1]/div[1]/div[2]/span";
		String xpathsourceDocument = "//input[@id='createLiteItemMultiUnitsForm:supDocLiteratureItem_input']";
		String TitleTextField = "//textarea[@id='createLiteItemMultiUnitsForm:title']";
		String AuthorsTextField = "//textarea[@id='createLiteItemMultiUnitsForm:authorNames']";
		String UIDTextField = "//input[@id='createLiteItemMultiUnitsForm:pui']";
		String DOITextField = "//input[@id='createLiteItemMultiUnitsForm:doi']";
		String ISSNTextField = "//input[@id='createLiteItemMultiUnitsForm:issn']";
		String AccessionIdTextField = "//input[@id='createLiteItemMultiUnitsForm:accessionId']";
		String AbstractTextField = "//textarea[@id='createLiteItemMultiUnitsForm:absCitationContent']";
		String DrugTermsTextField = "//textarea[@id='createLiteItemMultiUnitsForm:drugTerms']";
		String xpathUploadButton = "//span[normalize-space()='Upload']";
		String xpathSavePublish = "//span[normalize-space()='Save & Publish']";
		String xpathYesButton = "//span[normalize-space()='Yes']";

		String xpathReports = "//span[normalize-space()='Reports']";
		String xpathAdminAudit = "//a[@href='/ReTrans/views/audit/filterPanel.xhtml']//span[contains(text(),'Admin')]";
		String xpathClearButton = "//span[@class='ui-button-icon-left ui-icon ui-c fa fa-eraser F20 gray']";
		String xpathBusinessTransactionId = "//input[@id='filterPanelForm:j_idt34']";
		String xpathSearchauditButton = "//span[normalize-space()='Search']";
		String xpathSessionId = "//a[@id='auditlistListForm:auditlistGrid:0:j_idt38']";
		String xpathBackButton = "//*[@id=\"auditFieldLogForm:j_idt34\"]";
		String xpathGenerateAll = "//span[normalize-space()='Generate Report(All)']";

		String BusinessUnit = testData.get(10).get("BusinessUnit");
		String Title = testData.get(10).get("Title");
		String Authors = testData.get(10).get("Authors");
		String UID = testData.get(10).get("UID");
		String DOI = testData.get(10).get("DOI");
		String ISSN = testData.get(10).get("ISSN");
		String AccessionId = testData.get(10).get("AccessionId");
		String Abstract = testData.get(10).get("Abstract");
		String DrugTerms = testData.get(10).get("DrugTerms");
		String CsvFilePath = testData.get(10).get("CsvFilePath");

		driver.findElement(By.xpath(xpathLiLiterature)).click();
		logger.info("Clicking on Literature Menu");

		driver.findElement(By.xpath(xpathQueries)).click();
		logger.info("Clicking on Query ");

		driver.findElement(By.xpath(xpathCitation)).click();
		logger.info("Clicking on Create Citation");
		threadwait(3000);

		driver.findElement(By.xpath(xpathBusinessUnitDropDown)).click();
		driver.findElement(By.xpath(xpathBUSearchBar)).sendKeys(BusinessUnit);
		driver.findElement(By.xpath(xpathSelectBuBox)).click();
		logger.info("Selecting the Business Unit");
		threadwait(2000);

		driver.findElement(By.xpath(TitleTextField)).sendKeys(Title);
		logger.info("Entering the Ttile");
		threadwait(2000);

		driver.findElement(By.xpath(AuthorsTextField)).sendKeys(Authors);
		logger.info("Entering the Authors");
		threadwait(2000);

		driver.findElement(By.xpath(UIDTextField)).sendKeys(UID);
		logger.info("Entering the UID");
		threadwait(2000);

		driver.findElement(By.xpath(DOITextField)).sendKeys(DOI);
		logger.info("Entering the DOI");
		threadwait(2000);

		driver.findElement(By.xpath(ISSNTextField)).sendKeys(ISSN);
		logger.info("Entering the ISSN");
		threadwait(2000);

		driver.findElement(By.xpath(AccessionIdTextField)).sendKeys(AccessionId);
		logger.info("Entering the Accession ID");
		threadwait(2000);

		driver.findElement(By.xpath(AbstractTextField)).sendKeys(Abstract);
		logger.info("Entering the Abstract");
		threadwait(2000);

		driver.findElement(By.xpath(DrugTermsTextField)).sendKeys(DrugTerms);
		logger.info("Entering the Drug Terms");
		threadwait(2000);

		driver.findElement(By.xpath(xpathsourceDocument)).sendKeys(CsvFilePath);
		logger.info("Selecting the Source Document");
		threadwait(5000);

		driver.findElement(By.xpath(xpathUploadButton)).click();
		threadwait(5000);

		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile,
				new File("D://All_Software//ScreenShots//Create_Citation_Single//CreateCitationSingle01_"
						+ screenShotFileName + ".png"));
		logger.info("Screen Shot afte all the Deatils are entered");

		driver.findElement(By.xpath(xpathSavePublish)).click();
		logger.info("Clicking On Save & Publish Button");
		threadwait(2000);

		File screenshotFile1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile1,
				new File("D://All_Software//ScreenShots//Create_Citation_Single//CreateCitationSingle02_"
						+ screenShotFileName + ".png"));

		threadwait(2000);

		driver.findElement(By.xpath(xpathYesButton)).click();
		logger.info("Clicking on Yes Button");
		threadwait(10000);

		driver.findElement(By.xpath(xpathReports)).click();
		driver.findElement(By.xpath(xpathAdminAudit)).click();
		logger.info("Navigating to Audit Report Filter");

		threadwait(2000);

		driver.findElement(By.xpath(xpathClearButton)).click();
		logger.info("Clearing Audit Report Filter");
		threadwait(10000);

		driver.findElement(By.xpath(xpathBusinessTransactionId)).sendKeys(UID);
		logger.info("Entering the Title For Audit Report");
		threadwait(2000);

		File screenshotFile2 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile2,
				new File("D://All_Software//ScreenShots//Create_Citation_Single//CreateCitationSingle03_"
						+ screenShotFileName + ".png"));

		logger.info("ScreenShot taken once Before Applying the Filter ");

		driver.findElement(By.xpath(xpathSearchauditButton)).click();
		logger.info("Clickling Search button For Audit Report");
		threadwait(5000);

		File screenshotFile3 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile3,
				new File("D://All_Software//ScreenShots//Create_Citation_Single//CreateCitationSingle04_"
						+ screenShotFileName + ".png"));

		logger.info("ScreenShot after Applying the Filter ");

		driver.findElement(By.xpath(xpathSessionId)).click();
		logger.info("Navigating to Detailed Audit Report Filter");
		threadwait(2000);

		File screenshotFile4 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile4,
				new File("D://All_Software//ScreenShots//Create_Citation_Single//CreateCitationSingle05_"
						+ screenShotFileName + ".png"));

		logger.info("ScreenShot of Detailed Audit Report Filter ");

		driver.findElement(By.xpath(xpathBackButton)).click();
		logger.info("Navigating to Audit Report Listing Page");

		driver.findElement(By.xpath(xpathGenerateAll)).click();
		threadwait(5000);
		logger.info("Generating The Audit Report of Create Single Citation");

	}

	public void ReadExcel() throws IOException {

		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.getsheet("sheet1");
		int rowcount = sheet.getLastRowNum();// 10

		for (int i = 1; i <= rowcount; i++) {

		}
	}
}
