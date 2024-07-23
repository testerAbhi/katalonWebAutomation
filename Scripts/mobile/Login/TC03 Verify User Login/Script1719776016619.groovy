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

Mobile.verifyElementVisible(findTestObject('Object Repository/mobile/Login/Login Base Objects/Subscription Ended Title'), 
    GlobalVariable.ShortTimeout)

Mobile.verifyElementText(findTestObject('Object Repository/mobile/Login/Login Base Objects/Subscription Ended Title'), SubscriptionEndedTitle)

CustomKeywords.'mobile.BasePage.quitDriver'()