@tag
  Feature: Purchase the order from Ecommerce Website
    I want to use this template gor my feature file
  Background:
    Given I landed on Ecomerce Page

    @tag2
    Scenario Outline: Positive Test of Submitting the Order

      Given Logged in with username <name> and password <password>
      When I add product to cart
      When Checkout  and submit the orders
      Then "THANKYOU FOR THE ORDER." massage is displayed on ConfirmationPage

      Examples:
        | name              | password    | productName |  |
        | anshika@gmail.com | Iamking@000 | ZARA COAT 3 |  |