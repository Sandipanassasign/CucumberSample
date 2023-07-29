Feature: Search product and place product
  I want to use this template for my feature file

  @SearchProduct
  Scenario Outline: Search functionality checking on Home page and Deals page
  Given user is on the Greenkart homepage
  When user searched for name <prodshrtName> in the searchbar and extract actual product name 
  Then user searched for the same name <prodshrtName> in deals page
  And  validate product name in Homepage and Deals page are same
  
  Examples:
	|prodshrtName|
	|Tom |
	|Beet|
		
    