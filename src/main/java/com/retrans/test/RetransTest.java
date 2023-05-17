package com.retrans.test;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.retrans.framework.pageobjects.CreateActionsPage;
//import com.retrans.framework.pageobjects.CreatingPubmedQuery;
//import com.retrans.framework.pageobjects.CreateNotesPage;
import com.retrans.framework.pageobjects.EditLiteraturesPage;
//import com.retrans.framework.pageobjects.ftaOrderpage;
import com.retrans.framework.pageobjects.FtaOrderpage;
import com.retrans.framework.utils.TestDataFromJsonUtils;

public class RetransTest extends TestBase {

	private static final String Driver = null;
	private static Logger logger = LogManager.getLogger(RetransTest.class);

	private String testDataFile = "selectMultipleLiteratures.json";
	private List<Map<String, String>> testData = TestDataFromJsonUtils.readJsonTestDataFromFile(testDataFile);

 @Test
	public void completeReTrans() throws IOException {
		createPubMedQuery();
		createEmbaseQuery();
		bulkClaimReset();
		createUser();
		createRole();
		createMedicalTerms();
		createBulkMedicalTerms();
		createAppBucketTerms();
		createBulkAppBucketTerms();
		inactiveUser();
		unlockActiveUser();
		createCitationSingle();
		createQueryBlank();
		
	}

//	@Test
	public void createBusinessUnit() throws IOException {
		listLiteItemsPage.createBusinessUnit();
		
		

	}

//	@Test
	public void createQueryBlank() throws IOException {
		listLiteItemsPage.createQueryBlank();
	}

//	@Test
	public void createPubMedQuery() throws IOException {
		listLiteItemsPage.createPubMedQuery();

	}

//	@Test
	public void createCitationSingle() throws IOException {
		listLiteItemsPage.createCitationSingle();
	}

//	@Test
	public void createEmbaseQuery() throws IOException {
		listLiteItemsPage.createEmbaseQuery();
	}

//	@Test
	public void bulkClaimReset() throws IOException {
		listLiteItemsPage.bulkClaimReset();
	}

//	@Test
	public void createUser() throws IOException {
		listLiteItemsPage.createUser();
	}

//	@Test
	public void createRole() throws IOException {
		listLiteItemsPage.createRole();
	}

//	@Test
	public void createMedicalTerms() throws IOException {
		listLiteItemsPage.createMedicalTerms();
	}

//	@Test
	public void createAppBucketTerms() throws IOException {
		listLiteItemsPage.createAppBucketTerms();

	}

//	@Test
	public void inactiveUser() throws IOException {
		listLiteItemsPage.inactiveUser();
	}

//	@Test
	public void unlockActiveUser() throws IOException {
		listLiteItemsPage.unlockActiveUser();
	}

//@Test
	public void createBulkMedicalTerms() throws IOException {
		listLiteItemsPage.createBulkMedicalTerms();

	}

// @Test
	public void createBulkAppBucketTerms() throws IOException {
		listLiteItemsPage.createBulkAppBucketTerms();

	}

//	@Test
//	public void navigatingToQueryCreatePage() {
//		listLiteItemsPage.navigatingToQueryCreatePage();
//		dropdownFiledInCreateQuery();

//	}

//	 @Test
	public void claimLiteraturebyzaid() {

		listLiteItemsPage.navigateToListLitItemsPage();
		listLiteItemsPage.clearFilter();
		threadwait(5000);

	}

//	 @Test

	public void createQuery() {
		listLiteItemsPage.createQuery();

	}

//	@Test
	public void completeActivity() {

		filterSearchType();

		filterLiteraturesByActivity();

		filterLiteraturesByClassification();

		filterLiteraturesByBusinessUnit();

		filterLiteraturesByClaims();

		claimIconButton();

		createNoteButton();

		textTitleField();

		NotesField();

		SupportDoc();

		uploadButton();

		SaveButtonNotes();

		addAction();

		filterByClassificationIcon();

		addFta();

		CompleteButton();

		filterByNextActivity();

		CompleteAcRemarks();

		checkbox();

		CompleteActivityButton();

	}

	// @Test
	public void caseCreationTab() {

		listLiteItemsPage.caseCreationTab();
		threadwait(5000);

	}

	// @Test
	public void caseAdd() {

		listLiteItemsPage.caseAdd();
		threadwait(5000);

	}

	// @Test
	public void caseApply() {

		listLiteItemsPage.caseApply();
		threadwait(5000);
	}

	// @Test
	public void checkbox() {
		logger.info(" Selecting Disagree Chekbox ");

		listLiteItemsPage.checkbox();
		threadwait(5000);

	}

	// @Test
	public void editLiteratureItemAddAction() {
		threadwait(5000);
		String fromDate = "11";
		String fromMonth = "Oct";
		String fromYear = "2022";

		String toDate = "13";
		String toMonth = "Nov";
		String toYear = "2022";

		String actionsRemarks = "";
		String suppDoc = "";
		String uploadBut = "";
		String saveBut = "";
		String caseTab = "";
		String caseAdd = "";
		String caseaply = "";
		String caseSub = "";
		String casecret = "";

		String toEmail = "";
		String toSubj = "";
		String toBody = "";
		String toRemark = "";
		String savebt = "";
		String addAt = "";
		String aatitle = "";
		String ccdesp = "";
		String upDoc = "";
		String uplbt = "";
		String Savbt = "";
		String sendky = "";

		listLiteItemsPage.navigateToListLitItemsPage();
		EditLiteraturesPage editLitPage = listLiteItemsPage.editLiterature("2022_W37_9");
		threadwait(3000);
		editLitPage.createAction("Internal review", "Open", fromDate, fromMonth, fromYear, toDate, toMonth, toYear,
				actionsRemarks, suppDoc, uploadBut, saveBut, caseTab, caseAdd, caseaply, caseSub, casecret, toEmail,
				toSubj, toBody, toRemark, savebt, addAt, aatitle, ccdesp, upDoc, uplbt, Savbt, sendky);
		threadwait(3000);

	}

	// @Test
	public void addAction() {
		threadwait(5000);
		String fromDate = "11";
		String fromMonth = "Jan";
		String fromYear = "2023";

		String toDate = "30";
		String toMonth = "Jan";
		String toYear = "2023";
		String actionsRemarks = "Testing By zaid Auto ";
		String suppDoc = "";
		String uploadBut = "";
		String saveBut = "";
		String caseTab = "null";
		String caseAdd = "null";
		String caseaply = "null";
		String caseSub = "null";
		String casecret = "null";

		String toEmail = "null";
		String toSubj = "null";
		String toBody = "null";
		String toRemark = "null";
		String savebt = "null";
		String addAt = "null";
		String aatitle = "null";
		String ccdesp = "null";
		String upDoc = "null";
		String uplbt = "null";
		String Savbt = "null";

		String sendky = "null";

		createAction("Order Immediately", "Open", fromDate, fromMonth, fromYear, toDate, toMonth, toYear,
				actionsRemarks, suppDoc, uploadBut, saveBut, caseTab, caseAdd, caseaply, caseSub, casecret, "Open",
				toEmail, toSubj, toBody, toRemark, savebt, addAt, aatitle, ccdesp, upDoc, uplbt, Savbt, sendky);
		threadwait(5000);
	}

	// @Test
	public void addFta() {
		threadwait(5000);
		String fullTextTabXpath = "//a[normalize-space()='Full Text']";
		String OrderClick = "//span[@class='ui-button-text ui-c'][normalize-space()='Order']";

		ftacycle(fullTextTabXpath, OrderClick);
		FtaOrderpage orderFta = FtaOrderpage(Driver);

	}

	public void ftacycle(String fullTextTabXpath, String orderClick) {
		driver.findElement(By.xpath(fullTextTabXpath)).click();
		threadwait(5000);
		driver.findElement(By.xpath(orderClick)).click();
		FtaOrderpage orderFta = FtaOrderpage(Driver);

		orderFta.ftacycle(fullTextTabXpath, orderClick);

	}

	private FtaOrderpage FtaOrderpage(String driver2) {

		return null;
	}

	public void

			createAction(String title, String status, String fromDate, String fromMonth, String fromYear, String toDate,
					String toMonth, String toYear, String actionsRemarks, String suppDoc, String uploadBut,
					String saveBut, String caseTab, String caseAdd, String caseaply, String caseSub, String casecret,
					String emstatus, String toEmail, String toSubj, String toBody, String toRemark, String savebt,
					String addAt, String aatitle, String ccdesp, String upDoc, String uplbt, String Savbt,
					String sendky) {
		driver.findElement(By.xpath("//a[normalize-space()='Actions']")).click();
		threadwait(5000);
		driver.findElement(By.xpath("//button[@id='litPanel:actionListForm:createAction']")).click();
		CreateActionsPage actionsPage = new CreateActionsPage(driver);
		actionsPage.createAction(title, status, fromDate, fromMonth, fromYear, toDate, toMonth, toYear, actionsRemarks,
				suppDoc, uploadBut, saveBut, caseTab, caseAdd, caseaply, caseSub, casecret, toEmail, toSubj, toBody,
				toRemark, savebt, addAt, aatitle, ccdesp, upDoc, uplbt, Savbt, sendky);

	}

	// @Test
	public void editLiteratureItemByTitleAddAction() {
		logger.info("Navigating to Actions window & Creating Actions");
		threadwait(5000);
		String fromDate = "28";
		String fromMonth = "Oct";
		String fromYear = "2022";

		String toDate = "13";
		String toMonth = "Nov";
		String toYear = "2022";
		String litTitle = "Imepitoin is well tolerated";
		String actionsRemarks = "";
		String suppDoc = "";
		String uploadBut = "";
		String saveBut = "";
		String caseTab = "";
		String caseAdd = "";
		String caseaply = "";
		String caseSub = "";
		String casecret = "";
		String toEmail = "";
		String toSubj = "";
		String toBody = "";
		String toRemark = "";
		String savebt = "";
		String addAt = "";
		String aatitle = "";
		String ccdesp = "";
		String upDoc = "";
		String uplbt = "";
		String Savbt = "";
		String sendky = "";

		listLiteItemsPage.navigateToListLitItemsPage();
		EditLiteraturesPage editLitPage = listLiteItemsPage.editLiteratureByTitle(litTitle);
		threadwait(3000);
		editLitPage.createAction("Internal review", "Open", fromDate, fromMonth, fromYear, toDate, toMonth, toYear,
				actionsRemarks, suppDoc, uploadBut, saveBut, caseTab, caseAdd, caseaply, caseSub, casecret, toEmail,
				toSubj, toBody, toRemark, savebt, addAt, aatitle, ccdesp, upDoc, uplbt, Savbt, sendky);
		threadwait(3000);
	}

	// @Test
	public void editLiteratureItemAddNotes() {

		listLiteItemsPage.navigateToListLitItemsPage();
		EditLiteraturesPage editLitPage = listLiteItemsPage.editLiterature("2022_W47_1");
		threadwait(3000);
		editLitPage.createNotes("Nodes Title Nov 22 2022", "Notes Description Nov 22 2022 Description", "");
		threadwait(3000);
	}

	// @Test
	public void editLiteratureItemAddNotesWithAttachment() {

		listLiteItemsPage.navigateToListLitItemsPage();
		String attachmentFilePath = "C:\\Users\\ADMIN\\Desktop\\Automated Testing/Auto_Test.pdf";
		EditLiteraturesPage editLitPage = listLiteItemsPage.editLiterature(" 2022_W48_8");
		threadwait(3000);
		editLitPage.createNotes("Creating Note By zaid", "Creating Note By zaid", attachmentFilePath);
		threadwait(3000);
	}

	// @Test
	public void editLiteratureItem() {
		listLiteItemsPage.navigateToListLitItemsPage();
		listLiteItemsPage.editLiterature("2022_W37_9");
		threadwait(3000);
	}

	// @Test
	public void selectMultipleLiteratures() {

		String literature1 = testData.get(0).get("literature1");
		String literature2 = testData.get(0).get("literature2");
		String literature3 = testData.get(0).get("literature3");
		String literature4 = testData.get(0).get("literature4");

		System.out.println("literature1 :" + literature1);
		System.out.println("literature2 :" + literature2);

		listLiteItemsPage.navigateToListLitItemsPage();
		listLiteItemsPage.selectLiteratureByCheckBox(literature1);
		listLiteItemsPage.selectLiteratureByCheckBox(literature2);
		listLiteItemsPage.selectLiteratureByCheckBox(literature3);
		listLiteItemsPage.selectLiteratureByCheckBox(literature4);

		threadwait(3000);
	}

	// @Test
	public void viewLiteratureItemAndVerifyAuthor() {
		listLiteItemsPage.navigateToListLitItemsPage();
		listLiteItemsPage.clickLiteratureByName("2022_W37_9");
		threadwait(5000);
		AssertJUnit.assertTrue(driver.findElement(By.xpath("//input[contains(@value,'Hussar')]")).isDisplayed());
		listLiteItemsPage.closeLiteratureDialog();
	}

//	 @Test
	public void claimLiterature() {

		String filterBySearchType = testData.get(1).get("filterBySearchType");
		String filterByClassificationIcon = testData.get(1).get("filterByClassificationIcon");

		listLiteItemsPage.navigateToListLitItemsPage();
		listLiteItemsPage.selectLiteratureByCheckBox("2022_W37_9");
		listLiteItemsPage.claimSelectedLiteratureItems();
		threadwait(5000);
		listLiteItemsPage.filterBySearchType(filterBySearchType);
		listLiteItemsPage.filterByClassificationIcon(filterByClassificationIcon);
	}

	// @Test
	public void filterSearchType() {
		logger.info("selecting SearchType");
		listLiteItemsPage.filterBySearchType("Embase");
		threadwait(5000);

	}

	// @Test
	public void dropdownFiledInCreateQuery() {
		logger.info("selecting Business Unit");

		String dropdownFiledInCreateQuery = testData.get(0).get("UniForEmbase");
		logger.info("Value from Json" + dropdownFiledInCreateQuery);

		listLiteItemsPage.dropdownFiledInCreateQuery(dropdownFiledInCreateQuery);
		threadwait(5000);

	}

	// @Test
	public void filterLiteraturesByActivity() {
		logger.info("selecting Activity");
		listLiteItemsPage.filterByActivity("Initial Review");
		threadwait(5000);

	}

	// @Test
	public void filterLiteraturesByClassification() {
		logger.info("selecting Classification");

		listLiteItemsPage.filterByClassification("ICSR");
		threadwait(5000);

	}

	// @Test
	public void filterLiteraturesByBusinessUnit() {
		logger.info("selecting Business Uint ");

		listLiteItemsPage.filterByBusinessUnit1("Dev_Test_Unit");
		threadwait(5000);

	}

	// @Test
	public void filterLiteraturesByClaims() {
		logger.info("selecting Filter By Claim");

		listLiteItemsPage.filterByClaims("Claimed by me");
		threadwait(5000);

	}

	// @Test
	public void selectClaimButton() {
		logger.info("selecting Claim Button");

		listLiteItemsPage.claimSelectedLiteratureItems();
		threadwait(5000);

	}

	// @Test
	public void claimIconButton() {
		logger.info("Click on claim Icon");
		listLiteItemsPage.claimIconButton();
		threadwait(5000);

	}

	// @Test
	public void createNoteButton() {
		logger.info("Click on Notes Create");
		listLiteItemsPage.createNoteButton();
		threadwait(5000);

	}

	// @Test
	public void CaseSubmissonTab() {

		listLiteItemsPage.CaseSubmissonTab();
		threadwait(5000);

	}

	// @Test
	public void CaseCreateButton() {

		listLiteItemsPage.CaseCreateButton();
		threadwait(5000);

	}

	// @Test
	public void textTitleField() {
		logger.info("Adding the Title in Notes");
		listLiteItemsPage.textTitleField();
		threadwait(5000);
	}

	// @Test
	public void textToEmail() {

		listLiteItemsPage.textToEmail();
		threadwait(5000);
	}

	// @Test
	public void CompleteAcRemarks() {
		logger.info("Adding Remarks");

		listLiteItemsPage.CompleteAcRemarks();
		threadwait(5000);

	}

	// @Test
	public void textToSubject() {

		listLiteItemsPage.textToSubject();
		threadwait(3000);
	}

	// @Test
	public void textToRemarks() {

		listLiteItemsPage.textToRemarks();
		threadwait(3000);

	}

	// @Test
	public void textToBody() {

		listLiteItemsPage.textToBody();
		threadwait(3000);
	}

	// @Test
	public void NotesField() {
		logger.info("Adding the Notes in Notes");
		listLiteItemsPage.NotesField();
		threadwait(3000);

	}

//	@Test
	public void SupportDoc() {
		logger.info("Uploading support Document in Notes");
		listLiteItemsPage.SupportDoc();
		threadwait(3000);

	}

	// @Test
	public void uploadButton() {
		logger.info("Clicking On Uploading Button in Notes ");
		listLiteItemsPage.uploadButton();
		threadwait(3000);

	}

	// @Test
	public void SaveButtonNotes() {
		logger.info("Clicking On Save Button in Notes");
		listLiteItemsPage.SaveButtonNotes();
		threadwait(3000);

	}

	// @Test
	public void AddAttachment() {
		listLiteItemsPage.AddAttachment();
		threadwait(3000);

	}

	// @Test
	public void EmailSaveButton() {
		listLiteItemsPage.EmailSaveButton();
		threadwait(3000);

	}

	// @Test
	public void CompleteActivityButton() {
		logger.info("Clicking On Complete Activity Button");
		listLiteItemsPage.CompleteActivityButton();
		threadwait(3000);
	}

	// @Test
	public void EmailSentButton() {
		listLiteItemsPage.EmailSentButton();
		threadwait(3000);

	}

	// @Test
	public void CompleteButton() {
		logger.info("Clicking On Complete Button");
		listLiteItemsPage.CompleteButton();
		threadwait(3000);

	}

	// @Test
	public void ActionTab() {
		listLiteItemsPage.ActionTab();
		threadwait(3000);

	}

//	@Test 
	public void PlannedStartDate() {
		listLiteItemsPage.PlannedStartDate();
		threadwait(3000);

	}

	// @Test
	public void PlannedStartDatePick() {
		listLiteItemsPage.PlannedStartDatePick();
		threadwait(3000);
	}

	// @Test
	public void CreateActionButton() {
		listLiteItemsPage.CreateActionButton();
		threadwait(3000);

	}

	// @Test
	public void filterByTitleActions() {

		listLiteItemsPage.filterByTitleActions("Medical Assessment");
		threadwait(3000);

	}

	// @Test
	public void filterByClassificationIcon() {
		logger.info("selecting Classification");

		listLiteItemsPage.filterByClassificationIcon("Awaiting FTA");
		threadwait(3000);

	}

	// @Test
	public void filterByNextActivity() {
		logger.info("selecting Next Activity");

		listLiteItemsPage.filterByNextActivity("To End");
		threadwait(3000);

	}

	// @Test
	public void filterByEmailStatus() {

		listLiteItemsPage.filterByEmailStatus("Open");
		threadwait(3000);
	}

	// @Test
	public void filterByStatusActions() {

		listLiteItemsPage.filterByStatusActions("Closed");
		threadwait(3000);

	}

	// @Test
	public void selectUnClaimButton() {

		listLiteItemsPage.unClaimSelectedLiteratureItems();
		threadwait(3000);

	}

	// @Test
	public void filterLiteratures() {
		listLiteItemsPage.navigateToListLitItemsPage();
//		listLiteItemsPage.filterByActivity("Triage");
//		threadwait(3000);
//		listLiteItemsPage.clearFilter();
//		threadwait(5000);

		listLiteItemsPage.filterByClassification("Duplicate");
		threadwait(3000);
		listLiteItemsPage.clearFilter();
		threadwait(5000);

		listLiteItemsPage.filterByBusinessUnit1("Testing-BU");
		threadwait(3000);
		listLiteItemsPage.clearFilter();
		threadwait(6000);

		listLiteItemsPage.filterByClaims("Unclaimed");
		threadwait(3000);
		listLiteItemsPage.clearFilter();
		threadwait(5000);

		listLiteItemsPage.filterByClaims("Claimed by me");
		threadwait(3000);
		listLiteItemsPage.clearFilter();
		threadwait(5000);

	}

	// @Test
	public void createSingleCitation() {
		threadwait(5000);
		String businessUnit = "Testing-BU";
		String title = "Test tuesday single citation";
		String authors = "mohammed";
		String uid = "28017186";
		String doi = "10.1016/j.jsat.2016.11.005";
		String issn = "13789DJH";
		String accession_id = "By zaid 01";
		String abstractContents = "By zaid 01";
		String drugTerms = "By zaid 01";

		listLiteItemsPage.navigateToListLitItemsPage();
		listLiteItemsPage.addCitationDetails(businessUnit, title, authors, uid, doi, issn, accession_id,
				abstractContents, drugTerms);
		threadwait(2000);

		// listLiteItemsPage.selectLiteratureByCheckBox("2022_W46_9");

		// selectClaimButton();

		// ActionTab();

		// CreateActionButton();

		// filterByTitleActions();

		// PlannedStartDate();

		// PlannedStartDatePick();

		// filterByStatusActions();

		// CreateNotesPage notesPage = new CreateNotesPage(driver);
		// notesPage.addNotes(title, description, attachmentFilePath);
		// threadwait(3000);

//         listLiteItemsPage.selectLiteratureByCheckBox("2022_W39_42");

//         selectUnClaimButton();

//          listLiteItemsPage.clearFilter();
//          threadwait(3000);

	}

}
