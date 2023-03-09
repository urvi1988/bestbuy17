package com.bestbuywk16.categoriesinfo;

import com.bestbuywk16.constants.CategoriesEndPoint;
import com.bestbuywk16.model.CategoriesPojo;
import com.bestbuywk16.testbase.TestBase;
import com.bestbuywk16.utils.PropertyReader;
import com.bestbuywk16.utils.TestUtils;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Title;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;

import static org.hamcrest.Matchers.hasValue;

public class CaregoriesCRUDTest extends TestBase {
   // @BeforeClass
    //public static void inIt() {
    //propertyReader = PropertyReader.getInstance();
    //RestAssured.baseURI = propertyReader.getProperty("baseUrl");
    // RestAssured.port = Integer.parseInt(propertyReader.getProperty("port"));
   // RestAssured.basePath = "/categories";

    static String name = "jessy" + TestUtils.getRandomValue();
    static String id = "jess1234" + TestUtils.getRandomValue();
    static Object categoriesId;

    @Title("This will create categories")
    @Test
    public void test01() {

        CategoriesPojo categoriesPojo = new CategoriesPojo();
        categoriesPojo.setName(name);
        categoriesPojo.setId(id);

        SerenityRest.given()
                .log().all()
                .contentType(ContentType.JSON)
                .body(categoriesPojo)
                .when()
                .post(CategoriesEndPoint.CREATE_NEW_CATEGORIES)
                .then().log().all().statusCode(201);
    }
    @Title("verify if the categories created")
    @Test
    public void test02() {
        String part1 = "data.findAll{it.name='";
        String part2 = "'}.get(0)";

        HashMap<String, ?> categoriesMapData = SerenityRest.given()
                .log().all()
                .when()
                .get(CategoriesEndPoint.GET_ALL_CATEGORIES)
                .then().statusCode(200).extract().path(part1 + name + part2);
        Assert.assertThat(categoriesMapData, hasValue(name));
        categoriesId = categoriesMapData.get("id");
        System.out.println(categoriesId);
    }
    @Title("verify the name is updated")
    @Test
    public void test03() {
        name = name + "Dev";
     //   id = id + "00S";
        CategoriesPojo pojo = new CategoriesPojo();
        pojo.setName(name);
        pojo.setId(id);

        SerenityRest.given()
                .log().all()
                .contentType(ContentType.JSON)
                .pathParam("categoriesId",categoriesId)
                .body(pojo)
                .when()
                .patch(CategoriesEndPoint.UPDATE_SINGLE_CATEGORIES_BY_ID)
                .then().statusCode(200);

        String part1 ="data.findAll{it.name='";
        String part2 ="'}.get(0)";

       HashMap<String,Object> categoriesMapData = SerenityRest.given()
                .when()
                .get(CategoriesEndPoint.GET_ALL_CATEGORIES)
                .then().statusCode(200).extract().path(part1 + name + part2); //findAll{it.firstName=='akshit69136'}.get(0)
        Assert.assertThat(categoriesMapData, hasValue(name));
       // categoriesId = categoriesMapData.get("id");
       // System.out.println(categoriesId);
    }
    @Title("Delete the categories and verify if is deleted")
    @Test
    public void test04() {

        SerenityRest.given()
                .pathParam("categoriesID",categoriesId)
                .when()
                .delete(CategoriesEndPoint.DELETE_CATEGORIES_BY_ID)
                .then().log().all().statusCode(200);

        SerenityRest.given()
                .contentType(ContentType.JSON)
                .pathParam("categoriesID",categoriesId)
                .when()
                .get(CategoriesEndPoint.GET_SINGLE_CATEGORIES_BY_ID)
                .then().log().all().statusCode(404);
    }
}







