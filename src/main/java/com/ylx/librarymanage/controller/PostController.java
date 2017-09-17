package com.ylx.librarymanage.controller;

import com.ylx.librarymanage.common.Const;
import com.ylx.librarymanage.controller.form.AddItemForm;
import com.ylx.librarymanage.response.ErrorCode;
import com.ylx.librarymanage.response.ResponseCreator;
import com.ylx.librarymanage.response.ResponseTemplate;
import com.ylx.librarymanage.service.AddService;
import com.ylx.librarymanage.service.DeleteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostController {

    private AddService addService;
    private DeleteService deleteService;

    @PostMapping("/add")
    public ResponseTemplate addItem(AddItemForm addItemForm){
        String type = addItemForm.getType();
        if (StringUtils.isEmpty(type)){
            return ResponseCreator.createErrorResponse(ErrorCode.ARGUMENT_ERROR);
        }
        ResponseTemplate response = null;
        switch (type){
            case Const.BOOK_TYPE: {
                response = addService.addBooks(addItemForm.getObj());
                break;
            }
            case Const.MAGAZINE_TYPE: {
                response = addService.addMagazine(addItemForm.getObj());
                break;
            }
        }
        return response == null ? ResponseCreator.createErrorResponse(ErrorCode.SYSTEM_ERROR) : response;
    }


    public ResponseTemplate deleteItem(@RequestParam("id") String id){
        return deleteService.deleteItems(id);
    }

    @Autowired
    public void setAddService(AddService addService) {
        this.addService = addService;
    }

    @Autowired
    public void setDeleteService(DeleteService deleteService) {
        this.deleteService = deleteService;
    }
}
