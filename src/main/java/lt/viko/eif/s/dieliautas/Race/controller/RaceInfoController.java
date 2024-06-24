package lt.viko.eif.s.dieliautas.Race.controller;

import lt.viko.eif.s.dieliautas.Race.model.RaceInfo;
import lt.viko.eif.s.dieliautas.Race.service.RaceInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class RaceInfoController {

    @Autowired
    private RaceInfoService raceInfoService;

    /**
     * Apdoroja GET užklausą norint parodyti visą lenktynių informaciją.
     *
     * @param model Modelis, naudojamas pridėti atributus į vaizdą.
     * @return Lenktynių informacijos puslapio šablono pavadinimas.
     */
    @GetMapping("/raceinfos")
    public String showRaceInfos(Model model) {
        List<RaceInfo> raceInfos = raceInfoService.getAllRaceInfos();
        model.addAttribute("raceinfos", raceInfos);
        return "raceinfo";
    }
}
