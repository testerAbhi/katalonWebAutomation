import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

import internal.GlobalVariable
import utils.Generic as Generic

CustomKeywords.'mobile.BasePage.mobileSetUp'()

CustomKeywords.'mobile.LoginPage.clickOnContinueWithEmail'()

def newEmail = Generic.generateRandomEmail()

Mobile.setText(findTestObject('Object Repository/mobile/Login/Email Screen/Email Input Field'), newEmail, GlobalVariable.ShortTimeout)

Mobile.tap(findTestObject('Object Repository/mobile/Login/Login Base Objects/Continue Or Login Button'), GlobalVariable.ShortTimeout)

Mobile.verifyElementText(findTestObject('Object Repository/mobile/Signup/User Detail Screen/Signup Screen Title'), SignupScreenTitle)

Mobile.verifyElementVisible(findTestObject('Object Repository/mobile/Signup/User Detail Screen/Welcome Info Text'), GlobalVariable.ShortTimeout)

Mobile.verifyElementVisible(findTestObject('Object Repository/mobile/Signup/User Detail Screen/First Name Input Field'), GlobalVariable.ShortTimeout)

Mobile.verifyElementVisible(findTestObject('Object Repository/mobile/Signup/User Detail Screen/Last Name Input Field'), GlobalVariable.ShortTimeout)

Mobile.verifyElementVisible(findTestObject('Object Repository/mobile/Signup/User Detail Screen/Zip Code Input Field'), GlobalVariable.ShortTimeout)

Mobile.verifyElementText(findTestObject('Object Repository/mobile/Signup/User Detail Screen/Continue Button'), ContinueButtonText)

CustomKeywords.'mobile.BasePage.quitDriver'()