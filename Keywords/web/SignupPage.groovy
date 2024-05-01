package web

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable
import locatorCall.LocatorName
import utils.Generic

public class SignupPage extends BasePage{

	@Keyword void moveToSignupPage(){
		boolean isPage=false
		while(!isPage){
			WebUI.click(findTestObject('Object Repository/web/Signup Page/Button_Signup'))
			isPage = WebUI.waitForElementVisible(findTestObject('Object Repository/web/Signup Page/Text_Page heading'),
					GlobalVariable.ShortTimeout,FailureHandling.CONTINUE_ON_FAILURE)
		}
	}

	@Keyword boolean isSignupPageElementVisible(){
		boolean nameField = WebUI.waitForElementVisible(findTestObject('Object Repository/web/Signup Page/Input_Account name'),
				GlobalVariable.Timeout)
		boolean emailField = WebUI.waitForElementVisible(findTestObject('Object Repository/web/Signup Page/Input_User Email'),
				GlobalVariable.Timeout)
		boolean numberField = WebUI.waitForElementVisible(findTestObject('Object Repository/web/Signup Page/Input_Phone number'),
				GlobalVariable.Timeout)
		boolean passwordField = WebUI.waitForElementVisible(findTestObject('Object Repository/web/Signup Page/Input_Password'),
				GlobalVariable.Timeout)
		boolean confirmPasswordField = WebUI.waitForElementVisible(findTestObject('Object Repository/web/Signup Page/Input_Confirm password'),
				GlobalVariable.Timeout)
		boolean urlNameField = WebUI.waitForElementVisible(findTestObject('Object Repository/web/Signup Page/Input_URL preference'),
				GlobalVariable.Timeout)
		boolean checkbox = WebUI.waitForElementVisible(findTestObject('Object Repository/web/Signup Page/Checkbox_Privacy policy'),
				GlobalVariable.Timeout)
		boolean createAccountBtn = WebUI.waitForElementVisible(findTestObject('Object Repository/web/Signup Page/Button_Create account'),
				GlobalVariable.Timeout)
		boolean signupImg = WebUI.waitForElementVisible(findTestObject('Object Repository/web/Signup Page/IMG_Signup page'),
				GlobalVariable.Timeout)
		boolean googleIcn = WebUI.waitForElementVisible(findTestObject('Object Repository/web/Signup Page/IMG_Google icon'),
				GlobalVariable.Timeout)

		return nameField&&emailField&&numberField&&passwordField&&confirmPasswordField&&urlNameField&&checkbox&&createAccountBtn&&signupImg&&googleIcn
	}

	@Keyword List<String> getSignupPageTextList(LocatorName locEnum){
		switch(locEnum){
			case locEnum.SIGNUP:
				return getListOfText(findTestObject('Object Repository/web/Signup Page/Text_Signup Page common'))
			case locEnum.SIGNUPERROR:
				String invalidName = "12"
				String invalidEmail = "abc@k.cc"
				String invalidNumber = (String) Generic.generateRandomNumber(1000,100)
				String invalidPassword = (String) Generic.generateRandomNumber(1000,100)

				WebUI.setText(findTestObject('Object Repository/web/Signup Page/Input_Account name'),invalidName)
				WebUI.setText(findTestObject('Object Repository/web/Signup Page/Input_User Email'),invalidEmail)
				WebUI.setText(findTestObject('Object Repository/web/Signup Page/Input_Phone number'),invalidNumber)
				WebUI.setText(findTestObject('Object Repository/web/Signup Page/Input_Password'),invalidNumber)
				WebUI.setText(findTestObject('Object Repository/web/Signup Page/Input_Confirm password'),invalidPassword)
				WebUI.setText(findTestObject('Object Repository/web/Signup Page/Input_URL preference'),invalidName)
				WebUI.click(findTestObject('Object Repository/web/Signup Page/Checkbox_Privacy policy'))
				WebUI.click(findTestObject('Object Repository/web/Signup Page/Button_Create account'))

				List<String> list = new ArrayList()
				list.add(WebUI.getText(findTestObject('Object Repository/web/Signup Page/Error Text_User name')))
				list.add(WebUI.getText(findTestObject('Object Repository/web/Signup Page/Error Text_Mobile number')))
				list.add(WebUI.getText(findTestObject('Object Repository/web/Signup Page/Error Text_Password not match')))
				list.add(WebUI.getText(findTestObject('Object Repository/web/Signup Page/Error Text_Preference')))
				return list
		}
	}
}
