Feature:  Test Automation Login Web

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