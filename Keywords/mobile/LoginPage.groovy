package mobile

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

import internal.GlobalVariable

public class LoginPage extends BasePage{

	@Keyword
	public void clickOnContinueWithEmail() {
		if(Mobile.verifyElementExist(findTestObject('Object Repository/mobile/Login/Login Base Objects/ContinueWithEmailBtn'), GlobalVariable.Timeout)) {
			Mobile.tap(findTestObject('Object Repository/mobile/Login/Login Base Objects/ContinueWithEmailBtn'), GlobalVariable.ShortTimeout);
		}
	}

	@Keyword
	public void mobileUserLogin(String email, String password) {
		Mobile.setText(findTestObject('Object Repository/mobile/Login/Email Screen/Email Input Field'), email, GlobalVariable.ShortTimeout)
		Mobile.tap(findTestObject('Object Repository/mobile/Login/Login Base Objects/Continue Or Login Button'), GlobalVariable.ShortTimeout)

		Mobile.setText(findTestObject('Object Repository/mobile/Login/Password Screen/Password Input Field'), password, GlobalVariable.ShortTimeout)
		Mobile.waitForElementPresent(findTestObject('Object Repository/mobile/Login/Password Screen/Password Input Field'), GlobalVariable.ShortTimeout)
		Mobile.tap(findTestObject('Object Repository/mobile/Login/Login Base Objects/Continue Or Login Button'), GlobalVariable.ShortTimeout)
	}
}
