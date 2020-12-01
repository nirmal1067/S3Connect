package com.amazonaws.s3.operations;

import java.io.IOException;

import com.amazonaws.services.s3.model.PutObjectResult;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface IWriter {
	
	public PutObjectResult writeJson(String json,String bucketName) throws JsonProcessingException, IOException;
	
	

}
