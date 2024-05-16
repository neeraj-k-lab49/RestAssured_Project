package tests;

import constants.PostConstants;
import constants.RequestType;
import io.restassured.response.Response;
import models.PostModel;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class DeleteResources extends BaseTest{
    public String url="";

    @Test
    public void CreateDeleteTest() {
        String user= propReader.getUser("userDelete");
        String baseUrl = propReader.getBaseUrl();
        url = baseUrl + "/api/users/" + user;
        System.out.println(url);

        PostModel postModel = new PostModel(PostConstants.NameCreate);
        //System.out.println(postModel.toString());
        String postModelAsString = data.ConvertModelToJSON(postModel);

        Response response = restAssuredHelper.SpecifyAndSendRequest(RequestType.Delete, url, null);

        assertEquals(response.getStatusCode(), 204);

    }
}
