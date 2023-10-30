package Practice;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadTheDataFromExcelFile {

	public static void main(String[] args) throws Throwable, IOException {
		//step1- open the doc in java readable format 
		
		FileInputStream fis = new FileInputStream("src/test/resources/TestData.xlsx");
		//step2-create workbook
		Workbook book = WorkbookFactory.create(fis);
		//step3- navigate to required sheet
		Sheet sheet=book.getSheet("Contacts");
		//step4- navigate to required row
		Row row=sheet.getRow(1);
		//step5-navigate to required cell
		Cell cell = row.getCell(2);
		//step6- capture the data and print
       String lastname=   cell.getStringCellValue();
       System.out.println(lastname);
	}

}
