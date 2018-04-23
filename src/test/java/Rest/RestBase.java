package Rest;


import org.junit.BeforeClass;
import io.restassured.RestAssured;

import static io.restassured.RestAssured.*;

public class RestBase {


	@BeforeClass
	public static void Setup(){
		String port = System.getProperty("server.port");
		if (port == null) {
			RestAssured.port = Integer.valueOf(8089);
		}
		else{
			RestAssured.port = Integer.valueOf(port);
		}


		String basePath = System.getProperty("server.base");
		if(basePath==null){
			basePath = "/Kwetter/";
		}
		RestAssured.basePath = basePath;

		String baseHost = System.getProperty("server.host");
		if(baseHost==null){
			baseHost = "http://localhost";
		}
		baseURI = baseHost;

	}

}
