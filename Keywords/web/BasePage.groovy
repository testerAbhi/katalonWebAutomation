package web

import org.openqa.selenium.StaleElementReferenceException
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.remote.service.DriverCommandExecutor

import com.eviware.soapui.config.DriverConfig
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable



public class BasePage {

	private WebDriver driver;
	
	public List<WebElement> getListOfElements(TestObject to) {
		return WebUiBuiltInKeywords.findWebElements(to, GlobalVariable.Timeout)
	}

	public List<String> getListOfText(TestObject to){
		try {
			List<WebElement> elements = getListOfElements(to)
			List<String> list = new ArrayList<String>()
			for(WebElement element: elements) {
				list.add(element.getText().replaceAll("\\n", " ").trim())
			}
			return list;
		}
		catch (StaleElementReferenceException e) {
			return getListOfText(to);
		}
	}

	public String getPageSource() {
		WebUI.waitForPageLoad(GlobalVariable.Timeout, FailureHandling.CONTINUE_ON_FAILURE)
		return DriverFactory.getWebDriver().getPageSource();
	}

	public void webSetUp() {
		WebUI.openBrowser('')
		WebUI.maximizeWindow()
		WebUI.navigateToUrl(GlobalVariable.webBaseURL)
	}
	
	public void quitDriver() {
		WebUI.closeBrowser()
		DriverFactory.getWebDriver().quit()
	}
}
