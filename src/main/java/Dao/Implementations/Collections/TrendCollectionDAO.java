package Dao.Implementations.Collections;

import Dao.Interfaces.ITrendDAO;
import Entities.Trend;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class TrendCollectionDAO implements ITrendDAO {

	CopyOnWriteArrayList<Trend> trends = new CopyOnWriteArrayList<>();

	@Override
	public Trend add(Trend object) {
		trends.add(object);
		return object;
	}

	@Override
	public void deleteById(int id) {
	for(Trend t : trends){
		if(t.getId() == id){
			trends.remove(t);
		}
	}
	}

	@Override
	public void delete(Trend object) {
		trends.remove(object);
	}

	@Override
	public Trend findById(int id) {
		for(Trend t : trends){
			if(t.getId() == id){
				return t;
			}
		}
		return null;
	}

	@Override
	public Trend update(Trend object) {
		if(findById(object.getId()) != null){
			for(Trend t : trends){
				if(t.getId() == object.getId()){
					trends.remove(t);
					trends.add(object);
					return object;
				}
			}
		}
		return null;
	}
}
