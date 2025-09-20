package com.ecommerce.tests;

import com.ecommerce.base.BaseTest;
import com.ecommerce.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutTest extends BaseTest {

    @Test
    public void testEndToEndCheckoutFlow() {
        // 1. Login
        driver.get("https://www.saucedemo.com/");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginToApplication("standard_user", "secret_sauce");

        // 2. Add to Cart
        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.addBackpackToCart();
        productsPage.goToCart();

        // 3. Proceed to checkout from Cart
        CartPage cartPage = new CartPage(driver);
        cartPage.proceedToCheckout();

        // 4. Fill user information
        CheckoutInfoPage checkoutInfoPage = new CheckoutInfoPage(driver);
        checkoutInfoPage.fillCheckoutInformation("Test", "User", "12345");

        // 5. Finish checkout and Assert confirmation
        CheckoutCompletePage checkoutCompletePage = new CheckoutCompletePage(driver);
        checkoutCompletePage.finishCheckout();

        String expectedMessage = "Thank you for your order!";
        String actualMessage = checkoutCompletePage.getConfirmationMessage();
        Assert.assertEquals(actualMessage, expectedMessage, "Checkout confirmation message is incorrect.");
    }
}