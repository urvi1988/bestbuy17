package com.bestbuywk16.cucumber.steps;

import com.bestbuywk16.productinfo.ProductsSteps;
import com.bestbuywk16.storeinfo.StoresSteps;
import com.bestbuywk16.utils.TestUtils;
import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.ValidatableResponse;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;

import java.util.HashMap;

import static org.hamcrest.Matchers.hasValue;

public class MyStepdefsStore {
    static ValidatableResponse response;
    static  String Name=null;
    static int  storesId;
    @Steps
    StoresSteps storesSteps;
    @When("^User send get request to list endpoints$")
    public void userSendGetRequestToListEndpoints() {
        response=storesSteps.getAllStoresInfo();
    }
    @Then("^User should get the status code of (\\d+)$")
    public void userShouldGetTheStatusCodeOf(int statuscode){
        response.statusCode(statuscode);
    }
    @When("^I create a new store with new \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
    public void iCreateANewStoreWithNew(String _name, String type, String address, String address2, String city, String state, String zip, String hours) {
        Name = TestUtils.getRandomValue() + _name;
        response = storesSteps.createStores(Name, type, address, address2, city, state, zip, hours);
    }
    @Then("^I verify that stores with name is created$")
    public void iVerifyThatStoresWithNameIsCreated() {
        response.statusCode(201);
        HashMap<String,Object>storeMap=storesSteps.getStoresInfoByname(Name);
        Assert.assertThat(storeMap,hasValue(Name));
    }
    @When("^I update store with new \"([^\"]*)\"$")
    public void iUpdateStoreWithNew(String _name){
        Name=TestUtils.getRandomValue() + _name;
        response = storesSteps.updateStores(storesId,Name);
    }
    @When("^I delete store by id$")
    public void iDeleteStoreById() {
        response = storesSteps.deleteStoreInfoByID(storesId);
    }
    @Then("^I verify that store has been deleted$")
    public void iVerifyThatStoreHasBeenDeleted() {
        response=storesSteps.getstoresInfoByStoresId(storesId);
    }

    }



