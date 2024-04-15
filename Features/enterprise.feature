Feature: Getting Error Message By providing Invalid E-mail ID

  Scenario: Capture error message
    Given user click on contact sales which is in business page
    When user fill the form and submit it
    Then get error message 
    And store the error message in excel sheet
