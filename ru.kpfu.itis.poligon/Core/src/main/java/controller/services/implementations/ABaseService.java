package controller.services.implementations;

import com.sun.istack.internal.NotNull;
import controller.services.interfaces.IBaseService;
import model.cache.ICache;

import java.util.Collection;

public abstract class ABaseService<A> implements IBaseService {
    protected boolean initialized;
    private ICache cache;

    protected ABaseService(@NotNull ICache cache) {
        this.cache = cache;
        initialized = false;
    }

    protected <K> void saveInCache(@NotNull K key, @NotNull A object){
        cache.save(key,object);
    }

    protected <K> A loadFromCache(@NotNull K key){
        return cache.load(key);
    }

    protected Collection<A> loadAllFromCache(@NotNull Class<A> type){
        return cache.load(type);
    }
}
