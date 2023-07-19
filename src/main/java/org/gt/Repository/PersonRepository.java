package org.gt.Repository;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import org.gt.Entity.PersonEntity;
@ApplicationScoped
public class PersonRepository{
    @Transactional
    public   void createPerson(PersonEntity person){
        PersonEntity.persist(person);
    }
    public  PersonEntity findByName(String name){
        return PersonEntity.find("name",name).firstResult();
    }

}
