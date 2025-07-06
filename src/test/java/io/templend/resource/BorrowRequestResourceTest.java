package io.templend.resource;

import jakarta.ws.rs.core.Response;
import junit.framework.TestCase;

public class BorrowRequestResourceTest extends TestCase {

    public void testCreate() throws Exception {
        String payload = "";
        Response response = new BorrowRequestResource().create(payload);
        System.out.println(response.getEntity());
    }

    public void testUpdate() throws Exception {
        String id = "";
        String payload = "";
        Response response = new BorrowRequestResource().update(id, payload);
        System.out.println(response.getEntity());
    }
}