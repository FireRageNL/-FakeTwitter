import BLL.Implementations.UserLogic;
import entities.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

public class UserLogicTest {

	private UserLogic ul;

	@Before
	public void SetUp() throws InvalidKeySpecException, NoSuchAlgorithmException {
		ul = new UserLogic();

		ul.addUserToCollection("TestUser123","Test","TestPassword123",1);
	}

	@Test
	public void GetUserFromDatabase_UserInDatabase_ReturnsUser(){
		User toFind = ul.getUserFromDatabase("TestUser123");

		Assert.assertEquals(1,toFind.getId());
	}

/*	@Test
	public void VerifyPasswordOfUser_TestPassword123_ReturnsTrue() throws InvalidKeySpecException, NoSuchAlgorithmException {
		String passwordHash = "2500:76606ba8a313ea83ffe3c6bd49973dd7492c0c6abe27ec308e813162c49d5974:41408f68f07a89865c3b93be0297b1437258e27485571860c8d429e831801821";

		Assert.assertTrue(ul.verifyUserPassword(passwordHash,"TestPassword123"));

	}*/
}
