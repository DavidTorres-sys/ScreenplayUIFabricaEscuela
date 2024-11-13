# Language: en
# Author: Team Calidad Pagos B

Feature: Payment gateway selection
  As a user, I want to be able to select my preferred payment gateway when making my purchase,
  to ensure that I use my preferred payment method.

  Scenario: Show list of available payment gateways
    Given that the user is on the payment page
    When the system loads the payment page
    Then the system should display a list of payment gateways including PSE, Bancolombia Button, Pay U, PayPal, Stripe, Wompi

  Scenario: Successful selection of a payment gateway
    Given that the user is on the payment page
    When the user selects a payment gateway
    Then the system should redirect or simulate the flow of the selected gateway

  Scenario: Try to proceed without selecting a payment gateway
    Given that the user is on the payment page
    When the user does not select any payment gateway and tries to proceed
    Then the system should display a message requesting the selection of a payment gateway
