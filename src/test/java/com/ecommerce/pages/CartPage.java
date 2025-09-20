package com.ecommerce.pages;

import org.openqa.selenium.JavascriptExecutor; // <-- IMPORT THIS
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage {

    WebDriver driver;
    WebDriverWait wait;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
        // This wait ensures the button is ready before any action is taken
        wait.until(ExpectedConditions.elementToBeClickable(checkoutButton));
    }

    @FindBy(id = "checkout")
    private WebElement checkoutButton;

    public void proceedToCheckout() {
        // THIS IS THE FIX: Use a JavascriptExecutor for a more reliable click
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", checkoutButton);
    }
}