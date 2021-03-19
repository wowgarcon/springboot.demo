package com.example.demo.config;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.utilities.MessageInitializer;
import com.example.demo.vo.ResponseVo;

import lombok.extern.log4j.Log4j2;

@Component
@Log4j2
public class Interceptor implements HandlerInterceptor {

	@SuppressWarnings("unchecked")
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		log.info("preHandle : " + request.getRequestURI());
		
		JSONObject jsonObj = new JSONObject();
		response.setContentType("application/Json");
		response.setCharacterEncoding("UTF-8");
		
		// 토근 null 검사
		if(request.getHeader("Token") == null) {
			jsonObj.put("code", 412);
			jsonObj.put("messsage", MessageInitializer.codeToMessage(412));
			response.getWriter().write(jsonObj.toJSONString());
			return false;
		}

		// 토근 유효성 검사
		String originToken = "%wowgarcon%";
		Boolean tokenMatching = request.getHeader("Token").contains(originToken) ? true : false;
		
		if(!tokenMatching) {
			jsonObj.put("code", 413);
			jsonObj.put("message", MessageInitializer.codeToMessage(413));
			response.getWriter().write(jsonObj.toJSONString());
			return false;
		}
		
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		log.info("postHandle");
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		log.info("afterCompletion");
	}

	
}
