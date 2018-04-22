package Dao.Implementations.JPA;

import Dao.Interfaces.IUserDAO;
import Dao.Interfaces.KwetterJPA;
import Entities.Account;

import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
@KwetterJPA
public class UserDAO extends GenericDAO<Account> implements IUserDAO {


	public int countUsers() {
		return 0;
	}

	public Account findByUsername(String username) {
		try{
			TypedQuery<Account> query = em.createNamedQuery("account.findUser",Account.class);
			query.setParameter("name",username);
			return query.getSingleResult();
		}
		catch(NoResultException e) {
			return null;
		}

	}

	public List<Account> getAll() {
		Query q = em.createQuery("SELECT a FROM Account a");
		return q.getResultList();
	}
}
