package com.ylx.librarymanage.controller;

import com.ylx.librarymanage.controller.form.AddItemForm;
import com.ylx.librarymanage.response.ResponseTemplate;
import com.ylx.librarymanage.service.AddService;
import com.ylx.librarymanage.service.DeleteService;
import com.ylx.librarymanage.service.RecoverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostController {

    private AddService addService;
    private DeleteService deleteService;
    private RecoverService recoverService;

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
}
