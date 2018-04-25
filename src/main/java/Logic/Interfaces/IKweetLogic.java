package Logic.Interfaces;

import Entities.Kweet;

import javax.json.JsonObject;
import java.util.List;

public interface IKweetLogic {

	Kweet addNewKweet(Kweet kweetToAdd);

	Kweet getKweetById(int id);

	List<Kweet> getAllKweets();

	List<Kweet> getAllKweetsFromUser(String username);

	List<JsonObject> convertListToJSON(List<Kweet> kweets);

}
