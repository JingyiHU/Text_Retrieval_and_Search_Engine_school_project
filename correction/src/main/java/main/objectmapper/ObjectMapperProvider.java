package main.objectmapper;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ObjectMapperProvider {
	public static ObjectMapper get() {
		ObjectMapper mapper = new ObjectMapper();
		
		return mapper;
	}
}
