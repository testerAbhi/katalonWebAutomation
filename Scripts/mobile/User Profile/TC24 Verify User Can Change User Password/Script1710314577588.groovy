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

userEmail = getValueByKey(GlobalVariable.UserDataFilePath, "UserEmail")
userPassword = getValueByKey(GlobalVariable.UserDataFilePath, "UserPassword")
newPassword = generateNewPassword()

Mobile.startApplication(GlobalVariable.AppPath, true)

Mobile.verifyElementExist(findTestObject('Object Repository/Login/Login Base Objects/ContinueWithEmailBtn'), GlobalVariable.Timeout)

Mobile.tap(findTestObject('Login/Login Base Objects/ContinueWithEmailBtn'), GlobalVariable.ShortTimeout)

Mobile.setText(findTestObject('Object Repository/Login/Email Screen/Email Input Field'), userEmail, GlobalVariable.ShortTimeout)

Mobile.tap(findTestObject('Object Repository/Login/Login Base Objects/Continue Or Login Button'), GlobalVariable.ShortTimeout)

Mobile.setText(findTestObject('Object Repository/Login/Password Screen/Password Input Field'), userPassword,
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

Mobile.tap(findTestObject('Object Repository/User Profile/Account Settings Label/Change Password/Change Password Option'),
		GlobalVariable.ShortTimeout)

Mobile.setText(findTestObject('Object Repository/User Profile/Account Settings Label/Change Password/Current Password Field'),
		userPassword, GlobalVariable.ShortTimeout)

Mobile.setText(findTestObject('Object Repository/User Profile/Account Settings Label/Change Password/New Password Field'),
		newPassword, GlobalVariable.ShortTimeout)

Mobile.setText(findTestObject('Object Repository/User Profile/Account Settings Label/Change Password/Re-enter New Password Field'),
		newPassword, GlobalVariable.ShortTimeout)

Mobile.hideKeyboard()

Mobile.tap(findTestObject('Object Repository/User Profile/Account Settings Label/Change Password/Save Password'), GlobalVariable.ShortTimeout)

Mobile.verifyElementText(findTestObject('Object Repository/User Profile/Account Settings Label/Change Password/Password Updated Message'), SuccessMessage)

println "New Password: "+ newPassword

Mobile.closeApplication()

updateKeyValue(GlobalVariable.UserDataFilePath, "UserPassword", newPassword)

def getValueByKey(String filePath, String key) {
	def lines = new File(filePath).readLines()
	for (line in lines) {
		def (k, v) = line.split('=')
		if (k.trim() == key) {
			return v.trim()
		}
	}
	return null
}

def updateKeyValue(String filePath, String key, String newValue) {
	def lines = new File(filePath).readLines()
	def updatedLines = lines.collect { line ->
		def (k, v) = line.split('=')
		if (k.trim() == key) {
			return "${key.trim()}=${newValue.trim()}"
		} else {
			return line
		}
	}
	new File(filePath).write(updatedLines.join('\n'))
}

def generateNewPassword() {
	Random random = new Random()
	int value = random.nextInt(100, 1000)
	return "testing" + value
}