# Automated API and WEB Testing 
Project Automation testing untuk menguji API dengan data https://gorest.co.in/public/v2/users
web product store https://www.saucedemo.com/

#Build With 
Chrome : browser-actions/setup-chrome@v1.6.1
Java   : Set up JDK 17
cucumber framework
selenium 
restassure
gradle wraper 

#Project Structure 
![image](https://github.com/user-attachments/assets/d627ebc9-bf09-428a-99d9-b88739e9f74c)




 
library yang di gunakan 

    testImplementation platform('org.junit:junit-bom:5.10.0')
    testImplementation 'org.junit.jupiter:junit-jupiter'
    testImplementation 'org.junit.vintage:junit-vintage-engine:5.7.2'

    implementation group: 'io.cucumber', name: 'cucumber-java', version: '7.12.0'
    testImplementation group: 'io.cucumber', name: 'cucumber-junit', version: '7.12.0'

    testImplementation group: 'io.rest-assured', name: 'rest-assured', version: '5.3.0'
    testImplementation 'io.rest-assured:json-path:5.3.0'
    testImplementation 'io.rest-assured:json-schema-validator:5.3.0'
    testImplementation group: 'org.assertj', name: 'assertj-core', version: '3.24.0'
    testImplementation group: 'org.json', name: 'json', version: '20220924'

    implementation group: 'org.seleniumhq.selenium', name: 'selenium-java', version: '4.10.0'
    implementation 'io.github.bonigarcia:webdrivermanager:5.4.1'
    implementation "org.jetbrains.kotlin:kotlin-stdlib-jdk8"
    testImplementation 'org.hamcrest:hamcrest-library:1.3'




 
Feature: Test Automation Rest Api
@api
    Scenario: Test get list data normal
    Given prepare url valid for "GET_LIST_USERS"
    When hit api get list users
    Then validation status code is equal 200
    When validation response body get list users
    Then validation response json with JSONScema "get_list_user_normal.json"

   @api
    Scenario: Test create user normal
     Given prepare url valid for "CREATE_NEW_USERS"
     When   hit api post create new user
     Then validation status code is equal 201
     When validation response body post create new user
     Then validation response json with JSONScema "post_create_new_user_normal.json"

  @api
  Scenario: Test create user wrong normal
    Given prepare url valid for "CREATE_NEW_USERS"
    When   hit api post create new user invalid
    Then  validation status code is equal 422

     @api
     Scenario: Test delete user normal
       Given prepare url valid for "CREATE_NEW_USERS"
       When   hit api post create new user
       Then validation status code is equal 201
       When validation response body post create new user
       And hit api delete new
       Then validation status code is equal 204

    @api
      Scenario: Test update user normal
      Given prepare url valid for "CREATE_NEW_USERS"
      When   hit api post create new user
      Then validation status code is equal 201
      When validation response body post create new user
      And hit api update data
      Then validation status code is equal 200
      And validation response body update user

  @api
  Scenario: Test update wrong user normal
    Given prepare url valid for "CREATE_NEW_USERS"
    When   hit api post create new user
    Then validation status code is equal 201
    When validation response body post create new user
    And hit api update wrong data
    Then validation status code is equal 422

    
#ProgramOtomatisasiWeb
Feature:  Test Automation Web

  @web
  Scenario: Test login web normal
    Given open web login page
    And user input username "standard_user"
    And user input password "secret_sauce"
    When user click login button
    And user will see icon from cart in homepage

  @web
  Scenario: Test login web with lock user
    Given open web login page
    And user input username "locked_out_user"
    And user input password "secret_sauce"
    When user click login button
    And user will see error message "user has been locked out"

  @web
  Scenario: Test login user invalid
    Given open web login page
    And user input username "locked_out_user"
    And user input password "secret_saucexxx"
    When user click login button
    And user will see error message "Username and password do not match any user in this service"

  @web
  Scenario: Test login web add to card
    Given open web login page
    And user input username "standard_user"
    And user input password "secret_sauce"
    When user click login button
    And user will see icon from cart in homepage
    When user add item to cart
    When user add item to cart
    When user add item to cart
    Then verify cart is match "3"

  @web
  Scenario: Test login web remove to card
    Given open web login page
    And user input username "standard_user"
    And user input password "secret_sauce"
    When user click login button
    Then user will see icon from cart in homepage
    When user add item to cart
    And user add item to cart
    And user add item to cart
    And user add item to cart
    Then verify cart is match "4"
    When user remove item to cart
    And user remove item to cart
    Then verify cart is match "2"

