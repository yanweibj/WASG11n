package was.common.utility;

import org.openqa.selenium.WebDriver;


public class CommonTasks {
	WebDriver driver;
	
	public CommonTasks(WebDriver driver)
	{
		this.driver = driver;
	}
	
	
	/**
	 * Pause the driver for a certain time
	 * @param seconds	time in second
	 */
	public static void sleep(int seconds) 
	{
	    try {
	        Thread.sleep(seconds * 1000);
	    } catch (InterruptedException e) {
	    	//e.printStackTrace();
	    }
	}	
	
	
	
    /**
     * If happened to see the msg "Command failed to close cleanly" in
     * console, try this method.<br> Normally, the <i>driver.close()</i>  
     * or <i>driver.quit()</i> method is enough.
     * 
     * @param driver
     */
    public static void closeDriver(WebDriver driver) 
    {    
        try{
        	driver.close();
        	Thread.sleep(6000);
        }
        catch(Exception b){
        	b.getMessage();
        }
    }	
	

}
