Feature: search specific customer

  @Smoke
  Scenario: search all customers
    Given admin 'admin' is logged in
    When admin searches for all users
    Then response status should be '200'
    And total users amount should be '10'

  @Regression
  Scenario Outline: search existing customer by id
    Given admin 'admin' is logged in
    When admin searches for user with id '<id>'
    Then response status should be '<statusCode>'
    And found user should have id '<idInResponse>'
    Examples:
      | id  | statusCode | idInResponse |
      | 1   | 200        | 1            |
      | 10  | 200        | 10          |

  @Regression
  Scenario Outline: search non existing customer by id
    Given admin 'admin' is logged in
    When admin searches for user with id '<id>'
    Then response status should be '<statusCode>'
    Examples:
      | id  | statusCode |
      | 0   | 404        |
      | 11  | 404        |