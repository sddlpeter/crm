package com.powernode.crm.poi;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class CreateExcelTest {
    public static void main(String[] args) {
        // 创建HSSFWorkbook对象，对应一个excel 文件
        HSSFWorkbook wb = new HSSFWorkbook();
        HSSFSheet sheet = wb.createSheet("StudentInformation");
        //sheet.createRow("");
    }
}
