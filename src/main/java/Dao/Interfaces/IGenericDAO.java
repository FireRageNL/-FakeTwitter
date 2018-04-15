package Dao.Interfaces;

import java.util.List;

public interface IGenericDAO<T> {

    T add(T object);

    void deleteById(int id);

    void delete(T object);

    T findById(int id);

    T update(T object);

}
