package Dao.Implementations.JPA;

import Dao.Interfaces.IKweetDAO;
import Dao.Interfaces.KwetterJPA;
import Entities.Kweet;

import javax.ejb.Stateless;
import java.util.List;

@Stateless
@KwetterJPA
public class KweetDAO extends GenericDAO<Kweet> implements IKweetDAO {

	@Override
	public List<Kweet> getAllMessagesFromUser(String userName) {
		return null;
	}
}
