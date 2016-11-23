package model.models.database.entities;

import javax.persistence.*;

@Entity
@Table(name = "Carts")
@Access(value = AccessType.PROPERTY)
public class ProductPack extends AEntity {
    private Integer productCount;
    private Product product;
    private User user;

    public ProductPack() {}

    @Column(name = "quantity", nullable = false)
    public Integer getProductCount() {
        return productCount;
    }

    public void setProductCount(Integer productCount) {
        this.productCount = productCount;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", referencedColumnName = "id", nullable = false)
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
