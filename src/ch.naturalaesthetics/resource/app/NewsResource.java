package ch.naturalaesthetics.resource.app;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

/**
 * News Resource
 *
 * @author Andy Ettisberger [andyATettisberger.ch]
 */
@Path("/news")
public class NewsResource  {

    public NewsResource() {
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public final List<String> findAll() {
        List<String> test = new ArrayList<String>();
        test.add("test");
        test.add("test2");

        return test;
    }

}