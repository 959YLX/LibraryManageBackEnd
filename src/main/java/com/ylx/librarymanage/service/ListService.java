package com.ylx.librarymanage.service;

import com.ylx.librarymanage.model.Basic;
import com.ylx.librarymanage.response.ResponseTemplate;

import java.util.List;

public interface ListService {

    ResponseTemplate getList(boolean trashModel, int pageNumber);

    ResponseTemplate buildRequiredList(List<Basic> list);

}
