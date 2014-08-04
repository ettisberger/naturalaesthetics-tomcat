package main.ch.naturalaesthetics.resource.admin;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * User: ettisberger
 * Date: 02/08/14
 * Time: 15:16
 */
public class AbstractAdminResource<D, E> {

    AbstractService<D, E> service;

    @DELETE
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public void delete(@PathParam("id") final int id) {
        service.delete(id);
    }

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

    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public final D save(final D domainItem) {
        return service.save(domainItem);
    }
}
