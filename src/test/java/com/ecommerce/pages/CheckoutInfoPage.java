package com.ecommerce.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions; // <-- IMPORT THIS
import org.openqa.selenium.support.ui.WebDriverWait;         // <-- IMPORT THIS

import java.time.Duration; // <-- IMPORT THIS

public class CheckoutInfoPage {

    WebDriver driver;
    WebDriverWait wait; // <-- DECLARE A WAIT OBJECT

    public CheckoutInfoPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // <-- INITIALIZE THE WAIT
        PageFactory.initElements(driver, this);
        // THIS IS THE FIX: Wait for the first name field to be visible
        wait.until(ExpectedConditions.visibilityOf(firstNameField));
    }

    @FindBy(id = "first-name")
    private WebElement firstNameField;

    @FindBy(id = "last-name")
    private WebElement lastNameField;

    @FindBy(id = "postal-code")
    private WebElement postalCodeField;

    @FindBy(id = "continue")
    private WebElement continueButton;

    public void fillCheckoutInformation(String firstName, String lastName, String postalCode) {
        firstNameField.sendKeys(firstName);
        lastNameField.sendKeys(lastName);
        postalCodeField.sendKeys(postalCode);
        continueButton.click();
    }
}