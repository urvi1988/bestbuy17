Feature: Testing different request on Best Buy stores.

  Scenario: check if the store list can be accessed by users
  When User send get request to list endpoints
  Then User should get the status code of 200

  Scenario: Create new stores and verify is been added
    When I create a new store with new "<name>" "<type>" "<address>" "<address2>" "<city>" "<state>" "<zip>" "<hours>"
    Then I verify that stores with name is created

    Scenario: Check if the name of store has been updated and verify updated information
     When I update store with new "<name>"

      Scenario: Check if the store has been deleted by id and verify deleted information
        When I delete store by id
        Then I verify that store has been deleted
