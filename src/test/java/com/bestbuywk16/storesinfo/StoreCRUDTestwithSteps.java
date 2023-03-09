package com.bestbuywk16.storesinfo;

import com.bestbuywk16.categoriesinfo.CategoriesSteps;
import com.bestbuywk16.storeinfo.StoresSteps;
import com.bestbuywk16.testbase.TestBase;
import com.bestbuywk16.utils.TestUtils;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.hamcrest.Matchers.hasValue;
@RunWith(SerenityRunner.class)
public class StoreCRUDTestwithSteps extends TestBase {
    static String name = "jessy" + TestUtils.getRandomValue();
    static String type = "jess1234" + TestUtils.getRandomValue();
    static String address = "45 stores" + TestUtils.getRandomValue();
    static String address2 = "main road" + TestUtils.getRandomValue();
    static String city = "london" + TestUtils.getRandomValue();
    static String state = "BUCKS" + TestUtils.getRandomValue();
    static String zip = "hello12" + TestUtils.getRandomValue();
    static String hours = "mon to fri" + TestUtils.getRandomValue();
    static int storesId;

    @Steps
    StoresSteps storesSteps;

    @Title("This will create a new stores")
    @Test
    public void test01() {
        ValidatableResponse response = storesSteps.createStores(name, type, address, address2, city, state, zip, hours);
        response.statusCode(201);
    }

    @Title("verify if the store is created")
    @Test
    public void test02() {
        HashMap<String, Object> storesMapData = storesSteps.getStoresInfoByname(name);
        Assert.assertThat(storesMapData, hasValue(name));
        storesId = (int) storesMapData.get("id");
        System.out.println(storesId);
    }

    @Title("update the stores information")
    @Test
    public void test03() {
        name = name + "Queen";
        storesSteps.updateStores(storesId, name);
        HashMap<String, Object> storeMapData = storesSteps.getStoresInfoByname(name);
        Assert.assertThat(storeMapData, hasValue(name));
    }

    @Title("Delete store info by StoreId and verify its deleted")
    @Test
    public void test04() {

        storesSteps.deleteStoreInfoByID(storesId).statusCode(200);
        storesSteps.getstoresInfoByStoresId(storesId).statusCode(404);
    }
}


