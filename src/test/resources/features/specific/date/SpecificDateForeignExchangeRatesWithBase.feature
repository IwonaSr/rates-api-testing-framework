Feature:  Specific date Foreign Exchange rates - To get past conversion rates

  Scenario: Get the latest foreign exchange reference rates for specific date with base Euro
    Given Request with resource path "2020-05-29"
    And Request path with following query parameters added
      | Parameter | Value |
      | base      | EUR   |
    When Request "GET" is sent
    Then Response status is 200
    And Field "base" is "EUR"
    And Rates "rates" have correct precision
    And All countries rates are returned (without Euro)
    And Field "date" is "2020-05-29"

