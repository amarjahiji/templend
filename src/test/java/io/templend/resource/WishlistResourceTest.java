package io.templend.resource;

import jakarta.ws.rs.core.Response;
import junit.framework.TestCase;

public class WishlistResourceTest extends TestCase {

    public void testGetForUser() throws Exception {
        String userId = "";
        Response response = new WishlistResource().get(userId);
    }
}