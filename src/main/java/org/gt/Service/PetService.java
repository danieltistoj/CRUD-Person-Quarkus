package org.gt.Service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import org.gt.DTO.PetDTO;

import org.gt.Entity.PetEntity;
import org.gt.Repository.PetRepository;

import java.util.ArrayList;
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

    public List<PetDTO> findAllPet() {
        List<PetEntity> petEntityList = petRepository.allPet();
        List<PetDTO> petTOList = new ArrayList<>();
        for(PetEntity pet:petEntityList){
            petTOList.add(convertEntityToEdo(pet));
        }
        return petTOList;
    }
    public PetDTO findPetById(long id){
        PetEntity petEntity = petRepository.findById(id);

        if(petEntity!=null){

            return convertEntityToEdo(petEntity);
        }
        return null;
    }
    @Transactional
    public boolean deletePet(Long id) {
        if(petRepository.findById(id)!=null){
            petRepository.deletePet(id);
            return true;
        }
        return false;
    }
    @Transactional
    public boolean updatePet(long id,PetDTO petDTO) {
        PetEntity petEntity = petRepository.findById(id);
        if(petEntity!=null){
            petRepository.updatePerson(petEntity,petDTO);
            return true;
        }
        return false;
    }
    private PetDTO convertEntityToEdo(PetEntity petEntity){
        PetDTO petDTO = new PetDTO();
        petDTO.setName(petEntity.getName());
        petDTO.setRace(petEntity.getRace());
        petDTO.setAge(petEntity.getAge());
        return petDTO;
    }
}
