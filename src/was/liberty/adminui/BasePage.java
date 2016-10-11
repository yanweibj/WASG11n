package was.liberty.adminui;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.framework.util.PropUtil;

import static was.common.utility.CommonTasks.sleep;

/* *************************************************************
 * This class defines a set of generic functions that can be  
 * used by the other Page Object classes.
 * 
 * For simplicity, all the methods in this class which require
 * a locator string in its parameters list expect a cssSelector
 * as argument when being called,  except those indicated by
 * the method name, e.g. method name contains xpath, tag, etc.
 **************************************************************/


public class BasePage {
	protected static WebDriver driver;
	protected String IPz;
	protected String SVRROOT;
	protected String CLUSTER;
	protected String WLPBASE;
	protected String BASEURL;
	
	public BasePage(WebDriver driver){
		BasePage.driver = driver;
		String wlp = "config\\wasliberty.properties";
		PropUtil prop = new PropUtil(wlp);
		IPz = prop.get("HostIP").replace(".", "\\.");
		SVRROOT = prop.get("SVRROOT");
		CLUSTER = prop.get("cluster1");
		WLPBASE = prop.get("WLPBASE");
		BASEURL = prop.get("BaseUrl");
	}	
	
	
	// -------------------- Generic Functions --------------------

	/**
	 * Locate an element by cssSelector 
	 * 
	 * @param selector	 The css-selector of the element
	 * @return 			 Return a web element
	 */
	public WebElement find(String selector)
	{
		waitForElementPresent(selector, 5);
		return driver.findElement(By.cssSelector(selector));
	}
	
	/**
	 * Locate an element by xPath
	 * 
	 * @param xpath		 The element xPath	
	 * @return			 Return a web element	
	 */
	public WebElement findByXPath(String xpath)
	{
		WebDriverWait wait = (new WebDriverWait(driver, 5));
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath(xpath)));
		return driver.findElement(By.xpath(xpath));
	}
	
	/**
	 * Locate an element by tagName
	 * 
	 * @param tag	The element tag name
	 * @return		Return a web element
	 */
	public WebElement findByTag(String tag)
	{
		WebDriverWait wait = (new WebDriverWait(driver, 5));
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.tagName(tag)));
		return driver.findElement(By.tagName(tag));
	}
	 
	/**
	 * Locate elements by cssSelector
	 * 
	 * @param selector	The css-selector
	 * @return			Return a list of web elements
	 *                  that apply the same css selector
	 */
	public List<WebElement> finds(String selector)
	{
		return driver.findElements(By.cssSelector(selector));
	}	
	
	/**
	 * Locate elements by tagName
	 * 
	 * @param tag	The tag name
	 * @return		Return a list of web elements
	 *              that have the specified tag
	 */
	public List<WebElement> findsByTag(String tag)
	{
		return driver.findElements(By.tagName(tag));
	}	
	
	/**
	 * Locate elements by xPath
	 * 
	 * @param xpath
	 * @return
	 */
	public List<WebElement> findsByXPath(String xpath)
	{
		return driver.findElements(By.xpath(xpath));
	}
	
	
	/**
	 * Click on an element located by css-selector.
	 * 
	 * @param selector	The css-selector of the element
	 */
	public void clickOn(String selector)
	{
		waitForElementPresent(selector, 5);
		driver.findElement(By.cssSelector(selector)).click();
		
	}
	
	/**
	 * Click on an element
	 * 
	 * @param element	The element to be clicked
	 */
	public void clickOn(WebElement element) {
		element.click();
	}
	
	
	/**
	 * Click on a link with the specified text.
	 * 
	 * @param linkText
	 * @param timeout
	 */
	public void clickOnLink(String linkText, int timeout) {
		By byLink = By.linkText(linkText);
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions
			.presenceOfElementLocated(byLink));
		driver.findElement(byLink).click();
	}
	
	
	/**
	 * Click on a link with the specified text. Default timeout 3s.
	 * 
	 * @param linkText	&nbsp;the link text
	 * 
	 */
	public void clickOnLink(String linkText) {
		clickOnLink(linkText, 3);
	}
	
	
	/**
	 * Enter some text in the specified input field.
	 * 
	 * @param locator	&nbsp;css-selector of the input box
	 * @param text		&nbsp;&nbsp;&nbsp;&nbsp;
	 *              &nbsp;the text to be entered
	 */
	public void fill(String locator, String text)
	{
		waitForElementPresent(locator);
		driver.findElement(By.cssSelector(locator)).sendKeys(text);
	}
	
	/**
	 * Enter some text in an input filed.
	 * 
	 * @param elem
	 * @param text
	 */
	public void fill(WebElement elem, String text)
	{
		elem.sendKeys(text);
	}
	
	/**
	 * Emulate keyboard input of the specified Keys.
	 * 
	 * @param locator
	 * @param key
	 */
	public void fill(String locator, Keys key)
	{
		driver.findElement(By.cssSelector(locator)).sendKeys(key);
	}	
	
	
	/**
	 * Clear the text of an input field.
	 * 
	 * @param locator	 &nbsp;css-selector
	 */
	public void clearText(String locator){
		driver.findElement(By.cssSelector(locator)).clear();
	}
	
	/**
	 * Clear the text of a textbox.
	 * 
	 * @param elem	The textbox element
	 * 
	 */
	public void clearText(WebElement elem)
	{
		elem.clear();
	}
	
	
	/**
	 * @param locator
	 * @param time
	 */
	public void hoverOver(String locator, int time)
	{
	    Actions actions = new Actions(driver);
	    WebElement elem = find(locator);
	    actions.moveToElement(elem).perform();
	    sleep(time);
	}
	
	
	/**
	 * Hover over an element, default hover time 2s.
	 * 
	 * @param locator	The css-selector of the element
	 */
	public void hoverOver(String locator)
	{
	    Actions actions = new Actions(driver);
	    WebElement elem = find(locator);
	    actions.moveToElement(elem).perform();
	    sleep(2);
	}
	
	/**
	 * Hover over an element, default hover time 2s.
	 * 
	 * @param elem	The web element 
	 */
	public void hoverOver(WebElement elem)
	{
	    Actions action = new Actions(driver);
	    action.moveToElement(elem).perform();
	    sleep(2);
	}	
	
	 
	/**
	 * Switch to an iframe.
	 * 
	 * @param frame		The iframe element
	 */
	public void switchToFrame(WebElement frame)
	{
		driver.switchTo().frame(frame);
	}
	
	
	
	/**
	 * Scroll down the page to a particular position.
	 * 
	 * @param px	&nbsp;The distance to scroll down
	 */
	public void scrollDown(int px)
	{
		int dist;
		if(px > 0)
		{
			dist = px;
		}
		else{
			dist = (-1)*px;
		}
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("scroll(0, "+ dist +");");
	}
	
	/**
	 * Scroll up the page to a particular position.
	 * 
	 * @param px	The distance to scroll up, 
	 * 				<i>negative</i> number expected
	 *   				
	 */	
	public void scrollUp(int px)
	{
		int dist;
		if(px > 0)
		{
			dist = (-1)*px;
		}
		else{
			dist = px;
		}
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("scroll(0, "+ dist +");");
	}
	
	/**
	 * Scroll to the place where an element being displayed.
	 * 
	 * @param element
	 * 
	 */
	public void scrollIntoView(WebElement element)
	{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].scrollIntoView();", element);
	}
	
	
	/**
	 * Scroll to the bottom of a page. 
	 * 
	 */
	public void scrollToBottom()
	{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}	

	
	/**
	 * Wait for an element to present in the page.
	 * 
	 * @param locator	&nbsp;css-selector
	 * @param timeout	&nbsp;timeout in seconds
	 * 
	 */
	public void waitForElementPresent(String locator, int timeout)
	{
		By byCss = By.cssSelector(locator);
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.presenceOfElementLocated(byCss));
	}
	
	/**
	 * Wait for an element to present in the page. Default timeout 30s.
	 * 
	 * @param locator	&nbsp;css-selector
	 * 
	 */
	public void waitForElementPresent(String locator)
	{
		waitForElementPresent(locator, 30);
	}
	
	
	/**
	 * Wait for an element to be visible in the page.
	 * 
	 * @param locator	&nbsp;css-selector
	 * @param timeout	&nbsp;the timeout in seconds
	 * 
	 */
	public void waitForElementVisible(String locator, int timeout)
	{
		By byCss = By.cssSelector(locator);
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.visibilityOfElementLocated(byCss));
	}
	 
	/**
	 * Wait for an element to be visible in the page. Default timeout 30s.
	 * 
	 * @param locator	&nbsp;css-selector 
	 */
	public void waitForElementVisible(String locator)
	{
		waitForElementVisible(locator, 30);
	}
	
	
	/**
	 * Wait for an element to be visible in the page.
	 * 
	 * @param elem		&nbsp;the target element
	 * @param timeout	timeout in seconds
	 */
	public void waitForElementVisible(WebElement elem, int timeout){
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.visibilityOf(elem));
	}
	
	/**
	 * Wait for an element to be visible in the page. Default timeout 30s.
	 * 
	 * @param elem	&nbsp;the target element
	 */
	public void waitForElementVisible(WebElement elem){
		waitForElementVisible(elem, 30);
	}
	
	 
	/**
	 * Wait for an element to disappeared from the page.
	 * 
	 * @param locator
	 * @param timeout
	 */
	public void waitForElementDisappeared(String locator, int timeout)
	{
		By byCss = By.cssSelector(locator);
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(byCss));
	}
	
	/**
	 * Wait for an element to disappeared from the page. Default timeout 30s.
	 * 
	 * @param locator	&nbsp;cssSelector
	 * 
	 */
	public void waitForElementDisappeared(String locator)
	{
		waitForElementDisappeared(locator, 30);
	}
	
	
	/**
	 * Wait for an element to be clickable
	 * 
	 * @param locator	&nbsp;cssSelector
	 * @param timeout	timeout in seconds
	 */
	public void waitForElementClickable(String locator, int timeout) {
		By byCss = By.cssSelector(locator);
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.elementToBeClickable(byCss));
	}
	
	/**
	 * Wait for an element to be clickable, default timeout 5s.
	 * @param locator	&nbsp;cssSelector
	 */
	public void waitForElementClickable(String locator) {
		waitForElementClickable(locator, 5);
	}
	
	
}
