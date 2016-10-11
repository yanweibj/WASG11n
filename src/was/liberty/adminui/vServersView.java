package was.liberty.adminui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static was.common.utility.CommonTasks.sleep;


public class vServersView extends BasePage {
	WebDriver driver;
	
//	@FindBy(id = "collectionView-servers-FilterBarTotalresourceFilter")
//	WebElement filterbarTotalFilter;
//	@FindBy(id = "collectionView-servers-FilterBarSTARTEDresourceFilter")
//	WebElement filterbarRunningFilter;
//	@FindBy(id = "collectionView-servers-FilterBarSTOPPEDresourceFilter")
//	WebElement filterbarStoppedFilter;
	// Server Center
	@FindBy(id = "collectionView-servers-FilterBareditButton")
	WebElement scActionsButton;
	@FindBy(id = "collectionView-servers-FilterBarselectAllButton")
	WebElement scFilterBarSelectAllButton;
	@FindBy(id = "collectionView-servers-FilterBarselectNoneButton")
	WebElement scFilterBarSelectNoneButton;
	@FindBy(id = "collectionView-servers-actionStartButton")
	WebElement scActionBarStartButton;
	@FindBy(id = "collectionView-servers-actionRestartButton")
	WebElement scActionBarRestartButton;
	@FindBy(id = "collectionView-servers-actionStopButton")
	WebElement scActionBarStopButton;	
	@FindBy(id = "collectionView-servers-actionMoreButton")
	WebElement scActionBarMoreButton;
	@FindBy(id = "collectionView-servers-maintenanceActionMenuItem")
	WebElement scActionBarMaintenanceMenu;
	// Object View
	@FindBy(css=".sideTabOverview")
	WebElement ovSideTabOverview;
	@FindBy(css=".sideTabInstances")
	WebElement ovSideTabApps;
	@FindBy(css=".sideTabStats")
	WebElement ovSideTabMonitor;
	@FindBy(css=".sideTabConfig")
	WebElement ovSideTabConfig;	
	
	
	public vServersView(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
	}
	
	
	
	// ---------------------- Servers Center Pane --------------------
	//
	String serverRoot = IPz + "\\," +SVRROOT+ "\\,";
	
	public void scClickOnServer(String serverName)
	{
		String svr = "#collectionView-servers-card-" 
				   + serverRoot + serverName;
		clickOn(svr);
		waitForElementVisible(".objectViewHeaderPane");
	}
	
	
	public void scShowActionBar()
	{
		scActionsButton.click();
	}

	public void scSelectAllServers()
	{
		scFilterBarSelectAllButton.click();
	}
	
	// When all servers are selected, call this method
	// to deselect the specified servers <serverName>.
	public void scDeselectServer(String[] serverName)
	{
		if(serverName.length > 0)
		{
			for(int i=0; i < serverName.length; i++)
			{
				String svr = "#collectionView-servers-card-" + serverRoot
						   + serverName[i] + "selectedPane";
				clickOn(svr);				
			}
		}

	}
	
	private void scHideActionBar()
	{
		scFilterBarSelectNoneButton.click();
		scActionsButton.click();
	}
	
	private void scActionConfirm()
	{
		String confirmBtn = ".confirmOkButton";
		waitForElementPresent(confirmBtn);
		clickOn(confirmBtn);
		sleep(3);
	}
	
	//String startBtn = "#collectionView-servers-actionStartButton-startAction";
	//String restartBtn = "#collectionView-servers-actionRestartButton-restartAction";
	//String stopBtn = "#collectionView-servers-actionStopButton-stopAction";
	
	/**
	 * Start all (or some of) servers. Provide the server names in the 
	 * argument array to specify which servers you don't want to start.
	 * By default all servers will be started.
	 * 
	 * @param excludeServer The server names which won't be started
	 */
	public void scActionStartServers(String[] excludeServer)
	{
		scShowActionBar();
		scSelectAllServers();
		scDeselectServer(excludeServer);
		
		scActionBarStartButton.click();
		scActionConfirm();
		scHideActionBar(); 
	}

	public void scActionRestartServers(String[] excludeServer)
	{
		scShowActionBar();
		scSelectAllServers();
		scDeselectServer(excludeServer);
		
		scActionBarRestartButton.click();
		scActionConfirm();
		scHideActionBar(); 
	}	

	public void scActionStopServers(String[] excludeServer)
	{
		scShowActionBar();
		scSelectAllServers();
		scDeselectServer(excludeServer);
		
		scActionBarStopButton.click();
		scActionConfirm();
		scHideActionBar(); 
	}	
	
	
	public void scShowMoreActionMenu()
	{
		scActionBarMoreButton.click();
		waitForElementVisible(".dropDownActionButtons");
	}
	
	public void scOpenMaintenanceConfirmDialog()
	{
		scShowMoreActionMenu();
		scActionBarMaintenanceMenu.click();
		waitForElementVisible(".confirmOkButton");
	}
	
	/**
	 * Enable maintenance mode on servers. Provide the server names in the
	 * argument array to specify which servers you don't want to enable MT
	 * Mode on. If an empty array passed, all servers will be affected.
	 * 
	 * @param excludeServer
	 */
	public void scEnableMaintenanceModeOnServers(String[] excludeServer)
	{
		scShowActionBar();
		scSelectAllServers();
		scDeselectServer(excludeServer);
		scOpenMaintenanceConfirmDialog();
		scActionConfirm();
		scHideActionBar(); 
	}
	
	public void scDisableMaintenanceModeOnServer(String serverName)
	{
		String maintBtn = "#collectionView-servers-card-" + serverRoot
			   + serverName + "-stateButton-actionMenu-maintenanceModeButton";
		scShowSateButtonActionsMenu(serverName);
		clickOn(maintBtn);
		sleep(3);
	}
	
	public void scShowSateButtonActionsMenu(String serverName)
	{
		String stateBtn = "#collectionView-servers-card-" + serverRoot
				        + serverName + "-stateButton";
		clickOn(stateBtn);
		waitForElementPresent(".actionMenu");	
	}
	
	
	
	
	
	// ---------------------- Individual Server View ---------------------	
	
	
	public void gotoServerOverview()
	{
		ovSideTabOverview.click();
		waitForElementPresent(".objectViewHeaderPane");
	}
	
	public void gotoServerApps()
	{
		ovSideTabApps.click();
		waitForElementPresent(".cardsPane");
	}
	
	public void gotoServerMonitor()
	{
		ovSideTabMonitor.click();
		waitForElementPresent(".displayGraph");
	}	
		
	public void gotoServerConfigure()
	{
		ovSideTabConfig.click();
		waitForElementPresent("#mainContainer");
	}	
	
	
	
	
	
	
	

}
