package utility;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {

    XSSFWorkbook wb;

    public ExcelDataProvider() {

        File src = new File("./TestData/Test.xlsx");

        try {

            FileInputStream fis = new FileInputStream(src);

            wb = new XSSFWorkbook(fis);

        } catch (Exception e) {

            System.out.println(
                "Not able to load Excel file >> " + e.getMessage()
            );
        }
    }

    public String getStringData(int sheetIndex, int row, int column) {

        DataFormatter formatter = new DataFormatter();

        return formatter.formatCellValue(
            wb.getSheetAt(sheetIndex)
              .getRow(row)
              .getCell(column)
        );
    }

    public String getStringData(String sheetName, int row, int column) {

        DataFormatter formatter = new DataFormatter();

        return formatter.formatCellValue(
            wb.getSheet(sheetName)
              .getRow(row)
              .getCell(column)
        );
    }

    public double getNumericData(String sheetName, int row, int column) {

        return wb.getSheet(sheetName)
                 .getRow(row)
                 .getCell(column)
                 .getNumericCellValue();
    }
}