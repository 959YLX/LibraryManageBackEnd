package com.ylx.librarymanage.dao;

import com.ylx.librarymanage.model.MagazineAddition;

import java.util.List;

public interface MagazineAdditionMapper {
    int deleteByPrimaryKey(Integer uid);

    int insert(MagazineAddition record);

    int insertList(List<MagazineAddition> magazineAdditions);

    int insertSelective(MagazineAddition record);

    MagazineAddition selectByPrimaryKey(Integer uid);

    MagazineAddition selectById(Integer id);

    List<MagazineAddition> selectByIds(List<Integer> ids);

    int updateByIdSelective(MagazineAddition record);

    int updateByPrimaryKey(MagazineAddition record);

    int deleteByPrimaryKeys(List<Integer> uids);

    int deleteByIds(List<Integer> id);
}