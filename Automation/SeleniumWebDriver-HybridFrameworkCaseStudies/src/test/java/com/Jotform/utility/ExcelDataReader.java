package com.Jotform.utility;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataReader {

    XSSFWorkbook wb;

    XSSFSheet sheet;

    public ExcelDataReader() {

        try {

            File src = new File(
                    "./TestData/TestData2.xlsx"
            );

            FileInputStream fis =
                    new FileInputStream(src);

            wb = new XSSFWorkbook(fis);

        } catch (Exception e) {

            System.out.println(
                    "Exception is: " + e.getMessage()
            );

        }

    }

    public String getStringData(
            String sheetName,
            int row,
            int column) {

        sheet = wb.getSheet(sheetName);

        return sheet
                .getRow(row)
                .getCell(column)
                .getStringCellValue();

    }

}