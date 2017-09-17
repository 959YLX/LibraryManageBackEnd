package com.ylx.librarymanage.service;

import com.ylx.librarymanage.response.ResponseTemplate;

public interface AddService {

    ResponseTemplate addBooks(String bookObj);

    ResponseTemplate addMagazine(String magazineObj);

}
