package org.tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.pages.MainPage;

public class CheckNamingTest extends BaseTest{

    @Test
    public void namingTest(){
        String titleText = "Вход в Alfa-Test";
        String loginText = "Логин";
        String pasText = "Пароль";
        String btnText = "Войти";
//        String btnText = "Вход";

        MainPage page = new MainPage();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(titleText, page.getTitle().getText());
        softAssert.assertEquals(loginText, page.getLoginField().getText());
        softAssert.assertEquals(pasText, page.getPassField().getText());
        softAssert.assertEquals(btnText, page.getButton().getText());
        softAssert.assertAll();
    }
}
