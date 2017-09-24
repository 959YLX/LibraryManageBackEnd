package com.ylx.librarymanage.service;

import com.ylx.librarymanage.controller.form.SearchForm;
import com.ylx.librarymanage.response.ResponseTemplate;

public interface SearchService {

    ResponseTemplate searchItems(SearchForm form);

}
