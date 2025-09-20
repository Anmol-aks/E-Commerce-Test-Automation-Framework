package com.ecommerce.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage {

    WebDriver driver;

    public ProductsPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    private WebElement backpackAddToCartButton;

    @FindBy(className = "shopping_cart_badge")
    private WebElement shoppingCartBadge;

    @FindBy(className = "shopping_cart_link")
    private WebElement shoppingCartLink;

    public void addBackpackToCart() {
        backpackAddToCartButton.click();
    }

    public String getCartItemCount() {
        return shoppingCartBadge.getText();
    }

    public void goToCart() {
        shoppingCartLink.click();
    }

}
