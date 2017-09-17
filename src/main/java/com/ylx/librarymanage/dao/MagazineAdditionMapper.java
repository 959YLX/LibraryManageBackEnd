package com.ylx.librarymanage.dao;

import com.ylx.librarymanage.model.MagazineAddition;

import java.util.List;

public interface MagazineAdditionMapper {
    int deleteByPrimaryKey(Integer uid);

    int insert(MagazineAddition record);

    int insertSelective(MagazineAddition record);

    MagazineAddition selectByPrimaryKey(Integer uid);

    int updateByPrimaryKeySelective(MagazineAddition record);

    int updateByPrimaryKey(MagazineAddition record);

    int deleteByPrimaryKeys(List<Integer> uids);
}