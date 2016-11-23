package model.models.database.utilities.dao.implementations;

import com.sun.istack.internal.NotNull;
import model.models.database.entities.Characteristic;
import model.models.database.entities.Product;
import model.models.database.utilities.dao.aspects.marks.Transactional;
import model.models.database.utilities.dao.interfaces.IProductDAO;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;

public class ProductDAO extends ABaseDAO<Product, Long> implements IProductDAO {

    private static ProductDAO instance;

    static {
        instance = new ProductDAO(Product.class);
    }

    private ProductDAO(Class<Product> type) {
        super(type);
    }

    public static ProductDAO getInstance() {
        return instance;
    }

    public Product find(@NotNull String name) {
        return (Product) currentSession.createQuery("from Product where name=:name")
                .setParameter("name",name).list().get(0);
    }

    @SuppressWarnings("unchecked")
    public Collection<Product> find(@NotNull BigDecimal price) {
        Collection<Product> products = new ArrayList<>();
        currentSession.createQuery("from Product where price=:price")
                .setParameter("price",price).list().forEach((p) -> products.add((Product)p));
        return products;
    }

    @SuppressWarnings("unchecked")
    public Collection<Product> find(@NotNull Date appearanceDate) {
        Collection<Product> products = new ArrayList<>();
        currentSession.createQuery("from Product where appearanceDate=:appearanceDate")
                .setParameter("appearanceDate",appearanceDate).list().forEach((p) -> products.add((Product)p));
        return products;
    }

    @SuppressWarnings("unchecked")
    public Collection<Product> find() {
        Collection<Product> products = new ArrayList<>();
        currentSession.createQuery("from Product").list().forEach((p) -> products.add((Product)p));
        return products;
    }

    @Override
    @Transactional
    public boolean delete() {
        currentSession.createQuery("delete from Product").executeUpdate();
        return true;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Collection<Product> find(@NotNull Characteristic characteristic) {
        Collection<Product> result = new ArrayList<>();
        currentSession.createQuery("from Product p where :characteristic in p.characteristics")
                .setParameter("characteristic",characteristic).list().forEach((o) -> result.add((Product)o));
        return result;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Collection<Product> find(@NotNull Collection<Characteristic> characteristics) {
        Collection<Product> result = new ArrayList<>();
        currentSession.createQuery("from Product p inner join p.characteristics ch where ch in :characteristics")
                .setParameter("characteristics",characteristics).list().forEach((o) -> result.add((Product)o));
        return result;
    }

    @Override
    @Transactional
    public boolean delete(@NotNull Collection<Product> entities) {
        currentSession.createQuery("delete from Product p where p in :products")
                .setParameter("products",entities).executeUpdate();
        return true;
    }
}