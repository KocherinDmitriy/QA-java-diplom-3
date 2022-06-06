package unils;
import io.restassured.response.Response;
import unils.pojo.CreateUserResponse;

import static io.restassured.RestAssured.given;

public class DeleteUser {
    public static void sendDeleteRequestUser() {
                given()
                .header("Content-type", "application/json").auth().oauth2(getAuthToken())
                .and()
                .body("")
                .when()
                .delete("https://stellarburgers.nomoreparties.site/api/auth/user");

    }

    private static String getAuthToken() {
        Response response = given()
                .header("Content-type", "application/json")
                .and()
                .body("{\"email\":\"" + CreateUser.getLogin() + "\","
                        + "\"password\":\"" + CreateUser.getPassword() + "\"}")
                .when()
                .post("https://stellarburgers.nomoreparties.site/api/auth/login");

        CreateUserResponse createUserResponse = response.body().as(CreateUserResponse.class);
        return createUserResponse.getAccessToken();
}
}
