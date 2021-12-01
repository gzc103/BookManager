package com.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bean.Type;
@Repository
public interface TypeMapper {
    int insert(Type record);
    int delete(Integer id);
	int update(Type record);
    Type selectByPrimaryKey(Integer id);
    List<Type> findAll();
    int selectCount();
}