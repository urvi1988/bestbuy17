package com.bestbuywk16.categoriesinfo;

import com.bestbuywk16.testbase.TestBase;
import com.bestbuywk16.utils.TestUtils;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.hamcrest.Matchers.hasValue;

@RunWith(SerenityRunner.class)
public class CategoriesCRUDTestwithSteps extends TestBase {
    static String name = "jessy" + TestUtils.getRandomValue();
    static String id = "jess1234" + TestUtils.getRandomValue();
    static String categoriesId;
    @Steps
    CategoriesSteps categoriesSteps;

    @Title("This will create a new category")
    @Test
    public void test001() {
        ValidatableResponse response = categoriesSteps.createCategories(name, id);
        response.statusCode(201);
    }

    @Title("verify if category is created")
    @Test
    public void test002() {
        HashMap<String, Object> categoriesMapData = categoriesSteps.getCategoriesInfoByname(name);
        Assert.assertThat(categoriesMapData, hasValue(name));
        categoriesId = (String) categoriesMapData.get("id");
        System.out.println(categoriesId);
    }

    @Title("update the user information")
    @Test
    public void test003() {
        name = name + "simba";

        categoriesSteps.updateCategories(name, id);
        HashMap<String, Object> categoriesMapData = categoriesSteps.getCategoriesInfoByname(name);
        Assert.assertThat(categoriesMapData, hasValue(name));
    }

    @Title("Delete student info by StudentID and verify its deleted")
    @Test
    public void test004() {

        categoriesSteps.deleteCategoriesInfoByID(categoriesId).statusCode(200);
        categoriesSteps.getcategoriesInfoByCategoriesId(categoriesId).statusCode(404);

    }
}

