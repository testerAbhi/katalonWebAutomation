package web

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import utils.Generic

public class AllHandsPage extends BasePage {

	@Keyword
	def createEmployee(String empName, String email, String empNo, String empDept){
		WebUI.click(findTestObject('Object Repository/web/All Hands Page/Button_Add employee'))
		enterPersonalInfo(empName, email)
		String msg = enterEmployeeDetails(empNo, empDept)
		if(msg.equals("Employee number already exist")) {
			WebUI.click(findTestObject('Object Repository/web/All Hands Page/Button_Emp details tab'))
			String number = (String) (Integer.parseInt(empNo) + Generic.generateRandomNumber(0, 100))
			WebUI.setText(findTestObject('Object Repository/web/All Hands Page/Input_Emp number'), number)
			WebUI.click(findTestObject('Object Repository/web/All Hands Page/Button_Save and Next emp details'))
			msg = WebUI.getText(findTestObject('Object Repository/web/All Hands Page/Text_Employee created'))
		}
		return msg
	}

	public void enterPersonalInfo(String... str) {
		WebUI.setText(findTestObject('Object Repository/web/All Hands Page/Input_Enter employee name'), str[0])
		selectRandomDorpdownValue(findTestObject('Object Repository/web/All Hands Page/Dropdown_Select gender'))
		String dob = Generic.generateRandomDOB(25)
		println dob
		WebUI.setText(findTestObject('Object Repository/web/All Hands Page/Input_DOB'), dob)
		WebUI.setText(findTestObject('Object Repository/web/All Hands Page/Input_Email field'), str[1])
		WebUI.click(findTestObject('Object Repository/web/All Hands Page/Button_Next personal info'))
	}

	public String enterEmployeeDetails(String... str) {
		println selectRandomDorpdownValue(findTestObject('Object Repository/web/All Hands Page/Dropdown_Select emp type'))
		println selectRandomDorpdownValue(findTestObject('Object Repository/web/All Hands Page/Dropdown_Select emp series'))
		WebUI.setText(findTestObject('Object Repository/web/All Hands Page/Input_Emp number'), str[0])
		println selectRandomDorpdownValue(findTestObject('Object Repository/web/All Hands Page/Dropdown_Designation'))
		println selectRandomDorpdownValue(findTestObject('Object Repository/web/All Hands Page/Dropdown_Grade'))
		WebUI.setText(findTestObject('Object Repository/web/All Hands Page/Input_Start date'), Generic.generateRandomDOB(0))
		println selectRandomDorpdownValue(findTestObject('Object Repository/web/All Hands Page/Dropdowm_RM'))
		WebUI.setText(findTestObject('Object Repository/web/All Hands Page/Button Input_Department'), str[1])
		println selectRandomDorpdownValue(findTestObject('Object Repository/web/All Hands Page/Dropdown_Location'))
		WebUI.click(findTestObject('Object Repository/web/All Hands Page/Button_Save and Next emp details'))
		return WebUI.getText(findTestObject('Object Repository/web/All Hands Page/Text_Employee created'))
	}
}
