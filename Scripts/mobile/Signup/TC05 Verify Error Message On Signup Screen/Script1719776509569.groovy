import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

import internal.GlobalVariable
import utils.Generic

CustomKeywords.'mobile.BasePage.mobileSetUp'()

CustomKeywords.'mobile.LoginPage.clickOnContinueWithEmail'()

def newEmail = Generic.generateRandomEmail()

Mobile.setText(findTestObject('Object Repository/mobile/Login/Email Screen/Email Input Field'), newEmail, GlobalVariable.ShortTimeout)

Mobile.tap(findTestObject('Object Repository/mobile/Login/Login Base Objects/Continue Or Login Button'), GlobalVariable.ShortTimeout)

Mobile.hideKeyboard()

Mobile.tap(findTestObject('Object Repository/mobile/Signup/User Detail Screen/Continue Button'), GlobalVariable.ShortTimeout)

Mobile.verifyElementText(findTestObject('Object Repository/mobile/Signup/User Detail Screen/Blank First Name Error'), BlankFirstName)

Mobile.verifyElementText(findTestObject('Object Repository/mobile/Signup/User Detail Screen/Blank Last Name Error'), BlankLastName)

CustomKeywords.'mobile.BasePage.quitDriver'()