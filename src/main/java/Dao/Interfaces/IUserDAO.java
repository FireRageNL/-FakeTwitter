package Dao.Interfaces;


import Entities.Account;

public interface IUserDAO extends IGenericDAO<Account> {

	int countUsers();

	Account findByUsername(String username);


}
