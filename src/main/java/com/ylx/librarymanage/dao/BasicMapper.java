package com.ylx.librarymanage.dao;

import com.ylx.librarymanage.model.Basic;

public interface BasicMapper {
    int deleteByPrimaryKey(Integer uid);

    int insert(Basic record);

    int insertSelective(Basic record);

    Basic selectByPrimaryKey(Integer uid);

    int updateByPrimaryKeySelective(Basic record);

    int updateByPrimaryKey(Basic record);
}