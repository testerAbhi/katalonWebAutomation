import org.testng.Assert as Assert
import config.Constant as Constant
import config.FrameworkConfig as FrameworkConfig
import locatorCall.LocatorName as LocatorName
import utils.FileOperations as FileOperations

String EXPECTEDPOPUPHEADING = ((FileOperations.getValueFromJsonFile(Constant.HOME_TESTDATA, 'LeavePopupHeading')) as String)
List<String> POPUPLABELS = FileOperations.getJsonArray(Constant.HOME_TESTDATA, 'LeavePopupLabels')

CustomKeywords.'web.BasePage.webSetUp'()
CustomKeywords.'web.LoginPage.userLogin'(FrameworkConfig.webUseremail, FrameworkConfig.webUserPassword)

String popupHeading = CustomKeywords.'web.HomePage.clickOnHomePageItem'(LocatorName.REQUESTTIMEOFF)
Assert.assertEquals(popupHeading, EXPECTEDPOPUPHEADING)

List<String> actualLabels = CustomKeywords.'web.HomePage.getListOfHomePageItems'(LocatorName.REQUESTTIMEOFF)
Assert.assertEquals(actualLabels, POPUPLABELS)

boolean isPopupFiledAndBtn = CustomKeywords.'web.HomePage.isHomePageElementVisible'(LocatorName.REQUESTTIMEOFF)
Assert.assertTrue(isPopupFiledAndBtn, 'All popup fileds and buttons are not visible.')

CustomKeywords.'web.BasePage.quitDriver'()