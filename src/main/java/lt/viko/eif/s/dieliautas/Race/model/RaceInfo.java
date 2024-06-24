package lt.viko.eif.s.dieliautas.Race.model;

import javax.persistence.*;
import java.sql.Time;

/**
 * Atvaizduoja lenktynių informacijos objektą.
 */
@Entity
@Table(name = "raceinfo")
public class RaceInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; // ID išlaikymas kaip int dėl nuoseklumo

    @Column(name = "finish_time")
    private Time finishTime;

    @Column(name = "position_number")
    private int positionNumber;

    @ManyToOne
    @JoinColumn(name = "race_id")
    private Race race;

    @ManyToOne
    @JoinColumn(name = "racer_id")
    private Racer racer;

    // Gauti ir nustatyti metodai

    /**
     * Gauti lenktynių informacijos ID.
     * @return lenktynių informacijos ID
     */
    public int getId() {
        return id;
    }

    /**
     * Nustatyti lenktynių informacijos ID.
     * @param id lenktynių informacijos ID
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gauti lenktynių objektą.
     * @return lenktynių objektas
     */
    public Race getRace() {
        return race;
    }

    /**
     * Nustatyti lenktynių objektą.
     * @param race lenktynių objektas
     */
    public void setRace(Race race) {
        this.race = race;
    }

    /**
     * Gauti lenktynininko objektą.
     * @return lenktynininko objektas
     */
    public Racer getRacer() {
        return racer;
    }

    /**
     * Nustatyti lenktynininko objektą.
     * @param racer lenktynininko objektas
     */
    public void setRacer(Racer racer) {
        this.racer = racer;
    }

    /**
     * Gauti finišo laiką.
     * @return finišo laikas
     */
    public Time getFinishTime() {
        return finishTime;
    }

    /**
     * Nustatyti finišo laiką.
     * @param finishTime finišo laikas
     */
    public void setFinishTime(Time finishTime) {
        this.finishTime = finishTime;
    }

    /**
     * Gauti pozicijos numerį.
     * @return pozicijos numeris
     */
    public int getPositionNumber() {
        return positionNumber;
    }

    /**
     * Nustatyti pozicijos numerį.
     * @param positionNumber pozicijos numeris
     */
    public void setPositionNumber(int positionNumber) {
        this.positionNumber = positionNumber;
    }
}
