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
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory as MobileDriverFactory
import io.appium.java_client.AppiumDriver as AppiumDriver

Mobile.startExistingApplication(GlobalVariable.apps, FailureHandling.STOP_ON_FAILURE)

'Melakukan validasi splashscreen apabila muncul'
Mobile.verifyElementExist(findTestObject('TS-DK02 - Auth/TC-DK07/Splashscreen/ImageView - Splashscreen'), 0, FailureHandling.OPTIONAL)

'Melakukan validasi logo pada halaman login'
Mobile.verifyElementExist(findTestObject('TS-DK02 - Auth/TC-DK07/Login/logo - login'), 45, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementExist(findTestObject('TS-DK02 - Auth/TC-DK07/Login/Text Field - Email'), 0, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementExist(findTestObject('TS-DK02 - Auth/TC-DK07/Login/TextField - Kata Sandi'), 0, FailureHandling.STOP_ON_FAILURE)

Mobile.setText(findTestObject('TS-DK02 - Auth/TC-DK07/Login/Text Field - Email'), GlobalVariable.InvalidEmail, 0)

Mobile.setEncryptedText(findTestObject('TS-DK02 - Auth/TC-DK07/Login/TextField - Kata Sandi'), GlobalVariable.InvalidPassword, 
    0)

Mobile.tap(findTestObject('TS-DK02 - Auth/TC-DK07/Login/Button - Masuk'), 0)

'Melakukan validasi logo pada halaman login'
Mobile.verifyElementExist(findTestObject('TS-DK02 - Auth/TC-DK07/Login/ImageView - icon (popup)'), 45, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementExist(findTestObject('TS-DK02 - Auth/TC-DK07/Login/Text - Title (popup)'), 0, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementExist(findTestObject('TS-DK02 - Auth/TC-DK07/Login/Text - Message (popup)'), 0, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementExist(findTestObject('TS-DK02 - Auth/TC-DK07/Login/Button - OKE (popup)'), 0, FailureHandling.STOP_ON_FAILURE)

Mobile.delay(2, FailureHandling.STOP_ON_FAILURE)

'Fungsi untuk close application ketika membuka aplikasi menggunakan Mobile.StartExisitingApplication()'
AppiumDriver<?> driver = MobileDriverFactory.getDriver()

driver.terminateApp(GlobalVariable.apps)

