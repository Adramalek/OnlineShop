package model.models.database.entities;

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
    private List<ProductPack> card;

    public User() {}

    @Column(name = "is_admin", nullable = false)
    public Boolean getAdmin() {
        return isAdmin;
    }

    public void setAdmin(Boolean admin) {
        isAdmin = admin;
    }

    @Column(name = "email", nullable = false)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "hash_password", nullable = false)
    public String getHashPassword() {
        return hashPassword;
    }

    public void setHashPassword(String hashPassword) {
        this.hashPassword = hashPassword;
    }

    @Column(name = "name", nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "surname", nullable = false)
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Column(name = "nickname", nullable = false)
    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    public List<ProductPack> getCard() {
        return card;
    }

    public void setCard(List<ProductPack> card) {
        this.card = card;
    }
}
