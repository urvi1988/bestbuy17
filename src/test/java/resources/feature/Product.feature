#Feature: Testing different request on BestBuy Products

  #Scenario: check if the product list is accessed by users
    #When User get request to list endpints
    #Then User should get the status code 200


   # Scenario: creating new product and verify it is added
     # When I create a new product by providing information "<name>" "<type>""<model>" "<description>" "<url>" "<image>" "<manufacture>" "<UPC>"
    # Then I verify that the product name is created

      #Scenario: check if the name of new product is updated and verify the information
      #  When New product is updated with new "<name>"

      #  Scenario: check if the product has been deleted by id and verify if deleted
      # When I have deleted product by id
        #Then I verify that product is deleted