package was.liberty.adminui;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class Toolbox extends BasePage {
	
	// Web Elements
	@FindBy(tagName="img")
	List<WebElement> toolIcons;
	@FindBy(id="toolIFrame")
	WebElement toolIFrame;
	
	
	public Toolbox(WebDriver driver)
	{
		super(driver);
	}
	
	
	// ----------------- Toolbox Actions -------------------
	
	/**
	 * Open the Deploy tool.
	 * 
	 * @return
	 * 			returns ToolDeploy page object instance
	 */
	public ToolDeploy gotoDeploy()
	{
		clickIcon("Deploy");	
		switchToFrame(toolIFrame);
		waitForElementVisible("#server-selection");
		return PageFactory.initElements(driver,ToolDeploy.class);	
	}
	 
	
	/**
	 * Open the Explore tool.
	 * 
	 * @return
	 * 			returns ToolExplore page object instance
	 */
	public ToolExplore gotoExplore()
	{
		clickIcon("Explore");
		switchToFrame(toolIFrame);
		//waitForElementVisible("#dashboard-ContentPane");
		return PageFactory.initElements(driver, ToolExplore.class);
	}
	
	
	/**
	 * Open the Server Config tool.
	 * 
	 * @return
	 * 			returns ToolServerConfig page object instance
	 */
	public ToolServerConfig gotoServerConfig()
	{
		clickIcon("Server Config");		
		switchToFrame(toolIFrame);
		waitForElementVisible("#serverExplorerTable");
		return PageFactory.initElements(driver, ToolServerConfig.class);
	}
	 
	
	/**
	 * Open the Admin Center Example Tools tool.
	 */
	public void gotoAdminCenterTools()
	{
		// Feature not implement yet
		// TODO
	}
	
	
	
	/**
	 * Click on a tool Icon in the Toolbox.
	 * 
	 * @param iconName  The tool name (e.g. Deploy, Explore,
	 * 					Server Config...)
	 */
	private void clickIcon(String iconName) {
		// Iterate the toolIcons to find the target icon
		for(WebElement icon : toolIcons) {
			if (icon.getAttribute("alt").equals(iconName)) 
			{
				icon.click();
				break;
			}
		}
	}
	
	
}