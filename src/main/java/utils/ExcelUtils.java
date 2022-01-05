package utils;

import constants.FrameworkConstants;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class ExcelUtils {

    private ExcelUtils() {
    }

    public static List<Map<String, String>> getTestDetails() {

        String sheetName = "RUNMANAGER";

        List<Map<String, String>> list = null;
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
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(list);
        return list;
    }
}
