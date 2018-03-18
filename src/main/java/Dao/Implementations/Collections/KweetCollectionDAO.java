package Dao.Implementations.Collections;

import Dao.Interfaces.IKweetDAO;
import Entities.Kweet;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class KweetCollectionDAO implements IKweetDAO {

	CopyOnWriteArrayList<Kweet> kweets = new CopyOnWriteArrayList<>();


	@Override
	public List<Kweet> getAllMessagesFromUser(String userName) {
		List<Kweet> kweetsByUser = new ArrayList<Kweet>();
		for(Kweet k: kweets){
			if(k.getOwner().getUsername() == userName){
				kweetsByUser.add(k);
			}
		}
		return kweetsByUser;
	}

	@Override
	public Kweet add(Kweet object) {
		kweets.add(object);
		return object;
	}

	@Override
	public void deleteById(int id) {
	for(Kweet k : kweets){
		if(k.getId() == id){
			kweets.remove(k);
		}
	}
	}

	@Override
	public void delete(Kweet object) {
	kweets.remove(object);
	}

	@Override
	public Kweet findById(int id) {
		for(Kweet k : kweets){
			if(k.getId() == id){
				return k;
			}
		}
		return null;
	}

	@Override
	public Kweet update(Kweet object) {
		for(Kweet k : kweets){
			if(k.getId() == object.getId()){
				kweets.remove(k);
				kweets.add(object);
				return object;
			}
		}
		return null;
	}
}
