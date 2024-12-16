package org.example.demo.pages;

import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class CartPage {
    private final SelenideElement cartTitle = $(".title");
    private final SelenideElement checkoutButton = $("#checkout");
    private final SelenideElement firstCartItem = $(".cart_item");

    public CartPage verifyPageIsLoaded() {
        cartTitle.shouldBe(visible).shouldHave(text("Your Cart")).shouldBe(visible, Duration.ofSeconds(10));
        return this;
    }

    public CartPage verifyFirstItemIsVisible() {
        firstCartItem.shouldBe(visible);
        return this;
    }

    public void proceedToCheckout() {
        checkoutButton.shouldBe(visible).click();
    }
}
