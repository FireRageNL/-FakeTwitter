package Dao.Implementations.JPA;

import Dao.Interfaces.IKweetDAO;
import Entities.Kweet;

import java.util.List;

public class KweetDAO extends GenericDAO<Kweet> implements IKweetDAO {

	@Override
	public List<Kweet> getAllMessagesFromUser(String userName) {
		return null;
	}
}
