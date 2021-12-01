package com.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.bean.Info;
import com.bean.Page;
@Repository
public interface InfoMapper {
    int insert(Info record);
    int delete(Integer id);
	int update(Info record);
    Map<String,Object> selectByPrimaryKey(Integer id);
    List<Map<String,Object>> findAll();
    int selectCount();
    //按名称查询
    List<Map<String,Object>> findByName(String name);
    //分页查询
    List<Map<String,Object>> selectAll(Page page);
    int findCount();
}