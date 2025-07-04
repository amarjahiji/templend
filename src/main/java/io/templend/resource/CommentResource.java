package io.templend.resource;

import io.templend.model.Comment;
import io.templend.service.CommentService;
import io.templend.serviceImpl.CommentServiceImpl;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.UUID;

@Path("comments")
public class CommentResource extends AbstractResource {
    private final CommentService commentService = new CommentServiceImpl();

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("id") String id) throws Exception {
        return Response.ok(gson.toJson(commentService.getById(id))).build();
    }

    @GET
    @Path("/{itemId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getByItem(@PathParam("itemId") String itemId) throws Exception {
        return Response.ok(gson.toJson(commentService.getByItem(itemId))).build();
    }

    @GET
    @Path("/{parentId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSubcommentsByParentId(@PathParam("parentId") String id) throws Exception {
        return Response.ok(gson.toJson(commentService.getSubcommentsByParentId(id))).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(String payload) throws Exception {
        Comment comment = gson.fromJson(payload, Comment.class);
        comment.setId(UUID.randomUUID().toString());
        return Response.ok(gson.toJson(commentService.save(comment))).build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(@PathParam("id") String id, String payload) throws Exception {
        Comment comment = gson.fromJson(payload, Comment.class);
        comment.setId(id);
        return Response.ok(gson.toJson(commentService.save(comment))).build();
    }

}
