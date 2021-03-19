package com.example.demo.service;

import java.util.LinkedHashMap;
import java.util.List;

public interface DataService {
	
	public List<LinkedHashMap<String, Object>> getList();
	public LinkedHashMap<String, Object> getSearchedList(long idx);
}
