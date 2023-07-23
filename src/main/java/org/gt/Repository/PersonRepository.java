package org.gt.Repository;


import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import org.gt.Entity.PersonEntity;



@ApplicationScoped
public class PersonRepository implements PanacheRepository <PersonEntity>{
    @Transactional
    public   void createPerson(PersonEntity person){
        persist(person);
    }
    public  PersonEntity findByName(String name){
        return find("name",name).firstResult();
    }

}
