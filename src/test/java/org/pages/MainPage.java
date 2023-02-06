package org.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage extends BasePage{
    @FindBy(id = "com.alfabank.qapp:id/loader")
    private WebElement loader;

    @FindBy(className = "android.widget.TextView")
    private WebElement title;

    @FindBy(id = "com.alfabank.qapp:id/etUsername")
    private WebElement loginField;

    @FindBy(id = "com.alfabank.qapp:id/etPassword")
    private WebElement passField;

    @FindBy(id = "com.alfabank.qapp:id/btnConfirm")
    private WebElement button;

    @FindBy(id = "com.alfabank.qapp:id/tvError")
    private WebElement infoError;

    @FindBy(id = "com.alfabank.qapp:id/text_input_end_icon")
    private WebElement visiblePas;

//    WebElement loader = driver.findElement(By.id("com.alfabank.qapp:id/loader"));
//    WebElement loginField = driver.findElement(By.id("com.alfabank.qapp:id/etUsername"));
//    WebElement passField = driver.findElement(By.id("com.alfabank.qapp:id/etPassword"));
//    WebElement button = driver.findElement(By.id("com.alfabank.qapp:id/btnConfirm"));
//    WebElement infoError = driver.findElement(By.id("com.alfabank.qapp:id/tvError"));

    public WebElement getTitle() {
        return title;
    }

    public WebElement getLoginField() {
        return loginField;
    }

    public WebElement getPassField() {
        return passField;
    }

    public WebElement getButton() {
        return button;
    }

    public MainPage(){
        PageFactory.initElements(driver, this);
    }

    public MainPage setLogin(String login){
        loginField.sendKeys(login);
        return this;
    }

    public MainPage setPas(String password){
        passField.sendKeys(password);
        return this;
    }

    public FinishPage confirmButton(){
        button.click();
        waitDisappearLoader();
        return new FinishPage();
    }

    public MainPage checkButton(){
        button.click();
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.presenceOfElementLocated(By.id("com.alfabank.qapp:id/tvError")));
        return this;
    }

    public MainPage waitDisappearLoader(){
     WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
               wait.until(ExpectedConditions.invisibilityOf(loader));
    return this;
    }

    public String getInfoError(){
        String textError = infoError.getText();
        return textError;
    }

    public MainPage switchVisible(){
        visiblePas.click();
        return this;
    }

    public boolean checkVisible(){
        boolean isPass = (passField.getAttribute("password").equals("true")) ? true : false;
        return isPass;
    }

    public boolean checkAllElement(){
        boolean titleText = title.isDisplayed();
        boolean login = loginField.isDisplayed();
        boolean password = passField.isDisplayed();
        boolean btn = button.isDisplayed();
        boolean eye = visiblePas.isDisplayed();

        return (titleText && login && password && btn && eye) ? true : false;
    }

}
