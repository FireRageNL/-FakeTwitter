package DAL.Implementations;

import DAL.Interfaces.IGenericDAO;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class GenericDAO<T> implements IGenericDAO<T> {

    @PersistenceContext(name = "Kwetter")
    protected EntityManager em;

    private Class<T> type;

    public T add(T object) {
     em.persist(object);
     return object;
    }

    public void delete(T object){
        em.remove(object);
    }

    public void deleteById(int id){
        T toDelete = findById(id);
        em.remove(toDelete);
    }

    public T findById(int id){
        return em.find(type,id);
    }

    public T update(T object){
        return em.merge(object);
    }
}
