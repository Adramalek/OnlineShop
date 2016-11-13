package model.cache;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Cache implements ICahce {
    private static Cache instance;
    private Map<Float,Object> cachedObjects;

    static {
        instance = new Cache();
    }

    private Cache() {
        cachedObjects = new HashMap<>();
    }

    public static Cache getInstance() {
        return instance;
    }

    private <T> float generateID(T o){
        float classHash = o.getClass().hashCode();
        float objectHash = o.hashCode();
        return 4f*(classHash-objectHash/2f);
    }

    @Override
    public <T> float save(T o){
        float id = generateID(o);
        cachedObjects.put(id,o);
        return id;
    }

    @Override
    public Object load(float id) {
        return cachedObjects.get(id);
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T> Collection<T> load(Class<T> type) {
        Collection<T> result = new ArrayList<>();
        cachedObjects.values().forEach((v) -> { if(v.getClass() == type) result.add((T)v); });
        return result;
    }

    @Override
    public void clear() {
        cachedObjects.clear();
    }
}