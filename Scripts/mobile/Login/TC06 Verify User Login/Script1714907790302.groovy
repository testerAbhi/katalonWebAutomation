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
import org.openqa.selenium.Keys as Keys

Mobile.startApplication(GlobalVariable.AppPath, true)

Mobile.verifyElementExist(findTestObject('Object Repository/Login/Login Base Objects/ContinueWithEmailBtn'), GlobalVariable.Timeout)
Mobile.tap(findTestObject('Login/Login Base Objects/ContinueWithEmailBtn'), GlobalVariable.ShortTimeout)

Mobile.setText(findTestObject('Object Repository/Login/Email Screen/Email Input Field'), GlobalVariable.UserEmail, GlobalVariable.ShortTimeout)
Mobile.tap(findTestObject('Object Repository/Login/Login Base Objects/Continue Or Login Button'), GlobalVariable.ShortTimeout)

Mobile.setText(findTestObject('Object Repository/Login/Password Screen/Password Input Field'), GlobalVariable.UserPassword, GlobalVariable.ShortTimeout)
Mobile.waitForElementPresent(findTestObject('Object Repository/Login/Password Screen/Password Input Field'), GlobalVariable.ShortTimeout)
Mobile.tap(findTestObject('Object Repository/Login/Login Base Objects/Continue Or Login Button'), GlobalVariable.ShortTimeout)

isWelcomeScreen = Mobile.verifyElementVisible(findTestObject('Object Repository/Login/Login Base Objects/Maybe Later Button'), GlobalVariable.Timeout)
if (isWelcomeScreen) {
	Mobile.tap(findTestObject('Object Repository/Login/Login Base Objects/Maybe Later Button'), GlobalVariable.ShortTimeout)
}

Mobile.verifyElementVisible(findTestObject('Object Repository/Login/Login Base Objects/Subscription Ended Title'), GlobalVariable.ShortTimeout)
Mobile.verifyElementText(findTestObject('Object Repository/Login/Login Base Objects/Subscription Ended Title'), SubscriptionEndedTitle)

Mobile.closeApplication()
