package org.example.demo.pages;

import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class CheckoutPage {
    private final SelenideElement firstNameInput = $("#first-name");
    private final SelenideElement lastNameInput = $("#last-name");
    private final SelenideElement postalCodeInput = $("#postal-code");
    private final SelenideElement continueButton = $("#continue");
    private final SelenideElement finishButton = $("#finish");
    private final SelenideElement confirmationMessage = $(".complete-header");

    public CheckoutPage verifyPageIsLoaded() {
        continueButton.shouldBe(visible).shouldBe(visible, Duration.ofSeconds(10));
        return this;
    }

    public CheckoutPage fillCheckoutDetails(String firstName, String lastName, String postalCode) {
        firstNameInput.shouldBe(visible).val(firstName);
        lastNameInput.shouldBe(visible).val(lastName);
        postalCodeInput.shouldBe(visible).val(postalCode);
        return this;
    }

    public CheckoutPage continueCheckout() {
        continueButton.shouldBe(visible).click();
        return this;
    }

    public CheckoutPage finishCheckout() {
        finishButton.shouldBe(visible).click();
        return this;
    }

    public void verifyOrderCompletion() {
        confirmationMessage.shouldBe(visible).shouldHave(text("THANK YOU FOR YOUR ORDER"));
    }

}
