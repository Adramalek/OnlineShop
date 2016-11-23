package model.cache;

import java.util.*;

public class Cache implements ICache {
    private static Cache instance;
    private static int maxCapacity;
    public static final int DEFAULT_MAX_CAPACITY = 256;

    private Queue<Object> ids;
    private Map<Object,Object> cachedObjects;

    static {
        maxCapacity = DEFAULT_MAX_CAPACITY;
        instance = new Cache();
    }

    private Cache() {
        cachedObjects = new HashMap<>();
        ids = new PriorityQueue<>();
    }

    public static Cache getInstance() {
        return instance;
    }

    public static void setMaxCapacity(int maxCapacity) {
        Cache.maxCapacity = maxCapacity;
    }

    @Override
    public <T,K> void save(K key, T object){
        if (cachedObjects.size() < maxCapacity) {
            ids.offer(key);
            cachedObjects.put(key,object);
        }
        else {
            Object oldest = ids.poll();
            cachedObjects.remove(oldest);
            cachedObjects.put(key,object);
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T,K> T load(K key) {
        return (T) cachedObjects.get(key);
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
        ids.clear();
        cachedObjects.clear();
    }
}