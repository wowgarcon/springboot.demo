package com.example.demo.utilities;

import java.io.UnsupportedEncodingException;

import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import com.example.demo.config.WebConfig;

@Component
@PropertySource("classpath:static/properties/code.message.properties")
public class MessageInitializer {

	public static String codeToMessage (int code) {
		String message = "";
		
		try {
			message = WebConfig.environment.getProperty("code." + code);
			message = (message != null) ?	new String(message.getBytes("ISO-8859-1"), "UTF-8")
											: "Unknown server error";
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		return message;
	}
	
}
