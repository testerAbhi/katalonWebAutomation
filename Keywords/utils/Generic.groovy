package utils

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import java.time.LocalDate
import java.time.format.DateTimeFormatter

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

public class Generic {
	public static int generateRandomNumber(int max, int min) {
		return min + (int) (Math.random() * ((max - min) + 1))
	}

	public static String generateRandomDOB(int yearsToSubtract) {
		int randomDay = new Random().nextInt(31)
		int randomMonth = new Random().nextInt(12) + 1
		int currentYear = LocalDate.now().getYear()
		int dobYear = currentYear - yearsToSubtract
		LocalDate dob = LocalDate.of(dobYear, randomMonth, randomDay)
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")
		return dob.format(formatter)
	}
}
