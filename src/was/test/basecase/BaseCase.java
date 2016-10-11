package was.test.basecase;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.framework.webdriver.DriverFactory;


public class BaseCase {
	protected static WebDriver driver;
	
	@Parameters({"locale"})
	@BeforeTest
	public void BeforeTest(String locale) {
		driver = DriverFactory.getDriver(locale);
	}
	
	@AfterTest(alwaysRun = true)
	public void AfterTest(){
		driver.quit();
	}
	
	
	public WebDriver getDriver(){
		return driver;
	}
	
	
	// Get the test case number
	public String getTCNumber(){
		String methodName = Thread.currentThread().getStackTrace()[2].getMethodName();
		String TCNumber = methodName.replace("_", ".").replace("test.", "");
		return TCNumber;
	 }
	

}
