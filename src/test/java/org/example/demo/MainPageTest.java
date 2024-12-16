package org.example.demo;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.example.demo.pages.CartPage;
import org.example.demo.pages.CheckoutPage;
import org.example.demo.pages.ProductsPage;
import org.example.demo.pages.SignUpPage;
import org.openqa.selenium.chrome.ChromeOptions;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class MainPageTest {

    @BeforeAll
    public static void setUpAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.headless = true;
        Configuration.timeout = 10000;
        Configuration.browserCapabilities = new ChromeOptions().addArguments("--remote-allow-origins=*").addArguments("--disable-notifications").addArguments("--disable-popup-blocking").addArguments("--disable-infobars").addArguments("--disable-save-password-bubble");
    }

    @BeforeEach
    public void setUp() {
        open("https://www.saucedemo.com");
    }

    @Test
    public void testPurchaseProduct() {
        Account testAccount = new Account();

        testAccount.setUsername("standard_user");
        testAccount.setPassword("secret_sauce");

        new SignUpPage()
                .open()
                .signUp(testAccount);

        new ProductsPage()
                .verifyPageIsLoaded()
                .addFirstProductToCart()
                .openCart();

        new CartPage()
                .verifyPageIsLoaded()
                .verifyFirstItemIsVisible()
                .proceedToCheckout();

        new CheckoutPage()
                .verifyPageIsLoaded()
                .fillCheckoutDetails("Artem", "Lastname", "1")
                .continueCheckout()
                .finishCheckout()
                .verifyOrderCompletion();
    }

}
