package org.gt.DTO;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.gt.Entity.PetEntity;

import java.util.ArrayList;
import java.util.List;

public class PersonDTO {
    private String name;
    private String date;

    private String direction;

    private String phone;
    private List<PetEntity> pets = new ArrayList<>();

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
