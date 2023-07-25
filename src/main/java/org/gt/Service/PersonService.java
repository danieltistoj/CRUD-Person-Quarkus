package org.gt.Service;


import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import org.gt.DTO.PersonDTO;
import org.gt.Entity.*;
import org.gt.Repository.PersonRepository;
import org.gt.Repository.PetRepository;

import java.util.ArrayList;
import java.util.List;
@ApplicationScoped
public class PersonService {
    @Inject
    private PersonRepository personRepository;
    @Inject
    private PetRepository petRepository;
    @Transactional
    public  boolean savePerson(PersonEntity person) {

        if(personRepository.findByName(person.getName())==null){
            personRepository.createPerson(person);
            return true;
        }

       return false;
    }
    public PersonEntity findPersonByName(String name){

        PersonEntity personEntity = personRepository.findByName(name);
        return personEntity;
    }

    public List<PersonEntity> findAllPerson() {
        return personRepository.listAll();
    }
    public PersonEntity findPersonById(long id){
       return personRepository.findById(id);
    }
    @Transactional
    public boolean deletePersona(Long id) {
        if(personRepository.findById(id)!=null){
            personRepository.deleteById(id);
            return true;
        }
        return false;
    }
    @Transactional
    public boolean updatePerson(long id,PersonEntity personEntity) {
        PersonEntity updatePersonEntity = personRepository.findById(id);
      //  System.out.println(personEntity.getName());
        if(updatePersonEntity!=null){
            if(personEntity.getName()!=null){

                updatePersonEntity.setName(personEntity.getName());

            }
            if(personEntity.getDate()!=null){
                updatePersonEntity.setDate(personEntity.getDate());
            }
            if(personEntity.getDirection()!=null){
                updatePersonEntity.setDirection(personEntity.getDirection());
            }
            if(personEntity.getPhone()!=null){
                updatePersonEntity.setPhone(personEntity.getPhone());
            }
            return true;
        }
        return false;
    }
    public PersonDTO convertEntityToDTO(PersonEntity personEntity){
        PersonDTO personDTO = new PersonDTO();
        personDTO.setName(personEntity.getName());
        personDTO.setDate(personEntity.getDate());
        personDTO.setDirection(personEntity.getDirection());
        personDTO.setPhone(personEntity.getPhone());
        personDTO.setPets(personEntity.getPets());
        return personDTO;
    }

}
