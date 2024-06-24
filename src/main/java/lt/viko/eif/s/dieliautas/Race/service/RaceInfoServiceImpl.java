package lt.viko.eif.s.dieliautas.Race.service;

import lt.viko.eif.s.dieliautas.Race.model.RaceInfo;
import lt.viko.eif.s.dieliautas.Race.repository.RaceInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Paslaugos klasė, atsakinga už lenktynių informacijos valdymą.
 */
@Service
public class RaceInfoServiceImpl implements RaceInfoService {

    @Autowired
    private RaceInfoRepository raceInfoRepository;

    /**
     * Grąžina visų lenktynių informacijų sąrašą.
     *
     * @return sąrašas su visomis lenktynių informacijos įrašais
     */
    @Override
    public List<RaceInfo> getAllRaceInfos() {
        return raceInfoRepository.findAll();
    }
}
