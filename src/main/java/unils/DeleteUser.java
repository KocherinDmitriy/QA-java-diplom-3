package unils;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import unils.pojo.CreateUserResponse;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class DeleteUser {

    private static final RequestSpecification REQ_SPEC=
            new RequestSpecBuilder()
                    .setBaseUri("https://stellarburgers.nomoreparties.site")
                    .setContentType(ContentType.JSON)
                    .build();


    public static void sendDeleteRequestUser() {
        given()
                .spec(REQ_SPEC)
                .and().auth().oauth2(getAuthToken())
                .and()
                .body("")
                .when()
                .delete("/api/auth/user");

    }

    public static HashMap getBodyAuthUserRequest(String email, String password) {
        HashMap<String, Object> dataBody = new HashMap<String, Object>();
        dataBody.put("email", email);
        dataBody.put("password", password);

        return dataBody;
    }

    private static String getAuthToken() {
        Response response =
                given()
                .spec(REQ_SPEC)
                .and()
                .body(getBodyAuthUserRequest(CreateUser.getLogin(),CreateUser.getPassword()))
                .when()
                .post("/api/auth/login");

        CreateUserResponse createUserResponse = response.body().as(CreateUserResponse.class);
        return createUserResponse.getAccessToken();
}
}
