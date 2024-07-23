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

Mobile.verifyElementVisible(findTestObject('Object Repository/mobile/Home/Home Screen Title'), GlobalVariable.ShortTimeout)

Mobile.tap(findTestObject('Object Repository/mobile/Home/User Profile Tab'), GlobalVariable.ShortTimeout)

Mobile.verifyElementVisible(findTestObject('Object Repository/mobile/Home/User Profile Screen Title'), GlobalVariable.ShortTimeout)

Mobile.scrollToText(LogoutBtnText)

Mobile.verifyElementVisible(findTestObject('Object Repository/mobile/User Profile/Logout Label/Logout Button'), GlobalVariable.ShortTimeout)

Mobile.tap(findTestObject('Object Repository/mobile/User Profile/Logout Label/Logout Button'), GlobalVariable.ShortTimeout)

Mobile.verifyElementVisible(findTestObject('Object Repository/mobile/User Profile/Logout Label/Close Logout Popup Button'), 
    GlobalVariable.ShortTimeout)

Mobile.verifyElementText(findTestObject('Object Repository/mobile/User Profile/Logout Label/Logout Popup Title'), LogoutPopupTitle)

Mobile.verifyElementVisible(findTestObject('Object Repository/mobile/User Profile/Logout Label/Pet Animation On Logout Popup'), 
    GlobalVariable.ShortTimeout)

Mobile.verifyElementText(findTestObject('Object Repository/mobile/User Profile/Logout Label/Confirm Logout Button'), ConfirmLogoutButtonText)

Mobile.verifyElementText(findTestObject('Object Repository/mobile/User Profile/Logout Label/Nevermind Link Text'), NevermindLinkText)

CustomKeywords.'mobile.BasePage.quitDriver'()