package org.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class FinishPage extends BasePage{
    WebElement finishScreen= driver.findElement(By.className("android.widget.TextView"));

    public String getFinishText(){
        String finishText = finishScreen.getText();
        return finishText;
    }
}
