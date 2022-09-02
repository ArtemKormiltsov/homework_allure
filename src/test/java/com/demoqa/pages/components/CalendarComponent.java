package com.demoqa.pages.components;

import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {
    public void setDate(String day, String month, String year) {
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__year-select").selectOption(year);
        String dayFormat = "";
        if (day.length() == 1)
            dayFormat = "00" + day;
        else
            dayFormat = "0" + day;
        $(".react-datepicker__day--" + dayFormat + ":not(.react-datepicker__day--outside-month").click();
    }
}
