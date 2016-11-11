package utilities.dao.interfaces;

import com.sun.istack.internal.NotNull;
import models.User;

public interface IUserDAO extends IBaseDAO<User, Long> {
    User find(@NotNull String nickName);
}
