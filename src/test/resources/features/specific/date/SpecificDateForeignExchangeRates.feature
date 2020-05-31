Feature:  Specific date Foreign Exchange rates - To get past conversion rates

  Scenario: Get the latest foreign exchange reference rates for specific date (past date) with default base
    Given Request with resource path "2020-05-29"
    When Request "GET" is sent
    Then Response status is 200
    And Field "base" is "EUR"
    And Rates "rates" have correct precision
    And All countries rates are returned (without Euro)
    And Field "date" is "2020-05-29"

  Scenario: Get the latest foreign exchange reference rates for first available date (past date) with default base
    Given Request with resource path "1999-01-04"
    When Request "GET" is sent
    Then Response status is 200
    And Field "base" is "EUR"
    And Rates "rates" have correct precision
#    And All countries rates are returned (without Euro)
    And Field "date" is "1999-01-04"

  Scenario: Get the latest foreign exchange reference rates for specific date (future date) with default base
    Given Request with resource path "2099-12-12"
    When Request "GET" is sent
    Then Response status is 200
    And Field "base" is "EUR"
    And Rates "rates" have correct precision
    And All countries rates are returned (without Euro)
    And Field date has last working UTC date

