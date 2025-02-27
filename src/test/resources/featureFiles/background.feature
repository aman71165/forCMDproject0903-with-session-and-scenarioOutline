@testBackground
Feature: Validate multiple functionality using background feature

  Background: 
    Given user gets logged in with correct credentials
    And user is on the homepage

  Scenario: 
    When user clicks on Recognize link
    Then user navaigates to the Recognize page

  Scenario: 
    When user clicks on MySummary link
    Then user navaigates to the MySummary page
