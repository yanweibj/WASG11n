package com.framework.util;

//import org.apache.log4j.Logger;
//
//public class LogUtil {
//	
//	// Initialize Log4j logs
//	private static Logger Log = Logger.getLogger(Log.class.getName());
//	
//	// Print log for the beginning of the test case 
//	public static void startTestCase(String sTestCaseName)
//	{
//		int n = (44 - sTestCaseName.length())/2;
//		String seq = buildSeq(" ", n);
//		StringBuffer sb = new StringBuffer();
//		sb.append(seq);
//		sb.append(sTestCaseName);
//		sb.append(seq);
//		if( (sTestCaseName.length()%2) > 0 )
//		{	
//			sb.append(" ");
//		}
//		Log.info("****************************************************************************************"); 
//		Log.info("$$$$$$$$$$$$$$$$$$$$$$"             +sb.toString()+              "$$$$$$$$$$$$$$$$$$$$$$"); 
//		Log.info("****************************************************************************************"); 
//	}
//	 
//	//Print log for the ending of the test case 
//	public static void endTestCase(String sTestCaseName)
//	{
//		Log.info("XXXXXXXXXXXXXXXXXXXXXX                 -E---N---D-                 XXXXXXXXXXXXXXXXXXXXX");
//		Log.info("");
//		Log.info("");  
//	}
//	
//	
//	// Log the certain type of information
//	public static void info(String message) 
//	{	 
//		Log.info(message);	 
//	}
//	 
//	public static void warn(String message) 
//	{
//		Log.warn(message);	 
//	}
//	 
//	public static void error(String message) 
//	{
//		Log.error(message);	 
//	}
//	 
//	public static void fatal(String message) 
//	{
//		Log.fatal(message);
//	}
//	 
//	public static void debug(String message) 
//	{
//		Log.debug(message);	 
//	}
//	
//	
//	private static String buildSeq(String str, int len)
//	{
//		StringBuffer sb = new StringBuffer();
//		for(int i = 0; i < len; i++)
//		{
//			sb.append(str);
//		}
//		return sb.toString();
//	}
//
//}
