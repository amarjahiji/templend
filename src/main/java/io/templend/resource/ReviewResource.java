package io.templend.resource;

import io.templend.model.Review;
import io.templend.service.ReviewService;
import io.templend.serviceImpl.ReviewServiceImpl;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.UUID;

@Path("reviews")
public class ReviewResource extends AbstractResource {
    private final ReviewService reviewService = new ReviewServiceImpl();

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getForItem(@PathParam("id") String id) throws Exception {
        return Response.ok(gson.toJson(reviewService.getForItem(id))).build();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getForOwner(@PathParam("id") String id) throws Exception {
        return Response.ok(gson.toJson(reviewService.getForOwner(id))).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(String payload) throws Exception {
        Review review = gson.fromJson(payload, Review.class);
        review.setId(UUID.randomUUID().toString());
        return Response.ok(gson.toJson(reviewService.save(review))).build();
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(@PathParam("id") String id, String payload) throws Exception {
        Review review = gson.fromJson(payload, Review.class);
        review.setId(id);
        return Response.ok(gson.toJson(reviewService.save(review))).build();
    }
}
