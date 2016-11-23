package controller.services.interfaces;

public interface IProductService extends IBaseService {
    boolean modify(Long productID);
    boolean add(Long productID);
    boolean delete(Long productID);
    boolean addToCart(Long productID, Long userID);
}
