package io.templend.resource;

import jakarta.ws.rs.core.Response;
import junit.framework.TestCase;

public class ItemResourceTest extends TestCase {

    public void testGet() throws Exception {
        Response response = new ItemResource().get();
        System.out.println(response.getEntity());
    }

    public void testGetById() throws Exception {
        String id = "";
        Response response = new ItemResource().getById(id);
        System.out.println(response.getEntity());
    }

    public void testGetByOwnerId() throws Exception {
        String id = "";
        Response response = new ItemResource().getByOwnerId(id);
        System.out.println(response.getEntity());
    }

    public void testCreate() throws Exception {
        String payload = "";
        Response response = new ItemResource().create(payload);
        System.out.println(response.getEntity());
    }

    public void testUpdate() throws Exception {
        String id = "";
        String payload = "";
        Response response = new ItemResource().update(id, payload);
        System.out.println(response.getEntity());
    }

    public void testDelete() throws Exception {
        String id = "";
        Response response = new ItemResource().delete(id);
        System.out.println(response.getEntity());
    }

    public void testGetPaginated() throws Exception {
        int page = 1;
        int size = 10;
        Response response = new ItemResource().getPaginated(page, size);
        System.out.println(response.getEntity());
    }

    public void testGetByKeyword() throws Exception {
        String keyword = "";
        Response response = new ItemResource().getByKeyword(keyword);
        System.out.println(response.getEntity());
    }

    public void testGetByAvailability() throws Exception {
        boolean available = true;
        Response response = new ItemResource().getByAvailability(available);
        System.out.println(response.getEntity());
    }

    public void testGetWithDetails() throws Exception {
    Response response = new ItemResource().getWithDetails();
    System.out.println(response.getEntity());
    }

    public void testGetWithDetailsById() throws Exception {
        String id = "";
        Response response = new ItemResource().getWithDetailsById(id);
        System.out.println(response.getEntity());
    }
}