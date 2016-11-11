package utilities.dao.interfaces;

import com.sun.istack.internal.NotNull;
import models.AEntity;

import java.io.Serializable;
import java.util.Collection;

public interface IBaseDAO<E extends AEntity, ID extends Serializable> {
    E find(@NotNull ID id);
    Collection<E> find();
    boolean create(@NotNull E entity);
    boolean create(@NotNull Collection<E> entities);
    boolean update(@NotNull E entity);
    boolean update(@NotNull Collection<E> entities);
    boolean delete();
    boolean delete(@NotNull E entity);
    boolean delete(@NotNull Collection<E> entities);
}
