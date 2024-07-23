package mobile
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil

import internal.GlobalVariable
import io.appium.java_client.android.AndroidDriver




class BasePage {

	private AndroidDriver driver;

	@Keyword
	public void mobileSetUp() {
		MobileBuiltInKeywords.startApplication(GlobalVariable.mobileAPKPath, true);
	}

	@Keyword
	public void quitDriver() {
		MobileBuiltInKeywords.closeApplication();
	}

	@Keyword
	def WebDriver getCurrentSessionMobileDriver() {
		return MobileDriverFactory.getDriver();
	}
}