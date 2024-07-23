import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

import internal.GlobalVariable as GlobalVariable

CustomKeywords.'mobile.BasePage.mobileSetUp'()

CustomKeywords.'mobile.LoginPage.clickOnContinueWithEmail'()

Mobile.tap(findTestObject('Object Repository/mobile/Login/Login Base Objects/Continue Or Login Button'), GlobalVariable.ShortTimeout)

Mobile.verifyElementText(findTestObject('Object Repository/mobile/Login/Email Screen/Blank Email Error'), BlankFieldError)

Mobile.setText(findTestObject('Object Repository/mobile/Login/Email Screen/Email Input Field'), InValidEmail, 0)

Mobile.tap(findTestObject('Object Repository/mobile/Login/Login Base Objects/Continue Or Login Button'), GlobalVariable.ShortTimeout)

Mobile.verifyElementText(findTestObject('Object Repository/mobile/Login/Email Screen/Invalid Email Error'), InvalidEmailError)

Mobile.clearText(findTestObject('Object Repository/mobile/Login/Email Screen/Email Input Field'), GlobalVariable.ShortTimeout)

Mobile.setText(findTestObject('Object Repository/mobile/Login/Email Screen/Email Input Field'), GlobalVariable.UserEmail, 
    GlobalVariable.ShortTimeout)

Mobile.tap(findTestObject('Object Repository/mobile/Login/Login Base Objects/Continue Or Login Button'), GlobalVariable.ShortTimeout)

Mobile.waitForElementPresent(findTestObject('Object Repository/mobile/Login/Password Screen/Password Input Field'), GlobalVariable.ShortTimeout)

Mobile.tap(findTestObject('Object Repository/mobile/Login/Login Base Objects/Continue Or Login Button'), GlobalVariable.ShortTimeout)

Mobile.verifyElementText(findTestObject('Object Repository/mobile/Login/Password Screen/Blank PasswordError'), BlankPasswordError)

Mobile.setText(findTestObject('Object Repository/mobile/Login/Password Screen/Password Input Field'), InvalidPassword, GlobalVariable.ShortTimeout)

Mobile.tap(findTestObject('Object Repository/mobile/Login/Login Base Objects/Continue Or Login Button'), GlobalVariable.ShortTimeout)

Mobile.verifyElementText(findTestObject('Object Repository/mobile/Login/Password Screen/Invalid Password Error'), InvalidPasswordError)

Mobile.clearText(findTestObject('Object Repository/mobile/Login/Password Screen/Password Input Field'), GlobalVariable.ShortTimeout)

Mobile.setText(findTestObject('Object Repository/mobile/Login/Password Screen/Password Input Field'), IncorrectPassword, 
    GlobalVariable.ShortTimeout)

Mobile.tap(findTestObject('Object Repository/mobile/Login/Login Base Objects/Continue Or Login Button'), GlobalVariable.ShortTimeout)

Mobile.verifyElementText(findTestObject('Object Repository/mobile/Login/Password Screen/Incorrect Password Error'), IncorrectPasswordError)

CustomKeywords.'mobile.BasePage.quitDriver'()