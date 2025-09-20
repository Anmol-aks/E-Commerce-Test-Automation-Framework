package com.ecommerce.pages;

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
        // THE FIX: Wait for the button to be clickable, not just visible.
        wait.until(ExpectedConditions.elementToBeClickable(checkoutButton));
    }

    @FindBy(id = "checkout")
    private WebElement checkoutButton;

    public void proceedToCheckout() {
        checkoutButton.click();
    }
}