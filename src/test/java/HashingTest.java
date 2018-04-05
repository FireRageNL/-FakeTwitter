import Logic.Utilities.Hashing;
import org.junit.Assert;
import org.junit.Test;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

public class HashingTest {

	@Test
	public void ValidatePasswordTest_CorrectPassword() throws InvalidKeySpecException, NoSuchAlgorithmException {
		String password = Hashing.generatePasswordHash("test");

		Assert.assertTrue(Hashing.verifyPassword(password,"test"));
	}

	@Test
	public void ValidatePassword_IncorrectPassword() throws InvalidKeySpecException, NoSuchAlgorithmException {
		String password = Hashing.generatePasswordHash("test");

		Assert.assertFalse(Hashing.verifyPassword(password,"thisiswrong"));
	}
}
