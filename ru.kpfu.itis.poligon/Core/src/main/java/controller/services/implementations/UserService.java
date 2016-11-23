package controller.services.implementations;

import com.sun.istack.internal.NotNull;
import controller.services.aspects.marks.Admin;
import controller.services.interfaces.IUserService;
import model.cache.ICache;
import model.models.database.entities.User;
import model.models.shop.Constants;

import javax.servlet.http.HttpSession;

public class UserService extends AHttpBasedService<User> implements IUserService {

    public UserService(@NotNull ICache cache) {
        super(Constants.SESSION_USER, cache);
    }

    @Override
    public void add(@NotNull User user) {

    }

    @Admin
    @Override
    public void makeAdmin(@NotNull Long userId) {

    }

    @Override
    public boolean delete(@NotNull Long userId) {
        return false;
    }

    @Admin
    @Override
    public boolean ban(@NotNull Long userId) {
        return false;
    }
}
