package BLL.Interfaces;

import entities.User;

public interface IUserLogic {

	User addUserToCollection(String username, String password, String email, int id);

	User getUserFromDatabase(String username);

	boolean verifyPassword(String enteredPassword, String passwordHash);
}
