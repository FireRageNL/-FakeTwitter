package Dao.Interfaces;

import entities.User;

public interface IUserDAO extends IGenericDAO<User> {

	int countUsers();

	User findByUsername(String username);
}
