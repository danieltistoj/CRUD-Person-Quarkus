package org.gt.Controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.gt.DTO.UserDTO;
import org.gt.Service.UserService;

@Path("/user")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ControllerUser {
    @Inject
    private UserService userService;
    @POST
    @Path("/LogIn")
    public void LogIn(){

    }
    @POST
    @Path("/SignIn")
    public Response SignIn(UserDTO userDTO){
        if(userService.createUser(userDTO)){
            return Response.status(Response.Status.CREATED).entity("User created successfully").build();
        }
     return Response.status(Response.Status.BAD_REQUEST).entity("The user already exists").build();
    }
}
