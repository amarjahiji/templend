package io.templend.resource;

import jakarta.ws.rs.core.Response;
import junit.framework.TestCase;

public class BorrowRequestDetailResourceTest extends TestCase {

    public void testGetPendingByLender() throws Exception {
        String lenderId = "";
        Response response = new BorrowRequestDetailResource().getPendingByLender(lenderId);
        System.out.println(response.getEntity());
    }

    public void testTestGetPendingByLender() throws Exception {
        String lenderId = "";
        String itemId = "";
        Response response = new BorrowRequestDetailResource().getByLendersItem(lenderId, itemId);
        System.out.println(response.getEntity());
    }

    public void testGetByBorrower() throws Exception {
        String borrowerId = "";
        Response response = new BorrowRequestDetailResource().getByBorrower(borrowerId);
        System.out.println(response.getEntity());
    }
}