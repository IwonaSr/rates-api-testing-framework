Feature: Latest Foreign Exchange Rates - To get latest date data with base parameter

  Scenario: Get the latest foreign exchange reference rates with specific base
    Given Request with resource path "/latest"
    And Request path with following query parameters added
      | Parameter | Value |
      | base      | EUR   |
    When Request "GET" is sent
    Then Response status is 200
    And Field "base" is "EUR"
    And All countries rates are returned (without Euro)
    And Rates "rates" have correct precision
    And Field date has last working UTC date

    

