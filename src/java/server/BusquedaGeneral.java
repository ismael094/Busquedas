/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import filtro.FiltroClient;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Ismael1
 */
@Path("busquedas")
public class BusquedaGeneral {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of BusquedaGeneral
     */
    public BusquedaGeneral() {
    }

    /**
     * Retrieves representation of an instance of server.BusquedaGeneral
     * @param nombre
     * @return an instance of java.lang.String
     */
    @GET
    @Path("{key}, {nombre}, {page}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson(@PathParam("key") String key, @PathParam("nombre") String nombre, @PathParam("page") int page) {
        //TODO return proper representation objec
        FiltroClient fc = new FiltroClient();
        return fc.getJson(key, nombre, page+"");
    }

    /**
     * PUT method for updating or creating an instance of BusquedaGeneral
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
