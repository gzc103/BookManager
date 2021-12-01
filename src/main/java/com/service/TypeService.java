package com.service;

import java.util.List;

import com.bean.Type;

public interface TypeService {
    int insert(Type record);
    int delete(Integer id);
	int update(Type record);
    Type selectByPrimaryKey(Integer id);
    List<Type> findAll();
    int selectCount();
}
