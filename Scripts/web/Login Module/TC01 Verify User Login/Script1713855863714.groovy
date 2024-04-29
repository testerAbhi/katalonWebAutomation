import web.HomePage
import web.LoginPage as LoginPage
import config.FrameworkConfig

import org.testng.Assert

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import config.Constant as Constant
import utils.FileOperations as FileOperations

LoginPage loginPage = new LoginPage()
HomePage homePage = new HomePage()
String HOMEPAGEHEADING = (String) FileOperations.getValueFromJsonFile(Constant.LOGIN_TESTDATA, "HomePageHeading")

loginPage.webSetUp()

String pageHeading = loginPage.userLogin(FrameworkConfig.webUseremail, FrameworkConfig.webUserPassword).trim()

Assert.assertEquals(pageHeading, HOMEPAGEHEADING)

homePage.quitDriver()