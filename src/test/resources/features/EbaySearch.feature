Feature: Ebay search functionality
  Scenario: search for iMac 2020
    Given user is on ebay homepage
    When user searches for imac 2020
    Then  user sees results about imac only
    And there are more than 3 pages of results