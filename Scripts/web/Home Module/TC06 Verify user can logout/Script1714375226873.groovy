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

import config.Constant
import config.FrameworkConfig
import internal.GlobalVariable
import utils.FileOperations
import web.HomePage
import web.LoginPage

import org.openqa.selenium.Keys
import org.testng.Assert
import org.testng.Assert as Keys

HomePage homePage = new HomePage()
LoginPage loginPage = new LoginPage()

String LOGINPAGEHEADING = (String) FileOperations.getValueFromJsonFile(Constant.LOGIN_TESTDATA, "PageHeading")

homePage.webSetUp()
loginPage.userLogin(FrameworkConfig.webUseremail, FrameworkConfig.webUserPassword)

String pageHeading = homePage.userLogout()

Assert.assertEquals(pageHeading, LOGINPAGEHEADING)

homePage.quitDriver()