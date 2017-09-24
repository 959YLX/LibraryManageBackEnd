package com.ylx.librarymanage.service.Impl;

import com.ylx.librarymanage.common.Const;
import com.ylx.librarymanage.dao.BasicMapper;
import com.ylx.librarymanage.dao.BookAdditionMapper;
import com.ylx.librarymanage.dao.MagazineAdditionMapper;
import com.ylx.librarymanage.model.Basic;
import com.ylx.librarymanage.response.ResponseCreator;
import com.ylx.librarymanage.response.ResponseTemplate;
import com.ylx.librarymanage.response.Results.DeleteResult;
import com.ylx.librarymanage.service.DeleteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        String[] idsStr = ids.split(Const.SPLIT_CHARACTER);
        List<Integer> itemsId = new ArrayList<>();
        for (String s:
             idsStr) {
            itemsId.add(Integer.valueOf(s));
        }
        List<Basic> items = basicMapper.selectByIds(itemsId);
        List<Integer> deleteList = new ArrayList<>();
        List<Integer> tagList = new ArrayList<>();
        for (Basic basic :
                items) {
            if (basic.getTrash()){
                deleteList.add(basic.getId());
                continue;
            }
            tagList.add(basic.getId());
        }
        if (!deleteList.isEmpty()){
            delete(deleteList);
        }
        if (!tagList.isEmpty()){
            moveToTrash(tagList);
        }
        DeleteResult result = new DeleteResult(deleteList.size(), tagList.size());
        return ResponseCreator.createSuccessResponseByData(result);
    }

    private void delete(List<Integer> list){
        basicMapper.deleteByPrimaryKeys(list);
        bookAdditionMapper.deleteByIds(list);
        magazineAdditionMapper.deleteByIds(list);
    }

    private void moveToTrash(List<Integer> list){
        basicMapper.updateTrashByIds(list);
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
