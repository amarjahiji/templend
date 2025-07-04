package io.templend.resource;

import io.templend.service.PostService;
import io.templend.serviceImpl.PostServiceImpl;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("posts")
public class PostResource extends AbstractResource {

    private final PostService postService = new PostServiceImpl();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response get() throws Exception {
        return Response.ok(gson.toJson(postService.get())).build();
    }
}
