package com.amazonaws.s3.runner;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.amazonaws.s3.core.S3Reader;
import com.amazonaws.s3.core.S3Repository;
import com.amazonaws.s3.core.S3Writer;
import com.amazonaws.services.s3.model.PutObjectResult;

public class S3DemoRunner {

	private static Logger Log = LogManager.getLogger(S3DemoRunner.class.getName());

	public static void main(String[] args) {

		S3Repository repository = new S3Repository();
		String bucketName = "nirmaljson1067";
		String key = "1";
		
		//TODO uncomment this if Bucket is not present.
		// repository.createBucket(bucketName);

		String json = "{\r\n" + "   \"primaryKey\":\"1\",\r\n" + "   \"glossary\":{\r\n"
				+ "      \"title\":\"example glossary\",\r\n" + "      \"GlossDiv\":{\r\n"
				+ "         \"title\":\"S\",\r\n" + "         \"GlossList\":{\r\n" + "            \"GlossEntry\":{\r\n"
				+ "               \"ID\":\"SGML\",\r\n" + "               \"SortAs\":\"SGML\",\r\n"
				+ "               \"GlossTerm\":\"Standard Generalized Markup Language\",\r\n"
				+ "               \"Acronym\":\"SGML\",\r\n" + "               \"Abbrev\":\"ISO 8879:1986\",\r\n"
				+ "               \"GlossDef\":{\r\n"
				+ "                  \"para\":\"A meta-markup language, used to create markup languages such as DocBook.\",\r\n"
				+ "                  \"GlossSeeAlso\":[\r\n" + "                     \"GML\",\r\n"
				+ "                     \"XML\"\r\n" + "                  ]\r\n" + "               },\r\n"
				+ "               \"GlossSee\":\"markup\"\r\n" + "            }\r\n" + "         }\r\n" + "      }\r\n"
				+ "   }\r\n" + "}";

		S3Writer s3Writer = new S3Writer();

		try {
			PutObjectResult objectResult = s3Writer.writeJson(json, bucketName);

			Log.info("MetaData of successful write: " + objectResult.getMetadata().getETag());

			S3Reader reader = new S3Reader();
			String resultJson = reader.readJson(bucketName, key);

			Log.info("Fetched object details:  " + resultJson);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
