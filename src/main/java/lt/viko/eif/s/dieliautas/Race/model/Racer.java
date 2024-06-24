package lt.viko.eif.s.dieliautas.Race.model;

import javax.persistence.*;
import java.util.List;

/**
 * Atvaizduoja lenktynininko objektą.
 */
@Entity
public class Racer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firstName;
    private String lastName;
    private String phoneNumber;

    @ManyToOne
    @JoinColumn(name = "status_id")
    private Status status;

    @OneToMany(mappedBy = "racer")
    private List<RaceInfo> raceInfos;

    // Gauti ir nustatyti metodai

    /**
     * Gauti lenktynininko ID.
     * @return lenktynininko ID
     */
    public int getId() {
        return id;
    }

    /**
     * Nustatyti lenktynininko ID.
     * @param id lenktynininko ID
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gauti lenktynininko vardą.
     * @return lenktynininko vardas
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Nustatyti lenktynininko vardą.
     * @param firstName lenktynininko vardas
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gauti lenktynininko pavardę.
     * @return lenktynininko pavardė
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Nustatyti lenktynininko pavardę.
     * @param lastName lenktynininko pavardė
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gauti lenktynininko telefono numerį.
     * @return lenktynininko telefono numeris
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Nustatyti lenktynininko telefono numerį.
     * @param phoneNumber lenktynininko telefono numeris
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Gauti lenktynininko statusą.
     * @return lenktynininko statusas
     */
    public Status getStatus() {
        return status;
    }

    /**
     * Nustatyti lenktynininko statusą.
     * @param status lenktynininko statusas
     */
    public void setStatus(Status status) {
        this.status = status;
    }

    /**
     * Gauti lenktynininko lenktynių informacijos sąrašą.
     * @return lenktynininko lenktynių informacijos sąrašas
     */
    public List<RaceInfo> getRaceInfos() {
        return raceInfos;
    }

    /**
     * Nustatyti lenktynininko lenktynių informacijos sąrašą.
     * @param raceInfos lenktynininko lenktynių informacijos sąrašas
     */
    public void setRaceInfos(List<RaceInfo> raceInfos) {
        this.raceInfos = raceInfos;
    }
}
