package com.ylx.librarymanage.common.utils.excelutil;

import java.util.List;

public class DataTemplate {

    private String[] header;
    private List<List<String>> rows;

    public String[] getHeader() {
        return header;
    }

    public void setHeader(String[] header) {
        this.header = header;
    }

    public List<List<String>> getRows() {
        return rows;
    }

    public void setRows(List<List<String>> rows) {
        this.rows = rows;
    }
}
