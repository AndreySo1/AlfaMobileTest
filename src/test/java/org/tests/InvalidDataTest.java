package org.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.pages.MainPage;

public class InvalidDataTest extends BaseTest{

    @DataProvider
    public Object[][] invalidData(){
        return new Object[][]{
//                {"Login", ""},
//                {"", "Password"},
//                {"", ""},
//                {"1", "Password"},
//                {"Login", "@+$%#^&*!"},
                {"Login@+$%#^&*!", "Password"},
                {"Qwerty", "!@#$%^&*()_+|:/?.>,<~`rLjDGXlxxXnYzJSFEsuAOIjIBQomwwftM"},
                {"rLjDGXlxxXnYzJSFEsuAOIjIBQomwwftMiKsTvwbOKKQrTuMfbTbzQq", "Password"},
        };
    }

    @Test(dataProvider = "invalidData")
    public void checkMistakeLogin(String login, String pas){
        String resultText = new MainPage()
                .setLogin(login)
                .setPas(pas)
                .checkButton()
                .waitDisappearLoader()
                .getInfoError();

        Assert.assertEquals(resultText, "Введены неверные данные");
    }
}
