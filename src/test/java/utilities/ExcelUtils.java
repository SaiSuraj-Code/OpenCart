package utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

public class ExcelUtils {

    private FileInputStream fi;
    private FileOutputStream fo;
    private XSSFWorkbook wb;
    private XSSFSheet ws;
    private XSSFRow row;
    private XSSFCell cell;
    private CellStyle style;
    private String path;

    public ExcelUtils(String path) {
        this.path = path;
    }

    public int getRowCount(String sheetName) throws IOException {
        fi = new FileInputStream(path);
        wb = new XSSFWorkbook(fi);
        ws = wb.getSheet(sheetName);
        int rowCount = ws.getLastRowNum();
        wb.close();
        fi.close();
        return rowCount;
    }

    public int getCellCount(String sheetName, int rowNum) throws IOException {
        fi = new FileInputStream(path);
        wb = new XSSFWorkbook(fi);
        ws = wb.getSheet(sheetName);
        row = ws.getRow(rowNum);
        int cellCount = row.getLastCellNum();
        wb.close();
        fi.close();
        return cellCount;
    }

    public String getCellData(String sheetName, int rowNum, int colNum) throws IOException {
        fi = new FileInputStream(path);
        wb = new XSSFWorkbook(fi);
        ws = wb.getSheet(sheetName);
        row = ws.getRow(rowNum);
        cell = row.getCell(colNum);

        String data;
        try {
            DataFormatter formatter = new DataFormatter();
            data = formatter.formatCellValue(cell);
        } catch (Exception e) {
            data = "";
        }

        wb.close();
        fi.close();
        return data;
    }

    public void setCellData(String sheetName, int rowNum, int colNum, String data) throws IOException {
        fi = new FileInputStream(path);
        wb = new XSSFWorkbook(fi);
        ws = wb.getSheet(sheetName);
        row = ws.getRow(rowNum);
        if (row == null) row = ws.createRow(rowNum);
        cell = row.createCell(colNum);
        cell.setCellValue(data);

        fo = new FileOutputStream(path);
        wb.write(fo);
        wb.close();
        fi.close();
        fo.close();
    }

    public void fillGreenColor(String sheetName, int rowNum, int colNum) throws IOException {
        setCellColor(sheetName, rowNum, colNum, IndexedColors.GREEN);
    }

    public void fillRedColor(String sheetName, int rowNum, int colNum) throws IOException {
        setCellColor(sheetName, rowNum, colNum, IndexedColors.RED);
    }

    private void setCellColor(String sheetName, int rowNum, int colNum, IndexedColors color) throws IOException {
        fi = new FileInputStream(path);
        wb = new XSSFWorkbook(fi);
        ws = wb.getSheet(sheetName);
        row = ws.getRow(rowNum);
        if (row == null) row = ws.createRow(rowNum);
        cell = row.getCell(colNum);
        if (cell == null) cell = row.createCell(colNum);

        style = wb.createCellStyle();
        style.setFillForegroundColor(color.getIndex());
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        cell.setCellStyle(style);

        fo = new FileOutputStream(path);
        wb.write(fo);
        wb.close();
        fi.close();
        fo.close();
    }
}
