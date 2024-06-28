import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory as MobileDriverFactory
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
import org.openqa.selenium.WebElement as WebElement
import org.openqa.selenium.WebElement as Keys
import org.testng.Assert

Mobile.startApplication(GlobalVariable.AppPath, true)

Mobile.verifyElementExist(findTestObject('Object Repository/Login/Login Base Objects/ContinueWithEmailBtn'), GlobalVariable.Timeout)

Mobile.tap(findTestObject('Login/Login Base Objects/ContinueWithEmailBtn'), GlobalVariable.ShortTimeout)

Mobile.setText(findTestObject('Object Repository/Login/Email Screen/Email Input Field'), GlobalVariable.UserEmail, GlobalVariable.ShortTimeout)

Mobile.tap(findTestObject('Object Repository/Login/Login Base Objects/Continue Or Login Button'), GlobalVariable.ShortTimeout)

Mobile.setText(findTestObject('Object Repository/Login/Password Screen/Password Input Field'), GlobalVariable.UserPassword, 
    GlobalVariable.ShortTimeout)

Mobile.waitForElementPresent(findTestObject('Object Repository/Login/Password Screen/Password Input Field'), GlobalVariable.ShortTimeout)

Mobile.tap(findTestObject('Object Repository/Login/Login Base Objects/Continue Or Login Button'), GlobalVariable.ShortTimeout)

isWelcomeScreen = Mobile.verifyElementVisible(findTestObject('Object Repository/Login/Login Base Objects/Maybe Later Button'), 
    GlobalVariable.Timeout)

if (isWelcomeScreen) {
    Mobile.tap(findTestObject('Object Repository/Login/Login Base Objects/Maybe Later Button'), GlobalVariable.ShortTimeout)
}

Mobile.tap(findTestObject('Object Repository/Home/User Profile Tab'), GlobalVariable.ShortTimeout)

Mobile.tap(findTestObject('Object Repository/User Profile/Account Settings Label/Account Settings Label Option'), GlobalVariable.ShortTimeout)

Mobile.verifyElementText(findTestObject('Object Repository/User Profile/Account Settings Label/Account Settings Screen Title'), 
    ScreenTitle)

driver = MobileDriverFactory.getDriver()

elements = driver.findElementsByXPath('//*[@resource-id = \'account-settings.title\']/following-sibling::android.widget.Button')

isDisplay = true

for (WebElement element : elements) {
    if (!element.isDisplayed()) {
       isDisplay = false
    }
}

Assert.assertTrue(isDisplay, "The all elements are not visible.")

Mobile.closeApplication()