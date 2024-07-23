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

Mobile.clearText(findTestObject('Object Repository/mobile/User Profile/Edit User Details/Edit First Name'), GlobalVariable.ShortTimeout)

Mobile.tap(findTestObject('Object Repository/mobile/User Profile/Edit User Details/Close Edit Profile Screen'), GlobalVariable.ShortTimeout)

Mobile.verifyElementText(findTestObject('Object Repository/mobile/User Profile/Edit User Details/Popup Title'), PopupTitle)

Mobile.verifyElementVisible(findTestObject('Object Repository/mobile/User Profile/Edit User Details/Close Popup'), GlobalVariable.ShortTimeout)

text = Mobile.getText(findTestObject('Object Repository/mobile/User Profile/Edit User Details/Info Text'), GlobalVariable.ShortTimeout)

text = text.replaceAll('[\\s\\n]+', ' ').trim()

Mobile.verifyEqual(text, InfoText)

Mobile.verifyElementText(findTestObject('Object Repository/mobile/User Profile/Edit User Details/Donot Save Button'), ButtonText)

Mobile.verifyElementText(findTestObject('Object Repository/mobile/User Profile/Edit User Details/NevermindLink'), NevermindLinkText)

CustomKeywords.'mobile.BasePage.quitDriver'()