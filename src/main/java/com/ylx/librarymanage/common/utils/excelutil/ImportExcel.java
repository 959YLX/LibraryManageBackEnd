package com.ylx.librarymanage.common.utils.excelutil;

import java.io.IOException;
import java.io.InputStream;

public interface ImportExcel {

    DataTemplate importExcel(InputStream inputStream) throws IOException;

}
