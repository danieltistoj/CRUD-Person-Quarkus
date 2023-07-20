package org.gt.Entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="Pet")
public class PetEntity  extends PanacheEntity {
    private String name;
    private String race;
    private int ege;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public int getEge() {
        return ege;
    }

    public void setEge(int ege) {
        this.ege = ege;
    }
}
