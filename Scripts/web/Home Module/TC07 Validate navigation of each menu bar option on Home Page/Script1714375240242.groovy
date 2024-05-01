import org.testng.Assert as Assert
import config.Constant as Constant
import config.FrameworkConfig as FrameworkConfig
import utils.FileOperations as FileOperations

List<String> NAVIGATIONTEXTLIST = FileOperations.getJsonArray(Constant.HOME_TESTDATA, 'NavigatedTextList')

CustomKeywords.'web.BasePage.webSetUp'()

CustomKeywords.'web.LoginPage.userLogin'(FrameworkConfig.webUseremail, FrameworkConfig.webUserPassword)

List<String> pageTexts = CustomKeywords.'web.HomePage.navigateAndGetText'()

Assert.assertEquals(pageTexts, NAVIGATIONTEXTLIST)

CustomKeywords.'web.BasePage.quitDriver'()