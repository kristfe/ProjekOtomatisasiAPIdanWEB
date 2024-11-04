package helper;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

//import static helper.Utility.generateRandomEmail;

public class Models {

    private static RequestSpecification request;

    public static void setupHeader(){
        request = RestAssured.given()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .header("Autorization", "Bearer 52e7caa4c9734d6384715d12247c52115689015159636f84b68085f705146dea");
    }

    public static Response getListUser(String endpoint){
        System.out.println("end poin yang di lempar :" + endpoint);
        setupHeader();
        return request.when().get(endpoint);
    }

   // public static Response postCreateUser(String endpoint){
    //    String name = "Kristina fe";
    //   String gender = "female";
       // String email = generateRandomEmail();
      //  String status = "active";
      //  JSONObject payload = new JSONObject();
     //   payload.put("Name", name);
     //   payload.put("gender",gender);
     //   payload.put("email", email);
      //  payload.put("status", status);

       // setupHeader();
      //  return request.body(payload.toString()).when().post(endpoint);
//}
}



