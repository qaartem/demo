package org.example.demo.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.example.demo.Account;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class SignUpPage {
    private String BASE_URI = "https://www.saucedemo.com";

    private final SelenideElement username = $("#user-name");
    private final SelenideElement password = $("#password");
    private final SelenideElement loginButton = $("#login-button");

    public SignUpPage open(){
        Selenide.open(BASE_URI);
        loginButton.shouldBe(visible, Duration.ofSeconds(30));
        return this;
    }

    public void signUp(Account account) {
        username.val(account.getUsername());
        password.val(account.getPassword());
        loginButton.click();
    }
}
