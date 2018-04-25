package Rest;

import com.github.tomakehurst.wiremock.junit.WireMockRule;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static io.restassured.RestAssured.given;

public class LoginRestTest extends RestBase {


	@Rule
	public WireMockRule wireMockRule = new WireMockRule(8089);

	@BeforeClass
	public static void setup() {

		Setup();

	}

	@Test
	public void GetLoginEndpointTest(){
		wireMockRule.stubFor(get(urlEqualTo("/Kwetter/api/login"))
				.withHeader("Accept", equalTo("*/*"))
				.willReturn(aResponse()
						.withStatus(200)
						.withHeader("Content-Type", "/")));

		given().when().get("/api/login").then().statusCode(200);

	}
}
