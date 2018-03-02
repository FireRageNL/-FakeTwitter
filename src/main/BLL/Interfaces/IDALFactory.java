package BLL.Interfaces;

import DAL.Implementations.UserCollectionDAO;

public interface IDALFactory {

	UserCollectionDAO getUserCollectionDAO();
}
