package Dao.Interfaces;

import Entities.Kweet;

import java.util.List;

public interface IKweetDAO extends IGenericDAO<Kweet> {

	List<Kweet> getAllMessagesFromUser(String userName);
}
