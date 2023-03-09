package com.bestbuywk16.storesinfo;

import com.bestbuywk16.constants.ProductEndPoint;
import com.bestbuywk16.constants.StoreEndPoint;
import com.bestbuywk16.model.ProductPojo;
import com.bestbuywk16.model.StoresPojo;
import com.bestbuywk16.testbase.TestBase;
import com.bestbuywk16.utils.TestUtils;
import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Title;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

import static org.hamcrest.Matchers.hasValue;

public class StoreCRUDTest extends TestBase {
    static String name = "sun" + TestUtils.getRandomValue();
    static String type = "electrical" + TestUtils.getRandomValue();
    static String address = "12 lincon" + TestUtils.getRandomValue();

    static Object storesId;

    @Title("This will create new store")
    @Test
    public void test01() {

        StoresPojo storesPojo=new StoresPojo();

        storesPojo.setName(name);
        storesPojo.setAddress("10 dens");
        storesPojo.setAddress2("mays");
        storesPojo.setCity("london");
        storesPojo.setState("bucks");
        storesPojo.setType("retail");
        storesPojo.setZip("hp18");
       // storesPojo.setLat(2011);
       // storesPojo.setLng(2012);
        storesPojo.setHours("mon to fri");

        SerenityRest.given()
                .log().all()
                .contentType(ContentType.JSON)
                .body(storesPojo)
                .when()
                .post(StoreEndPoint.CREATE_NEW_STORES)
                .then().log().all().statusCode(201);
    }
    @Title("verify if the store is created")
    @Test
    public void test02() {
        String part1 ="data.findAll{it.name='";
        String part2 ="'}.get(0)";

        HashMap<String, ?> StoresMapData = SerenityRest.given()
                .log().all()
                .when()
                .get (StoreEndPoint.GET_ALL_STORES)
                .then().statusCode(200).extract().path(part1 + name + part2);
        Assert.assertThat(StoresMapData, hasValue(name));
         storesId= StoresMapData.get("id");
        System.out.println(storesId);
    }
    @Title("verify store is updated")
    @Test
    public void test03(){
        name = name + "Tester";
        //   id = id + "00S";
        StoresPojo pojo = new StoresPojo();
        pojo.setName(name);

        SerenityRest.given()
                .log().all()
                .contentType(ContentType.JSON)
                .pathParam("storesId",storesId)
                .body(pojo)
                .when()
                .patch(StoreEndPoint.UPDATE_STORES_BY_ID)
                .then().statusCode(200);

        String part1 ="data.findAll{it.name='";
        String part2 ="'}.get(0)";

        HashMap<String,?> StoresMapData = SerenityRest.given()
                .when()
                .get(StoreEndPoint.GET_ALL_STORES)
                .then().statusCode(200).extract().path(part1 +name +part2);
        Assert.assertThat(StoresMapData,hasValue(name));
    }
    @Title("Delete the store and verify if is deleted")
    @Test
    public void test04() {

        SerenityRest.given()
                .pathParam("storesID",storesId)
                .when()
                .delete(StoreEndPoint.DELETE_STORES_BY_ID)
                .then().log().all().statusCode(200);

        SerenityRest.given()
                .contentType(ContentType.JSON)
                .pathParam("storesID",storesId)
                .when()
                .get(StoreEndPoint.GET_SINGLE_STORES_BY_ID)
                .then().log().all().statusCode(404);
    }




}
