package api.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndPoints;
import api.endpoints.UserEndPointsPropertyFile;
import api.payload.User;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;

public class UserTestPropertyFile {
	
	Faker fakedata=new Faker();
	User userdata=new User();;
	
	@BeforeClass
	public void DataSetup()
	{
		
		userdata.setId(fakedata.idNumber().hashCode());		
		userdata.setUsername(fakedata.name().username());
		userdata.setFirstName(fakedata.name().firstName());
		userdata.setLastName(fakedata.name().lastName());
		userdata.setEmail(fakedata.internet().emailAddress());
		userdata.setPassword(fakedata.internet().password());
		userdata.setPhone(fakedata.phoneNumber().cellPhone());
			
	}
	
	
	@Test(priority=1)
	void createuser()
	{
		Response CreatRes=UserEndPointsPropertyFile.createUser(userdata);
		System.out.println("Create user Response");
		CreatRes.then().log().all();
		Assert.assertEquals(CreatRes.getStatusCode(), 200);
		
		
	}
	@Test(priority=2)
	void getuser()
	{
		Response ReadRes=UserEndPointsPropertyFile.readUser(userdata.getUsername());
		System.out.println("Get user Response");
		ReadRes.then().log().all();
		Assert.assertEquals(ReadRes.getStatusCode(), 200);
		
	}
	
	@Test(priority=3)
	void updateuser()
	{
		//update the user data change only first name , lastname and email
		userdata.setFirstName(fakedata.name().firstName());
		userdata.setLastName(fakedata.name().lastName());
		userdata.setEmail(fakedata.internet().emailAddress());
		
		Response UpdateRes=UserEndPointsPropertyFile.updateUser(userdata.getUsername(),userdata);
		System.out.println("Update user Response");
		UpdateRes.then().log().all();
		Assert.assertEquals(UpdateRes.getStatusCode(), 200);
		
		//to validate the is the data is updated we will have to first retrive the data using get method because update does not give any respose
		Response ReadRes=UserEndPointsPropertyFile.readUser(userdata.getUsername());
		System.out.println("Post update user Response");
		ReadRes.then().log().all();
		Assert.assertEquals(ReadRes.getStatusCode(), 200);
	}
	
	@Test(priority=4)
	void deleteuser()
	{
		Response DeleteRes=UserEndPointsPropertyFile.deleteUser(userdata.getUsername());
		System.out.println("Delete user Response");
		DeleteRes.then().log().all();
		Assert.assertEquals(DeleteRes.getStatusCode(), 200);

}
}