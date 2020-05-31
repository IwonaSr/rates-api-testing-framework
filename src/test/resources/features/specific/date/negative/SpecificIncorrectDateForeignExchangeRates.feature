Feature:  Specific date Foreign Exchange rates - Past conversion rates for incorrect dates are not returned

  Scenario: The latest foreign exchange reference rates for first day of 1999 (incorrect past date) with default base are not returned
    Given Request with resource path "1999-01-01"
    When Request "GET" is sent
    Then Response status is 400
    And Field "error" is "There is no data for dates older then 1999-01-04."

  Scenario: The latest foreign exchange reference rates for last day of 1989 (incorrect past date) with default base are not returned
    Given Request with resource path "1989-12-31"
    When Request "GET" is sent
    Then Response status is 400
    And Field "error" is "There is no data for dates older then 1999-01-04."
