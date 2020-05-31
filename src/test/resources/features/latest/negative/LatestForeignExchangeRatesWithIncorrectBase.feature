Feature: Latest Foreign Exchange Rates Negative cases- To get latest date data with incorrect base parameter

  Scenario: Get the latest foreign exchange reference rates with base parameter that does not exist
    Given Request with resource path "/latest"
    And Request path with following query parameters added
      | Parameter | Value            |
      | base      | NOT_EXISTS_PARAM |
    When Request "GET" is sent
    Then Response status is 400
    And Field "error" is "Base 'NOT_EXISTS_PARAM' is not supported."

  Scenario: Get the latest foreign exchange reference rates with 2 base parameters
    Given Request with resource path "/latest"
    And Request path with following query parameters added
      | Parameter | Value    |
      | base      | USD,GBP |
    When Request "GET" is sent
    Then Response status is 400
    And Field "error" is "Base 'USD,GBP' is not supported."

    

