Feature: login functionality

  Scenario: Validating Forget Password Link
    Given user on homepage
    When user clicks My Account Link
    And user clicks Login Link
    Then login page should be visible
    When user clicks forgotten password link