package DAL.Implementations;

import DAL.Interfaces.IUserDAO;
import entities.User;

import java.util.concurrent.CopyOnWriteArrayList;

public class UserCollectionDAO implements IUserDAO{

	CopyOnWriteArrayList<User> userList = new CopyOnWriteArrayList<User>();


	public User add(User object) {
		userList.add(object);
		return object;
	}

	public void deleteById(int id) {
		for (User usr : userList) {
			if(usr.getId() == id){
				userList.remove(usr);
			}
		}
	}

	public void delete(User object) {
		userList.remove(object);
	}

	public User findById(int id) {
		for(User usr : userList){
			if(usr.getId() == id){
				return usr;
			}
		}
		return null;
	}

	public User update(User object) {
		if(findById(object.getId()) != null){
			for(User usr : userList){
				if(usr.getId() == object.getId()){
					userList.remove(usr);
					userList.add(object);
					return object;
				}
			}
		}
		return null;
	}

	public int countUsers() {
		return userList.size();
	}

	public User findByUsername(String username) {
		for(User usr : userList){
			if(usr.getUsername() == username){
				return usr;
			}
		}
		return null;
	}
}
