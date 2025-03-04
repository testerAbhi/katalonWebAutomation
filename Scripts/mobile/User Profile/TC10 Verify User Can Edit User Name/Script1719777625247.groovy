import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling

import internal.GlobalVariable as GlobalVariable

CustomKeywords.'mobile.BasePage.mobileSetUp'()

CustomKeywords.'mobile.LoginPage.clickOnContinueWithEmail'()

CustomKeywords.'mobile.LoginPage.mobileUserLogin'(GlobalVariable.UserEmail, GlobalVariable.UserPassword)

isWelcomeScreen = Mobile.verifyElementVisible(findTestObject('Object Repository/mobile/Login/Login Base Objects/Maybe Later Button'), 
    GlobalVariable.Timeout, FailureHandling.OPTIONAL)

if (isWelcomeScreen) {
    Mobile.tap(findTestObject('Object Repository/mobile/Login/Login Base Objects/Maybe Later Button'), GlobalVariable.ShortTimeout)
}

Mobile.tap(findTestObject('Object Repository/mobile/Home/User Profile Tab'), GlobalVariable.ShortTimeout)

Mobile.tap(findTestObject('Object Repository/mobile/User Profile/User Profile Base Objects/Edit User Profile Button'), GlobalVariable.ShortTimeout)

Mobile.setText(findTestObject('Object Repository/mobile/User Profile/Edit User Details/Edit First Name'), FirstName, GlobalVariable.ShortTimeout)

Mobile.setText(findTestObject('Object Repository/mobile/User Profile/Edit User Details/Edit Last Name'), LastName, GlobalVariable.ShortTimeout)

Mobile.hideKeyboard()

Mobile.tap(findTestObject('Object Repository/mobile/User Profile/Edit User Details/Save Button'), GlobalVariable.ShortTimeout)

CustomKeywords.'mobile.BasePage.quitDriver'()