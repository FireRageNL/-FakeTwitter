package Dao.Implementations.JPA;

import Dao.Interfaces.IUserDAO;
import Dao.Interfaces.KwetterJPA;
import Entities.Account;

import javax.ejb.Stateless;
import javax.persistence.Query;
import java.util.List;

@Stateless
@KwetterJPA
public class UserDAO extends GenericDAO<Account> implements IUserDAO {


	public int countUsers() {
		return 0;
	}

	public Account findByUsername(String username) {
		return null;
	}

	public List<Account> getAll() {
		Query q = em.createQuery("SELECT a FROM Account a");
		return q.getResultList();
	}
}
