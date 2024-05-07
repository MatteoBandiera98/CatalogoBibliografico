package entities;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ElementoPrestato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // Puoi aggiungere ulteriori attributi se necessario

    public ElementoPrestato() {
        // Costruttore vuoto
    }

    public ElementoPrestato(Long id) {
        this.id = id;
    }

    // Getter e setter
}
