package DAL.Implementations;

import DAL.Interfaces.IUserDAO;
import entities.User;

public class UserDAO extends GenericDAO<User> implements IUserDAO {


	public int countUsers() {
		return 0;
	}

	public User findByUsername(String username) {
		return null;
	}
}
