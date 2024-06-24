package lt.viko.eif.s.dieliautas.Race.service;

import lt.viko.eif.s.dieliautas.Race.model.RaceInfo;
import lt.viko.eif.s.dieliautas.Race.model.Racer;
import java.util.List;

/**
 * Sąsaja, apibrėžianti lenktynininkų paslaugų metodus.
 */
public interface RacerService {
    /**
     * Grąžina visų lenktynininkų sąrašą.
     *
     * @return sąrašas su visais lenktynininkais
     */
    List<Racer> getAllRacers();

    /**
     * Grąžina lenktynininką pagal nurodytą ID.
     *
     * @param id lenktynininko ID
     * @return lenktynininkas su nurodytu ID arba null, jei nerastas
     */
    Racer getRacerById(int id);

    /**
     * Grąžina lenktynininkų sąrašą pagal nurodytą statusą.
     *
     * @param status lenktynininkų statusas
     * @return sąrašas su lenktynininkais, turinčiais nurodytą statusą
     */
    List<Racer> getRacersByStatus(String status);

    /**
     * Grąžina lenktynių informacijos sąrašą su geriausiais finišo laikais.
     *
     * @return sąrašas su lenktynių informacija, kurioje yra geriausi finišo laikai
     */
    List<RaceInfo> getTopFinishTimes();
}
