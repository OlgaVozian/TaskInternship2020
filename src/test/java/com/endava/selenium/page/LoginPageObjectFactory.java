package com.endava.selenium.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPageObjectFactory {
    @FindBy(xpath= "//a[contains(@class,'dismiss-link')]")
    private WebElement dismiss_link;

    @FindBy(xpath = "//a[contains(@href,'my-account')]")
    private WebElement loginButton;

    @FindBy(id="username")
    private WebElement emailField;

    @FindBy(name="password")
    private WebElement passwordField;

    @FindBy(name="login")
    private WebElement submitButton;

    @FindBy(xpath ="//div[contains(@class,'MyAccount-content')]/p/strong" )
    private WebElement userName;

    private WebDriver driver;
    private WebDriverWait wait;

    public LoginPageObjectFactory(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void login(String email, String password){
        dismiss_link.click();
        loginButton.click();
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        submitButton.click();
    }

    public WebElement getUserName() {
        return userName;
    }
    public String getUserNameValue() {
        return userName.getText();
    }
}
