package dao;

import entities.Catalogo;


import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;
import java.util.UUID;

public class CatalogoDao {
    private EntityManager em;

    public CatalogoDao(EntityManager em) {
        this.em = em;
    }

    public void save(Catalogo elemento) {
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(elemento);
        et.commit();
    }

    public Catalogo getById(String isbn) {
        return em.find(Catalogo.class, UUID.fromString(isbn));
    }

    public void delete(UUID isbn) {
        EntityTransaction et = em.getTransaction();
        et.begin();
        Catalogo elemento = getById(isbn.toString());

        if (elemento != null) {
            em.remove(elemento);
        } else {
            System.out.println("Elemento non presente nel catalogo");
        }

        et.commit();
    }




    public List<Catalogo> getElementoByAnnoPubblicazione(int anno){
        Query query = em.createQuery("select e from ElementoCatalogo e where e.annoPubblicazione = :anno");
        query.setParameter("anno",anno);
        return query.getResultList();
    }



    public List<Catalogo> getElementoByAutore(String autore){
        Query query = em.createQuery("select e from ElementoCatalogo e where e.autore=:autore");
        query.setParameter("autore", autore);
        return query.getResultList();
    }




    public List<Catalogo> getElementoByTitolo(String titolo){
        Query query = em.createQuery("select e from ElementoCatalogo e where e.titolo like :titolo");
        query.setParameter("titolo","%" + titolo + "%");
        return query.getResultList();
    }




}