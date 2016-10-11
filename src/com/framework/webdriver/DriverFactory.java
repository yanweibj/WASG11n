package com.framework.webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;


public class DriverFactory {
	
	/**
	 * Create a Firefox driver instance, started with the specified
	 * preferred language "locale".
	 * 
	 * @param locale	Preferred language of the Firefox instance
	 * @return			Return a Firefox driver instance
	 * 
	 */
	public static WebDriver getDriver(String locale) 
	{
		FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("intl.accept_languages", locale);
		profile.setEnableNativeEvents(true);
		WebDriver driver = new FirefoxDriver(profile);
		driver.manage().window().maximize();
		return driver;
	}
	
	
	/**
	 * Create a ChromeDriver instance, started with the specified
	 * preferred language "locale".
	 * 
	 * @param locale	Preferred language of the Chrome instance
	 * @return			Return a Chrome driver instance
	 * 
	 */
	public static WebDriver getChromeDriver(String locale)
	{
		String chromedriver = System.getProperty("user.dir")
				+"\\resources\\webdriver\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromedriver);
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--lang=" + locale);
		options.addArguments("--start-maximized");
		options.addArguments("test-type");
		ChromeDriver driver = new ChromeDriver(options);
		return driver;
	}
	
	
	/**
	 * Create an IE driver instance
	 * 
	 * @return
	 * 			return an IE driver instance
	 */
	public static WebDriver getIEDriver()
	{
		String iedriver = System.getProperty("user.dir")
				+"\\resources\\webdriver\\IEDriverServer.exe";
		System.setProperty("webdriver.ie.driver", iedriver);
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(InternetExplorerDriver
				.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
		cap.setCapability(InternetExplorerDriver.INITIAL_BROWSER_URL,"");
		cap.setCapability(CapabilityType.SUPPORTS_JAVASCRIPT,true);
		cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		InternetExplorerDriver driver = new InternetExplorerDriver(cap);
		driver.manage().window().maximize();
		return driver;
	}

	
}
