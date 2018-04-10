package Dao.Implementations.JPA;

import Dao.Interfaces.IHeartDAO;
import Entities.Heart;

public class HeartDAO extends GenericDAO<Heart> implements IHeartDAO {
	@Override
	public int getAmountOfHeartsForMessage(int messageId) {
		return 0;
	}
}
