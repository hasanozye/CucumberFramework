Feature: login functionality

  Scenario: login with tabKey
    Given user on homepage
    When user clicks My Account Link
    And user clicks Login Link
    Then login page should be visible
    And Press Tab keyboard key until the control comes to the "E-Mail" text field

    When user fill the email with the following data
      | username | deneme@deneme.com |

    And Press Tab keyboard key until the control comes to the "Password" text field

    When user fill the password with the following data
      | password | deneme |
