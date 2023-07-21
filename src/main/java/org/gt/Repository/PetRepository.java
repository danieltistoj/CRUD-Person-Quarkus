package org.gt.Repository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import org.gt.DTO.PetDTO;
import org.gt.Entity.PetEntity;
import java.util.List;

@ApplicationScoped
public class PetRepository {
    @Transactional
    public   void createPet(PetEntity pet){
        PetEntity.persist(pet);
    }
    public  PetEntity findByName(String name){
        return PetEntity.find("name",name).firstResult();
    }
    public List<PetEntity> allPet() {
        return PetEntity.listAll();
    }
    public PetEntity findById(Long id){
        return PetEntity.findById(id);
    }
    @Transactional
    public void deletePet(Long id) {
        PetEntity.deleteById(id);
    }
    @Transactional
    public void updatePerson(PetEntity petEntity, PetDTO petDTO) {
        petEntity.setName(petDTO.getName());
        petEntity.setRace(petDTO.getRace());
        petEntity.setAge(petDTO.getAge());

    }
}
