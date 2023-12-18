package api.endpoints;

import static io.restassured.RestAssured.*;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

//User enpoint.java file
//Create to perform CRUD (Create, Read, Update,Delete) operation for user api
public class UserEndPoints {
	
	public static Response createUser(User payload)// the user payload in the argument is class which will have the body of the request
	{
		Response res=given().contentType(ContentType.JSON).accept("application/json").body(payload)
		 .when().post(Routes.post_url);
		
		return res;
	}
	
	public static Response readUser(String username)
	{
		Response res=given().pathParam("username",username)
		 .when().get(Routes.get_url);
		
		return res;
	}
	
	public static Response updateUser(String username, User payload)// the user payload in the argument is class which will have the body of the request
	{
		Response res=given().contentType(ContentType.JSON).accept("application/json").body(payload).pathParam("username",username)
		 .when().put(Routes.update_url);
		
		return res;
	}
	
	public static Response deleteUser(String username)
	{
		Response res=given().pathParam("username",username)
		 .when().get(Routes.delete_url);
		
		return res;
	}
	
	

}
