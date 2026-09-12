package utility;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataReader {
	XSSFWorkbook wb;
	
	public ExcelDataReader() {
		File src = new File("./TestData/TestData1.xlsx");
		try {
			FileInputStream fis = new FileInputStream(src);
			wb=new XSSFWorkbook(fis);	
		} catch (Exception e) {
			System.out.println("Unable to load Xls File " +e.getMessage());
		}		
	}
	public String getStringData(int sheetIndex, int row, int column) {
		return wb.getSheetAt(sheetIndex).getRow(row).getCell(column).getStringCellValue();
	}
	public String getStringData(String sheetName, int row, int column) {
		return wb.getSheet(sheetName).getRow(row).getCell(column).getStringCellValue();
	}
	public String getNumericData(String sheetName, int row, int column) {
		return wb.getSheet(sheetName).getRow(row).getCell(column).getStringCellValue();
	

}
}
