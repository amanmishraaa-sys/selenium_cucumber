Feature: Login page feature

  Scenario: Login page title
    Given Go to the url "https://rahulshettyacademy.com/client/#/auth/login"
    When User gets the title of the page
    Then Page title should be "Let's Shop"

  Scenario: Forgot Password link
    Given Go to the url "https://rahulshettyacademy.com/client/#/auth/login"
    Then Verify that forgot password link is displayed

  Scenario: Login with correct credentials
    Given Go to the url "https://rahulshettyacademy.com/client/#/auth/login"
    When User enters username "doubledouble@gmail.com"
    And User enters password "double@1234"
    And Click on Login button
    Then User gets the title of the page
    And Page title should be "Let's Shop"