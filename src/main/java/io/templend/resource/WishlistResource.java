package io.templend.resource;

import io.templend.model.Item;
import io.templend.service.WishlistService;
import io.templend.serviceImpl.WishlistServiceImpl;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("wishlist")
public class WishlistResource extends AbstractResource {

    private final WishlistService wishlistService = new WishlistServiceImpl();

    @GET
    @Path("/user/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response get(@PathParam("id") String userId) throws Exception {
        return Response.ok(gson.toJson(wishlistService.get(userId))).build();
    }

    @POST
    @Path("/user/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(@PathParam("id") String userId, String payload) throws Exception {
        return Response.ok(wishlistService.create(userId, gson.fromJson(payload, Item.class).getId())).build();

    }
}
