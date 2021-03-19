package com.example.demo.vo;

import com.example.demo.utilities.MessageInitializer;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;
import lombok.extern.log4j.Log4j2;

@Data
@Log4j2
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseVo {

	private int code;
	private String message;
	private Object data;
	
	public ResponseVo() {}
	
	public ResponseVo(int code) {
		this.code = code;
		this.message = MessageInitializer.codeToMessage(code);
		log.info("response ::::: code = " + code + ", message = " + message);
	}
	
	public ResponseVo(int code, Object data) {
		this.code = code;
		this.message = MessageInitializer.codeToMessage(code);
		this.data = data;
		log.info("response ::::: code = " + code + ", message = " + message);
	}
	
}
