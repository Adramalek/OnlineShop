package model.models.database.utilities.dao.implementations;

import com.sun.istack.internal.NotNull;
import model.models.database.entities.User;
import model.models.database.utilities.dao.aspects.marks.Transactional;
import model.models.database.utilities.dao.interfaces.IUserDAO;

import java.util.ArrayList;
import java.util.Collection;

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
        Collection<User> result = new ArrayList<>();
        currentSession.createQuery("from User").list().forEach((u) -> result.add((User)u));
        return result;
    }

    @Override
    @Transactional
    public boolean delete() {
        currentSession.createQuery("delete from User").executeUpdate();
        return true;
    }

    @Override
    @Transactional
    public boolean delete(@NotNull Collection<User> entities) {
        currentSession.createQuery("delete from User u where u in :users")
                .setParameter("users",entities).executeUpdate();
        return true;
    }
}
