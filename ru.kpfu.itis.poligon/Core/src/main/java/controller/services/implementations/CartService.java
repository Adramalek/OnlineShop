package controller.services.implementations;

import com.sun.istack.internal.NotNull;
import controller.services.interfaces.ICartService;
import model.cache.ICache;
import model.models.database.entities.ProductPack;
import model.models.database.utilities.dao.implementations.ProductPackDAO;
import model.models.database.utilities.utils.DAOFactory;
import model.models.shop.Cart;
import model.models.shop.Constants;

import javax.servlet.http.HttpSession;
import java.util.Collection;

public class CartService extends AHttpBasedService<Cart> implements ICartService {
    private Cart cart;
    private ProductPackDAO dao;

    public CartService(@NotNull ICache cache) {
        super(Constants.SESSION_CART,cache);
    }

    @Override
    public void put(@NotNull Long productID, @NotNull Integer quantity) {

    }

    @Override
    public boolean pay() {
        return false;
    }

    @Override
    public boolean pay(@NotNull Long productID) {
        return false;
    }

    @Override
    public boolean pay(@NotNull Long productID, Integer quantity) {
        return false;
    }

    @Override
    public boolean pay(@NotNull Collection<Long> productIDs) {
        return false;
    }

    @Override
    public boolean exclude() {
        return false;
    }

    @Override
    public boolean exclude(@NotNull Long productID) {
        return false;
    }

    @Override
    public void init() {
        if (initialized) return;
        dao = (ProductPackDAO) DAOFactory.getInstance().getDAOFor(ProductPack.class);
    }

    @Override
    public void init(@NotNull HttpSession session) {
        httpSession = session;
        cart = (Cart) session.getAttribute(Constants.SESSION_CART);
        if (cart == null){
            cart = new Cart((Long)session.getAttribute(Constants.SESSION_USER));
        }
    }

    @Override
    public void destroy() {

    }
}