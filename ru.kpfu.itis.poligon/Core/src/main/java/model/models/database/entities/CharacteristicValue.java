package model.models.database.entities;

import javax.persistence.*;

@Entity
@Table(name = "Characteristic_Values")
@Access(value = AccessType.PROPERTY)
public class CharacteristicValue extends AEntity {
    private String value;
    private Characteristic characteristic;

    public CharacteristicValue() {}

    @Column(name = "value", nullable = false)
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "characteristic_id", referencedColumnName = "id", nullable = false)
    public Characteristic getCharacteristic() {
        return characteristic;
    }

    public void setCharacteristic(Characteristic characteristic) {
        this.characteristic = characteristic;
    }
}
