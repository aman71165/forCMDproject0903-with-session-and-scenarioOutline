Feature: To add multiple rewards using scenarioOutline functionality

  Scenario: User gets logged into frontEnd app
    Given User is on frontEnd login page
    When user enters correct credentials
    Then user lands on homepage

  Scenario: User gets logged into adminPanel app
    When clicks on AdminPanel link
    Then user lands on AdminPanel page

  Scenario: User navigates Recognitions page
    When User clicks on Recognitions tile
    And clicks on EnableEdit link
    Then recognition page gets enabled to proceed further

  Scenario Outline: User is ready to add multiple rewards using ScenarioOutline
    When User Clicks on NewRecognition button to add a new reward
    And Enters "<rewardName>" and "<rewardsPoints>" to add different rewards
    Then user navigates to grid page

    Examples: 
      | rewardName         | rewardsPoints |
      | 1qwerty 123 reward |             2 |
      | 2mnp reward        |             5 |
      | 3QWERTY reward     |             4 |
      | 4xyz reward        |             3 |
      | 5final reward      |             8 |

  Scenario: User navigates Recognitions page
    When User clicks on Logout link
    And clicks on Yes button
    Then user gets logged out successfully
