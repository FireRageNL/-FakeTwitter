package Rest;

import org.junit.Test;

import static io.restassured.RestAssured.given;

public class AccountRestTest extends RestBase{

	@Test
	public void getAllAccounts(){
		given().when().get("/api/account/getall").then().statusCode(200);
	}
}
