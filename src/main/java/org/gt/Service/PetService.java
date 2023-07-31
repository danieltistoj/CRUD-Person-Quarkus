package org.gt.Service;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import jakarta.transaction.Transactional;



import org.gt.Entity.PersonEntity;
import org.gt.Entity.PetEntity;

import org.gt.Repository.PetRepository;
import org.gt.Tools.CloudinaryConnection;
import org.jboss.resteasy.reactive.server.multipart.FormValue;
import org.jboss.resteasy.reactive.server.multipart.MultipartFormDataInput;


import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;


@ApplicationScoped
public class PetService {
    @Inject
    private PetRepository petRepository;
    @Inject
    private PersonService personService;


    @Transactional
    public  void savePet(PetEntity pet) {

        PersonEntity personEntity = personService.findPersonByName(pet.getPerson().getName());
        if(personEntity==null){
            throw new IllegalArgumentException("the person does not exist");
        }
        pet.setPerson(personEntity);
        petRepository.persist(pet);
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
    @Transactional
    public String uploadImage(String name,MultipartFormDataInput input) throws IOException {
        PetEntity petEntity = findPetByName(name);

        Map<String, Collection<FormValue>> formDataMap = input.getValues();
        Collection<FormValue> imageParts = formDataMap.get("image");

        List<FormValue> listFormValues = new ArrayList<>(imageParts);

        if(imageParts == null || imageParts.isEmpty()){
            return null;
        }

        FormValue data = listFormValues.get(0);

        InputStream inputStream = data.getFileItem().getInputStream();
        byte[] imageBytes = inputStream.readAllBytes();

        Cloudinary cloudinary = CloudinaryConnection.getInstance();

        Map<?,?> result = cloudinary.uploader().upload(imageBytes, ObjectUtils.asMap("public_id", petEntity.getName()));
        String imageUrl = (String) result.get("url");

        petEntity.setImageUrl(imageUrl);
        return imageUrl;
    }
}
