package io.templend.resource;

import jakarta.ws.rs.core.Response;
import junit.framework.TestCase;

public class ReviewResourceTest extends TestCase {

    public void testGetForItem() throws Exception {
        String id = "";
        Response response = new ReviewResource().getForItem(id);
        System.out.println(response.getEntity());
    }

    public void testGetForOwner() throws Exception {
        String id = "";
        Response response = new ReviewResource().getForOwner(id);
        System.out.println(response.getEntity());
    }

    public void testCreate() throws Exception {
        String payload = "";
        Response response = new ReviewResource().create(payload);
        System.out.println(response.getEntity());
    }

    public void testUpdate() throws Exception {
        String id = "";
        String payload = "";
        Response response = new ReviewResource().update(id, payload);
        System.out.println(response.getEntity());
    }
}