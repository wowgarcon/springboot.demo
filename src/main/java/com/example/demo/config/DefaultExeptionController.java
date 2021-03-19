package com.example.demo.config;

import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.vo.ResponseVo;

import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
public class DefaultExeptionController implements ErrorController{

	@Override
	public String getErrorPath() {
		return "/error";
	}

	@RequestMapping("/error")
	public ResponseVo error(HttpServletRequest request) {
		int code = (int) request.getAttribute("javax.servlet.error.status_code");
		log.info(code);
		
		return new ResponseVo(code);
	}
	
}
