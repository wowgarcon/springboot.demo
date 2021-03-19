package com.example.demo.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.DataService;
import com.example.demo.vo.ResponseVo;

import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
public class DataController {

	@Autowired
	private DataService service;
	
	
	@GetMapping("/list")
	public ResponseVo getList () {
		return new ResponseVo(200, service.getList());
	}
	
	
	@GetMapping("/searched-list")
	public ResponseVo getSearchedList (@RequestBody Map<String, Object> map) {
		int idx = (int) map.get("idx");
		log.info(idx);
		
		return new ResponseVo(200, service.getSearchedList(idx));
	}
	
}
