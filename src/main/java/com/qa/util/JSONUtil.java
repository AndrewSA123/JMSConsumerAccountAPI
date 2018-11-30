package com.qa.util;

import com.google.gson.Gson;
import org.springframework.stereotype.Component;

@Component
public class JSONUtil {

	private Gson gson;

	public JSONUtil() {
		this.gson = new Gson();
	}

	public String toJSON(Object obj) {
		return gson.toJson(obj);
	}

	public <T> T fromJSON(String jsonString, Class<T> clazz) {
		return gson.fromJson(jsonString, clazz);
	}
	
}