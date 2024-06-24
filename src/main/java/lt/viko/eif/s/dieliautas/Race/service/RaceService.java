package lt.viko.eif.s.dieliautas.Race.service;

import lt.viko.eif.s.dieliautas.Race.model.Race;
import java.util.List;

/**
 * Lenktynių paslaugų sąsaja.
 */
public interface RaceService {
    /**
     * Grąžina visų lenktynių sąrašą.
     *
     * @return sąrašas su visomis lenktynėmis
     */
    List<Race> getAllRaces();

    /**
     * Grąžina lenktynes pagal nurodytą ID.
     *
     * @param id lenktynių ID
     * @return lenktynės su nurodytu ID arba null, jei nerasta
     */
    Race getRaceById(int id); // Pridėkite šį metodą
}
