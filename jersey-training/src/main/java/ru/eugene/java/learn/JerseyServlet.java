package ru.eugene.java.learn;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/main")
public class JerseyServlet {
    @GET
    @Path("/test")
    public Response test(){
        return Response.ok().entity("JERSEY TEST").build();
    }
}
