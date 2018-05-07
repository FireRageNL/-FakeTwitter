package Logic.Implementations;

import Dao.Interfaces.IUserDAO;
import Dao.Interfaces.KwetterJPA;
import Entities.Account;
import Logic.Interfaces.IUserLogic;
import Logic.Utilities.Hashing;

import javax.inject.Inject;
import javax.json.JsonObject;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;
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
		if(accountToAdd.getBiography().length() == 0){
			accountToAdd.setBiography("I am new here!");
		}
		return userDAO.add(accountToAdd);
	}

	public Account getUserFromDatabase(String username) {
		return userDAO.findByUsername(username);
	}

	@Override
	public Account getUserByID(int id) {
		return userDAO.findById(id);
	}

	@Override
	public boolean verifyUserPassword(String passwordHash, String password) throws InvalidKeySpecException, NoSuchAlgorithmException {
		return Hashing.verifyPassword(passwordHash,password);
	}

	@Override
	public void addFollower(Account toEdit, Account newFollower) {
		List<Account> followers = toEdit.getFollowers();
		followers.add(newFollower);
		toEdit.setFollowing(followers);
		Account editedAccount = userDAO.update(toEdit);
		System.out.println(editedAccount.getFollowers().toString());

	}

	@Override
	public void deleteFollower(Account toEdit, Account removeFollower) {
		List<Account> followers = toEdit.getFollowers();
		followers.remove(removeFollower);
		toEdit.setFollowers(followers);
		Account editedAccount = userDAO.update(toEdit);
		System.out.println(editedAccount.getFollowers().toString());
	}

	@Override
	public boolean loginUser(String username, String password) throws InvalidKeySpecException, NoSuchAlgorithmException {
		Account toLogin = getUserFromDatabase(username);
		if(toLogin == null){
			return false;
		}
		return verifyUserPassword(toLogin.getPasswordHash(),password);
	}

	@Override
	public List<Account> getAllUsersFromDatabase() {
		return userDAO.getAll();
	}

	@Override
	public List<JsonObject> convertListToJSON(List<Account> accounts) {
		List<JsonObject> toReturn = new ArrayList<>();
		for(Account a : accounts){
			toReturn.add(a.convertToJSON());
		}
		return toReturn;
	}

}
