Feature:  Specific date Foreign Exchange rates - To get past conversion rates

  Scenario: Get the latest foreign exchange reference rates for specific fate with one symbol and one base
    Given Request with resource path "/2020-05-29"
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
    And Field "date" is "2020-05-29"
