package org.gt.Controller;

import io.vertx.core.json.JsonObject;
import jakarta.inject.Inject;
import jakarta.json.Json;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.gt.DTO.UserDTO;
import org.gt.Entity.UserEntity;
import org.gt.Service.ResponseService;
import org.gt.Service.UserService;

import java.util.Date;

@Path("/user")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ControllerUser {
    @Inject
    private UserService userService;

    @Inject
    private ResponseService responseService;


    @POST
    @Path("/LogIn")
    public Response LogIn(UserDTO userDTO){
        if(userService.authenticateUser(userDTO)){
            System.out.println("ENtro 3");
            return Response.status(Response.Status.CREATED).entity(responseService.Request(true,userDTO.getUser_name())).build();
        }
        return Response.status(Response.Status.BAD_REQUEST).entity(responseService.Request(false,"wrong username or password")).build();
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
