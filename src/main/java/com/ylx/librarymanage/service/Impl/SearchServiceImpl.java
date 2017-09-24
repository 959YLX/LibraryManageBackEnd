package com.ylx.librarymanage.service.Impl;

import com.github.pagehelper.PageHelper;
import com.ylx.librarymanage.common.Const;
import com.ylx.librarymanage.controller.form.SearchForm;
import com.ylx.librarymanage.dao.BasicMapper;
import com.ylx.librarymanage.dao.SearchObject;
import com.ylx.librarymanage.model.Basic;
import com.ylx.librarymanage.response.ResponseTemplate;
import com.ylx.librarymanage.service.ListService;
import com.ylx.librarymanage.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchServiceImpl implements SearchService {

    private BasicMapper basicMapper;
    private ListService listService;

    @Override
    public ResponseTemplate searchItems(SearchForm form) {
        PageHelper.startPage(form.getPage(), Const.PAGE_SIZE);
        String keyword = Const.SEARCH_CHARACTER + form.getKeyword() + Const.SEARCH_CHARACTER;
        List<Basic> lists = basicMapper.selectByKeyword(new SearchObject(keyword, form.getTrash()));
        return listService.buildRequiredList(lists);
    }

    @Autowired
    public void setBasicMapper(BasicMapper basicMapper) {
        this.basicMapper = basicMapper;
    }

    @Autowired
    public void setListService(ListService listService) {
        this.listService = listService;
    }
}
