package Logic;

import Dao.Interfaces.IUserDAO;
import Entities.Account;
import Logic.Implementations.UserLogic;
import Logic.Utilities.Hashing;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import static org.mockito.Mockito.verify;


@RunWith(MockitoJUnitRunner.class)
public class UserLogicTest {

	@Mock
	private IUserDAO userDAO;

	private UserLogic ul;
	private Account account1;

	@Before
	public void SetUp(){
		MockitoAnnotations.initMocks(this);
		ul = new UserLogic(userDAO);
		account1 = new Account("Hello","Hello","hello@hi.nl");
	}

	@Test
	public void CreateAccount_FullAcount_AccountAdded() throws InvalidKeySpecException, NoSuchAlgorithmException {
		Account added = ul.addUserToCollection(account1);

		verify(userDAO, Mockito.times(1)).add(account1);
	}

	@Test
	public void VerifyPassword_CorrectPassword_ReturnsTrue() throws InvalidKeySpecException, NoSuchAlgorithmException {
		String passwordHash = Hashing.generatePasswordHash("test");

		Assert.assertTrue(ul.verifyUserPassword(passwordHash,"test"));
	}

	@Test
	public void VerifyPassword_IncorrectPassword_ReturnsFalse() throws InvalidKeySpecException, NoSuchAlgorithmException {
		String passwordHash = Hashing.generatePasswordHash("CanYouDoThis");

		Assert.assertFalse(ul.verifyUserPassword(passwordHash,"Only399"));
	}
}
