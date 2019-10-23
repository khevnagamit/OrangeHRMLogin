@Login
Feature: as a user i want to use Login functionality

  Scenario Outline: User should login successfully with valid credential
    When user put valid credential "<UserName>" and "<Password>"
    And click submit button
    Then user should able to register successfully
    Examples:
      |UserName  |Password |
      | Admin    | admin123|


    Scenario Outline: User should not login with in valid credential
      When user put in valid credential "<InvalidUserName>" and "<InvalidPassword>"
      And click submit button
      Then user should not able to login and should see error message
      Examples:
      |InvalidUserName|InvalidPassword|
      | amin          | amin123        |
      | Admin         | amin123        |


