import api.Data;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import pageObject.RegistrationPage;
import user.UserAuthorization;
import user.CreateUser;

import static user.CreateUser.getUserCredentials;
import static user.CreateUser.getUserWrongPassword;

public class TestRegistrationMain extends TestMain {

    CreateUser createUser = new CreateUser();
    CreateUser createTheUserWrongPassword = new CreateUser();
    Data regAndAuthUser = new Data();

    @Test
    @DisplayName("Успешная регистрация")
    public void verifySuccessRegIsPossible() {
        RegistrationPage registrationPage = new RegistrationPage(webDriver);
        createUser = getUserCredentials();
        registrationPage.openRegistrationPage();
        registrationPage.registrationDataField(createUser.getName(), createUser.getEmail(), createUser.getPassword());
        registrationPage.clickRegistrationAccountButton();
        registrationPage.checkLoginButtonIsDisplayed();
    }

    @Test
    @DisplayName("Некорректный пароль. Минимальный пароль — шесть символов")
    public void verifyErrorShortPasswordReg() {
        RegistrationPage registrationPage = new RegistrationPage(webDriver);
        createTheUserWrongPassword = getUserWrongPassword();
        regAndAuthUser.NewUserRegistration(createTheUserWrongPassword);
        registrationPage.openRegistrationPage();
        registrationPage.registrationDataField(createTheUserWrongPassword.getName(), createTheUserWrongPassword.getEmail(), createTheUserWrongPassword.getPassword());
        registrationPage.clickRegistrationAccountButton();
        Assert.assertEquals("Некорректный пароль. Минимальный пароль — шесть символов", registrationPage.getTextPasswordError());
    }

    @After
    public void removeUser() {
        Data regAndAuthUser = new Data();
        UserAuthorization userAuthorization = new UserAuthorization();
        Response response = regAndAuthUser.UserAuthorization(userAuthorization);
        String accessToken = response
                .then()
                .extract()
                .path("accessToken");

        if (accessToken != null) {
            regAndAuthUser.UserDelete(accessToken);
        }
    }
}