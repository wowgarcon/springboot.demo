package com.example.demo.service;

import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mapper.DataMapper;

@Service
public class DataServiceImpl implements DataService {
	
	@Autowired
	private DataMapper mapper;
	
	@Override
	public List<LinkedHashMap<String, Object>> getList(){
		return mapper.getList();
	}

	@Override
	public LinkedHashMap<String, Object> getSearchedList(long idx) {
		return mapper.getSearchedList(idx);
	}
	
	
}
