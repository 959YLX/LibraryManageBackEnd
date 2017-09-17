package com.ylx.librarymanage.service.Impl;

import com.ylx.librarymanage.common.Const;
import com.ylx.librarymanage.dao.BasicMapper;
import com.ylx.librarymanage.dao.BookAdditionMapper;
import com.ylx.librarymanage.dao.MagazineAdditionMapper;
import com.ylx.librarymanage.model.Basic;
import com.ylx.librarymanage.response.ResponseCreator;
import com.ylx.librarymanage.response.ResponseTemplate;
import com.ylx.librarymanage.service.DeleteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class DeleteServiceImpl implements DeleteService {

    private BasicMapper basicMapper;
    private BookAdditionMapper bookAdditionMapper;
    private MagazineAdditionMapper magazineAdditionMapper;

    @Override
    public ResponseTemplate deleteItems(String ids) {
        List<Basic> items = basicMapper.selectById(Arrays.asList(ids.split(Const.SPLIT_CHARACTER)));
        List<Integer> deleteList = new ArrayList<>();
        List<Integer> tagList = new ArrayList<>();
        for (Basic basic :
                items) {
            if (basic.getTrash()){
                deleteList.add(basic.getUid());
                continue;
            }
            tagList.add(basic.getUid());
        }
        if (!deleteList.isEmpty()){
            delete(deleteList);
        }
        if (!tagList.isEmpty()){
            moveToTrash(deleteList);
        }
        return ResponseCreator.createDefaultSuccessResponse();
    }

    private void delete(List<Integer> list){
        basicMapper.deleteByPrimaryKeys(list);
        bookAdditionMapper.deleteByPrimaryKeys(list);
        magazineAdditionMapper.deleteByPrimaryKeys(list);
    }

    private void moveToTrash(List<Integer> list){
        basicMapper.updateTrashByPrimaryKeys(list);
    }

    @Autowired
    public void setMagazineAdditionMapper(MagazineAdditionMapper magazineAdditionMapper) {
        this.magazineAdditionMapper = magazineAdditionMapper;
    }

    @Autowired
    public void setBookAdditionMapper(BookAdditionMapper bookAdditionMapper) {
        this.bookAdditionMapper = bookAdditionMapper;
    }

    @Autowired
    public void setBasicMapper(BasicMapper basicMapper) {
        this.basicMapper = basicMapper;
    }
}
