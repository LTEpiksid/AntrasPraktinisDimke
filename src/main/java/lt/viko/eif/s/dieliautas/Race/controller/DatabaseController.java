package lt.viko.eif.s.dieliautas.Race.controller;

import lt.viko.eif.s.dieliautas.Race.service.DatabaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DatabaseController {

    @Autowired
    private DatabaseService databaseService;

    /**
     * HTTP POST užklausos apdorojimas, kuris inicijuoja duomenų bazės įkrovimą.
     * @return Žinutė, informuojanti, kad duomenų bazė buvo inicijuota.
     */
    @PostMapping("/loaddatabase")
    public String loadDatabasePost() {
        databaseService.initializeDatabase();
        return "Database initialized!";
    }
}
