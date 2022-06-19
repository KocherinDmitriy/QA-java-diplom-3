package unils;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.commons.lang3.RandomStringUtils;
import unils.pojo.CreateUserResponse;

import java.util.ArrayList;
import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class CreateUser {

    static String login = String.format("%s@gmail.com", RandomStringUtils.randomAlphabetic(10));
    static String password = RandomStringUtils.randomAlphabetic(10);
    static String name = RandomStringUtils.randomAlphabetic(10);

    public static HashMap getBodyCreateUserRequest(String email, String password, String name) {
        HashMap<String, Object> dataBody = new HashMap<String, Object>();
        dataBody.put("email", getLogin());
        dataBody.put("password", getPassword());
        dataBody.put("name", getName());

        return dataBody;
    }
    private static final RequestSpecification REQ_SPEC=
            new RequestSpecBuilder()
                    .setBaseUri("https://stellarburgers.nomoreparties.site")
                    .setBasePath("/api/auth/register")
                    .setContentType(ContentType.JSON)
                    .build();


    public static void sendPostRequestCreateUser(String email, String password, String name) {
                given()
                .spec(REQ_SPEC)
                .and()
                .body(getBodyCreateUserRequest(email,password,name))
                .when()
                .post();
        ;


    }



    public static String getLogin() {
        return login;
    }

    public static String getPassword() {
        return password;
    }

    public static String getName() {
        return name;
    }

    public static ArrayList<String> createUserMethod() {

        ArrayList<String> credentials = new ArrayList<>(2);
        CreateUser.sendPostRequestCreateUser(login, password, name);
        credentials.add(login);
        credentials.add(password);


        return credentials;
    }


}
