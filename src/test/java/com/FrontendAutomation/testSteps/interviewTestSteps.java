package com.FrontendAutomation.testSteps;

import org.jbehave.core.annotations.*;

import com.FrontendAutomation.TestMethods.interviewTestMethods;

public class interviewTestSteps {

	public interviewTestMethods testMethods;

	@Given("the user is on test homepage")
	public void userOpensHomepage() {
		testMethods.openHomePage();
	}

	@When("the user selects the source")
	public void userSelectsSource() {
		testMethods.userSelectsSource();
	}

	@Then("the user selects the destination")
	public void userSelectsDestination() {
		testMethods.userSelectsDestination();
	}

	@Then("the user selects date of travel")
	public void userSelectsDate() {
		testMethods.userSelectsDateOfJourney();
	}

	@When("the user clicks the booknow button")
	public void userClicksBookNowBtn() {
		testMethods.clickBookNow();
	}

	@Then("list of buses is displayed")
	public void busesListDisplyed() throws InterruptedException {
		testMethods.userVerifiesBusListIsDisplayed();
	}

	@When("the user selects the bus")
	public void userSelectsTheBus() {
		testMethods.userSelectsTheRequiredBus();
	}

	@Then("the user selects seat to be occupied")
	public void userSelectsSeats() {
		testMethods.userSelectsSeatsToBeOccupied();
	}

	@Then("the user verifies the seats are selected")
	public void userVerifiesSeatSelection() {
		testMethods.userVerifiesSeatSelectQty();

	}

	@When("the user clicks Proceed button")
	public void userClicksProceedButton() {
		testMethods.userClicksProceedBtn();
	}

	@Then("the user enters personal details")
	public void userEntersPersonalDetails() throws InterruptedException {
		testMethods.userEntersPersonalDetails();
	}

	@When("the user clicks Proceed To Payment Button")
	public void userClicksProceedToPaymentBtn() throws InterruptedException {
		testMethods.userClickProceedToPaymentBtn();
	}

	@Then("user verifies the alert")
	public void userVerifiesAlert() throws InterruptedException {
		testMethods.userVerifiesAlertMsgDisplayed();
	}
}
