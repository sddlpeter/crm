package com.powernode.crm.commons.utils;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.ss.usermodel.CellType;

public class HSSFUtil {
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
