Feature: 001Register

  @Register
  Scenario: Register success
    Given I Open the register page
    And I fill with all valid data
    Then Click register button
    And Verify register is success

  @Register
  Scenario: Register using email already taken
    Given I Open the register page
    And I fill with registered email
    Then Click register button
    And Verify there is a toast notification

  @Register
  Scenario: Register using invalid data
    Given I Open the register page
    And I fill with invalid name
    Then Click register button
    And Verify there is a notification on name form