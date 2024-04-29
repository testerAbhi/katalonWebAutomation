import org.testng.Assert

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import config.Constant
import locatorCall.LocatorName
import utils.FileOperations
import web.SignupPage


SignupPage signupPage = new SignupPage()

List<String> ERRORLIST = FileOperations.getJsonArray(Constant.SIGNUP_TESTDATA, 'SignupPageErrors')

signupPage.webSetUp()
signupPage.moveToSignupPage()

List<String> actualErrors = signupPage.getSignupPageTextList(LocatorName.SIGNUPERROR)
Assert.assertEquals(actualErrors, ERRORLIST)

WebUI.closeBrowser()