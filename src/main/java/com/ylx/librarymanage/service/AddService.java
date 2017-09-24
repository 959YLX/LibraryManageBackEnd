package com.ylx.librarymanage.service;

import com.ylx.librarymanage.controller.form.AddItemForm;
import com.ylx.librarymanage.response.ResponseTemplate;

public interface AddService {

    ResponseTemplate addItem(AddItemForm form);

}
