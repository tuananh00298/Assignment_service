/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.Transaction;
import entity.User;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Tuan Anh
 */
@Stateless
@Path("service.transaction")
public class TransactionFacadeREST extends AbstractFacade<Transaction> {

    @PersistenceContext(unitName = "AssignmentServicePU")
    private EntityManager em;

    public TransactionFacadeREST() {
        super(Transaction.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Transaction entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Transaction entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Transaction find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Transaction> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Transaction> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }
    @GET
    @Path("findByReceiverId")
    @Consumes({"application/xml", "application/json"})
    public List<Transaction> findByReceiverId(@QueryParam("id") String id) {
        return (List<Transaction>) em.createNamedQuery("Transaction.findByReceiverId")
                .setParameter("receiverId", Integer.parseInt(id)).getResultList();
    }
    @GET
    @Path("findBySenderId")
    @Consumes({"application/xml", "application/json"})
    public List<Transaction> findBySenderId(@QueryParam("id") String id) {
        return (List<Transaction>) em.createNamedQuery("Transaction.findBySenderId")
                .setParameter("senderId", Integer.parseInt(id)).getResultList();
    }
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
