package com.ylx.librarymanage.service.Impl;

import com.ylx.librarymanage.common.utils.excelutil.DataTemplate;
import com.ylx.librarymanage.common.utils.excelutil.ExportExcel;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@SpringBootTest
public class ExportExcelImplTest {

    private OutputStream outputStream;
    private String[] header;
    private List<List<String>> contains;

    @Before
    public void prepareData() throws IOException {
        File file = new File("/Users/ylx/Desktop/test.xlsx");
        if (file.createNewFile()){
            outputStream = new FileOutputStream(file);
            header = new String[]{"姓名", "年龄", "性别"};
            contains = new ArrayList<>(3);
            List<String> row = new ArrayList<>(3);
            row.add("张三");
            row.add("18");
            row.add("男");
            contains.add(row);
            row = new ArrayList<>(3);
            row.add("李四");
            row.add("10");
            row.add("男");
            contains.add(row);
            row = new ArrayList<>(3);
            row.add("小花");
            row.add("19");
            row.add("");
            contains.add(row);
        }
    }

    @Test
    public void export() throws Exception {
//        DataTemplate template = new DataTemplate();
//        template.setHeader(header);
//        template.setRows(contains);
//        ExportExcelImpl exportExcel = new ExportExcelImpl();
//        exportExcel.export(outputStream, template);
    }

}