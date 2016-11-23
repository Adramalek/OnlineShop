package controller.services.interfaces;

import com.sun.istack.internal.NotNull;
import model.models.database.entities.User;

public interface IUserService extends IHttpBasedService {
    void add(@NotNull User user);
    void makeAdmin(@NotNull Long userId);
    boolean delete(@NotNull Long userId);
    boolean ban(@NotNull Long userId);
}