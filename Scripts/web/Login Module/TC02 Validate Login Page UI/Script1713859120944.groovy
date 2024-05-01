import org.testng.Assert as Assert
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import web.HomePage as HomePage
import web.LoginPage as LoginPage
import config.Constant as Constant
import utils.FileOperations as FileOperations

List<String> LOGINPAGETEXTLIST = FileOperations.getJsonArray(Constant.LOGIN_TESTDATA, 'LoginPageTexts')

CustomKeywords.'web.BasePage.webSetUp'()

boolean isElement = CustomKeywords.'web.LoginPage.isLoginPageElementVisible'()

Assert.assertTrue(isElement, 'The all login page elements are not visible')

List<String> pageTexts = CustomKeywords.'web.LoginPage.getLoginPageTextList'()

Assert.assertEquals(pageTexts, LOGINPAGETEXTLIST)

CustomKeywords.'web.BasePage.quitDriver'()