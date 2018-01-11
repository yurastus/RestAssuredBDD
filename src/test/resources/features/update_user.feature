Feature: update existing user

  @Smoke
  Scenario Outline: fill in all fields and update user
    Given admin 'admin' is logged in
    And user with name '<name>', username '<username>'
    And contacts: phone '<phone>', website '<website>', email '<email>'
    And company: name '<companyName>', catch phrase '<phrase>', bs '<bs>'
    And address: street '<street>', suite '<suite>', city '<city>', zipcode '<zipcode>', lat '<lat>', lng '<lng>'
    When admin tries to update user with id '<id>'
    Then response status should be '<status>'
    And if updated, user should have all expected data

    Examples:
      |id|name  |username|phone        |website|email |companyName|phrase|bs    |street|suite        |city  |zipcode      |lat          |lng          |status|
      |1 |STRING|STRING  |INT_AS_STRING|STRING |STRING|STRING     |STRING|STRING|STRING|INT_AS_STRING|STRING|INT_AS_STRING|INT_AS_STRING|INT_AS_STRING|200   |

      |0 |STRING|STRING  |INT_AS_STRING|STRING |STRING|STRING     |STRING|STRING|STRING|INT_AS_STRING|STRING|INT_AS_STRING|INT_AS_STRING|INT_AS_STRING|404   |
      |11|STRING|STRING  |INT_AS_STRING|STRING |STRING|STRING     |STRING|STRING|STRING|INT_AS_STRING|STRING|INT_AS_STRING|INT_AS_STRING|INT_AS_STRING|404   |