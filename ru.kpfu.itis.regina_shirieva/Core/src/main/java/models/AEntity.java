package models;

import javax.persistence.*;

@MappedSuperclass
@Access(value = AccessType.PROPERTY)
public abstract class AEntity {
    private Long id;

    AEntity(){}

    @Id
    @Basic
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
