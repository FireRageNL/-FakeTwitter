package Rest;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

import com.github.tomakehurst.wiremock.junit.WireMockRule;
import org.junit.*;

import static io.restassured.RestAssured.given;

public class AccountRestTest extends RestBase{

	@Rule
	public WireMockRule wireMockRule = new WireMockRule(8089);

	@BeforeClass
	public static void setup() {

		Setup();

	}
	@Test
	public void getAllAccounts(){
		wireMockRule.stubFor(get(urlEqualTo("/Kwetter/api/account/getall"))
				.withHeader("Accept", equalTo("*/*"))
				.willReturn(aResponse()
						.withStatus(200)
						.withHeader("Content-Type", "/")));


		given().when().get("/api/account/getall").then().statusCode(200);
	}

	@Test
	public void getSpecificAccountById(){
		wireMockRule.stubFor(get(urlEqualTo("/Kwetter/api/account/1"))
				.withHeader("Accept", equalTo("*/*"))
				.willReturn(aResponse()
						.withStatus(200)
						.withHeader("Content-Type", "text/json")));

		given().when().get("/api/account/1").then().statusCode(200);
	}
}
