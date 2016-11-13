package model.models.database.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;

@Entity
@Table(name = "Cards")
@Access(value = AccessType.PROPERTY)
public class Card extends AEntity{
    private CardType type;
    private String owner;
    private Date giveDate;
    private Date expireDate;
    private BigDecimal availableMoney;
    private User user;

    public Card() {}

    @Column(columnDefinition = "enum('VISA','MASTERCARD')", nullable = false)
    @Enumerated(value = EnumType.STRING)
    public CardType getType() {
        return type;
    }

    public void setType(CardType type) {
        this.type = type;
    }

    @Column(name = "owner", nullable = false)
    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    @Column(name = "give_date", nullable = false)
    public Date getGiveDate() {
        return giveDate;
    }

    public void setGiveDate(Date giveDate) {
        this.giveDate = giveDate;
    }

    @Column(name = "expire_date")
    public Date getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Date expireDate) {
        if (expireDate != null && giveDate.compareTo(expireDate) == 1) return;
        this.expireDate = expireDate;
    }

    @Column(name = "available_money", nullable = false)
    public BigDecimal getAvailableMoney() {
        return availableMoney;
    }

    public void setAvailableMoney(BigDecimal availableMoney) {
        this.availableMoney = availableMoney;
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
