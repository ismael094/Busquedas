/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import database.Libros;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Ismael1
 */
@Stateless
@Path("database.libros")
public class LibrosFacadeREST extends AbstractFacade<Libros> {

    @PersistenceContext(unitName = "BusquedasPU")
    private EntityManager em;

    public LibrosFacadeREST() {
        super(Libros.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_JSON})
    public void create(Libros entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Libros entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Libros> find(@PathParam("id") Integer id) {
        em.getEntityManagerFactory().getCache().evictAll();
        javax.persistence.criteria.CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(Libros.class));
        em.flush();
        return em.createNamedQuery("Libros.findById").setParameter("id",id).getResultList();
    }
    
    @GET
    @Path("ISBN/{isbn}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Libros> findByIsbn(@PathParam("isbn") String isbn) {
        javax.persistence.criteria.CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(Libros.class));
        return em.createNamedQuery("Libros.findByIsbn").setParameter("isbn",isbn).getResultList();
    }
    
    @GET
    @Path("TITLE/{title}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Libros> findByTitle(@PathParam("title") String title) {
        em.getEntityManagerFactory().getCache().evictAll();
        javax.persistence.criteria.CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(Libros.class));
        return em.createNamedQuery("Libros.findByTitle").setParameter("title","%"+title+"%").getResultList();
        //return (Libros) ;
    }
    
    @GET
    @Path("AUTHORNAME/{authorName}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Libros> findByAuthorName(@PathParam("authorName") String authorName) {
        em.getEntityManagerFactory().getCache().evictAll();
        javax.persistence.criteria.CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(Libros.class));
        return em.createNamedQuery("Libros.findByAuthorName").setParameter("authorName","%"+authorName+"%").getResultList();
        //return (Libros) ;
    }
    
    @GET
    @Path("SUBJECT/{subject}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Libros> findBySubject(@PathParam("subject") String subject) {
        em.getEntityManagerFactory().getCache().evictAll();
        javax.persistence.criteria.CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(Libros.class));
        return em.createNamedQuery("Libros.findBySubject").setParameter("subject","%"+subject+"%").getResultList();
        //return (Libros) ;
    }
    
    @GET
    @Path("novedades")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Libros> novedades() {
        javax.persistence.criteria.CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(Libros.class));
        return em.createNamedQuery("Libros.random").setMaxResults(5).getResultList();
        
        //return (Libros) ;
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_JSON})
    public List<Libros> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Libros> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
