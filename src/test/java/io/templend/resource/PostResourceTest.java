package io.templend.resource;

import jakarta.ws.rs.core.Response;
import junit.framework.TestCase;

public class PostResourceTest extends TestCase {

    public void testGet() throws Exception {
        Response response = new PostResource().get();
        System.out.println(response.getEntity());
    }
}