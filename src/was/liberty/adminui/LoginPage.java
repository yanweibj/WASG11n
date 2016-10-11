package was.liberty.adminui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.framework.util.PropUtil;


public class LoginPage {
	private String AdminURL;
	private String userName;
	private String userPass;
	private WebDriver driver;
	
	// Declare web elements
	@FindBy(id="j_username")
	WebElement usernameInput;
	@FindBy(id="j_password")
	WebElement passwordInput;
	@FindBy(id="loginButton")
	WebElement loginButton;
	
	
	public LoginPage(WebDriver driver) {
		this.setEnv();
		this.driver = driver;
		driver.get(AdminURL);
		PageFactory.initElements(driver, this);
	}
	
	
	/**
	 * Fetch environment settings from config file:
	 * <br> <font color='blue'>
	 *  &nbsp; src\config\wasliberty.properties
	 * </font>
	 */
	private void setEnv() {
		String wlp = "config\\wasliberty.properties";
		PropUtil prop = new PropUtil(wlp);
		userName = prop.get("AdminUsername");
		userPass = prop.get("AdminPassword");
		AdminURL = prop.get("AdminUrl");
	}
	
	
	/**
	 * Use this method in Page Object mode. The "User Name"
	 * and "Password"</br>are fetched from config file and 
	 * are automatically entered.
	 * 
	 * @return return Toolbox page object.
	 */
	public Toolbox login()
	{
		usernameInput.sendKeys(userName);
		passwordInput.sendKeys(userPass);
		loginButton.click();
		return PageFactory.initElements(driver, Toolbox.class);
	}
	
	
	/**
	 * For testing login functionality
	 * @param userName
	 * @param userPass
	 */
	public void login(String userName, String userPass)
	{
		usernameInput.sendKeys(userName);
		passwordInput.sendKeys(userPass);
		loginButton.click();
	}
	
}
