import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

import internal.GlobalVariable
import utils.Generic as Generic

CustomKeywords.'mobile.BasePage.mobileSetUp'()

CustomKeywords.'mobile.LoginPage.clickOnContinueWithEmail'()

def newEmail = Generic.generateRandomEmail()

Mobile.setText(findTestObject('Object Repository/mobile/Login/Email Screen/Email Input Field'), newEmail, GlobalVariable.ShortTimeout)

Mobile.tap(findTestObject('Object Repository/mobile/Login/Login Base Objects/Continue Or Login Button'), GlobalVariable.ShortTimeout)

Mobile.hideKeyboard()

Mobile.setText(findTestObject('Object Repository/mobile/Signup/User Detail Screen/First Name Input Field'), FirstName, GlobalVariable.ShortTimeout)

Mobile.setText(findTestObject('Object Repository/mobile/Signup/User Detail Screen/Last Name Input Field'), LastName, GlobalVariable.ShortTimeout)

Mobile.hideKeyboard()

Mobile.tap(findTestObject('Object Repository/mobile/Signup/User Detail Screen/Continue Button'), GlobalVariable.ShortTimeout)

Mobile.setText(findTestObject('Object Repository/mobile/Signup/Create Account Screen/Create Password Field'), NewPassword, 
    GlobalVariable.ShortTimeout)

Mobile.hideKeyboard()

Mobile.tap(findTestObject('Object Repository/mobile/Signup/Create Account Screen/Create Account Button'), GlobalVariable.ShortTimeout)

Mobile.verifyElementText(findTestObject('Object Repository/mobile/Signup/Signup Base Objects/Subscribtion Header'), SubscriptionHeader)

CustomKeywords.'mobile.BasePage.quitDriver'()