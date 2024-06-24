package lt.viko.eif.s.dieliautas.Race.service;

import lt.viko.eif.s.dieliautas.Race.model.RaceInfo;
import java.util.List;

/**
 * Sąsaja, apibrėžianti paslaugas, susijusias su lenktynių informacija.
 */
public interface RaceInfoService {
    /**
     * Grąžina visų lenktynių informacijų sąrašą.
     *
     * @return sąrašas su visomis lenktynių informacijos įrašais
     */
    List<RaceInfo> getAllRaceInfos();
}
