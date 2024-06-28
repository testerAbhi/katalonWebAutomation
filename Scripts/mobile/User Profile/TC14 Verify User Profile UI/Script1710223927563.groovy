import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import java.time.Duration as Duration
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
import org.openqa.selenium.interactions.PointerInput as PointerInput
import org.openqa.selenium.interactions.PointerInput as Keys
import org.openqa.selenium.interactions.Sequence as Sequence
import org.openqa.selenium.remote.RemoteWebDriver as RemoteWebDriver

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

Mobile.verifyElementVisible(findTestObject('Object Repository/Home/Home Screen Title'), GlobalVariable.ShortTimeout)

Mobile.tap(findTestObject('Object Repository/Home/User Profile Tab'), GlobalVariable.ShortTimeout)

Mobile.verifyElementVisible(findTestObject('Object Repository/User Profile/User Profile Base Objects/Edit User Profile Button'), 
    GlobalVariable.ShortTimeout)

Mobile.verifyElementVisible(findTestObject('Object Repository/User Profile/User Profile Base Objects/User Profile Image'), 
    GlobalVariable.ShortTimeout)

Mobile.verifyElementVisible(findTestObject('Object Repository/User Profile/User Profile Base Objects/Edit User Profile Photo'), 
    GlobalVariable.ShortTimeout)

Mobile.verifyElementText(findTestObject('Object Repository/User Profile/User Profile Base Objects/User Entered Name'), UserName)

Mobile.verifyElementText(findTestObject('Object Repository/User Profile/User Profile Base Objects/User Registered Email'), 
    GlobalVariable.UserEmail)

Mobile.verifyElementText(findTestObject('Object Repository/User Profile/User Profile Base Objects/Profile Support'), SupportLabelText)

Mobile.verifyElementText(findTestObject('Object Repository/User Profile/Subscribe Label/Subscribe Label Option'), SuscribeOption)

Mobile.verifyElementText(findTestObject('Object Repository/User Profile/Account Settings Label/Account Settings Label Option'), 
    AccountSettingsOption)

Mobile.verifyElementText(findTestObject('Object Repository/User Profile/Email Support Label/Email Support Label Option'), 
    EmailSupportOption)

Mobile.verifyElementText(findTestObject('Object Repository/User Profile/User Profile Base Objects/App Settings Label'), 
    AppSettingsLabelText)

Mobile.verifyElementText(findTestObject('Object Repository/User Profile/Notification Settings Label/Notification Settings Label Option'), 
    NotificationOption)

scrollDown()

Mobile.verifyElementText(findTestObject('Object Repository/User Profile/Privacy Policy Setting Label/Privacy Policy Label Option'), 
    PrivacyPolicyOption)

Mobile.verifyElementText(findTestObject('Object Repository/User Profile/Term Label/Terms Label Option'), TermOption)

Mobile.verifyElementText(findTestObject('Object Repository/User Profile/Ad Choice Label/Ad Choices Label Option'), AdChoiceOption)

Mobile.verifyElementText(findTestObject('Object Repository/User Profile/Logout Label/Logout Button'), LogoutOption)

Mobile.closeApplication()

void scrollDown() {
    RemoteWebDriver driver = ((MobileDriverFactory.getDriver()) as RemoteWebDriver)

    device_Height = Mobile.getDeviceHeight()

    device_Width = Mobile.getDeviceWidth()

    int startX = device_Width / 2

    int endX = startX

    int startY = device_Height * 0.70

    int endY = device_Height * 0.30

    PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, 'first-finger')

    Sequence sequence = new Sequence(finger, 0).addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), 
            startX, startY))

    sequence.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))

    sequence.addAction(finger.createPointerMove(Duration.ofMillis(300), PointerInput.Origin.viewport(), endX, endY))

    sequence.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()))

    driver.perform(Collections.singletonList(sequence))
}