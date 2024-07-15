package toReadDataFromExternalSource;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.collections4.bag.SynchronizedSortedBag;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadTheDataFromWorkbook {
   public static void main(String[] args) throws EncryptedDocumentException, IOException {
	FileInputStream file = new FileInputStream("./src/test/resource/Workbook.xlsx");
	Workbook workbook = WorkbookFactory.create(file);
	Sheet sheet = workbook.getSheet("Ratings");
	int lastRowNum = sheet.getLastRowNum();
	System.out.println("No.of Rows:"+lastRowNum);
	short lastCellNum = sheet.getRow(0).getLastCellNum();
	System.out.println("No.of cell:"+lastCellNum);
	
	for(int i=1;i<=lastRowNum;i++) {
		for(int j=0;j<lastCellNum;j++) {
			Row row = sheet.getRow(i);
			Cell cell=row.getCell(j);
			DataFormatter dft=new DataFormatter();
			String value = dft.formatCellValue(cell);
			System.out.println(value);

			
		
			}
		}
	}
	
	
	
	
}

