Feature: Automating the Puma Application

  Scenario Outline: Login the Puma Application
    Given I login the Puma application
    Then I navigate to Running Shoe section
    And I Filter the Shoe Size as "<Shoe_Size>"
    And I Filter the Shoe Colour as "<Shoe_Colour>"
    Then I select the Shoe as "<Shoe_Name>"
    Then I Click on "AddToCart" Button
    And I verify shoe name is displayed as "Twitch Runner Unisex Running Shoes"
    And I Verify the Shoe and Proceed the Checkout
    Then I fill the CreditCard details for Payment
#    And I cancel the Product
#    Then I Logout the Puma application

    Examples:
      | Shoe_Size | Shoe_Colour | Shoe_Name                          |
      | 11        | blue        | Twitch Runner Unisex Running Shoes |



