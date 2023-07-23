package org.gt.Service;


import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.gt.DTO.PersonDTO;
import org.gt.Entity.PersonEntity;
import org.gt.Repository.PersonRepository;

import java.util.ArrayList;
import java.util.List;
@ApplicationScoped
public class PersonService {
    @Inject
    private PersonRepository personRepository;
    @Transactional
    public  boolean savePerson(PersonEntity person) {

        if(personRepository.findByName(person.getName())==null){
            personRepository.createPerson(person);
            return true;
        }

       return false;
    }
    public PersonEntity findPersonByName(String name){
        return personRepository.findByName(name);
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
        if(personEntity!=null){
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

}
