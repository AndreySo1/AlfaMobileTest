package org.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.pages.MainPage;

public class ValidDataTest extends BaseTest{

    @Test
    public void successTest(){

        String result = new MainPage()
                .setLogin("Login")
                .setPas("Password")
                .confirmButton()
                .getFinishText();

        Assert.assertEquals(result, "Вход в Alfa-Test выполнен");
    }
}
