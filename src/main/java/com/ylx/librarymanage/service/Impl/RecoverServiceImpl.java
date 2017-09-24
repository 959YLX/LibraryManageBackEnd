package com.ylx.librarymanage.service.Impl;

import com.ylx.librarymanage.common.Const;
import com.ylx.librarymanage.dao.BasicMapper;
import com.ylx.librarymanage.response.ResponseCreator;
import com.ylx.librarymanage.response.ResponseTemplate;
import com.ylx.librarymanage.response.Results.RecoverResult;
import com.ylx.librarymanage.service.RecoverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class RecoverServiceImpl implements RecoverService {

    private BasicMapper basicMapper;

    @Override
    public ResponseTemplate recover(String ids) {
        String[] id = ids.split(Const.SPLIT_CHARACTER);
        List<Integer> idList = new ArrayList<>(id.length);
        for (String idStr :
                id) {
            idList.add(Integer.valueOf(idStr));
        }
        int recoverItemNumber = basicMapper.recoverByIds(idList);
        return ResponseCreator.createSuccessResponseByData(new RecoverResult(recoverItemNumber));
    }

    @Autowired
    public void setBasicMapper(BasicMapper basicMapper) {
        this.basicMapper = basicMapper;
    }
}
