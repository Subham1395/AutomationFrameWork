package genericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This class consist of generic method to read the data from excel sheet
 * @author HP
 */
public class ExcelUtility {
	
	/**
	 * This method will read the data from excel sheet and return the value
	 * @param SheetName
	 * @param rownum
	 * @param cellnum
	 * @return
	 * @throws Throwable
	 */
	public String readDataFromExcelUtility(String SheetName, int rownum, int cellnum) throws Throwable
	{
		FileInputStream fis =new FileInputStream("src/test/resources/TestData.xlsx");
		Workbook book=WorkbookFactory.create(fis);
		 Sheet sheet = book.getSheet(SheetName);
		  Row row = sheet.getRow(rownum);
		Cell cell = row.getCell(cellnum);
		String value = cell.getStringCellValue();
		return value;
	}
	/**
	 * this method will used for fetching the data from excel sheet with multiple data or different set of data with data provider
	 * @param SheetName
	 * @return 
	 * @throws Throwable
	 */
	public Object[][] readMultipleDataFromExcelUtility(String SheetName) throws Throwable
	{
		FileInputStream fis = new FileInputStream("src/test/resources/TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		 Sheet sheet=wb.getSheet(SheetName);
		int lastrow=sheet.getLastRowNum();
		 int lastcell=sheet.getRow(0).getLastCellNum();
		 Object[][] data=new Object [lastrow][lastcell];
		 for(int i=0; i<lastrow;i++)
		 {
			 for(int j=0; j<lastcell; j++)
			 {
				 data[i][j] = sheet.getRow(i+1).getCell(j).getStringCellValue();
			 }
		 }
		 return data;
	}

}
