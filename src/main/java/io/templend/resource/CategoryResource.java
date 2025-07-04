package io.templend.resource;

import io.templend.model.Category;
import io.templend.service.CategoryService;
import io.templend.serviceImpl.CategoryServiceImpl;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

import java.util.UUID;

@Path("categories")
public class CategoryResource extends AbstractResource {
    private final CategoryService categoryService = new CategoryServiceImpl();

    @GET
    public Response get() throws Exception {
        return Response.ok(gson.toJson(categoryService.get())).build();
    }

    @GET
    @Path("/{id}")
    public Response getById(@PathParam("id") String id) throws Exception {
        return Response.ok(gson.toJson(categoryService.getById(id))).build();
    }

    @POST
    public Response create(String payload) throws Exception {
        Category category = gson.fromJson(payload, Category.class);
        category.setId(UUID.randomUUID().toString());
        return Response.ok(gson.toJson(categoryService.save(category))).build();
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") String id, String payload) throws Exception {
        Category category = gson.fromJson(payload, Category.class);
        category.setId(id);
        return Response.ok(gson.toJson(categoryService.save(category))).build();
    }

    @GET
    @Path("/with-items")
    public Response getWithItems() throws Exception {
        return Response.ok(gson.toJson(categoryService.getWithItems())).build();
    }

    @GET
    public Response getWithItemsByName(@QueryParam("name") String name) throws Exception {
        return Response.ok(gson.toJson(categoryService.getWithItemsByName(name))).build();
    }
}
