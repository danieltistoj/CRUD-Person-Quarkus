package org.gt.Repository;


import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import org.gt.DTO.PersonDTO;
import org.gt.Entity.PersonEntity;

import java.util.List;

@ApplicationScoped
public class PersonRepository implements PanacheRepository <PersonEntity>{
    @Transactional
    public   void createPerson(PersonEntity person){
        persist(person);
    }
    public  PersonEntity findByName(String name){
        return find("name",name).firstResult();
    }
    @Transactional
    public void updatePerson(PersonEntity updatePersonEntity,PersonEntity personEntity) {
        updatePersonEntity.setName(personEntity.getName());
        updatePersonEntity.setPhone(personEntity.getPhone());
        updatePersonEntity.setDirection(personEntity.getDirection());
        updatePersonEntity.setDate(personEntity.getDate());
    }
}
