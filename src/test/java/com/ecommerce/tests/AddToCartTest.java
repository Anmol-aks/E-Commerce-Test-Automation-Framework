package com.ecommerce.tests;

import com.ecommerce.base.BaseTest;
import com.ecommerce.pages.LoginPage;
import com.ecommerce.pages.ProductsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddToCartTest extends BaseTest {

    @Test
    public void testAddBackpackToCart(){
        driver.get("https://www.saucedemo.com/");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginToApplication("standard_user", "secret_sauce");

        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.addBackpackToCart();

        String expectedItemCount = "1";
        String actualItemCount = productsPage.getCartItemCount();
        Assert.assertEquals(actualItemCount, expectedItemCount, "Cart item count is not correct.");
    }

}
