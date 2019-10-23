Feature: as a user i want to use Login functionality
  @Login
  Scenario Outline: User should login successfully with valid credential
    When user put valid credential "<UserName>" and "<Password>"
    And click submit button
    Then user should able to register successfully
    Examples:
      |UserName  |Password|
    | Admin         | admin123       |
    | amin          | amin123        |
    | Admin         | amin123        |
