package model.cache;

import java.util.Collection;

public interface ICahce {
    <T> float save(T o);
    Object load(float id);
    <T> Collection<T> load(Class<T> type);
    void clear();
}
