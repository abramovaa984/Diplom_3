import api.Data;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pageObject.AuthorizationPage;
import pageObject.BuilderPage;
import pageObject.PersonalDataPage;
import pageObject.RegistrationPage;
import user.CreateUser;
import user.UserAuthorization;

import static user.CreateUser.getUserCredentials;

public class TestAuthorizationMain extends TestMain {

    CreateUser createUser = new CreateUser();
    Data regAndAuthUser = new Data();
    RegistrationPage registrationPage;
    PersonalDataPage personalDataPage;
    BuilderPage builderPage;
    AuthorizationPage authorizationPage;

    @Before
    public void setUp() {
        registrationPage = new RegistrationPage(webDriver);
        personalDataPage = new PersonalDataPage(webDriver);
        builderPage = new BuilderPage(webDriver);
        authorizationPage = new AuthorizationPage(webDriver);
        createUser = getUserCredentials();
        regAndAuthUser.NewUserRegistration(createUser);
    }

    @Test
    @DisplayName("Вход по кнопке «Войти в аккаунт» на главной")
    public void testLoginToAccountWithButtonOnMainPage() {
        authorizationPage.clickLoginAccountBottom();
        authorizationPage.setEmailField(createUser.getEmail());
        authorizationPage.setPasswordField(createUser.getPassword());
        authorizationPage.clickLoginBottom();
        builderPage.checkMakeOrderIsDisplayed();
    }

    @Test
    @DisplayName("Вход через кнопку «Личный кабинет»")
    public void testLoginToPersonalAccountButtonOnMainPage() {
        authorizationPage.clickPersonalAccountBottom();
        authorizationPage.setEmailField(createUser.getEmail());
        authorizationPage.setPasswordField(createUser.getPassword());
        authorizationPage.clickLoginBottom();
        builderPage.checkMakeOrderIsDisplayed();
    }

    @Test
    @DisplayName("Вход через кнопку в форме регистрации")
    public void testLoginFromRegistrationPage() {
        authorizationPage.clickPersonalAccountBottom();
        authorizationPage.clickRegistrationBottom();
        authorizationPage.clickLoginInRegistrationBottom();
        authorizationPage.setEmailField(createUser.getEmail());
        authorizationPage.setPasswordField(createUser.getPassword());
        authorizationPage.clickLoginBottom();
        builderPage.checkMakeOrderIsDisplayed();
    }

    @Test
    @DisplayName("Вход через кнопку в форме восстановления пароля")
    public void testLoginFromForgotPasswordPage() {
        authorizationPage.clickPersonalAccountBottom();
        authorizationPage.clickForgotPasswordBottom();
        authorizationPage.clickLoginInRegistrationBottom();
        authorizationPage.setEmailField(createUser.getEmail());
        authorizationPage.setPasswordField(createUser.getPassword());
        authorizationPage.clickLoginBottom();
        builderPage.checkMakeOrderIsDisplayed();
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