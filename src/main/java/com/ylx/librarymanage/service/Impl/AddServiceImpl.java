package com.ylx.librarymanage.service.Impl;

import com.ylx.librarymanage.dao.BasicMapper;
import com.ylx.librarymanage.dao.BookAdditionMapper;
import com.ylx.librarymanage.dao.MagazineAdditionMapper;
import com.ylx.librarymanage.response.ResponseTemplate;
import com.ylx.librarymanage.service.AddService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddServiceImpl implements AddService {

    private BasicMapper basicMapper;
    private BookAdditionMapper bookAdditionMapper;
    private MagazineAdditionMapper magazineAdditionMapper;

    @Override
    public ResponseTemplate addBooks(String bookObj) {

        return null;
    }

    @Override
    public ResponseTemplate addMagazine(String magazineObj) {
        return null;
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
