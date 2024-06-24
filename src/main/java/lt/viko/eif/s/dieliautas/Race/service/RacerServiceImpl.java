package lt.viko.eif.s.dieliautas.Race.service;

import lt.viko.eif.s.dieliautas.Race.model.RaceInfo;
import lt.viko.eif.s.dieliautas.Race.model.Racer;
import lt.viko.eif.s.dieliautas.Race.repository.RaceInfoRepository;
import lt.viko.eif.s.dieliautas.Race.repository.RacerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Lenktynininkų paslaugų įgyvendinimas.
 */
@Service
public class RacerServiceImpl implements RacerService {

    @Autowired
    private RacerRepository racerRepository;

    @Autowired
    private RaceInfoRepository raceInfoRepository;

    /**
     * Grąžina visų lenktynininkų sąrašą.
     *
     * @return sąrašas su visais lenktynininkais
     */
    @Override
    public List<Racer> getAllRacers() {
        return racerRepository.findAll();
    }

    /**
     * Grąžina lenktynininką pagal nurodytą ID.
     *
     * @param id lenktynininko ID
     * @return lenktynininkas su nurodytu ID arba null, jei nerastas
     */
    @Override
    public Racer getRacerById(int id) {
        return racerRepository.findById(id).orElse(null);
    }

    /**
     * Grąžina lenktynininkų sąrašą pagal nurodytą statusą.
     *
     * @param status lenktynininkų statusas
     * @return sąrašas su lenktynininkais, turinčiais nurodytą statusą
     */
    @Override
    public List<Racer> getRacersByStatus(String status) {
        return racerRepository.findByStatusStatusName(status);
    }

    /**
     * Grąžina lenktynių informacijos sąrašą su geriausiais finišo laikais.
     *
     * @return sąrašas su lenktynių informacija, kurioje yra geriausi finišo laikai
     */
    @Override
    public List<RaceInfo> getTopFinishTimes() {
        return raceInfoRepository.findAll().stream()
                .sorted((r1, r2) -> r1.getFinishTime().compareTo(r2.getFinishTime()))
                .limit(10)
                .collect(Collectors.toList());
    }
}
