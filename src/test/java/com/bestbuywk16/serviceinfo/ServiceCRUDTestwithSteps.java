package com.bestbuywk16.serviceinfo;

import com.bestbuywk16.servicesinfo.ServicesSteps;
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

public class ServiceCRUDTestwithSteps extends TestBase {
    static String name = "jes" + TestUtils.getRandomValue();
    static int servicesId;
    @Steps
    ServicesSteps servicesSteps;

    @Title("This will create a new service")
    @Test
    public void test001() {
        ValidatableResponse response = servicesSteps.createServices(name);
        response.statusCode(201);
    }

    @Title("verify if service is created")
    @Test
    public void test002() {
        HashMap<String, Object> servicesMapData = servicesSteps.getServicesInfoByname(name);
        Assert.assertThat(servicesMapData, hasValue(name));
        servicesId = (int) servicesMapData.get("id");
        System.out.println(servicesId);
    }

    @Title("update the service information")
    @Test
    public void test003() {
        name = name + "pumba";

        servicesSteps.updateServices(name,servicesId);
        HashMap<String, Object> servicesMapData = servicesSteps.getServicesInfoByname(name);
        Assert.assertThat(servicesMapData, hasValue(name));
    }
    @Title("Delete service info  and verify its deleted")
    @Test
    public void test004() {
        servicesSteps.deleteServicessInfoByID(servicesId).statusCode(200);
        servicesSteps.getserviceInfoByServicesId(servicesId).statusCode(404);
    }
}

