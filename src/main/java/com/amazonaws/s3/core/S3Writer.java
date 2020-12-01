package com.amazonaws.s3.core;

import java.io.IOException;

import com.amazonaws.s3.operations.IWriter;
import com.amazonaws.services.s3.model.PutObjectResult;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class S3Writer implements IWriter{
	
	
	private ObjectMapper mapper = new ObjectMapper();

	public PutObjectResult writeJson(String json,String bucketName) throws JsonProcessingException, IOException {
	    JsonNode actualObj = mapper.readTree(json);
	    String key = actualObj.get("primaryKey").textValue();
		PutObjectResult objectResult = S3ClientProvider.AmazonS3Client().putObject(bucketName, key, json);
		return objectResult;
	}

 
}
