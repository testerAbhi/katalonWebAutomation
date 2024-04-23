package web

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable

public class LoginPage extends BasePage{

	public String userLogin(String email, String password) {
		WebUI.waitForElementPresent(findTestObject('Object Repository/web/Login Page/Text_Page Heading'), GlobalVariable.Timeout)
		WebUI.setText(findTestObject('Object Repository/web/Login Page/Input_Login Email'), email)
		WebUI.setText(findTestObject('Object Repository/web/Login Page/Input_Login_password'), password)
		WebUI.click(findTestObject('Object Repository/web/Login Page/Button_Log In'))
		return WebUI.getText(findTestObject('Object Repository/web/Home Page/Text_Page heading'))
	}
}
