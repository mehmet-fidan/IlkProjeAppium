Feature: Calculator

  @Sum
  Scenario: Sum of two number in calculator
    Given user on start page
    When user sum the following numbers
    |8|
    |2|
    |3|

    Then the result should be 13