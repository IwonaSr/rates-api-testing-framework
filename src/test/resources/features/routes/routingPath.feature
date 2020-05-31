Feature: Checking other routes

  Scenario: Check if route /api return Bad request error
    Given Request with resource path ""
    And Request "GET" is sent
    When Response status is 400
    Then Field "error" is "time data 'api' does not match format '%Y-%m-%d'"

  Scenario: Check if route /latest/incorrectPath" return 404 Not found error
    Given Request with resource path "latest/incorrectPath"
    When Request "GET" is sent
    Then Response status is 404
    #And The error is