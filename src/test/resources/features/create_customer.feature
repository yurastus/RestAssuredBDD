Feature: create new user

  @Smoke
  Scenario Outline: fill in all fields and create new user
    Given admin 'admin' is logged in
    And new user with name '<name>', username '<username>'
    And contacts: phone '<phone>', website '<website>', email '<email>'
    And company: name '<companyName>', catch phrase '<catchPhrase>', bs '<bs>'
    And address: street '<street>', suite '<suite>', city '<city>', zipcode '<zipcode>', lat '<lat>', lng '<lng>'
    When admin created new user
    Then response status should be '200'
    And new user should have name '<name>', username '<username>'
    And should have contacts: phone '<phone>', website '<website>', email '<email>'
    And should have company: name '<companyName>', catch phrase '<catchPhrase>', bs '<bs>'
    And should have address: street '<street>', suite '<suite>', city '<city>', zipcode '<zipcode>', lat '<lat>', lng '<lng>'
    Examples:
    |name|username|phone|website|email|companyName|catchPhrase|bs|street|suite|city|zipcode|lat|lng|
    |a ve |a.ve|78945648|website|email|epam|hello world anyway|tar|Red str|123|Lviv|123456|1234|1234|
    |o la |o.la|78945648|website|email|epam|hello world anyway|tar|Red str|123|Lviv|123456|1234|1234|