package lt.viko.eif.s.dieliautas.Race.model;

import javax.persistence.*;

/**
 * Atvaizduoja lenktynininko statusą.
 */
@Entity
public class Status {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; // Pakeista į int dėl nuoseklumo

    private String statusName;

    // Gauti ir nustatyti metodai

    /**
     * Gauti statuso ID.
     * @return statuso ID
     */
    public int getId() {
        return id;
    }

    /**
     * Nustatyti statuso ID.
     * @param id statuso ID
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gauti statuso pavadinimą.
     * @return statuso pavadinimas
     */
    public String getStatusName() {
        return statusName;
    }

    /**
     * Nustatyti statuso pavadinimą.
     * @param statusName statuso pavadinimas
     */
    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }
}
