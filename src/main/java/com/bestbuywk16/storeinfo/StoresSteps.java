package com.bestbuywk16.storeinfo;

import com.bestbuywk16.constants.CategoriesEndPoint;
import com.bestbuywk16.constants.StoreEndPoint;
import com.bestbuywk16.model.CategoriesPojo;
import com.bestbuywk16.model.ServicePojo;
import com.bestbuywk16.model.StoresPojo;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import java.util.HashMap;

public class StoresSteps {
    @Step("getting all information :{0}")
    public ValidatableResponse getAllStoresInfo() {
        return SerenityRest.given()
                .when()
                .get(StoreEndPoint.GET_ALL_STORES)
                .then();
    }
    @Step("creating stores with name:{0},type:{1},address:{2},address2:{3},city:{4},state:{5},zip:{6},hours:{7}")
    public ValidatableResponse createStores(String name, String type, String address,String address2, String city, String state, String zip, String hours) {

        StoresPojo storesPojo = new StoresPojo();
        storesPojo.setName(name);
        storesPojo.setType(type);
        storesPojo.setAddress(address);
        storesPojo.setAddress2(address2);
        storesPojo.setCity(city);
        storesPojo.setState(state);
        storesPojo.setZip(zip);
        storesPojo.setHours(hours);

        return SerenityRest.given()
                .log().all()
                .contentType(ContentType.JSON)
                .body(storesPojo)
                .when()
                .post(StoreEndPoint.CREATE_NEW_STORES)
                .then().statusCode(201);
    }
    @Step("getting stores info by name:{0}")
    public HashMap<String, Object> getStoresInfoByname(String name) {
        String part1 ="data.findAll{it.name='";
        String part2 ="'}.get(0)";

        return SerenityRest.given()
                .log().all()
                .when()
                .get(StoreEndPoint.GET_ALL_STORES)
                .then()
                .statusCode(200)
                .extract().path(part1 + name + part2);
    }
    @Step("update stores info with storesId:{0}, name:{1}")
    public ValidatableResponse updateStores(int storesId, String name) {

        StoresPojo storesPojo = new StoresPojo();
        storesPojo.setName(name);

        return SerenityRest.given()
                .log().all()
                .contentType(ContentType.JSON)
                .pathParam("storesID", storesId)
                .body(storesPojo)
                .when()
                .patch(StoreEndPoint.UPDATE_STORES_BY_ID)
                .then();
               // .statusCode(200);
    }
    @Step("deleting stores information with storeId:{0}")
    public ValidatableResponse deleteStoreInfoByID(int storesId) {
        return SerenityRest.given()
                .pathParam("storesID", storesId)
                .when()
                .delete(StoreEndPoint.DELETE_STORES_BY_ID)
                .then();
    }
    @Step("getting stores info By id:{0}")
    public ValidatableResponse getstoresInfoByStoresId(int storesId) {
        return SerenityRest.given()
                .pathParam("storesID", storesId)
                .when()
                .get(StoreEndPoint.GET_SINGLE_STORES_BY_ID)
                .then();
    }


}

