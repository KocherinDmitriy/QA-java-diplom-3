package unils;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import unils.pojo.CreateUserResponse;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class DeleteUserCreatedViaUI {


    private static final RequestSpecification REQ_SPEC=
            new RequestSpecBuilder()
                    .setBaseUri("https://stellarburgers.nomoreparties.site")
                    .setContentType(ContentType.JSON)
                    .build();

    public static HashMap getBodyAuthUserRequest(String login, String password) {
        HashMap<String, Object> dataBody = new HashMap<String, Object>();
        dataBody.put("email", login);
        dataBody.put("password", password);

        return dataBody;
    }

    public static void sendDeleteRequestUserFromUI(String login, String password) throws NullPointerException {
        String oauthToken=getAuthToken(login,password);
        if (oauthToken==null){
        }else {
            given()
                    .spec(REQ_SPEC)
                    .and().auth().oauth2(oauthToken)
                    .and()
                    .body("")
                    .when()
                    .delete("/api/auth/user");
        }
    }

    private static String getAuthToken(String login,String password) {
        if (password.length()<6){
            return null;
        }else {
            Response response =
                    given()
                            .spec(REQ_SPEC)
                            .and()
                            .body(getBodyAuthUserRequest(login,password))
                            .when()
                            .post("/api/auth/login");

            CreateUserResponse createUserResponse = response.body().as(CreateUserResponse.class);
            return createUserResponse.getAccessToken();
        }
    }

}
