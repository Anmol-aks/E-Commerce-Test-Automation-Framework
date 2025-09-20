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
        // Wait for the checkout button to be visible when the page object is created
        wait.until(ExpectedConditions.visibilityOf(checkoutButton));
    }

    @FindBy(id = "checkout")
    private WebElement checkoutButton;

    public void proceedToCheckout() {
        checkoutButton.click();
    }
}