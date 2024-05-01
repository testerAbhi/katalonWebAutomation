package web

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.WebElement

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable
import locatorCall.LocatorName

public class HomePage extends BasePage{

	@Keyword
	String userLogout() {
		WebUI.click(findTestObject('Object Repository/web/Home Page/Button_User profile nav bar'))
		WebUI.click(findTestObject('Object Repository/web/Home Page/Button_Logout'))
		WebUI.click(findTestObject('Object Repository/web/Home Page/Button_Confirm logout'))
		return WebUI.getText(findTestObject('Object Repository/web/Login Page/Text_Page Heading'))
	}

	@Keyword
	List<String> navigateAndGetText() {
		List<String> list = new ArrayList()
		List<WebElement> elements = getListOfElements(findTestObject('Object Repository/web/Home Page/Links_Menu bar options'))
		for(WebElement element:elements) {
			element.click()
			WebUI.waitForPageLoad(GlobalVariable.ShortTimeout, FailureHandling.CONTINUE_ON_FAILURE)
			list.add(WebUI.getText(findTestObject('Object Repository/web/Home Page/Text_Menu bar navigation common Text')))
		}
		return list
	}

	@Keyword
	void clickOnTab(String tab) {
		WebUI.click(findTestObject('Object Repository/web/Home Page/Button_Navigation tab', ['text': tab]))
	}

	@Keyword
	String clickOnHomePageItem(LocatorName locEnum) {
		switch(locEnum) {
			case locEnum.REQUESTTIMEOFF:
				WebUI.click(findTestObject('Object Repository/web/Home Page/Button_Request time off'))
				return WebUI.getText(findTestObject('Object Repository/web/Home Page/Text_Request leave popup heading'))
		}
	}

	@Keyword
	List<String> getListOfHomePageItems(LocatorName locEnum){
		switch(locEnum) {
			case locEnum.REQUESTTIMEOFF:
				return getListOfText(findTestObject('Object Repository/web/Home Page/Text_Leave popup labels'))
		}
	}

	@Keyword
	boolean isHomePageElementVisible(LocatorName locEnum){
		switch(locEnum) {
			case locEnum.REQUESTTIMEOFF:
				boolean isLeaveType = WebUI.waitForElementVisible(findTestObject('Object Repository/web/Home Page/Options_Select leave type'),
				GlobalVariable.ShortTimeout, FailureHandling.CONTINUE_ON_FAILURE)
				boolean startDateField = WebUI.waitForElementVisible(findTestObject('Object Repository/web/Home Page/Input_Start date'),
						GlobalVariable.ShortTimeout, FailureHandling.CONTINUE_ON_FAILURE)
				boolean lastDateField = WebUI.waitForElementVisible(findTestObject('Object Repository/web/Home Page/Input_Last date'),
						GlobalVariable.ShortTimeout, FailureHandling.CONTINUE_ON_FAILURE)
				boolean reasonField = WebUI.waitForElementVisible(findTestObject('Object Repository/web/Home Page/Input_Leave reason field'),
						GlobalVariable.ShortTimeout, FailureHandling.CONTINUE_ON_FAILURE)
				boolean cancelBtn = WebUI.waitForElementVisible(findTestObject('Object Repository/web/Home Page/Button_Cancel Leave'),
						GlobalVariable.ShortTimeout, FailureHandling.CONTINUE_ON_FAILURE)
				boolean applyBtn = WebUI.waitForElementVisible(findTestObject('Object Repository/web/Home Page/Button_Apply Leave'),
						GlobalVariable.ShortTimeout, FailureHandling.CONTINUE_ON_FAILURE)

				return isLeaveType && startDateField && lastDateField && reasonField && cancelBtn && applyBtn
		}
	}
}
