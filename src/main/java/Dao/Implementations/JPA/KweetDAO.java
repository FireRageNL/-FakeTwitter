package Dao.Implementations.JPA;

import Dao.Interfaces.IKweetDAO;
import Dao.Interfaces.KwetterJPA;
import Entities.Kweet;

import javax.ejb.Stateless;
import javax.persistence.NamedQuery;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
@KwetterJPA
public class KweetDAO extends GenericDAO<Kweet> implements IKweetDAO {

	@Override
	public List<Kweet> getAllMessagesFromUser(String userName) {
		TypedQuery<Kweet> query = em.createNamedQuery("kweet.findKweetBy",Kweet.class);
		query.setParameter("name",userName);
		return query.getResultList();
	}

	@Override
	public List<Kweet> getAll() {
		Query q = em.createQuery("SELECT k FROM Kweet k");
		return q.getResultList();
	}
}
