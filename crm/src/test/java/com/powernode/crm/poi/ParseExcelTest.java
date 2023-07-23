package com.powernode.crm.poi;

import com.powernode.crm.commons.utils.HSSFUtil;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.CellType;

import java.io.FileInputStream;
import java.io.InputStream;

public class ParseExcelTest {
    public static void main(String[] args) throws Exception {
        InputStream is = new FileInputStream("C:\\Users\\Admin\\Documents\\ServerDir\\activityList.xls");
        HSSFWorkbook wb = new HSSFWorkbook(is);

        HSSFSheet sheet = wb.getSheetAt(0);

        HSSFRow row = null;
        HSSFCell cell = null;
        for (int i = 0; i < sheet.getLastRowNum(); i++) {
            row = sheet.getRow(i);

            for (int j = 0; j < row.getLastCellNum(); j++) {
                cell = row.getCell(j);
                String cellValueForStr = HSSFUtil.getCellValueForStr(cell);
                System.out.print(cellValueForStr + " ");
            }

            System.out.println();
        }
    }

    public static String getCellValueForStr(HSSFCell cell) {
        String res = "";
        if (cell.getCellType() == CellType.STRING) {
            res = cell.getStringCellValue();
        } else if (cell.getCellType() == CellType.NUMERIC) {
            res = cell.getNumericCellValue() + "";
        } else if (cell.getCellType() == CellType.BOOLEAN) {
            res = cell.getBooleanCellValue() + "";
        } else if (cell.getCellType() == CellType.FORMULA) {
            res = cell.getCellFormula() + "";
        }

        return res;
    }
}
