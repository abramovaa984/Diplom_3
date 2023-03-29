package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BuilderPage extends MainPage {

    public final By selectedBunHeader =  By.xpath("//div[contains(@class, 'current')]/span[text()='Булки']");
    public final By nonSelectedBunHeader = By.xpath("//div[contains(@class, 'noselect')]/span[text()='Булки']");
    public final By selectedSauceHeader = By.xpath("//div[contains(@class, 'current')]/span[text()='Соусы']");
    public final By nonSelectedSauceHeader = By.xpath("//span[contains(@class, 'noselect')]/span[text()='Соусы']");
    public final By selectedToppingHeader = By.xpath("//div[contains(@class, 'current')]/span[text()='Начинки']");
    public final By nonSelectedToppingHeader = By.xpath("//div[contains(@class, 'noselect')]/span[text()='Начинки']");
    public final By makeOrder = By.xpath("//button[text()='Оформить заказ']");

    public BuilderPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void clickBunHeader() {
        webDriver.findElement(nonSelectedBunHeader).click();
    }

    public void clickSauceHeader() {
        webDriver.findElement(nonSelectedSauceHeader).click();
    }

    public void clickToppingHeader() {
        webDriver.findElement(nonSelectedToppingHeader).click();
    }

    public void checkMakeOrderIsDisplayed() {
        webDriver.findElement(makeOrder).isDisplayed();
    }
}