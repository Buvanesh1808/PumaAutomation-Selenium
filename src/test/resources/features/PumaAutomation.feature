Feature: Automating the Puma Application

  Scenario Outline: Login the Puma Application
    Given I login the Puma application
    And I wait for Account page to be visible
    Then I navigate to Running Shoe section
    And I filter the shoe size as "<Shoe_Size>"
    And I Filter the Shoe Colour as below
      | Blue  |
      | White |
      | Black |
      | Brown |
      | Green |
      | Red   |
    Then I select the Shoe as "<Shoe_Name>"
    Then I Click on "AddToCart" Button
    And I verify shoe name is displayed as "Twitch Runner Unisex Running Shoes"
    And I click on Proceed the Checkout
    Then I Fill the Shipping Address details as below
      | FirstName   | Buvanesh              |
      | LastName    | S                     |
      | PinCode     | 642134                |
      | Street      | 777, Dhoni Street     |
      | Address 2   | Ram Nagar             |
      | City        | Pollachi              |
      | Email       | Testingpuma@gmail.com |
      | PhoneNumber | +918632546985         |
    Then I fill the CreditCard details for Payment
    And I cancel the Product
    And I Verify the Cart is Empty Message displayed as "Your Shopping Cart is Empty"
    Then I Logout the Puma application

    Examples:
      | Shoe_Size | Shoe_Name                          |
      | 11        | Twitch Runner Unisex Running Shoes |



