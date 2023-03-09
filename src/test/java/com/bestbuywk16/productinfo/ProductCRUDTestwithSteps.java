package com.bestbuywk16.productinfo;

import com.bestbuywk16.testbase.TestBase;
import com.bestbuywk16.utils.TestUtils;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.HashMap;

import static org.hamcrest.Matchers.hasValue;

@RunWith(SerenityRunner.class)
public class ProductCRUDTestwithSteps extends TestBase {

        static String name = "star" + TestUtils.getRandomValue();
        static String type = "jupitor1" + TestUtils.getRandomValue();
        static String upc = "4569H" + TestUtils.getRandomValue();
        static String description = "strong" + TestUtils.getRandomValue();
        static String manufacturer = "amazon" + TestUtils.getRandomValue();
        static String model = "wc1988" + TestUtils.getRandomValue();
        static String url = "http//www.star.com" + TestUtils.getRandomValue();
        static String image = "img/urv" + TestUtils.getRandomValue();
        static int productsId;
    @Steps
    ProductsSteps productsSteps;
    @Title("This will create a new products")
    @Test
    public void test01() {
        ValidatableResponse response = productsSteps.createProducts(name,type,upc,description,manufacturer,model,url,image);
        response.statusCode(201);
        //ValidatableResponse response = productsSteps.createProducts(name,type,upc,description,manufacturer,model,url,image);
        //response.statusCode(201);
    }
    @Title("verify if the product is created")
    @Test
    public void test02() {
        HashMap<String, Object> productsMapData = productsSteps.getProductsInfoByname(name);
        Assert.assertThat(productsMapData, hasValue(name));
        productsId = (int) productsMapData.get("id");
        System.out.println(productsId);
    }
    @Title("update the products information")
    @Test
    public void test03() {
        name = name + "Queen";
        productsSteps.updateProducts(productsId, name);
        HashMap<String, Object> productsmapdata = productsSteps.getProductsInfoByname(name);
        Assert.assertThat(productsmapdata, hasValue(name));
    }
    @Title("Delete store info by StoreId and verify its deleted")
    @Test
    public void test04() {
        productsSteps.deleteProductsInfoByID(productsId).statusCode(200);
        productsSteps.getsproductsInfoByProductId(productsId).statusCode(404);

    }

    }
