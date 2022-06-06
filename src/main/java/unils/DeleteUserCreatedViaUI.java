package unils;

import io.restassured.response.Response;
import unils.pojo.CreateUserResponse;

import static io.restassured.RestAssured.given;

public class DeleteUserCreatedViaUI {
    public static void sendDeleteRequestUserFromUI(String login, String password) {
        given()
                .header("Content-type", "application/json").auth().oauth2(getAuthToken(login,password))
                .and()
                .body("")
                .when()
                .delete("https://stellarburgers.nomoreparties.site/api/auth/user");

    }

    private static String getAuthToken(String login,String password) {
        Response response = given()
                .header("Content-type", "application/json")
                .and()
                .body("{\"email\":\"" + login + "\","
                        + "\"password\":\"" + password + "\"}")
                .when()
                .post("https://stellarburgers.nomoreparties.site/api/auth/login");

        CreateUserResponse createUserResponse = response.body().as(CreateUserResponse.class);
        return createUserResponse.getAccessToken();
    }

}
