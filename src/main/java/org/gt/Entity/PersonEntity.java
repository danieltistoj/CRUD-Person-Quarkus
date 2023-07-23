package org.gt.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name="Person")
public class PersonEntity{
    @Id
    @GeneratedValue
    @JsonIgnore
    private Long id;
    private String name;
    private String date;
    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<PetEntity> pets = new ArrayList<>();
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

    public List<PetEntity> getPets() {
        return pets;
    }

    public void setPets(List<PetEntity> pets) {
        this.pets = pets;
    }
}
