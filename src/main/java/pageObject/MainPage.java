package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class MainPage {

    protected WebDriver webDriver;
    public static WebDriverWait wait;

    protected MainPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
}