package BLL.Implementations;

import BLL.Factories.DALFactory;
import BLL.Interfaces.IUserLogic;
import DAL.Implementations.UserCollectionDAO;
import entities.User;

import javax.inject.Inject;
import javax.security.enterprise.identitystore.Pbkdf2PasswordHash;

public class UserLogic implements IUserLogic {

	@Inject
	Pbkdf2PasswordHash hash;

	private DALFactory df = new DALFactory();

	public User addUserToCollection(String username, String password, String email, int id) {
		UserCollectionDAO dao = df.getUserCollectionDAO();
		User newUser = new User(username,hash.generate(password.toCharArray()),email,id);
		return dao.add(newUser);
	}

	public User getUserFromDatabase(String username) {
		UserCollectionDAO dao = df.getUserCollectionDAO();
		return dao.findByUsername(username);
	}

	public boolean verifyPassword(String enteredPassword, String passwordHash) {
		return hash.verify(enteredPassword.toCharArray(),passwordHash);
	}
}
