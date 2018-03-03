package BLL.Interfaces;

import entities.User;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

public interface IUserLogic {

	User addUserToCollection(String username, String password, String email, int id) throws InvalidKeySpecException, NoSuchAlgorithmException;

	User getUserFromDatabase(String username);

}
