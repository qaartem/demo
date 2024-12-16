package org.example.demo.pages;

import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class ProductsPage {
    private final SelenideElement productsTitle = $(".title");
    private final SelenideElement firstProductAddToCartButton = $("#add-to-cart-sauce-labs-backpack");
    private final SelenideElement cartIcon = $("#shopping_cart_container");

    public ProductsPage verifyPageIsLoaded() {
        productsTitle.shouldBe(visible).shouldHave(text("Products")).shouldBe(visible, Duration.ofSeconds(10));
        return this;
    }

    public ProductsPage addFirstProductToCart() {
        firstProductAddToCartButton.shouldBe(visible).click();
        return this;
    }

    public void openCart() {
        cartIcon.shouldBe(visible).click();
    }
}
