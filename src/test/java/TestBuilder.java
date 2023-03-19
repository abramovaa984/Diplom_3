import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import pageObject.BuilderPage;

public class TestBuilder extends TestMain {

    @Test
    @DisplayName("Переход к разделу «Булки»")
    public void testTransitToBuns() {
        BuilderPage builderPage = new BuilderPage(webDriver);
        builderPage.clickSauceHeader();
        builderPage.clickBunHeader();
        Assert.assertEquals("Булки", builderPage.textFromBunHeader());
    }

    @Test
    @DisplayName("Переход к разделу «Соусы»")
    public void testTransitToSauces() {
        BuilderPage builderPage = new BuilderPage(webDriver);
        builderPage.clickSauceHeader();
        builderPage.clickBunHeader();
        builderPage.clickSauceHeader();
        Assert.assertEquals("Соусы", builderPage.textFromSauceHeader());
    }

    @Test
    @DisplayName("Переход к разделу «Начинки»")
    public void testTransitToToppings() {
        BuilderPage builderPage = new BuilderPage(webDriver);
        builderPage.clickSauceHeader();
        builderPage.clickBunHeader();
        builderPage.clickToppingHeader();
        Assert.assertEquals("Начинки", builderPage.textFromToppingHeader());
    }
}