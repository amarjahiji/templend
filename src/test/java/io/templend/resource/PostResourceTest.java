package io.templend.resource;

import jakarta.ws.rs.core.Response;
import junit.framework.TestCase;

public class PostResourceTest extends TestCase {

    public void testGet() throws Exception {
        Response response = new PostResource().get();
        System.out.println(response.getEntity());
    }

    public void testGetByIdWithDetails() throws Exception {
        String id = "";
        Response response = new PostResource().getByIdWithDetails(id);
        System.out.println(response.getEntity());
    }

    public void testGetByIdWithoutDetails() throws Exception {
        String id = "";
        Response response = new PostResource().getByIdWithoutDetails(id);
        System.out.println(response.getEntity());
    }
}