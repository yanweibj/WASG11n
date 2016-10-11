package was.liberty.adminui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.framework.util.PropUtil;



public class ToolServerConfig extends BasePage {
	
	// -- Server list view --
	@FindBy(id="serverExplorerSearchInput")
	WebElement searchInputBox;
	@FindBy(id="serverExplorerClearButton")
	WebElement searchInputClearButton;
	@FindBy(id="serverExplorerSearchButtonIcon")
	WebElement searchButton;
	@FindBy(id="navbarChangeServerButton")
	WebElement changeServerButton;
	// -- Editor --
	@FindBy(id="navbarEditorButtonsSave")
	WebElement saveButton;
	@FindBy(id="navbarEditorButtonsClose")
	WebElement closeButton;
	@FindBy(id="editorNavigationDesignLink")
	WebElement designTab;
	@FindBy(id="editorNavigationSourceLink")
	WebElement sourceTab;
	@FindBy(id="settingsButtonLink")
	WebElement settingsButton;
	@FindBy(id="addChildButton")
	WebElement addChildButton;
	@FindBy(id="removeButton")
	WebElement removeButton;
	@FindBy(id="dialogAddChildElementOKButton")
	WebElement addChildDialogAddButton;
	@FindBy(css=".dialogEnumerationSelectButton")
	WebElement selectButton;
	@FindBy(css=".clearInputFeedbackAction")
	WebElement inputClearButton;
	@FindBy(id="dialogSaveBeforeClosingSaveButton")
	WebElement closDialogSaveButton;
	@FindBy(id="dialogSaveBeforeClosingDontSaveButton")
	WebElement closDialogDontSaveButton;
	// Add Child dialog elements
	@FindBy(css="#dialogAddChildElementListContainer > div")
	List<WebElement> elements;
	// HashMap to hold the (element-name, element) pair
	Map<String, WebElement> map = new HashMap<String, WebElement>();
	private final String CLOSEX = "div.modal-dialog:nth-child(2) > "
			+ "div:nth-child(1) > div:nth-child(1) > a:nth-child(1)";
	
	
	public ToolServerConfig(WebDriver driver) {
		super(driver);
	}
	
	
	// ------------------------ Server List ------------------------
	
	
	/**
	 * Click on the n-th server in the server list. This 
	 * function may not work sometimes.
	 * 
	 * @param nthServer
	 */
	public void clickServer(int nthServer)
	{
		String svrName = "tr.serverExplorerServerEntry:nth-child(" 
	           + nthServer +") > td:nth-child(1) > span:nth-child(1)";
		hoverOver(svrName, 1);
		clickOn(svrName);
		waitForElementDisappeared("#progress", 60);
	}
	
	
	// Use following non-parameter functions instead
	 
	/**
	 * Click on the first server -- contorller1
	 */
	public void clickServer1()
	{
		//tr1 = "tr.serverExplorerServerEntry:nth-child(1)"
		clickOn("tr.serverExplorerServerEntry:nth-child(1)");
		waitForElementDisappeared("#progress", 60);
		try {
			waitForElementPresent("#fileExplorer", 3);
		} catch (TimeoutException e) {
			driver.navigate().refresh();
			waitForElementDisappeared("#progress", 60);
		}
	}
	
	
	/**
	 * Click on the second server -- member1
	 */
	public void clickServer2()
	{
		//tr2 = "tr.serverExplorerServerEntry:nth-child(2)"
		clickOn("tr.serverExplorerServerEntry:nth-child(2)");
		waitForElementDisappeared("#progress", 60);
	}
	
	
	/**
	 * Click on the third server -- member2
	 */
	public void clickServer3()
	{
		//tr3 = "tr.serverExplorerServerEntry:nth-child(3)"
		clickOn("tr.serverExplorerServerEntry:nth-child(3)");
		waitForElementDisappeared("#progress", 60);
	}
	
	
	// Search a server
	public void searchServer(String searchText)
	{
		searchInputBox.sendKeys(searchText);
		searchButton.click();
	}
	
	// Clear the input text
	public void searchInputClear()
	{
		searchInputClearButton.click();
	}
	
	
	/**
	 * Call this method to request the Server List page directly
	 * if the server does not respond properly. 
	 */
	private void showServerList(){
		String wlp = "config\\wasliberty.properties";
		PropUtil props = new PropUtil(wlp);
		String BASE_URL = props.get("BaseUrl");
		driver.get(BASE_URL + "/adminCenter/#serverConfig/");
	}
	
	
	// ------------------------ File List ------------------------
	
	
	private void clickOnServerXml(){
		waitForElementPresent("#fileExplorer",2);
		clickOnLink("server.xml");
	}
	
	/**
	 * Click on the link <font color="blue"> 
	 * <u> server.xml </u> </font>
	 * 
	 */
	public void clickServerXML()
	{
		try {
			clickOnServerXml();
		} catch (TimeoutException e){
			changeServer();
			clickServer1();
			clickServerXML();
		}
		waitForElementVisible("#editorTree");
	}
	
	
	/**
	 * Click on the <b>Change Server</b> button
	 */
	public void changeServer()
	{	
		try {
			changeServerButton.click();
		} catch (ElementNotVisibleException e) {
			showServerList();
		}
		waitForElementPresent("#serverExplorerTableBody");
	}
	
	
	// -------------------------- Editor -------------------------- 
	
	// Toggle between Design view and Source view.
	
	/**
	 * Change to <b>Design</b> view.
	 */
	public void toggleDesignView()
	{
		designTab.click();
	}
	
	/**
	 * Change to <b>Source</b> view.
	 */
	public void toggleSourceView()
	{
		sourceTab.click();
	}
	
	
	/**
	 * Click on Settings button.
	 */
	public void clickSettingsButton()
	{
		settingsButton.click();
		waitForElementPresent("#settings");
	}
	
	
	
	// ======================== Design View ==========================
	
	
	// ------------------------- Select Node -------------------------
	
	
	/**
	 * Select the top level node. e.g. Server
	 */
	public void selectTopNode()
	{
		clickOn(".expanded");
	}
	
	 
	/**
	 * Select the first child node in the left tree
	 */
	public void selectFirstChildNode()
	{
		String nd = "#editorTree > div:nth-child(1) > div:nth-child(2)"
				+ " > div:nth-child(1)";
		clickOn(nd);
	}
	
	
	/**
	 * Select the n-th child node in the left tree. Count start
	 * from the top node.
	 * 
	 * @param n		&nbsp;the nth child node
	 */
	public void selectNthChildNode(int n)
	{
		if(n == 1) {
			selectFirstChildNode();
		}
		else
		{
			String node = "div.editorTreeNodeContainer:nth-child("+n+")";
			clickOn(node);
		}
	}
	
	
	
	// ------------------------- Add Child -------------------------
	
	/**
	 * Build (data-element-name, element) pairs to used by the
	 * addChildDialogSelectElement() method later.
	 * 
	 */
	public void buildHashMap()
	{
		for(WebElement elem : elements)
		{
			map.put(elem.getAttribute("data-element-name"), elem);
		}
	}
	
	 
	/**
	 * Open the <b>Add Child</b> dialog 
	 */
	public void addChildDialogOpen()
	{
		String ctn = "#dialogAddChildElementListContainer";
		addChildButton.click();
		waitForElementVisible(ctn);
	}

	
	/**
	 * Click (x) to close the <b>Add Child</b> dialog
	 */
	public void addChildDialogClose()
	{
		clickOn(CLOSEX);
	}
	
	
	/**
	 * Type some text in the search input box of the
	 * Add Child dialog.
	 * 
	 * @param text
	 */
	public void addChildDialogSearch(String text)
	{
		fill("#dialogAddChildElementSearch",text);
	}

	 
	/**
	 * Click on the <b>Add</b> button on the Add Child dialog
	 */
	public void addChildDialogAdd()
	{
		addChildDialogAddButton.click();
	}
	
	
	/**
	 * Select an element from the list with the given data-element-name
	 * attribute value. Call buildHashMap() before calling this method.
	 * 
	 * @param elemName	
	 * 			  the "data-element-name" attribute value.
	 *  		  See the possible attribute values in:
	 *  <pre>	  resources\data\child_elements.txt</pre>
	 *           
	 */
	public void addChildDialogSelectElement(String elemName)
	{
		/* this method is intended to be used for selecting the
		 * first level child-node element only. For other sub node
		 * elements selection, use addChildDialogSelectElement2()
		 * method instead.
		 */
		map.get(elemName).click();	
	}
	
	
	/**
	 * For sub elements selection where the total elements
	 * number is small
	 * 
	 * @param elemName	the "data-element-name" attribute
	 */
	public void addChildDialogSelectElement2(String elemName)
	{
		// Poor efficiency. But keep this method for
		// selecting sub-element where element number
		// is relatively small.
  		for(WebElement el : elements)
		{
			if(el.getAttribute("data-element-name").equals(elemName))
			{
				el.click();
				break;
			}
		}	
	}
	
	
	
	/**
	 * Add a first level child element. 
	 * 
	 * @param elemName	
	 * 			the "data-element-name" attribute value
	 */
	public void addChildElement(String elemName)
	{
		// Need to clear and re-set the hashmap
		// each time the dialog opened
		addChildDialogOpen();
		map.clear();
		this.buildHashMap();
		addChildDialogSelectElement(elemName);
		addChildDialogAdd();
	}
	
	
	/**
	 * Add a sub-node child element.
	 * 
	 * @param dataElemName	
	 * 			the "data-element-name" attribute value
	 */
	public void addChildElement2(String dataElemName)
	{
		addChildDialogOpen();
		addChildDialogSelectElement2(dataElemName);
		addChildDialogAdd();
	}	
	
	
	/**
	 * Add a Child Element with the specified element display name
	 * <p>
	 * Note that the element name may be translated under other
	 * languages pages, you need to know the exact translation
	 * of each element if write test script with this method.
	 * </p>
	 * 
	 * @param element	The element display name
	 */
	public void addChildElement3(String element)
	{
		addChildDialogOpen();
		addChildDialogSearch(element);
		addChildDialogAdd();
	}	
	
	
	/**
	 * Remove a Child element, make sure the element is selected
	 * first
	 * 
	 * @param elem
	 */
	public void removeChildElement()
	{
		try {
			String removeConf= "#dialogRemoveElementOKButton";
			waitForElementClickable("#removeButton");
			removeButton.click();
			waitForElementVisible(removeConf);
			clickOn(removeConf);
		} catch(TimeoutException e) {
			System.out.println("The element can not be removed!");
			e.printStackTrace();
		}
	}
	
	
	
	// -------------------------- Select --------------------------
	
	 
	/**
	 * Open the <b>Select</b> dialog
	 */
	public void selectDialogOpen()
	{
		selectButton.click();
		waitForElementVisible("#dialogEnumerationSelectListContainer");
	}
	
	
	/**
	 * The action of selecting the n-th option on the
	 * <b>Select</b> dialog
	 * @param n	&nbsp;the n-th option
	 */
	public void selectOptionN(int n)
	{
		String opt = "div.enumerationOption:nth-child(" + n + ")";
		clickOn(opt);
	}
	
	
	/**
	 * Select an option as the corresponding field value
	 * 
	 * @param nthOption	&nbsp;the n-th option
	 */
	public void selectOptionAsAttrValue(int nthOption)
	{
		selectDialogOpen();
		selectOptionN(nthOption);
		clickOn("#dialogEnumerationSelectOKButton");//Select
	}
	
	 
	/**
	 * Click the (x) to close the <b>Select</b> dialog
	 */
	public void selectDialogClose()
	{
		clickOn(CLOSEX);
	}
	
	
	// ------------------------- Input Box -------------------------	
	
	
	/**
	 * Set value for an attribute. See the possible attrID in:
	 * 	<font color='blue'>resources\data\xmleditor.txt</font>
	 * 
	 * @param attrID     the #id of the attribute input field
	 * @param attrValue
	 */
	public void setAttribute(String attrID,String attrValue)
	{
		fill(attrID, attrValue);
	}
	
	
	/**
	 * Clear the text of an input field. Applied when
	 * there is only one input field on the page.
	 */
	public void clearAttrValue()
	{
		inputClearButton.click();
	}
	
	
	/**
	 * Clear the nth attribute value if the filed is editable
	 * 
	 * @param n	&nbsp;the n-th attribute
	 */
	public void clearAttrValue(int n) {
		String clr = "div.form-group:nth-child("+n+") > div:nth-child(2)"
				+ " > a:nth-child(2) > img:nth-child(1)";
		clickOn(clr);
	}
	

	/**
	 * Update the Server Description, make sure to select the
	 * Server entry first.
	 * 
	 * @param serverDesc
	 */
	public void updateServerDescription(String serverDesc) {
		clearAttrValue(); // Clear the old desc first
		fill("#attribute_description", serverDesc);
		saveChanges();
	}
	
	
	// ------------------------- Save Changes -------------------------
	
	/**
	 * Click <b>Save</b> button to save changes to the server.xml
	 */
	public void saveChanges()
	{
		try {
			waitForElementClickable("#navbarEditorButtonsSave");
			saveButton.click();
		} catch(WebDriverException e) {
			System.out.println("There is no changes to save.");
			//e.printStackTrace();
		}
	}
	
	
	/**
	 * Click the <b>Close</b> button while there are changes to
	 * the server.xml, a confirm dialog will opened.
	 */
	public void closeDialogOpen()
	{
		String SaveBtn ="#dialogSaveBeforeClosingSaveButton";
		closeButton.click();
		waitForElementVisible(SaveBtn);
	}
	
	
	/**
	 * Click on the (x) to close the confirmation dialog
	 */
	public void closeDialogClose(){
		clickOn(CLOSEX);
	}
	
	
	/**
	 * Click on <b>Close</b> and then <b>Save</b> button
	 * to save changes and close the xml editor.
	 */
	public void closeEditorSaveChanges()
	{
		closeDialogOpen();
		closDialogSaveButton.click();
	}
	
	
	/**
	 * Click on <b>Close</b> and then <b>Don't Save</b> button
	 * to close the xml editor without saving changes.
	 */
	public void closeEditorDontSave()
	{
		closeDialogOpen();
		closDialogDontSaveButton.click();
	}
	
	 
	/**
	 * Close the Editor when no changes made to the file
	 */
	public void closeEditorNoChanges()
	{
		try {
			closeButton.click();
			waitForElementVisible("#navbarChangeServerButton",3);
		} catch(TimeoutException e) {
			System.out.println("There are not saved changes.");
			//e.printStackTrace();
		}
	}
	
	
	// Check the message shown after clicking "Save"
	// #navbarEditorSavingMessage
	// #navbarEditorChangesSavedMessage
	
	
	
	// ======================== Source View ==========================
	
	
	public void modifyElementAttr(String attribute, 
								  String oldValue, String newValue) {
		// TODO
	}
	
	public void modifyElementText(String oldText, String newText) {
		// TODO
	}
	
	
	/**
	 * Seems the last 3 lines could not be processed
	 * @return
	 */
	public List<WebElement> getServerXmlTextLines() {
		List<WebElement> rows = new ArrayList<WebElement>();
		rows = findsByXPath("//*[@role='presentation']");
		return rows;
	}
	
	
	/**
	 * Extract the text to list "lines"
	 * @return
	 */
	public List<String> getServerXmlText() {
		List<String> lines = new ArrayList<String>();
		List<WebElement> elems = getServerXmlTextLines();
		for(WebElement el : elems) {
			String line = el.getText();
			lines.add(line);
		}
		return lines;
	}
	
}
