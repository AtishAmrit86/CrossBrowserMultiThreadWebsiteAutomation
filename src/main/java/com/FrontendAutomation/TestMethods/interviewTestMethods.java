package com.FrontendAutomation.TestMethods;

import java.util.List;
import java.util.Properties;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.FrontenedAutomation.CommonUtilities.commonUtilities;

import net.serenitybdd.core.pages.PageObject;

public class interviewTestMethods extends PageObject {

	public Properties locators;
	public Properties testData;
	public int seatsAvailable;

	public interviewTestMethods() {

		locators = commonUtilities.getLocators("interviewWebLocators");
		testData = commonUtilities.getTestData("interviewTestData");

	}

	public void openHomePage() {
		open();
		getDriver().manage().window().maximize();
	}

	public void userSelectsSource() {

		String selectSource = locators.getProperty("sourceSelect");
		String txtBoxSource = locators.getProperty("txtBoxSource");
		commonUtilities.clickElement(getDriver(), txtBoxSource);
		commonUtilities.clickElement(getDriver(), selectSource);
	}

	public void userSelectsDestination() {

		String selectDestination = locators.getProperty("destinationSelect");
		String txtBoxDestination = locators.getProperty("txtBoxDestination");
		commonUtilities.clickElement(getDriver(), txtBoxDestination);
		commonUtilities.clickElement(getDriver(), selectDestination);
	}

	public void userSelectsDateOfJourney() {

		String doj = locators.getProperty("departureDateBox");
		String nxtMnthBtn = locators.getProperty("calendarBtnNext");
		String dateOfJourney = locators.getProperty("calendarDateSelect");
		commonUtilities.clickElement(getDriver(), doj);
		commonUtilities.clickElement(getDriver(), nxtMnthBtn);
		commonUtilities.clickElement(getDriver(), dateOfJourney);
	}

	public void clickBookNow() {
		String btnBookNow = locators.getProperty("btnBookNow");
		commonUtilities.clickElement(getDriver(), btnBookNow);

	}

	public void userVerifiesBusListIsDisplayed() throws InterruptedException {
		Thread.sleep(5000);
		String busList = locators.getProperty("busListTable");
		Assert.assertTrue(commonUtilities.verifyElementIsDisplayed(getDriver(), busList));
	}

	public void userSelectsTheRequiredBus() {
		String btnSelect = locators.getProperty("busSelect");
		List<WebElement> availableBusList = getDriver().findElements(By.xpath(btnSelect));
		availableBusList.get(2).click();
	}

	public void userSelectsSeatsToBeOccupied() {

		String seatSelectionModal = locators.getProperty("busSeatSelectionModal");
		String availableSeats = locators.getProperty("availableSeats");
		Assert.assertTrue(commonUtilities.verifyElementIsDisplayed(getDriver(), seatSelectionModal));
		List<WebElement> availableSeatsToBeoccupied = getDriver().findElements(By.xpath(availableSeats));
		seatsAvailable = availableSeatsToBeoccupied.size();
		if (seatsAvailable < 4) {
			for (int i = 0; i < availableSeatsToBeoccupied.size(); i++) {

				availableSeatsToBeoccupied.get(i).click();
			}
		} else {
			availableSeatsToBeoccupied.get(0).click();
			availableSeatsToBeoccupied.get(1).click();
			availableSeatsToBeoccupied.get(2).click();
			availableSeatsToBeoccupied.get(3).click();
			seatsAvailable = 4;
		}
	}

	public void userVerifiesSeatSelectQty() {

		String seatSelectedQty = locators.getProperty("numberOfSeatSelected");
		int numberOfSeatSelected = Integer
				.parseInt(commonUtilities.findElement(getDriver(), seatSelectedQty).getText().trim());
		Assert.assertTrue(numberOfSeatSelected == seatsAvailable);
	}

	public void userClicksProceedBtn() {

		String btnProceed = locators.getProperty("btnProceed");
		commonUtilities.clickElement(getDriver(), btnProceed);
	}

	public void userEntersPersonalDetails() throws InterruptedException {
		Thread.sleep(3000);

		String txtBoxName = locators.getProperty("txtBoxName");
		String txtBoxPhone = locators.getProperty("txtBoxMobile");
		String txtBoxEmail = locators.getProperty("txtBoxEmail");
		String txtBoxConfirmEmail = locators.getProperty("txtBoxConfirmEmail");

		String userName = testData.getProperty("name");
		String userPhoneNumber = testData.getProperty("phone");
		String userEmail = testData.getProperty("email");

		commonUtilities.fillDataInTextBox(getDriver(), txtBoxName, userName);
		commonUtilities.fillDataInTextBox(getDriver(), txtBoxPhone, userPhoneNumber);
		commonUtilities.fillDataInTextBox(getDriver(), txtBoxEmail, userEmail);
		commonUtilities.fillDataInTextBox(getDriver(), txtBoxConfirmEmail, userEmail);
	}

	public void userClickProceedToPaymentBtn() throws InterruptedException {

		String btnChkOut = locators.getProperty("btnProceedToCheckOut");
		commonUtilities.clickElement(getDriver(), btnChkOut);
		
	}

	public void userVerifiesAlertMsgDisplayed() throws InterruptedException {

		Thread.sleep(10000);
		Alert alert = getDriver().switchTo().alert();
		String errorMessage = testData.getProperty("alertText");
		String actualErrMsg = alert.getText().trim();
		System.out.println("Alert Message is ---> " + actualErrMsg);
		Assert.assertTrue(errorMessage.equalsIgnoreCase(actualErrMsg));

	}

}
