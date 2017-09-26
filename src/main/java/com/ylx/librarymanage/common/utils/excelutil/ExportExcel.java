package com.ylx.librarymanage.common.utils.excelutil;

import java.io.IOException;
import java.io.OutputStream;

public interface ExportExcel {

    void export(OutputStream outputStream, DataTemplate template) throws IOException;

}
