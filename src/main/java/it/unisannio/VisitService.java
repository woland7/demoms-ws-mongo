package it.unisannio;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/popvisit")
public class VisitService {

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public String getPopVisit() {
        return "CIAO";
    }
}
