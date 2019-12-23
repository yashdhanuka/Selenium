
Feature: Home page scenarios

  @stable
  Scenario: Best sellers
    Given we are on login page
    When we click the best sellers link
    And we choose the number one seller item
    Then we validate the best seller tag of the item

  @stable
  Scenario: Mobile Recharge tab
    Given we are on login page
    When we click the amazon pay link
    And go to mobile recharge 
    Then I verify the pay link