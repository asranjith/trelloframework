package com.trello.qsp.genericutility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class ExcelUtility {
    public String readTheStringDataFromWorkBook(String sheetname,int rownum,int cellnum) throws EncryptedDocumentException, IOException {
    	FileInputStream fis = new FileInputStream("./src/test/resource/TrelloWorkbook.xlsx");
    	Workbook workbook = WorkbookFactory.create(fis);
    	Sheet sheet = workbook.getSheet(sheetname);
    	String cellvalue = sheet.getRow(rownum).getCell(cellnum).getStringCellValue();
       
        return cellvalue;
    }
    public double readTheNumericDataFromWorkBook(String sheetname,int rownum,int cellnum) throws EncryptedDocumentException, IOException {
    	FileInputStream fis = new FileInputStream("./src/test/resource/TrelloWorkbook.xlsx");
    	Workbook workbook = WorkbookFactory.create(fis);
    	Sheet sheet = workbook.getSheet(sheetname);
    	double cellvalue = sheet.getRow(rownum).getCell(cellnum).getNumericCellValue();

        return cellvalue;
    }
}
