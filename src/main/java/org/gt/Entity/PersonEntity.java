package org.gt.Entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;


@Entity
@Table(name="Person")
public class PersonEntity extends PanacheEntity{

    private String name;
    private String date;

    private String direction;
    @Column(length = 100)
    private String phone;
    @Column(length = 100)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
