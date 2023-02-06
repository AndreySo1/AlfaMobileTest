package org.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.pages.MainPage;

public class HaveAllElementTest extends BaseTest {

    @Test(priority = 1)
    public void checkAllElements(){
        boolean haveMainElements = new MainPage().checkAllElement();

        Assert.assertTrue(haveMainElements, "element not found");
    }
}
