import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import locatorCall.LocatorName as LocatorName
import org.openqa.selenium.Keys as Keys
import org.testng.Assert as Assert
import config.Constant as Constant
import config.FrameworkConfig as FrameworkConfig
import utils.FileOperations as FileOperations
import utils.FileOperations as File
import web.HomePage as HomePage
import web.LoginPage as LoginPage

HomePage homePage = new HomePage()

LoginPage loginPage = new LoginPage()

String EXPECTEDPOPUPHEADING = ((FileOperations.getValueFromJsonFile(Constant.HOME_TESTDATA, 'LeavePopupHeading')) as String)

List<String> POPUPLABELS = FileOperations.getJsonArray(Constant.HOME_TESTDATA, 'LeavePopupLabels')

homePage.webSetUp()

loginPage.userLogin(FrameworkConfig.webUseremail, FrameworkConfig.webUserPassword)

String popupHeading = homePage.clickOnHomePageItem(LocatorName.REQUESTTIMEOFF)

Assert.assertEquals(popupHeading, EXPECTEDPOPUPHEADING)

List<String> actualLabels = homePage.getListOfHomePageItems(LocatorName.REQUESTTIMEOFF)

Assert.assertEquals(actualLabels, POPUPLABELS)

boolean isPopupFiledAndBtn = homePage.isHomePageElementVisible(LocatorName.REQUESTTIMEOFF)

Assert.assertTrue(isPopupFiledAndBtn, 'All popup fileds and buttons are not visible.')

homePage.quitDriver()