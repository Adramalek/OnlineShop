package model.models.database.utilities.dao.interfaces;

import com.sun.istack.internal.NotNull;
import model.models.database.entities.Product;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.Collection;

public interface IProductDAO extends IBaseDAO<Product, Long> {
    Product find(@NotNull String name);
    Collection<Product> find(@NotNull BigDecimal price);
    Collection<Product> find(@NotNull Date appearanceDate);
}
