package org.example.demo;

import com.codeborne.selenide.SelenideElement;
import lombok.Data;

import static com.codeborne.selenide.Selenide.$;
@Data
public class Account {
    private String username;
    private String password;
}
