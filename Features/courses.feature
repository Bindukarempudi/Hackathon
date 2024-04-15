Feature: Identify first two web development courses with English language and Beginner level filters

  Scenario: Search web development courses and apply filter options ( beginner, English)
    Given User opens the application with provided URL
    When User search for "web development" courses and clicks on search button
    And select the English Language filter option
    And select the Beginner level filter option
    And user click on the first course
    Then user should naviagate to new window for first course 
    And Collect the title,rating and duration of course in hours
    And add first course data to excel
    And After gathering the data,user should navigate back to parent window from child window
    When Now User click on the second course
    Then user should naviagate to new window for second course 
    And Collect the title,rating and duration of course in hours
    And add second course data to excel
    And After gathering the data,user should navigate back to parent window from child window
