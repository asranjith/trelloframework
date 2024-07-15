package toReadDataFromExternalSource;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;



public class DataProvider {
	@Test(dataProvider="CredentialsSupplier")
	public void dataPrint(String name,String skills,int rating) {
		System.out.println(name+"---"+skills+"---"+rating);
	}
  @org.testng.annotations.DataProvider(name="CredentialsSupplier")
  public Object[][] datasupplier() throws EncryptedDocumentException, IOException {
	  FileInputStream file = new FileInputStream("./src/test/resource/Workbook.xlsx");
	  Workbook workbook = WorkbookFactory.create(file);
	  Sheet sheet = workbook.getSheet("Rating");
//	  Row row = sheet.getRow(1);
//	  Cell cell = row.getCell(0);
	  
	  int rowcount = sheet.getLastRowNum();
	  short cellcount = sheet.getRow(0).getLastCellNum();
	  
	  Object[][] data= new Object[rowcount][cellcount];
	  for(int i=0;i<rowcount;i++) {
		   Row row = sheet.getRow(i+1);
		  for(int j=0;j<cellcount;j++) {
			   Cell cell = row.getCell(j); 
			   CellType celltype = cell.getCellType();
			   switch(celltype) {
			   case STRING:
				   data[i][j]= cell.getStringCellValue();
				   break;
			   case NUMERIC:
				   data[i][j]=Integer.toString((int)cell.getNumericCellValue());
				   break;
			   case BOOLEAN:
				   data[i][j]=cell.getBooleanCellValue();
				   break;
			   }
			   
		  }
	  }
	  return data;  
  }
  
}
