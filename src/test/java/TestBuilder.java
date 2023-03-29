import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pageObject.BuilderPage;


public class TestBuilder extends TestMain {

    @Test
    @DisplayName("Переход к разделу «Булки»")
    public void testTransitToBuns() {
        BuilderPage builderPage = new BuilderPage(webDriver);
        builderPage.clickBunHeader();
        wait.until(ExpectedConditions.visibilityOf(webDriver.findElement(builderPage.selectedBunHeader)));
        Assert.assertEquals("Булки", webDriver.findElement(builderPage.selectedBunHeader).getText());
    }

    @Test
    @DisplayName("Переход к разделу «Соусы»")
    public void testTransitToSauces() {
        BuilderPage builderPage = new BuilderPage(webDriver);
        builderPage.clickSauceHeader();
        wait.until(ExpectedConditions.visibilityOf(webDriver.findElement(builderPage.selectedSauceHeader)));
        Assert.assertEquals("Соусы", webDriver.findElement(builderPage.selectedSauceHeader).getText());
    }

    @Test
    @DisplayName("Переход к разделу «Начинки»")
    public void testTransitToToppings() {
        BuilderPage builderPage = new BuilderPage(webDriver);
        builderPage.clickSauceHeader();
        wait.until(ExpectedConditions.visibilityOf(webDriver.findElement(builderPage.selectedToppingHeader)));
        Assert.assertEquals("Начинки", webDriver.findElement(builderPage.selectedToppingHeader).getText());
    }

}