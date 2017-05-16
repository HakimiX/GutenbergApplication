/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import DomainLayer.Controller;
import DomainLayer.author;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author mustafahakimi
 */
@Path("author")
public class authorREST {

    @Context
    private UriInfo context;

    Controller c = new Controller();

    public authorREST() {
    }

    
    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    public author find(@PathParam("id") String id) {
        //return super.find(id);
        return c.getAuthor("1");
    }
    
}
