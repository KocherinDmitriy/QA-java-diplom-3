package unils;
import io.restassured.response.Response;
import org.apache.commons.lang3.RandomStringUtils;
import unils.pojo.CreateUserResponse;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;

public class CreateUser {


    public static void sendPostRequestCreateUser(String email, String password, String name) {
            given()
                .header("Content-type", "application/json")
                .and()
                .body("{\"email\":\"" + email + "\","
                        + "\"password\":\"" + password + "\","
                        + "\"name\":\"" + name + "\"}")
                .when()
                .post("https://stellarburgers.nomoreparties.site/api/auth/register");
        ;


    }

    static String login = String.format("%s@gmail.com", RandomStringUtils.randomAlphabetic(10));
    static String password = RandomStringUtils.randomAlphabetic(10);
    static String name = RandomStringUtils.randomAlphabetic(10);

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
