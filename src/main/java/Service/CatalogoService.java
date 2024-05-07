package Service;



import entities.Libro;
import entities.Rivista;
import persistence.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class CatalogoService {

    public void aggiungiLibro(Libro libro) {
        EntityManager entityManager = JPAUtil.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(libro);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void aggiungiRivista(Rivista rivista) {
        EntityManager entityManager = JPAUtil.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(rivista);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void rimuoviElemento(String isbn) {
        EntityManager entityManager = JPAUtil.getEntityManager();
        entityManager.getTransaction().begin();

        Query queryLibro = entityManager.createQuery("DELETE FROM Libro l WHERE l.isbn = :isbn");
        queryLibro.setParameter("isbn", isbn);
        queryLibro.executeUpdate();

        Query queryRivista = entityManager.createQuery("DELETE FROM Rivista r WHERE r.isbn = :isbn");
        queryRivista.setParameter("isbn", isbn);
        queryRivista.executeUpdate();

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public List<Libro> ricercaPerISBN(String isbn) {
        EntityManager entityManager = JPAUtil.getEntityManager();
        Query query = entityManager.createQuery("SELECT l FROM Libro l WHERE l.isbn = :isbn", Libro.class);
        query.setParameter("isbn", isbn);
        List<Libro> risultati = query.getResultList();
        entityManager.close();
        return risultati;
    }

    public List<Libro> ricercaPerAnnoPubblicazione(int anno) {
        EntityManager entityManager = JPAUtil.getEntityManager();
        Query query = entityManager.createQuery("SELECT l FROM Libro l WHERE l.annoPubblicazione = :anno", Libro.class);
        query.setParameter("anno", anno);
        List<Libro> risultati = query.getResultList();
        entityManager.close();
        return risultati;
    }

    public List<Libro> ricercaPerAutore(String autore) {
        EntityManager entityManager = JPAUtil.getEntityManager();
        Query query = entityManager.createQuery("SELECT l FROM Libro l WHERE l.autore = :autore", Libro.class);
        query.setParameter("autore", autore);
        List<Libro> risultati = query.getResultList();
        entityManager.close();
        return risultati;
    }

    public List<Libro> ricercaPerTitolo(String titolo) {
        EntityManager entityManager = JPAUtil.getEntityManager();
        Query query = entityManager.createQuery("SELECT l FROM Libro l WHERE l.titolo LIKE :titolo", Libro.class);
        query.setParameter("titolo", "%" + titolo + "%");
        List<Libro> risultati = query.getResultList();
        entityManager.close();
        return risultati;
    }

    // Altri metodi per la ricerca di libri e riviste, e gestione dei prestiti...
}
