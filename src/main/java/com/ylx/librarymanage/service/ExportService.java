package com.ylx.librarymanage.service;


import javax.servlet.http.HttpServletResponse;

public interface ExportService {

    void export(HttpServletResponse response, Boolean trash);

}
