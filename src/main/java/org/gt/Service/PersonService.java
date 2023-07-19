package org.gt.Service;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.gt.DTO.PersonDTO;
import org.gt.Entity.PersonEntity;
import org.gt.Repository.PersonRepository;

import java.util.List;
@ApplicationScoped
public class PersonService {

    @Transactional
    public  boolean savePerson(PersonDTO person) {
       PersonEntity newPerson = new PersonEntity();
        if(PersonRepository.findByName(person.getName())==null){
            newPerson.setName(person.getName());
            newPerson.setDate(person.getDate());
            newPerson.setDirection(person.getDirection());
            newPerson.setPhone(person.getPhone());

            PersonRepository.createPerson(newPerson);
            return true;
        }

       return false;
    }

    @Transactional
    public void updatePerson(PersonDTO person) {
        // Logic to update the person in the database
    }

    @Transactional
    public void deletePerson(Long id) {
        // Logic to delete the person from the database
    }

    public PersonDTO findPersonById(Long id) {
        return null;
    }

    public List<PersonDTO> findAllPerson() {
        return null;
    }
}
