package com.framework.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropUtil {
	private static Properties properties = null;
	
	public PropUtil(String path) {
		initialize(path);
	}
	
	private void initialize(String path) {
		InputStream is = getClass().getClassLoader().getResourceAsStream(path);
		if (is == null) {
			return;
		}
		properties = new Properties();
		try {
			properties.load(is);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (is != null) {
					is.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	
	/**
	 * Get specified key in config file
	 * 
	 * @param key	the key name to get value
	 * @return		return the value of the specified key
	 * 			  
	 */
	public String get(String key) {
		String keyValue = null;
		if(properties.containsKey(key)) {
			keyValue = (String) properties.get(key);
		}
		return keyValue;
	}
	
}
