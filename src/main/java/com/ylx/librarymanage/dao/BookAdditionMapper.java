package com.ylx.librarymanage.dao;

import com.ylx.librarymanage.model.BookAddition;

import java.util.List;

public interface BookAdditionMapper {
    int deleteByPrimaryKey(Integer uid);

    int insert(BookAddition record);

    int insertSelective(BookAddition record);

    BookAddition selectByPrimaryKey(Integer uid);

    int updateByPrimaryKeySelective(BookAddition record);

    int updateByPrimaryKey(BookAddition record);

    int deleteByPrimaryKeys(List<Integer> uids);
}