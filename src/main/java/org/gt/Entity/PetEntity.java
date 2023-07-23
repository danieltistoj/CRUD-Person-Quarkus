package org.gt.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name="Pet")
public class PetEntity  {
    @Id
    @GeneratedValue
    @JsonIgnore
    private Long id;
    private String name;
    private String race;
    @Column(nullable = true)
    private int age;
    @ManyToOne
    @JoinColumn(name="personId")
    @JsonBackReference
    private PersonEntity person;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public PersonEntity getPerson() {
        return person;
    }

    public void setPerson(PersonEntity person) {
        this.person = person;
    }
}
