import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling

import internal.GlobalVariable as GlobalVariable

userEmail = getValueByKey(UserDataFilePath, 'UserEmail')

userPassword = getValueByKey(UserDataFilePath, 'UserPassword')

newPassword = generateNewPassword()

CustomKeywords.'mobile.BasePage.mobileSetUp'()

CustomKeywords.'mobile.LoginPage.clickOnContinueWithEmail'()

CustomKeywords.'mobile.LoginPage.mobileUserLogin'(GlobalVariable.UserEmail, GlobalVariable.UserPassword)

isWelcomeScreen = Mobile.verifyElementVisible(findTestObject('Object Repository/mobile/Login/Login Base Objects/Maybe Later Button'), 
    GlobalVariable.Timeout, FailureHandling.OPTIONAL)

if (isWelcomeScreen) {
    Mobile.tap(findTestObject('Object Repository/mobile/Login/Login Base Objects/Maybe Later Button'), GlobalVariable.ShortTimeout)
}

Mobile.tap(findTestObject('Object Repository/mobile/Home/User Profile Tab'), GlobalVariable.ShortTimeout)

Mobile.tap(findTestObject('Object Repository/mobile/User Profile/Account Settings Label/Account Settings Label Option'), 
    GlobalVariable.ShortTimeout)

Mobile.tap(findTestObject('Object Repository/mobile/User Profile/Account Settings Label/Change Password/Change Password Option'), 
    GlobalVariable.ShortTimeout)

Mobile.setText(findTestObject('Object Repository/mobile/User Profile/Account Settings Label/Change Password/Current Password Field'), 
    userPassword, GlobalVariable.ShortTimeout)

Mobile.setText(findTestObject('Object Repository/mobile/User Profile/Account Settings Label/Change Password/New Password Field'), 
    newPassword, GlobalVariable.ShortTimeout)

Mobile.setText(findTestObject('Object Repository/mobile/User Profile/Account Settings Label/Change Password/Re-enter New Password Field'), 
    newPassword, GlobalVariable.ShortTimeout)

Mobile.hideKeyboard()

Mobile.tap(findTestObject('Object Repository/mobile/User Profile/Account Settings Label/Change Password/Save Password'), 
    GlobalVariable.ShortTimeout)

//Mobile.verifyElementText(findTestObject('Object Repository/mobile/User Profile/Account Settings Label/Change Password/Password Updated Message'), 
//    SuccessMessage)

println('New Password: ' + newPassword)

CustomKeywords.'mobile.BasePage.quitDriver'();

updateKeyValue(UserDataFilePath, 'UserPassword', newPassword);

def getValueByKey(String filePath, String key) {
    def lines = new File(filePath).readLines()

    for (def line : lines) {
        def (k, v)=line.split('=')

        if (k.trim() == key) {
            return v.trim()
        }
    }
    
    return null
}

def updateKeyValue(String filePath, String key, String newValue) {
    def lines = new File(filePath).readLines()

    def updatedLines = lines.collect({ def line ->
            def (k, v)=line.split('=')

            if (k.trim() == key) {
                return "$key.trim()=$newValue.trim()"
            } else {
                return line
            }
        })

    new File(filePath).write(updatedLines.join('\n'))
}

def generateNewPassword() {
    Random random = new Random()

    int value = random.nextInt(100, 1000)

    return 'testing' + value
}