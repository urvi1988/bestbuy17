package com.bestbuywk16.productinfo;

import com.bestbuywk16.constants.CategoriesEndPoint;
import com.bestbuywk16.constants.ProductEndPoint;
import com.bestbuywk16.constants.StoreEndPoint;
import com.bestbuywk16.model.CategoriesPojo;
import com.bestbuywk16.model.ProductPojo;
import com.bestbuywk16.testbase.TestBase;
import com.bestbuywk16.utils.TestUtils;
import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Title;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

import static org.hamcrest.Matchers.hasValue;

public class ProductCRUDTest extends TestBase {
  /* static String name = "apple"+ TestUtils.getRandomValue();
    static String type="solar"+ TestUtils.getRandomValue();
    static String manufacture= "amazon" + TestUtils.getRandomValue();

    static Object productsId;

    @Title("This will create products")
    @Test
    public void test01() {

        ProductPojo productpojo= new ProductPojo();

        productpojo.setName(name);
        productpojo.setType("Automatic");
        productpojo.setManufacturer("amazon");
        productpojo.setImage("ab2001");
        productpojo.setModel("A1");
        //productpojo.setShipping(100);
        productpojo.setUrl("xyz88");
        productpojo.setDescription("Strong");
       // productpojo.setPrice(10);
        productpojo.setUpc("2011");

        SerenityRest.given()
                .log().all()
                .contentType(ContentType.JSON)
                .body(productpojo)
                .when()
                .post(ProductEndPoint.CREATE_NEW_PRODUCTS)
                .then().log().all().statusCode(201);
    }
    @Title("verify if the products created")
    @Test
    public void test02() {
        String part1 = "data.findAll{it.name='";
        String part2 = "'}.get(0)";

        HashMap<String, ?> productsMapData = SerenityRest.given()
                .log().all()
                .when()
                .get (ProductEndPoint.GET_ALL_PRODUCTS)
                .then().statusCode(200).extract().path(part1 + name + part2);
        Assert.assertThat(productsMapData, hasValue(name));
        productsId = productsMapData.get("id");
        System.out.println(productsId);
    }

    @Title("verify product is updated")
    @Test
    public void test03(){
         name = name + "Testing";
            //   id = id + "00S";
            ProductPojo pojo = new ProductPojo();
            pojo.setName(name);

            SerenityRest.given()
                    .log().all()
                    .contentType(ContentType.JSON)
                    .pathParam("productsID",productsId)
                    .body(pojo)
                    .when()
                    .patch(ProductEndPoint.UPDATE_PRODUCT_BY_ID)
                    .then().statusCode(200);

            String part1 ="data.findAll{it.name='";
            String part2 ="'}.get(0)";

        HashMap<String,?> ProductsMapData = SerenityRest.given()
                .when()
                .get(ProductEndPoint.GET_ALL_PRODUCTS)
                .then().statusCode(200).extract().path(part1 +name +part2);
        Assert.assertThat(ProductsMapData,hasValue(name));
    }
    @Title("Delete the products and verify if is deleted")
    @Test
    public void test04() {

        SerenityRest.given()
                .pathParam("productsID",productsId)
                .when()
                .delete(ProductEndPoint.DELETE_PRODUCT_BY_ID)
                .then().log().all().statusCode(200);

        SerenityRest.given()
                .contentType(ContentType.JSON)
                .pathParam("productsID",productsId)
                .when()
                .get(ProductEndPoint.GET_SINGLE_PRODUCT_BY_ID)
                .then().log().all().statusCode(404);
    }

    }

   */
}





