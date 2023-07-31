package org.gt.Controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;


import org.gt.Entity.PetEntity;
import org.gt.Service.PetService;


import org.jboss.resteasy.reactive.server.core.multipart.FormData;
import org.jboss.resteasy.reactive.server.multipart.FormValue;
import org.jboss.resteasy.reactive.server.multipart.MultipartFormDataInput;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@Path("/pets")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ControllerPet {
    @Inject
    private PetService petService;

    @POST
    @Path("/")
    public Response newPet(PetEntity petEntity) {
        if( petService.findPetByName(petEntity.getName())==null){
            try {
                petService.savePet(petEntity);
                return Response.status(Response.Status.CREATED).entity("Pet created successfully").build();
            }catch (IllegalArgumentException ex){
                return Response.status(Response.Status.BAD_REQUEST).entity(ex.getMessage()).build();
            }
        }
        return Response.status(Response.Status.BAD_REQUEST).entity("The pet already exists").build();
    }
    @GET
    @Path("/")
    public List<PetEntity> allPet(){
        return petService.findAllPet();
    }
    @GET
    @Path("/{id}")
    public Response onePetById(@PathParam("id") Long id){

        PetEntity petEntity = petService.findPetById(id);
        if(petEntity!=null){
            return Response.ok(petEntity).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }
    @DELETE
    @Path("/{id}")
    public Response deletePet(@PathParam("id") Long id) {
        if(petService.deletePet(id)){
            return Response.status(Response.Status.OK).entity("Pet deleted successfully").build();
        }
        return Response.status(Response.Status.BAD_REQUEST).entity("The pet does not exist").build();
    }
    @DELETE
    @Path("/{name}")
    public Response deletePetByName(@PathParam("name") String name){
        if(petService.findPetByName(name)!=null){
            petService.deletePetBYName(name);
            return Response.status(Response.Status.OK).entity("Pet deleted successfully").build();
        }
        return Response.status(Response.Status.BAD_REQUEST).entity("The pet does not exist").build();
    }
    @PUT
    @Path("/{name}")
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
    @Path("/{name}")
    public Response findPetByName(@PathParam("name") String name){
        PetEntity petEntity = petService.findPetByName(name);
        if(petEntity!=null){
            return Response.status(Response.Status.OK).entity(petEntity).build();
        }
        return Response.status(Response.Status.BAD_REQUEST).entity("The pet does not exist").build();
    }
    @POST
    @Path("/upload/{name}")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response uploadImage(@PathParam("name") String name, MultipartFormDataInput input) throws IOException {
        String urlImage = petService.uploadImage(name,input);
        if(urlImage!=null){
            return Response.ok(urlImage).build();
        }
        return Response.status(Response.Status.BAD_REQUEST).entity("Image not found").build();
    }

}
