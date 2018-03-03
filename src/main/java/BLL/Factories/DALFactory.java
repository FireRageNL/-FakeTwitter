package BLL.Factories;

import BLL.Interfaces.IDALFactory;
import DAL.Implementations.UserCollectionDAO;

public class DALFactory implements IDALFactory {

	private UserCollectionDAO uCollectionDAO;

	public  UserCollectionDAO getUserCollectionDAO() {
		if(uCollectionDAO == null){
			uCollectionDAO = new UserCollectionDAO();
		}
		return uCollectionDAO;
	}
}
