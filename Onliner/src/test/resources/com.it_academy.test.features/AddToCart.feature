Feature: As a user
  I want to get ability to add product to cart
  So that I can

  Background:
    Given the user opens Onliner website

  Scenario Outline: Product should be added to cart
    When the user set "<productCategory>" in search menu
    And the user clicks on the "jbltune510bt" offer button
    And the user clicks on the AddToCart button
    And the user clicks on the Cart button
    Then product with title "Наушники JBL Tune 510BT" is displayed

    Examples:
      | productCategory |
      | Наушники        |
      | Телевизоры      |