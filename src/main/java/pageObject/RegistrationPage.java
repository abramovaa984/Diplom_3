package pageObject;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage extends MainPage {

    private final By registrationName = By.xpath("//label[text() = 'Имя']/following-sibling::input");
    private final By registrationEmail = By.xpath("//label[text() = 'Email']/following-sibling::input");
    private final By registrationPassword = By.xpath("//input[@name = 'Пароль']");
    private final By shortPasswordError = By.xpath("//p[text()='Некорректный пароль']");
    private final By registrationAccountButton = By.xpath("//button[text()='Зарегистрироваться']");
    private final By registrationLoginButton = By.xpath("//button[text()='Войти']");

    public RegistrationPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void openRegistrationPage() {
        webDriver.get("https://stellarburgers.nomoreparties.site/register");
    }

    public void clickRegistrationAccountButton() {
        webDriver.findElement(registrationAccountButton).click();
    }

    public void registrationDataField(String name, String email, String password) {
        webDriver.findElement(registrationName).sendKeys(name);
        webDriver.findElement(registrationEmail).sendKeys(email);
        webDriver.findElement(registrationPassword).sendKeys(password);
    }

    public String getTextPasswordError() {
        return webDriver.findElement(shortPasswordError).getText();
    }

    public void checkLoginButtonIsDisplayed() {
        Assert.assertTrue(webDriver.findElement(registrationLoginButton).isDisplayed());
    }
}