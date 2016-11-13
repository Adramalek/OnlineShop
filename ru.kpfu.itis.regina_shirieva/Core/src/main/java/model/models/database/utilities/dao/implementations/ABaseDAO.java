package model.models.database.utilities.dao.implementations;

import com.sun.istack.internal.NotNull;
import model.models.database.utilities.dao.interfaces.IBaseDAO;
import model.models.database.utilities.utils.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
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

    public boolean create(@NotNull E entity) {
        Transaction transaction = currentSession.beginTransaction();
        try {
            currentSession.save(entity);
            transaction.commit();
            return true;
        } catch (HibernateException e){
            e.printStackTrace();
            transaction.rollback();
            return false;
        }
    }

    public boolean create(@NotNull Collection<E> entities) {
        Transaction transaction = currentSession.beginTransaction();
        try {
            for (E entity : entities) currentSession.save(entity);
            transaction.commit();
            return true;
        } catch (HibernateException e){
            e.printStackTrace();
            transaction.rollback();
            return false;
        }
    }

    public E find(@NotNull ID id) {
        return currentSession.load(type,id);
    }

    public boolean update(@NotNull E entity) {
        Transaction transaction = currentSession.beginTransaction();
        try {
            currentSession.update(entity);
            transaction.commit();
            return true;
        } catch (HibernateException e){
            e.printStackTrace();
            transaction.rollback();
            return false;
        }
    }

    public boolean update(@NotNull Collection<E> entities) {
        Transaction transaction = currentSession.beginTransaction();
        try {
            for (E entity : entities) currentSession.update(entity);
            transaction.commit();
            return true;
        } catch (HibernateException e){
            e.printStackTrace();
            transaction.rollback();
            return false;
        }
    }

    public boolean delete(@NotNull E entity) {
        Transaction transaction = currentSession.beginTransaction();
        try {
            currentSession.delete(entity);
            transaction.commit();
            return true;
        } catch (HibernateException e){
            e.printStackTrace();
            transaction.rollback();
            return false;
        }
    }

    public boolean delete(@NotNull Collection<E> entities) {
        Transaction transaction = currentSession.beginTransaction();
        try {
            for (E entity : entities) currentSession.delete(entity);
            transaction.commit();
            return true;
        } catch (HibernateException e){
            e.printStackTrace();
            transaction.rollback();
            return false;
        }
    }
}