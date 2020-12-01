package com.amazonaws.s3.core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import com.amazonaws.s3.opertaions.IReader;
import com.amazonaws.services.s3.model.S3Object;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

public class S3Reader implements IReader{
	

	public String readJson(String bucket,String key) throws JsonParseException, JsonMappingException, IOException  {
		S3Object object = S3ClientProvider.AmazonS3Client().getObject(bucket, key);
		String json = parseString(object.getObjectContent());
		return json;
	}
	
	   private  String parseString(InputStream input) throws IOException {
	        BufferedReader reader = new BufferedReader(new InputStreamReader(input));
	        String line ;
	        StringBuilder builder = new StringBuilder();
	        while ((line = reader.readLine())!=null) {
	            builder.append(line);
	            System.out.println("    " + line);
	        }
	       // System.out.println(builder.toString());
	        return builder.toString();
	    }

}
