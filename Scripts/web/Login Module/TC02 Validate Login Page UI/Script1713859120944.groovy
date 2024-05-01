import org.testng.Assert

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import web.HomePage
import web.LoginPage as LoginPage
import config.Constant as Constant
import utils.FileOperations as FileOperations

LoginPage loginPage = new LoginPage()
HomePage homePage = new HomePage()

List<String> LOGINPAGETEXTLIST = FileOperations.getJsonArray(Constant.LOGIN_TESTDATA, 'LoginPageTexts')

loginPage.webSetUp()

boolean isElement = loginPage.isLoginPageElementVisible()
Assert.assertTrue(isElement, "The all login page elements are not visible") 

List<String> pageTexts = loginPage.getLoginPageTextList()

Assert.assertEquals(pageTexts, LOGINPAGETEXTLIST)

homePage.quitDriver()