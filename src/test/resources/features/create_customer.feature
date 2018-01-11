Feature: create new user

  @Smoke
  Scenario Outline: fill in all fields and create new user
    Given admin 'admin' is logged in
    And new user with name '<name>', username '<username>'
    And contacts: phone '<phone>', website '<website>', email '<email>'
    And company: name '<companyName>', catch phrase '<catchPhrase>', bs '<bs>'
    And address: street '<street>', suite '<suite>', city '<city>', zipcode '<zipcode>', lat '<lat>', lng '<lng>'
    When admin tries to create new user
    Then response status should be '<responseCode>'
    And if created new user should have all expected data
    Examples:
    |name|username|phone|website|email|companyName|catchPhrase|bs|street|suite|city|zipcode|lat|lng|responseCode|
    |a ve |a.ve|78945648|website|email|epam|hello world anyway|tar|Red str|123|Lviv|123456|1234|1234|       201 |
    |o la |o.la|78945648|website|email|epam|hello world anyway|tar|Red str|123|Lviv|123456|1234|1234|       201 |
    #|     |o.la|78945648|website|email|epam|hello world anyway|tar|Red str|123|Lviv|123456|    |    |       404 |