package helper;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;

import static helper.Utility.generateRandomEmail;

//import static helper.Utility.generateRandomEmail;

public class Models {

    private static RequestSpecification request;

    public static void setupHeader() {
        request = RestAssured.given()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .header("Authorization", "Bearer 7154a9db30ed462444c77c010ed62745b60717b0d7bc8811afed4235efc32ea5");
    }

    public static Response getListUser(String endpoint) {
        System.out.println("end poin yang di lempar :" + endpoint);
        setupHeader();
        return request.when().get(endpoint);
    }

    public static Response postCreateUser(String endpoint) {
        String name = "Kristina create";
        String email = generateRandomEmail();
        String gender = "female";
        String status = "active";
        JSONObject payload = new JSONObject();
        payload.put("name", name);
        payload.put("email", email);
        payload.put("gender", gender);
        payload.put("status", status);

        setupHeader();
        return request.body(payload.toString()).when().post(endpoint);
    }

    public static Response deleteUser(String endpoint, String user_id) {
        setupHeader();
        String finalEndpoint = endpoint + "/" + user_id;
        return request.when().delete(finalEndpoint);
    }

    public static Response updateUser(String endpoint, String user_id) {
        setupHeader();

        String name = "Kristin update";
        String email = generateRandomEmail();
        String gender = "female";
        String status = "active";
        JSONObject payload = new JSONObject();
        payload.put("name", name);
        payload.put("email", email);
        payload.put("gender", gender);
        payload.put("status", status);

        String finalEndpoint = endpoint + "/" + user_id;
        return request.body(payload.toString()).when().patch(finalEndpoint);
    }


    public static Response postCreateWrongUser(String endpoint) {
        String name = "Kristina wrong";
        String email = generateRandomEmail();
        String gender = "femalex";
        String status = "activex";
        JSONObject payload = new JSONObject();
        payload.put("name", name);
        payload.put("email", email);
        payload.put("gender", gender);
        payload.put("status", status);

        setupHeader();
        return request.body(payload.toString()).when().post(endpoint);
    }


    public static Response WrongUpadteUser(String endpoint, String user_id) {
        setupHeader();

        String name = "Kristin wrong ";
        String email = generateRandomEmail();
        String gender = "femalex";
        String status = "active";
        JSONObject payload = new JSONObject();
        payload.put("name", name);
        payload.put("email", email);
        payload.put("gender", gender);
        payload.put("status", status);

        String finalEndpoint = endpoint + "/" + user_id;
        return request.body(payload.toString()).when().patch(finalEndpoint);
    }
}