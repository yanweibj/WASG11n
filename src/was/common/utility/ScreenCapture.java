package was.common.utility;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class ScreenCapture {
	private WebDriver driver;
	
	public ScreenCapture(WebDriver driver)
	{
		this.driver = driver;
	}
	
	
	/**
	 * Capture screenshot of the current page.
	 * 
	 * @param destination	a place where the screenshot saved to
	 * @param fileName		the screenshot name		
	 */
	public void TakeScreenshot(String destination, String fileName)
	{		
		try {
			// Capture the whole page
			File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);			
			// Save it to a file
			FileUtils.copyFile(screenshot, new File(destination + fileName));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	/**
	 * Capture part of the page by the given start point, width and height.
	 * 
	 * @param point			the start point to capture screenshot
	 * @param width			the width of the screenshot 
	 * @param height		the height of the screenshot
	 * @param destination	the screenshot saving place
	 * @param fileName		the screenshot name
	 */
	public void TakePartScreenshot(Point p, int w, int h, 
			                       String destination, String fileName) 
	{
		// Capture the whole page
		File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		BufferedImage fullImg = null;
		try {
			fullImg = ImageIO.read(screenshot);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		//Crop the full page screenshot to get the desired part
		BufferedImage targetScreen = fullImg.getSubimage(p.getX(), p.getY(), w, h);
		
		// Save the image to a file
		try {
			ImageIO.write(targetScreen, "png", screenshot);
			FileUtils.copyFile(screenshot, new File(destination + fileName));
		} catch (IOException e2) {
			e2.printStackTrace();
		}	
	}
	
	
	/**
	 * Capture a specific element only
	 * 
	 * @param elem			the element to be captured
	 * @param destination	the screenshot saving place
	 * @param fileName		the screenshot name
	 */
	public void TakePartScreenshot(WebElement elem, String destination, String fileName) 
	{
		//Get the location of element on the page
		Point point = elem.getLocation();
		//Get width and height of the element
		int width = elem.getSize().getWidth();
		int height = elem.getSize().getHeight();
		
		TakePartScreenshot(point, width, height, destination, fileName);
	}
	
	
	/**
	 * Capture a specific element only
	 * 
	 * @param locator		the css selector of the element
	 * @param destination
	 * @param fileName
	 */
	public void TakePartScreenshot(String locator, String destination, String fileName) 
	{
		WebElement elem = driver.findElement(By.cssSelector(locator));
		Point point = elem.getLocation();
		int width = elem.getSize().getWidth();
		int height = elem.getSize().getHeight();
		TakePartScreenshot(point, width, height, destination, fileName);
	}
	
	
	
	/**
	 * Specialized for TVT screen capture of the whole page. Screenshot name
	 * is automatically generated with the test cane number XX.XXX.XXX.jpg
	 * 
	 * @param destination
	 */
	public void tvtTakeScreenshot(String destination)
	{	
		// Construct the screenshot name with test case number
		String methodName = Thread.currentThread().getStackTrace()[3].getMethodName();
		String TCNumber = methodName.replace("_", ".").replace("test.", "");		
		String fileName = TCNumber +".jpg";
		
		TakeScreenshot(destination, fileName);
	}
	
	
	/**
	 * Specialized for TVT screen capture of the whole page. Screenshot name
	 * is automatically generated with test cane number and language code: 
	 *   XX.XXX.XXX_NNN.jpg
	 * @param destination
	 * @param LC
	 */
	public void tvtTakeScreenshot(String destination, String LC)
	{	
		// Construct the screenshot name with test case number
		String methodName = Thread.currentThread().getStackTrace()[3].getMethodName();
		String TCNumber = methodName.replace("_", ".").replace("test.", "");		
		String fileName = TCNumber +"_"+LC+".jpg";
		
		TakeScreenshot(destination, fileName);
	}
	
	
	
	/**
	 * Specialized for TVT screen capture. File name with testcase number + langCode.
	 * 
	 * @param p
	 * @param w
	 * @param h
	 * @param destination
	 * @param LC
	 */
	public void tvtTakeScreenshot(Point point,int width,int height,String destination,String LC) 
	{
		// Construct the screenshot name with test case number + LangCode
		String methodName = Thread.currentThread().getStackTrace()[3].getMethodName();
		String TCNumber = methodName.replace("_", ".").replace("test.", "");		
		String fileName = TCNumber +"_"+LC+".jpg";
		
		TakePartScreenshot(point, width, height, destination, fileName);
	}
	
	
	/**
	 * Specialized for TVT screen capture. File name with testcase number only.
	 * 
	 * @param p
	 * @param w
	 * @param h
	 * @param destination
	 */
	public void tvtTakeScreenshot(Point point,int width,int height,String destination) {
		// Screenshot file name with test case number only
		String methodName = Thread.currentThread().getStackTrace()[3].getMethodName();
		String TCNumber = methodName.replace("_", ".").replace("test.", "");		
		String fileName = TCNumber +".jpg";
		
		TakePartScreenshot(point, width, height, destination, fileName);
	}
	
	
	
	/**
	 * TVT screen capture of a specified element. File name with testcase number only.
	 * 
	 * @param locator		the CSS selector
	 * @param destination
	 */
	public void tvtTakePartScreenshot(String locator, String destination) {
		// Screenshot file name with test case number only
		String methodName = Thread.currentThread().getStackTrace()[3].getMethodName();
		String TCNumber = methodName.replace("_", ".").replace("test.", "");		
		String fileName = TCNumber +".jpg";
		
		WebElement elem = driver.findElement(By.cssSelector(locator));
		Point point = elem.getLocation();
		int width = elem.getSize().getWidth();
		int height = elem.getSize().getHeight();
		TakePartScreenshot(point, width, height, destination, fileName);
	}
	
	
	/**
	 * TVT screen capture of an specified element. File name with testcase number only.
	 * 
	 * @param elem			the target element
	 * @param destination
	 */
	public void tvtTakePartScreenshot(WebElement elem, String destination) {
		// Screenshot file name with test case number only
		String methodName = Thread.currentThread().getStackTrace()[2].getMethodName();
		String TCNumber = methodName.replace("_", ".").replace("test.", "");		
		String fileName = TCNumber +".jpg";
		
		Point point = elem.getLocation();
		int width = elem.getSize().getWidth();
		int height = elem.getSize().getHeight();
		TakePartScreenshot(point, width, height, destination, fileName);
	}
	
	

}
