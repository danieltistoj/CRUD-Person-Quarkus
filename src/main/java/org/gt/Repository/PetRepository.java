package org.gt.Repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import org.gt.DTO.PetDTO;
import org.gt.Entity.PetEntity;
import java.util.List;

@ApplicationScoped
public class PetRepository implements PanacheRepository<PetEntity> {
    @Transactional
    public   void createPet(PetEntity pet){
        persist(pet);
    }
    public  PetEntity findByName(String name){
        return find("name",name).firstResult();
    }

}
