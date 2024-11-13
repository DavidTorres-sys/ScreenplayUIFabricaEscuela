# Language: en
# Author: Team Calidad Pagos B

Feature: Detailed display of purchase costs
  As a user, I want to be able to see the detailed costs of my purchase,
  including taxes and additional fees, so I know exactly what I am paying.

  Scenario: Display the detailed costs of the purchase
    Given that the user is on the purchase summary page
    When the user displays the purchase details tab
    Then the system should display the detailed breakdown of the purchase, including taxes, fees and additional charges

  Scenario: Calculate the total amount
    Given that the system has displayed the breakdown of the purchase costs
    When the system adds up the value of each item on the invoice*
    Then the system should calculate the total amount of the purchase