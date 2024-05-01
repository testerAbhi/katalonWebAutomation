package web

import org.openqa.selenium.StaleElementReferenceException
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.remote.service.DriverCommandExecutor
import org.openqa.selenium.support.ui.Select

import com.eviware.soapui.config.DriverConfig
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable
import utils.Generic



public class BasePage {

	private WebDriver driver;

	public List<WebElement> getListOfElements(TestObject to) {
		try {
			return WebUiBuiltInKeywords.findWebElements(to, GlobalVariable.Timeout)
		}
		catch(Exception e) {
			KeywordUtil.markFailed("Object " + to.getObjectId() + " is not present")
		}
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
		finally {
			KeywordUtil.markFailed("Object " + to.getObjectId() + " is not present")
		}
	}

	public String getPageSource() {
		try {
			WebUI.waitForPageLoad(GlobalVariable.Timeout, FailureHandling.CONTINUE_ON_FAILURE)
			return DriverFactory.getWebDriver().getPageSource();
		}
		catch (Exception e){
			KeywordUtil.markFailed("Page source is not found.")
		}
	}

	public String selectRandomDorpdownValue(TestObject to) {
		try {
			WebElement element = WebUiBuiltInKeywords.findWebElement(to, GlobalVariable.Timeout)
			Select select = new Select(element)
			List<WebElement> options = select.getOptions()
			int index = Generic.generateRandomNumber(0, options.size())
			select.selectByIndex(index)
			return options.get(index).getText();
		}
		catch (Exception e) {
			KeywordUtil.markFailed("Object " + to.getObjectId() + " is not present")
		}
	}

	@Keyword
	public void webSetUp() {
		WebUI.openBrowser('')
		WebUI.maximizeWindow()
		WebUI.navigateToUrl(GlobalVariable.webBaseURL)
	}

	@Keyword
	public void quitDriver() {
		WebUI.closeBrowser()
		DriverFactory.getWebDriver().quit()
	}
}
