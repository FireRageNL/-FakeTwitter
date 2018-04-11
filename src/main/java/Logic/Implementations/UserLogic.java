package Logic.Implementations;

import Dao.Interfaces.IUserDAO;
import Dao.Interfaces.KwetterJPA;
import Entities.Account;
import Logic.Interfaces.IUserLogic;
import Logic.Utilities.Hashing;

import javax.inject.Inject;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.List;

public class UserLogic implements IUserLogic {



	@Inject
	@KwetterJPA
	private IUserDAO userDAO;

	private UserLogic(){
		//Empty constructor for ejb
	}
	public UserLogic(IUserDAO dao){
		this.userDAO = dao;
	}

	@Override
	public Account addUserToCollection(Account accountToAdd) throws InvalidKeySpecException, NoSuchAlgorithmException {
		String pwHash = Hashing.generatePasswordHash(accountToAdd.getPasswordHash());
		accountToAdd.setPasswordHash(pwHash);
		return userDAO.add(accountToAdd);
	}

	public Account getUserFromDatabase(String username) {
		return userDAO.findByUsername(username);
	}

	@Override
	public boolean verifyUserPassword(String passwordHash, String password) throws InvalidKeySpecException, NoSuchAlgorithmException {
		return Hashing.verifyPassword(passwordHash,password);
	}

	@Override
	public void addFollower(Account toEdit, Account newFollower) {
		List<Account> followers = toEdit.getFollowers();
		followers.add(newFollower);
		toEdit.setFollowers(followers);
		userDAO.update(toEdit);

	}

	@Override
	public void deleteFollower(Account toEdit, Account removeFollower) {
		List<Account> followers = toEdit.getFollowers();
		followers.remove(removeFollower);
		toEdit.setFollowers(followers);
		userDAO.update(toEdit);
	}

	@Override
	public boolean loginUser(String username, String password) throws InvalidKeySpecException, NoSuchAlgorithmException {
		Account toLogin = getUserFromDatabase(username);
		return verifyUserPassword(toLogin.getPasswordHash(),password);
	}

}
