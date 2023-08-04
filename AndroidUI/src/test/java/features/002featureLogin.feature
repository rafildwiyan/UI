Feature: 002Login

  @Login
  Scenario: Login success
    Given I Open the login page
    And I fill with valid data
    Then Click login button
    And Verify login is success

  @Login
  Scenario: Login with invalid email
    Given I Open the login page
    And I fill with invalid email
    Then Click login button
    And Verify there is a notification on email form

  @Login
  Scenario: Login with invalid password
    Given I Open the login page
    And I fill with invalid password
    Then Click login button
    And Verify there is a notification toast