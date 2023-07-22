package org.gt.Controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.gt.DTO.DateTimeResponseDTO;
import org.gt.DTO.UserDTO;
import org.gt.Entity.UserEntity;
import org.gt.Service.UserService;

import java.util.List;

@Path("/user")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ControllerUser {
    @Inject
    private UserService userService;

    @POST
    @Path("/LogIn")
    public Response LogIn(UserEntity userEntity){
        DateTimeResponseDTO dataResponseDTO = new DateTimeResponseDTO();
        dataResponseDTO.TimeDate();
        if(userService.authenticateUser(userEntity)){
            dataResponseDTO.setMessage(userEntity.getUsername());

            return Response.status(Response.Status.CREATED).entity(dataResponseDTO).build();
        }
        dataResponseDTO.setMessage("the username or password are incorrect");
        return Response.status(Response.Status.UNAUTHORIZED).entity(dataResponseDTO).build();
    }
    @POST
    @Path("/SignIn")
    public Response SignIn(UserEntity userEntity){
        if(userService.createUser(userEntity)){
            return Response.status(Response.Status.CREATED).entity("User created successfully").build();
        }
     return Response.status(Response.Status.BAD_REQUEST).entity("The user already exists, try another username or email").build();
    }
    @GET
    @Path("/allUsers")
    public List<UserEntity> allUsers(){
        return userService.allUser();
    }
    @GET
    @Path("/findUserByUserName/{username}")
    public Response findUserByName(@PathParam("username") String name){
        UserEntity userEntity = userService.findUserByName(name);
        if(userEntity!=null){
         return Response.status(Response.Status.OK).entity(userEntity).build();
        }
        return Response.status(Response.Status.BAD_REQUEST).entity("Username does not exist").build();
    }
    @PUT
    @Path("/updateUser/{username}")
    public Response updateUser(@PathParam("username") String name,UserEntity userEntity){
        if(userService.findUserByName(name)!=null){

            try {
               return Response.status(Response.Status.OK).entity(userService.updateUser(name,userEntity)).build();
            }catch (IllegalArgumentException ex){
                return Response.status(Response.Status.BAD_REQUEST).entity(ex.getMessage()).build();
            }


            //return Response.status(Response.Status.OK).entity("ok").build();

        }
            return Response.status(Response.Status.BAD_REQUEST).entity("Username does not exist").build();
    }

}
