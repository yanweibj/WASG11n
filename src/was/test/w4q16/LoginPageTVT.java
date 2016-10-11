package was.test.w4q16;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import was.liberty.adminui.Header;
import was.liberty.adminui.LoginPage;
import was.liberty.adminui.ToolExplore;
import was.liberty.adminui.vApplicationsView;
import was.common.utility.ScreenCapture;
import was.test.basecase.BaseCase;

public class LoginPageTVT extends BaseCase {
	WebDriver driver;
	ToolExplore explore;
	vApplicationsView apps;
	ScreenCapture sc;
	String     destination;
	String     LC;
	Point p1 = new Point(0, 0);
	Point p2 = new Point(280,83);	
	
	
	@Parameters({"lang"})
	@BeforeClass
	public void beforeClass(String lang){
		driver = getDriver();
		LC     = lang;
		destination = "C:\\TVT\\WAS\\" + LC + "\\";
		LoginPage loginPage = new LoginPage(driver);
		sc      = new ScreenCapture(driver);
	}
	
	
	@Test
	public void test_01_010_010() {
		// Capture the screenshot
		String TCN = getTCNumber();
		String scr = TCN +".jpg";
		sc.TakeScreenshot(destination, scr);
	}
}
