package Dao.Implementations.JPA;

import Dao.Implementations.JPA.GenericDAO;
import Dao.Interfaces.IUserDAO;
import Dao.Interfaces.KwetterJPA;
import Entities.Account;

import javax.ejb.Stateless;

@Stateless
@KwetterJPA
public class UserDAO extends GenericDAO<Account> implements IUserDAO {


	public int countUsers() {
		return 0;
	}

	public Account findByUsername(String username) {
		return null;
	}
}
