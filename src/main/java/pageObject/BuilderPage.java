package pageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BuilderPage extends MainPage {

    private final By bunHeader = By.xpath("//span[text()='Булки']");
    private final By sauceHeader = By.xpath("//span[text()='Соусы']");
    private final By toppingHeader = By.xpath("//span[text()='Начинки']");

    public BuilderPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Step("Переход к разделу Булки")
    public void clickBunHeader() {
        webDriver.findElement(bunHeader).click();
    }

    @Step("Переход к разделу Соусы")
    public void clickSauceHeader() {
        webDriver.findElement(sauceHeader).click();
    }

    @Step("Переход к разделу Начинки")
    public void clickToppingHeader() {
        webDriver.findElement(toppingHeader).click();
    }


    public String textFromBunHeader() {
        return webDriver.findElement(bunHeader).getText();
    }

    public String textFromSauceHeader() {
        return webDriver.findElement(sauceHeader).getText();
    }

    public String textFromToppingHeader(){
        return webDriver.findElement(toppingHeader).getText();
    }
}