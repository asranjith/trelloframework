package toReadDataFromExternalSource;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ToReadDataInRowsAndColumns {
     public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream file = new FileInputStream("./src/test/resource/TrelloWorkbook.xlsx");
		Workbook workbook = WorkbookFactory.create(file);
		Sheet sheet = workbook.getSheet("TrelloData");
		int NoOfrow = sheet.getLastRowNum();
		 Row lastrow = sheet.getRow(NoOfrow);
		// sheet.getRow(NoOfrow).getCell(NoOfrow).getStringCellValue();
		int noofcolumn = lastrow.getLastCellNum();
		for(int i=1;i<=NoOfrow;i++) {
			for(int j=0;j<noofcolumn;j++) {
				System.out.println(sheet.getRow(i).getCell(j).getStringCellValue());
			}
		}
	}
}
