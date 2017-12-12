package com.fjz.util;

import com.fjz.util.log.Logs;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

public class Props {
	public Props(){}
	private final static Props p=new Props();
    private static Prop prop=null;
	public class Prop{
		private Properties properties = null;
		private File file;
		private String encoding;
		public Prop(File file, String encoding) {
			if (file == null)
				throw new IllegalArgumentException("File can not be null.");
			if (file.isFile() == false)
				throw new IllegalArgumentException("File not found : " + file.getName());

			try(InputStream inputStream =  new FileInputStream(file)) {
				properties = new Properties();
				properties.load(new InputStreamReader(inputStream, encoding));
				this.encoding=encoding;
				this.file=file;
			} catch (IOException e) {
				throw new RuntimeException("Error loading properties file.", e);
			}
		}
		public String get(String key) {
			return properties.getProperty(key);
		}

		public String get(String key, String defaultValue) {
			return properties.getProperty(key, defaultValue);
		}
	}
	public static Prop use(File file, String encoding){
		prop= p.new Prop(file, encoding);
		return prop;
	}
	public static Prop use(String file){
		return use(new File(file), "UTF-8");
	}
	public static Prop use(File file){
		return use(file, "UTF-8");
	}
    public static String get(String key) {
        return prop.get(key);
    }
    public static String get(String key, String defaultValue) {
        return prop.get(key, defaultValue);
    }
}
