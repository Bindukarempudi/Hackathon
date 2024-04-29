Feature: Getting Error Message By providing Invalid E-mail ID

  Scenario: Capture error message
    Given user is in business page
    When user scroll down to form
    And user fill the form and submit it
    Then get error message
    And store the error message in excel sheet
