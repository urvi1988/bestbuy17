#Feature: Testing different request on Best Buy Services.

  #Scenario: check if the services list can be accessed by users
   #When user send get request to list endpoints
   # Then user should get the status code of 200

 # Scenario: Create new services and verify is been added
   # When I create a new  with new "<name>"
    #Then I verify that services with name is created

  #Scenario: Check if the name of services has been updated and verify updated information
   # When I update services with new "<name>"

 # Scenario: Check if the services has been deleted by id and verify deleted information
  #  When I delete services by id
   # Then I verify that services has been deleted
