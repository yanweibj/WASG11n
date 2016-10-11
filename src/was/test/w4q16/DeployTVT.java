package was.test.w4q16;

import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.framework.webdriver.DriverFactory;

import was.liberty.adminui.Header;
import was.liberty.adminui.LoginPage;
import was.liberty.adminui.ToolDeploy;
import was.liberty.adminui.Toolbox;
import was.liberty.adminui.vApplicationsView;
import was.common.utility.ScreenCapture;
import was.test.basecase.BaseCase;
import static was.common.utility.CommonTasks.sleep;

public class DeployTVT  extends BaseCase{
	WebDriver driver;
	ToolDeploy deploy;
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
		destination = "C:\\TVT\\WAS2\\" + LC + "\\";
		sc      = new ScreenCapture(driver);
		LoginPage loginPage = new LoginPage(driver);
		Toolbox toolbox = loginPage.login();
		deploy = toolbox.gotoDeploy();
		
	}
	
	@Test
	public void test_01_020_010() {
		WebElement serverType = new WebDriverWait(driver, 10)
				.until(ExpectedConditions.visibilityOfElementLocated(By.id("server-selection")));
		sleep(1);
		serverType.click();
		WebElement LibertyType = new WebDriverWait(driver, 10)
				.until(ExpectedConditions.visibilityOfElementLocated(By.id("server-Liberty")));
		sleep(1);
		LibertyType.click();
		sleep(2);
		// Capture the screenshot
		String TCN = getTCNumber();
		System.out.println(TCN);
		String scr = TCN +".jpg";
		sc.TakeScreenshot(destination, scr);
	}
	@Test
	public void test_01_020_020() {
		WebElement serverNextBtn = new WebDriverWait(driver, 10)
				.until(ExpectedConditions.visibilityOfElementLocated(By.id("server-next-button")));
		sleep(1);
		serverNextBtn.click();
		sleep(2);
		// Capture the screenshot
		String TCN = getTCNumber();
		System.out.println(TCN);
		String scr = TCN +".jpg";
		sc.TakeScreenshot(destination, scr);
	}
	@Test
	public void test_01_020_030() {
		WebElement ServerPackage = new WebDriverWait(driver, 10)
				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[id*='deploy-'][tabindex='1']")));
		sleep(1);
		ServerPackage.click();
		sleep(2);
		// Capture the screenshot
		String TCN = getTCNumber();
		System.out.println(TCN);
		String scr = TCN +".jpg";
		sc.TakeScreenshot(destination, scr);
	}
	@Test
	public void test_01_020_040() {
		WebElement deployNextBtn = new WebDriverWait(driver, 10)
				.until(ExpectedConditions.visibilityOfElementLocated(By.id("deploy-next-button")));
		sleep(1);
		deployNextBtn.click();
		sleep(2);
		// Capture the screenshot
		String TCN = getTCNumber();
		System.out.println(TCN);
		String scr = TCN +".jpg";
		sc.TakeScreenshot(destination, scr);
	}
	@Test
	public void test_01_020_050() {
		WebElement submitDoneBtn = new WebDriverWait(driver, 10)
				.until(ExpectedConditions.visibilityOfElementLocated(By.id("submit-done-button")));
		sleep(1);
		submitDoneBtn.click();
		sleep(2);
		// Capture the screenshot
		String TCN = getTCNumber();
		System.out.println(TCN);
//		String scr = TCN +".jpg";
	
		
		for (int i = 1; i <=5 ; i++) {
			sleep(1);
			deploy.scrollDown(480*(i-1));
			sleep(2);
			sc.TakeScreenshot(destination , TCN +"_"+ i + ".jpg");
			}
	}
	@Test
	public void test_01_020_060() {
		WebElement submitDoneBtn = new WebDriverWait(driver, 10)
				.until(ExpectedConditions.visibilityOfElementLocated(By.id("deploy-selection")));
		sleep(1);
		submitDoneBtn.click();
		sleep(2);
		WebElement DockerContainer = new WebDriverWait(driver, 10)
				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[id*='deploy-'][tabindex='2']")));
		sleep(1);
		DockerContainer.click();
		sleep(2);
		// Capture the screenshot
		String TCN = getTCNumber();
		System.out.println(TCN);
		String scr = TCN +".jpg";
		sc.TakeScreenshot(destination, scr);

	}
	
	@Test
	public void test_01_020_070() {
		WebElement deployNextBtn = new WebDriverWait(driver, 10)
				.until(ExpectedConditions.visibilityOfElementLocated(By.id("deploy-next-button")));
		sleep(1);
		deployNextBtn.click();
		sleep(2);
		// Capture the screenshot
		String TCN = getTCNumber();
		System.out.println(TCN);
		String scr = TCN +".jpg";
		sc.TakeScreenshot(destination, scr);
	}
	
	@Test
	public void test_01_020_080() {
		WebElement submitDoneBtn = new WebDriverWait(driver, 10)
				.until(ExpectedConditions.visibilityOfElementLocated(By.id("submit-done-button")));
		sleep(1);
		submitDoneBtn.click();
		sleep(2);
		// Capture the screenshot
		String TCN = getTCNumber();
		System.out.println(TCN);
//		String scr = TCN +".jpg";
	
		
		for (int i = 1; i <=5 ; i++) {
			deploy.scrollDown(480*(i-1));
			sleep(3);
			sc.TakeScreenshot(destination , TCN +"_"+ i + ".jpg");
		}
	}
	
	@Test
	public void test_01_020_090() {
		WebElement serverType = new WebDriverWait(driver, 10)
				.until(ExpectedConditions.visibilityOfElementLocated(By.id("server-selection")));
		sleep(1);
		serverType.click();
		WebElement NodeType = new WebDriverWait(driver, 10)
				.until(ExpectedConditions.visibilityOfElementLocated(By.id("server-Node.js")));
		sleep(1);
		NodeType.click();
		sleep(2);
		// Capture the screenshot
		String TCN = getTCNumber();
		System.out.println(TCN);
		String scr = TCN +".jpg";
		sc.TakeScreenshot(destination, scr);
	}
	
	@Test
	public void test_01_020_100() {
		WebElement serverNextBtn = new WebDriverWait(driver, 10)
				.until(ExpectedConditions.visibilityOfElementLocated(By.id("server-next-button")));
		sleep(1);
		serverNextBtn.click();
		sleep(2);
		// Capture the screenshot
		String TCN = getTCNumber();
		System.out.println(TCN);
		String scr = TCN +".jpg";
		sc.TakeScreenshot(destination, scr);
	}
	@Test
	public void test_01_020_110() {
		WebElement ServerPackage = new WebDriverWait(driver, 10)
				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[id*='deploy-'][tabindex='1']")));
		sleep(1);
		ServerPackage.click();
		sleep(2);
		// Capture the screenshot
		String TCN = getTCNumber();
		System.out.println(TCN);
		String scr = TCN +".jpg";
		sc.TakeScreenshot(destination, scr);
	}
	@Test
	public void test_01_020_120() {
		WebElement deployNextBtn = new WebDriverWait(driver, 10)
				.until(ExpectedConditions.visibilityOfElementLocated(By.id("deploy-next-button")));
		sleep(1);
		deployNextBtn.click();
		sleep(2);
		// Capture the screenshot
		String TCN = getTCNumber();
		System.out.println(TCN);
		String scr = TCN +".jpg";
		sc.TakeScreenshot(destination, scr);
	}
	@Test
	public void test_01_020_130() {
		WebElement submitDoneBtn = new WebDriverWait(driver, 10)
				.until(ExpectedConditions.visibilityOfElementLocated(By.id("submit-done-button")));
		sleep(1);
		submitDoneBtn.click();
		sleep(2);
		// Capture the screenshot
		String TCN = getTCNumber();
		System.out.println(TCN);
//		String scr = TCN +".jpg";
	
		
		for (int i = 1; i <=5 ; i++) {
			sleep(1);
			deploy.scrollDown(480*(i-1));
			sleep(2);
			sc.TakeScreenshot(destination , TCN +"_"+ i + ".jpg");
			}
	}
	@Test
	public void test_01_020_140() {
		WebElement submitDoneBtn = new WebDriverWait(driver, 10)
				.until(ExpectedConditions.visibilityOfElementLocated(By.id("deploy-selection")));
		sleep(1);
		submitDoneBtn.click();
		sleep(2);
		WebElement DockerContainer = new WebDriverWait(driver, 10)
				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[id*='deploy-'][tabindex='2']")));
		sleep(1);
		DockerContainer.click();
		sleep(2);
		// Capture the screenshot
		String TCN = getTCNumber();
		System.out.println(TCN);
		String scr = TCN +".jpg";
		sc.TakeScreenshot(destination, scr);

	}
	
	@Test
	public void test_01_020_150() {
		WebElement deployNextBtn = new WebDriverWait(driver, 10)
				.until(ExpectedConditions.visibilityOfElementLocated(By.id("deploy-next-button")));
		sleep(1);
		deployNextBtn.click();
		sleep(2);
		// Capture the screenshot
		String TCN = getTCNumber();
		System.out.println(TCN);
		String scr = TCN +".jpg";
		sc.TakeScreenshot(destination, scr);
	}
	
	@Test
	public void test_01_020_160() {
		WebElement submitDoneBtn = new WebDriverWait(driver, 10)
				.until(ExpectedConditions.visibilityOfElementLocated(By.id("submit-done-button")));
		sleep(1);
		submitDoneBtn.click();
		sleep(2);
		// Capture the screenshot
		String TCN = getTCNumber();
		System.out.println(TCN);
//		String scr = TCN +".jpg";
	
		WebElement password = new WebDriverWait(driver, 10)
				.until(ExpectedConditions.visibilityOfElementLocated(By.id("default_inputVariable_keystorePassword")));
		password.sendKeys("abcd");
		for (int i = 1; i <=5 ; i++) {
			sleep(1);
			deploy.scrollDown(480*(i-1));
			sleep(2);
			sc.TakeScreenshot(destination , TCN +"_"+ i + ".jpg");
		}
	}
		
}
