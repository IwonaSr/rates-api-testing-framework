Feature: Latest Foreign Exchange Rates - To get latest date data with base and symbol parameters

  Scenario: Get the latest foreign exchange reference rates with one symbol and one base parameter
    Given Request with resource path "/latest"
    And Request path with following query parameters added
      | Parameter | Value |
      | symbols   | USD   |
    And Request path with following query parameters added
      | Parameter | Value |
      | base      | EUR   |
    When Request "GET" is sent
    Then Response status is 200
    And Field "base" is "EUR"
    And Rates "rates.USD" have correct precision
    And Field date has last working UTC date