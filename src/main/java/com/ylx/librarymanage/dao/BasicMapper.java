package com.ylx.librarymanage.dao;

import com.ylx.librarymanage.model.Basic;

import java.util.List;

public interface BasicMapper {
    int deleteByPrimaryKey(Integer uid);

    int insert(Basic record);

    int insertSelective(Basic record);

    Basic selectByPrimaryKey(Integer uid);

    int updateByPrimaryKeySelective(Basic record);

    int updateByPrimaryKey(Basic record);

    List<Basic> selectById(List<String> ids);

    int deleteByPrimaryKeys(List<Integer> uids);

    int updateTrashByPrimaryKeys(List<Integer> uids);
}