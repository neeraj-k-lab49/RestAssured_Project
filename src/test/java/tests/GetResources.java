package tests;

import io.restassured.response.Response;
import models.PostModel;
import org.testng.annotations.Test;
import constants.PostConstants;
import constants.RequestType;
import constants.StatusCodeConstants;

import static org.testng.Assert.assertEquals;

public class GetResources extends BaseTest {

    public String url = "";

    @Test
    public void ListUsersTest() {
        String pages= propReader.getPages();
        String baseUrl = propReader.getBaseUrl();
        url = baseUrl + "/api/users/";
        System.out.println(url);

        Response response = restAssuredHelper.SpecifyAndSendRequest(RequestType.Get, url, null);
        assertEquals(response.getStatusCode(), 200);
        System.out.println(response.prettyPrint());
        assertEquals(response.jsonPath().get("total_pages").toString(),pages);

    }

    @Test
    public void SingleUserTest() {
        String user= propReader.getUser("user");
        String baseUrl = propReader.getBaseUrl();
        url = baseUrl + "/api/users/" + user;
        System.out.println(url);

        Response response = restAssuredHelper.SpecifyAndSendRequest(RequestType.Get, url, null);

        assertEquals(response.getStatusCode(), 200);
        System.out.println(response.prettyPrint());
        assertEquals(response.jsonPath().get("data.id").toString(),user);
    }

    @Test
    public void UserNotFoundTest() {
        String user= propReader.getUser("userDelete");
        String baseUrl = propReader.getBaseUrl();
        url = baseUrl + "/api/users/" + user;
        System.out.println(url);

        Response response = restAssuredHelper.SpecifyAndSendRequest(RequestType.Get, url, null);

        assertEquals(response.getStatusCode(), 404);
    }


}
