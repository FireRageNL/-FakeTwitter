package Logic.Interfaces;


import Dao.Interfaces.IUserDAO;

public interface IDALFactory {

	IUserDAO getUserDAO();
}
