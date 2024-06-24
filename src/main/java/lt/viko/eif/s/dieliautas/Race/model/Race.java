package lt.viko.eif.s.dieliautas.Race.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Atvaizduoja lenktynių objektą.
 */
@Entity
public class Race {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String location;
    private Date date;

    @OneToMany(mappedBy = "race")
    private List<RaceInfo> raceInfos; // Pridedamas laukas

    // Gauti ir nustatyti metodai

    /**
     * Gauti lenktynių ID.
     * @return lenktynių ID
     */
    public int getId() {
        return id;
    }

    /**
     * Nustatyti lenktynių ID.
     * @param id lenktynių ID
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gauti lenktynių pavadinimą.
     * @return lenktynių pavadinimas
     */
    public String getName() {
        return name;
    }

    /**
     * Nustatyti lenktynių pavadinimą.
     * @param name lenktynių pavadinimas
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gauti lenktynių vietą.
     * @return lenktynių vieta
     */
    public String getLocation() {
        return location;
    }

    /**
     * Nustatyti lenktynių vietą.
     * @param location lenktynių vieta
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * Gauti lenktynių datą.
     * @return lenktynių data
     */
    public Date getDate() {
        return date;
    }

    /**
     * Nustatyti lenktynių datą.
     * @param date lenktynių data
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * Gauti lenktynių informaciją.
     * @return lenktynių informacija
     */
    public List<RaceInfo> getRaceInfos() {
        return raceInfos;
    }

    /**
     * Nustatyti lenktynių informaciją.
     * @param raceInfos lenktynių informacija
     */
    public void setRaceInfos(List<RaceInfo> raceInfos) {
        this.raceInfos = raceInfos;
    }
}
