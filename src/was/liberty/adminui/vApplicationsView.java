package was.liberty.adminui;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static was.common.utility.CommonTasks.sleep;


public class vApplicationsView extends BasePage{
	
	// Application Center
	@FindBy(id = "collectionView-applications-FilterBareditButton")
	WebElement appCenterActionsButton;
	@FindBy(id = "collectionView-applications-FilterBarselectAllButton")
	WebElement actionBarSelectAllButton;
	@FindBy(id = "collectionView-applications-FilterBarselectNoneButton")
	WebElement actionBarSelectNoneButton;
	@FindBy(id = "collectionView-applications-actionStartButton")
	WebElement actionBarStartButton;
	@FindBy(id = "collectionView-applications-actionRestartButton")
	WebElement actionBarRestartButton;
	@FindBy(id = "collectionView-applications-actionStopButton")
	WebElement actionBarStopButton;
	// Individual Object View  (not worked!)
//	@FindBy(css=".sideTabOverview")
//	WebElement sideTabOverview;
//	@FindBy(css=".sideTabInstances")	
//	WebElement sideTabInstances;
//	@FindBy(css=".sideTabStats")
//	WebElement sideTabMonitor;
	
	
	
	public vApplicationsView(WebDriver driver)
	{
		super(driver);
	}
	
	
	// ---------------------- Applications Center Pane --------------------
	//
	// Be careful of the '(', ')' and any special characters in the selector
	//
	
	 
	/**
	 * Click on an Application resides on a non-clustered server
	 * 
	 * @param appName
	 * @param serverName
	 */
	public void clickApplicationOnServer(String appName, String serverName)
	{
		String app;
		String OVHP;
		
		// App on non-clustered member "serverName"
		String serverRoot = "\\(" +IPz+ "\\," +SVRROOT+ "\\," +serverName+ "\\)";						
		app = "#collectionView-applications-card-" + appName + serverRoot;
		OVHP = "#OVHP-appOnServer-" + appName + serverRoot;			
		clickOn(app);
		waitForElementVisible(OVHP);
	}
	
	
	/**
	 * Click on an Application which resides on a cluster
	 * There may be several instances of an application
	 * 
	 * @param appName
	 * @param clusterName
	 */
	public void clickApplicationOnCluster(String appName, String clusterName)
	{
		String app = "#collectionView-applications-card-" + appName
				   + "\\(" +clusterName+ "\\)";
		String OVHP = "#OVHP-appOnCluster-"+appName+"\\("+clusterName+"\\)";
		clickOn(app);
		waitForElementVisible(OVHP);
	}
	
	// app actions
	public void appCenterShowActionBar()
	{
		appCenterActionsButton.click();
	}
	
	private void actionStart()
	{
		String startBtn = "#collectionView-applications-"
						+ "actionStartButton-startAction";
		actionBarStartButton.click();
		waitForElementVisible(startBtn);
		clickOn(startBtn);
	}
	
	private void actionRestart()
	{
		String restartBtn = "#collectionView-applications-"
						  + "actionRestartButton-restartAction";
		actionBarRestartButton.click();
		waitForElementVisible(restartBtn);
		clickOn(restartBtn);
	}
	
	private void actionStop()
	{
		String stopBtn = "#collectionView-applications-"
					   + "actionStopButton-stopAction";		
		actionBarStopButton.click();
		waitForElementVisible(stopBtn);
		clickOn(stopBtn);
	}
	
	
	public void appCenterTakeActionOnAllApps(String action)
	{
		appCenterShowActionBar();
		actionBarSelectAllButton.click();
		
		if(action.toUpperCase().equals("START"))
		{
			actionStart();
		}
		else if(action.toUpperCase().equals("RESTART"))
		{
			actionRestart();
		}
		else if(action.toUpperCase().equals("STOP"))
		{
			actionStop();
		}
		else
		{
			throw new IllegalArgumentException();
		}	
		
		actionBarSelectNoneButton.click();
		appCenterActionsButton.click();  // Hide the Actions bar
		sleep(3);  // Wait for the action to complete
	}	
	
	
	
	// ------------------- Individual Application View -----------------
	// 
	// Be careful:
	// The view is different for apps on cluster and non-clustered server
	//
	
	
	// *********** Side Tab navigation ***********
	
	// app on cluster
	public void gotoAppOnClusterOverviewView(String appName) 
	{
		String sideTabOverview = "#" +appName+ "\\(" + CLUSTER
				+ "\\)SideTabOverviewButton";
		clickOn(sideTabOverview);
		waitForElementPresent(".objectViewHeaderPane");
	}
	
	public void gotoAppInstancesView(String appName)
	{
		//sideTabInstances.click(); // not worked
		String sideTabInstances = "#" +appName+ "\\(" +CLUSTER
								+ "\\)SideTabInstancesButton";
		clickOn(sideTabInstances);
		waitForElementPresent(".cardsPane");
	}
	
	//  app on server
	public void gotoAppOverviewView(String appName, String serverName)
	{
		//sideTabOverview.click();
		String serverRoot = "\\(" +IPz+ "\\," +SVRROOT+ "\\," +serverName+ "\\)";
		String stOverview = "#" + appName + serverRoot + "SideTabOverviewButton";
		clickOn(stOverview);
		waitForElementPresent(".objectViewHeaderPane");
	}
	
	// app on server
	public void gotoAppMonitorView(String appName, String serverName)
	{
		//sideTabMonitor.click();
		String serverRoot = "\\(" +IPz+ "\\," +SVRROOT+ "\\," +serverName+ "\\)";
		String stMonitor = "#" + appName + serverRoot + "SideTabStatsButton";
		String graphPane = "#" + appName + serverRoot + "-GraphsPane";
		clickOn(stMonitor);
		waitForElementPresent(graphPane);
	}
	
	
	// -----*----- App on clustered server -----*-----
	//
	// Application on cluster, note that most of the Selectors contain
	// the cluster name. For simplicity, clusterName is fetched from the
	// config file "config\wasliberty.properties"
	//
	// Methods naming context:
	//   OV -- All instances Overview view
	//   SV -- Single App Instance view
	//
	
	
	// ================= Overview ================= 
	
	public void appOnClusterOVShowActionMenu(String appName)
	{
		String actionBtn = "#"+appName+"\\("+CLUSTER+"\\)-actionButton";
		String actionMenu = actionBtn + "-actionMenu";
		clickOn(actionBtn);
		waitForElementVisible(actionMenu);
	}
	
	public void appOnClusterOVActionConfirm(String appName)
	{
		String OK = "#" +appName+ "\\(" + CLUSTER
					+ "\\)-actionButton-actionMenu-confirmationButton";
		waitForElementVisible(OK);
		clickOn(OK);
	}
	
	public void appOnClusterOVActionStart(String appName)
	{
		String startMenu = "#" +appName+ "\\(" + CLUSTER
						+ "\\)-actionButton-actionMenu-startButton";
		appOnClusterOVShowActionMenu(appName);
		clickOn(startMenu);
		appOnClusterOVActionConfirm(appName);
	}
	
	public void appOnClusterOVActionRetart(String appName)
	{
		String restartMenu = "#" +appName+ "\\(" + CLUSTER
						+ "\\)-actionButton-actionMenu-restartButton";
		appOnClusterOVShowActionMenu(appName);
		clickOn(restartMenu);
		appOnClusterOVActionConfirm(appName);
	}
	
	public void appOnClusterOVActionStop(String appName)
	{
		String stopMenu = "#" +appName+ "\\(" + CLUSTER
					+ "\\)-actionButton-actionMenu-stopButton";
		appOnClusterOVShowActionMenu(appName);
		clickOn(stopMenu);
		appOnClusterOVActionConfirm(appName);
	}
	
	
	// Tags and Metadata settings dialog
	
	public void appOnClusterOVSetAttrDialogOpen(String appName)
	{
		String setAttrMenu = "#" +appName+ "\\(" + CLUSTER
					+ "\\)-actionButton-actionMenu-setAttrButton";
		String saveBtn = "#saveButton";
		appOnClusterOVShowActionMenu(appName);
		clickOn(setAttrMenu);
		waitForElementVisible(saveBtn);
	}
	
	
	/**
	 * Click on "(X)" to close the dialog
	 */
	public void setAttrDialogClose()
	{
		String closeBtn = "#setAttrsDlg_close";
		clickOn(closeBtn);
	}
	
	
	
	/*
	 * Can only test a field one time. The id of the input item is
	 * assigned with a trailing number, which are increased as more
	 * items added
	 */	
	
	
	/**
	 * Add tag for an application
	 * 
	 * @param appName
	 * @param tag
	 */
	public void appOnClusterOVSetAttrTagAdd(String appName, String tag)
	{
		appOnClusterOVSetAttrDialogOpen(appName);
		find("#newTagEditField").sendKeys(tag);
		find("#newTagEditField").sendKeys(Keys.ENTER);
		clickOn("#saveButton");
	}	
	
	
	/**
	 * Remove the nth tag,  first tag: "#dijit_InlineEditBox_1" and so on.
	 * Make the tag editable first, then clear the text in it
	 * 
	 * @param appName
	 * @param nthTag		The nth tag to be removed
	 */
	public void appOnClusterOVSetAttrTagRemove(String appName, int nthTag)
	{
		String tag = "#dijit_InlineEditBox_"+nthTag;
		String editor = "#dijit_form_ComboBox_"+nthTag;
		appOnClusterOVSetAttrDialogOpen(appName);	
		sleep(1);
		find(tag).click();
		find(editor).clear();
		clickOn("#saveButton");
	}
	
	
	
	// ============ Single Instance view ============
	
	// opened from Instances view
	/**
	 * Click a instance of an Application on cluster, this will open
	 * app single instance view, which has the same structure as the 
	 * view of an app on a server. Make sure switch to the Instances
	 * tab first. 
	 * 
	 * @param appName
	 * @param serverName
	 */
	public void appOnClusterClickInstanceOnServer(String appName, String serverName) {
		String server = "\\(" +IPz+ "\\,"+SVRROOT+"\\,"+serverName+"\\)";
		String appInstance = "#collectionView-appInstancesByCluster\\("+CLUSTER+"\\,"
		                 +appName+ "\\(" +CLUSTER+ "\\)\\)-card-" + appName + server;
		String appIcon = "#"+ appName + server + "-Icon";
		clickOn(appInstance);
		waitForElementPresent(appIcon);
	}
	
	
	// -----*----- App on on-clustered server -----*-----
	
	
	
	
}
