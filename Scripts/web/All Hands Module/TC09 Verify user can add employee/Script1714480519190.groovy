import config.FrameworkConfig as FrameworkConfig

CustomKeywords.'web.BasePage.webSetUp'()
CustomKeywords.'web.LoginPage.userLogin'(FrameworkConfig.webUseremail, FrameworkConfig.webUserPassword)
CustomKeywords.'web.HomePage.clickOnTab'("All Hands")

CustomKeywords.'web.AllHandsPage.createEmployee'("Kin", "abc@kin.co", "3", "IT")