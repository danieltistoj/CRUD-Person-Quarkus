package org.gt;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;

import java.util.Date;
@Entity
public class Person extends PanacheEntity {

    public String name;
    public String date;
    @Column(length = 100)
    public String direction;
    @Column(length = 200)
    public String phone;


}
