package Rest;

import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class AccountRestTest extends RestBase{

	@BeforeClass
	public static void setup() {
		Setup();
	}

	@Test
	public void getAllAccounts(){
		given().when().get("/api/account/getall").then().statusCode(200);
	}
}
