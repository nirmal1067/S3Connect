package com.amazonaws.s3.operations;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

public interface IReader {
	
	
	public String readJson(String bucket,String key)throws JsonParseException, JsonMappingException, IOException;

}
