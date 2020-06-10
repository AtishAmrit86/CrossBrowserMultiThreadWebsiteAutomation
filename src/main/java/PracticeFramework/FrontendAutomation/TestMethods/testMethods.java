package PracticeFramework.FrontendAutomation.TestMethods;

import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;

import PracticeFramework.FrontendAutomation.CommonUtilities.commonUtilities;
import net.serenitybdd.core.pages.PageObject;


public class testMethods extends PageObject{
	
	Logger logs = LogManager.getLogger(testMethods.class);
	
	public Properties locators;
	public Properties testData;
	
	public testMethods() {
		
		locators = commonUtilities.getLocators("webElementLocators");
		testData = commonUtilities.getTestData("testData");
	}
	
	public void maximise() {
		
		getDriver().manage().window().maximize();
		
		
	}
	
	public void clickBtnBuy() {
		String locatorBtnBuy = locators.getProperty("btnBuy");
		commonUtilities.clickElement(getDriver(), locatorBtnBuy);
		logs.info("Buy button clicked");
	}
	
	public void verifyShoppingCartDisplay() {
		
		String locatorShoppingCartModal = locators.getProperty("shoppingCart");
		Assert.assertTrue(commonUtilities.verifyElementIsDisplayed(getDriver(), locatorShoppingCartModal));
		logs.info("Shopping Cart is displayed");
			
	}
	
	public void verifyShoppingCartModal() {
		
		String labelName = locators.getProperty("labelName");
		String labelEmail = locators.getProperty("labelEmail");
		String labelCity = locators.getProperty("labelCity");
		String labelAddress = locators.getProperty("labelAddress");
		String lablelPostalCode = locators.getProperty("lablelPostalCode");
		String txtBoxName = locators.getProperty("txtBoxName");
		String txtBoxEmail = locators.getProperty("txtBoxEmail");
		String txtBoxCity = locators.getProperty("txtBoxCity");
		String txtBoxAddress = locators.getProperty("txtBoxAddress");
		String txtBoxPostalCode = locators.getProperty("txtBoxPostalCode");
		String btnCheckOut = locators.getProperty("btnCheckOut");
		
		Assert.assertTrue(commonUtilities.verifyElementIsDisplayed(getDriver(), labelName));
		Assert.assertTrue(commonUtilities.verifyElementIsDisplayed(getDriver(), labelEmail));
		Assert.assertTrue(commonUtilities.verifyElementIsDisplayed(getDriver(), labelCity));
		Assert.assertTrue(commonUtilities.verifyElementIsDisplayed(getDriver(), labelAddress));
		Assert.assertTrue(commonUtilities.verifyElementIsDisplayed(getDriver(), lablelPostalCode));
		Assert.assertTrue(commonUtilities.verifyElementIsDisplayed(getDriver(), txtBoxName));
		Assert.assertTrue(commonUtilities.verifyElementIsDisplayed(getDriver(), txtBoxEmail));
		Assert.assertTrue(commonUtilities.verifyElementIsDisplayed(getDriver(), txtBoxCity));
		Assert.assertTrue(commonUtilities.verifyElementIsDisplayed(getDriver(), txtBoxAddress));
		Assert.assertTrue(commonUtilities.verifyElementIsDisplayed(getDriver(), txtBoxPostalCode));
		Assert.assertTrue(commonUtilities.verifyElementIsDisplayed(getDriver(), btnCheckOut));
		
		logs.info("Shopping Cart Modal verified");
	}
	
	public void fillTestData() {
		
		String txtBoxName = locators.getProperty("txtBoxName");
		String txtBoxEmail = locators.getProperty("txtBoxEmail");
		String txtBoxPhone = locators.getProperty("txtBoxPhone");
		String txtBoxCity = locators.getProperty("txtBoxCity");
		String txtBoxAddress = locators.getProperty("txtBoxAddress");
		String txtBoxPostalCode = locators.getProperty("txtBoxPostalCode");
		
		String testDataName = testData.getProperty("name");
		String testDataEmail = testData.getProperty("email");
		String testDataPhone = testData.getProperty("phone");
		String testDataCity = testData.getProperty("city");
		String testDataAddress = testData.getProperty("address");
		String testDataPostalCode = testData.getProperty("postalCode");
		
		commonUtilities.fillDataInTextBox(getDriver(), txtBoxName, testDataName);
		commonUtilities.fillDataInTextBox(getDriver(), txtBoxEmail, testDataEmail);
		commonUtilities.fillDataInTextBox(getDriver(), txtBoxPhone, testDataPhone);
		commonUtilities.fillDataInTextBox(getDriver(), txtBoxCity, testDataCity);
		commonUtilities.fillDataInTextBox(getDriver(), txtBoxAddress, testDataAddress);
		commonUtilities.fillDataInTextBox(getDriver(), txtBoxPostalCode, testDataPostalCode);
		
		logs.info("Buyer's details filled");
		
	}
	
	public void clickChkOutBtn() {
		
		String btnCheckOut = locators.getProperty("btnCheckOut");
		commonUtilities.clickElement(getDriver(), btnCheckOut);
		
		logs.info("CheckOut button clicked");
	}
	
	public void verifyOrderSummaryModal() {
		
		String orderSummarySection = locators.getProperty("orderSummarySection");
		String orderSummaryAmt = locators.getProperty("orderSummaryAmt");
		String orderSummaryOrderId = locators.getProperty("orderSummaryOrderId");
		String orderSummaryTabs = locators.getProperty("orderSummaryTabs");
		String orderSummmaryOrderDetailsTab = locators.getProperty("orderSummmaryOrderDetailsTab");
		String orderSummaryShippingDetailsTab = locators.getProperty("orderSummaryShippingDetailsTab");
		String orderSummaryContinueBtn = locators.getProperty("orderSummaryContinueBtn");
		String frame = locators.getProperty("iframe");
		
		commonUtilities.switchFrame(getDriver(), frame);
		Assert.assertTrue(commonUtilities.verifyElementIsDisplayed(getDriver(), orderSummarySection));
		Assert.assertTrue(commonUtilities.verifyElementIsDisplayed(getDriver(), orderSummaryAmt));
		Assert.assertTrue(commonUtilities.verifyElementIsDisplayed(getDriver(), orderSummaryOrderId));
		Assert.assertTrue(commonUtilities.verifyElementIsDisplayed(getDriver(), orderSummaryTabs));
		Assert.assertTrue(commonUtilities.verifyElementIsDisplayed(getDriver(), orderSummmaryOrderDetailsTab));
		Assert.assertTrue(commonUtilities.verifyElementIsDisplayed(getDriver(), orderSummaryShippingDetailsTab));
		Assert.assertTrue(commonUtilities.verifyElementIsDisplayed(getDriver(), orderSummaryContinueBtn));
		
		commonUtilities.switchToParentFrame(getDriver());
		
		logs.info("Order Summary Modal is Verified");
		
	}
	
	public void clickContinueBtn() {
		String orderSummaryContinueBtn = locators.getProperty("orderSummaryContinueBtn");
		String frame = locators.getProperty("iframe");
		
		commonUtilities.switchFrame(getDriver(), frame);
		commonUtilities.clickElement(getDriver(), orderSummaryContinueBtn);
		
		logs.info("Continue Button clicked");
	}
	
	public void verifyPaymentSelectionModal() {
		
		String headerPaymentSelection = locators.getProperty("selectPaymentHeader");
		String paymentList = locators.getProperty("selectPaymentHeader");
		Assert.assertTrue(commonUtilities.verifyElementIsDisplayed(getDriver(), headerPaymentSelection));
		Assert.assertTrue(commonUtilities.verifyElementIsDisplayed(getDriver(), paymentList));
		
		logs.info("Select Payment Modal is Displayed");
	}
	
	public void selectCreditCardPayment() {
		String paymentCreditCardMethod = locators.getProperty("paymentCreditCard");
		commonUtilities.clickElement(getDriver(), paymentCreditCardMethod);
		
		logs.info("Credit Card Method Selected");
	}
	
	public void verifyCreditCardForm() {
		String cardDetailsHeader = locators.getProperty("cardDetailsHeader");
		String txtBoxCardNumber = locators.getProperty("txtBoxCardNumber");
		String txtBoxExpiryDate = locators.getProperty("txtBoxExpiryDate");
		String txtBoxCVV = locators.getProperty("txtBoxCVV");
		String btnPayNow = locators.getProperty("btnPayNow");
		
		Assert.assertTrue(commonUtilities.verifyElementIsDisplayed(getDriver(), cardDetailsHeader));
		Assert.assertTrue(commonUtilities.verifyElementIsDisplayed(getDriver(), txtBoxCardNumber));
		Assert.assertTrue(commonUtilities.verifyElementIsDisplayed(getDriver(), txtBoxExpiryDate));
		Assert.assertTrue(commonUtilities.verifyElementIsDisplayed(getDriver(), txtBoxCVV));
		Assert.assertTrue(commonUtilities.verifyElementIsDisplayed(getDriver(), btnPayNow));
		
		logs.info("Credit Card form verified");
	}
	
	public void fillCorrectCardDetails() {
		
		String txtBoxCardNumber = locators.getProperty("txtBoxCardNumber");
		String txtBoxExpiryDate = locators.getProperty("txtBoxExpiryDate");
		String txtBoxCVV = locators.getProperty("txtBoxCVV");
		
		
		String testDataCorrectCardNumber = testData.getProperty("correctCardNumber");
		String testDataexpiryDate = testData.getProperty("expiryDate");
		String testDatacvv = testData.getProperty("cvv");
		
		commonUtilities.fillDataInTextBox(getDriver(), txtBoxCardNumber, testDataCorrectCardNumber);
		commonUtilities.fillDataInTextBox(getDriver(), txtBoxExpiryDate, testDataexpiryDate);
		commonUtilities.fillDataInTextBox(getDriver(), txtBoxCVV, testDatacvv);
		
		
		logs.info("Credit Card Details for Successful Payment entered");
	}
	
	public void fillInCorrectCardDetails() {
		
		String txtBoxCardNumber = locators.getProperty("txtBoxCardNumber");
		String txtBoxExpiryDate = locators.getProperty("txtBoxExpiryDate");
		String txtBoxCVV = locators.getProperty("txtBoxCVV");
		
		
		String testDataIncorrectCardNumber = testData.getProperty("incorrectCardNumber");
		String testDataexpiryDate = testData.getProperty("expiryDate");
		String testDatacvv = testData.getProperty("cvv");
		
		commonUtilities.fillDataInTextBox(getDriver(), txtBoxCardNumber, testDataIncorrectCardNumber);
		commonUtilities.fillDataInTextBox(getDriver(), txtBoxExpiryDate, testDataexpiryDate);
		commonUtilities.fillDataInTextBox(getDriver(), txtBoxCVV, testDatacvv);
		
		
		logs.info("Credit Card Details for Unsuccessful Payment entered");
	}
	
	public void clickPayNowBtn() {
		
		String btnPayNow = locators.getProperty("btnPayNow");
		commonUtilities.clickElement(getDriver(), btnPayNow);
		commonUtilities.switchToParentFrame(getDriver());
		
		String txtBoxCVV = locators.getProperty("txtBoxCVV");
		commonUtilities.waitForElementInvisibility(getDriver(), txtBoxCVV);
		
		logs.info("Pay Now button Clicked");
	}
	
	public void verifyOtpPage() {
		
		String sectionOTP = locators.getProperty("sectionOTP");
		String txtBoxPswd = locators.getProperty("txtBoxPswd");
		String btnOk = locators.getProperty("btnOk");
		String frame = locators.getProperty("iframe");
		String frameOTP = locators.getProperty("iframeToken");
		String tokenSection = locators.getProperty("tokenSection");
		
		commonUtilities.waitForElementVisibility(getDriver(), frame);
		commonUtilities.switchFrame(getDriver(), frame);
		commonUtilities.waitForElementVisibility(getDriver(), tokenSection);
		commonUtilities.switchFrame(getDriver(), frameOTP);
		
		Assert.assertTrue(commonUtilities.verifyElementIsDisplayed(getDriver(), sectionOTP));
		Assert.assertTrue(commonUtilities.verifyElementIsDisplayed(getDriver(), txtBoxPswd));
		Assert.assertTrue(commonUtilities.verifyElementIsDisplayed(getDriver(), btnOk));
		
		logs.info("OTP page verified");
	}
	
	public void fillOTP() {
		
		String txtBoxPswd = locators.getProperty("txtBoxPswd");
		String otp = testData.getProperty("otp");
		
		commonUtilities.fillDataInTextBox(getDriver(), txtBoxPswd, otp);
		logs.info("OTP entered");
	}
	
	public void clickOkBtn() {
		
		String btnOk = locators.getProperty("btnOk");
		
		commonUtilities.clickElement(getDriver(), btnOk);
		commonUtilities.waitForElementVisibility(getDriver(), btnOk);
		commonUtilities.switchToParentFrame(getDriver());
		
		logs.info("Ok button clicked");
	}
	
	public void verifySuccessMsg() {
		
		commonUtilities.switchToParentFrame(getDriver());
		String transactionResultMsg = locators.getProperty("transactionSucessMsgSection");
		String successMessageLine1 = locators.getProperty("transSuccessMsgLine1");
		String successMessageLine2 = locators.getProperty("transSuccessMsgLine2");
		String partialTransactionMsg = commonUtilities.getText(getDriver(), successMessageLine1);
		String actualTransactionMessage = partialTransactionMsg + commonUtilities.getText(getDriver(), successMessageLine2);
		String expectedTransactionMessage = testData.getProperty("expectedSuccessMsg");
		
		logs.info("Expected Message "+expectedTransactionMessage);
		logs.info("Actual Message "+actualTransactionMessage);
		Assert.assertTrue(commonUtilities.verifyElementIsDisplayed(getDriver(), transactionResultMsg));
		commonUtilities.compareStrings(actualTransactionMessage, expectedTransactionMessage);
		
		logs.info("Success Message verified");
	}
	
	public void verifyFailureMsg() {
		
		String transactionResultMsg = locators.getProperty("transactionResultMsg");
		String btnRetry = locators.getProperty("btnRetry");
		String actualTransactionMessage = commonUtilities.getText(getDriver(), transactionResultMsg);
		String expectedTransactionMessage = testData.getProperty("expectedFailureMsg");
		
		commonUtilities.waitForElementVisibility(getDriver(), btnRetry);
		
		logs.info("Expected Message "+expectedTransactionMessage);
		logs.info("Actual Message "+actualTransactionMessage);
		Assert.assertTrue(commonUtilities.verifyElementIsDisplayed(getDriver(), transactionResultMsg));
		commonUtilities.compareStrings(actualTransactionMessage, expectedTransactionMessage);
		
		logs.info("Failure Message verified");
	}
	

}
