Feature: Login page feature

    @testcases @login
  Scenario: Login page title
    Given Go to the url "https://rahulshettyacademy.com/client/#/auth/login"
    When User gets the title of the page
    Then Page title should be "Let's Shop"

    @testcases @forgotPassworLink
  Scenario: Forgot Password link
    Given Go to the url "https://rahulshettyacademy.com/client/#/auth/login"
    Then Verify that forgot password link is displayed

    @testcases @loginWithCreds
  Scenario: Login with correct credentials
    Given Go to the url "https://rahulshettyacademy.com/client/#/auth/login"
    When User enters username "doubledouble@gmail.com"
    And User enters password "double@1234"
    And Click on Login button
    Then User gets the title of the page
    And Page title should be "Let's Shop"

    @testcases @registerUser
  Scenario: Create a new account
    Given Go to the url "https://rahulshettyacademy.com/client/#/auth/login"
    And Click on "Register here" link
    And Fill first name, last name, useremail and usermobile with randoms
    And Select "Student" in occupation field
    And Click on "Male" for gender radio button
    And Fill "userPassword" field with "Aman@9635992829"
    And Fill "confirmPassword" field with "Aman@9635992829"
    And "Check" the "checkbox" field
    And Click on "login" button
    Then Verify the visibility of "Account Created Successfully" heading
    And Verify the visibility of "Registered successfully" toast message