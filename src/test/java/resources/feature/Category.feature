#Feature: Testing different request on BestBuy Categories

#Scenario: check if the categories list can be accessed by users
 # When User send get request to list endpoints
  #Then User should get the status code of 200

  #Scenario Outline: Create new categories and verify if it is added
   # When I create a new category with name "<name>" id "<id>"
    #Then I verify that categories with name is created
    #Examples:
    #|name|id|
    #|luca|01Lu|
    #|lisa|02Li|

    #Scenario: Check if the category has been updated and verify
     # When I update category with name "<name>"

      #Scenario: Check if the category has been deleted by id
       # When I delete category by id
        #Then I verify that category has been deleted




