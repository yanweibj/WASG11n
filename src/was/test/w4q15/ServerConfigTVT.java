package was.test.w4q15;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import was.liberty.adminui.LoginPage;
import was.liberty.adminui.Toolbox;
import was.liberty.adminui.ToolServerConfig;
import was.common.utility.ScreenCapture;
import was.test.basecase.BaseCase;

import static was.common.utility.CommonTasks.sleep;


public class ServerConfigTVT extends BaseCase {

	WebDriver driver;
	WebElement dlg;
	ToolServerConfig serverConfig;
	ScreenCapture sc;
	String    destination;
	String    LC;
	Point p = new Point(350, 51);	
	
	
	@Parameters({"lang"})
	@BeforeClass
	public void beforeClass(String lang) {
		driver = getDriver();
		LC          = lang;
		destination = "C:\\TVT\\WAS\\" + LC + "\\";
		sc          = new ScreenCapture(driver);
		LoginPage loginPage = new LoginPage(driver);
		Toolbox     toolbox = loginPage.login();
		serverConfig = toolbox.gotoServerConfig();
		sleep(1);
	}
	
	@AfterClass
	public void afterClass() {
		// Close the server.xml editor
		serverConfig.closeEditorDontSave();
		
	}
	
	
	@Test
	public void test_01_020_010() {
		serverConfig.clickServer1();
		String scr = "01.030.010_"+LC+".jpg";
		sc.TakeScreenshot(destination, scr);
				
	}
	
	
	// ------------------- Add Child -------------------
	// Verify the Add Child dialog elements are properly translated
	
	@Test
	public void test_01_020_100(){
		serverConfig.clickServerXML();
		serverConfig.addChildDialogOpen();
		dlg = serverConfig.find("div.modal-dialog:nth-child(2)");
		serverConfig.scrollIntoView(dlg);
		serverConfig.buildHashMap();
		
		// BELL
		serverConfig.addChildDialogSelectElement("bell");	
		sc.tvtTakeScreenshot(p, 605, 614, destination, LC);
	}
	
	@Test
	public void test_01_020_125(){
		// Collective Controller
		serverConfig.addChildDialogSelectElement("collectiveController");	
		sc.tvtTakeScreenshot(p, 605, 614, destination, LC);
	}
	
	@Test
	public void test_01_020_135(){
		// Configuration Management
		serverConfig.addChildDialogSelectElement("config");
		sc.tvtTakeScreenshot(p, 605, 614, destination, LC);
	}
	
	@Test
	public void test_01_020_140(){
		// Connection Factory
		serverConfig.addChildDialogSelectElement("connectionFactory");
		sc.tvtTakeScreenshot(p, 605, 614, destination, LC);
	}
	
	@Test
	public void test_01_020_150(){
		// Contexts And Dependency Injection (CDI) V1.2
		serverConfig.addChildDialogSelectElement("cdi12");
		sc.tvtTakeScreenshot(p, 605, 614, destination, LC);
	}
	
	@Test
	public void test_01_020_155(){
		// CouchDB
		serverConfig.addChildDialogSelectElement("couchdb");
		sc.tvtTakeScreenshot(p, 605, 614, destination, LC);
	}
	
	@Test
	public void test_01_020_180(){
		// DeployVariable
		serverConfig.addChildDialogSelectElement("deployVariable");
		sc.tvtTakeScreenshot(p, 605, 614, destination, LC);
	}
	
	@Test
	public void test_01_020_195(){
		// EJB Application
		serverConfig.addChildDialogSelectElement("ejbApplication");	
		sc.tvtTakeScreenshot(p, 605, 614, destination, LC);
	}
	
	@Test
	public void test_01_020_230(){
		// Fileset
		serverConfig.addChildDialogSelectElement("fileset");
		sc.tvtTakeScreenshot(p, 605, 614, destination, LC);
	}
	
	@Test
	public void test_01_020_245(){
		// Host Access
		serverConfig.addChildDialogSelectElement("hostAccess");
		sc.tvtTakeScreenshot(p, 605, 614, destination, LC);
	}
	
	@Test
	public void test_01_020_300(){
		// HTTP Whiteboard
		serverConfig.addChildDialogSelectElement("httpWhiteboard");	
		sc.tvtTakeScreenshot(p, 605, 614, destination, LC);
	}
	
	@Test
	public void test_01_020_365(){
		// JDBC Driver
		serverConfig.addChildDialogSelectElement("jdbcDriver");
		sc.tvtTakeScreenshot(p, 605, 614, destination, LC);
	}
	
	@Test
	public void test_01_020_375(){
		// JMS Connection Factory
		serverConfig.addChildDialogSelectElement("jmsConnectionFactory");
		sc.tvtTakeScreenshot(p, 605, 614, destination, LC);
	}
	
	@Test
	public void test_01_020_460(){
		// LTPA Token
		serverConfig.addChildDialogSelectElement("ltpa");
		sc.tvtTakeScreenshot(p, 605, 614, destination, LC);
	}
	
	@Test
	public void test_01_020_510(){
		// Monitor
		serverConfig.addChildDialogSelectElement("monitor");
		sc.tvtTakeScreenshot(p, 605, 614, destination, LC);
	}
	
	@Test
	public void test_01_020_540(){
		// Object Request Broker (ORB)
		serverConfig.addChildDialogSelectElement("orb");
		sc.tvtTakeScreenshot(p, 605, 614, destination, LC);
	}
	
	@Test
	public void test_01_020_570(){
		// OSGi Applications Bundle Repository
		serverConfig.addChildDialogSelectElement("bundleRepository");
		sc.tvtTakeScreenshot(p, 605, 614, destination, LC);
	}
	
	@Test
	public void test_01_020_585(){
		// Real-Time Communications
		serverConfig.addChildDialogSelectElement("rtcomm");
		sc.tvtTakeScreenshot(p, 605, 614, destination, LC);
	}
	
	@Test
	public void test_01_020_590(){
		// Remote File Access
		serverConfig.addChildDialogSelectElement("remoteFileAccess");
		sc.tvtTakeScreenshot(p, 605, 614, destination, LC);
	}
	
	@Test
	public void test_01_020_640(){
		// Scaling Member
		serverConfig.addChildDialogSelectElement("scalingMember");
		sc.tvtTakeScreenshot(p, 605, 614, destination, LC);
	}
	
	@Test
	public void test_01_020_740(){
		// Trust Association Interceptor
		serverConfig.addChildDialogSelectElement("trustAssociation");
		sc.tvtTakeScreenshot(p, 605, 614, destination, LC);
	}
	
	@Test
	public void test_01_020_760(){
		// Virtual Host
		serverConfig.addChildDialogSelectElement("virtualHost");
		sc.tvtTakeScreenshot(p, 605, 614, destination, LC);
	}
	
	@Test
	public void test_01_020_775(){
		// WAS WebSocket Outbound
		serverConfig.addChildDialogSelectElement("wsocOutbound");
		sc.tvtTakeScreenshot(p, 605, 614, destination, LC);
	}
	
	@Test
	public void test_01_020_790(){
		// Web Container Application Security
		serverConfig.addChildDialogSelectElement("webAppSecurity");	
		sc.tvtTakeScreenshot(p, 605, 614, destination, LC);
	}
	
	@Test
	public void test_01_020_795(){
		// WebSphere Cluster Manager
		serverConfig.addChildDialogSelectElement("clusterPluginConfig");
		sc.tvtTakeScreenshot(p, 605, 614, destination, LC);
	}
	
	// ------------------- Sub child -------------------
	
	@Test
	public void test_01_050_010(){
		// Feature Authorization Role Mapping > Security Role
		serverConfig.addChildDialogSelectElement("authorization-roles");
		serverConfig.addChildDialogAdd();
		sleep(1);
		serverConfig.addChildDialogOpen();  //Only one sub-element, selected by default
		serverConfig.scrollIntoView(dlg);
		sc.tvtTakeScreenshot(p, 605, 614, destination, LC);
		
		serverConfig.addChildDialogClose();
		serverConfig.removeChildElement();
		sleep(1);
	}
	
	@Test
	public void test_01_050_020(){
		// Stack Group > DeployVariable
		serverConfig.addChildElement("stackGroup");
		sleep(1);
		serverConfig.addChildDialogOpen();
		serverConfig.scrollIntoView(dlg);
		serverConfig.addChildDialogSelectElement2("deployVariable");
		sc.tvtTakeScreenshot(p, 605, 614, destination, LC);
		
		serverConfig.addChildDialogClose();
		serverConfig.removeChildElement();
		sleep(1);
	}
	
	@Test
	public void test_01_050_030(){
		// User Registry Federation > Primary Realm
		serverConfig.addChildElement("federatedRepository");
		sleep(1);
		serverConfig.addChildDialogOpen();
		serverConfig.scrollIntoView(dlg);
		serverConfig.addChildDialogSelectElement2("primaryRealm");
		sc.tvtTakeScreenshot(p, 605, 614, destination, LC);
		
		serverConfig.addChildDialogClose();
		serverConfig.removeChildElement();
		sleep(1);
	}
	
	@Test
	public void test_01_050_040() {
		// WS-Security Provider > SAML Token Properties
		serverConfig.addChildElement("wsSecurityProvider");
		sleep(1);
		serverConfig.addChildDialogOpen();
		serverConfig.scrollIntoView(dlg);
		serverConfig.addChildDialogSelectElement2("samlToken");
		sc.tvtTakeScreenshot(p, 605, 614, destination, LC);
		
		// Add this element for next test case
		serverConfig.addChildDialogAdd();
		sleep(1);
	}
	
	@Test
	public void test_01_050_050() {
		// SAML Token Properties > The audience restrictions
		serverConfig.addChildDialogOpen();
		serverConfig.scrollIntoView(dlg);
		sc.tvtTakeScreenshot(p, 605, 614, destination, LC);
		
		serverConfig.addChildDialogClose();
		serverConfig.removeChildElement(); // SAML Token Properties
		sleep(1);
		serverConfig.removeChildElement(); // WS-Security Provider
		sleep(1);
	}
	
	
}
