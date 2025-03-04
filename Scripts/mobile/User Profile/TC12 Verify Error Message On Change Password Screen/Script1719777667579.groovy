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

Mobile.tap(findTestObject('Object Repository/mobile/User Profile/Account Settings Label/Account Settings Label Option'), 
    GlobalVariable.ShortTimeout)

Mobile.tap(findTestObject('Object Repository/mobile/User Profile/Account Settings Label/Change Password/Change Password Option'), 
    GlobalVariable.ShortTimeout)

Mobile.setText(findTestObject('Object Repository/mobile/User Profile/Account Settings Label/Change Password/Current Password Field'), 
    GlobalVariable.UserPassword, GlobalVariable.ShortTimeout)

Mobile.setText(findTestObject('Object Repository/mobile/User Profile/Account Settings Label/Change Password/New Password Field'), 
    NewPassword, GlobalVariable.ShortTimeout)

Mobile.setText(findTestObject('Object Repository/mobile/User Profile/Account Settings Label/Change Password/Re-enter New Password Field'), 
    NotMatchPassword, GlobalVariable.ShortTimeout)

Mobile.hideKeyboard()

Mobile.verifyElementText(findTestObject('Object Repository/mobile/User Profile/Account Settings Label/Change Password/Passwords Not Match Error'), 
    PasswordNotMatchError)

Mobile.clearText(findTestObject('Object Repository/mobile/User Profile/Account Settings Label/Change Password/Current Password Field'), 
    GlobalVariable.ShortTimeout)

Mobile.setText(findTestObject('Object Repository/mobile/User Profile/Account Settings Label/Change Password/Current Password Field'), 
    NotMatchPassword, GlobalVariable.ShortTimeout)

Mobile.clearText(findTestObject('Object Repository/mobile/User Profile/Account Settings Label/Change Password/New Password Field'), 
    GlobalVariable.ShortTimeout)

Mobile.setText(findTestObject('Object Repository/mobile/User Profile/Account Settings Label/Change Password/New Password Field'), 
    NewPassword, GlobalVariable.ShortTimeout)

Mobile.clearText(findTestObject('Object Repository/mobile/User Profile/Account Settings Label/Change Password/Re-enter New Password Field'), 
    GlobalVariable.ShortTimeout)

Mobile.setText(findTestObject('Object Repository/mobile/User Profile/Account Settings Label/Change Password/Re-enter New Password Field'), 
    NewPassword, GlobalVariable.ShortTimeout)

Mobile.hideKeyboard()

Mobile.tap(findTestObject('Object Repository/mobile/User Profile/Account Settings Label/Change Password/Save Password'), 
    GlobalVariable.ShortTimeout)

Mobile.waitForElementPresent(findTestObject('Object Repository/mobile/User Profile/Account Settings Label/Change Password/Old Password Error'), 
    GlobalVariable.Timeout, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementText(findTestObject('Object Repository/mobile/User Profile/Account Settings Label/Change Password/Old Password Error'), 
    OldPasswordError)

Mobile.clearText(findTestObject('Object Repository/mobile/User Profile/Account Settings Label/Change Password/Current Password Field'), 
    GlobalVariable.ShortTimeout)

Mobile.setText(findTestObject('Object Repository/mobile/User Profile/Account Settings Label/Change Password/Current Password Field'), 
    InvalidOldPassword, GlobalVariable.ShortTimeout)

Mobile.hideKeyboard()

Mobile.tap(findTestObject('Object Repository/mobile/User Profile/Account Settings Label/Change Password/Save Password'), 
    GlobalVariable.ShortTimeout)

Mobile.verifyElementText(findTestObject('Object Repository/mobile/User Profile/Account Settings Label/Change Password/Invalid Password Error'), 
    InvalidPasswordError)

Mobile.clearText(findTestObject('Object Repository/mobile/User Profile/Account Settings Label/Change Password/Current Password Field'), 
    GlobalVariable.ShortTimeout)

Mobile.setText(findTestObject('Object Repository/mobile/User Profile/Account Settings Label/Change Password/Current Password Field'), 
    NewPassword, GlobalVariable.ShortTimeout)

Mobile.hideKeyboard()

Mobile.tap(findTestObject('Object Repository/mobile/User Profile/Account Settings Label/Change Password/Save Password'), 
    GlobalVariable.ShortTimeout)

Mobile.verifyElementText(findTestObject('Object Repository/mobile/User Profile/Account Settings Label/Change Password/Can Not Same Error'), 
    NewPasswordCanNotSameError)

CustomKeywords.'mobile.BasePage.quitDriver'()