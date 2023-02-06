package org.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.pages.MainPage;

public class VisiblePasswordTest extends BaseTest{

    @Test
    public void checkPasAttributeTrue(){
        boolean hasAttributTrue = new MainPage()
                .setPas("Password")
                .checkVisible();

        Assert.assertTrue(hasAttributTrue);
    }

    @Test
    public void checkPasAttributeFalse(){
        boolean hasAttributFalse = new MainPage()
                .setPas("Password")
                .switchVisible()
                .checkVisible();

        Assert.assertFalse(hasAttributFalse);
        new MainPage().switchVisible();
    }

    @Test
    public void longCheckPasAttributeTrue(){

        boolean hasAttributTrue = new MainPage()
                .setPas("Password")
                .switchVisible()
                .setPas("Password2")
                .switchVisible()
                .switchVisible()
                .switchVisible()
                .switchVisible()
                .switchVisible()
                .checkVisible();

        Assert.assertTrue(hasAttributTrue);
    }

    @Test
    public void longCheckPasAttributeFalse(){

        boolean hasAttributFalse = new MainPage()
                .setPas("Password")
                .switchVisible()
                .setPas("Password2")
                .switchVisible()
                .switchVisible()
                .switchVisible()
                .switchVisible()
                .checkVisible();

        Assert.assertFalse(hasAttributFalse);
        new MainPage().switchVisible();
    }

}
