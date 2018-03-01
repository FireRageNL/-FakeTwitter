package DAL.Interfaces;

public interface IGenericDAO<T> {

    T add(T object);

    void deleteById(int id);

    void delete(T object);

    T findbyId(int id);

    T update(T object);

}
