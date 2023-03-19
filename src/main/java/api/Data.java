package api;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import user.UserAuthorization;
import user.CreateUser;

import static io.restassured.RestAssured.given;

public class Data {
    String baseUri = "http://stellarburgers.nomoreparties.site/api/";

    @Step("Регистрация пользователя")
    public Response NewUserRegistration(CreateUser createUser) {
        Response response = given()
                .header("Content-type", "application/json")
                .baseUri(baseUri)
                .body(createUser)
                .post("auth/register");
        response.then();
        return response;
    }

    @Step("Авторизация пользователя")
    public Response UserAuthorization(UserAuthorization userAuthorization) {
        Response response = given()
                .header("Content-type", "application/json")
                .baseUri(baseUri)
                .body(userAuthorization)
                .post("auth/login");
        response.then();
        return response;
    }

    @Step("Получение access token успешно зарегистрированного пользователя")
    public String getAccessToken(UserAuthorization userAuthorization) {
        return UserAuthorization(userAuthorization)
                .then()
                .extract()
                .path("accessToken");
    }

    @Step("Удаление пользователя")
    public Response UserDelete(String accessToken) {
        Response response = given()
                .header("Authorization", accessToken)
                .baseUri(baseUri)
                .when()
                .delete("auth/user");
        return response;
    }
}