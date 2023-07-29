Feature: Search a product and place the order
  I want to use this template for my feature file

  @Placeorder
  Scenario Outline: Product is searched and order is placed
    Given user is on the Greenkart homepage
    When user searched for name <prodshrtName> in the searchbar and extract actual product name 
    And  User add the Product count to three products and Add to Cart
 		Then User proceeds to checkout page and validate the ProductName
    And User validates the promocode and placeorderbutton and place the order
    And Validate the order is placed successfully

    Examples:
|prodshrtName|
|Cucu|