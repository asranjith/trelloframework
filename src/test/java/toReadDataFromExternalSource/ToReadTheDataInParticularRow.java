package toReadDataFromExternalSource;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ToReadTheDataInParticularRow {
    public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream file = new FileInputStream("./src/test/resource/TrelloWorkbook.xlsx");
		Workbook workbook = WorkbookFactory.create(file);
		Sheet sheet = workbook.getSheet("TrelloData");
		int NoOfrow = sheet.getLastRowNum();
		Row lastrow = sheet.getRow(NoOfrow);
		int noofcolumn = lastrow.getLastCellNum();
		for(int i=0;i<noofcolumn;i++) {
			System.out.println(sheet.getRow(1).getCell(i).getStringCellValue());
		}
	}
}
