package model.cache;

import java.util.Collection;

public interface ICache {
    <T,K> void save(K key, T object);
    <T,K> T load(K key);
    <T> Collection<T> load(Class<T> type);
    void clear();
}
