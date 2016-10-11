package was.test.w2q16;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import was.liberty.adminui.Header;
import was.liberty.adminui.LoginPage;
import was.liberty.adminui.ToolDeploy;
import was.liberty.adminui.ToolExplore;
import was.liberty.adminui.ToolServerConfig;
import was.liberty.adminui.Toolbox;
import was.liberty.adminui.vApplicationsView;
import was.liberty.adminui.vClustersView;
import was.liberty.adminui.vRuntimesView;
import was.liberty.adminui.vServersView;

import com.framework.webdriver.DriverFactory;

import static was.common.utility.CommonTasks.sleep;


public class TestAPI {
	
	private static WebDriver driver;
	private Toolbox toolbox;
	private String hostIP = "9.112.230.90";

	@Before
	public void setUp() throws Exception {
		String locale = "en-us";
		driver = DriverFactory.getDriver(locale);
		LoginPage loginPage = new LoginPage(driver);
		toolbox = loginPage.login();
	}

	@After
	public void tearDown() throws Exception {
		driver.switchTo().defaultContent();
		Header header = new Header(driver);
		header.backToToolbox();
		header.logout();
		driver.quit();
	}

	
	public void testServerConfig() {
		
		ToolServerConfig serverConfig = toolbox.gotoServerConfig();
		serverConfig.clickServer(1);
		serverConfig.clickServerXML();
		
		sleep(1);
		//serverConfig.selectTopNode();
		//serverConfig.updateServerDescription("new server");
//		serverConfig.setAttribute("#attribute_description", "abc");
//		serverConfig.closeEditorNoChanges();
//		serverConfig.closeDialogClose();
//		serverConfig.closeEditorDontSave();
		
//		sleep(1);
		serverConfig.toggleSourceView();
		
//		sleep(2);
//		serverConfig.toggleDesignView();
//		sleep(2);
//		serverConfig.addChildDialogOpen();
		
		sleep(2);
	}
	
	
	@Test
	public void testExplore() {
		
		ToolExplore explore = toolbox.gotoExplore();		
		vServersView server = explore.gotoServers();
			
		server.scClickOnServer("controller1");
//		server.gotoServerApps();
//		server.gotoServerMonitor();
//		server.gotoServerOverview();
//		sleep(1);
		
		explore.backToDashboard();
		
		vClustersView cluster = explore.gotoClusters();
		String clusterName = "myCluster";
		sleep(1);
		cluster.ccClickOnCluster(clusterName);
//		cluster.gotoServersOnCluster();
//		cluster.gotoAppsOnCluster();
//		cluster.gotoClusterOverview();
		explore.backToDashboard();
		sleep(1);
		
		// Applications
		vApplicationsView apps = explore.gotoApplications();
		String appName = "App2";
		
		apps.clickApplicationOnCluster(appName, clusterName);
		sleep(1);
//		apps.gotoAppInstancesView(appName);
//		apps.gotoAppOnClusterOverviewView(appName);
//		apps.gotoAppInstancesView(appName);
//		sleep(1);
//		apps.appOnClusterClickInstanceOnServer(appName, "member1");
//		sleep(1);
//		apps.gotoAppMonitorView(appName, "member1");
//		sleep(1);
//		apps.gotoAppOverviewView(appName, "member1");
		explore.backToDashboard();
		
//		vApplicationsView app = explore.gotoApplications();
//		String testApp = "testApp";
//		String serverName = "member3";
//		app.clickApplicationOnServer(testApp, serverName);
//		app.gotoAppMonitorView(testApp, serverName);
//		sleep(1);
//		app.gotoAppOverviewView(testApp, serverName);
//		explore.backToDashboard();
		
		// Runtimes
		vRuntimesView runtime = explore.gotoRuntimes();
		runtime.clickRuntimeOnHost();
		sleep(1);
		runtime.gotoRuntimeServers();
		runtime.gotoRuntimeOverview();
		sleep(1);
		explore.backToDashboard();
	}	
	
	
	
	public void testDeploy() {
		ToolDeploy deploy = toolbox.gotoDeploy();
		deploy.selectHost(hostIP);
		deploy.selectServerPackageType(1);
		
		String pkgFile = "C:\\drivers\\testAppSvr5.zip";
		//deploy.fillInRemoteSvrPackageLocation(pkgFile);
		//deploy.selectLocalSvrPackage();
		deploy.selectLocalSvrPackage("File Upload", pkgFile);
		
		sleep(3);
		deploy.clickOnCancelButton();	
	}
	

}
