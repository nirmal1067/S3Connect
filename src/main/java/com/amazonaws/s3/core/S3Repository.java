package com.amazonaws.s3.core;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.s3.opertaions.IS3Repository;

public class S3Repository implements IS3Repository {

	public void createBucket(String name) throws AmazonServiceException, AmazonClientException {

		try {
			S3ClientProvider.AmazonS3Client().createBucket(name);
		} catch (AmazonServiceException amazonServiceException) {

		} catch (AmazonClientException e) {

		}

	}

	public void deleteBucket(String name) throws AmazonServiceException, AmazonClientException {

		try {
			S3ClientProvider.AmazonS3Client().deleteBucket(name);
		} catch (AmazonServiceException amazonServiceException) {

		} catch (AmazonClientException e) {

		}

	}

}
