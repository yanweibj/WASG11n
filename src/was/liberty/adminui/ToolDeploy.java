package was.liberty.adminui;

import static was.common.utility.CommonTasks.sleep;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.framework.util.GUIAuto;


public class ToolDeploy extends BasePage {	
	
	// Web Elements
	@FindBy(id="uploadArchiveRadioWidget")
	WebElement radioBtnUploadSvrPackage;
	@FindBy(id="existingArchiveRadioButton")
	WebElement radioBtnUseExistingSvrPackage;
	@FindBy(id="browseButtonWidget")
	WebElement browseButton;
	@FindBy(id="useHostCredentialsRadioButton")
	WebElement useConnectHostCredentialsRadioBtn;
	@FindBy(id="generatedSSHKeysRadioButton")
	WebElement useGeneratedSSHKeysRadioBtn;
	@FindBy(id="rpcUsernamePasswordRadioButton")
	WebElement useSpecifiedCredentialsRadioBtn;
	@FindBy(id="deployButtonWidget")
	WebElement deployButton;
	@FindBy(id="cancelButtonWidget")
	WebElement cancelButton;
//	@FindBy(id="server-selection")
//	WebElement serverType;
//	@FindBy(id="server-Liberty")
//	WebElement libertyType;
//	@FindBy(id="server-Node.js")
//	WebElement nodeType;
//	@FindBy(id="server-next-button")
//	WebElement nextBtn;
//	static List<WebElement> list1= driver.findElements(By.cssSelector("a[id*='deploy-']"));
//	
//	WebElement serverPackage=list1.get(0);
//	
//	WebElement serverContainer= list1.get(1);
	
	
	
	
	public ToolDeploy(WebDriver driver)
	{
		super(driver);
	}
	
	
	// ----------------------- Target Hosts -----------------------
	// Search box
	// @FindBy(id="hostFilter")
	// @FindBy(css=".filterImage")
	
	/**
	 * Select a host from the available hosts
	 * @param hostIP
	 */
	public void selectHost(String hostIP){
		String host = "#unselected" + hostIP.replace(".", "\\.");
		clickOn(host);
	}
	
	/**
	 * Remove a host from the selected hosts
	 * @param hostIP
	 */
	public void unselectHost(String hostIP){
		String host = "#selected" + hostIP.replace(".", "\\.");
		clickOn(host);
	}
	
	
	/**
	 * Specify a server package that includes a Liberty profile
	 * and a server.
	 * 
	 * @param option	There are two options:<br>
	 *  	<li>(1) Upload a server package file (local)</li>
	 *  	<li>(2) Use a server package file on controller</li>
	 */
	public void selectServerPackageType(int option){
		switch(option){
		case 1: 
		{
			radioBtnUploadSvrPackage.click();
			break;
		}
		case 2:
		{
			radioBtnUseExistingSvrPackage.click();
			break;
		}
		default:
		{
			radioBtnUseExistingSvrPackage.click();
		}
		}
	}
	
	
	/**
	 * Upload a local server package file, with the help of
	 * compiled AutoIt exe to select the file to be uploaded.
	 * 
	 * @param title		&nbsp; the title of the upload dialog
	 * @param fileName	the full path of the uploaded file
	 */
	public void selectLocalSvrPackage(String title, String fileName){
		GUIAuto.fileUpload(title, fileName);
		browseButton.click();
	}
	
	
	/**
	 * Enter the server package file path.
	 * 
	 * @param filePath
	 */
	public void fillInRemoteSvrPackageLocation(String filePath){
		fill("#uploadRemoteFileLocation", filePath);
	}
	
	
	/**
	 * Specify a target directory for the Liberty profile.
	 * 
	 * @param path
	 */
	public void specifyTargetDirectory(String path) {
		fill("#installationDirectoryTextBox", path);
	}
	
	
	/**
	 * Specify the Key Store password
	 * 
	 * @param keyPass
	 */
	public void specifyKeyStorePassword(String keyPass) {
		fill("#keystorePassword", keyPass);
		fill("#keystoreConfirmPassword", keyPass);
	}
	
	
	/**
	 * Specify how the collective controller will connect to each 
	 * target host when managing the servers.
	 * 
	 * @param option
	 * 
	 */
	public void selectControllerConnectionMethod(int option){
		switch(option) {
		case 1: {
			useConnectHostCredentialsRadioBtn.click();
			break;
		}
		case 2: {
			useGeneratedSSHKeysRadioBtn.click();
			break;
		}
		case 3: {
			useSpecifiedCredentialsRadioBtn.click();
			break;
		}
		default: {
			useConnectHostCredentialsRadioBtn.click();
			break;
		}
		
		}
	}
	
	
	/**
	 * Enter the Remote Management Credentials info.
	 * Editable only when the 3rd option is selected.
	 * 
	 * @param userName
	 * @param userPass
	 */
	public void enterRMCredentials(String userName, String userPass) 
	{
		fill("#rpcUsername", userName);
		fill("#rpcUserPassword", userPass);
		fill("rpcConfirmPassword", userPass);
	}
	
	
	/**
	 * Specify Liberty Administrative password
	 * @param adminPassword
	 */
	public void specifyLibertyAdminPassword(String adminPassword) {
		fill("#libertyAdminPassword", adminPassword);
	}
	
	
	/**
	 * Click on Deploy button
	 */
	public void clickOnDeployButton() {
		deployButton.click();
	}
//	public void clickOnServerType() {
//		serverType.click();
//		
//	}
//	
//	public void clickOnLibertyType() {
//		libertyType.click();
//		
//	}
//	public void clickOnNodeType() {
//		nodeType.click();
//	}
	
	
	/**
	 * Click on Cancel button and switch to the outer html. 
	 * After the button clicked,<br> the page will show back
	 *  the Toolbox view, so switch the webdriver out here.
	 */
	public void clickOnCancelButton() {
		cancelButton.click();
		driver.switchTo().defaultContent();
	}
	
	
//	public void clickOnNextButton() {
//		nextBtn.click();
//		driver.switchTo().defaultContent();
//	}
//	public void clickOnPackageType() {
//		System.out.println(serverPackage.getText());
//		serverPackage.click();
//		System.out.println("package2");
//		driver.switchTo().defaultContent();
//	}
//	public void clickOnContainerType() {
//	
//		System.out.println("Container1");
//		serverContainer.click();
//		driver.switchTo().defaultContent();
//	}


	
	
}
