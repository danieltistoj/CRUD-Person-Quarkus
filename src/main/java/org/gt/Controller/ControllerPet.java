package org.gt.Controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import org.gt.DTO.PetDTO;

import org.gt.Entity.PetEntity;
import org.gt.Service.PetService;

import java.util.List;

@Path("/pet")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ControllerPet {
    @Inject
    private PetService petService;
    @GET
    @Path("/")
    public String hello(){
        return "Pet";
    }
    @POST
    @Path("/newPet")
    public Response newPet(PetDTO pet) {
        if( petService.savePet(pet)){
            return Response.status(Response.Status.CREATED).entity("Pet created successfully").build();
        }
        return Response.status(Response.Status.BAD_REQUEST).entity("The pet already exists").build();
    }
    @GET
    @Path("/getAll")
    public List<PetEntity> allPet(){
        return petService.findAllPet();
    }
    @GET
    @Path("/OnePetById/{id}")
    public Response onePetById(@PathParam("id") Long id){

        PetEntity petEntity = petService.findPetById(id);
        if(petEntity!=null){
            return Response.ok(petEntity).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }
    @DELETE
    @Path("/deletePet/{id}")
    public Response deletePet(@PathParam("id") Long id) {
        if(petService.deletePet(id)){
            return Response.status(Response.Status.OK).entity("Pet deleted successfully").build();
        }
        return Response.status(Response.Status.BAD_REQUEST).entity("The pet does not exist").build();
    }
    @DELETE
    @Path("/deletePetByName/{name}")
    public Response deletePetByName(@PathParam("name") String name){
        if(petService.findPetByName(name)!=null){
            petService.deletePetBYName(name);
            return Response.status(Response.Status.OK).entity("Pet deleted successfully").build();
        }
        return Response.status(Response.Status.BAD_REQUEST).entity("The pet does not exist").build();
    }
    @PUT
    @Path("/updatePet/{name}")
    public Response updatePet(@PathParam("name") String name,PetEntity petEntity) {
        if(petService.findPetByName(name)!=null){
            try {
                return Response.status(Response.Status.OK).entity(petService.updatePet(name,petEntity)).build();
            }catch (IllegalArgumentException ex){
                return Response.status(Response.Status.BAD_REQUEST).entity(ex.getMessage()).build();
            }

        }
        return Response.status(Response.Status.BAD_REQUEST).entity("The pet does not exist").build();
    }
    @GET
    @Path("/findPetByName/{name}")
    public Response findPetByName(@PathParam("name") String name){
        PetEntity petEntity = petService.findPetByName(name);
        if(petEntity!=null){
            return Response.status(Response.Status.OK).entity(petEntity).build();
        }
        return Response.status(Response.Status.BAD_REQUEST).entity("The pet does not exist").build();
    }

}
