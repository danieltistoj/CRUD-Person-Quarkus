package org.gt.Controller;


import jakarta.inject.Inject;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.gt.DTO.PersonDTO;

import org.gt.Service.PersonService;

import jakarta.ws.rs.core.Response;

import java.util.List;


@Path("/person")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ControllerPerson {
    @Inject
    private PersonService personService;
    @GET
    @Path("/")
    public String hello(){
        return "Person";
    }
    @POST
    @Path("/newPerson")
    public Response newPerson(PersonDTO person) {
        if( personService.savePerson(person)){
         return Response.status(Response.Status.CREATED).entity("Person created successfully").build();
        }
        return Response.status(Response.Status.BAD_REQUEST).entity("The person already exists").build();
    }
    @GET
    @Path("/getAll")
    public List<PersonDTO> allPerson(){
        return personService.findAllPerson();
    }
    @GET
    @Path("/OnePersonById/{id}")
    public Response onePersonById(@PathParam("id") Long id){

        PersonDTO personDTO = personService.findPersonById(id);
        if(personDTO!=null){
            return Response.ok(personDTO).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }
    @DELETE
    @Path("/deletePerson/{id}")
    public Response deletePerson(@PathParam("id") Long id) {
        if(personService.deletePersona(id)){
            return Response.status(Response.Status.OK).entity("Deleted person").build();
        }
        return Response.status(Response.Status.BAD_REQUEST).entity("The person does not exist").build();
    }
    @PUT
    @Path("/updatePerson/{id}")
    public Response updatePersona(@PathParam("id") Long id,PersonDTO personDTO) {
        if(personService.updatePerson(id,personDTO)){
            return Response.status(Response.Status.OK).entity("Update person").build();
        }
        return Response.status(Response.Status.BAD_REQUEST).entity("The person does not exist").build();
    }


}
