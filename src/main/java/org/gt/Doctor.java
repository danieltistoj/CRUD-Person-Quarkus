package org.gt;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;

@Entity
public class Doctor extends PanacheEntity {
    public String qualification;
    public String specialty;

}
