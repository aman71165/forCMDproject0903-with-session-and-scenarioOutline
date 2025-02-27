Feature: Test Reward Addition

  Scenario: To validate the reward addition functionality
    Given user is on Admin Panel app
    When user lands on Recognitions page and enable the toggle
    And clicks on New Recognition button
    And selects Rewards tile to proceed for addition process
    Then reward displayed on grid page after successful addition process
