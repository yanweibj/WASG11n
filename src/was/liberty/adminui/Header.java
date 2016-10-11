package was.liberty.adminui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class Header extends BasePage {
	
	// Web Elements
	@FindBy(css=".pencilEditIcon")
	WebElement editButton;
	@FindBy(css=".profileIcon")
	WebElement profileButton;
	@FindBy(css=".backgroundTaskIcon")
	WebElement bgTaskButton;
	@FindBy(css=".filterIcon")
	WebElement searchButton;
	@FindBy(id="userNameLogoutMenuItem")
	WebElement profileMenuLogoutButton;
	@FindBy(id="preferencesMenuItem")
	WebElement profileMenuPreferencesButton;
	// Visible when under other view
	@FindBy(css=".toolboxIcon")
	WebElement toolboxIcon;
	// Visible after clicking "Edit" button
	@FindBy(css=".plusIcon")
	WebElement addToolButton;
	@FindBy(css=".doneIcon")
	WebElement doneButton;
	// Visible after clicking "Add Tool" button
	@FindBy(id="toolboxAddCatalogToolMenu")
	WebElement addToolMenu;
	@FindBy(id="toolboxAddBookmarkMenu")
	WebElement addBookmarkMenu;	
	
	
	public Header(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	
	
	// --------------------- Header Widget (left) ---------------------
	
	// Click on the Pencil edit icon
	public void clickPencilEditIcon()
	{
		editButton.click();
	}
	
	public void addTool()
	{
		addToolButton.click();
		addToolMenu.click();
		// More to be added
	}
	
	public void addBookmark()
	{
		addToolButton.click();
		addBookmarkMenu.click();
		// More to be added
	}
	
	 
	/**
	 * Go back to Toolbox. Make sure to switch the 
	 * driver to the<br> outer html first if under
	 * other tool's view.
	 */
	public void backToToolbox()
	{
		toolboxIcon.click();
		waitForElementVisible(".profileIcon");
	}	
	
	
	// --------------------- Header Widget (right) --------------------
	
	
	public void clickOnSearchButton() {
		searchButton.click();
	}
	
	public void clickOnSearchBarClearButton() {
		clickOn("#searchBoxInputClear");
	}
	
	public void clickOnSearchBarCloseButton() {
		clickOn("#cancelFiltering");
	}
	
	/**
	 * Enter some text in the input box to filter
	 * 
	 * @param text
	 */
	public void searchFor(String text) {
		clickOnSearchButton();
		fill("#secondarySearchBoxInput", text);
	}
	
	
	/**
	 * Logout Admin Center
	 */
	public void logout()
	{
		waitForElementVisible(".profileIcon");
		profileButton.click();
		profileMenuLogoutButton.click();
		waitForElementVisible("#loginButton");
	}
	
	public void showBackgroundTasks() {
		bgTaskButton.click();
		waitForElementVisible("#backgroundTaskPopupDialog");
	}
	
	
	public void showPreferencesSettings() {
		profileButton.click();
		profileMenuPreferencesButton.click();
		waitForElementVisible("#enableBidi");
	}
	
	public void clickOnHelpButton() {
		profileButton.click();
		clickOn("#helpMenuItem");
	}
	
	
	
	// --------------------- Preferences Settings ---------------------
	
	/**
	 * Enable the func "<b>Enable bidirectional support<b>"
	 * @param nthOption
	 */
	public void enableBidiSupport(int nthOption) {
		clickOn("#enableBidi");
		switch(nthOption)
		{
		case 1:
			clickOn("#textDirectionLTR");
			break;
		case 2:
			clickOn("#textDirectionRTL");
			break;
		case 3:
			clickOn("#textDirectionContextual");
			break;
		default:
			clickOn("#textDirectionContextual");
		}
	}
	
	/**
	 * Disable the func "<b>Enable bidirectional support<b>"
	 */
	public void disableBidiSupport() {
		clickOn("#enableBidi");
	}
	
}
