package Logic.Interfaces;


import Entities.Account;

import javax.json.JsonObject;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.List;

public interface IUserLogic {

	Account addUserToCollection(Account accountToAdd) throws InvalidKeySpecException, NoSuchAlgorithmException;

	Account getUserFromDatabase(String username);

	Account getUserByID(int id);

	boolean verifyUserPassword(String passwordHash, String password) throws InvalidKeySpecException, NoSuchAlgorithmException;

	void addFollower(Account toEdit, Account newFollower);

	void deleteFollower(Account toEdit, Account removeFollower);

	boolean loginUser(String username, String password) throws InvalidKeySpecException, NoSuchAlgorithmException;

	List<Account> getAllUsersFromDatabase();

	List<JsonObject> convertListToJSON(List<Account> accounts);
}
