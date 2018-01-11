Feature: search specific users

  @Smoke
  Scenario: search all users
    Given admin 'admin' is logged in
    When admin searches for all users
    Then response status should be '200'
    And total users amount should be '10'

  @Smoke
  Scenario Outline: search existing users by id
    Given admin 'admin' is logged in
    When admin searches for user with id '<id>'
    Then response status should be '<status>'
    And found user should have id '<idInResponse>'
    Examples:
      |id  |idInResponse |status |
      |1   |1            |200    |
      |10  |10           |200    |

  @Regression
  Scenario Outline: search non existing customer by id
    Given admin 'admin' is logged in
    When admin searches for user with id '<id>'
    Then response status should be '<status>'
    Examples:
      |id  |status |
      |0   |404    |
      |11  |404    |