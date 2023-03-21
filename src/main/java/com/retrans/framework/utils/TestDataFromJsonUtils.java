package com.retrans.framework.utils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TestDataFromJsonUtils {

	public static void main(String args[]) throws IOException {
		List<Map<String, String>> testData = readJsonTestDataFromFile(null);

		Set<String> keys = testData.get(1).keySet();

		for (String key : keys) {
			System.out.println("key:" + key);
			System.out.println("value:" + testData.get(1).get(key));

		}

	}

	public static List<Map<String, String>> readJsonTestDataFromFile(String jsonFilePath) {
		// create instance of the ObjectMapper class to map JSON data
		ObjectMapper mapper = new ObjectMapper();
		// create instance of the File class
		File fileObj = null;

		List<Map<String, String>> testData = null;

		java.net.URL url = ClassLoader.getSystemResource(jsonFilePath);

		System.out.println("file:" + url.getFile());
		System.out.println("path:" + url.getPath());
		fileObj = new File(url.getPath());

		String jsonContent = "";

		// use try-catch block to convert JSON data into Map
		try {
			// read JSON data from file using fileObj and map it using ObjectMapper and
			// TypeReference classes
			jsonContent = FileUtils.readFileToString(fileObj, StandardCharsets.UTF_8);
			testData = (List<Map<String, String>>) mapper.readValue(jsonContent,
					new TypeReference<List<Map<String, String>>>() {
					});
			

		} catch (Exception e) {
			e.printStackTrace();

		}

		return testData;

	}

}
