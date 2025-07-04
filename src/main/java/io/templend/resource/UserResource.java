package io.templend.resource;

import io.templend.model.User;
import io.templend.service.UserService;
import io.templend.serviceImpl.UserServiceImpl;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.UUID;

@Path("users")
public class UserResource extends AbstractResource {
    private final UserService userService = new UserServiceImpl();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response get() throws Exception {
        return Response.ok(gson.toJson(userService.get())).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("id") String id) throws Exception {
        return Response.ok(gson.toJson(userService.getById(id))).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(String payload) throws Exception {
        User user = gson.fromJson(payload, User.class);
        user.setId(UUID.randomUUID().toString());
        return Response.ok(userService.save(user)).build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(@PathParam("id") String id, String payload) throws Exception {
        User user = gson.fromJson(payload, User.class);
        user.setId(id);
        return Response.ok(userService.save(user)).build();
    }

    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response delete(@PathParam("id") String id) throws Exception {
    return Response.ok(userService.delete(id)).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response login(String payload) throws Exception {
        User user = gson.fromJson(payload, User.class);
        return Response.ok(userService.login(user)).build();
    }
}
