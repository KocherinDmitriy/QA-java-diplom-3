package unils;

import java.util.ArrayList;
import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class CreateUser extends BaseSpec {
    public CreateUser() {
    }


    private HashMap getBodyCreateUserRequest(String email, String password, String name) {
        HashMap<String, Object> dataBody = new HashMap<String, Object>();
        dataBody.put("email", email);
        dataBody.put("password", password);
        dataBody.put("name", name);

        return dataBody;
    }


    private void sendPostRequestCreateUser(String email, String password, String name) {
        given()
                .spec(REQ_SPEC)
                .and()
                .body(getBodyCreateUserRequest(email, password, name))
                .when()
                .post("/api/auth/register");
    }

    public ArrayList<String> createUserMethod(String email, String password, String name) {

        ArrayList<String> credentials = new ArrayList<>(2);
        sendPostRequestCreateUser(email, password, name);
        credentials.add(email);
        credentials.add(password);

        return credentials;
    }


}
