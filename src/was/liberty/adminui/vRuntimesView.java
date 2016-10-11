package was.liberty.adminui;

import org.openqa.selenium.WebDriver;



public class vRuntimesView extends BasePage {

//	@FindBy(id = "collectionView-runtimes-FilterBarTotalresourceFilter")
//	WebElement filterbarTotalFilter;
//	@FindBy(id = "collectionView-runtimes-FilterBarSTARTEDresourceFilter")
//	WebElement filterbarRunningFilter;
//	@FindBy(id = "collectionView-runtimes-FilterBarSTOPPEDresourceFilter")
//	WebElement filterbarStoppedFilter;

	
	public vRuntimesView(WebDriver driver) {
		super(driver);
	}
	
	
	
	// ---------------------- Runtimes Center Pane --------------------
	
	
	/**
	 * Click on the Runtimes card of the default host
	 * read from properties file
	 */
	public void clickRuntimeOnHost() {
		String rtCard = "#collectionView-runtimes-card-"+IPz+"\\,"+WLPBASE;
		String OVHP = "#OVHP-runtime-" +IPz+ "\\," + WLPBASE;
		clickOn(rtCard);
		waitForElementVisible(OVHP);
	}
	
	
	/**
	 * Click on the Runtimes card of the host "hostIP"
	 * @param hostIP
	 */
	public void clickRuntimeOnHost(String hostIP) {
		String IPs = hostIP.replace(".", "\\.");
		String OVHP = "#OVHP-runtime-" +IPs+ "\\," + WLPBASE;
		String rtCard = "#collectionView-runtimes-card-"+IPs+"\\,"+WLPBASE;
		clickOn(rtCard);
		waitForElementVisible(OVHP);
	}
	
	
	/**
	 * @param hostIP
	 */
	public void rcShowRuntimeActionMenu(String hostIP) {
		String IPs = hostIP.replace(".", "\\.");
		String stateIcon = "#collectionView-runtimes-card-" +IPs+ "\\,"
						 +WLPBASE+ "-stateButton-stateIcon";
		String setAttrBtn = "#collectionView-runtimes-card-" +IPs+ "\\,"
				         +WLPBASE+ "-stateButton-actionMenu-setAttrButton";
		clickOn(stateIcon);
		waitForElementPresent(setAttrBtn);
	}
	
	
	/**
	 * @param hostIP
	 */
	public void rcOpenSetAttrDialogForRuntime(String hostIP) {
		String saveBtn = "#saveButton";
		rcShowRuntimeActionMenu(hostIP);
		waitForElementPresent(saveBtn);
	}
	
	
	/**
	 * @param hostIP
	 */
	public void rcRuntimeSetAttrTagAdd(String hostIP) {
		// TODO
	}
	
	
	/**
	 * @param hostIP
	 */
	public void rcRuntimeSetAttrTagRemove(String hostIP) {
		// TODO
	}
	
	
	
	// ---------------------- Individual Runtimes view --------------------
	
	
	/**
	 * Overview view of single Runtime on default host 9.112.230.90
	 */
	public void gotoRuntimeOverview() {
		String sideTabOverview = "#\\3"+IPz+"\\,"+WLPBASE+"SideTabOverviewButton";
		String OVHP = "#OVHP-runtime-" +IPz+ "\\," + WLPBASE;
		clickOn(sideTabOverview);
		waitForElementPresent(OVHP);
	}
	
	
	/**
	 * Servers view of single Runtime on default host 9.112.230.90
	 */
	public void gotoRuntimeServers() {
		String sideTabServers = "#\\3"+IPz+"\\,"+WLPBASE+"SideTabServersButton";
		String svrOnRunitme = "#collectionView-serversOnRuntime\\(" + IPz
				            + "\\," +WLPBASE+ "\\)centerPane";
		clickOn(sideTabServers);
		waitForElementPresent(svrOnRunitme);
	}
	
	
	

}
