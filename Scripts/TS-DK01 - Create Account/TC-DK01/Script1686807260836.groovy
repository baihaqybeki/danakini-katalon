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
Mobile.verifyElementExist(findTestObject('TS-DK01 - Create Account/TC-DK01/Splashscreen/ImageView - Splashscreen'), 0, FailureHandling.OPTIONAL)

'Melakukan validasi logo pada halaman login'
Mobile.verifyElementExist(findTestObject('TS-DK01 - Create Account/TC-DK01/Login/logo - login'), 45, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementExist(findTestObject('TS-DK01 - Create Account/TC-DK01/Login/Text Field - Email'), 0, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementExist(findTestObject('TS-DK01 - Create Account/TC-DK01/Login/TextField - Kata Sandi'), 0, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('TS-DK01 - Create Account/TC-DK01/Login/Link - Daftar'), 0, FailureHandling.STOP_ON_FAILURE)

Mobile.delay(3, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementExist(findTestObject('TS-DK01 - Create Account/TC-DK01/Daftar/TextView - Daftar'), 45, FailureHandling.STOP_ON_FAILURE)

Date time = new Date()

def formattedTime = time.format('HHmmss')

Mobile.setText(findTestObject('TS-DK01 - Create Account/TC-DK01/Daftar/TextField - Nama Lengkap'), GlobalVariable.name, 
    0)

Mobile.setText(findTestObject('TS-DK01 - Create Account/TC-DK01/Daftar/Text Field - No Ponsel'), GlobalVariable.VirtualPhoneNumber, 
    0)

'Generate email dengan penambahan format waktu agar script dinamis'
def email = ('createaccount' + formattedTime) + '@yopmail.com'

Mobile.setText(findTestObject('TS-DK01 - Create Account/TC-DK01/Daftar/Text Field - Email'), email, 0)

Mobile.setEncryptedText(findTestObject('TS-DK01 - Create Account/TC-DK01/Daftar/Text Field - Kata Sandi'), GlobalVariable.KataSandi, 
    0)

Mobile.setEncryptedText(findTestObject('TS-DK01 - Create Account/TC-DK01/Daftar/Text Field - Konfirmasi Kata Sandi'), GlobalVariable.KataSandi, 
    0)

Mobile.tap(findTestObject('TS-DK01 - Create Account/TC-DK01/Daftar/Link - Syarat dan Ketentuan'), 0, FailureHandling.STOP_ON_FAILURE)

boolean isExist = Mobile.verifyElementExist(findTestObject('TS-DK01 - Create Account/TC-DK01/Daftar/Button - Setuju'), 1, 
    FailureHandling.OPTIONAL)

height = Mobile.getDeviceHeight()

'Scroll hingga button setuju muncul'
while (isExist == false) {
    Mobile.swipe(0, height, 0, 0)

    isExist = Mobile.verifyElementExist(findTestObject('TS-DK01 - Create Account/TC-DK01/Daftar/Button - Setuju'), 1, FailureHandling.OPTIONAL)
}

Mobile.tap(findTestObject('TS-DK01 - Create Account/TC-DK01/Daftar/Button - Setuju'), 0, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('TS-DK01 - Create Account/TC-DK01/Daftar/Button - DAFTAR'), 0, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementExist(findTestObject('TS-DK01 - Create Account/TC-DK01/Daftar/TextView - OTP Title (Title Page)'), 45, 
    FailureHandling.STOP_ON_FAILURE)

'delay untuk input OTP secara manual'
Mobile.delay(10, FailureHandling.STOP_ON_FAILURE)

'Masukkan kode OTP yang terkirim secara manual'

Mobile.verifyElementExist(findTestObject('TS-DK01 - Create Account/TC-DK01/Daftar/ImageView - icon (popup)'), 60, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementExist(findTestObject('TS-DK01 - Create Account/TC-DK01/Daftar/TextView - Sukses title (Popup)'), 45, 
    FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementExist(findTestObject('TS-DK01 - Create Account/TC-DK01/Daftar/TextView - Body (Popup)'), 45, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementExist(findTestObject('TS-DK01 - Create Account/TC-DK01/Daftar/Button - OKE (popup)'), 45, FailureHandling.STOP_ON_FAILURE)

//CustomKeywords.'ScrollDown.scrollListToElementWithText'('Hukum yang Berlaku')
'Fungsi untuk close application ketika membuka aplikasi menggunakan Mobile.StartExisitingApplication()'
AppiumDriver<?> driver = MobileDriverFactory.getDriver()

driver.terminateApp(GlobalVariable.apps)

