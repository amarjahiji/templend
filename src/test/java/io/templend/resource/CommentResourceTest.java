package io.templend.resource;

import jakarta.ws.rs.core.Response;
import junit.framework.TestCase;

public class CommentResourceTest extends TestCase {

    public void testGetByItem() throws Exception {
        String itemId = "";
        Response response = new CommentResource().getByItem(itemId);
        System.out.println(response.getEntity());
    }

    public void testGetById() throws Exception {
        String id = "";
        Response response = new CommentResource().getById(id);
        System.out.println(response.getEntity());
    }

    public void testGetSubcommentsByParentId() throws Exception {
        String id = "";
        Response response = new CommentResource().getSubcommentsByParentId(id);
        System.out.println(response.getEntity());
    }

    public void testCreate() throws Exception {
        String payload = "";
        Response response = new CommentResource().create(payload);
        System.out.println(response.getEntity());
    }

    public void testUpdate() throws Exception {
        String id = "";
        String payload = "";
        Response response = new CommentResource().update(id, payload);
        System.out.println(response.getEntity());
    }
}