package controller.services.interfaces;

import com.sun.istack.internal.NotNull;

import javax.servlet.http.HttpSession;

public interface IHttpBasedService extends IBaseService {
    void init(@NotNull HttpSession session);
}
