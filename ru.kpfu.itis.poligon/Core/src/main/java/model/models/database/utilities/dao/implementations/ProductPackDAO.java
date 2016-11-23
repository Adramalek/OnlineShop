package model.models.database.utilities.dao.implementations;

import com.sun.istack.internal.NotNull;
import model.models.database.entities.ProductPack;
import model.models.database.entities.User;
import model.models.database.utilities.dao.aspects.marks.Transactional;
import model.models.database.utilities.dao.interfaces.IProductPackDAO;

import java.util.ArrayList;
import java.util.Collection;

public class ProductPackDAO extends ABaseDAO<ProductPack,Long> implements IProductPackDAO {
    private static ProductPackDAO instance;

    static {
        instance = new ProductPackDAO(ProductPack.class);
    }

    private ProductPackDAO(Class<ProductPack> type) {
        super(type);
    }

    public static ProductPackDAO getInstance() {
        return instance;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Collection<ProductPack> find() {
        Collection<ProductPack> result = new ArrayList<>();
        currentSession.createQuery("from ProductPack").list().forEach((o) -> result.add((ProductPack)o));
        return result;
    }

    @Override
    @Transactional
    public boolean delete() {
        currentSession.createQuery("delete from ProductPack").executeUpdate();
        return true;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Collection<ProductPack> find(@NotNull User user) {
        Collection<ProductPack> result = new ArrayList<>();
        currentSession.createQuery("from ProductPack p where p.user=:user")
                .setParameter("user",user).list().forEach((o) -> result.add((ProductPack)o));
        return result;
    }

    @Override
    @Transactional
    public boolean delete(@NotNull Collection<ProductPack> entities) {
        currentSession.createQuery("delete from ProductPack pp where pp in :pack")
                .setParameter("pack",entities).executeUpdate();
        return true;
    }
}
