import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling

import internal.GlobalVariable as GlobalVariable

CustomKeywords.'mobile.BasePage.mobileSetUp'()

CustomKeywords.'mobile.LoginPage.clickOnContinueWithEmail'()

CustomKeywords.'mobile.LoginPage.mobileUserLogin'(GlobalVariable.UserEmail, GlobalVariable.UserPassword)

isWelcomeScreen = Mobile.verifyElementVisible(findTestObject('Object Repository/mobile/Login/Login Base Objects/Maybe Later Button'), 
    GlobalVariable.Timeout)

if (isWelcomeScreen) {
    Mobile.tap(findTestObject('Object Repository/mobile/Login/Login Base Objects/Maybe Later Button'), GlobalVariable.ShortTimeout, 
		FailureHandling.OPTIONAL)
}

Mobile.verifyElementText(findTestObject('Object Repository/mobile/Home/Home Screen Title'), HomePageTitle)

Mobile.tap(findTestObject('Object Repository/mobile/Home/Vetchat Tab'), GlobalVariable.ShortTimeout)

Mobile.verifyElementText(findTestObject('Object Repository/mobile/Home/Vetchat Screen Title'), VetChatPageTitle)

Mobile.tap(findTestObject('Object Repository/mobile/Home/Pet Profile Tab'), GlobalVariable.ShortTimeout)

Mobile.verifyElementText(findTestObject('Object Repository/mobile/Home/Pet Profile Screen Title'), PetProfilePageTitle)

Mobile.tap(findTestObject('Object Repository/mobile/Home/User Profile Tab'), GlobalVariable.ShortTimeout)

Mobile.verifyElementText(findTestObject('Object Repository/mobile/Home/User Profile Screen Title'), UserProfilePageTitle)

CustomKeywords.'mobile.BasePage.quitDriver'()