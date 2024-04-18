Feature: Languages and levels in language learning
  @smoke 
  Scenario: Finding total languages and levels in language learning
    Given User open the application
    When user click on explore dropdown
    And select the language learning subject
    And select All language courses under Popular skills section
    Then it should load a new page with all courses
    When user click on show more option under language section
    Then all languages will be displayed,collect all languages
    And store all languages in excel sheet
    When user click on close button
    And collect all levels under level section
    And store all levels in excel sheet
