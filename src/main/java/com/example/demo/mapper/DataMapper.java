package com.example.demo.mapper;

import java.util.LinkedHashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface DataMapper {
	
	@Select("select * from tbl_ota_broken_history")
	public List<LinkedHashMap<String, Object>> getList();
	
	@Select("select * from tbl_ota_broken_history where idx = #{idx}")
	public LinkedHashMap<String, Object> getSearchedList(long idx);
}
