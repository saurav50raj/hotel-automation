package data;

import org.apache.poi.ss.usermodel.*;
import java.io.FileInputStream;
import java.util.*;

public class ExcelUtils {
    public static List<String[]> readData(String path, String sheetName) throws Exception {
        List<String[]> data = new ArrayList<>();
        Workbook wb = WorkbookFactory.create(new FileInputStream(path));
        Sheet sheet = wb.getSheet(sheetName);

        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            Row row = sheet.getRow(i);
            String[] values = new String[row.getLastCellNum()];
            for (int j = 0; j < row.getLastCellNum(); j++) {
                values[j] = row.getCell(j).toString().trim();
            }
            data.add(values);
        }

        wb.close();
        return data;
    }
}