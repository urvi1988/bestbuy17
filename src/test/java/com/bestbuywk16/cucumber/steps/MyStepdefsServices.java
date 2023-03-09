package com.bestbuywk16.cucumber.steps;

import com.bestbuywk16.servicesinfo.ServicesSteps;
import com.bestbuywk16.utils.TestUtils;
import cucumber.api.PendingException;
import cucumber.api.java.cs.A;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.ValidatableResponse;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;

import java.util.HashMap;

import static org.hamcrest.Matchers.hasValue;

public class MyStepdefsServices {

  /* ValidatableResponse response;
    static String Name=null;
    static int servicesId;

    @Steps
    ServicesSteps servicesSteps;

    @When("^user send get request to list endpoints$")
    public void userSendGetRequestToListEndpoints() {
        response = servicesSteps.getAllServicesInfo();
    }

    @Then("^user should get the status code of (\\d+)$")
    public void userShouldGetTheStatusCodeOf(int statuscode) {
        response.statusCode(statuscode);
    }

    @When("^I create a new  with new \"([^\"]*)\"$")
    public void iCreateANewWithNew(String _name) {
        Name= TestUtils.getRandomValue()+ _name;
        response=servicesSteps.createServices(Name);
    }
    @Then("^I verify that services with name is created$")
    public void iVerifyThatServicesWithNameIsCreated() {
        response.statusCode(201);
        HashMap<String,Object>map=servicesSteps.getServicesInfoByname(Name);
        Assert.assertThat(map,hasValue(Name));
    }
    @When("^I update services with new \"([^\"]*)\"$")
    public void iUpdateServicesWithNew(String _name){
        Name=TestUtils.getRandomValue()+ _name;
        response=servicesSteps.updateServices(Name,servicesId);
    }
    @When("^I delete services by id$")
    public void iDeleteServicesById() {
        response=servicesSteps.deleteServicessInfoByID(servicesId);
    }
    @Then("^I verify that services has been deleted$")
    public void iVerifyThatServicesHasBeenDeleted() {
        response=servicesSteps.getserviceInfoByServicesId(servicesId);
    }
}
   */
}



