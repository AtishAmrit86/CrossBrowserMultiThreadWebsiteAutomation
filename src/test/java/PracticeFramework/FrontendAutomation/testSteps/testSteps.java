package PracticeFramework.FrontendAutomation.testSteps;
import org.jbehave.core.annotations.*;

import PracticeFramework.FrontendAutomation.TestMethods.testMethods;


public class testSteps {

public testMethods Methods;

	
@Given("the user is on homepage")

public void userIsOnHomepage() {
	Methods.open();
	Methods.maximise();
}
@When("the user clicks buy now button")

public void userClicksBuyBtn() {
	Methods.clickBtnBuy();
}

@Then("shopping cart modal opens")

public void shoppingCartOpens() {
	Methods.verifyShoppingCartDisplay();
}

@Then("user verifies the fields on the shopping cart modal")

public void userVerifiesShoppingCartModal() {
	Methods.verifyShoppingCartModal();
}

@Then("the user enters required details")

public void userEntersDetails() {
	Methods.fillTestData();
}
@When("the user clicks chekckout button")

public void userClicksCheckoutButton() {
	
	Methods.clickChkOutBtn();
}

@Then("order summary modal is displayed")

public void userVerifiesOrderSummaryModal() {
	Methods.verifyOrderSummaryModal();
}

@When("the user clicks continue button")

public void userClicksContinueBtn() {
	Methods.clickContinueBtn();
}

@Then("payment selection modal is displayed")

public void paymentSelectionOpnes() {
	Methods.verifyPaymentSelectionModal();
	
}

@When("the user selects Credit Card payment method")

public void userSelectsCreditCardOption() {
	Methods.selectCreditCardPayment();
}

@Then("the card details form is displayed")

public void cardDetailsFormOpens() {
	Methods.verifyCreditCardForm();
}

@When("the user enters correct card details")

public void userEntersCorrectCardDetails() {
	Methods.fillCorrectCardDetails();
}
@Then("the user clicks on Paynow button")

public void userClicksPayNowBtn() {
	Methods.clickPayNowBtn();
}

@Then("OTP page is displayed")

public void pageForOTPDisplayed() {
	Methods.verifyOtpPage();
	
}
@When("the user enters OTP in the text box")

public void userEntersOTP() {
	Methods.fillOTP();
}

@Then("the user clicks on OK button")

public void userClicksOkBtn() {
	Methods.clickOkBtn();
}

@Then("transaction successful message is displayed")

public void verifySuccessMsg() {
	Methods.verifySuccessMsg();
	
}

@When("the user enters incorrect card details")

public void userEntersIncorrectCardDetails() {
	Methods.fillInCorrectCardDetails();
}

@Then("transaction fail message is displayed")

public void verifyFailureMsg() {
	Methods.verifyFailureMsg();
}



}
