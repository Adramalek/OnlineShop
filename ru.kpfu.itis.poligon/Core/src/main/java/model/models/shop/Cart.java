package model.models.shop;

import com.sun.istack.internal.NotNull;
import model.models.database.entities.Card;
import model.models.database.entities.Product;
import model.models.shop.exceptions.NotEnoughMoney;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Cart {
    private Long userID;
    private Card card;
    private BigDecimal totalPrice;
    private Map<Product, Integer> selectedProducts;

    public Cart(Long userID) {
        this.userID = userID;
        selectedProducts = new HashMap<>();
        totalPrice = BigDecimal.ZERO;
    }

    public Cart(Long userID, Map<Product, Integer> selectedProducts){
        this.userID = userID;
        this.selectedProducts = selectedProducts;
        this.totalPrice = selectedProducts.entrySet().stream()
                .map(entry -> entry.getKey().getPrice().multiply(BigDecimal.valueOf(entry.getValue())))
                .reduce(BigDecimal.ZERO,BigDecimal::add);
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public Map<Product, Integer> getProducts() {
        return selectedProducts;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(@NotNull Card card) {
        this.card = card;
    }

    public boolean isEmpty(){
        return selectedProducts.isEmpty();
    }

    public void put(@NotNull Product product, @NotNull Integer quantity){
        selectedProducts.put(product,quantity);
        totalPrice = totalPrice.add(BigDecimal.valueOf(quantity).multiply(product.getPrice()));
    }

    public boolean pay(@NotNull Product product, int quantity) throws NotEnoughMoney{
        if (!selectedProducts.containsKey(product)) return false;
        if (selectedProducts.get(product) < quantity) return false;
        BigDecimal price = product.getPrice().multiply(BigDecimal.valueOf(quantity));
        if (card.getAvailableMoney().compareTo(price) == -1) throw new NotEnoughMoney();
        int rest = selectedProducts.get(product)-quantity;
        if (rest == 0) selectedProducts.remove(product);
        else {
            selectedProducts.replace(product,rest);
            card.setAvailableMoney(card.getAvailableMoney().add(price.negate()));
        }
        return true;
    }

    public void payAll() throws NotEnoughMoney{
        if (card.getAvailableMoney().compareTo(totalPrice) == -1) throw new NotEnoughMoney();
        selectedProducts.clear();
        card.setAvailableMoney(card.getAvailableMoney().add(totalPrice.negate()));
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || !(o instanceof Cart)) return false;
        if (this == o) return true;
        Cart card = (Cart) o;
        return Objects.equals(userID, card.userID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userID);
    }
}