package Dao.Interfaces;

import Entities.Heart;

public interface IHeartDAO extends IGenericDAO<Heart> {

	 int getAmountOfHeartsForMessage(int messageId);

}
