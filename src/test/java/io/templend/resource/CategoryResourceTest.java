package io.templend.resource;

import jakarta.ws.rs.core.Response;
import junit.framework.TestCase;

public class CategoryResourceTest extends TestCase {

    public void testGet() throws Exception {
        Response response = new CategoryResource().get();
        System.out.println(response.getEntity());
    }

    public void testGetById() throws Exception {
        String id = "";
        Response response = new CategoryResource().getById(id);
        System.out.println(response.getEntity());
    }

    public void testCreate() throws Exception {
        String payload = "";
        Response response = new CategoryResource().create(payload);
        System.out.println(response.getEntity());
    }

    public void testUpdate() throws Exception {
        String id = "";
        String payload = "";
        Response response = new CategoryResource().update(id, payload);
        System.out.println(response.getEntity());
    }

    public void testGetWithItems() throws Exception {
        Response response = new CategoryResource().getWithItems();
        System.out.println(response.getEntity());
    }

    public void testGetWithItemsByName() throws Exception {
        String name = "";
        Response response = new CategoryResource().getWithItemsByName(name);
        System.out.println(response.getEntity());
    }
}