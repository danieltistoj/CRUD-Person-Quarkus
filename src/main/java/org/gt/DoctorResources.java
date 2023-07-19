package org.gt;

import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/doctor")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class DoctorResources {
    @GET
    @Path("/getAll")
    public List<Doctor> allDoctor() {
        return Doctor.listAll();
    }
    @POST
    @Path("/newDoctor")
    @Transactional
    public Response newDoctor(Doctor doctor) {
        Doctor.persist(doctor);
        return Response.status(Response.Status.CREATED).entity("Doctor created successfully").build();
    }
}
