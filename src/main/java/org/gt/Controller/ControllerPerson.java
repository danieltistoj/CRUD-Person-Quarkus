package org.gt.Controller;


import com.fasterxml.jackson.annotation.JsonInclude;
import io.vertx.core.json.pointer.JsonPointerIterator;
import jakarta.inject.Inject;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;


import org.gt.DTO.DateTimeResponseDTO;
import org.gt.DTO.PersonDTO;
import org.gt.Entity.PersonEntity;
import org.gt.Service.PersonService;

import jakarta.ws.rs.core.Response;

import java.util.List;


@Path("/people")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ControllerPerson {
    @Inject
    private PersonService personService;

    @POST
    @Path("/")
    public Response newPerson(PersonEntity person) {
        DateTimeResponseDTO responseDTO = new DateTimeResponseDTO();
        if( personService.savePerson(person)){
         return Response.status(Response.Status.CREATED).entity(person).build();
        }

        responseDTO.TimeDate();
        responseDTO.setStatusCode(Response.Status.BAD_REQUEST.getStatusCode());
        responseDTO.setMessage("The person already exists");

        return Response.status(Response.Status.BAD_REQUEST).entity(responseDTO).build();
    }
    @GET
    @Path("/")
    public List<PersonEntity> allPerson(){
        return personService.findAllPerson();
    }
    @GET
    @Path("/{id}")
    public Response onePersonById(@PathParam("id") Long id){
        DateTimeResponseDTO responseDTO = new DateTimeResponseDTO();
        PersonEntity personEntity = personService.findPersonById(id);
        if(personEntity!=null){
            return Response.ok(personEntity).build();
        }
        responseDTO.TimeDate();
        responseDTO.setMessage("The person does not exist");
        responseDTO.setStatusCode(Response.Status.NOT_FOUND.getStatusCode());

        return Response.status(Response.Status.NOT_FOUND).entity(responseDTO).build();
    }
    @DELETE
    @Path("/{id}")
    public Response deletePerson(@PathParam("id") Long id) {
        DateTimeResponseDTO responseDTO = new DateTimeResponseDTO();
        responseDTO.TimeDate();
        if(personService.deletePersona(id)){

            responseDTO.setMessage("Deleted person");
            responseDTO.setStatusCode(Response.Status.OK.getStatusCode());
            return Response.status(Response.Status.OK).entity(responseDTO).build();
        }


        responseDTO.setMessage("The person does not exist");
        responseDTO.setStatusCode(Response.Status.NOT_FOUND.getStatusCode());

        return Response.status(Response.Status.NO_CONTENT).entity(responseDTO).build();
    }
    @PUT
    @Path("/{id}")
    public Response updatePersona(@PathParam("id") Long id,PersonEntity personEntity) {
        DateTimeResponseDTO responseDTO = new DateTimeResponseDTO();
        if(personService.updatePerson(id,personEntity)){

            PersonEntity updatePersonEntity = personService.findPersonById(id);
            return Response.ok(updatePersonEntity).build();
        }


        responseDTO.TimeDate();
        responseDTO.setMessage("The person does not exist");
        responseDTO.setStatusCode(Response.Status.NOT_FOUND.getStatusCode());

        return Response.status(Response.Status.NO_CONTENT).entity(responseDTO).build();
    }
    @GET
    @JsonInclude(JsonInclude.Include.ALWAYS)
    @Path("/{name}")
    public Response findPersonByName(@PathParam("name") String name){
        PersonEntity personEntity;
        try {
            long id = Long.parseLong(name);
             personEntity = personService.findPersonById(id);
        }catch (Exception ex){
            personEntity = personService.findPersonByName(name);
        }

        if(personEntity!=null){
            PersonDTO personDTO = personService.convertEntityToDTO(personEntity);
            return Response.status(Response.Status.OK).entity(personDTO).build();
        }
        DateTimeResponseDTO responseDTO = new DateTimeResponseDTO();
        responseDTO.TimeDate();
        responseDTO.setMessage("The person does not exist");
        responseDTO.setStatusCode(Response.Status.NOT_FOUND.getStatusCode());

        return Response.status(Response.Status.NOT_FOUND).entity(responseDTO).build();
    }
}
