Feature: Latest Foreign Exchange Rates Negative cases - To get latest date data with incorrect symbol

  Scenario: Get the latest foreign exchange reference rates with symbol that does not exist
    Given Request with resource path "/latest"
    And Request path with following query parameters added
      | Parameter | Value            |
      | symbols   | NOT_EXISTS_PARAM |
    When Request "GET" is sent
    Then Response status is 400
#    And Field "error" is Symbols 'NOT_EXISTS_PARAM' are invalid for date" "last."

  Scenario: Get the latest foreign exchange reference rates with one correct symbol and one that does not exist
    Given Request with resource path "/latest"
    And Request path with following query parameters added
      | Parameter | Value                |
      | symbols   | USD,NOT_EXISTS_PARAM |
    When Request "GET" is sent
    Then Response status is 400
#    And Field "error" is Symbols 'USD,INCORRECT_VALUE' are invalid for date" "last."

#  Scenario: Get the latest foreign exchange reference rates with empty symbol
#    Given Request with resource path "/latest"
#    And Request path with following query parameters added
#      | Parameter | Value           |
#      | symbols   | EMPTY |
#    When Request "GET" is sent
#    Then Response status is 400
#    And All countries rates are returned (without Euro)
#    And Rates "rates" have correct precision

