package com.amazonaws.s3.opertaions;

public interface IS3Repository {
	
	public void createBucket(String name);
	
	public void deleteBucket(String name);

}
