package io.templend.resource;

import io.templend.service.BorrowRequestDetailService;
import io.templend.serviceImpl.BorrowRequestDetailServiceImpl;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;

@Path("borrow_request_details")
public class BorrowRequestDetailResource extends AbstractResource {

    private final BorrowRequestDetailService borrowRequestDetailService = new BorrowRequestDetailServiceImpl();

    @GET
    @Path("/{id}")
    public Response getPendingByLender(@PathParam("id") String lenderId) throws Exception {
        return Response.ok(gson.toJson(borrowRequestDetailService.getPendingByLender(lenderId))).build();
    }

    @GET
    @Path("/{id}/items/{item_id}")
    public Response getByLendersItem(@PathParam("id") String lenderId,
                                       @PathParam("item_id") String itemId) throws Exception {
        return Response.ok(gson.toJson(borrowRequestDetailService.getByLendersItem(lenderId, itemId))).build();
    }

    @GET
    @Path("/{id}")
    public Response getByBorrower(@PathParam("id") String borrowerId) throws Exception {
        return Response.ok(gson.toJson(borrowRequestDetailService.getByBorrower(borrowerId))).build();
    }

}
