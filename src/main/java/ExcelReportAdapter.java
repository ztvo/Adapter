import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelReportAdapter implements ReportGenerator {
    public void generateReport(String text) {
        System.out.println("Generating Excel report ...");
        Workbook book = new HSSFWorkbook();
        Sheet sheet = book.createSheet("list1");
        Row row = sheet.createRow(0);
        Cell name = row.createCell(0);
        name.setCellValue(text);
        // Меняем размер столбца
        sheet.autoSizeColumn(0);
        try {
            // Записываем всё в файл
            book.write(new FileOutputStream("excel.xls"));
            book.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
