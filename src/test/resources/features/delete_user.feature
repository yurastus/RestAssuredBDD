Feature: delete specific users

  @Smoke
  Scenario Outline: delete existing users by id
    Given admin 'admin' is logged in
    When admin deletes user with id '<id>'
    Then response status should be '<status>'

    Examples:
      |id  |status |
      |1   |200    |
      |10  |200    |

      |0   |404    |
      |11  |404    |