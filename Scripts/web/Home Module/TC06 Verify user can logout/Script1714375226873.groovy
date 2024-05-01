import org.testng.Assert

import config.Constant
import config.FrameworkConfig
import utils.FileOperations

String LOGINPAGEHEADING = ((FileOperations.getValueFromJsonFile(Constant.LOGIN_TESTDATA, 'PageHeading')) as String)

CustomKeywords.'web.BasePage.webSetUp'()

CustomKeywords.'web.LoginPage.userLogin'(FrameworkConfig.webUseremail, FrameworkConfig.webUserPassword)

String pageHeading = CustomKeywords.'web.HomePage.userLogout'()

Assert.assertEquals(pageHeading, LOGINPAGEHEADING)

CustomKeywords.'web.BasePage.quitDriver'()