package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer, EnvironmentAware{

	@Autowired
	public static Environment environment;
	
	@Autowired
	private Interceptor intercept;
	
	@Override
	public void setEnvironment(Environment environment) {
		WebConfig.environment = environment;
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(intercept)
		.addPathPatterns("/**")
		.excludePathPatterns("/error");
	}

	
}
