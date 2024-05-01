import org.testng.Assert

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import config.Constant
import locatorCall.LocatorName
import utils.FileOperations
import web.HomePage
import web.SignupPage

List<String> ERRORLIST = FileOperations.getJsonArray(Constant.SIGNUP_TESTDATA, 'SignupPageErrors')

CustomKeywords.'web.BasePage.webSetUp'()
CustomKeywords.'web.SignupPage.moveToSignupPage'()

List<String> actualErrors = CustomKeywords.'web.SignupPage.getSignupPageTextList'(LocatorName.SIGNUPERROR)
Assert.assertEquals(actualErrors, ERRORLIST)

CustomKeywords.'web.BasePage.quitDriver'()