package com.endava.selenium.page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddToCartPageObjectFactory {
    @FindBy(xpath = "//a[contains(@class,'dismiss-link')]")
    private WebElement dismiss_link;

    @FindBy(xpath = "//*[@class='icon_search']")
    private WebElement searchIcon;

    @FindBy(xpath = "//*[@type='search']")
    private WebElement searchField;

    @FindBy(xpath = "//*[@class='product-one-thumb']")
    private WebElement chooseDress;

    @FindBy(xpath = "//*[@id='pa_color']//option[@value='white']")
    private WebElement chooseColor;

    @FindBy(xpath="//*[@id='pa_size']//option[@value='small']")
    private WebElement chooseSize;

    @FindBy(xpath="//button[contains(text(),'Add to cart')]")
    private WebElement addToCart;

    @FindBy(xpath="//*[@class='woocommerce-message']")
    private WebElement informativeMessage;

    private WebDriver driver;
    private WebDriverWait wait;

    public AddToCartPageObjectFactory(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void addToCartItem(String item) {
        dismiss_link.click();
        searchIcon.click();
        searchField.sendKeys(item + Keys.ENTER);
        chooseDress.click();
        chooseColor.click();
        chooseSize.click();
        addToCart.click();
    }

    public WebElement getInformativeMessage() {
        return informativeMessage;
    }
    public String getInformativeMessageValue() {
        return informativeMessage.getText();
    }

}
