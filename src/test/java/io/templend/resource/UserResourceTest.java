package io.templend.resource;


import jakarta.ws.rs.core.Response;
import org.junit.Test;

public class UserResourceTest {

    @Test
    public void get() throws Exception {
        Response response = new UserResource().get();
        System.out.println(response.getEntity());
    }

    @Test
    public void getById() throws Exception {
        String id = "";
        Response response = new UserResource().getById(id);
        System.out.println(response.getEntity());
    }

    @Test
    public void create() throws Exception {
        String payload = "";
        Response response = new UserResource().create(payload);
        System.out.println(response.getEntity());
    }

    @Test
    public void update() throws Exception {
        String id = "";
        String payload = "";
        Response response = new UserResource().update(id, payload);
        System.out.println(response.getEntity());
    }

    @Test
    public void delete() throws Exception {
        String id = "";
        Response response = new UserResource().delete(id);
        System.out.println(response.getEntity());
    }
}