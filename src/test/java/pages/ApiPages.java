package pages;

import helper.Endpoint;
import helper.Utility;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.io.File;
import java.util.List;

import static helper.Models.*;
import static org.assertj.core.api.Assertions.assertThat;

public class ApiPages {

    String setURL, global_id;
    Response res;


  public void prepareUrlValidFor( String url){
      switch (url){
          case "GET_LIST_USERS":
              setURL= Endpoint.GET_LIST_USERS;
              break;

          case "CREATE_NEW_USERS":
              setURL= Endpoint.CREATE_NEW_USERS;
              break;

          case "DELETE_NEW_USERS":
              setURL= Endpoint.DELETE_NEW_USERS;
              break;
          default:
          System.out.println("Input right URL ");
      }
      System.out.println("endpoint siap pakai adalah : "+setURL);
  }

    public void hitApiGetListUsers(){
      res = getListUser(setURL);
     System.out.println(res.getBody().asString());
    }

    public void hitApiPostCreateNewUser(){
        res = postCreateUser(setURL);
        System.out.println(res.getBody().asString());
    }

    public void validationStatusCodeIsEqual( int status_code){
        assertThat(res.statusCode()).isEqualTo(status_code);
  }

    public void validationResponseBodyGetListUsers(){
        List<Object> id = res.jsonPath().getList("id");
        List<Object> name = res.jsonPath().getList("name");
        List<Object> email = res.jsonPath().getList("email");
        List<Object> gender = res.jsonPath().getList("gender");
        List<Object> status = res.jsonPath().getList("status");

        System.out.println(id.get(1));
        System.out.println(name.get(1));
        System.out.println(email.get(1));
        System.out.println(gender.get(1));
        System.out.println(status.get(1));

        assertThat(id.get(1)).isNotNull();
        assertThat(name.get(1)).isNotNull();
        assertThat(email.get(1)).isNotNull();
        assertThat(gender.get(1)).isIn("female","male");
        assertThat(status.get(1)).isIn("active", "inactive");

    }

    public void validationResponseJsonWithJSONScema( String filename){
        File JSONfile = Utility.getJSONSchemaFile(filename);
        res.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(JSONfile));
    }

    public void validationResponseBodyCreateUser(){
        JsonPath jsonPathEvaluator = res.jsonPath();
        Integer id  = jsonPathEvaluator.get("id");
        String name = jsonPathEvaluator.get ("name");
        String email = jsonPathEvaluator.get("email");
        String gender = jsonPathEvaluator.get("gender");
        String status = jsonPathEvaluator.get("status");

        assertThat(id).isNotNull();
        assertThat(name).isNotNull();
        assertThat(email).isNotNull();
        assertThat(gender).isIn("female","male");
        assertThat(status).isIn("active", "inactive");

        global_id =Integer.toString(id);

    }

    public void hitApiDeleteUser(){
      res = deleteUser(setURL,global_id);
    }

    public  void hitUpdateUser(){
      res = updateUser(setURL,global_id);
}

    public  void hitWrongUpdateUser(){
        res = WrongUpadteUser(setURL,global_id);
    }

public void validationResponseUpdateUser(){
        JsonPath jsonPathEvaluator = res.jsonPath();
        Integer id = jsonPathEvaluator.get("id");
        String name = jsonPathEvaluator.get("name");
        String email = jsonPathEvaluator.get("email");
        String gender = jsonPathEvaluator.get("gender");
        String status = jsonPathEvaluator.get("status");

        assertThat(id).isNotNull();
        assertThat(name).isNotNull();
        assertThat(email).isNotNull();
        assertThat(gender).isIn("female","male");
        assertThat(status).isIn("active", "inactive");
}

    public void hitApiPostCreateNewWrongUser(){
        res = postCreateWrongUser(setURL);
        System.out.println(res.getBody().asString());
    }


   }
