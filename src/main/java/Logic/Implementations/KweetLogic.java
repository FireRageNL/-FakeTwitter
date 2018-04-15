package Logic.Implementations;

import Dao.Interfaces.IKweetDAO;
import Dao.Interfaces.KwetterJPA;
import Entities.Kweet;
import Logic.Interfaces.IKweetLogic;

import javax.inject.Inject;
import java.util.List;

public class KweetLogic implements IKweetLogic {

	@Inject
	@KwetterJPA
	private IKweetDAO kweetDAO;

	private KweetLogic(){
		//Empty private for ejb
	}

	public KweetLogic(IKweetDAO kweetDAO) {
		this.kweetDAO = kweetDAO;
	}

	@Override
	public Kweet addNewKweet(Kweet kweetToAdd) {
		return kweetDAO.add(kweetToAdd);
	}

	@Override
	public Kweet getKweetById(int id) {
		return kweetDAO.findById(id);
	}

	@Override
	public List<Kweet> getAllKweetsFromUser(String username) {
		return kweetDAO.getAllMessagesFromUser(username);
	}


}
