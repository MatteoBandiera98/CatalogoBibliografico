package entities;




import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Date;

@Entity
public class Prestito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Utente utente;
    @ManyToOne
    private ElementoPrestato elementoPrestato;
    private Date dataInizioPrestito;
    private Date dataRestituzionePrevista;
    private Date dataRestituzioneEffettiva;

    // Costruttore, getter e setter
}


