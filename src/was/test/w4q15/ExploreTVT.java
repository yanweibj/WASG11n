package was.test.w4q15;

import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import was.liberty.adminui.Header;
import was.liberty.adminui.LoginPage;
import was.liberty.adminui.ToolExplore;
import was.liberty.adminui.Toolbox;
import was.liberty.adminui.vApplicationsView;
import was.liberty.adminui.vHostsView;
import was.common.utility.ScreenCapture;
import was.test.basecase.BaseCase;
import static was.common.utility.CommonTasks.sleep;


public class ExploreTVT extends BaseCase{	

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
		Toolbox toolbox = loginPage.login();
		explore = toolbox.gotoExplore();
		sc      = new ScreenCapture(driver);
	}
	
	@AfterClass
	public void afterClass() {
		driver.switchTo().defaultContent();
		Header header = new Header(driver);
		header.backToToolbox();
		header.logout();
	}
	
		
	@Test
	public void test_01_040_010() {
			
		// Search Application
		explore.searchObjectByType("Application");
		sleep(2);
		
		// Capture the screenshot
		String TCN = getTCNumber();
		String scr = TCN +"_"+LC+".jpg";
		sc.TakePartScreenshot(p1, 1290, 440, destination, scr);
		explore.backToDashboard();
	}
	
	@Test
	public void test_01_040_020() {
		// Open the Applications view
		apps = explore.gotoApplications();
					
		// App on cluster
		apps.clickApplicationOnCluster("App2","myCluster");
		String TCN = getTCNumber();
		String scr = TCN +"_"+LC+".jpg";
		sc.TakePartScreenshot(p1, 1290, 300, destination, scr);
	}
	
	@Test
	public void test_01_040_030() {
		// App on server
		String serverRoot = "\\(10\\.0\\.3\\.101\\,C\\:\\/Build\\/wlp\\/usr\\,member1\\)";
		String App2OnServer = "#collectionView-appInstancesByCluster\\(myCluster\\,App2\\"
							+ "(myCluster\\)\\)-card-App2" + serverRoot + "newCard";
		String App2OnServerOVHP = "#OVHP-appOnServer-App2" + serverRoot;
		apps.gotoAppInstancesView("App2");
		apps.clickOn(App2OnServer);
		apps.waitForElementVisible(App2OnServerOVHP);
		String TCN = getTCNumber();
		String scr = TCN +"_"+LC+".jpg";
		sc.TakePartScreenshot(p1, 1290, 300, destination, scr);
	}
	
	@Test
	public void test_01_040_040() {
		// Tags and Metadata
		String serverRoot = "\\(10\\.0\\.3\\.101\\,C\\:\\/Build\\/wlp\\/usr\\,member1\\)";
		String appOnServerActionBtn = "#App2" + serverRoot + "-actionButton";
		String appOnServerActionMenu = "#App2" + serverRoot + "-actionButton-actionMenu";
		String appOnServersetAttrBtn = "#App2" + serverRoot + "-actionButton-actionMenu-setAttrButton";
		
		apps.clickOn(appOnServerActionBtn);
		apps.waitForElementVisible(appOnServerActionMenu);
		apps.clickOn(appOnServersetAttrBtn);
		apps.waitForElementVisible("#saveButton");			
		sleep(1);
		
		String TCN = getTCNumber();
		String scr = TCN +"_"+LC+".jpg";
		sc.TakePartScreenshot(p2,745, 585, destination, scr);
	}
	
	@Test
	public void test_01_040_050() {
		// Add a tag
		String serverRoot = "\\(10\\.0\\.3\\.101\\,C\\:\\/Build\\/wlp\\/usr\\,member1\\)";
		String resourceToggle = "#OVHP-appOnServer-App2"+serverRoot+"-ResourceToggle_label";
		apps.fill("#newTagEditField", "atag");
		apps.fill("#newTagEditField", Keys.ENTER);
		apps.clickOn("#saveButton");
		apps.waitForElementVisible(resourceToggle);
		apps.clickOn(resourceToggle);						
		
		String TCN = getTCNumber();
		String scr = TCN +"_"+LC+".jpg";
		sc.TakePartScreenshot(p1, 1290, 340, destination, scr);
		
		// Remove the tag
		String appOnServerActionBtn = "#App2" + serverRoot + "-actionButton";
		String appOnServersetAttrBtn = "#App2" + serverRoot + "-actionButton-actionMenu-setAttrButton";
		String editBox = "#dijit_InlineEditBox_1";
		String comboBox = "#dijit_form_ComboBox_1";
		apps.clickOn(appOnServerActionBtn);
		apps.clickOn(appOnServersetAttrBtn);
		apps.waitForElementVisible("#saveButton");
		apps.clickOn(editBox);
		apps.clearText(comboBox);
		apps.clickOn("#saveButton");
		sleep(1);
		explore.backToDashboard();
	}	
	
	@Test
	public void test_01_040_060() {
		// Hosts view
		vHostsView host = explore.gotoHosts();
		
		// Host Center pane
		String hostIP = "9.111.139.36";
		host.hcClickOnHost(hostIP);
		host.gotoHostRuntimesView();
		host.runtimesOnHostSetAttrDialogOpen(hostIP);
		sleep(1);		
		
		String TCN = getTCNumber();
		String scr = TCN +"_"+LC+".jpg";
		sc.TakePartScreenshot(p2,745, 585, destination, scr);
		
		host.runtimesOnHostSetAttrDialogClose();
		explore.backToDashboard();
	}	

}
