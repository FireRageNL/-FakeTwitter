package Logic.Interfaces;

import Entities.Kweet;

import java.util.List;

public interface IKweetLogic {

	Kweet addNewKweet(Kweet kweetToAdd);

	Kweet getKweetById(int id);

	List<Kweet> getAllKweetsFromUser(String username);
}
