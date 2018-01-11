Feature: create new user

  @Smoke
  Scenario Outline: fill in all fields and create new user
    Given admin 'admin' is logged in
    And user with name '<name>', username '<username>'
    And contacts: phone '<phone>', website '<website>', email '<email>'
    And company: name '<companyName>', catch phrase '<phrase>', bs '<bs>'
    And address: street '<street>', suite '<suite>', city '<city>', zipcode '<zipcode>', lat '<lat>', lng '<lng>'
    When admin tries to create new user
    Then response status should be '<status>'
    And if created, new user should have all expected data
    Examples:
      |name  |username|phone        |website|email |companyName|phrase|bs    |street|suite        |city  |zipcode      |lat          |lng          |status|
      |STRING|STRING  |INT_AS_STRING|STRING |STRING|STRING     |STRING|STRING|STRING|INT_AS_STRING|STRING|INT_AS_STRING|INT_AS_STRING|INT_AS_STRING|201   |