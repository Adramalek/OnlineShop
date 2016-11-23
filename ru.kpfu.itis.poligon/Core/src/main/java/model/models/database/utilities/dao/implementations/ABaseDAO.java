package model.models.database.utilities.dao.implementations;

import com.sun.istack.internal.NotNull;
import model.models.database.utilities.dao.aspects.marks.Transactional;
import model.models.database.utilities.dao.interfaces.IBaseDAO;
import model.models.database.utilities.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import model.models.database.entities.AEntity;

import java.io.Serializable;
import java.util.Collection;

public abstract class ABaseDAO<E extends AEntity, ID extends Serializable> implements IBaseDAO<E,ID> {

    private SessionFactory sessionFactory;
    protected Session currentSession;

    private Class<E> type;

    ABaseDAO(Class<E> type){
        this.type = type;
        sessionFactory = HibernateUtil.getSessionFactory();
    }

    public void openSession(){
        currentSession = sessionFactory.openSession();
    }

    public void closeSession(){
        currentSession.close();
    }

    @Transactional
    public boolean create(@NotNull E entity) {
        currentSession.save(entity);
        return true;
    }

    @Transactional
    public boolean create(@NotNull Collection<E> entities) {
        for (E entity : entities) currentSession.save(entity);
        return true;
    }

    public E find(@NotNull ID id) {
        return currentSession.load(type,id);
    }

    @Transactional
    public boolean update(@NotNull E entity) {
        currentSession.update(entity);
        return true;
    }

    @Override
    @Transactional
    public boolean update(@NotNull Collection<E> entities) {
        for (E entity : entities) currentSession.update(entity);
        return true;
    }

    @Transactional
    public boolean delete(@NotNull E entity) {
        currentSession.delete(entity);
        return true;
    }
}