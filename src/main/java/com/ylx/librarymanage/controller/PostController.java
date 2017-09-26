package com.ylx.librarymanage.controller;

import com.sun.org.apache.regexp.internal.RE;
import com.ylx.librarymanage.controller.form.AddItemForm;
import com.ylx.librarymanage.response.ErrorCode;
import com.ylx.librarymanage.response.ResponseCreator;
import com.ylx.librarymanage.response.ResponseTemplate;
import com.ylx.librarymanage.service.AddService;
import com.ylx.librarymanage.service.DeleteService;
import com.ylx.librarymanage.service.RecoverService;
import com.ylx.librarymanage.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class PostController {

    private AddService addService;
    private DeleteService deleteService;
    private RecoverService recoverService;
    private UploadService uploadService;

    @PostMapping("/add")
    public ResponseTemplate addItem(AddItemForm addItemForm){
        return addService.addItem(addItemForm);
    }

    @PostMapping("/delete")
    public ResponseTemplate deleteItem(@RequestParam("ids") String ids){
        return deleteService.deleteItems(ids);
    }

    @PostMapping("/recover")
    public ResponseTemplate recoverItem(@RequestParam("ids") String ids){
        return recoverService.recover(ids);
    }

    @PostMapping("/upload")
    public ResponseTemplate upload(@RequestParam("file") MultipartFile multipartFile){
        if (multipartFile.isEmpty()){
            return ResponseCreator.createErrorResponse(ErrorCode.ARGUMENT_ERROR);
        }
        return uploadService.uploadExcelFile(multipartFile);
    }

    @Autowired
    public void setAddService(AddService addService) {
        this.addService = addService;
    }

    @Autowired
    public void setDeleteService(DeleteService deleteService) {
        this.deleteService = deleteService;
    }

    @Autowired
    public void setRecoverService(RecoverService recoverService) {
        this.recoverService = recoverService;
    }

    @Autowired
    public void setUploadService(UploadService uploadService) {
        this.uploadService = uploadService;
    }
}
