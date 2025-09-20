package com.ecommerce.pages;

import org.openqa.selenium.JavascriptExecutor; // <-- IMPORT THIS
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductsPage {

    WebDriver driver;
    WebDriverWait wait;

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    private WebElement backpackAddToCartButton;

    @FindBy(className = "shopping_cart_badge")
    private WebElement shoppingCartBadge;

    @FindBy(className = "shopping_cart_link")
    private WebElement shoppingCartLink;

    public void addBackpackToCart() {
        wait.until(ExpectedConditions.elementToBeClickable(backpackAddToCartButton));

        // THIS IS THE FIX: Use JavascriptExecutor for a more reliable click
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", backpackAddToCartButton);

        // The wait for the badge is still needed after the click.
        wait.until(ExpectedConditions.visibilityOf(shoppingCartBadge));
    }

    public String getCartItemCount() {
        return shoppingCartBadge.getText();
    }

    public void goToCart() {
        wait.until(ExpectedConditions.elementToBeClickable(shoppingCartLink));

        // Applying the same robust click method here for consistency
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", shoppingCartLink);
    }
}