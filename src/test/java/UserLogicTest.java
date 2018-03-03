import BLL.Implementations.UserLogic;
import entities.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.inject.Inject;
import javax.security.enterprise.identitystore.Pbkdf2PasswordHash;
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
}
