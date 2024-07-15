package toReadDataFromExternalSource;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ToReadMultipleDataInParticularColumn {
    public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream file = new FileInputStream("./src/test/resource/TrelloWorkbook.xlsx");
		Workbook workbook = WorkbookFactory.create(file);
		Sheet sheet = workbook.getSheet("TrelloData");
		int lastrow = sheet.getLastRowNum();
		Row r = sheet.getRow(lastrow);
		int lastcoulmn = r.getLastCellNum();
		for(int i=1;i<=lastrow;i++) {
			System.out.println(sheet.getRow(i).getCell(0).getStringCellValue());
		}
	}
}
