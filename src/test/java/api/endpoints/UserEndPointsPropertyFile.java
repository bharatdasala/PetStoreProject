package api.endpoints;

import static io.restassured.RestAssured.*;

import java.util.ResourceBundle;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

//User enpoint.java file
//Create to perform CRUD (Create, Read, Update,Delete) operation for user api
public class UserEndPointsPropertyFile {
	
	static ResourceBundle accessURL()
	{
		ResourceBundle routesproperty= ResourceBundle.getBundle("route");
		return routesproperty;
	}
	
	
	public static Response createUser(User payload)// the user payload in the argument is class which will have the body of the request
	{
		
		String posturl=accessURL().getString("post_url");
		Response res=given().contentType(ContentType.JSON).accept("application/json").body(payload)
		 .when().post(posturl);
		
		return res;
	}
	
	public static Response readUser(String username)
	{
		String geturl=accessURL().getString("get_url");
		Response res=given().pathParam("username",username)
		 .when().get(geturl);
		
		return res;
	}
	
	public static Response updateUser(String username, User payload)// the user payload in the argument is class which will have the body of the request
	{
		String updateurl=accessURL().getString("update_url");
		Response res=given().contentType(ContentType.JSON).accept("application/json").body(payload).pathParam("username",username)
		 .when().put(updateurl);
		
		return res;
	}
	
	public static Response deleteUser(String username)
	{
		String deleteurl=accessURL().getString("delete_url");
		Response res=given().pathParam("username",username)
		 .when().get(deleteurl);
		
		return res;
	}
	
	

}
