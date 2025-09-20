package com.ecommerce.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductsPage {

    WebDriver driver;
    WebDriverWait wait; // <-- DECLARE A WAIT OBJECT

    // Constructor
    public ProductsPage(WebDriver driver) {
        this.driver = driver;
        // Initialize the WebDriverWait for a 10-second timeout
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // INITIALIZE THE WAIT
        PageFactory.initElements(driver, this);
    }

    // Locators
    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    private WebElement backpackAddToCartButton;

    @FindBy(className = "shopping_cart_badge")
    private WebElement shoppingCartBadge;

    @FindBy(className = "shopping_cart_link")
    private WebElement shoppingCartLink;

    // Action Methods
    public void addBackpackToCart() {
        backpackAddToCartButton.click();
        //Wait until the shopping cart badge is visible on the page
        wait.until(ExpectedConditions.visibilityOf(shoppingCartBadge));
    }

    public String getCartItemCount() {
        // the badge is present
        return shoppingCartBadge.getText();
    }

    public void goToCart() {
        shoppingCartLink.click();
    }
}