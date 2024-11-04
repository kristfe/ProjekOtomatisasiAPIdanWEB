Feature: Test Automation Rest Api

git @api
    Scenario: Test get list data normal
    Given prepare url valid for "GET_LIST_USERS"
    And hit api get list users
    Then validation status code is equal 200
    Then validation response body get list users
    Then validation response json with JSONScema "get_list_users_normal.json"

   // @api
      // Scenario: Test create user normal
     // Given prepare url valid for "CREATE_NEW_USERS"
    //    And hit api post create new user
