package model.models.database.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Access(value = AccessType.PROPERTY)
@Table(name = "Products", uniqueConstraints = {
        @UniqueConstraint(columnNames = "name")
})
public class Product extends AEntity {
    private String info;
    private String name;
    private BigDecimal price;
    private String imageURL;
    private Date appearanceDate;
    private Integer quantity;
    private List<CharacteristicValue> characteristics;
    private List<ProductPack> packs;

    public Product() {}

    @Column(name = "info")
    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Column(name = "name", nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "price", nullable = false)
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Column(name = "image_url", nullable = false)
    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    @Column(name = "appearance_date", nullable = false)
    public Date getAppearanceDate() {
        return appearanceDate;
    }

    public void setAppearanceDate(Date appearanceDate) {
        this.appearanceDate = appearanceDate;
    }

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "Product_Characteristics",
            joinColumns = @JoinColumn(name = "characteristic_value_id", referencedColumnName = "id", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "product_id", referencedColumnName = "id", nullable = false)
    )
    public List<CharacteristicValue> getCharacteristics() {
        return characteristics;
    }

    public void setCharacteristics(List<CharacteristicValue> characteristics) {
        this.characteristics = characteristics;
    }

    @Column(name = "quantity", nullable = false)
    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @OneToMany(mappedBy = "product")
    public List<ProductPack> getPacks() {
        return packs;
    }

    public void setPacks(List<ProductPack> packs) {
        this.packs = packs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !(o instanceof Product)) return false;
        Product product = (Product) o;
        return Objects.equals(getName(), product.getName());
    }

    @Override
    public int hashCode() {
        return 3*Objects.hash(getName());
    }
}