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
    public  boolean savePerson(PersonDTO person) {
       PersonEntity newPerson = new PersonEntity();
        if(personRepository.findByName(person.getName())==null){
            newPerson.setName(person.getName());
            newPerson.setDate(person.getDate());
            newPerson.setDirection(person.getDirection());
            newPerson.setPhone(person.getPhone());

            personRepository.createPerson(newPerson);
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

    public List<PersonDTO> findAllPerson() {
        List<PersonEntity> personEntityList = personRepository.allPerson();
        List<PersonDTO> personDTOList = new ArrayList<>();
        for(PersonEntity person:personEntityList){

            personDTOList.add(convertEntityToEdo(person));
        }
        return personDTOList;
    }
    public PersonDTO findPersonById(long id){
        PersonEntity personEntity = personRepository.findById(id);

        if(personEntity!=null){

            return convertEntityToEdo(personEntity);
        }
        return null;
    }
    @Transactional
    public boolean deletePersona(Long id) {
        if(personRepository.findById(id)!=null){
            personRepository.deletePersona(id);
            return true;
        }
        return false;
    }
    @Transactional
    public boolean updatePerson(long id,PersonDTO personDTO) {
        PersonEntity personEntity = personRepository.findById(id);
        if(personEntity!=null){
            personRepository.updatePerson(personEntity,personDTO);
            return true;
        }
        return false;
    }
    private PersonDTO convertEntityToEdo(PersonEntity personEntity){
        PersonDTO personDTO = new PersonDTO();
        personDTO.setName(personEntity.getName());
        personDTO.setDate(personEntity.getDate());
        personDTO.setPhone(personEntity.getPhone());
        personDTO.setDirection(personEntity.getDirection());
        return personDTO;
    }
}
