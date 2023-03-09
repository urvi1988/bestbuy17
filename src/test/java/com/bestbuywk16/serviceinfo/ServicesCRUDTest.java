package com.bestbuywk16.serviceinfo;


import com.bestbuywk16.constants.ServiceEndPoint;
import com.bestbuywk16.model.CategoriesPojo;
import com.bestbuywk16.model.ServicePojo;
import com.bestbuywk16.testbase.TestBase;
import com.bestbuywk16.utils.TestUtils;
import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Title;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

import static org.hamcrest.Matchers.hasValue;

public class ServicesCRUDTest extends TestBase {
    static String name = "james" + TestUtils.getRandomValue();
    //static String id = "jm12" + TestUtils.getRandomValue();
    static Object servicesId;

    @Title("This will create services")
    @Test
    public void test01() {

        ServicePojo servicePojo = new ServicePojo();
        servicePojo.setName(name);

        SerenityRest.given()
                .log().all()
                .contentType(ContentType.JSON)
                .body(servicePojo)
                .when()
                .post(ServiceEndPoint.CREATE_NEW_SERVICES)
                .then().log().all().statusCode(201);
    }

    @Title("verify if that services created")
    @Test
    public void test02() {
        String part1 = "data.findAll{it.name='";
        String part2 = "'}.get(0)";

        HashMap<String, ?> servicesMapData = SerenityRest.given()
                .log().all()
                .when()
                .get(ServiceEndPoint.GET_ALL_SERVICES)
                .then().statusCode(200).extract().path(part1 + name + part2);
        Assert.assertThat(servicesMapData, hasValue(name));
        servicesId = servicesMapData.get("id");
        System.out.println(servicesMapData);
    }

    @Title("verify the services name is updated")
    @Test
    public void test03() {
        name = name + "Star";

        ServicePojo pojo = new ServicePojo();
        pojo.setName(name);

        SerenityRest.given()
                .log().all()
                .contentType(ContentType.JSON)
                .pathParam("servicesID", servicesId)
                .body(pojo)
                .when()
                .patch(ServiceEndPoint.UPDATE_SERVICES_BY_ID)
                .then().statusCode(200);

        String part1 = "data.findAll{it.name='";
        String part2 = "'}.get(0)";
        HashMap<String, Object> servicesMapData = SerenityRest.given()
                .when()
                .get(ServiceEndPoint.GET_ALL_SERVICES)
                .then().statusCode(200).extract().path(part1 + name + part2); //findAll{it.firstName=='akshit69136'}.get(0)
        Assert.assertThat(servicesMapData, hasValue(name));
    }
    @Title("Delete the services and verify if is deleted")
    @Test
    public void test04() {

        SerenityRest.given()
                .pathParam("servicesID",servicesId)
                .when()
                .delete(ServiceEndPoint.DELETE_SERVICES_BY_ID)
                .then().log().all().statusCode(200);

        SerenityRest.given()
                .contentType(ContentType.JSON)
                .pathParam("servicesID",servicesId)
                .when()
                .get(ServiceEndPoint.GET_SINGLE_SERVICES_BY_ID)
                .then().log().all().statusCode(404);
    }
}

