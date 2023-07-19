package org.gt;

import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;


@Path("/person")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PersonResources {
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello(){
        return "Person";
    }


    @GET
    @Path("/getAll")
    public List<Person> allPerson() {
        return Person.listAll();
    }
    @POST
    @Path("/newPerson")
    @Transactional
    public Response newPerson(Person persona) {
        Person.persist(persona);
        return Response.status(Response.Status.CREATED).entity("Person created successfully").build();
    }
    @GET
    @Path("/OnePersonById/{id}")
    public Person onePersonBYId(@PathParam("id") Long id) {
        return Person.findById(id);
    }
    @PUT
    @Path("/updatePerson/{id}")
    @Transactional
    public Response updatePersona(@PathParam("id") Long id, Person persona) {
        Person existingPerson = Person.findById(id);
        if (existingPerson!= null) {
            existingPerson.name = persona.name;
            existingPerson.date = persona.date;
            existingPerson.phone = persona.phone;
            existingPerson.direction = persona.direction;
            return Response.status(Response.Status.OK).entity("successfully modified person").build();
        }
        return Response.status(Response.Status.BAD_REQUEST).entity("The person does not exist").build();
    }
    @DELETE
    @Path("deletePerson/{id}")
    @Transactional
    public Response deletePerson(@PathParam("id") Long id) {
        if(Person.findById(id)!=null){
            Person.deleteById(id);
            return Response.status(Response.Status.OK).entity("Deleted person").build();
        }
        return Response.status(Response.Status.BAD_REQUEST).entity("The person does not exist").build();
    }

}
