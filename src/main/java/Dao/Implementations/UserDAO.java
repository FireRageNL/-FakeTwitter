package Dao.Implementations;

import Dao.Interfaces.IUserDAO;
import Dao.Interfaces.KwetterJPA;
import entities.User;

import javax.ejb.Stateless;

@Stateless
@KwetterJPA
public class UserDAO extends GenericDAO<User> implements IUserDAO {


	public int countUsers() {
		return 0;
	}

	public User findByUsername(String username) {
		return null;
	}
}
