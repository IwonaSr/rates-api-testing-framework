Feature: Latest Foreign Exchange Rates - To get latest date data

  Scenario: Get the latest foreign exchange reference rates (default Euro)
    Given Request with resource path "/latest"
    When Request "GET" is sent
    Then Response status is 200
    And Field "base" is "EUR"
    And All countries rates are returned (without Euro)
    And Rates "rates" have correct precision
    And Field date has last working UTC date

