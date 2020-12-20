package com.endava.selenium;

import com.endava.selenium.page.AddToCartPageObjectFactory;
import com.endava.selenium.page.LoginPageObjectFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SeleniumTest {

    WebDriver driver;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://shop.demoqa.com/");
    }

   @Test
   @DisplayName("Login")
    public void testLoginPageFactory(){
        LoginPageObjectFactory loginPage = new LoginPageObjectFactory(driver);
        loginPage.login("olga.vozian@gmail.com","Metrojil739#");
        assertThat(loginPage.getUserNameValue().equals("OlgaVozian"), is(true));
    }

   @Test
   @DisplayName("Add to Cart")
    public void addItemToCart() {
       AddToCartPageObjectFactory searchArticle = new AddToCartPageObjectFactory(driver);
       searchArticle.addToCartItem("Dress");
       assertTrue(searchArticle.getInformativeMessageValue().contains("has been added"));
   }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}

