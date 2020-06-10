package com.FrontenedAutomation.CommonUtilities;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class commonUtilities {
	
	public static Properties getLocators(String propertyFile) {
		FileInputStream file = null;
		Properties prop = null;
		try {
			file = new FileInputStream(System.getProperty("user.dir")+"//src//main//resources//locators//"+propertyFile+".properties");
			prop = new Properties();
			prop.load(file);
		} catch (Exception e) {
			System.out.println("Unable to load property file"+e.getMessage());
		}
		return prop;
	}
	
	public static Properties getTestData(String propertyFile) {
		FileInputStream file = null;
		Properties prop = null;
		try {
			file = new FileInputStream(System.getProperty("user.dir")+"//"+propertyFile+".properties");
			prop = new Properties();
			prop.load(file);
		} catch (Exception e) {
			System.out.println("Unable to load property file"+e.getMessage());
		}
		return prop;
	}
	
	public static WebElement findElement(WebDriver driver, String elem) {
		return driver.findElement(By.xpath(elem));
	}
	
	public static void clickElement(WebDriver driver, String elem) {
		findElement(driver, elem).click();
	}
	
	public static void fillDataInTextBox(WebDriver driver, String elem, String data) {
		findElement(driver, elem).clear();
		findElement(driver, elem).sendKeys(data);
	}
	
	public static boolean verifyElementIsDisplayed(WebDriver driver, String elem) {
		return findElement(driver, elem).isDisplayed();
	}

}
