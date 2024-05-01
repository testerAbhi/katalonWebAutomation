import org.testng.Assert

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import config.Constant
import locatorCall.LocatorName
import utils.FileOperations
import web.HomePage
import web.SignupPage as SignupPage

List<String> SIGNUPPAGETEXTLIST = FileOperations.getJsonArray(Constant.SIGNUP_TESTDATA, 'SignupPageTexts')

CustomKeywords.'web.BasePage.webSetUp'()
CustomKeywords.'web.SignupPage.moveToSignupPage'()

boolean isElement = CustomKeywords.'web.SignupPage.isSignupPageElementVisible'()
Assert.assertTrue(isElement, 'All signup elements are not visible.')

List<String> pageTextList = CustomKeywords.'web.SignupPage.getSignupPageTextList'(LocatorName.SIGNUP)
Assert.assertEquals(pageTextList, SIGNUPPAGETEXTLIST)

CustomKeywords.'web.BasePage.quitDriver'()