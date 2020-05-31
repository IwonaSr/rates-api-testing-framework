Feature: Latest Foreign Exchange Rates - To get latest date data with symbol

  Scenario: Get the latest foreign exchange reference rates with symbol for one value
    Given Request with resource path "/latest"
    And Request path with following query parameters added
      | Parameter | Value   |
      | symbols   | USD |
    When Request "GET" is sent
    Then Response status is 200
    And Field "base" is "EUR"
    And Rates "rates.USD" have correct precision
    And Field date has last working UTC date

  Scenario: Get the latest foreign exchange reference rates with symbol for more than one value
    Given Request with resource path "/latest"
    And Request path with following query parameters added
      | Parameter | Value   |
      | symbols   | USD,GBP |
    When Request "GET" is sent
    Then Response status is 200
    And Field "base" is "EUR"
    And Rates "rates.USD" have correct precision
    And Rates "rates.GBP" have correct precision
    And Field date has last working UTC date

  Scenario: Get the latest foreign exchange reference rates with symbol for all available value (without EUR) against default
    Given Request with resource path "/latest"
    And Request path with following query parameters added
      | Parameter | Value   |
      | symbols   | USD,JPY,AUD,NZD,ZAR,PLN,CZK,RON,BGN,TRY,HUF,RUB,HRK,ISK,ILS,CAD,BRL,KRW,IDR,PHP,SGD,HKD,CNY,MYR,THB,INR,NOK,DKK,SEK,CHF,GBP,MXN |
    When Request "GET" is sent
    Then Response status is 200
    And Field "base" is "EUR"
    And All countries rates are returned (without Euro)
    And Rates "rates" have correct precision
    And Field date has last working UTC date

  Scenario: Get the latest foreign exchange reference rates with symbol for all available value (with EUR) against default
    Given Request with resource path "/latest"
    And Request path with following query parameters added
      | Parameter | Value   |
      | symbols   | USD,JPY,AUD,NZD,ZAR,PLN,CZK,RON,BGN,TRY,HUF,RUB,HRK,ISK,ILS,CAD,BRL,KRW,IDR,PHP,SGD,HKD,CNY,MYR,THB,INR,NOK,DKK,SEK,CHF,GBP,MXN |
    When Request "GET" is sent
    Then Response status is 200
    And Field "base" is "EUR"
#    And All countries rates are returned (with Euro)
    And Rates "rates" have correct precision
    And Field date has last working UTC date

