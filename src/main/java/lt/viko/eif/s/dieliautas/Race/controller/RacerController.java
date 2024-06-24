package lt.viko.eif.s.dieliautas.Race.controller;

import lt.viko.eif.s.dieliautas.Race.model.Race;
import lt.viko.eif.s.dieliautas.Race.service.RacerService;
import lt.viko.eif.s.dieliautas.Race.repository.RaceRepository;
import lt.viko.eif.s.dieliautas.Race.repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class RacerController {

    @Autowired
    private RacerService racerService;

    @Autowired
    private RaceRepository raceRepository;

    @Autowired
    private StatusRepository statusRepository;

    /**
     * Apdoroja GET užklausą norint parodyti pagrindinį puslapį.
     *
     * @return Pagrindinio puslapio šablono pavadinimas.
     */
    @GetMapping("/")
    public String showMainPage() {
        return "mainpage";
    }

    /**
     * Apdoroja GET užklausą norint parodyti duomenų bazės puslapį.
     *
     * @return Duomenų bazės puslapio šablono pavadinimas.
     */
    @GetMapping("/database")
    public String showDatabasePage() {
        return "database";
    }

    /**
     * Apdoroja GET užklausą norint parodyti visų lenktynių sąrašą.
     *
     * @param model Modelis, naudojamas pridėti atributus į vaizdą.
     * @return Lenktynių puslapio šablono pavadinimas.
     */
    @GetMapping("/races")
    public String showRaces(Model model) {
        List<Race> races = raceRepository.findAll();
        model.addAttribute("races", races);
        return "races";
    }

    /**
     * Apdoroja GET užklausą norint parodyti visų lenktynininkų sąrašą.
     *
     * @param model Modelis, naudojamas pridėti atributus į vaizdą.
     * @return Lenktynininkų puslapio šablono pavadinimas.
     */
    @GetMapping("/racers")
    public String showAllRacers(Model model) {
        model.addAttribute("racers", racerService.getAllRacers());
        return "racer";
    }

    /**
     * Apdoroja GET užklausą norint parodyti visų būsenų sąrašą.
     *
     * @param model Modelis, naudojamas pridėti atributus į vaizdą.
     * @return Būsenų puslapio šablono pavadinimas.
     */
    @GetMapping("/statuses")
    public String showStatuses(Model model) {
        model.addAttribute("statuses", statusRepository.findAll());
        return "statuses";
    }
}
