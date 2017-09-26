package com.ylx.librarymanage.dao;

import com.ylx.librarymanage.model.BookAddition;

import java.util.List;

public interface BookAdditionMapper {
    int deleteByPrimaryKey(Integer uid);

    int insert(BookAddition record);

    int insertList(List<BookAddition> list);

    int insertSelective(BookAddition record);

    BookAddition selectByPrimaryKey(Integer uid);

    BookAddition selectById(Integer id);

    int updateByIdSelective(BookAddition record);

    int updateByPrimaryKey(BookAddition record);

    int deleteByPrimaryKeys(List<Integer> uids);

    int deleteByIds(List<Integer> id);

    List<BookAddition> selectByIds(List<Integer> id);
}