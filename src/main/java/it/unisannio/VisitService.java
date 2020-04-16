package it.unisannio;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import it.unisannio.database.ConnectionManager;
import org.bson.Document;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;

import static com.mongodb.client.model.Filters.gt;
import static com.mongodb.client.model.Projections.*;

@Path("/visits")
public class VisitService {

    @GET
    @Path("/mostpop")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Integer> getPopVisit() {
        ConnectionManager cm = new ConnectionManager();
        MongoClient mongo = cm.getClient();
        MongoCollection<Document> collection = mongo.getDatabase("museo").getCollection("visits");
        MongoCursor<Document> cursor = collection.find().
                projection(excludeId()).iterator();
       ArrayList<Integer> visit = null;
        while(cursor.hasNext())
            visit = (ArrayList<Integer>) cursor.next().getList("visit", Integer.class);
        return visit;
    }
}
