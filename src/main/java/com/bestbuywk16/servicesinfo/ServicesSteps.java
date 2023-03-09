package com.bestbuywk16.servicesinfo;

import com.bestbuywk16.constants.ServiceEndPoint;
import com.bestbuywk16.model.ServicePojo;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import java.util.HashMap;

public class ServicesSteps {
    @Step("getting all information :{0}")
    public ValidatableResponse getAllServicesInfo() {
        return SerenityRest.given()
                .when()
                .get(ServiceEndPoint.GET_ALL_SERVICES)
                .then();
    }
    @Step("creating services with name:{0}")
    public ValidatableResponse createServices(String name) {
        ServicePojo servicePojo= new ServicePojo();
        servicePojo.setName(name);

        return SerenityRest.given()
                .log().all()
                .contentType(ContentType.JSON)
                .body(servicePojo)
                .when()
                .post(ServiceEndPoint.CREATE_NEW_SERVICES)
                .then().statusCode(201);
    }
    @Step("getting services info by name:{0}")
    public HashMap<String, Object> getServicesInfoByname(String name) {
        String part1 ="data.findAll{it.name='";
        String part2 ="'}.get(0)";

        return SerenityRest.given()
                .log().all()
                .when()
                .get(ServiceEndPoint.GET_ALL_SERVICES)
                .then()
                .statusCode(200)
                .extract().path(part1 + name + part2);
    }
    @Step("update services info with servicesId:{0}, name:{1}")
    public ValidatableResponse updateServices(String name,int servicesId) {

        ServicePojo servicePojo= new ServicePojo();
        servicePojo.setName(name);

        return SerenityRest.given()
                .log().all()
                .contentType(ContentType.JSON)
                .pathParam("servicesID",servicesId)
                .body(servicePojo)
                .when()
                .patch(ServiceEndPoint.UPDATE_SERVICES_BY_ID)
                .then();
    }
    @Step("deleting categories information with servicesId:{0}")
    public ValidatableResponse deleteServicessInfoByID(int servicesId){
        return SerenityRest.given()
                .pathParam("servicesID",servicesId)
                .when()
                .delete(ServiceEndPoint.DELETE_SERVICES_BY_ID)
                .then();
    }

    @Step("getting services info By servicesId:{0}")
    public ValidatableResponse getserviceInfoByServicesId(int servicesId){
        return SerenityRest.given()
                .pathParam("servicesID",servicesId)
                .when()
                .get(ServiceEndPoint.GET_SINGLE_SERVICES_BY_ID)
                .then();
    }

}



