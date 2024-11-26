# Language: en
# Author: Team Calidad Pagos B

Feature: Make payment with debit or credit card

  Scenario: User completes the transaction using a credit card or debit card
    Given The user is on the payment page
    When The user selects the option to pay with a credit card or debit card
    And The user provides the card details (card number, expiration date, CVV)
    Then The user sees a payment confirmation message
    And The user push the button to navegate to the next page

  Scenario: User enters invalid card information
    Given The user is on the payment page
    When The user selects the option to pay with a credit card or debit card
    And The user provides invalid card information (invalid card number, expired expiration date, incorrect CVV)
    Then The user sees an error message indicating that the provided information is invalid
