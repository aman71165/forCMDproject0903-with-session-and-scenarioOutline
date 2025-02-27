Feature: test AdminPanel page

  Scenario: Validate admin panel page using miscellaneous funtions
    Given user is on the login page
    When user enters the username "toshu@yopmail.com" and password "pass@1234"
    And user clicks on login button
    Then user clicks on AdminPanel link
