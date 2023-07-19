package org.gt.Repository;


import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import org.gt.DTO.PersonDTO;
import org.gt.Entity.PersonEntity;

import java.util.List;

@ApplicationScoped
public class PersonRepository{
    @Transactional
    public   void createPerson(PersonEntity person){
        PersonEntity.persist(person);
    }
    public  PersonEntity findByName(String name){
        return PersonEntity.find("name",name).firstResult();
    }
    public List<PersonEntity> allPerson() {
        return PersonEntity.listAll();
    }
    public PersonEntity findById(Long id){
        return PersonEntity.findById(id);
    }
    @Transactional
    public void deletePersona(Long id) {
        PersonEntity.deleteById(id);
    }
    @Transactional
    public void updatePerson(PersonEntity personEntity,PersonDTO personDTO) {
        personEntity.setName(personDTO.getName());
        personEntity.setPhone(personDTO.getPhone());
        personEntity.setDirection(personDTO.getDirection());
        personEntity.setDate(personDTO.getDate());
    }
}
