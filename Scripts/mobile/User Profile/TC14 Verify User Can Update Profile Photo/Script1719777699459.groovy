import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory as MobileDriverFactory
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import internal.GlobalVariable as GlobalVariable
import io.appium.java_client.android.AndroidDriver as AndroidDriver

CustomKeywords.'mobile.BasePage.mobileSetUp'()

def driver = MobileDriverFactory.getDriver()

    ((driver) as AndroidDriver).pushFile('/sdcard/download/UserPhoto.png', new File(ImagePath))

CustomKeywords.'mobile.LoginPage.clickOnContinueWithEmail'()

CustomKeywords.'mobile.LoginPage.mobileUserLogin'(GlobalVariable.UserEmail, GlobalVariable.UserPassword)

isWelcomeScreen = Mobile.verifyElementVisible(findTestObject('Object Repository/mobile/Login/Login Base Objects/Maybe Later Button'), 
    GlobalVariable.Timeout, FailureHandling.OPTIONAL)

if (isWelcomeScreen) {
    Mobile.tap(findTestObject('Object Repository/mobile/Login/Login Base Objects/Maybe Later Button'), GlobalVariable.ShortTimeout)
}

Mobile.tap(findTestObject('Object Repository/mobile/Home/User Profile Tab'), GlobalVariable.ShortTimeout)

Mobile.tap(findTestObject('Object Repository/mobile/User Profile/User Profile Base Objects/Edit User Profile Photo'), GlobalVariable.ShortTimeout)

Mobile.tap(findTestObject('Object Repository/mobile/User Profile/User Profile Base Objects/Choose from Library Option'), 
    GlobalVariable.ShortTimeout)

Mobile.tap(findTestObject('Object Repository/mobile/User Profile/User Profile Base Objects/Select Photo'), GlobalVariable.ShortTimeout)

Mobile.tap(findTestObject('Object Repository/mobile/User Profile/User Profile Base Objects/Crop Image'), GlobalVariable.ShortTimeout)

Mobile.verifyElementText(findTestObject('Object Repository/mobile/User Profile/User Profile Base Objects/Photo Updated Message'), 
    SuccessMessage)

CustomKeywords.'mobile.BasePage.quitDriver'()