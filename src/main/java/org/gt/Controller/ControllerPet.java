package org.gt.Controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import org.gt.DTO.PetDTO;

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
    public List<PetDTO> allPet(){
        return petService.findAllPet();
    }
    @GET
    @Path("/OnePetById/{id}")
    public Response onePetById(@PathParam("id") Long id){

        PetDTO petDTO = petService.findPetById(id);
        if(petDTO!=null){
            return Response.ok(petDTO).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }
    @DELETE
    @Path("/deletePet/{id}")
    public Response deletePet(@PathParam("id") Long id) {
        if(petService.deletePet(id)){
            return Response.status(Response.Status.OK).entity("Deleted pet").build();
        }
        return Response.status(Response.Status.BAD_REQUEST).entity("The pet does not exist").build();
    }
    @PUT
    @Path("/updatePet/{id}")
    public Response updatePet(@PathParam("id") Long id,PetDTO petDTO) {
        if(petService.updatePet(id,petDTO)){
            return Response.status(Response.Status.OK).entity("Update pet").build();
        }
        return Response.status(Response.Status.BAD_REQUEST).entity("The pet does not exist").build();
    }

}
