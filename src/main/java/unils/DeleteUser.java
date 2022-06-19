package unils;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import unils.pojo.CreateUserResponse;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class DeleteUser extends BaseSpec {
    public DeleteUser() {
    }

    public void sendDeleteRequestUser(String email, String password) {
        given()
                .spec(REQ_SPEC)
                .and().auth().oauth2(getAuthToken(email, password))
                .and()
                .body("")
                .when()
                .delete("/api/auth/user");

    }

    private HashMap getBodyAuthUserRequest(String email, String password) {
        HashMap<String, Object> dataBody = new HashMap<String, Object>();
        dataBody.put("email", email);
        dataBody.put("password", password);

        return dataBody;
    }

    private String getAuthToken(String email, String password) {
        Response response =
                given()
                        .spec(REQ_SPEC)
                        .and()
                        .body(getBodyAuthUserRequest(email, password))
                        .when()
                        .post("/api/auth/login");

        CreateUserResponse createUserResponse = response.body().as(CreateUserResponse.class);
        return createUserResponse.getAccessToken();
    }
}
