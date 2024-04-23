import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import javax.xml.bind.annotation.XmlElementDecl.GLOBAL as GLOBAL
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import config.Constant
import groovy.console.ui.Console as Console
import internal.GlobalVariable
import utils.FileOperations

import org.openqa.selenium.Keys
import org.openqa.selenium.WebElement
import org.testng.Assert


def POPUP_HEADING = FileOperations.getValue(Constant.HOME_MODULE_TESTDATA, "PopupHeading")

WebUI.openBrowser(GlobalVariable.webBaseURL)

WebUI.maximizeWindow()

WebUI.click(findTestObject('null'))

WebUI.click(findTestObject('null'))

WebUI.verifyElementVisible(findTestObject('null'))

//def heading = WebUI.getText(findTestObject('null')).replaceAll("\n", "")
//Assert.assertArrayEquals(heading, POPUP_HEADING, "does not match")

def elements = findTestObject('null');
List<WebElement> eles = WebUiBuiltInKeywords.findWebElements(elements, 10)
println(eles.size())
List<String> list = new ArrayList<String>()
for(WebElement e: eles) {
	String str = e.getText()
	list.add(str)
}

Assert.assertArrayEquals(list, Points, "List do not match")


