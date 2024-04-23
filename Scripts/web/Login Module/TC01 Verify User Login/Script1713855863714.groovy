import web.LoginPage as LoginPage
import config.FrameworkConfig

import static org.junit.Assert.assertEquals

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import config.Constant as Constant
import utils.FileOperations as FileOperations

LoginPage loginPage = new LoginPage()
String HOMEPAGEHEADING = FileOperations.getValueFromJsonFile(Constant.LOGIN_TESTDATA, "HomePageHeading")

loginPage.webSetUp()

String pageHeading = loginPage.userLogin(FrameworkConfig.webUseremail, FrameworkConfig.webUserPassword).trim()

assertEquals(pageHeading, HOMEPAGEHEADING)

WebUI.closeBrowser()