package com.ylx.librarymanage.service.Impl;

import com.ylx.librarymanage.common.Const;
import com.ylx.librarymanage.controller.form.AddItemForm;
import com.ylx.librarymanage.dao.BasicMapper;
import com.ylx.librarymanage.dao.BookAdditionMapper;
import com.ylx.librarymanage.dao.MagazineAdditionMapper;
import com.ylx.librarymanage.model.Basic;
import com.ylx.librarymanage.model.BookAddition;
import com.ylx.librarymanage.model.MagazineAddition;
import com.ylx.librarymanage.response.ErrorCode;
import com.ylx.librarymanage.response.ResponseCreator;
import com.ylx.librarymanage.response.ResponseTemplate;
import com.ylx.librarymanage.service.AddService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import sun.misc.BASE64Encoder;

@Service
public class AddServiceImpl implements AddService {

    private BasicMapper basicMapper;
    private BookAdditionMapper bookAdditionMapper;
    private MagazineAdditionMapper magazineAdditionMapper;

    @Override
    @Transactional
    public ResponseTemplate addItem(AddItemForm form) {
        String type = form.getType();
        Basic basic = new Basic(form.getId(), form.getName(), form.getClassicIndex(), form.getInventory(), form.getBorrowedNumber(), form.getPublicationYear(), form.getPublisher(), form.getPrice(), false);
        if (StringUtils.isEmpty(type)){
            return ResponseCreator.createErrorResponse(ErrorCode.ARGUMENT_ERROR);
        }
        ResponseTemplate responseTemplate;
        switch (type){
            case Const.BOOK_TYPE:{
                responseTemplate = addBook(basic, form);
                break;
            }
            case Const.MAGAZINE_TYPE:{
                responseTemplate = addMagazine(basic, form);
                break;
            }
            default:{
                responseTemplate = ResponseCreator.createErrorResponse(ErrorCode.ARGUMENT_ERROR);
            }
        }
        return responseTemplate;
    }

    private ResponseTemplate addBook(Basic basic, AddItemForm form){
        basic.setType((short) 0);
        basicMapper.insert(basic);
        double preprice = 1000 * (basic.getPrice() / form.getLetterCount());
        BookAddition bookAddition = new BookAddition(basic.getId(), form.getISBN(), form.getEditor(), form.getPageCount(), form.getLetterCount(), preprice);
        bookAdditionMapper.insert(bookAddition);
        return ResponseCreator.createDefaultSuccessResponse();
    }

    private ResponseTemplate addMagazine(Basic basic, AddItemForm form){
        basic.setType((short) 1);
        basicMapper.insert(basic);
        double preprice = basic.getPrice() / form.getPapers();
        MagazineAddition magazineAddition = new MagazineAddition(basic.getId(), form.getISSN(), form.getISDNumber(), form.getSubject(), form.getImpactFactor(), form.getPublishingCycle(), form.getPapers(), preprice);
        magazineAdditionMapper.insert(magazineAddition);
        return ResponseCreator.createDefaultSuccessResponse();
    }

    @Autowired
    public void setBasicMapper(BasicMapper basicMapper) {
        this.basicMapper = basicMapper;
    }

    @Autowired
    public void setBookAdditionMapper(BookAdditionMapper bookAdditionMapper) {
        this.bookAdditionMapper = bookAdditionMapper;
    }

    @Autowired
    public void setMagazineAdditionMapper(MagazineAdditionMapper magazineAdditionMapper) {
        this.magazineAdditionMapper = magazineAdditionMapper;
    }

}
