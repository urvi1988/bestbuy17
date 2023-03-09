package com.bestbuywk16.productinfo;

import com.bestbuywk16.constants.ProductEndPoint;
import com.bestbuywk16.model.ProductPojo;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import java.util.HashMap;

public class ProductsSteps {
    @Step("getting all information :{0}")
    public ValidatableResponse getAllProductInfo() {
        return SerenityRest.given()
                .when()
                .get(ProductEndPoint.GET_ALL_PRODUCTS)
                .then();
    }
     @Step("creating products with name:{0},type:{1},manufacturer:{2},image:{3},model:{4},url:{5},description:{6},upc:{7}")
     public ValidatableResponse createProducts(String name, String type, String manufacturer, String image, String model, String url, String description, String upc) {
         ProductPojo pojo = new ProductPojo();
         pojo.setName(name);
         pojo.setType(type);
         pojo.setManufacturer(manufacturer);
         pojo.setImage(image);
         pojo.setModel(model);
         pojo.setUrl(url);
         pojo.setDescription(description);
         pojo.setUpc(upc);

         return SerenityRest.given()
                 .log().all()
                 .contentType(ContentType.JSON)
                 .body(pojo)
                 .when()
                 .post(ProductEndPoint.CREATE_NEW_PRODUCTS)
                 .then().statusCode(201);
     }
    @Step("getting products info by name:{0}")
    public HashMap<String, Object> getProductsInfoByname(String name) {
        String part1 ="data.findAll{it.name='";
        String part2 ="'}.get(0)";

        return SerenityRest.given()
                .log().all()
                .when()
                .get(ProductEndPoint.GET_ALL_PRODUCTS)
                .then()
                .statusCode(200)
                .extract().path(part1 + name + part2);
    }
    @Step("update products info with productsId:{0}, name:{1}")
    public ValidatableResponse updateProducts(int productId, String name) {

        ProductPojo productPojo=new ProductPojo();
        productPojo.setName(name);

        return SerenityRest.given()
                .log().all()
                .contentType(ContentType.JSON)
                .pathParam("productsID", productId)
                .body(productPojo)
                .when()
                .patch(ProductEndPoint.UPDATE_PRODUCT_BY_ID)
                .then();
    }
    @Step("deleting products information with productsId:{0}")
    public ValidatableResponse deleteProductsInfoByID(int productId) {
        return SerenityRest.given()
                .pathParam("productsID", productId)
                .when()
                .delete(ProductEndPoint.DELETE_PRODUCT_BY_ID)
                .then();
    }
    @Step("getting products info By id:{0}")
    public ValidatableResponse getsproductsInfoByProductId(int productId) {
        return SerenityRest.given()
                .pathParam("productsID", productId)
                .when()
                .get(ProductEndPoint.GET_SINGLE_PRODUCT_BY_ID)
                .then();
    }

}
