package web

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

public class SignupPage extends BasePage{

	public void moveToSignupPage() {
		boolean isPage = false
		while(!isPage) {
			WebUI.click(findTestObject('Object Repository/web/Signup Page/Button_Signup'))
			isPage = WebUI.waitForElementVisible(
					findTestObject('Object Repository/web/Signup Page/Text_Page heading'), GlobalVariable.ShortTimeout, FailureHandling.CONTINUE_ON_FAILURE)
		}
	}

	public boolean isSignupPageElementVisible() {
		boolean nameField = WebUI.waitForElementVisible(findTestObject('Object Repository/web/Signup Page/Input_Account name'), GlobalVariable.Timeout)
		boolean emailField = WebUI.waitForElementVisible(findTestObject('Object Repository/web/Signup Page/Input_User Email'), GlobalVariable.Timeout)
		boolean numberField = WebUI.waitForElementVisible(findTestObject('Object Repository/web/Signup Page/Input_Phone number'), GlobalVariable.Timeout)
		boolean passwordField = WebUI.waitForElementVisible(findTestObject('Object Repository/web/Signup Page/Input_Password'), GlobalVariable.Timeout)
		boolean confirmPasswordField = WebUI.waitForElementVisible(findTestObject('Object Repository/web/Signup Page/Input_Confirm password'), GlobalVariable.Timeout)
		boolean urlNameField = WebUI.waitForElementVisible(findTestObject('Object Repository/web/Signup Page/Input_URL preference'), GlobalVariable.Timeout)
		boolean checkbox = WebUI.waitForElementVisible(findTestObject('Object Repository/web/Signup Page/Checkbox_Privacy policy'), GlobalVariable.Timeout)
		boolean createAccountBtn = WebUI.waitForElementVisible(findTestObject('Object Repository/web/Signup Page/Button_Create account'), GlobalVariable.Timeout)
		boolean signupImg = WebUI.waitForElementVisible(findTestObject('Object Repository/web/Signup Page/IMG_Signup page'), GlobalVariable.Timeout)
		boolean googleIcn = WebUI.waitForElementVisible(findTestObject('Object Repository/web/Signup Page/IMG_Google icon'), GlobalVariable.Timeout)

		return nameField && emailField && numberField && passwordField && confirmPasswordField && urlNameField && checkbox && createAccountBtn && signupImg && googleIcn
	}

	public List<String> getSignupPageTextList(){
		return getListOfText(findTestObject('Object Repository/web/Signup Page/Text_Signup Page common'))
	}
}
