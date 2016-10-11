package was.liberty.adminui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class vHostsView extends BasePage {

//	@FindBy(id = "collectionView-hosts-FilterBarTotalresourceFilter")
//	WebElement filterbarTotalFilter;
//	@FindBy(id = "collectionView-hosts-FilterBarSTARTEDresourceFilter")
//	WebElement filterbarRunningFilter;
//	@FindBy(id = "collectionView-hosts-FilterBarSTOPPEDresourceFilter")
//	WebElement filterbarStoppedFilter;
	// Host Center
	@FindBy(id = "collectionView-hosts-FilterBareditButton")
	WebElement hcActionsButton;
	@FindBy(id = "collectionView-hosts-FilterBarselectAllButton")
	WebElement hcFilterBarSelectAllButton;
	@FindBy(id = "collectionView-hosts-FilterBarselectNoneButton")
	WebElement hcFilterBarSelectNoneButton;
	@FindBy(id = "collectionView-hosts-actionDeployButton")
	WebElement hcActionBarDeployButton;
	@FindBy(id = "collectionView-hosts-actionMoreButton")
	WebElement hcActionBarMoreButton;
	@FindBy(id = "collectionView-hosts-maintenanceActionMenuItem")
	WebElement hcActionBarMaintenanceMenu;
	// Object View
	@FindBy(css=".sideTabOverview")
	WebElement ovSideTabOverview;
	@FindBy(css=".sideTabServers")
	WebElement ovSideTabServers;	
	@FindBy(css=".sideTabRuntimes")
	WebElement ovSideTabRuntimes;	
	
	
	public vHostsView(WebDriver driver)
	{
		super(driver);
	}
	
	
	
	// ------------------------ Hosts Center Pane ----------------------
	//
	// All functions start with "hc"
	//	
	
	public void hcClickOnHost(String hostIP)
	{
		String IP = hostIP.replace(".", "\\.");
		String host = "#collectionView-hosts-card-" +IP+ "newCard";
		String OVHP = "#OVHP-host-" + IP;
		
		clickOn(host);
		waitForElementVisible(OVHP);	
	}
	
	
	public void hcShowActionBar()
	{
		hcActionsButton.click();
	}	
	
	public void  hcDeployServerPackage()
	{
		hcShowActionBar();
		hcFilterBarSelectAllButton.click();
		hcActionBarDeployButton.click();
		String ifr = "#hostProxyPage > iframe:nth-child(1)";
		WebElement prxIF = find(ifr);
		switchToFrame(prxIF);
		waitForElementPresent("#deploymentMainDiv");
		// More tasks handled by the Deploy tool
	}
	
	public void hcShowMoreActionMenu()
	{
		hcActionBarMoreButton.click();
		waitForElementVisible("#collectionView-hosts-moreActionDropDownMenu");
	}
	
	public void  hcEnableMaintenanceModeOnAllHost()
	{
		String maintDlg = "#askEnableDisableMaintenanceMode";
		String confirmBtn = "//div[@id='askEnableDisableMaintenanceMode']/div[2]/div/div[2]/button";
		//String breakAffinityToogleButton = "#breakAffinityToogleButton";
		hcShowActionBar();
		hcFilterBarSelectAllButton.click();	
		hcActionBarMaintenanceMenu.click();
		waitForElementVisible(maintDlg);
		findByXPath(confirmBtn).click();
		hcFilterBarSelectNoneButton.click();
		hcActionsButton.click();		
	}
	
	
	public void hcShowStateBtnActionMenu(String hostIP)
	{
		String IP = hostIP.replace(".", "\\.");
		String stateBtn = "#collectionView-hosts-card-"+IP+"-stateButton";
		String stateBtnActionMenu = "#collectionView-hosts-card-" + IP
									+ "-stateButton-actionMenu";
		clickOn(stateBtn);
		waitForElementVisible(stateBtnActionMenu);
	}
	
	
	public void hcDisableMaintenanceModeOnHost(String hostIP)
	{
		String IP = hostIP.replace(".", "\\.");
		String maintMenu = "#collectionView-hosts-card-" + IP + 
				"-stateButton-actionMenu-maintenanceModeButton";
		hcShowStateBtnActionMenu(hostIP);
		clickOn(maintMenu);
	}
	
	public void hcSetTagForHost(String hostIP)
	{
		// TODO
	}
	
	
	
	// ---------------------- Individual Host View ---------------------
	
	public void gotoHostOverviewView()
	{
		ovSideTabOverview.click();
		waitForElementPresent(".objectViewHeaderPane");
	}
	
	public void gotoHostServersView()
	{
		ovSideTabServers.click();
		waitForElementPresent(".cardsPane");
	}
	
	public void gotoHostRuntimesView()
	{
		ovSideTabRuntimes.click();
		waitForElementPresent(".cardsPane");
	}	
	
	
	// -------------------------------------
	//	Overview view
	// -------------------------------------
	
	
	
	
	
	// -------------------------------------
	//	Servers view
	// -------------------------------------	
	
	
	
	
	
	// -------------------------------------
	//	Runtimes view
	// -------------------------------------	
	
	public void runtimesOnHostSetAttrDialogOpen(String hostIP)
	{
		String IP = hostIP.replace(".", "\\.");
		String WLPBase = "C\\:\\/Build\\/wlp";
		String stateBtn = "#collectionView-runtimesOnHost\\(" + IP +
				"\\)-card-" + IP + "\\," + WLPBase + "-stateButton";
		String setAttrBtn = "#collectionView-runtimesOnHost\\(" + IP +
				"\\)-card-" + IP + "\\," + WLPBase + "-stateButton-actionMenu-setAttrButton";
		clickOn(stateBtn);
		waitForElementVisible(setAttrBtn);
		clickOn(setAttrBtn);
		waitForElementVisible("#saveButton");
	}
	
	public void runtimesOnHostSetAttrDialogClose()
	{
		clickOn("#setAttrsDlg_close");
	}
	
	
	public void runtimesOnHostSetAttrTag()
	{
		// TODO
	}
	
	public void runtimesOnHostSetAttrOwner()
	{
		// TODO
	}
	
	public void runtimesOnHostSetAttrContact()
	{
		// TODO
	}
	
	public void runtimesOnHostSetAttrNotes()
	{
		// TODO
	}
	
	

	

}
