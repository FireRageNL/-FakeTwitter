package Utilities;

import Logic.Implementations.JWTTokenLogic;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class JwtTokenTest {

	JWTTokenLogic tokenLogic;
	@Before
	public void Setup(){
		tokenLogic = new JWTTokenLogic();
	}

	@Test
	public void GetUsernameFromToken_ValidToken_ReturnsUsername(){
		String token = tokenLogic.EncodeToken("test");

		String extractedUsername = tokenLogic.GetUsernameFromToken(token);

		Assert.assertEquals("test",extractedUsername);
	}

	@Test
	public void CheckTrustedToken_ValidToken_ReturnsTrue(){
		String token = tokenLogic.EncodeToken("test");

		Assert.assertTrue(tokenLogic.CheckIfTokenIsTrusted(token));
	}

	@Test
	public void CheckTrustedToken_InvalidToken_ReturnsFalse(){
		String token = "lol";

		Assert.assertFalse(tokenLogic.CheckIfTokenIsTrusted(token));
	}

	@Test
	public void CheckTrustedToken_FakeToken_ReturnsFalse(){
		String token = "this.is.fake";

		Assert.assertFalse(tokenLogic.CheckIfTokenIsTrusted(token));
	}
}
