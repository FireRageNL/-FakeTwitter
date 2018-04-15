package Dao.Interfaces;


import Entities.Account;

import java.util.List;

public interface IUserDAO extends IGenericDAO<Account> {

	int countUsers();

	Account findByUsername(String username);

	List<Account> getAll();
}
