package io.templend.resource;

import io.templend.model.BorrowRequest;
import io.templend.service.BorrowRequestService;
import io.templend.serviceImpl.BorrowRequestServiceImpl;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.UUID;

@Path("borrow_requests")
public class BorrowRequestResource extends AbstractResource {

    private final BorrowRequestService borrowRequestService = new BorrowRequestServiceImpl();

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(String payload) throws Exception {
        BorrowRequest borrowRequest = gson.fromJson(payload, BorrowRequest.class);
        borrowRequest.setId(UUID.randomUUID().toString());
        borrowRequestService.requestOrResponse(borrowRequest);
        return Response.ok().build();
    }

    @PUT
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(@PathParam("id") String id,
                           String payload) throws Exception {
        BorrowRequest borrowRequest = gson.fromJson(payload, BorrowRequest.class);
        borrowRequest.setId(id);
        borrowRequestService.requestOrResponse(borrowRequest);
        return Response.ok().build();
    }
}
