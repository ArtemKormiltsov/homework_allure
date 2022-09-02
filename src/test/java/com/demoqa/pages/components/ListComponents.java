package com.demoqa.pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;

public class ListComponents {
    public ListComponents setValue(SelenideElement locator, String value) {
        locator.click();
        locator.$(byText(value)).click();
        return this;
    }
}
