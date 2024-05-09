import Enums.Periodicita;
import dao.CatalogoDao;
import dao.PrestitoDao;
import dao.UtenteDao;
import entities.Libro;
import entities.Prestito;
import entities.Rivista;
import entities.Utente;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestionecatalogo");
        EntityManager em = emf.createEntityManager();

        CatalogoDao elementoCatalogoDao = new CatalogoDao(em);
        UtenteDao utenteDao = new UtenteDao(em);
        PrestitoDao prestitoDao = new PrestitoDao(em);



        Libro libro1 = new Libro();

        libro1.setAutore("Veronica Roth");
        libro1.setGenere("Romanzo");
        libro1.setTitolo("Divergent");
        libro1.setAnnoPubblicazione(2011);
        libro1.setNumPagine(1200);

        Libro libro2 = new Libro();
        libro2.setAutore("Dan Brown");
        libro2.setGenere("Thriller");
        libro2.setTitolo("Il codice Da Vinci");
        libro2.setAnnoPubblicazione(2003);
        libro2.setNumPagine(350);

        Libro libro3 = new Libro();
        libro3.setAutore("J.K. Rowling");
        libro3.setGenere("Fantasy");
        libro3.setTitolo("Harry Potter e la Pietra Filosofale");
        libro3.setAnnoPubblicazione(1997);
        libro3.setNumPagine(332);

        Libro libro4 = new Libro();
        libro4.setAutore("Stephen King");
        libro4.setGenere("Horror");
        libro4.setTitolo("It");
        libro4.setAnnoPubblicazione(1986);
        libro4.setNumPagine(1138);

        Libro libro5 = new Libro();
        libro5.setAutore("Jane Austen");
        libro5.setGenere("Romanzo");
        libro5.setTitolo("Orgoglio e pregiudizio");
        libro5.setAnnoPubblicazione(1813);
        libro5.setNumPagine(432);

        Libro libro6 = new Libro();
        libro6.setAutore("George Orwell");
        libro6.setGenere("Romanzo distopico");
        libro6.setTitolo("1984");
        libro6.setAnnoPubblicazione(1949);
        libro6.setNumPagine(328);

        Libro libro7 = new Libro();
        libro7.setAutore("F. Scott Fitzgerald");
        libro7.setGenere("Romanzo");
        libro7.setTitolo("Il grande Gatsby");
        libro7.setAnnoPubblicazione(1925);
        libro7.setNumPagine(218);

        Libro libro8 = new Libro();
        libro8.setAutore("Gabriel Garcia Marquez");
        libro8.setGenere("Romanzo");
        libro8.setTitolo("Cent'anni di solitudine");
        libro8.setAnnoPubblicazione(1967);
        libro8.setNumPagine(417);

        Libro libro9 = new Libro();
        libro9.setAutore("Leo Tolstoj");
        libro9.setGenere("Romanzo");
        libro9.setTitolo("Guerra e pace");
        libro9.setAnnoPubblicazione(1869);
        libro9.setNumPagine(1225);

        Libro libro10 = new Libro();
        libro10.setAutore("Markus Zusak");
        libro10.setGenere("Romanzo");
        libro10.setTitolo("The Book Thief");
        libro10.setAnnoPubblicazione(2005);
        libro10.setNumPagine(552);


        Rivista rivista1 = new Rivista();
        rivista1.setPeriodicita(Periodicita.SETTIMANALE);
        rivista1.setTitolo("Focus");
        rivista1.setAnnoPubblicazione(2024);
        rivista1.setNumPagine(50);

        Rivista rivista2 = new Rivista();
        rivista2.setPeriodicita(Periodicita.MENSILE);
        rivista2.setTitolo("National Geographic");
        rivista2.setAnnoPubblicazione(2024);
        rivista2.setNumPagine(80);

        Rivista rivista3 = new Rivista();
        rivista3.setPeriodicita(Periodicita.SEMESTRALE);
        rivista3.setTitolo("Science");
        rivista3.setAnnoPubblicazione(2024);
        rivista3.setNumPagine(120);

        Rivista rivista4 = new Rivista();
        rivista4.setPeriodicita(Periodicita.SETTIMANALE);
        rivista4.setTitolo("The Economist");
        rivista4.setAnnoPubblicazione(2024);
        rivista4.setNumPagine(64);

        Rivista rivista5 = new Rivista();
        rivista5.setPeriodicita(Periodicita.MENSILE);
        rivista5.setTitolo("Time");
        rivista5.setAnnoPubblicazione(2024);
        rivista5.setNumPagine(64);

        Rivista rivista6 = new Rivista();
        rivista6.setPeriodicita(Periodicita.SEMESTRALE);
        rivista6.setTitolo("Nature");
        rivista6.setAnnoPubblicazione(2024);
        rivista6.setNumPagine(100);

        Rivista rivista7 = new Rivista();
        rivista7.setPeriodicita(Periodicita.SETTIMANALE);
        rivista7.setTitolo("New Scientist");
        rivista7.setAnnoPubblicazione(2024);
        rivista7.setNumPagine(48);

        Rivista rivista8 = new Rivista();
        rivista8.setPeriodicita(Periodicita.MENSILE);
        rivista8.setTitolo("Cosmopolitan");
        rivista8.setAnnoPubblicazione(2024);
        rivista8.setNumPagine(120);



       Rivista rivistaEsistente = (Rivista) elementoCatalogoDao.getById("031f5f18-a624-4d61-97db-b56ec91e1118");

        System.out.println("rivistaEsistente:");
        System.out.println(rivistaEsistente);

      /*  elementoCatalogoDao.save(libro1);
        elementoCatalogoDao.save(libro2);
        elementoCatalogoDao.save(libro3);
        elementoCatalogoDao.save(libro4);
        elementoCatalogoDao.save(libro5);
        elementoCatalogoDao.save(libro6);
        elementoCatalogoDao.save(libro7);
        elementoCatalogoDao.save(libro8);
        elementoCatalogoDao.save(libro9);
        elementoCatalogoDao.save(libro10);


        // Salvataggio delle riviste
        elementoCatalogoDao.save(rivista1);
        elementoCatalogoDao.save(rivista2);
        elementoCatalogoDao.save(rivista3);
        elementoCatalogoDao.save(rivista4);
        elementoCatalogoDao.save(rivista5);
        elementoCatalogoDao.save(rivista6);
        elementoCatalogoDao.save(rivista7);
        elementoCatalogoDao.save(rivista8); */





        Utente utente1 = new Utente();
        utente1.setNome("Francesco");
        utente1.setCognome("Reale");
        utente1.setDataDiNascita(LocalDate.of(1986, 4, 12));
        utente1.setNumeroDiTessera(12345);

        Utente utente2 = new Utente();
        utente2.setNome("Piero");
        utente2.setCognome("Pelu");
        utente2.setDataDiNascita(LocalDate.of(1992, 12, 3));
        utente2.setNumeroDiTessera(67891);

      /*  utenteDao.save(utente1);
        utenteDao.save(utente2); */

        Prestito prestito1 = new Prestito();
        prestito1.setUtente(utente2);
        prestito1.setElementoPrestato(libro1);
        prestito1.setDataInizioPrestito(LocalDate.of(2024, 2, 10));

       /* prestitoDao.save(prestito1); */


        prestitoDao.getPrestitiScaduti().forEach(System.out::println
        );






    }
}