package org.gt.Service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import org.gt.DTO.PetDTO;

import org.gt.Entity.PetEntity;

import org.gt.Repository.PetRepository;

import java.util.List;

@ApplicationScoped
public class PetService {
    @Inject
    private PetRepository petRepository;
    @Transactional
    public  boolean savePet(PetDTO pet) {
        PetEntity newPet = new PetEntity();
        if(petRepository.findByName(pet.getName())==null){
            newPet.setName(pet.getName());
            newPet.setRace(pet.getRace());
            newPet.setAge(pet.getAge());

            petRepository.createPet(newPet);
            return true;
        }

        return false;
    }

    public List<PetEntity> findAllPet() {
       return petRepository.listAll();
    }
    public PetEntity findPetById(long id){
        PetEntity petEntity = petRepository.findById(id);

        if(petEntity!=null){

            return petEntity;
        }
        return null;
    }
    @Transactional
    public boolean deletePet(Long id) {
        if(petRepository.findById(id)!=null){
            petRepository.deleteById(id);
            return true;
        }
        return false;
    }
    @Transactional
    public Object updatePet(String  username,PetEntity petEntity) {
        PetEntity updatePetEntity = petRepository.findByName(username);
            if(!updatePetEntity.getName().equals(petEntity.getName()) && petEntity.getName()!=null){
                if(petRepository.findByName(petEntity.getName())==null){
                    updatePetEntity.setName(petEntity.getName());
                }else{
                    throw new IllegalArgumentException("pet name already exists");
                }
            }
            if(petEntity.getRace()!=null){

                updatePetEntity.setRace(petEntity.getRace());

            }
            Integer objetAge = petEntity.getAge();
            if(objetAge!=null){

                updatePetEntity.setAge(petEntity.getAge());

            }
            return "pet update successfully";

    }
    public PetEntity findPetByName(String name){
        PetEntity getPetEntity = petRepository.findByName(name);
        if(getPetEntity!=null){
            return getPetEntity;
        }
        return null;
    }
    @Transactional
    public void deletePetBYName(String name){
        petRepository.delete("name",name);
    }
}
