package com.serviceimpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.Info;
import com.bean.Page;
import com.dao.InfoMapper;
import com.service.InfoService;

@Service
public class InfoServiceImpl implements InfoService {

	@Autowired
	private InfoMapper idao;
	
	
	@Override
	public int insert(Info record) {
		return idao.insert(record);
	}

	@Override
	public int delete(Integer id) {
		return idao.delete(id);
	}

	@Override
	public int update(Info record) {
		return idao.update(record);
	}

	@Override
	public Map<String, Object> selectByPrimaryKey(Integer id) {
		return idao.selectByPrimaryKey(id);
	}

	@Override
	public List<Map<String, Object>> findAll() {
		return idao.findAll();
	}

	@Override
	public int selectCount() {
		return idao.selectCount();
	}

	@Override
	public List<Map<String, Object>> findByName(String name) {
		return idao.findByName(name);
	}

	@Override
	public List<Map<String, Object>> selectAll(Page page) {
		return idao.selectAll(page);
	}

	@Override
	public int findCount() {
		return idao.findCount();
	}

}
