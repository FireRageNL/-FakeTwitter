package Dao.Implementations.Collections;

import Dao.Interfaces.IUserDAO;
import Entities.Account;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class UserCollectionDAO implements IUserDAO {

	CopyOnWriteArrayList<Account> accountList = new CopyOnWriteArrayList<>();


	public Account add(Account object) {
		accountList.add(object);
		return object;
	}

	public void deleteById(int id) {
		for (Account usr : accountList) {
			if(usr.getId() == id){
				accountList.remove(usr);
			}
		}
	}

	public void delete(Account object) {
		accountList.remove(object);
	}

	public Account findById(int id) {
		for(Account usr : accountList){
			if(usr.getId() == id){
				return usr;
			}
		}
		return null;
	}

	public Account update(Account object) {
		if(findById(object.getId()) != null){
			for(Account usr : accountList){
				if(usr.getId() == object.getId()){
					accountList.remove(usr);
					accountList.add(object);
					return object;
				}
			}
		}
		return null;
	}

	@Override
	public List<Account> getAll() {
		return accountList;
	}

	public int countUsers() {
		return accountList.size();
	}

	public Account findByUsername(String username) {
		for(Account usr : accountList){
			if(usr.getUsername() == username){
				return usr;
			}
		}
		return null;
	}
}
