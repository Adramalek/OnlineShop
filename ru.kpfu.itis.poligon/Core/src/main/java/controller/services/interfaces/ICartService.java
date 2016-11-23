package controller.services.interfaces;

import com.sun.istack.internal.NotNull;

import java.util.Collection;

public interface ICartService extends IHttpBasedService {
    void put(@NotNull Long productID,@NotNull Integer quantity);
    boolean pay();
    boolean pay(@NotNull Long productID);
    boolean pay(@NotNull Long productID, Integer quantity);
    boolean pay(@NotNull Collection<Long> productIDs);
    boolean exclude();
    boolean exclude(@NotNull Long productID);
}
