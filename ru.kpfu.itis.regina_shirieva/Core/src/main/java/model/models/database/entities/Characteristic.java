package model.models.database.entities;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Access(value = AccessType.PROPERTY)
@Table(name = "Characteristics", uniqueConstraints = {
        @UniqueConstraint(columnNames = "name")
})
public class Characteristic extends AEntity {
    private String name;
    private List<CharacteristicValue> value;

    protected Characteristic(){}

    @Column(name = "name", nullable = false)
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

    @Override
    public int hashCode() {
        return 2*Objects.hash(getName());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Characteristic)) return false;
        if (this == obj) return true;
        Characteristic another = (Characteristic) obj;
        return getName().equals(another.getName());
    }
}
