
@tag
Feature: Purchase the order from Ecommerce website
  I want to use this template for my feature file
  
          Background:
          Given i landed on ecommerce page
       


 @tag2
  Scenario Outline: Title of your scenario outline
    Given Login with username <name> and password <password>
    When i added product <productname> to the cart
    And  checkout product <productname> and submit the order
    Then "THANKYOU FOR THE ORDER." message displayed on the confirmation page

    Examples: 
      | name             | password      | productname    |
      | hemaraj@gmail.com|     Uber12345 | ADIDAS ORIGINAL|
    
