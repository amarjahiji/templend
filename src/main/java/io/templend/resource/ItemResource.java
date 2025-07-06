package io.templend.resource;

import io.templend.model.Item;
import io.templend.service.ItemService;
import io.templend.serviceImpl.ItemServiceImpl;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.UUID;

@Path("items")
public class ItemResource extends AbstractResource {
    private final ItemService itemService = new ItemServiceImpl();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response get() throws Exception {
        return Response.ok(itemService.get()).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("id") String id) throws Exception {
        return Response.ok(itemService.getById(id)).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getByOwnerId(@PathParam("id") String id) throws Exception {
        return Response.ok(itemService.getByOwnerId(id)).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(String payload) throws Exception {
        Item item = gson.fromJson(gson.toJson(payload), Item.class);
        item.setId(UUID.randomUUID().toString());
        return Response.ok(itemService.save(item)).build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(@PathParam("id") String id, String payload) throws Exception {
        Item item = gson.fromJson(payload, Item.class);
        item.setId(id);
        return Response.ok(itemService.save(item)).build();
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response delete(@PathParam("id") String id) throws Exception {
        return Response.ok(itemService.delete(id)).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPaginated(@QueryParam("page") int page,
                                 @QueryParam("size") int size) throws Exception {
        return Response.ok(itemService.getPaginated(page, size)).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getByKeyword(@QueryParam("keyword") String keyword) throws Exception {
        return Response.ok(itemService.getByKeyword(keyword)).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getByAvailability(@QueryParam("available") boolean available) throws Exception {
        return Response.ok(itemService.getByAvailability(available)).build();
    }

//    @GET
//    @Path("/details")
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response getWithDetails() throws Exception {
//        return Response.ok(itemService.getWithDetails()).build();
//    }

    @GET
    @Path("{id}/details")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getWithDetailsById(@PathParam("id") String id) throws Exception {
        return Response.ok(itemService.getWithDetailsById(id)).build();
    }
}
