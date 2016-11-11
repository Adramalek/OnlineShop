package utilities.dao.implementations;

import com.sun.istack.internal.NotNull;
import models.Product;
import org.hibernate.HibernateException;
import org.hibernate.Transaction;
import utilities.dao.interfaces.IProductDAO;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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
        List<Product> products = new ArrayList<>();
        List tmp = currentSession.createQuery("from Product where price=:price").setParameter("price",price).list();
        tmp.forEach((p) -> products.add((Product)p));
        return products;
    }

    @SuppressWarnings("unchecked")
    public Collection<Product> find(@NotNull Date appearanceDate) {
        List<Product> products = new ArrayList<>();
        List tmp = currentSession.createQuery("from Product where appearanceDate=:appearanceDate")
                .setParameter("appearanceDate",appearanceDate).list();
        tmp.forEach((p) -> products.add((Product)p));
        return products;
    }

    @SuppressWarnings("unchecked")
    public Collection<Product> find() {
        List<Product> products = new ArrayList<>();
        List tmp = currentSession.createQuery("from Product").list();
        tmp.forEach((p) -> products.add((Product)p));
        return products;
    }

    public boolean delete() {
        Transaction transaction = currentSession.beginTransaction();
        try {
            currentSession.createQuery("delete from Product").executeUpdate();
            transaction.commit();
            return true;
        } catch (HibernateException e){
            e.printStackTrace();
            transaction.rollback();
            return false;
        }
    }
}
