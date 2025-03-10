Feature: To add multiple rewards using scenarioOutline functionality

  Scenario: User gets logged into frontEnd app
    Given User is on frontEnd login page
    When user enters correct credentials
    And clicks on Login button
    Then user lands on homepage

  Scenario: User gets logged into adminPanel app
    Given User is on frontEnd homepage
    When user clicks on Profile Image
    And clicks on AdminPanel link
    Then user lands on AdminPanel page

  Scenario: User moves to the Recognitions page
    Given User is on AdminPanel page
    When clicks on Recognitions tile
    And clicks on EnableEdit link
    Then User should be on the Recognitions page

  Scenario Outline: User is ready to add multiple rewards
    Given User is Recognitions page
    When User Clicks on NewRecognition button to add a new reward
    And Enters "<rewardName>" and "<rewardsPoints>" to add different rewards
    Then user navigates on grid page

    Examples: 
      | rewardName        | rewardsPoints |
      | xyzReward         |             2 |
      | mnp reward        |             5 |
      | qwerty 123 reward |             3 |
      | 123 final reward  |             8 |
