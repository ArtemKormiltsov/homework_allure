package com.demoqa.data;


import com.github.javafaker.Faker;

public class RegistrationFormData {

    Faker faker = new Faker();

    public String firstName = faker.name().firstName();
    public String lastName = faker.name().lastName();
    public String email = faker.internet().emailAddress();
    public String mobilePhone = faker.phoneNumber().subscriberNumber(10);
    public String subjects = "Economics";
    public String gender = "Male";
    public String fileName = "logo.png";
    public String filePath = fileName;
    public String currentAddress = faker.address().fullAddress();
    public String year = faker.number().numberBetween(1990, 2010) + "";
    public String month = "April";
    public String day = faker.number().numberBetween(1, 28) + "";
    public String hobby = "Sports";
    public String state = "Uttar Pradesh";
    public String city = "Agra";
}
