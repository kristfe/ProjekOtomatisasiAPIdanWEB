Feature: Test Automation Rest Api

@api
    Scenario: Test get list data normal
    Given prepare url valid for "GET_LIST_USERS"
    And hit api get list users
    Then validation status code is equal 200
    Then validation response body get list users
    Then validation response json with JSONScema "get_list_user_normal.json"

   @api
    Scenario: Test create user normal
     Given prepare url valid for "CREATE_NEW_USERS"
     And   hit api post create new user
     Then validation status code is equal 201
     Then validation response body post create new user
     Then validation response json with JSONScema "post_create_new_user_normal.json"

  @api
  Scenario: Test create user wrong normal
    Given prepare url valid for "CREATE_NEW_USERS"
    And   hit api post create new user invalid
    Then  validation status code is equal 422

     @api
     Scenario: Test delete user normal
       Given prepare url valid for "CREATE_NEW_USERS"
       And   hit api post create new user
       Then validation status code is equal 201
       Then validation response body post create new user
       And hit api delete new
       Then validation status code is equal 204

    @api
      Scenario: Test update user normal
      Given prepare url valid for "CREATE_NEW_USERS"
      And   hit api post create new user
      Then validation status code is equal 201
      Then validation response body post create new user
      And hit api update data
      Then validation status code is equal 200
      Then validation response body update user

  @api
  Scenario: Test update wrong user normal
    Given prepare url valid for "CREATE_NEW_USERS"
    And   hit api post create new user
    Then validation status code is equal 201
    Then validation response body post create new user
    And hit api update wrong data
    Then validation status code is equal 422
