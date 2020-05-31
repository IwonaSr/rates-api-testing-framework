Feature:  Specific date Foreign Exchange rates - To get past conversion rates

  Scenario: Get the latest foreign exchange reference rates for specific date with symbol
    Given Request with resource path "/2020-05-29"
    And Request path with following query parameters added
      | Parameter | Value |
      | symbols   | USD   |
    When Request "GET" is sent
    Then Response status is 200
    And Field "base" is "EUR"
    And Rates "rates.USD" have correct precision
    And Field "date" is "2020-05-29"

