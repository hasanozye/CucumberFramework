@login2
Feature: login functionality

  Scenario Outline: login 2
    Given user on homepage
    When user clicks the following links with text
      | My Account |
      | Login      |
    Then login page should be visible

    When  user fill the login form with the following datas
      | username | <username> |
      | password | <password> |
    And user clicks Login button
    Then login should be "<success>"

    Examples:
      | username           | password | success |
      | deneme@deneme.com  | deneme   | true    |
      |                    |          | false   |
      | deneme@deneme.com  |          | true    |
      |                    | deneme   | false   |
      | deneme1@deneme.com | deneme   | false   |
      | deneme@deneme.com  | deneme1  | false   |
      | deneme@deneme.com  | deneme   | false   |
      | a                  | a        | false   |

