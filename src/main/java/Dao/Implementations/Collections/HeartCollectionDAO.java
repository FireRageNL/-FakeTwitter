package Dao.Implementations.Collections;

import Dao.Interfaces.IHeartDAO;
import Entities.Heart;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class HeartCollectionDAO implements IHeartDAO {

	CopyOnWriteArrayList<Heart> hearts = new CopyOnWriteArrayList<>();

	@Override
	public int getAmountOfHeartsForMessage(int messageId) {
		int count = 0;
		for(Heart h : hearts){
			if(h.getLikedKweet().getId() == messageId){
				count++;
			}
		}
		return count;
	}

	@Override
	public Heart add(Heart object){
		hearts.add(object);
		return object;
	}

	@Override
	public void deleteById(int id) {
		for(Heart h : hearts){
			if(h.getId() == id){
				hearts.remove(h);
			}
		}
	}

	@Override
	public void delete(Heart object) {
		hearts.remove(object);
	}

	@Override
	public Heart findById(int id) {
		for(Heart h : hearts){
			if(h.getId() == id){
				return h;
			}
		}
		return null;
	}

	@Override
	public Heart update(Heart object) {
		if(findById(object.getId()) != null){
			for(Heart h : hearts){
				if(h.getId() == object.getId()){
					hearts.remove(h);
					hearts.add(object);
					return object;
				}
			}
		}
		return null;	}

	@Override
	public List<Heart> getAll() {
		return hearts;
	}
}
