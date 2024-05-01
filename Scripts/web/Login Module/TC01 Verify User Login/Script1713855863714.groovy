import web.HomePage
import web.LoginPage as LoginPage
import config.FrameworkConfig

import org.testng.Assert

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import config.Constant as Constant
import utils.FileOperations as FileOperations

String HOMEPAGEHEADING = (String) FileOperations.getValueFromJsonFile(Constant.LOGIN_TESTDATA, "HomePageHeading")

CustomKeywords.'web.BasePage.webSetUp'()

String pageHeading = (CustomKeywords.'web.LoginPage.userLogin'(FrameworkConfig.webUseremail, FrameworkConfig.webUserPassword))
Assert.assertEquals(pageHeading.trim(), HOMEPAGEHEADING)

CustomKeywords.'web.BasePage.quitDriver'()