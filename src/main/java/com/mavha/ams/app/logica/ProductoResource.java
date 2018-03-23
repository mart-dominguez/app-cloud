/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mavha.ams.app.logica;

import com.mavha.ams.app.modelo.Producto;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author marti
 */
@Path("producto")
public class ProductoResource {

    @Context
    private UriInfo context;

    @PersistenceContext(unitName = "VENTAS_PU")
    private EntityManager em;
    
    /**
     * Creates a new instance of ProductoResource
     */
    public ProductoResource() {
    }

    /**
     * Retrieves representation of an instance of com.mavha.ams.app.logica.ProductoResource
     * @return an instance of com.mavha.ams.app.modelo.Producto
     */
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public List<Producto> getXml() {
        //TODO return proper representation object
        return em.createQuery("SELECT p FROM Producto p").getResultList();
    }

    /**
     * PUT method for updating or creating an instance of ProductoResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public void putXml(Producto content) {
    }
}
