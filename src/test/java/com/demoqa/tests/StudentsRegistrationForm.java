package com.demoqa.tests;

import com.demoqa.data.RegistrationFormData;
import com.demoqa.pages.RegistrationFormPage;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

public class StudentsRegistrationForm extends TestBase {
    RegistrationFormPage registrationFormPage = new RegistrationFormPage();
    RegistrationFormData registrationFormData = new RegistrationFormData();

    @Feature("Students registration form")
    @Owner("akormilcov")
    @DisplayName("Checking student registration form")
    @Test
    void fillFormTest() {
        step("Открыть страницу регистрации студента", ()-> {
        registrationFormPage.openPage();});
        step("Заполнить форму регистрации", ()-> {
        registrationFormPage.fillForm(registrationFormData).submit();});
        step("Проверить данные в модальном окне и закрыть", ()-> {
        registrationFormPage.checkTitle().checkFields(registrationFormData).closeModalWindow();});
    }
}

