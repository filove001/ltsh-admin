package com.fjz.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

public class Props {
	private Properties properties = null;
	
//	public Prop(File file, String encoding) {
//		if (file == null)
//			throw new IllegalArgumentException("File can not be null.");
//		if (file.isFile() == false)
//			throw new IllegalArgumentException("File not found : " + file.getName());
//		
//		InputStream inputStream = null;
//		try {
//			inputStream = new FileInputStream(file);
//			properties = new Properties();
//			properties.load(new InputStreamReader(inputStream, encoding));
//		} catch (IOException e) {
//			throw new RuntimeException("Error loading properties file.", e);
//		}
//		finally {
//			if (inputStream != null) try {inputStream.close();} catch (IOException e) {LogKit.error(e.getMessage(), e);}
//		}
//	}
	
	
	public String get(String key) {
		return properties.getProperty(key);
	}
	
	public String get(String key, String defaultValue) {
		return properties.getProperty(key, defaultValue);
	}
}
