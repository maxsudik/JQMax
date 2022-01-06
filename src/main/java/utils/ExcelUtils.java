package utils;

import constants.FrameworkConstants;
import exceptions.InvalidPathForExcelException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class ExcelUtils {

    private ExcelUtils() {
    }

    public static List<Map<String, String>> getTestDetails(String sheetName) {

        List<Map<String, String>> list;
        try (FileInputStream fileInputStream = new FileInputStream(FrameworkConstants.getExcelPath())) {
            XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
            XSSFSheet sheet = workbook.getSheet(sheetName);

            int lastRowNumber = sheet.getLastRowNum();
            int lastColumnNumber = sheet.getRow(0).getLastCellNum();

            Map<String, String> map;
            list = new ArrayList<>();
            for (int i = 1; i <= lastRowNumber; i++) {
                map = new HashMap<>();
                for (int j = 0; j < lastColumnNumber; j++) {
                    String key = sheet.getRow(0).getCell(j).getStringCellValue();
                    String value = sheet.getRow(i).getCell(j).getStringCellValue();
                    map.put(key, value);
                }
                list.add(map);
            }
        } catch (FileNotFoundException e) {
            StackTraceElement[] a = e.getStackTrace();
            a[0] = new StackTraceElement("utils.ExcelUtils", "getTestDetails", "ExcelUtils.java", 23);
            e.setStackTrace(a);
            throw new InvalidPathForExcelException("Excel file you trying to read is not found", e);
        } catch (IOException e) {
            throw new RuntimeException("Some IO exception happened while reading excel file");
        }
        System.out.println(list);
        return list;
    }
}
