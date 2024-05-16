package tests;

import io.restassured.path.json.JsonPath;
import io.restassured.path.json.config.JsonPathConfig;
import io.restassured.response.Response;
import models.PostModel;
import org.testng.annotations.Test;
import constants.PostConstants;
import constants.RequestType;
import constants.StatusCodeConstants;
import utilities.JsonProcessing;

import static org.testng.Assert.assertEquals;

public class CreateResources extends BaseTest{
    public String url="";

    @Test
    public void CreatePostsTest()
    {
        url=propReader.getBaseUrl()+"/api/users/";
        System.out.println(url);

        PostModel postModel = new PostModel(PostConstants.NameCreate, PostConstants.JobCreate);
        //System.out.println(postModel.toString());
        String postModelAsString = data.ConvertModelToJSON(postModel);

        Response response = restAssuredHelper.SpecifyAndSendRequest(RequestType.Post,url, postModelAsString);

        assertEquals(response.getStatusCode(),201);
        String name = response.jsonPath().getString("name");

        System.out.println(name);

        assertEquals(name,PostConstants.NameCreate);
    }

}
