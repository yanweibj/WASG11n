package com.framework.util;

import java.io.IOException;

public class GUIAuto {
	private static final String EXECUTE = System.getProperty("user.dir")
			+ "/resources/gui/";
	
	
	
	/**
	 * Upload a file using the AutoIt compiled exe in command mode
	 * 
	 * @param title		the upload dialog title
	 * @param fileName	the uploaded file name
	 * @param timeout	timeout in seconds
	 */
	public static void fileUpload(String title, String fileName, int timeout) {
		String fileExec = EXECUTE + "Upload.exe";
		String cmd = "\"" + fileExec + "\" \"" + title + "\" \""
				   + fileName + "\" \""+ timeout +"\"";
		try {
			Runtime.getRuntime().exec(cmd);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Upload a file using the AutoIt compiled exe in command mode.<br>
	 * Default timeout 3 seconds.
	 * 
	 * @param title		the upload dialog title
	 * @param fileName	the uploaded file name
	 */
	public static void fileUpload(String title, String fileName) {
		fileUpload(title, fileName, 3);
	}
	
	
	
	

}
