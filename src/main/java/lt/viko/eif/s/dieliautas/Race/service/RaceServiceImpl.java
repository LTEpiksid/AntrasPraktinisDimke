package lt.viko.eif.s.dieliautas.Race.service;

import lt.viko.eif.s.dieliautas.Race.model.Race;
import lt.viko.eif.s.dieliautas.Race.repository.RaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Lenktynių paslaugų įgyvendinimas.
 */
@Service
public class RaceServiceImpl implements RaceService {

    @Autowired
    private RaceRepository raceRepository;

    /**
     * Grąžina visų lenktynių sąrašą.
     *
     * @return sąrašas su visomis lenktynėmis
     */
    @Override
    public List<Race> getAllRaces() {
        return raceRepository.findAll();
    }

    /**
     * Grąžina lenktynes pagal nurodytą ID.
     *
     * @param id lenktynių ID
     * @return lenktynės su nurodytu ID arba null, jei nerasta
     */
    @Override
    public Race getRaceById(int id) {
        return raceRepository.findById(id).orElse(null); // Įgyvendina metodą
    }
}
