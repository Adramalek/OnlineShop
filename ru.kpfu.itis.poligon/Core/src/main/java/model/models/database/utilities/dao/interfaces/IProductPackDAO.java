package model.models.database.utilities.dao.interfaces;

import com.sun.istack.internal.NotNull;
import model.models.database.entities.ProductPack;
import model.models.database.entities.User;

import java.util.Collection;

public interface IProductPackDAO extends IBaseDAO<ProductPack, Long> {
    Collection<ProductPack> find(@NotNull User user);
}
