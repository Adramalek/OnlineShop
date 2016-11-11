package models;

import javax.persistence.*;
import java.util.List;

@Entity
@Access(value = AccessType.PROPERTY)
@Table(name = "Characteristics", uniqueConstraints = {
        @UniqueConstraint(columnNames = "name")
})
public class Characteristic extends AEntity {
    private String name;
    private List<CharacteristicValue> value;

    protected Characteristic(){}

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(mappedBy = "characteristic")
    public List<CharacteristicValue> getValue() {
        return value;
    }

    public void setValue(List<CharacteristicValue> value) {
        this.value = value;
    }
}
