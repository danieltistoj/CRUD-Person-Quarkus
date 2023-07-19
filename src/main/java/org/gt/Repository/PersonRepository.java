package org.gt.Repository;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import org.gt.Entity.PersonEntity;

public class PersonRepository{

    public  static void createPerson(PersonEntity person){
        PersonEntity.persist(person);
    }
    public static PersonEntity findByName(String name){
        return PersonEntity.find("name",name).firstResult();
    }

}
