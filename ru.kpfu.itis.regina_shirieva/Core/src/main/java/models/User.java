package models;

import javax.persistence.*;
import java.util.List;

@Entity
@Access(value = AccessType.PROPERTY)
@Table(name = "Users", uniqueConstraints = {
        @UniqueConstraint(columnNames = "email"),
        @UniqueConstraint(columnNames = "nickname")
})
public class User extends AEntity {
    private Boolean isAdmin;
    private String email;
    private String hashPassword;
    private String name;
    private String surname;
    private String nickName;
    private List<Product> card;

    public User() {}

    @Column
    public Boolean getAdmin() {
        return isAdmin;
    }

    public void setAdmin(Boolean admin) {
        isAdmin = admin;
    }

    @Column
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column
    public String getHashPassword() {
        return hashPassword;
    }

    public void setHashPassword(String hashPassword) {
        this.hashPassword = hashPassword;
    }

    @Column
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Column
    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    @ManyToMany(mappedBy = "buyers", fetch = FetchType.LAZY)
    public List<Product> getCard() {
        return card;
    }

    public void setCard(List<Product> card) {
        this.card = card;
    }
}
