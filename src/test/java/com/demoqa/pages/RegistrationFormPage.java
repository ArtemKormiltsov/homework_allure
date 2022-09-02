package com.demoqa.pages;

import com.codeborne.selenide.SelenideElement;
import com.demoqa.data.RegistrationFormData;
import com.demoqa.pages.components.CalendarComponent;
import com.demoqa.pages.components.CheckboxComponent;
import com.demoqa.pages.components.ListComponents;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static java.lang.String.format;

public class RegistrationFormPage {
    SelenideElement firstNameInput = $("#firstName");
    SelenideElement lastNameInput = $("#lastName");
    SelenideElement emailInput = $("#userEmail");
    SelenideElement userNumberInput = $("#userNumber");
    SelenideElement dateOfBirthInput = $("#dateOfBirthInput");
    SelenideElement subjectsInput = $("#subjectsInput");
    SelenideElement pictureInput = $("#uploadPicture");
    SelenideElement currentAddressInput = $("#currentAddress");
    SelenideElement stateInput = $("#state");
    SelenideElement cityInput = $("#city");
    SelenideElement submitButton = $("#submit");
    SelenideElement title = $("#example-modal-sizes-title-lg");
    SelenideElement closeModalButton = $("#closeLargeModal");

    public RegistrationFormPage openPage() {
        open("/automation-practice-form");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        return this;
    }

    CalendarComponent calendar = new CalendarComponent();
    CheckboxComponent checkBox = new CheckboxComponent();
    ListComponents list = new ListComponents();

    public RegistrationFormPage fillForm(RegistrationFormData registrationFormData) {
        setFirstName(registrationFormData.firstName);
        setLastName(registrationFormData.lastName);
        setEmail(registrationFormData.email);
        setGender(registrationFormData.gender);
        setPhoneNumber(registrationFormData.mobilePhone);
        setBirthDate(registrationFormData.day, registrationFormData.month, registrationFormData.year);
        setSubjects(registrationFormData.subjects);
        setHobby(registrationFormData.hobby);
        setPicture(registrationFormData.filePath);
        setCurrentAddress(registrationFormData.currentAddress);
        setState(registrationFormData.state);
        setCity(registrationFormData.city);
        return this;
    }

    private RegistrationFormPage setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    private RegistrationFormPage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    private RegistrationFormPage setEmail(String value) {
        emailInput.setValue(value);
        return this;
    }

    private RegistrationFormPage setPhoneNumber(String value) {
        userNumberInput.setValue(value);
        return this;
    }

    private RegistrationFormPage setBirthDate(String day, String month, String year) {
        dateOfBirthInput.click();
        calendar.setDate(day, month, year);
        return this;
    }

    private RegistrationFormPage setSubjects(String value) {
        subjectsInput.setValue(value).pressEnter();
        return this;
    }

    private RegistrationFormPage setPicture(String value) {
        pictureInput.uploadFromClasspath(value);
        return this;
    }

    private RegistrationFormPage setCurrentAddress(String value) {
        currentAddressInput.setValue(value);
        return this;
    }

    private RegistrationFormPage setGender(String value) {
        checkBox.setCheckbox(value);
        return this;
    }

    private RegistrationFormPage setHobby(String value) {
        checkBox.setCheckbox(value);
        return this;
    }

    private RegistrationFormPage setState(String value) {
        list.setValue(stateInput, value);
        return this;
    }

    private RegistrationFormPage setCity(String value) {
        list.setValue(cityInput, value);
        return this;
    }

    public RegistrationFormPage submit() {
        submitButton.click();
        return this;
    }

    public RegistrationFormPage closeModalWindow() {
        closeModalButton.click();
        return this;
    }

    public RegistrationFormPage checkTitle() {
        title.shouldHave(text("Thanks for submitting the form"));
        return this;
    }

    public RegistrationFormPage checkFields(RegistrationFormData registrationFormData) {
        $(".table-responsive").shouldHave(
                text(format("%s %s", registrationFormData.firstName, registrationFormData.lastName)),
                text(registrationFormData.email),
                text(registrationFormData.mobilePhone),
                text(registrationFormData.gender),
                text(format("%s %s,%s", registrationFormData.day, registrationFormData.month, registrationFormData.year)),
                text(registrationFormData.subjects),
                text(registrationFormData.hobby),
                text(registrationFormData.fileName),
                text(registrationFormData.currentAddress),
                text(format("%s %s", registrationFormData.state, registrationFormData.city)));
        return this;
    }
}



