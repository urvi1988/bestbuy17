package com.bestbuywk16.cucumber.steps;

import com.bestbuywk16.categoriesinfo.CategoriesSteps;
import com.bestbuywk16.productinfo.ProductsSteps;
import com.bestbuywk16.utils.TestUtils;
import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.ValidatableResponse;
import jdk.internal.org.objectweb.asm.util.ASMifiable;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;

import java.util.HashMap;

import static org.hamcrest.Matchers.hasValue;

public class MyStepdefsProduct {
    static ValidatableResponse response;
    static String Name = null;
    static int productsId;
   /* @Steps
    ProductsSteps productsSteps;
    @When("^User get request to list endpints$")
    public void userGetRequestToListEndpints() {
        response=productsSteps.getAllProductInfo();
    }
    @Then("^User should get the status code (\\d+)$")
    public void userShouldGetTheStatusCode(int statuscode) {
        response.statusCode(statuscode);
    }
    @When("^I create a new product by providing information \"([^\"]*)\" \"([^\"]*)\"\"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
    public void iCreateANewProductByProvidingInformation(String _name, String type, String model, String description, String url, String image, String manufracturer, String UPC ) {
        Name = TestUtils.getRandomValue()+_name;
        response=productsSteps.createProducts(Name,type,manufracturer,model,UPC,image,description,url);
    }
    @Then("^I verify that the product name is created$")
    public void iVerifyThatTheProductNameIsCreated() {
        response.statusCode(201);
        HashMap<String,Object>productMap=productsSteps.getProductsInfoByname(Name);
        Assert.assertThat(productMap,hasValue(Name));
    }
    @When("^New product is updated with new \"([^\"]*)\"$")
    public void newProductIsUpdatedWithNew(String _name){
        Name=TestUtils.getRandomValue()+_name;
        response=productsSteps.updateProducts(productsId, Name);
    }
    @When("^I have deleted product by id$")
    public void iHaveDeletedProductById() {
        response=productsSteps.deleteProductsInfoByID(productsId);
    }
    @Then("^I verify that product is deleted$")
    public void iVerifyThatProductIsDeleted() {
        response=productsSteps.getsproductsInfoByProductId(productsId);
    }
}

    */
}




