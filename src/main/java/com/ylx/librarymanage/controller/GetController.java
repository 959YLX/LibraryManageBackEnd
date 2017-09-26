package com.ylx.librarymanage.controller;

import com.ylx.librarymanage.controller.form.SearchForm;
import com.ylx.librarymanage.response.ResponseTemplate;
import com.ylx.librarymanage.service.ExportService;
import com.ylx.librarymanage.service.ListService;
import com.ylx.librarymanage.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
public class GetController {

    private ListService listService;
    private SearchService searchService;
    private ExportService exportService;

    @GetMapping(value = "/getList")
    public ResponseTemplate getList(@RequestParam(value = "trash") Boolean trash,@RequestParam(value = "page", required = false, defaultValue = "1") Integer page){
        return listService.getList(trash, page);
    }

    @GetMapping(value = "/search")
    public ResponseTemplate search(SearchForm form){
        return searchService.searchItems(form);
    }

    @GetMapping(value = "/export")
    public void exportData(HttpServletResponse response, @RequestParam(value = "trash") Boolean trash){
        exportService.export(response, trash);
    }

    @Autowired
    public void setListService(ListService listService) {
        this.listService = listService;
    }

    @Autowired
    public void setSearchService(SearchService searchService) {
        this.searchService = searchService;
    }

    @Autowired
    public void setExportService(ExportService exportService) {
        this.exportService = exportService;
    }
}
