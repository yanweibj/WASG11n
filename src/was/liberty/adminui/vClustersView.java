package was.liberty.adminui;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;



public class vClustersView extends BasePage {

//	@FindBy(id = "collectionView-clusters-FilterBarTotalresourceFilter")
//	WebElement filterbarTotalFilter;
//	@FindBy(id = "collectionView-clusters-FilterBarSTARTEDresourceFilter")
//	WebElement filterbarRunningFilter;
//	@FindBy(id = "collectionView-clusters-FilterBarSTOPPEDresourceFilter")
//	WebElement filterbarStoppedFilter;
	// Cluster Center
	@FindBy(id = "collectionView-clusters-FilterBareditButton")
	WebElement ccActionsButton;
	@FindBy(id = "collectionView-clusters-FilterBarselectAllButton")
	WebElement ccFilterBarSelectAllButton;
	@FindBy(id = "collectionView-clusters-FilterBarselectNoneButton")
	WebElement ccFilterBarSelectNoneButton;
	@FindBy(id = "collectionView-clusters-actionStartButton")
	WebElement ccActionBarStartButton;
	@FindBy(id = "collectionView-clusters-actionRestartButton")
	WebElement ccActionBarRestartButton;
	@FindBy(id = "collectionView-clusters-actionStopButton")
	WebElement ccActionBarStopButton;
	@FindBy(id = "collectionView-clusters-actionRestartButton-startAction")
	WebElement ccActionConfirmationDialogStartBtn;	
	@FindBy(id = "collectionView-clusters-actionRestartButton-restartAction")
	WebElement ccActionConfirmationDialogRestartBtn;
	@FindBy(id = "collectionView-clusters-actionStopButton-stopAction")
	WebElement ccActionConfirmationDialogStopBtn;
	// Single Object View
	//@FindBy(css=".sideTabOverview")
	//WebElement ovSideTabOverview;
	@FindBy(css=".sideTabServers")
	WebElement ovSideTabServers;	
	@FindBy(css=".sideTabAppsOnCluster")
	WebElement ovSideTabApps;
	
	
	
	public vClustersView(WebDriver driver)
	{
		super(driver);
	}
	
	
	
	// ---------------------- Clusters Center Pane --------------------
	//
	// All functions names start with "cc"
	//
	
	public void ccShowActionBar()
	{
		ccActionsButton.click();
	}
	
	public void ccActionBarClickStartBtn()
	{
		String dlgStartBtn = 
				"#collectionView-clusters-actionRestartButton-startAction";
		ccActionBarStartButton.click();
		waitForElementVisible(dlgStartBtn);
	}
	
	public void ccActionBarClickRestartBtn()
	{
		String dlgRestartBtn = 
				"#collectionView-clusters-actionRestartButton-restartAction";
		ccActionBarRestartButton.click();
		waitForElementVisible(dlgRestartBtn);
	}
	
	public void ccActionBarClickStopBtn()
	{
		String dlgStopBtn = 
				"#collectionView-clusters-actionStopButton-stopAction";
		ccActionBarStopButton.click();
		waitForElementVisible(dlgStopBtn);
	}	
	
	
	public void ccActionStartAllClusters()
	{
		ccShowActionBar();
		ccFilterBarSelectAllButton.click();
		ccActionBarClickStartBtn();
		ccActionConfirmationDialogStartBtn.click();
		ccFilterBarSelectNoneButton.click();
		ccShowActionBar(); // Hide the Action bar
	}
	
	public void ccActionRetartAllClusters()
	{
		ccShowActionBar();
		ccFilterBarSelectAllButton.click();
		ccActionBarClickRestartBtn();
		ccActionConfirmationDialogRestartBtn.click();
		ccFilterBarSelectNoneButton.click();
		ccShowActionBar();		
	}	

	public void ccActionStopAllClusters()
	{
		ccShowActionBar();
		ccFilterBarSelectAllButton.click();
		ccActionBarClickStopBtn();
		ccActionConfirmationDialogStopBtn.click();
		ccFilterBarSelectNoneButton.click();
		ccShowActionBar();		
	}	
	
	
	public void ccClickSateButtonOnCluster(String clusterName)
	{
		String state = "#collectionView-clusters-card-"
					 + clusterName +"-stateButton";
		clickOn(state);
		
		// The Actions pop up menu item
		//#collectionView-clusters-card-[myCluster]-stateButton-actionMenu-startButton
		//#collectionView-clusters-card-[myCluster]-stateButton-actionMenu-restartButton
		//#collectionView-clusters-card-[myCluster]-stateButton-actionMenu-stopButton
		//#collectionView-clusters-card-[myCluster]-stateButton-actionMenu-setAttrButton
		
	}
	
	
	public void ccClickOnCluster(String clusterName)
	{
		String cluster = "#collectionView-clusters-card-"+clusterName;
		String OVHP = "#OVHP-cluster-" + clusterName;
		clickOn(cluster);
		waitForElementVisible(OVHP, 15);
	}
	

	
	// ---------------------- Individual Cluster View ---------------------
	
	
	public void gotoClusterOverview()
	{
		String SideTabOverview = "#"+CLUSTER+"SideTabOverviewButton";
		String midContentPane = ".middleContentPane.dijitContentPane";
		clickOn(SideTabOverview);
		waitForElementVisible(midContentPane);
	}
	
	public void gotoServersOnCluster()
	{
		ovSideTabServers.click();
		waitForElementPresent(".cardsPane");
	}
	
	public void gotoAppsOnCluster()
	{
		ovSideTabApps.click();
		waitForElementPresent(".cardsPane");
	}
	
	
	// ----------------------------------------
	//	Object View
	//
	// Some functions name may start with "ov" 
	// ----------------------------------------
	
	private void ovShowActionMenu()
	{
		clickOn(".dijitDownArrowButton");
	}
	
	private void ovClusterActionConfirm()
	{
		clickOn(".confirmOkButton");
	}
	
	public void ovClusterActionStart(String clusterName)
	{
		String startBtn = "#" + clusterName
				+ "-actionButton-actionMenu-startButton";
		ovShowActionMenu();
		clickOn(startBtn);
		ovClusterActionConfirm();
	}
	
	public void ovClusterActionRetart(String clusterName)
	{
		String restartBtn = "#" + clusterName 
				+"-actionButton-actionMenu-restartButton";
		ovShowActionMenu();
		clickOn(restartBtn);
		ovClusterActionConfirm();
	}	

	public void ovClusterActionStop(String clusterName)
	{
		String stopBtn = "#" + clusterName
				+ "-actionButton-actionMenu-stopButton";
		ovShowActionMenu();
		clickOn(stopBtn);
		ovClusterActionConfirm();
	}
	
	public void ovClusterActionConfirmationPopupClose()
	{
		clickOn(".dijitDialogCloseIcon");
	}	
	
	
	/**
	 * Set tags and other metadata for a cluster from single cluster view
	 * @param clusterName	Cluster name
	 * @param attribute		The attribute name: Tags, Owner, Contacts, Notes
	 * @param value			The attribute value to be set
	 * @throws Exception 
	 */
	public void ovClusterActionSetAttribute(String clusterName,
			    String attribute, String value) throws Exception
	{
		String setAttrBtn = "#" + clusterName
				+ "-actionButton-actionMenu-setAttrButton";
		String saveBtn = "#saveButton";
		ovShowActionMenu();
		clickOn(setAttrBtn);
		waitForElementVisible(saveBtn);
		
		if(attribute.equalsIgnoreCase("Tags"))
		{
			ovSetAttrTags(value);
		}
		else if(attribute.equalsIgnoreCase("Owner"))
		{
			ovSetAttrOwner(value);
		}
		else if(attribute.equalsIgnoreCase("Contacts"))
		{
			ovSetAttrContacts(value);
		}
		else if(attribute.equalsIgnoreCase("Notes"))
		{
			ovSetAttrNotes(value);
		}
		else
		{
			throw new Exception("The argument "+attribute+" is invalid!");
		}
		
		clickOn(saveBtn);	
	}
	
	private void ovSetAttrTags(String tag)
	{
		String newEdit = "#newTagEditField";
		clickOn(newEdit);
		find(newEdit).sendKeys(tag);
		find(newEdit).sendKeys(Keys.ENTER);
	}

	private void ovSetAttrOwner(String text)
	{
		String newEdit = "#newOwnerEditField";
		clickOn(newEdit);
		find(newEdit).sendKeys(text);
		find(newEdit).sendKeys(Keys.ENTER);
	}
	
	private void ovSetAttrContacts(String text)
	{
		String newEdit = "#newContactEditField";
		clickOn(newEdit);
		find(newEdit).sendKeys(text);
		find(newEdit).sendKeys(Keys.ENTER);
	}
	
	private void ovSetAttrNotes(String text)
	{
		String newEdit = "#notesAttrsPane";
		clickOn(newEdit);
		find(newEdit).sendKeys(text);
	}	
	
	
	
	// -------------------------------------
	//	Servers view
	// -------------------------------------
	
	// Implemented in future if needed
	
	
	
	
	
	// -------------------------------------
	//	Apps view
	// -------------------------------------	
	
	// Implemented in future if needed
	

}
