package model.models.database.utilities.dao.interfaces;

import com.sun.istack.internal.NotNull;
import model.models.database.entities.User;

public interface IUserDAO extends IBaseDAO<User, Long> {
    User find(@NotNull String nickName);
}
