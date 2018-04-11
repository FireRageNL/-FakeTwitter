package Logic.Interfaces;


import Entities.Account;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

public interface IUserLogic {

	Account addUserToCollection(Account accountToAdd) throws InvalidKeySpecException, NoSuchAlgorithmException;

	Account getUserFromDatabase(String username);

	boolean verifyUserPassword(String passwordHash, String password) throws InvalidKeySpecException, NoSuchAlgorithmException;

	void addFollower(Account toEdit, Account newFollower);

	void deleteFollower(Account toEdit, Account removeFollower);

	boolean loginUser(String username, String password) throws InvalidKeySpecException, NoSuchAlgorithmException;

}
