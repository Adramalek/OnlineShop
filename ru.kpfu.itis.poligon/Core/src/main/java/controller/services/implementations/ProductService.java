package controller.services.implementations;

import com.sun.istack.internal.NotNull;
import controller.services.interfaces.IProductService;
import model.cache.ICache;
import model.models.database.entities.Product;

public class ProductService extends ABaseService<Product> implements IProductService {


    public ProductService(@NotNull ICache cache) {
        super(cache);
    }

    @Override
    public boolean modify(Long productID) {
        return false;
    }

    @Override
    public boolean add(Long productID) {
        return false;
    }

    @Override
    public boolean delete(Long productID) {
        return false;
    }

    @Override
    public boolean addToCart(Long productID, Long userID) {
        return false;
    }
}
