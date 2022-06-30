
package com.humintec.poc.dto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class BaseDTO {
	 
	 final ObjectMapper objectMapper = new ObjectMapper();
	
	@Override
	public String toString() {
		String serializedString = null;
		try {
			serializedString = objectMapper.writeValueAsString(this);
		} catch (JsonProcessingException e) {		
			e.printStackTrace();
		}
		return serializedString;
	}
}