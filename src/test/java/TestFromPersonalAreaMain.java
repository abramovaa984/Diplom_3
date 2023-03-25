import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.openqa.selenium.By;
import pageObject.BuilderPage;
import pageObject.PersonalDataPage;

public class TestFromPersonalAreaMain extends TestMain {

    @Test
    @DisplayName("Переход по клику на «Личный кабинет»")
    public void testEntryToPersonalAcc() {
        PersonalDataPage personalDataPage = new PersonalDataPage(webDriver);
        personalDataPage.clickLoginAccountBottom();
        personalDataPage.checkEntryHeaderIsDisplayed();
    }

    @Test
    @DisplayName("Переход по клику на «Конструктор»")
    public void testTransitToBuilder() {
        PersonalDataPage personalDataPage = new PersonalDataPage(webDriver);
        personalDataPage.clickLoginAccountBottom();
        personalDataPage.clickBuilderBottom();
        BuilderPage builderPage = new BuilderPage(webDriver);
        webDriver.findElement(By.xpath("//*[@id=\"root\"]/div/header/nav/ul/li[1]/a")).isDisplayed();
    }

    @Test
    @DisplayName("Переход по клику на логотип Stellar Burgers")
    public void testTransitLogoToBuilder() {
        PersonalDataPage personalDataPage = new PersonalDataPage(webDriver);
        personalDataPage.clickLoginAccountBottom();
        personalDataPage.clickLogo();
        BuilderPage builderPage = new BuilderPage(webDriver);
        webDriver.findElement(By.xpath("//*[@id=\"root\"]/div/header/nav/div")).isDisplayed();
    }

}