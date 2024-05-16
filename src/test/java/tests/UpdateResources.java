package tests;

import constants.PostConstants;
import constants.RequestType;
import io.restassured.response.Response;
import models.PostModel;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class UpdateResources extends BaseTest{

    public String url="";

    @Test
    public void CreatePutTest() {
        String user= propReader.getUser("userUpdate");
        String baseUrl = propReader.getBaseUrl();
        url = baseUrl + "/api/users/" + user;
        System.out.println(url);

        PostModel postModel = new PostModel(PostConstants.NameCreate, PostConstants.JobCreate);
        //System.out.println(postModel.toString());
        String postModelAsString = data.ConvertModelToJSON(postModel);

        Response response = restAssuredHelper.SpecifyAndSendRequest(RequestType.Put, url, postModelAsString);

        assertEquals(response.getStatusCode(), 200);
        String name = response.jsonPath().getString("name");

        System.out.println(name);

        assertEquals(name, PostConstants.NameCreate);

    }

    @Test
    public void CreatePatchTest() {
        String user= propReader.getUser("userUpdate");
        String baseUrl = propReader.getBaseUrl();
        url = baseUrl + "/api/users/" + user;
        System.out.println(url);

        PostModel postModel = new PostModel(PostConstants.NameCreate);
        //System.out.println(postModel.toString());
        String postModelAsString = data.ConvertModelToJSON(postModel);

        Response response = restAssuredHelper.SpecifyAndSendRequest(RequestType.Patch, url, postModelAsString);

        assertEquals(response.getStatusCode(), 200);
        String name = response.jsonPath().getString("name");

        System.out.println(name);

        assertEquals(name, PostConstants.NameCreate);

    }

}
