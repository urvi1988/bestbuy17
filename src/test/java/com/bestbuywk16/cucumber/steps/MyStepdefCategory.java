package com.bestbuywk16.cucumber.steps;

import com.bestbuywk16.categoriesinfo.CategoriesSteps;
import com.bestbuywk16.utils.TestUtils;
import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.ValidatableResponse;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;

import java.util.HashMap;

import static org.hamcrest.Matchers.hasValue;


public class MyStepdefCategory {
    /*static ValidatableResponse response;
    static  String Name=null;
    static String categoryId = null;
    @Steps
    CategoriesSteps categoriesSteps;
    @When("^User send get request to list endpoints$")
    public void userSendGetRequestToListEndpoints(){
        response=categoriesSteps.getAllCategoriesInfo();
    }

    @Then("^User should get the status code of (\\d+)$")
    public void userShouldGetTheStatusCodeOf(int statusCode) {
        response.statusCode(statusCode);
    }

    @When("^I create a new category with name \"([^\"]*)\" id \"([^\"]*)\"$")
    public void iCreateANewCategoryWithNameId(String _name, String _id) {
        Name = TestUtils.getRandomValue()+_name;
        categoryId = TestUtils.getRandomValue()+_id;
        response=categoriesSteps.createCategories(Name,categoryId);
    }
    @Then("^I verify that categories with name is created$")
    public void iVerifyThatCategoriesWithNameIsCreated() {
        response.statusCode(201);
        HashMap<String,Object>map=categoriesSteps.getCategoriesInfoByname(Name);
        Assert.assertThat(map,hasValue(Name));
    }
    @When("^I update category with name \"([^\"]*)\"$")
    public void iUpdateCategoryWithName(String _name){
        Name=TestUtils.getRandomValue()+_name;
        response=categoriesSteps.updateCategories(Name,categoryId);
    }
    @When("^I delete category by id$")
    public void iDeleteCategoryById() {
        response=categoriesSteps.deleteCategoriesInfoByID(categoryId);
    }
    @Then("^I verify that category has been deleted$")
    public void iVerifyThatCategoryHasBeenDeleted() {
        response=categoriesSteps.getcategoriesInfoByCategoriesId(categoryId);
    }
}
     */
}