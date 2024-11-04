package pages;

import helper.Endpoint;
import helper.Utility;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;

import java.io.File;
import java.util.List;

import static helper.Models.getListUser;
//import static helper.Models.postCreateUser;
import static org.assertj.core.api.Assertions.assertThat;

public class ApiPages {

    String setURL;
    Response res;
    //private Object utility;

    // public void prepareURL()
  //{
  //    System.out.println("Hello Prepare URL");
  //}

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
        //System.out.println(res.getBody().asString());
    }

    //public void hitApiPostCreateNewUser(){
       // res = postCreateUser(setURL);
    //}

    public void validationStatusCodeIsEqual( int status_code){
        //System.out.println("print from page :3");
        assertThat(res.statusCode()).isEqualTo(status_code);
  }

    public void validationResponseBodyGetListUsers(){
        //System.out.println("print from page :4");
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

        assertThat(id.get(0)).isNotNull();
        assertThat(name.get(0)).isNotNull();
        assertThat(email.get(0)).isNotNull();
        assertThat(gender.get(0)).isIn("female","male");
        assertThat(status.get(0)).isIn("active", "inactive");
    }

    public void validationResponseJsonWithJSONScema( String filename){
        //System.out.println("print from page :5");
        File JSONfile = Utility.getJSONSchemaFile(filename);
        res.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(JSONfile));
    }
   }
