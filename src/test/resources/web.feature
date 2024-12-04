Feature:  Test Automation Web

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