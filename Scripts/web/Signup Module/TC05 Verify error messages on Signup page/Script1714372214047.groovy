import org.testng.Assert

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import config.Constant
import locatorCall.LocatorName
import utils.FileOperations
import web.HomePage
import web.SignupPage


SignupPage signupPage = new SignupPage()
HomePage homePage = new HomePage()

List<String> ERRORLIST = FileOperations.getJsonArray(Constant.SIGNUP_TESTDATA, 'SignupPageErrors')

signupPage.webSetUp()
signupPage.moveToSignupPage()

List<String> actualErrors = signupPage.getSignupPageTextList(LocatorName.SIGNUPERROR)
Assert.assertEquals(actualErrors, ERRORLIST)

homePage.quitDriver()