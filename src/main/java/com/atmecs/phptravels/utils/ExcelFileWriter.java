package com.atmecs.phptravels.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.AfterSuite;

import com.atmecs.phptravels.testbase.ConstantFilePaths;

public class ExcelFileWriter {
	static int i=1;
	static XSSFWorkbook workbook;
	static LogReports reports=new LogReports();

	public static void test(String data) throws Exception 
	{
		File file= new File(ConstantFilePaths.USERTESTDATA_FILE);
		
		FileInputStream inputStreams=new FileInputStream(file);
		
		 workbook=new XSSFWorkbook(inputStreams);
		XSSFSheet sheet=workbook.getSheetAt(0);
		
		sheet.createRow(i).createCell(3).setCellValue(data);
		FileOutputStream write=new FileOutputStream(file);
		
		workbook.write(write);
		reports.info("writing date and time to excel file");
		i++;

	}
	@AfterSuite
	public void workBookClose() throws Exception
	{
		workbook.close();
	}

}
