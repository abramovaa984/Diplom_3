package pageObject;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PersonalDataPage extends MainPage {

    public final String MAIN_URL = "https://stellarburgers.nomoreparties.site/";
    public final By loginAccountButton = By.xpath("//button[text()='Войти в аккаунт']");
    public final By loginBottom = By.xpath(".//button[(text()='Войти')]");
    public final By emailField = By.xpath("//input[@name='name']");
    public final By passwordField = By.xpath("//input[@name='Пароль']");
    public final By entryHeader = By.xpath("//h2[text()='Вход']");
    public final By builderBottom = By.xpath(".//p[contains(text(),\"Конструктор\")]");
    public final By logoButton = By.xpath("//*[@id=\"root\"]/div/header/nav/div/a");

    public PersonalDataPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void openMainPage() {
        webDriver.get(MAIN_URL);
    }


    public void clickLoginAccountBottom() {
        webDriver.findElement(loginAccountButton).click();
    }


    public void clickBuilderBottom() {
        webDriver.findElement(builderBottom).click();
    }

    public void setEmailField(String email) {
        webDriver.findElement(emailField).sendKeys(email);
    }

    public void setPasswordField(String password) {
        webDriver.findElement(passwordField).sendKeys(password);
    }

    public void checkEntryHeaderIsDisplayed() {
        Assert.assertTrue(webDriver.findElement(entryHeader).isDisplayed());
    }

    public void checkIfBuilderIsClicable() {
        Assert.assertTrue(webDriver.findElement(builderBottom).isDisplayed());
    }

    public void checkIfLogoIsClicable() {
        Assert.assertTrue(webDriver.findElement(logoButton).isDisplayed());
    }
}