package BLL.Implementations;

import BLL.Factories.DALFactory;
import BLL.Interfaces.IUserLogic;
import DAL.Implementations.UserCollectionDAO;
import entities.User;

import javax.inject.Inject;
import javax.security.enterprise.identitystore.Pbkdf2PasswordHash;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

public class UserLogic implements IUserLogic {

	private DALFactory df;

	public UserLogic(){
		df = new DALFactory();
	}

	public User addUserToCollection(String username, String password, String email, int id) throws InvalidKeySpecException, NoSuchAlgorithmException {
		UserCollectionDAO dao = df.getUserCollectionDAO();
		String pwHash = BLL.Utilities.Hashing.generatePasswordHash(password);
		User newUser = new User(username,pwHash,email,id);
		return dao.add(newUser);
	}

	public User getUserFromDatabase(String username) {
		UserCollectionDAO dao = df.getUserCollectionDAO();
		return dao.findByUsername(username);
	}

	@Override
	public boolean verifyUserPassword(String passwordHash, String password) throws InvalidKeySpecException, NoSuchAlgorithmException {
		return BLL.Utilities.Hashing.verifyPassword(passwordHash,password);
	}

}
