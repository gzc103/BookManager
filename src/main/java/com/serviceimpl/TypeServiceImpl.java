package com.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.Type;
import com.dao.TypeMapper;
import com.service.TypeService;

@Service
public class TypeServiceImpl implements TypeService {

	@Autowired
	private TypeMapper tdao;
	
	@Override
	public int insert(Type record) {
		return tdao.insert(record);
	}

	@Override
	public int delete(Integer id) {
		return tdao.delete(id);
	}

	@Override
	public int update(Type record) {
		return tdao.update(record);
	}

	@Override
	public Type selectByPrimaryKey(Integer id) {
		return tdao.selectByPrimaryKey(id);
	}

	@Override
	public List<Type> findAll() {
		return tdao.findAll();
	}

	@Override
	public int selectCount() {
		return tdao.selectCount();
	}

}
