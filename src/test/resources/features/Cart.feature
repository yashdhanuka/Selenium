Feature: Buying options

  @stable
  Scenario Outline: Search and put a product in cart
    Given we are on login page
	 # When we enter credentials
    When search for a product "<product>"
    And add the product to cart
    Then we should see that product in cart
  
     Examples: 
      | product  |
      | Samsung Galaxy A50s |



@stable
  Scenario Outline: Search and delete a product in cart
    Given we are on login page
	 # When we enter credentials
	 When search for a product "<product>"
    And add the product to cart
    And we go to to cart and delete the product "<product>"
    Then the product should be removed
  
     Examples: 
      | product  |
      | Samsung Galaxy A50s |

