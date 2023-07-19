package org.gt.Controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.gt.DTO.PersonDTO;
import org.gt.Service.PersonService;

import jakarta.ws.rs.core.Response;

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
}
