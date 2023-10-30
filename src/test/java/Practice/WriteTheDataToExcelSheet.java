package Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteTheDataToExcelSheet {

	public static void main(String[] args) throws Throwable {
		//step1 open the documents in java readable format
		FileInputStream fis = new FileInputStream("src/test/resources/ExcelData.xlsx");
		
		//step2 create workbook
		Workbook book = WorkbookFactory.create(fis);
		
		//step3 navigate to required sheet
		Sheet sheet = book.getSheet("Products");
		
		//step4 write the required data in key and value format using LinkedHashMap
		LinkedHashMap<String, String> map = new LinkedHashMap<String,String>();
         map.put("10", "gearbox");
         map.put("20", "pitmanarm");
         map.put("30", "linkrod");
         
         //step5 iterate the value
         int rowNo=0;
         for(Entry<String, String> m:map.entrySet())
         {
        	  Row row = sheet.createRow(rowNo++);
        	  row.createCell(0).setCellValue((String)m.getKey());
        	  row.createCell(1).setCellValue((String)m.getValue());
        	 
         }
         
         //step6 write the data into excel
         FileOutputStream fos = new FileOutputStream("src/test/resources/ExcelData.xlsx");
         book.write(fos);
         System.out.println("update the data into excell sheet");
         book.close();
         
	}

}
