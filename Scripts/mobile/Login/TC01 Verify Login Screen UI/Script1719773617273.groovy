import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

import internal.GlobalVariable

CustomKeywords.'mobile.BasePage.mobileSetUp'();

CustomKeywords.'mobile.LoginPage.clickOnContinueWithEmail'();

Mobile.verifyElementText(findTestObject('Object Repository/mobile/Login/Email Screen/Email Screen Title'), PageTitle1)

Mobile.verifyElementText(findTestObject('Object Repository/mobile/Login/Email Screen/Email Info Text'), LoginInfo)

Mobile.verifyElementText(findTestObject('Object Repository/mobile/Login/Login Base Objects/Continue Or Login Button'), ContinueBtnText)

Mobile.waitForElementPresent(findTestObject('Object Repository/mobile/Login/Email Screen/Email Input Field'), GlobalVariable.ShortTimeout)

Mobile.setText(findTestObject('Object Repository/mobile/Login/Email Screen/Email Input Field'), GlobalVariable.UserEmail, GlobalVariable.ShortTimeout)

Mobile.tap(findTestObject('Object Repository/mobile/Login/Login Base Objects/Continue Or Login Button'), GlobalVariable.ShortTimeout);

Mobile.verifyElementText(findTestObject('Object Repository/mobile/Login/Password Screen/Password Screen Title'), PageTitle2)

Mobile.verifyElementText(findTestObject('Object Repository/mobile/Login/Password Screen/Password Info Text'), PasswordInfo)

Mobile.verifyElementText(findTestObject('Object Repository/mobile/Login/Password Screen/Forgot Password Link Text'), ForgotPasswordLink)

Mobile.verifyElementText(findTestObject('Object Repository/mobile/Login/Login Base Objects/Continue Or Login Button'), LoginButtonText)

CustomKeywords.'mobile.BasePage.quitDriver'();