import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import org.junit.Assert
import org.openqa.selenium.WebElement
import org.openqa.selenium.interactions.Actions

import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import ch.qos.logback.core.joran.action.Action
import internal.GlobalVariable as GlobalVariable

WebUI.callTestCase(findTestCase('TC1_Login'), [:], FailureHandling.STOP_ON_FAILURE)

//get product
TestObject inventoryData = findTestObject('Object Repository/AddToCart/div_inventoryItems')
List<WebElement> elements = WebUI.findWebElements(inventoryData, 10)
for(def i=0; i<elements.size(); i++) {
	if(elements.get(i).getText().equalsIgnoreCase("Sauce Labs Backpack")) {
		elements.get(i).click()
		break
	}
}

//click btn addToCart
TestObject btn_addToCart = findTestObject("Object Repository/AddToCart/btn_addToCart")
WebUI.click(btn_addToCart)

TestObject span_cartBadge = findTestObject("Object Repository/AddToCart/span_cartBadge")
WebUI.waitForElementPresent(span_cartBadge, 10)
WebUI.verifyElementPresent(span_cartBadge, 5)
print(WebUI.getText(span_cartBadge))
WebUI.click(span_cartBadge)

//click checkout
TestObject btn_checkout = findTestObject("Object Repository/Checkout/btn_checkout")
WebUI.click(btn_checkout)

//checkout form
TestObject input_firstName = findTestObject("Object Repository/Checkout/input_firstName")
TestObject input_lastName = findTestObject("Object Repository/Checkout/input_lastName")
TestObject input_postalCode = findTestObject("Object Repository/Checkout/input_postalCode")
TestObject btn_continue = findTestObject("Object Repository/Checkout/btn_continue")


WebUI.sendKeys(input_firstName, "Frans")
WebUI.sendKeys(input_lastName, "test")
WebUI.sendKeys(input_postalCode, "22312")
WebUI.scrollToElement(btn_continue, 10)
WebUI.click(btn_continue)

//click finish
TestObject btn_finish = findTestObject("Object Repository/Checkout/btn_finish")
WebUI.click(btn_finish)

//verify order complete
TestObject h2_header = findTestObject("Object Repository/Checkout/h2_completeHeader")
WebUI.verifyElementPresent(h2_header, 10)
Assert.assertEquals("Thank you for your order!", WebUI.getText(h2_header))

WebUI.delay(5)
WebUI.closeBrowser()
