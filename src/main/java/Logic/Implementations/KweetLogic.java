package Logic.Implementations;

import Dao.Interfaces.IKweetDAO;
import Dao.Interfaces.KwetterJPA;
import Entities.Kweet;
import Logic.Interfaces.IKweetLogic;

import javax.inject.Inject;

public class KweetLogic implements IKweetLogic {

	@Inject
	@KwetterJPA
	private IKweetDAO kweetDAO;

	public KweetLogic(IKweetDAO kweetDAO) {
		this.kweetDAO = kweetDAO;
	}

	@Override
	public Kweet addNewKweet(Kweet kweetToAdd) {
		return kweetDAO.add(kweetToAdd);
	}
}
