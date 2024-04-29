import org.testng.Assert

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import config.Constant
import locatorCall.LocatorName
import utils.FileOperations
import web.HomePage
import web.SignupPage as SignupPage

SignupPage signupPage = new SignupPage()
HomePage homePage = new HomePage()

List<String> SIGNUPPAGETEXTLIST = FileOperations.getJsonArray(Constant.SIGNUP_TESTDATA, 'SignupPageTexts')

signupPage.webSetUp()
signupPage.moveToSignupPage()

boolean isElement = signupPage.isSignupPageElementVisible()
Assert.assertTrue(isElement, 'All signup elements are not visible.')

List<String> pageTextList = signupPage.getSignupPageTextList(LocatorName.SIGNUP)
Assert.assertEquals(pageTextList, SIGNUPPAGETEXTLIST)

homePage.quitDriver()