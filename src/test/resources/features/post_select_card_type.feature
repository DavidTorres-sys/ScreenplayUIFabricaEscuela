# Language: en
# Author: Team Calidad Pagos B

Feature: Payment with debit or credit card
  As a user, I want to be able to make the payment with a debit or credit card to complete the transaction.

  Scenario: Request debit or credit card data
    Given that the user selects to pay with debit or credit card
    When the system loads the payment form
    Then the system must request the card number, identification document, dynamic key or double authentication factor

  Scenario: Validate correct card number
    Given that the user has entered the card number
    When the card number has between 16 and 19 digits and corresponds to a valid bank
    Then the system must accept the card number
    And allow the user to continue with the transaction
    When the card number does not have between 16 and 19 digits or does not correspond to a valid bank
    Then the system must display an error message indicating the invalidity of the card number

  Scenario: Validate correct CVC
    Given that the user has entered the CVC of the card
    When the CVC has up to 4 digits
    Then the system must accept the CVC
    And allow the user to continue with the transaction
    When the CVC has more than 4 digits
    Then the system should display an error message indicating the invalidity of the CVC

  Scenario: Validate correct expiration date
    Given that the user has entered the expiration date of the card
    When the expiration date is in MM/YY format and is not earlier than the current date
    Then the system should accept the expiration date
    And allow the user to continue with the transaction
    When the expiration date is earlier than the current date or has an incorrect format
    Then the system should display an error message indicating the invalidity of the expiration date

  Scenario: Display error message in case of payment failure
    Given that the user has filled in all the card details
    When an error occurs during the payment simulation
    Then the system should display a detailed message of the error that occurred