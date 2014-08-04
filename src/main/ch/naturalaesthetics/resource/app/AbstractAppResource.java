package main.ch.naturalaesthetics.resource.app;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * User: ettisberger
 * Date: 02/08/14
 * Time: 15:16
 */
public class AbstractAppResource<D, E> {

    AbstractService<D, E> service;

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public final List<D> findAll() {
        return service.findAll();
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public final D findById(@PathParam("id") final String id) {
        return service.findById(Integer.valueOf(id));
    }

}
