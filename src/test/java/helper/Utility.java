package helper;

import java.io.File;

public class Utility {
    public static File getJSONSchemaFile(String JSONFile){
        return new File("src/test/java/helper/JSONSchemaData/"+JSONFile);
}

//public static String generateRandomEmail(){
      //  String allowedChars ="abcdefghijklmnopqrstuvwxyz" + "1234567890"+"_-.";
      //  String email ="";
       // String temp = RandomStringUtils.randomAlphabetic(10);// panjang email 10 karakter
   // email = temp+"@testdata.com";
   // return email;
//}

}
