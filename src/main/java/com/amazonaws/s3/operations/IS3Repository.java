package com.amazonaws.s3.operations;

public interface IS3Repository {
	
	public void createBucket(String name);
	
	public void deleteBucket(String name);

}
