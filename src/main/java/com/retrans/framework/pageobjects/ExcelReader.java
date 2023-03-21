package com.retrans.framework.pageobjects;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelReader {
	
	public String doiValue="DOI1317";
	
		
	
	
	
	public void ReadExcel() throws IOException {

		FileInputStream fis = new FileInputStream("C:\\Users\\ADMIN\\Desktop\\Automated Testing\\Testing_Date.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.getsheet("sheet1");
		int rowcount = sheet.getLastRowNum();//10
		int colcount = sheet.getRow(1);
		for (int i = 1; i <= rowcount; i++)
		{
			int celldata = sheet.getRow(i);

			//String smiple = sheet.getcell(i).toString();
			
		}
	}

}
