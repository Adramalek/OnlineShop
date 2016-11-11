package models;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;
import java.util.Map;

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
    private List<User> buyers;
    private List<CharacteristicValue> characteristics;

    public Product() {}

    @Column
    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Column
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Column
    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    @Column
    public Date getAppearanceDate() {
        return appearanceDate;
    }

    public void setAppearanceDate(Date appearanceDate) {
        this.appearanceDate = appearanceDate;
    }

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "Card",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "product_id", referencedColumnName = "id")
    )
    public List<User> getBuyers() {
        return buyers;
    }

    public void setBuyers(List<User> buyers) {
        this.buyers = buyers;
    }

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "Product_Characteristics",
            joinColumns = @JoinColumn(name = "characteristic_value_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "product_id", referencedColumnName = "id")
    )
    public List<CharacteristicValue> getCharacteristics() {
        return characteristics;
    }

    public void setCharacteristics(List<CharacteristicValue> characteristics) {
        this.characteristics = characteristics;
    }
}
