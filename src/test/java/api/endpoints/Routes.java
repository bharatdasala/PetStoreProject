package api.endpoints;
/*
 * Swagger urls -- > https://petstore.swagger.io
 * Create Post :https://petstore.swagger.io/v2/user
 * Get user : https://petstore.swagger.io/v2/user/{username}
 * Update Put :https://petstore.swagger.io/v2/user/{username}
 * Delete delete :https://petstore.swagger.io/v2/user/{username}
 */


public class Routes {
	
	public static String base_url="https://petstore.swagger.io/v2";
	
	//User Module
	public static String post_url=base_url+"/user";
	public static String get_url=base_url+"/user/{username}";
	public static String update_url=base_url+"/user/{username}";
	public static String delete_url=base_url+"/user/{username}";
	

}
