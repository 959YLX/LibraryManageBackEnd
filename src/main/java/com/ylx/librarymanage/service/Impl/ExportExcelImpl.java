package com.ylx.librarymanage.service.Impl;

import com.ylx.librarymanage.common.utils.excelutil.DataTemplate;
import com.ylx.librarymanage.common.utils.excelutil.ExportExcel;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

@Service
public class ExportExcelImpl implements ExportExcel {

    @Override
    public void export(OutputStream outputStream, DataTemplate template) throws IOException {
        String[] header = template.getHeader();
        List<List<String>> containRows = template.getRows();
        XSSFWorkbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet();
        Row headerRow = sheet.createRow(0);
        Cell cell;
        for (int i = 0; i < header.length; i++) {
            cell = headerRow.createCell(i);
            cell.setCellValue(header[i]);
        }
        if (containRows != null) {
            Row containRow;
            List<String> contains;
            int containRowSize = containRows.size();
            for (int i = 0; i < containRowSize; i++) {
                containRow = sheet.createRow(i + 1);
                contains = containRows.get(i);
                int containSize = contains.size();
                for (int j = 0; j < containSize; j++) {
                    cell = containRow.createCell(j);
                    cell.setCellValue(contains.get(j));
                }
            }
        }
        workbook.write(outputStream);
    }
}
