package com.ylx.librarymanage.dao;

import com.ylx.librarymanage.model.Basic;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BasicMapper {
    int deleteByPrimaryKey(Integer uid);

    int insert(Basic record);

    int insertSelective(Basic record);

    Basic selectByPrimaryKey(Integer uid);

    int updateByPrimaryKeySelective(Basic record);

    int updateByPrimaryKey(Basic record);

    List<Basic> selectByIds(List<Integer> ids);

    int deleteByPrimaryKeys(List<Integer> uids);

    int deleteByIds(List<Integer> ids);

    int updateTrashByIds(List<Integer> id);

//    List<Basic> selectAllNotInTrash();
//
//    List<Basic> selectAllInTrash();

    List<Basic> selectAll(@Param("trash") Boolean trash);

    int recoverByIds(List<Integer> ids);

    List<Basic> selectByKeyword(SearchObject searchObject);
}