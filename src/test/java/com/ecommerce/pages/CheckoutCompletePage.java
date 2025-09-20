package com.ecommerce.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions; // <-- IMPORT THIS
import org.openqa.selenium.support.ui.WebDriverWait;         // <-- IMPORT THIS

import java.time.Duration; // <-- IMPORT THIS

public class CheckoutCompletePage {

    WebDriver driver;
    WebDriverWait wait; // <-- DECLARE A WAIT OBJECT

    public CheckoutCompletePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // <-- INITIALIZE THE WAIT
        PageFactory.initElements(driver, this);
        // THIS IS THE FIX: Wait for the finish button to be clickable
        wait.until(ExpectedConditions.elementToBeClickable(finishButton));
    }

    @FindBy(id = "finish")
    private WebElement finishButton;

    @FindBy(className = "complete-header")
    private WebElement confirmationHeader;

    public void finishCheckout() {
        finishButton.click();
        // After finishing, wait for the confirmation message to appear on the next page
        wait.until(ExpectedConditions.visibilityOf(confirmationHeader));
    }

    public String getConfirmationMessage() {
        return confirmationHeader.getText();
    }
}