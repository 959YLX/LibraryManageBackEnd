package com.ylx.librarymanage.service.Impl;

import com.ylx.librarymanage.common.utils.excelutil.DataTemplate;
import com.ylx.librarymanage.common.utils.excelutil.ImportExcel;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Service
public class ImportExcelImpl implements ImportExcel {

    @Override
    public DataTemplate importExcel(InputStream inputStream) throws IOException {
        DataTemplate data = new DataTemplate();
        Workbook workbook = new XSSFWorkbook(inputStream);
        Sheet sheet = workbook.getSheetAt(0);
        int rowSize = sheet.getLastRowNum();
        if (rowSize < 1){
            //无数据
            return null;
        }
        Row row = sheet.getRow(0);
        Cell cell;
        int cellSize = row.getLastCellNum();
        String[] header = new String[cellSize];
        for (int i = 0; i < cellSize; i++) {
            cell = row.getCell(i);
            header[i] = cell.getStringCellValue();
        }
        data.setHeader(header);
        List<List<String>> rows = new ArrayList<>(rowSize);
        List<String> cells;
        for (int i = 1; i <= rowSize; i++) {
            row = sheet.getRow(i);
            cellSize = row.getLastCellNum();
            cells = new ArrayList<>(cellSize);
            for (int j = 0; j <= cellSize; j++) {
                cell = row.getCell(j);
                cells.add(String.valueOf(cell));
            }
            rows.add(cells);
        }
        data.setRows(rows);
        return data;
    }

}
