package controller.services.implementations;

import com.sun.istack.internal.NotNull;
import controller.services.interfaces.IHttpBasedService;
import model.cache.ICache;

import javax.servlet.http.HttpSession;

public abstract class AHttpBasedService<A> extends ABaseService<A> implements IHttpBasedService {
    protected String attributeName;
    protected HttpSession httpSession;

    public AHttpBasedService(@NotNull String attributeName,
                             @NotNull ICache cache) {
        super(cache);
        this.attributeName = attributeName;
    }

    protected <O> void setAttributeName(O attribute){
        httpSession.setAttribute(attributeName, attribute);
    }
}
