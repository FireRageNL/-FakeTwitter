package Dao.Implementations.JPA;

import Dao.Interfaces.IGenericDAO;
import Dao.Interfaces.KwetterJPA;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.lang.reflect.ParameterizedType;
import java.util.List;


@Stateless
@KwetterJPA
public class GenericDAO<T> implements IGenericDAO<T> {

    @PersistenceContext(unitName = "Kwetter")
    protected EntityManager em;

    private Class<T> type;

    public GenericDAO(){
        ParameterizedType genericSuperClass = (ParameterizedType) getClass().getGenericSuperclass();
        this.type = (Class<T>) genericSuperClass.getActualTypeArguments()[0];
    }
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
