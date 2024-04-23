import org.testng.Assert

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import config.Constant as Constant
import utils.FileOperations as FileOperations
import web.SignupPage as SignupPage

SignupPage signupPage = new SignupPage()

List<String> SIGNUPPAGETEXTLIST = FileOperations.getJsonArray(Constant.SIGNUP_TESTDATA, 'SignupPageTexts')

signupPage.webSetUp()
signupPage.moveToSignupPage()

boolean isElement = signupPage.isSignupPageElementVisible()
Assert.assertTrue(isElement, 'All signup elements are not visible.')

List<String> pageTextList = signupPage.getSignupPageTextList()
Assert.assertEquals(pageTextList, SIGNUPPAGETEXTLIST)

WebUI.closeBrowser()