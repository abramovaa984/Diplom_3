import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.openqa.selenium.By;
import pageObject.BuilderPage;

public class TestBuilder extends TestMain {

    @Test
    @DisplayName("Переход к разделу «Булки»")
    public void testTransitToBuns() {
        BuilderPage builderPage = new BuilderPage(webDriver);
        builderPage.clickSauceHeader();
        builderPage.clickBunHeader();
        webDriver.findElement(By.xpath("//span[text()='Булки']")).isDisplayed();
    }

    @Test
    @DisplayName("Переход к разделу «Соусы»")
    public void testTransitToSauces() {
        BuilderPage builderPage = new BuilderPage(webDriver);
        builderPage.clickSauceHeader();
        builderPage.clickBunHeader();
        builderPage.clickSauceHeader();
        webDriver.findElement(By.xpath("//span[text()='Соусы']")).isDisplayed();
    }

    @Test
    @DisplayName("Переход к разделу «Начинки»")
    public void testTransitToToppings() {
        BuilderPage builderPage = new BuilderPage(webDriver);
        builderPage.clickSauceHeader();
        builderPage.clickBunHeader();
        builderPage.clickToppingHeader();
        webDriver.findElement(By.xpath("//span[text()='Начинки']")).isDisplayed();
    }
}