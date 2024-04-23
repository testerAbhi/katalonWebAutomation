package web

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable
import locatorCall.LocatorName as LocatorName


public class LoginPage extends BasePage{

	public String userLogin(String email, String password) {
		WebUI.waitForElementPresent(findTestObject('Object Repository/web/Login Page/Text_Page Heading'), GlobalVariable.ShortTimeout)
		WebUI.setText(findTestObject('Object Repository/web/Login Page/Input_Login Email'), email)
		WebUI.setText(findTestObject('Object Repository/web/Login Page/Input_Login_password'), password)
		WebUI.click(findTestObject('Object Repository/web/Login Page/Button_Log In'))
		return WebUI.getText(findTestObject('Object Repository/web/Home Page/Text_Page heading'))
	}

	public boolean isLoginPageElementVisible() {
		boolean loginImg = WebUI.waitForElementVisible(
				findTestObject('Object Repository/web/Login Page/IMG_Login Page'), GlobalVariable.ShortTimeout)
		boolean eyeIcn = WebUI.waitForElementVisible(
				findTestObject('Object Repository/web/Login Page/Icon_Eye on password'), GlobalVariable.ShortTimeout)
		boolean emailField = WebUI.waitForElementVisible(
				findTestObject('Object Repository/web/Login Page/Input_Login Email'), GlobalVariable.ShortTimeout)
		boolean passwordField = WebUI.waitForElementVisible(
				findTestObject('Object Repository/web/Login Page/Input_Login_password'), GlobalVariable.ShortTimeout)
		boolean googleIcn = WebUI.waitForElementVisible(
				findTestObject('Object Repository/web/Login Page/IMG_Google icon'), GlobalVariable.ShortTimeout)
		boolean loginBtn = WebUI.waitForElementVisible(
				findTestObject('Object Repository/web/Login Page/Button_Log In'), GlobalVariable.ShortTimeout)

		return loginImg && eyeIcn && emailField && passwordField && googleIcn && loginBtn
	}

	public List<String> getLoginPageTextList(){
		return getListOfText(findTestObject('Object Repository/web/Login Page/Text_Login page common'))
	}
}
