package tests;

import io.restassured.response.Response;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import utilities.JsonProcessing;
import utilities.PropertiesReader;
import utilities.RestAssuredHelper;

import java.util.Map;

import static org.testng.Assert.assertEquals;

public class BaseTest {

    public JsonProcessing data = new JsonProcessing();
    public RestAssuredHelper restAssuredHelper=new RestAssuredHelper();

    protected static PropertiesReader propReader = new PropertiesReader();

    @BeforeTest
    public void setUp() {
        System.out.println("This test is started");
    }

    @AfterTest
    public void tearDown() {
        System.out.println("This test is completed");
    }

    public void AssertStatusCode(Response response, int expectedStatusCode)
    {
        int actualStatusCode = response.getStatusCode();
        System.out.println("Response Status Code: " + actualStatusCode);
        assertEquals(expectedStatusCode, actualStatusCode);
    }

    public void AssertContent(Object postModel, Response response)
    {
        Map<?, ?> actualResponseBody = response.jsonPath().get();
        System.out.println("Actual Response Content:" + actualResponseBody);

        Map<?, ?> expectedResponseBody = data.ConvertModelToMap(postModel);
        System.out.println("Expected Response Content:" + expectedResponseBody);

        assertEquals(expectedResponseBody, actualResponseBody);
    }
}
