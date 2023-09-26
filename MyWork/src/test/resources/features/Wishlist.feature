@wishList
Feature: Wishlist


  Background: login with true credentials
    Given user on homepage
    When user login with username "deneme@deneme.com" and password "deneme"
    Then  login should be successfull

  @tc1
  Scenario: wishList TC1
    Given  user search for "iMac"
    When user add "iMac" to the wishList
    Then success notification with "wish list!" should be visible

  @tc2
  Scenario: wishList TC2
    Given user clicks on Store Logo
    When user scroll down till the Featured section on the Home page is displayed
    And user add "MacBook" to the wishList
    And success notification with "wish list!" should be visible

  @tc3
  Scenario: wishList TC3
    Given user hovers the mouse on any of the menu option say "Desktops"
    When  user clicks on "Show All Desktops" option
    And   user Selects "Mac" subcategory option from the left side options
    And   user add "Mac" to the wishList

  @tc4
  Scenario: wishList TC4
    Given user search for "iMac"
    When user scroll down and click to the "iMac"
    And user add "iMac" to the wishList
    And success notification with "wish list!" should be visible

  @tc5
  Scenario: wishList TC5
    Given user search for "MacBook"
    When user scroll down and click to the "MacBook"
    And user add product to the wishList from product page
    And user click on the "Wish List" header option

