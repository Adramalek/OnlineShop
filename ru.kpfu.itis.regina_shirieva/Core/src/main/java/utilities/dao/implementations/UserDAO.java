package utilities.dao.implementations;

import com.sun.istack.internal.NotNull;
import models.User;
import org.hibernate.HibernateException;
import org.hibernate.Transaction;
import utilities.dao.interfaces.IUserDAO;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UserDAO extends ABaseDAO<User,Long> implements IUserDAO {

    private static UserDAO instance;

    static {
        instance = new UserDAO(User.class);
    }

    private UserDAO(Class<User> type) {
        super(type);
    }

    public static UserDAO getInstance(){
        return instance;
    }

    public User find(@NotNull String nickName) {
        return (User) currentSession.createQuery("from User where nickName=:nickname")
                .setParameter("nickname",nickName).list().get(0);
    }

    @SuppressWarnings("unchecked")
    public Collection<User> find() {
        final List<User> result = new ArrayList<>();
        List tmp = currentSession.createQuery("from User").list();
        tmp.forEach((u) -> result.add((User)u));
        return result;
    }

    public boolean delete() {
        Transaction transaction = currentSession.beginTransaction();
        try {
            currentSession.createQuery("delete from User").executeUpdate();
            transaction.commit();
            return true;
        } catch (HibernateException e){
            e.printStackTrace();
            transaction.rollback();
            return false;
        }
    }
}
