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

String newEmail = generateRandomEmail()
Mobile.setText(findTestObject('Object Repository/Login/Email Screen/Email Input Field'), newEmail, GlobalVariable.ShortTimeout)
Mobile.tap(findTestObject('Object Repository/Login/Login Base Objects/Continue Or Login Button'), GlobalVariable.ShortTimeout)

Mobile.hideKeyboard()
Mobile.tap(findTestObject('Object Repository/Signup/User Detail Screen/Continue Button'), GlobalVariable.ShortTimeout)

Mobile.verifyElementText(findTestObject('Object Repository/Signup/User Detail Screen/Blank First Name Error'), BlankFirstName)
Mobile.verifyElementText(findTestObject('Object Repository/Signup/User Detail Screen/Blank Last Name Error'), BlankLastName)

Mobile.closeApplication()

def generateRandomEmail() {
	def alphabet = (('a'..'z') + ('A'..'Z')) + ('0'..'9')

	def randomName = ((alphabet[new Random().nextInt(alphabet.size())]) as char)

	for (int i = 1; i < 8; i++) {
		randomName += ((alphabet[new Random().nextInt(alphabet.size())]) as char)
	}
	
	return ('testkinuser+' + randomName) + '@kin.co'
}