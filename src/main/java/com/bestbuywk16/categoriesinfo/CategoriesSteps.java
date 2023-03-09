package com.bestbuywk16.categoriesinfo;

import com.bestbuywk16.constants.CategoriesEndPoint;
import com.bestbuywk16.model.CategoriesPojo;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.eclipse.jetty.io.EndPoint;
import org.jruby.ext.ripper.Warnings;

import java.util.HashMap;
import java.util.List;

public class CategoriesSteps {
    @Step("getting all information :{0}")
    public ValidatableResponse getAllCategoriesInfo(){
        return   SerenityRest.given()
                .when()
                .get(CategoriesEndPoint.GET_ALL_CATEGORIES)
                .then();
    }
    @Step("creating categories with name:{0},id:{1}")
    public ValidatableResponse createCategories(String name, String id) {
        CategoriesPojo categoriesPojo = new CategoriesPojo();
        categoriesPojo.setName(name);
        categoriesPojo.setId(id);

        return SerenityRest.given()
                .log().all()
                .contentType(ContentType.JSON)
                .body(categoriesPojo)
                .when()
                .post(CategoriesEndPoint.CREATE_NEW_CATEGORIES)
                .then().statusCode(201);
    }
    @Step("getting categories info by name:{0},id:{1}")
    public HashMap<String, Object> getCategoriesInfoByname(String name) {
        String part1 ="data.findAll{it.name='";
        String part2 ="'}.get(0)";

        return SerenityRest.given()
                .log().all()
                .when()
                .get(CategoriesEndPoint.GET_ALL_CATEGORIES)
                .then()
                .statusCode(200)
                .extract().path(part1 + name + part2);
    }
    @Step("update categories info with name:{0}, id:{1}")
    public ValidatableResponse updateCategories(String categoriesId,String name) {

        CategoriesPojo categoriesPojo = new CategoriesPojo();
        categoriesPojo.setName(name);

        return SerenityRest.given()
                .log().all()
                .contentType(ContentType.JSON)
                .pathParam("categoriesID",categoriesId)
                .body(categoriesPojo)
                .when()
                .patch(CategoriesEndPoint.UPDATE_SINGLE_CATEGORIES_BY_ID)
                .then();
    }
    @Step("deleting categories information with id:{1}")
    public ValidatableResponse deleteCategoriesInfoByID(String categoriesId){
        return SerenityRest.given()
                .pathParam("categoriesID",categoriesId)
                .when()
                .delete(CategoriesEndPoint.DELETE_CATEGORIES_BY_ID)
                .then();
    }

    @Step("getting categories info By id:{1}")
    public ValidatableResponse getcategoriesInfoByCategoriesId(String categoriesId){
        return SerenityRest.given()
                .pathParam("categoriesID",categoriesId)
                .when()
                .get(CategoriesEndPoint.GET_SINGLE_CATEGORIES_BY_ID)
                .then();
    }


    }
