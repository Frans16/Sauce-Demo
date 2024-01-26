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
import org.openqa.selenium.Keys
import org.openqa.selenium.WebElement
import org.openqa.selenium.WebElement as Keys

for(def rowNum=1;rowNum<=findTestData("testData").getRowNumbers();rowNum++) {
	
	TestObject inputUsername = findTestObject('Object Repository/Read Data/input_username')
	WebUI.delay(2)
	WebUI.sendKeys(inputUsername,findTestData("testData").getValue(1, rowNum))
	
	TestObject inputEmail = findTestObject("Object Repository/Read Data/input_email")
	WebUI.delay(2)
	WebUI.sendKeys(inputEmail,findTestData("testData").getValue(2, rowNum))
	
	TestObject inputPhoneNumber = findTestObject("Object Repository/Read Data/input_phoneNumber")
	WebUI.delay(2)
	WebUI.sendKeys(inputPhoneNumber,findTestData("testData").getValue(3, rowNum))
	
	TestObject selectGender = findTestObject("Object Repository/Read Data/select_gender")
	WebUI.delay(2)
	WebUI.selectOptionByValue(selectGender, findTestData("testData").getValue(4, rowNum), false)
	
	TestObject radioYearofExperience = findTestObject("Object Repository/Read Data/radio_yearExperience")
	WebUI.delay(2)
	List<WebElement>allYearOfExperience = WebUI.findWebElements(radioYearofExperience, 5)
	for(def i=0;i<allYearOfExperience.size();i++) {
		if(allYearOfExperience.get(i).getAttribute("value").equalsIgnoreCase(findTestData("testData").getValue(5, rowNum))) {
			allYearOfExperience.get(i).click()
			break
		}
	}
	
	
	TestObject checkboxSkill = findTestObject("Object Repository/Read Data/checkbox_skill")
	WebUI.delay(2)
	List<WebElement>allSkill = WebUI.findWebElements(checkboxSkill, 5)
	for(def i=0;i<allSkill.size();i++) {
		if(allSkill.get(i).getAttribute("value").equalsIgnoreCase(findTestData("testData").getValue(6, rowNum))) {
			allSkill.get(i).click()
			break
		}
	}
	
	TestObject selectQatools = findTestObject("Object Repository/Read Data/select_qatools")
	WebUI.delay(2)
	WebUI.selectOptionByValue(selectQatools, findTestData("testData").getValue(7, rowNum), false)
	
	
	TestObject textareaOtherDetail = findTestObject("Object Repository/Read Data/textarea_otherDetail")
	WebUI.delay(2)
	WebUI.sendKeys(textareaOtherDetail, findTestData("testData").getValue(8, rowNum))
	
	TestObject buttonSubmit = findTestObject("Object Repository/Read Data/button_submit")
	WebUI.delay(2)
	WebUI.click(buttonSubmit)
	
	TestObject aGoBack = findTestObject("Object Repository/Read Data/a_goBack")
	WebUI.delay(2)
	WebUI.waitForElementPresent(aGoBack, 10)
	WebUI.click(aGoBack)
}





	