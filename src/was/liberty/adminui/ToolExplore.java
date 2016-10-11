package was.liberty.adminui;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ToolExplore extends BasePage {
	
	// Web Elements
	@FindBy(id="searchButton")
	WebElement searchButton;
	@FindBy(id="breadcrumbController-mainDashboard")
	WebElement dashboardIcon;
	@FindBy(id="dashboard-Application-OverviewPane")
	WebElement dashboardAppOverviewPane;
	@FindBy(id="dashboard-Cluster-OverviewPane")
	WebElement dashboardClusterOverviewPane;
	@FindBy(id="dashboard-Host-OverviewPane")
	WebElement dashboardHostOverviewPane;
	@FindBy(id="dashboard-Server-OverviewPane")
	WebElement dashboardServerOverviewPane;
	@FindBy(id="dashboard-Runtime-OverviewPane")
	WebElement dashboardRuntimeOverviewPane;
	@FindBy(id="search-searchBoxAddPill-button")
	WebElement searchBoxAddButton;
	@FindBy(id="search-searchBoxSearch-button")
	WebElement searchBoxSearchButton;
	@FindBy(id="search-searchBoxClear-button")
	WebElement searchBoxClearButton;
	@FindBy(id="search-searchPill0_searchBy-comboBox")
	WebElement searchByComboBox;
	@FindBy(id="search-searchPill0_searchBy-dropDownMenu")
	WebElement searchByDropdownMenu;
	@FindBy(id="search-searchPill0_type-dropDownMenu")
	WebElement searchByTypeDropdownMenu;
	@FindBy(id="search-searchPill0_state-dropDownMenu")
	WebElement searchByStateDropdownMenu;
	@FindBy(id="search-searchPill0_name-input")
	WebElement searchNameInput;
	@FindBy(id="search-searchPill0_tag-input")
	WebElement searchTagInput;
	@FindBy(id="search-searchPill0_type-input")
	WebElement searchTypeInput;
	@FindBy(id="search-searchPill0_state-input")
	WebElement searchStateInput;
	
	
	
	public ToolExplore(WebDriver driver)
	{
		super(driver);
	}	

	
	
	// ----------------------- Open Object View -----------------------
	
	public vApplicationsView gotoApplications()
	{
		dashboardAppOverviewPane.click(); 
		return PageFactory.initElements(driver, vApplicationsView.class);
	}
	
	public vClustersView gotoClusters()
	{
		dashboardClusterOverviewPane.click();
		return PageFactory.initElements(driver, vClustersView.class);
	}
	
	public vServersView gotoServers()
	{
		dashboardServerOverviewPane.click();
		return PageFactory.initElements(driver, vServersView.class);
	}
	
	public vHostsView gotoHosts()
	{
		dashboardHostOverviewPane.click();
		return PageFactory.initElements(driver, vHostsView.class);
	}
	
	public vRuntimesView gotoRuntimes()
	{
		dashboardRuntimeOverviewPane.click();
		return PageFactory.initElements(driver, vRuntimesView.class);
	}
	
	
	
	// ------------------------- Search Object -------------------------
	 
	/**
	 * Select a search criteria from the drop down list
	 * @param searchCriteria
	 * 				
	 */
	private void searchBy(String searchCriteria)
	{
		List<WebElement> items = null;
		String text = searchCriteria.toLowerCase();
		
		searchBoxAddButton.click();
		searchByComboBox.click();
		items = searchByDropdownMenu.findElements(By.tagName("tr"));
		for(WebElement item : items) {
			if(item.getAttribute("id").contains(text))
			{
				item.click();
				break;
			}
		}
	}
	
	private void selectType(String type)
	{
		List<WebElement> types;
		
		searchTypeInput.click();
		types = searchByTypeDropdownMenu.findElements(By.tagName("tr"));
		for(WebElement tp : types) {
			if(tp.getAttribute("id").contains(type.toLowerCase()))
			{
				tp.click();
				break;
			}
		}
	}
	
	private void selectState(String state)
	{
		List<WebElement> states;
		if(state.equalsIgnoreCase("Running"))
		{
			state = "STARTED";
		}	
		
		searchStateInput.click();
		states = searchByStateDropdownMenu.findElements(By.tagName("tr"));
		
		for(WebElement st : states)
		{
			String stID = st.getAttribute("id").toUpperCase();
			if(stID.contains(state.toUpperCase()))
			{
				st.click();
				break;
			}
		}
	}
	
	
	public void searchObjectByName(String text)
	{
		searchButton.click();
		searchBy("Name");
		searchNameInput.sendKeys(text);
		searchBoxSearchButton.click();
	}
	
	public void searchObjectByTag(String text)
	{
		searchButton.click();
		searchBy("Tag");
		searchTagInput.sendKeys(text);
		searchBoxSearchButton.click();
	}
	
	public void searchObjectByType(String text)
	{
		searchButton.click();
		searchBy("Type");
		selectType(text);
		searchBoxSearchButton.click();
	}	
	
	public void searchObjectByState(String text)
	{
		searchButton.click();
		searchBy("State");
		selectState(text);
		searchBoxSearchButton.click();
	}	
	
	
	
	// ----------------------- Back to Dashboard -----------------------
	
	/**
	 * Go back to the Dashboard view. 
	 */
	public void backToDashboard()
	{
		dashboardIcon.click();
	}
	
	
}
