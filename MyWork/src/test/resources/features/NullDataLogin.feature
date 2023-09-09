Feature: login functionality

  Scenario: login with null credentials
    Given user on homepage
    When user clicks My Account Link
    And user clicks Login Link
    Then login page should be visible
    And user clicks Login button
    Then login should be fail
